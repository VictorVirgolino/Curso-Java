package sef.module3.sample.aula5_31_07_2024;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    //Adiciona um livro a DATABASE
    public Livro createLivro(String titulo, String autor, int anoPublicacao) throws SQLException {
        String insertLivro = "INSERT INTO livros (titulo, autor, ano_publicacao) VALUES (?, ?, ?)";
        Livro livro = null;

        try(
                Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(insertLivro, Statement.RETURN_GENERATED_KEYS)
                ){
            stmt.setString(1, titulo);
            stmt.setString(2, autor);
            stmt.setInt(3, anoPublicacao);

            stmt.executeUpdate();

            //Se o livro foi adicionado corretamente no banco criar um objeto de retorno
            try(ResultSet keys = stmt.getGeneratedKeys()){
                if(keys.next()){
                    int id = keys.getInt(1);
                    livro = new Livro(id, titulo, autor, anoPublicacao);
                }
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return livro;
    }
    //Retorna de um livro passando o id
    public Livro getLivro(int id) throws SQLException{
        String selectLivro = "SELECT * FROM livros WHERE id = ?";
        Livro livro = null;

        try(
                Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(selectLivro)
        ){
            stmt.setInt(1,id);

            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    String titulo =  rs.getString("titulo");
                    String autor = rs.getString("autor");
                    int anoPublicacao = rs.getInt("ano_publicacao");

                    livro = new Livro(id, titulo, autor, anoPublicacao);
                }
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return livro;
    }

    //Retorna todos os livros
    public List<Livro> getLivros() throws SQLException{
        String selectAllLivros = "SELECT * FROM livros";
        List<Livro> livros = new ArrayList<>();

        try(
                Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(selectAllLivros);
                ResultSet rs = stmt.executeQuery()
                ){
            while(rs.next()){
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int anoPublicacao = rs.getInt("ano_publicacao");
                livros.add(new Livro(id,titulo, autor, anoPublicacao));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return livros;
    }

    //Atualiza as informações de um livro passando o id retorna o Livro atualizado
    public Livro updateLivro(int id, String titulo, String autor, int anoPublicacao) throws SQLException{
        String updateLivro = "UPDATE livros SET titulo = ?, autor = ?, ano_publicacao = ? WHERE id = ?";
        Livro livro = null;

            try(
                    Connection conn = Conexao.getConnection();
                    PreparedStatement stmt = conn.prepareStatement(updateLivro)
                    ){
                stmt.setString(1, titulo);
                stmt.setString(2, autor);
                stmt.setInt(3, anoPublicacao);
                stmt.setInt(4, id);

                int rowsUpdated = stmt.executeUpdate();
                if (rowsUpdated > 0){
                    livro = new Livro(id, titulo, autor, anoPublicacao);
                }

            }catch(SQLException e){
                System.out.println(e.getMessage());
            }

        return livro;
    }

    //Deleta um livro passando o id e retorna o objeto deletado
    public Livro deleteLivro(int id) throws SQLException{
        String deleteLivro = "DELETE FROM livros WHERE id = ?";
        Livro livro = null;
        Livro oldLivro;

        try(
                Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(deleteLivro)
                ){

            //Verificar se o livro existe
            oldLivro = this.getLivro(id);

            //se o livro existir
            if(oldLivro != null){
               stmt.setInt(1, id);
               int rowsDeleted = stmt.executeUpdate();

               if(rowsDeleted > 0){
                    livro = oldLivro;
               }
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return livro;
    }
}
