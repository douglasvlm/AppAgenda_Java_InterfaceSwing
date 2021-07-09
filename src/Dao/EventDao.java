
package Dao;

import Poo.Event;
import static Agenda_Connection.ConnectionMyDB.closeConnection;
import static Agenda_Connection.ConnectionMyDB.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Connection Class Event
 * @version 1.0
 * @since 2019
 * @author Douglas And William
 */

public class EventDao {
//------------------------------------------------------//
//--                    INSERT
//------------------------------------------------------//    
    public void insertEvent (Event e){
        Connection con = getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO EVENT (NAME) VALUES (?)");
            
            stmt.setString(1,e.getName());
                        
            stmt.executeUpdate();
            
            showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            
            showMessageDialog(null, "Cadastro não pode ser duplicado ou vazio!");
            getLogger(EventDao.class.getName()).log(SEVERE, null, ex);
            
        }finally{
            
            closeConnection(con, stmt);
        }

    }      
    
//------------------------------------------------------//
//                    SELECT 
//------------------------------------------------------//   
    public List<Event> readEvent() {
          Connection con = getConnection();
          PreparedStatement stmt = null;
          ResultSet rs = null;
          
          List<Event> event = new ArrayList <>();

            try {

                stmt = con.prepareStatement("SELECT * FROM EVENT");
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                
               Event e = new Event();
                e.setId_event(rs.getInt("ID_EVENT"));
                e.setName(rs.getString("NAME"));
                event.add(e);
                
                }
            
            } catch (SQLException ex) {
                 showMessageDialog(null, "Erro ao ler!"+ex);
                getLogger(EventDao.class.getName()).log(SEVERE, null, ex);
            } finally {
            
                    closeConnection(con, stmt);
        
            }
            
            return event;
    }
//------------------------------------------------------//
//                    UPDATE 
//------------------------------------------------------//   
   
    public void updateEvent (Event e){
        Connection con = getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE EVENT SET NAME=? WHERE ID_EVENT = ?");
                 
            stmt.setString(1,e.getName());
            stmt.setInt(2,e.getId_event());
                     
            stmt.executeUpdate();
            
            showMessageDialog(null, "Atualizado com sucesso!");
            
        } catch (SQLException ex) {
            showMessageDialog(null, "Erro ao atualizar!");
            showMessageDialog(null, "Valor não pode ser duplicado ou vazio!");
            getLogger(EventDao.class.getName()).log(SEVERE, null, ex);
        }finally{
            closeConnection(con, stmt);
        }
    } 
   
 //------------------------------------------------------//
//                    DELETE
//------------------------------------------------------//   
   
    public void deleteEvent (Event e){
        
        Connection con = getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM EVENT WHERE ID_EVENT=?");
                   
            stmt.setInt(1,e.getId_event());
           
            stmt.executeUpdate();
            
            showMessageDialog(null, "Excluido com sucesso!");
            
        } catch (SQLException ex) {
            showMessageDialog(null, "Erro ao excluir!");
            showMessageDialog(null, "Evento está sendo usado!");
            getLogger(EventDao.class.getName()).log(SEVERE, null, ex);
        }finally{
            closeConnection(con, stmt);
        }
    } 
}