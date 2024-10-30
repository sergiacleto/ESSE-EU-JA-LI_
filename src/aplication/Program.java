package application;

import entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    private static UsuarioManager usuarioManager = new UsuarioManager();
    private static List<Livro> catalogoLivros = new ArrayList<>();
    private static Ranking ranking;
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {

        inicializarCatalogo();
        
        ranking = new Ranking(usuarioManager.getUsuarios());
        
        boolean sair = false;
        while (!sair) {
            exibirMenuPrincipal();
            int escolha = lerInteiro("Escolha uma opção: ");
            switch (escolha) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    Usuario usuarioLogado = realizarLogin();
                    if (usuarioLogado != null) {
                        menuUsuario(usuarioLogado);
                    }
                    break;
                case 3:
                    ranking.exibirRanking();
                    break;
                case 4:
                    sair = true;
                    System.out.println("Encerrando o sistema. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    
    private static void inicializarCatalogo() {
        catalogoLivros.add(new Livro("Duna", "Frank Herbert", 412, "Ficção Científica"));
        catalogoLivros.add(new Livro("Duna II", "Frank Herbert", 272, "Ficção Científica"));
        catalogoLivros.add(new Livro("Duna III", "Frank Herbert", 528, "Ficção Científica"));
        catalogoLivros.add(new Livro("Neuromancer", "William Gibson", 271, "Ficção Científica"));
        catalogoLivros.add(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1178, "Fantasia"));
        catalogoLivros.add(new Livro("Foundation", "Isaac Asimov", 255, "Ficção Científica"));
        catalogoLivros.add(new Livro("O Hobbit", "J.R.R. Tolkien", 310, "Fantasia"));
        catalogoLivros.add(new Livro("1984", "George Orwell", 328, "Distopia"));
        catalogoLivros.add(new Livro("A Guerra dos Tronos", "George R.R. Martin", 694, "Fantasia"));
        catalogoLivros.add(new Livro("Fahrenheit 451", "Ray Bradbury", 194, "Distopia"));
        catalogoLivros.add(new Livro("Brave New World", "Aldous Huxley", 311, "Distopia"));
        catalogoLivros.add(new Livro("O Código Da Vinci", "Dan Brown", 689, "Thriller"));
    }
    
    private static void exibirMenuPrincipal() {
        System.out.println("\n===== Esse eu já li! =====");
        System.out.println("1. Registrar-se");
        System.out.println("2. Login");
        System.out.println("3. Ver Ranking");
        System.out.println("4. Sair");
    }
    
    private static void registrarUsuario() {
        System.out.println("\n===== Registro de Usuário =====");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        
        boolean sucesso = usuarioManager.registrarUsuario(nome, email, senha);
        if (sucesso) {
            System.out.println("Registro realizado com sucesso!");
        } else {
            System.out.println("Email já está registrado. Tente novamente com outro email.");
        }
    }
    
    private static Usuario realizarLogin() {
        System.out.println("\n===== Login =====");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        
        Usuario usuario = usuarioManager.login(email, senha);
        if (usuario != null) {
            System.out.println("Login bem-sucedido! Bem-vindo, " + usuario.name + "!");
            return usuario;
        } else {
            System.out.println("Email ou senha incorretos. Tente novamente.");
            return null;
        }
    }
    
    private static void menuUsuario(Usuario usuario) {
        boolean voltar = false;
        while (!voltar) {
            exibirMenuUsuario();
            int escolha = lerInteiro("Escolha uma opção: ");
            switch (escolha) {
                case 1:
                    listarLivros();
                    break;
                case 2:
                    marcarLivroComoLido(usuario);
                    break;
                case 3:
                    usuario.exibirInformacoes();
                    break;
                case 4:
                    ranking.exibirRanking();
                    break;
                case 5:
                    voltar = true;
                    System.out.println("Voltando ao menu principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    
    private static void exibirMenuUsuario() {
        System.out.println("\n===== Menu do Usuário =====");
        System.out.println("1. Listar Livros Disponíveis");
        System.out.println("2. Marcar Livro como Lido");
        System.out.println("3. Ver Suas Informações");
        System.out.println("4. Ver Ranking");
        System.out.println("5. Logout");
    }
    
    private static void listarLivros() {
        System.out.println("\n===== Catálogo de Livros =====");
        for (int i = 0; i < catalogoLivros.size(); i++) {
            Livro livro = catalogoLivros.get(i);
            System.out.println((i + 1) + ". " + livro.getDetalhes());
        }
    }
    
    private static void marcarLivroComoLido(Usuario usuario) {
        listarLivros();
        int escolha = lerInteiro("Digite o número do livro que você leu (0 para cancelar): ");
        if (escolha == 0) {
            System.out.println("Operação cancelada.");
            return;
        }
        if (escolha < 1 || escolha > catalogoLivros.size()) {
            System.out.println("Número de livro inválido.");
            return;
        }
        Livro livroSelecionado = catalogoLivros.get(escolha - 1);
        usuario.marcarLivroComoLido(livroSelecionado);
        
        ranking = new Ranking(usuarioManager.getUsuarios());
    }
    
    private static int lerInteiro(String mensagem) {
        int numero;
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine();
            try {
                numero = Integer.parseInt(entrada);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
            }
        }
        return numero;
    }
}

