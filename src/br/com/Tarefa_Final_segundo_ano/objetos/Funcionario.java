package br.com.Tarefa_Final_segundo_ano.objetos;

public class Funcionario {

	String nomeFuncionario;
	String dataNascimento;
	String funcao;
	String senha;
	long cpfFuncionario;

	public Funcionario(String nome, String funcao, String senha) {
		this.setNomeFuncionario(nome);
		this.setSenha(senha);
		this.setFuncao(funcao);
	}

	public Funcionario(long cpf, String senha) {
		this.setCpfFuncionario(cpf);
		this.setSenha(senha);
	}

	@Override
	public String toString() {
		return "Funcionario: " + nomeFuncionario + "\n Função: " + funcao + "";
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public long getCpfFuncionario() {
		return cpfFuncionario;
	}

	public void setCpfFuncionario(long cpfFuncionario) {
		this.cpfFuncionario = cpfFuncionario;
	}

}
