package Agenda_Connection;

import static java.lang.Class.forName;
import static java.lang.System.err;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.JOptionPane;

/**
 * Connection Class
 * @version 1.1
 * @since 2019/2021
 * @author Douglas 
 */
//------------------------------------------------------//
//                    CONNECTION 
//------------------------------------------------------// 
public class ConnectionMyDB {
    public  Statement STM;
    public Connection CON;    
    public ResultSet RS;
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String    URL = "jdbc:mysql://localhost:3306/DATABASE_AGENDA";
    private static final String   USER = "root";
    private static final String   PASS = "1234";
       
    public void startSqlConnection(){
        try {
            System.setProperty("jdbc.Drivers", DRIVER);
            CON = DriverManager.getConnection(URL, USER, PASS);
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionMyDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro na conexão:\n" + ex);
        }
    }
    
    public void executeSql(String sql){
        try {
            STM = CON.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            RS  = STM.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionMyDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro do executa sql:\n" + ex);
        }
    }
    
    public void closeSqlConnection(){
        try {
            CON.close();
           
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionMyDB.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Erro ao desconectar do BD:\n" + ex);
        }
    }
    
    public static Connection getConnection(){
    
        try {
            
            forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
           
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão", ex);
        }
    }
    
    public static void closeConnection(Connection con){
  
        try {
            if(con != null){
                con.close();
            }
        }catch (SQLException ex) {
            getLogger(ConnectionMyDB.class.getName()).log(SEVERE, null, ex);
        }               
    } 

    public static void closeConnection(Connection con, PreparedStatement stmt){
        closeConnection(con);
        try {
            if(stmt != null){
                stmt.close();
            }
        }catch (SQLException ex) {
            err.println("Erro:"+ex);
        }       
    } 
           
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection(con, stmt);
        try {
            if(rs != null){
                rs.close();
            } 
        }catch (SQLException ex) {
            err.println("Erro:"+ex);
        }       
    }
}