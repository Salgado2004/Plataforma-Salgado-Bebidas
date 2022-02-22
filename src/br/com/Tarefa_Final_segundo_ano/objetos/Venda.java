package br.com.Tarefa_Final_segundo_ano.objetos;

public class Venda {

	int idVenda;
	int qtdVendida;
	int idProduto;
	int idFuncionario;
	String dia;
	float lucro;

	public Venda(int id, int qtd, int produto, int funcionario, String dia, float lucro) {
		this.setIdVenda(id);
		this.setQtdVendida(qtd);
		this.setIdProduto(produto);
		this.setIdFuncionario(funcionario);
		this.setDia(dia);
		this.setLucro(lucro);
	}

	@Override
	public String toString() {
		return "Venda " + idVenda + ": Qtd vendida = " + qtdVendida + ", Produto = " + idProduto
				+ ", funcionário responsável = " + idFuncionario + ", dia = " + dia + ", lucro = R$" + lucro + ";";
	}

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public int getQtdVendida() {
		return qtdVendida;
	}

	public void setQtdVendida(int qtdVendida) {
		this.qtdVendida = qtdVendida;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public float getLucro() {
		return lucro;
	}

	public void setLucro(float lucro) {
		this.lucro = lucro;
	}

}
