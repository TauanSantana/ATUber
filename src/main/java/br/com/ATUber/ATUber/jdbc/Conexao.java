package br.com.ATUber.ATUber.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static Connection conn = null;

    public static Connection obterConexao(){

        if (conn == null){
            String url ="jdbc:mysql://localhost:3306/dbInfnet";
            String usuario = "root";
            String senha = "@LoginMaria";

            try {
               // DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                conn = DriverManager.getConnection(url, usuario, senha);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return conn;
    }
}
