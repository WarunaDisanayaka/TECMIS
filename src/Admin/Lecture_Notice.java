/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Admin;

import com.mysql.jdbc.Connection;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author warun
 */
public class Lecture_Notice extends javax.swing.JInternalFrame {
    
    java.sql.Connection con;
    
    /**
     * Creates new form Profiles
     */
    public Lecture_Notice() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        con=DBConnect.connect();
        PreparedStatement pst;
        ResultSet rs;
        
        this.setSize(1200,800);
        
        displayTable();
        
        
        
    }
    
    public void tableClick(){
       
    }
    
    public void displayTable(){
        
        Notice noti=new Notice();
        
       DefaultTableModel model=(DefaultTableModel) notices.getModel();
        
         model.setRowCount(0);
         noti.display();
         
         for (Object data : noti.getData()) {
            model.addRow((Vector)data);
        }
    }
    
       
     public void displayStudent(){
         Users std=new Users();
        
         DefaultTableModel model=(DefaultTableModel) notices.getModel();
        
         model.setRowCount(0);
         std.display();
         
         for (Object data : std.getData()) {
            model.addRow((Vector)data);
        }
    }
     
     
   
     
     
    
    
    public void clear(){
        
            title.setText("");
            notice.setText("");
            
            
            jButton6.setEnabled(true);
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        notices = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(1155, 600));

        notices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Title", "Notice"
            }
        ));
        notices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noticesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(notices);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(349, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Notice", jPanel3);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 0, 988, 716);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void noticesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noticesMouseClicked
        try {
            Notice noti=new Notice();
            DefaultTableModel d = (DefaultTableModel)notices.getModel();
            int row=notices.getSelectedRow();
            int id=(int) notices.getValueAt(row, 0);
            //JOptionPane.showMessageDialog(null, row);
            int count=notices.getRowCount();

            //JOptionPane.showMessageDialog(null, id);
            noti.select(id);
            title.setText(noti.getTitle());
            notice.setText(noti.getNotice());

            jButton6.setEnabled(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_noticesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable notices;
    // End of variables declaration//GEN-END:variables

        
    
    
}

