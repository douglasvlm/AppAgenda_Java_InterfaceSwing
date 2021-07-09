
package Dao;

import static Agenda_Connection.ConnectionMyDB.closeConnection;
import static Agenda_Connection.ConnectionMyDB.getConnection;
import Poo.Time;
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
 * Connection Class Time
 * @version 1.1
 * @since 2019/2021
 * @author Douglas 
 */

public class TimeDao {
    public List<Time> readHorary() {
          Connection con = getConnection();
          PreparedStatement stmt = null;
          ResultSet rs = null;
          
          List<Time> tm = new ArrayList <>();

            try {

                stmt = con.prepareStatement("SELECT * FROM TIME");
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                
                Time h = new Time();
                
               h.setId_time(rs.getInt("ID_TIME"));
               h.setTime(rs.getString("TIME"));
                
                tm.add(h);
                }       
            } catch (SQLException ex) {
                 showMessageDialog(null, "Erro ao ler!"+ex);
                getLogger(TimeDao.class.getName()).log(SEVERE, null, ex);
            } finally {
            
                    closeConnection(con, stmt);
            }
            return tm;
    } 
}