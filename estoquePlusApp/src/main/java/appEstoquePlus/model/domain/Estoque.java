package appEstoquePlus.model.domain;

import java.util.List;

public class Estoque {
	
	private String nome;
	private String local;
	private String filial;
	private Funcionario funcionario;
	private List<itens> itensColecao;
	
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<itens> getItensColecao() {
		return itensColecao;
	}

	public void setItensColecao(List<itens> itensColecao) {
		this.itensColecao = itensColecao;
	}

	@Override
	public String toString() {
		return "Estoque" + nome	;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getFilial() {
		return filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
	}
}
