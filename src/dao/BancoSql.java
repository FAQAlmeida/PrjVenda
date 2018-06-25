package dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ManutencaoEtec
 */
public class BancoSql {

    //Acesso direto usando driver JDBC class4 do SQL Server
    private static final String servidor = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String urlBanco = "jdbc:sqlserver://172.168.255.252;";
    //jdbc:sqlserver://desktop-fqa\\fqasqlserver:1433;databaseName=db_05579_1_C_1_2017
    private static final String nomeBanco = "databaseName=db_05118_1_C_1_2017;";
    private static final String usuario = "user=05118_1_C_1_2017;";
    private static final String senha = "password=Smile@435BMI";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(servidor);
        //Carrega o driver (classes de conexão) especificas do DB na virtual machine do Java
        //Sem as classes o java não conecta no DB
        //cada DB tem o seu próprio driver
        //Ex.: MySQL: Class.forName("com.mysql.jdbc.Driver");

        //Adiciona o driver do SqlServer (no site tem) e pressiona Ok,
        //ou sqljdbc.jar do SqlServer
        
        //Criando uma conexão com o DB MySQL
        //return DriverManager.getConnection("jdbc:mysql://localhost/employee", "root", "");
        //return DriverManager.getConnection(urlBanco + nomeBanco + usuario + senha);
        return DriverManager.getConnection(urlBanco + nomeBanco + usuario + senha);
    }
    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            System.out.println(conn.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BancoSql.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BancoSql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
