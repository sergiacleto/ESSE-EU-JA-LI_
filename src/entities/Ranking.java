package entities;

import java.util.List;
import java.util.stream.Collectors;

public class Ranking {

    public List<Usuario> usuarios;
    
    public Ranking(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public List<Usuario> gerarRanking() {
        return usuarios.stream()
                .sorted((u1, u2) -> Integer.compare(u2.points, u1.points))
                .limit(10)
                .collect(Collectors.toList());
    }
    
    public void exibirRanking() {
        List<Usuario> topUsuarios = gerarRanking();
        System.out.println("\n===== Ranking dos 10 Melhores Usuários =====");
        if (topUsuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado ainda.");
            return;
        }
        for (int i = 0; i < topUsuarios.size(); i++) {
            Usuario usuario = topUsuarios.get(i);
            System.out.println((i + 1) + ". " + usuario.name + " - " + usuario.points + " pontos");
        }
        System.out.println("===========================================");
    }
}
