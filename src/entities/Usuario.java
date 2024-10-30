package entities;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    
    public String name;
    public String mail;
    public String password;
    public int points;
    public List<Livro> livrosLidos = new ArrayList<>();
    public List<Trofeu> trofeus = new ArrayList<>();
    
    public Usuario(String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.points = 0;
    }
    
    public void marcarLivroComoLido(Livro livro) {
    	
        if (livrosLidos.contains(livro)) {
            System.out.println("Você já marcou este livro como lido.");
            return;
        }
        
        livrosLidos.add(livro);
        
        int pontosGanhos = calcularPontos(livro);
        points += pontosGanhos;
        System.out.println("Você ganhou " + pontosGanhos + " pontos.");
        
        verificarTrofeus(livro);
    }
    
    public int calcularPontos(Livro livro) {
        return 1 + (livro.numeroDePaginas / 100);
    }
    
    private void verificarTrofeus(Livro livro) {

        long count = livrosLidos.stream()
                .filter(l -> l.estilo.equalsIgnoreCase(livro.estilo))
                .count();
        
        if (count == 5) {
            Trofeu trofeu = new Trofeu("Leitor de " + livro.estilo, livro.estilo);
            adicionarTrofeu(trofeu);
            System.out.println("Parabéns! Você ganhou o troféu: " + trofeu.nome);
        }
    }
    
    public void adicionarTrofeu(Trofeu trofeu) {
        trofeus.add(trofeu);
    }
    
    public void exibirInformacoes() {
        System.out.println("===== Informações do Usuário =====");
        System.out.println("Nome: " + name);
        System.out.println("Email: " + mail);
        System.out.println("Pontos: " + points);
        System.out.println("Troféus Conquistados:");
        if (trofeus.isEmpty()) {
            System.out.println("Nenhum troféu conquistado ainda.");
        } else {
            for (Trofeu trofeu : trofeus) {
                System.out.println("- " + trofeu.nome);
            }
        }
        System.out.println("Livros Lidos:");
        if (livrosLidos.isEmpty()) {
            System.out.println("Nenhum livro marcado como lido ainda.");
        } else {
            for (Livro livro : livrosLidos) {
                System.out.println("- " + livro.titulo + " (" + livro.estilo + ")");
            }
        }
        System.out.println("==================================");
    }
    
    public boolean verificarSenha(String senha) {
        return this.password.equals(senha);
    }
}
