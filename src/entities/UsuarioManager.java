package entities;

import java.util.ArrayList;
import java.util.List;

public class UsuarioManager {
    
    private List<Usuario> usuarios = new ArrayList<>();
    
    public boolean registrarUsuario(String name, String mail, String password) {

        for (Usuario u : usuarios) {
            if (u.mail.equalsIgnoreCase(mail)) {
                return false; // Email já registrado
            }
        }
        Usuario novoUsuario = new Usuario(name, mail, password);
        usuarios.add(novoUsuario);
        return true;
    }
    
    public Usuario login(String mail, String password) {
        for (Usuario u : usuarios) {
            if (u.mail.equalsIgnoreCase(mail) && u.verificarSenha(password)) {
                return u; // Login bem-sucedido
            }
        }
        return null; // Falha no login
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
