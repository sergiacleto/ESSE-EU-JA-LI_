package entities;

public class Livro {

    public String titulo;
    public String autor;
    public int numeroDePaginas;
    public String estilo;
    
    public Livro(String titulo, String autor, int numeroDePaginas, String estilo) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroDePaginas = numeroDePaginas;
        this.estilo = estilo;
    }
    
    public String getDetalhes() {
        return "Título: " + titulo + ", Autor: " + autor + ", Páginas: " + numeroDePaginas + ", Estilo: " + estilo;
    }
    
    public int calcularPontos() {
        return 1 + (numeroDePaginas / 100);
    }


    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Livro livro = (Livro) obj;
        return titulo.equalsIgnoreCase(livro.titulo) && autor.equalsIgnoreCase(livro.autor);
    }


    public int hashCode() {
        return titulo.toLowerCase().hashCode() + autor.toLowerCase().hashCode();
    }
}
