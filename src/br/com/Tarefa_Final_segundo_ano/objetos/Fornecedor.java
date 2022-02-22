package br.com.Tarefa_Final_segundo_ano.objetos;

public class Fornecedor {

	String nomeFornecedor;
	int numeroFornecedor;
	int cnpfFornecedor;

	public Fornecedor(String nome, int numero, int cnpj) {
		this.setNomeFornecedor(nome);
		this.setNumeroFornecedor(numero);
		this.setCnpfFornecedor(cnpj);
	}

	@Override
	public String toString() {
		return "Fornecedor: " + nomeFornecedor + ", Número: " + numeroFornecedor + ", CNJP: " + cnpfFornecedor + "";
	}

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	public int getNumeroFornecedor() {
		return numeroFornecedor;
	}

	public void setNumeroFornecedor(int numeroFornecedor) {
		this.numeroFornecedor = numeroFornecedor;
	}

	public int getCnpfFornecedor() {
		return cnpfFornecedor;
	}

	public void setCnpfFornecedor(int cnpfFornecedor) {
		this.cnpfFornecedor = cnpfFornecedor;
	}

}
