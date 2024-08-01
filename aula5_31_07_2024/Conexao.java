package sef.module3.sample.aula5_31_07_2024;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USER = "root";
    private static final String PASSWORD = "biblio";

    public static Connection getConnection() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
