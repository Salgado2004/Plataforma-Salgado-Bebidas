package br.com.Tarefa_Final_segundo_ano.objetos;

public class Produto {

	int idProduto;
	String nomeProduto;
	String marcaProduto;
	String tipoProduto;
	float precoCompra;
	float precoVenda;
	int qtdDisp;

	public Produto(int id, String nome, String marca, String tipo, float pc, float pv, int qtd) {
		this.setIdProduto(id);
		this.setNomeProduto(nome);
		this.setMarcaProduto(marca);
		this.setTipoProduto(tipo);
		this.setPrecoCompra(pc);
		this.setPrecoVenda(pv);
		this.setQtdDisp(qtd);
	}

	public Produto(int id, String nome, String tipo, int qtd) {
		this.setIdProduto(id);
		this.setNomeProduto(nome);
		this.setTipoProduto(tipo);
		this.setQtdDisp(qtd);
	}

	public Produto(int id) {
		this.setIdProduto(id);
	}

	@Override
	public String toString() {
		return "Produto " + idProduto + ": " + nomeProduto + ", " + tipoProduto + ", " + qtdDisp + " disponíveis";
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getMarcaProduto() {
		return marcaProduto;
	}

	public void setMarcaProduto(String marcaProduto) {
		this.marcaProduto = marcaProduto;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public float getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(float precoCompra) {
		this.precoCompra = precoCompra;
	}

	public float getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(float precoVenda) {
		this.precoVenda = precoVenda;
	}

	public int getQtdDisp() {
		return qtdDisp;
	}

	public void setQtdDisp(int qtdDisp) {
		this.qtdDisp = qtdDisp;
	}

}
