function registrarUsuario() {
    // Lógica para registrar usuário
    alert("Registro de usuário não implementado.");
}

function login() {
    document.getElementById('menu-principal').style.display = 'none';
    document.getElementById('login-form').style.display = 'block';
}

function realizarLogin() {
    const email = document.getElementById('email').value;
    const senha = document.getElementById('senha').value;
    // Aqui você deve validar o login com o backend Java
    if (email === 'user1@example.com' && senha === 'password') {
        alert("Login bem-sucedido!");
        document.getElementById('login-form').style.display = 'none';
        document.getElementById('user-menu').style.display = 'block';
        return false;
    } else {
        alert("Email ou senha incorretos.");
        return false;
    }
}

function exibirRanking() {
    document.getElementById('ranking-lista').style.display = 'block';
    document.getElementById('menu-principal').style.display = 'none';
    const ranking = document.getElementById('ranking');
    ranking.innerHTML = "<li>Usuário 1 - 100 pontos</li><li>Usuário 2 - 80 pontos</li>";
}

function listarLivros() {
    document.getElementById('catalogo-livros').style.display = 'block';
    document.getElementById('user-menu').style.display = 'none';
    const livrosLista = document.getElementById('livros-lista');
    livrosLista.innerHTML = `
        <li>Duna - Frank Herbert</li>
        <li>Neuromancer - William Gibson</li>
        <li>O Senhor dos Anéis - J.R.R. Tolkien</li>
    `;
}

function marcarLivroComoLido() {
    alert("Função para marcar livro como lido não implementada.");
}

function verInformacoes() {
    alert("Informações do usuário não implementadas.");
}

function verRanking() {
    exibirRanking();
}

function logout() {
    alert("Logout realizado.");
    document.getElementById('user-menu').style.display = 'none';
    document.getElementById('menu-principal').style.display = 'block';
}

function sair() {
    alert("Até mais!");
    window.location.reload();
}
