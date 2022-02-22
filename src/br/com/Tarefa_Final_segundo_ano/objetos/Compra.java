package br.com.Tarefa_Final_segundo_ano.objetos;

public class Compra {

	int idCompra;
	int qtdComprada;
	int idProduto;
	int idFuncionario;
	String dia;

	public Compra(int id, int qtd, int produto, int funcionario, String data) {
		this.setIdCompra(id);
		this.setQtdComprada(qtd);
		this.setIdProduto(produto);
		this.setIdFuncionario(funcionario);
		this.setDia(data);
	}

	@Override
	public String toString() {
		return "Compra " + idCompra + ": Qtd comprada = " + qtdComprada + ", produto =  " + idProduto
				+ ", funcionário responsável = " + idFuncionario + ", dia = " + dia + ";";
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public int getQtdComprada() {
		return qtdComprada;
	}

	public void setQtdComprada(int qtdComprada) {
		this.qtdComprada = qtdComprada;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

}
