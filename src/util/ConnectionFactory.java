package util;

import java.sql.*;

public class ConnectionFactory {
    public static  final  String PATH = "jdbc:postgresql://localhost:5432/banco";
    public static  final  String USER = "POSTGRES";
    public static final String PASSWORD = "postgres";

    //metodo que retorna a conexão estabelecida
    public static Connection getConnection() throws Exception{
        try {
            //carregar o driver do postgresql
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(PATH, USER, PASSWORD);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    // criar os métodos para fechar a conexão
    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws Exception {
        close(conn,stmt,rs);
    }
    public static void closeConnection(Connection conn, Statement stmt) throws Exception {
        close(conn,stmt,null);
    }

    public static void closeConnection (Connection conn) throws Exception {
        close(conn,null,null);
    }

    private static void close(Connection conn,Statement stmt, ResultSet rs) throws Exception{
        try {
            if (rs != null){
                rs.close();
            }
            if (stmt !=null){
                stmt.close();
            }
            if (conn != null){
                conn.close();
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
