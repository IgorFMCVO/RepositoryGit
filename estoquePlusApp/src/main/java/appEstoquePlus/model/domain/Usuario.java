package appEstoquePlus.model.domain;

public class Usuario {
	
	private String nome;
	private String email;
	private int idade;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	// Ao usar ja temos um nome
	public Usuario() {
		this.setNome("Exemplo de nome");
	}
	
// cria um objeto do tipo Usuario com o nome
	public Usuario(String nome) {
		this.setNome(nome);
	}

	@Override
	public String toString() {
		return "A inclusão do usuário " + nome + " foi realizada com sucesso!";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}

	
	
	
	


