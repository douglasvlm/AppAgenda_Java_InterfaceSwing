package Dao;

import static Agenda_Connection.ConnectionMyDB.closeConnection;
import static Agenda_Connection.ConnectionMyDB.getConnection;
import Poo.Agenda;
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
 * Connection Class Agenda
 * @version 1.1
 * @since 2019/2021
 * @author Douglas 
 */

public class AgendaDao {

    public void insertAgenda (Agenda a){
        Connection con = getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO ACADEMIC_AGENDA (ID_EVENT,ID_DISCIPLINE,ID_TIME,DAYS,NOTE) \n" +
                                    "VALUES (?,?,?,STR_TO_DATE(?, '%d/%m/%Y'),?);");
    
            stmt.setInt(1,a.getId_event());
            stmt.setInt(2,a.getId_discipline());
            stmt.setInt(3,a.getId_time());
            stmt.setString(4,a.getDays());
            stmt.setString(5,a.getNote());
                        
            stmt.executeUpdate();
            
            showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            
            showMessageDialog(null, "Data e horario ja possui agendamento!");
            getLogger(AgendaDao.class.getName()).log(SEVERE, null, ex);
            
        }finally{
            
            closeConnection(con, stmt);
        }
    }        
 
    public List<Agenda> leitura() {
        Connection con = getConnection();      
        PreparedStatement stmt = null;      
        ResultSet rs = null;         
        List<Agenda> agenda = new ArrayList <>();
        try {
                stmt = con.prepareStatement(" SELECT ID_AGENDA, EVE.NAME, DATE_FORMAT(AGE.DAYS, '%d/%m/%Y')AS DATE, TIM.TIME, DIS.NAME, AGE.NOTE\n" +
                                                    "FROM EVENT EVE, ACADEMIC_AGENDA AGE, TIME TIM, DISCIPLINE DIS\n" +
                                                    "WHERE AGE.ID_EVENT = EVE.ID_EVENT\n" +
                                                    "AND AGE.ID_TIME = TIM.ID_TIME\n" +
                                                    "AND AGE.ID_DISCIPLINE = DIS.ID_DISCIPLINE; ");
                rs = stmt.executeQuery();
                while (rs.next()) {               
                    Agenda a = new Agenda();
                    a.setId_agenda(rs.getInt("ID_AGENDA"));
                    a.setEveName(rs.getString("EVE.NAME"));
                    a.setDays(rs.getString("DATE"));
                    a.setTime(rs.getString("TIME"));
                    a.setDisName(rs.getString("DIS.NAME"));
                    a.setNote(rs.getString("AGE.NOTE"));
                    agenda.add(a);
                
                }
            
            } catch (SQLException ex) {
                 showMessageDialog(null, "Erro ao ler!"+ex);
                getLogger(AgendaDao.class.getName()).log(SEVERE, null, ex);
            } finally {
            
                    closeConnection(con, stmt);
            }            
            return agenda;
 }
     
    public void updateAgenda (Agenda a){
        Connection con = getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE ACADEMIC_AGENDA SET ID_EVENT =?,  DAYS=STR_TO_DATE(?, '%d/%m/%Y'), ID_TIME=?, ID_DISCIPLINE=?, NOTE =? WHERE ID_AGENDA = ?");
            
                   
            stmt.setInt(1,a.getId_event());
            stmt.setString(2,a.getDays());
            stmt.setInt(3,a.getId_time());
            stmt.setInt(4,a.getId_discipline());
            stmt.setString(5,a.getNote());
            stmt.setInt(6,a.getId_agenda());
                        
            stmt.executeUpdate();
            
            showMessageDialog(null, "Atualizado com sucesso!");
            
        } catch (SQLException ex) {
            
            showMessageDialog(null, "Data e Horarios já possui agendamento!"/*+ex*/);
            getLogger(AgendaDao.class.getName()).log(SEVERE, null, ex);
            
        }finally{
            
            closeConnection(con, stmt);
        }
    }    
   
    public void deleteAgenda (Agenda a){
        
        Connection con = getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM ACADEMIC_AGENDA WHERE ID_AGENDA=?");
            
                   
            stmt.setInt(1,a.getId_agenda());
           
            stmt.executeUpdate();
            
            showMessageDialog(null, "Excluido com sucesso!");
            
        } catch (SQLException ex) {
            showMessageDialog(null, "Erro ao excluir!");
            getLogger(AgendaDao.class.getName()).log(SEVERE, null, ex);
        }finally{
            closeConnection(con, stmt);
        }
    } 
       
    public List<Agenda> pesquisar(String date) {
          Connection con = getConnection();
          PreparedStatement stmt = null;
          ResultSet rs = null;
          
          List<Agenda> agenda = new ArrayList <>();

            try {

                stmt = con.prepareStatement("SELECT ID_AGENDA, EVE.NAME, DATE_FORMAT(AGE.DAYS, '%d/%m/%Y') AS DATE, TIME, DIS.NAME, AGE.NOTE\n" +
                                                    "FROM EVENT EVE, ACADEMIC_AGENDA AGE, TIME TIM, DISCIPLINE DIS\n" +
                                                    "WHERE AGE.ID_EVENT = EVE.ID_EVENT\n" +
                                                    "AND AGE.ID_TIME = TIM.ID_TIME\n" +
                                                    "AND AGE.ID_DISCIPLINE = DIS.ID_DISCIPLINE\n" +
                                                    "AND AGE.DAYS LIKE STR_TO_DATE(?, '%d/%m/%Y');");
                stmt.setString(1, date);
                rs = stmt.executeQuery();

                while (rs.next()){                
                    Agenda a = new Agenda();
                    a.setId_agenda(rs.getInt("ID_AGENDA"));
                    a.setEveName(rs.getString("EVE.NAME"));
                    a.setDays(rs.getString("DATE"));
                    a.setTime(rs.getString("TIME"));
                    a.setDisName(rs.getString("DIS.NAME"));
                    a.setNote(rs.getString("AGE.NOTE"));
                    agenda.add(a);
                
                }
            
            } catch (SQLException ex) {
                 showMessageDialog(null, "Não existe!"+ex);
                getLogger(AgendaDao.class.getName()).log(SEVERE, null, ex);
            } finally {
            
                 closeConnection(con, stmt);  
            }         
        return agenda;
    }
}