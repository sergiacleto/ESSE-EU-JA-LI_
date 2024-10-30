package entities;

public class Trofeu {

	public String nome;
	public String estilo;
	
	public Trofeu(String nome, String estilo) {
		this.nome = nome;
		this.estilo = estilo;
	}
	
	public void concederTrofeu(Usuario usuario) {
		usuario.adicionarTrofeu(this);
	}
}
