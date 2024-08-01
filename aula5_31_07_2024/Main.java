import sef.module3.sample.aula5_31_07_2024.Conexao;
import sef.module3.sample.aula5_31_07_2024.Livro;
import sef.module3.sample.aula5_31_07_2024.LivroDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
/*
                   Classes - Atividade  JDBC
                    Aluno: Victor Arruda Câmara Virgolino
                                  Questão:

		Criar um banco biblioteca com a tabela livros, e criar e testar um CRUD
 */
public static void main(String[] args) {
    try{

        //Cria instância do Livro DAO
        LivroDAO livroDAO = new LivroDAO();

        //criar livros
        Livro livro1 = livroDAO.createLivro(
                "O Alquimista",
                "Paulo Coelho",
                1988);
        System.out.println("Livro adicionado: " + livro1);

        Livro livro2 = livroDAO.createLivro(
                "1984",
                "George Orwell",
                1949);
        System.out.println("Livro adicionado: " + livro2);

        //get livro by id
        Livro livroObtido = livroDAO.getLivro(livro1.getId());
        System.out.println("Livro obtido: " + livroObtido);

        //atualizar livro by id
        Livro livroAtualizado = livroDAO.updateLivro(
                livro2.getId(),
                "1985",
                "Lucas Orwell",
                1955);
        System.out.println("Livro atualizado: " + livroAtualizado);

        //get all livros
        List<Livro> todosLivros = livroDAO.getLivros();
        System.out.println("Todos os livros:");
        for (Livro livro : todosLivros) {
            System.out.println(livro);
        }

        //deletar livro by id
        Livro livroDeletado = livroDAO.deleteLivro(livro1.getId());
        System.out.println("Livro deletado: " + livroDeletado);

        todosLivros = livroDAO.getLivros();
        System.out.println("Todos os livros após deletar:");
        for (Livro livro : todosLivros) {
            System.out.println(livro);
        }

    }catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}
