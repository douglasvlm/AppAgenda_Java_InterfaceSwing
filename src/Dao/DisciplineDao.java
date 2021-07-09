package Dao;

import static Agenda_Connection.ConnectionMyDB.closeConnection;
import static Agenda_Connection.ConnectionMyDB.getConnection;
import Poo.Discipline;
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
 * Connection Class Discipline
 * @version 1.1
 * @since 2019/2021
 * @author Douglas 
 */

public class DisciplineDao {

//------------------------------------------------------//
//                    INSERT
//------------------------------------------------------//    
    public void insertDiscipline (Discipline d){
        Connection con = getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO DISCIPLINE (NAME) VALUES (?)");
            //stmt.setInt(1,a.getId_agenda());
            stmt.setString(1,d.getName());
                        
            stmt.executeUpdate();
            
            showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            
            showMessageDialog(null, "Valor não pode ser duplicado ou vazio!");
            getLogger(DisciplineDao.class.getName()).log(SEVERE, null, ex);
            
        }finally{
            
            closeConnection(con, stmt);
        }

    }      
    
//------------------------------------------------------//
//                    SELECT 
//------------------------------------------------------//   
    public List<Discipline> readDiscipline() {
          Connection con = getConnection();
          PreparedStatement stmt = null;
          ResultSet rs = null;
          
          List<Discipline> discipline = new ArrayList <>();

            try {

                stmt = con.prepareStatement("SELECT * FROM DISCIPLINE");
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                
                Discipline d = new Discipline();
                d.setId_disicipline(rs.getInt("ID_DISCIPLINE"));
                d.setName(rs.getString("NAME"));
                discipline.add(d);
                
                }
            
            } catch (SQLException ex) {
                 showMessageDialog(null, "Erro ao ler!");
                getLogger(DisciplineDao.class.getName()).log(SEVERE, null, ex);
            } finally {
            
                    closeConnection(con, stmt);
        
            }
            
            return discipline;
    }
//------------------------------------------------------//
//                    UPDATE 
//------------------------------------------------------//   
   
    public void updateDiscipline (Discipline d){
        Connection con = getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE DISCIPLINE SET NAME=? WHERE ID_DISCIPLINE = ?");
            //stmt.setInt(1,a.getId_agenda());
                   
            stmt.setString(1,d.getName());
            stmt.setInt(2,d.getId_disicipline());
            
                        
            stmt.executeUpdate();
            showMessageDialog(null, "Atualizado com sucesso!");
            
        } catch (SQLException ex) {
            showMessageDialog(null, "Erro ao atualizar!");
            showMessageDialog(null, "Valor não pode ser duplicado ou vazio!");
            getLogger(DisciplineDao.class.getName()).log(SEVERE, null, ex);
        }finally{
            closeConnection(con, stmt);
        }
    } 
   
 //------------------------------------------------------//
//                    DELETE
//------------------------------------------------------//   
   
    public void deleteDiscipline (Discipline d){
        
        Connection con = getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM DISCIPLINE WHERE ID_DISCIPLINE=?");
            //stmt.setInt(1,a.getId_agenda());
                   
            stmt.setInt(1,d.getId_disicipline());
           
            stmt.executeUpdate();
            
            showMessageDialog(null, "Excluido com sucesso!");
            
        } catch (SQLException ex) {
            showMessageDialog(null, "Erro ao excluir!");
            showMessageDialog(null, "Disciplina está sendo usada!");
            getLogger(DisciplineDao.class.getName()).log(SEVERE, null, ex);
        }finally{
            closeConnection(con, stmt);
        }
    } 
}