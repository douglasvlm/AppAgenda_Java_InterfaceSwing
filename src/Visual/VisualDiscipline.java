package Visual;

import Dao.DisciplineDao;
import Poo.Discipline;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
/**
 * Visual Discipline
 * @version 1.1
 * @since 2019/2021
 * @author Douglas 
 */
public class VisualDiscipline extends javax.swing.JFrame {
    public VisualDiscipline() {
        initComponents();
        readDiscipline();
    }
          
      public void readDiscipline(){
        DefaultTableModel lendoModelo =  (DefaultTableModel) disTable.getModel();
        lendoModelo.setNumRows(0);
        DisciplineDao disciplineDao = new DisciplineDao();
        
        for(Discipline d: disciplineDao.readDiscipline()){
            lendoModelo.addRow(new Object[]{
                d.getId_disicipline(),
                d.getName()
            });
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_Insert = new javax.swing.JButton();
        bt_Delete = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtDiscipline = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        disTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Discipline Table");
        setMinimumSize(new java.awt.Dimension(750, 250));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt_Insert.setText("INSERT");
        bt_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_InsertActionPerformed(evt);
            }
        });
        getContentPane().add(bt_Insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 67, 132, -1));

        bt_Delete.setText("DELETE");
        bt_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_DeleteActionPerformed(evt);
            }
        });
        getContentPane().add(bt_Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 128, 132, -1));

        jButton3.setText("ALTER");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 185, 132, -1));
        getContentPane().add(txtDiscipline, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 29, 255, -1));

        disTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(disTable);
        if (disTable.getColumnModel().getColumnCount() > 0) {
            disTable.getColumnModel().getColumn(0).setMinWidth(50);
            disTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            disTable.getColumnModel().getColumn(0).setMaxWidth(50);
            disTable.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 0, 467, 250));

        jLabel1.setText("DISCIPLINE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 12, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/calendar_add.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/calendar_edit.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/calendar_delete.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 20, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(disTable.getSelectedRow() != -1){   

           Discipline d = new Discipline();
           DisciplineDao dao = new DisciplineDao();

           d.setName(txtDiscipline.getText().toUpperCase());
           d.setId_disicipline((int)disTable.getValueAt(disTable.getSelectedRow(), 0));
           dao.updateDiscipline(d);
           
           readDiscipline();
           txtDiscipline.setText("");
        }else{
            showMessageDialog(null, "Selecione uma disciplina");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void bt_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_InsertActionPerformed
       Discipline d = new Discipline();
       DisciplineDao dao = new DisciplineDao();
       
       d.setName(txtDiscipline.getText().toUpperCase());
       dao.insertDiscipline(d);
       readDiscipline();
       
       txtDiscipline.setText("");       
    }//GEN-LAST:event_bt_InsertActionPerformed

    private void bt_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_DeleteActionPerformed
        if(disTable.getSelectedRow() != -1){   
            Discipline d = new Discipline();
            DisciplineDao dao = new DisciplineDao();
            
            d.setId_disicipline((int) disTable.getValueAt(disTable.getSelectedRow(), 0));
            dao.deleteDiscipline(d);
            
            readDiscipline();
            txtDiscipline.setText("");
        }else{
            showMessageDialog(null, "Selecione uma disciplina");
        }
    }//GEN-LAST:event_bt_DeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Delete;
    private javax.swing.JButton bt_Insert;
    private javax.swing.JTable disTable;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDiscipline;
    // End of variables declaration//GEN-END:variables
}
