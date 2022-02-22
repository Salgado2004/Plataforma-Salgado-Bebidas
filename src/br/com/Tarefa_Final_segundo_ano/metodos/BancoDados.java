package br.com.Tarefa_Final_segundo_ano.metodos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JOptionPane;

import br.com.Tarefa_Final_segundo_ano.objetos.Compra;
import br.com.Tarefa_Final_segundo_ano.objetos.Produto;
import br.com.Tarefa_Final_segundo_ano.objetos.Venda;

public class BancoDados {

	String nome;
	String funcao;
	float pVenda;
	float pCompra;
	float lucro;
	String marca;
	String tipo;
	String fornecedor;
	int retorno;
	int qtd;
	String dia;

	public void insereDados(Connection con, String tabela, String sql_data) {
		PreparedStatement ps;
		try {
			String sql = "INSERT INTO " + tabela + " VALUES " + sql_data;
			ps = con.prepareStatement(sql);
			int retorno = ps.executeUpdate();
			this.setRetorno(retorno);
			if (retorno > 0) {
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
			} else {
				JOptionPane.showMessageDialog(null, "Houve um problema! Cadastro não realizado");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void infoProduto(Connection con, int id) {
		PreparedStatement ps;
		try {
			String sql = "SELECT * FROM produto join fornecedor WHERE idProduto = '" + id
					+ "' AND produto.idFornecedor = fornecedor.idFornecedor;";
			ps = con.prepareStatement(sql);
			ResultSet retorno = ps.executeQuery();
			if (retorno != null && retorno.next()) {
				this.setNome(retorno.getString("nomeProduto"));
				this.setMarca(retorno.getString("marcaProduto"));
				this.setTipo(retorno.getString("tipoProduto"));
				this.setFornecedor(retorno.getString("nomeFornecedor"));
				this.setpCompra(retorno.getFloat("precoCompra"));
				this.setpVenda(retorno.getFloat("precoVenda"));
				this.setQtd(retorno.getInt("qtdProduto"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void defineLucro(Connection con, String id) {
		PreparedStatement ps;
		try {
			String sql = "SELECT precoVenda, precoCompra FROM produto WHERE idProduto = '" + id + "';";
			ps = con.prepareStatement(sql);
			ResultSet retorno = ps.executeQuery();
			if (retorno != null && retorno.next()) {
				this.setLucro(retorno.getFloat("precoVenda") - retorno.getFloat("precoCompra"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizavendaEstoque(Connection con, int quantidade, String id) {
		PreparedStatement ps;
		try {
			String sql = "SELECT * " + "FROM produto WHERE idProduto = '" + id + "';";
			ps = con.prepareStatement(sql);
			ResultSet retorno = ps.executeQuery();
			if (retorno != null && retorno.next()) {
				this.setQtd(retorno.getInt("qtdProduto"));
				this.setQtd(this.getQtd() - quantidade);
				sql = "UPDATE produto SET qtdProduto = '" + this.getQtd() + "' WHERE idProduto = '" + id + "';";
				ps = con.prepareStatement(sql);
				int retorno2 = ps.executeUpdate();
				if (retorno2 > 0) {
					JOptionPane.showMessageDialog(null, "Estoque atualizado com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Houve um problema! Estoque não atualizado");
				}
			}
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		} catch (java.lang.NullPointerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Oops! Algo deu errado");
		}
	}

	public void atualizacompraEstoque(Connection con, int quantidade, String id) {
		PreparedStatement ps;
		try {
			String sql = "SELECT * " + "FROM produto WHERE idProduto = '" + id + "';";
			ps = con.prepareStatement(sql);
			ResultSet retorno = ps.executeQuery();
			if (retorno != null && retorno.next()) {
				this.setQtd(retorno.getInt("qtdProduto"));
				this.setQtd(this.getQtd() + quantidade);
				sql = "UPDATE produto SET qtdProduto = '" + this.getQtd() + "' WHERE idProduto = '" + id + "';";
				ps = con.prepareStatement(sql);
				int retorno2 = ps.executeUpdate();
				if (retorno2 > 0) {
					JOptionPane.showMessageDialog(null, "Estoque atualizado com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Houve um problema! Estoque não atualizado");
				}
			}
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		} catch (java.lang.NullPointerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Oops! Algo deu errado");
		}
	}

	public void funcionarioLogin(Connection con, String where, long cpf, String senha) {
		PreparedStatement ps;
		try {
			String sql = "SELECT * " + "FROM funcionario WHERE " + where + ";";
			ps = con.prepareStatement(sql);
			ResultSet retorno = ps.executeQuery();
			if (retorno != null && retorno.next()) {
				if (retorno.getString("senhaFuncionario").equals(senha)) {
					this.setNome(retorno.getString("nomeFuncionario"));
					this.setFuncao(retorno.getString("funcao"));
				} else
					JOptionPane.showMessageDialog(null, "Senha incorreta!");
			}
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Email ou senha errados");
		} catch (java.lang.NullPointerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Email ou senha errados");
		}
	}

	public ArrayList<Produto> Estoque(Connection con, String tabela) {
		PreparedStatement ps;
		ArrayList<Produto> estoque = new ArrayList<Produto>();
		try {
			String sql = "SELECT * FROM " + tabela;
			ps = con.prepareStatement(sql);
			ResultSet retorno = ps.executeQuery();
			while (retorno.next()) {
				estoque.add(new Produto(retorno.getInt("idProduto"), retorno.getString("nomeProduto"),
						retorno.getString("tipoProduto"), retorno.getInt("qtdProduto")));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return estoque;
	}

	public ArrayList<Venda> vendas(Connection con, String tabela) {
		PreparedStatement ps;
		ArrayList<Venda> listVendas = new ArrayList<Venda>();
		try {
			String sql = "SELECT * FROM " + tabela;
			ps = con.prepareStatement(sql);
			ResultSet retorno = ps.executeQuery();
			while (retorno.next()) {
				listVendas.add(new Venda(retorno.getInt("idVenda"), retorno.getInt("quantidade"),
						retorno.getInt("idProduto"), retorno.getInt("idFuncionario"), retorno.getString("diaVenda"),
						retorno.getFloat("lucro")));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return listVendas;
	}

	public ArrayList<Compra> compras(Connection con, String tabela) {
		PreparedStatement ps;
		ArrayList<Compra> listCompras = new ArrayList<Compra>();
		try {
			String sql = "SELECT * FROM " + tabela;
			ps = con.prepareStatement(sql);
			ResultSet retorno = ps.executeQuery();
			while (retorno.next()) {
				listCompras.add(new Compra(retorno.getInt("idCompra"), retorno.getInt("quantidade"),
						retorno.getInt("idProduto"), retorno.getInt("idFuncionario"), retorno.getString("diaCompra")));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return listCompras;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public float getpVenda() {
		return pVenda;
	}

	public void setpVenda(float pVenda) {
		this.pVenda = pVenda;
	}

	public float getpCompra() {
		return pCompra;
	}

	public void setpCompra(float pCompra) {
		this.pCompra = pCompra;
	}

	public int getRetorno() {
		return retorno;
	}

	public void setRetorno(int retorno) {
		this.retorno = retorno;
	}

	public float getLucro() {
		return lucro;
	}

	public void setLucro(float lucro) {
		this.lucro = lucro;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

}
