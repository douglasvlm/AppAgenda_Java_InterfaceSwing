
package Visual;

import Agenda_Connection.ConnectionMyDB;
import Dao.AgendaDao;
import Poo.Agenda;
import static java.lang.System.exit;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.ofInstant;
import static java.time.ZoneId.systemDefault;
import java.time.ZonedDateTime;
import java.util.Date;
import static java.util.Date.from;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
/**
 * Main Class Visual Agenda
 * @version 1.1
 * @since 2019/2021
 * @author Douglas 
 */

public class VisualAgenda extends javax.swing.JFrame {

    public VisualAgenda() {
        initComponents();
        
        //set date chooser
        Date now = new Date();
        Instant current = now.toInstant();
        LocalDateTime ldt = ofInstant(current, 
        systemDefault());
        ZonedDateTime zdt = ldt.atZone(systemDefault());
        Date output = from(zdt.toInstant());
        jDateChooser1.setMinSelectableDate(output);
        
        
        comboTime();
        comboDiscipline();
        comboEvent();
        readAgenda();
    }
    

    public void readAgenda(){
        DefaultTableModel lendoModelo =  (DefaultTableModel) ageTable.getModel();
        lendoModelo.setNumRows(0);
        AgendaDao agendaDao = new AgendaDao();
        
        for(Agenda a: agendaDao.leitura()){
            lendoModelo.addRow(new Object[]{
                a.getId_agenda(),
                a.getEveName(),
                a.getDays(),
                a.getTime(),
                a.getDisName(),
                a.getNote()
                   
            });
        }
    }
    
    public void searchDate(String date){
        
        DefaultTableModel lendoModelo =  (DefaultTableModel) ageTable.getModel();
        lendoModelo.setNumRows(0);
        AgendaDao agendaDao = new AgendaDao();
        
        for(Agenda a: agendaDao.pesquisar(date)){
            lendoModelo.addRow(new Object[]{
               a.getId_agenda(),
                a.getEveName(),
                a.getDays(),
                a.getTime(),
                a.getDisName(),
                a.getNote()
            
            });
        }
    }
    
    ConnectionMyDB conect = new ConnectionMyDB();
    
    public void comboEvent(){
        conect.startSqlConnection();
        conect.executeSql("SELECT * FROM EVENT");
        try {
            conect.RS.first();
            comboEvent.removeAllItems();
         do{
               comboEvent.addItem(conect.RS.getString("NAME"));
            
            }while(conect.RS.next());
        } catch (SQLException ex) {
             Logger.getLogger(VisualAgenda.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Erro de COMBO event:\n" + ex);
        }
        conect.closeSqlConnection();
    }
    
       
    public void comboTime(){
        conect.startSqlConnection();
        conect.executeSql("SELECT * FROM TIME");
        try {
            conect.RS.first();
            comboTime.removeAllItems();
         do{
               comboTime.addItem(conect.RS.getString("TIME"));
            
            }while(conect.RS.next());
        } catch (SQLException ex) {
             Logger.getLogger(VisualAgenda.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Erro de COMBO time:\n" + ex);
        }
        conect.closeSqlConnection();

    }
    
    public void comboDiscipline(){
        conect.startSqlConnection();
        conect.executeSql("SELECT * FROM DISCIPLINE");
        try {
            conect.RS.first();
            comboDiscipline.removeAllItems();
         do{
               comboDiscipline.addItem(conect.RS.getString("NAME"));
            
            }while(conect.RS.next());
        } catch (SQLException ex) {
             Logger.getLogger(VisualAgenda.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Erro de COMBO HORARY:\n" + ex);
        }
        conect.closeSqlConnection();

    }
    
    private int idisci, ideve, idtim;
    
    public int searchId_Discipline(String b){
        
        conect.startSqlConnection();
        conect.executeSql("SELECT * FROM DISCIPLINE WHERE NAME ='"+b+"'");
        try {
            conect.RS.first();
            idisci = conect.RS.getInt("ID_DISCIPLINE");
          
        } catch (SQLException ex) {
            Logger.getLogger(VisualAgenda.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao busca disciplina: " + ex);
        }
        conect.closeSqlConnection();
        
        return idisci;
    }    
    
    public int searchId_Event(String b){
        
        conect.startSqlConnection();
        conect.executeSql("SELECT * FROM EVENT WHERE NAME ='"+b+"'");
        try {
            conect.RS.first();
            ideve = conect.RS.getInt("ID_EVENT");
          
        } catch (SQLException ex) {
            Logger.getLogger(VisualAgenda.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao busca disciplina: " + ex);
        }
        conect.closeSqlConnection();
        
        return ideve;
     }
    
    public int searchId_Time(String b){
        
        conect.startSqlConnection();
        conect.executeSql("SELECT * FROM TIME WHERE TIME ='"+b+"'");
        try {
            conect.RS.first();
            idtim = conect.RS.getInt("ID_TIME");
          
        } catch (SQLException ex) {
            Logger.getLogger(VisualAgenda.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao busca TIME: " + ex);
        }
        conect.closeSqlConnection();
        
        return idtim;
     }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ageTable = new javax.swing.JTable();
        btShow = new javax.swing.JButton();
        btInsert = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        brSearch = new javax.swing.JButton();
        comboDiscipline = new javax.swing.JComboBox<>();
        comboEvent = new javax.swing.JComboBox<>();
        comboTime = new javax.swing.JComboBox<>();
        txtNote = new javax.swing.JTextField();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ageTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "EVENT", "DATE", "HORARY", "DISCIPLINE", "NOTE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ageTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ageTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ageTable);
        if (ageTable.getColumnModel().getColumnCount() > 0) {
            ageTable.getColumnModel().getColumn(0).setMinWidth(50);
            ageTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            ageTable.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 860, 240));

        btShow.setText("SHOW ALL");
        btShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btShowActionPerformed(evt);
            }
        });
        getContentPane().add(btShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 120, 40));

        btInsert.setText("INSERT");
        btInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInsertActionPerformed(evt);
            }
        });
        getContentPane().add(btInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 120, 40));

        btEdit.setText("EDIT");
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });
        getContentPane().add(btEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 120, 40));

        btDelete.setForeground(new java.awt.Color(255, 102, 102));
        btDelete.setText("DELETE");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 120, 40));

        brSearch.setText("SEARCH");
        brSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brSearchActionPerformed(evt);
            }
        });
        getContentPane().add(brSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, 140, 40));

        getContentPane().add(comboDiscipline, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 270, 40));

        getContentPane().add(comboEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 170, 40));

        getContentPane().add(comboTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 140, 40));
        getContentPane().add(txtNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 520, 30));
        getContentPane().add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 140, 40));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 140, 40));

        jLabel1.setText("DATE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel2.setText("HORARY");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 60, -1));

        jLabel3.setText("EVENT");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        jLabel4.setText("DISCIPLINE");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, -1));

        jLabel5.setText("NOTE");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("SEARCH DATE"));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 200, 120));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 850, 140));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/zoom.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 20, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/calendar_add.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/calendar_edit.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/calendar_delete.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 20, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/application_cascade.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 20, -1));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/help.png"))); // NOI18N
        jMenu1.setText("File");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cancel.png"))); // NOI18N
        jMenuItem4.setText("Exit");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add.png"))); // NOI18N
        jMenu2.setText("Discipline");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/information.png"))); // NOI18N
        jMenuItem1.setText("Edit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add.png"))); // NOI18N
        jMenu3.setText("Event");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/information.png"))); // NOI18N
        jMenuItem2.setText("Edit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add.png"))); // NOI18N
        jMenu4.setText("Horary");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/information.png"))); // NOI18N
        jMenuItem3.setText("View");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    VisualDiscipline disciplineWindows = new VisualDiscipline();
    VisualEvent           eventWindows = new VisualEvent();
    VisualTime         timeWindows = new VisualTime();
        
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        disciplineWindows.dispose();
        disciplineWindows.setVisible(true);           
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        eventWindows.dispose();
        eventWindows.setVisible(true);  
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        timeWindows.dispose();
        timeWindows.setVisible(true);  
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void btInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInsertActionPerformed
        
        Agenda c = new Agenda();
        AgendaDao dao = new AgendaDao();
                     
        String disc =  (String) comboDiscipline.getSelectedItem();
        String time =  (String) comboTime.getSelectedItem();        
        String eve =  (String) comboEvent.getSelectedItem();        
       
       Agenda x = new Agenda();
                             
       c.setDays(x.getMeuDataChooser(jDateChooser1)); 
       c.setId_event(searchId_Event(eve));
       c.setId_discipline(searchId_Discipline(disc));
       c.setId_time(searchId_Time(time)); 
       
       c.setNote(txtNote.getText());
       dao.insertAgenda(c);
       readAgenda();
       
       txtNote.setText("");
    }//GEN-LAST:event_btInsertActionPerformed

    private void ageTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ageTableMouseClicked
       
    }//GEN-LAST:event_ageTableMouseClicked

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        if(ageTable.getSelectedRow() != -1){   
            Agenda a = new Agenda();
            Agenda z = new Agenda();
            AgendaDao dao = new AgendaDao();

            String disc =  (String) comboDiscipline.getSelectedItem();
            String time =  (String) comboTime.getSelectedItem();        
            String eve =  (String) comboEvent.getSelectedItem();

            a.setId_event(searchId_Event(eve));
            a.setId_discipline(searchId_Discipline(disc));
            a.setId_time(searchId_Time(time)); 
            a.setDays(z.getMeuDataChooser(jDateChooser1)); 
            a.setNote(txtNote.getText());
            a.setId_agenda((int)ageTable.getValueAt(ageTable.getSelectedRow(), 0));
                dao.updateAgenda(a);
                readAgenda();
                txtNote.setText("");
        }else{
            showMessageDialog(null, "Selecione um agendamento");
        }
    }//GEN-LAST:event_btEditActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        if(ageTable.getSelectedRow() != -1){   
            Agenda a = new Agenda();
            AgendaDao dao = new AgendaDao();
            a.setId_agenda((int) ageTable.getValueAt(ageTable.getSelectedRow(), 0));
                dao.deleteAgenda(a);
                readAgenda();
                txtNote.setText("");
        }else{
            showMessageDialog(null, "Selecione um agendamento");
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void brSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brSearchActionPerformed
        Agenda a = new Agenda();
        searchDate(a.getMeuDataChooser(jDateChooser2));
    }//GEN-LAST:event_brSearchActionPerformed

    private void btShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btShowActionPerformed
        comboTime();
        comboDiscipline();
        comboEvent();
        readAgenda();
    }//GEN-LAST:event_btShowActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    public static void main(String args[]) {
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VisualAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisualAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisualAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisualAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualAgenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ageTable;
    private javax.swing.JButton brSearch;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btInsert;
    private javax.swing.JButton btShow;
    private javax.swing.JComboBox<String> comboDiscipline;
    private javax.swing.JComboBox<String> comboEvent;
    private javax.swing.JComboBox<String> comboTime;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtNote;
    // End of variables declaration//GEN-END:variables
}
