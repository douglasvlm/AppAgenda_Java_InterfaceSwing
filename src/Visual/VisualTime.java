
package Visual;

import Dao.TimeDao;
import Poo.Time;
import javax.swing.table.DefaultTableModel;

/**
 * Visual Time
 * @version 1.1
 * @since 2019/2021
 * @author Douglas 
 */
public class VisualTime extends javax.swing.JFrame {

    public VisualTime() {
        initComponents();
        readTime();
    }
    
    
     public void readTime(){
        DefaultTableModel lendoModelo =  (DefaultTableModel) horTable.getModel();
        lendoModelo.setNumRows(0);
        TimeDao timeDao = new TimeDao();
        
        for(Time h: timeDao.readHorary()){
            lendoModelo.addRow(new Object[]{
                h.getId_time(),
                h.getTime()
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        horTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Table Horary");
        setMinimumSize(new java.awt.Dimension(350, 300));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        horTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CLASS PERIOD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(horTable);
        if (horTable.getColumnModel().getColumnCount() > 0) {
            horTable.getColumnModel().getColumn(0).setMinWidth(50);
            horTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            horTable.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 0, 228, 290));

        jLabel1.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        jLabel1.setText("THIS TABLE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        jLabel3.setText("ISN'T EDITABLE");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 80, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cancel.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable horTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
