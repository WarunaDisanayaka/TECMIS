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
public class Courses extends javax.swing.JInternalFrame {
    
    java.sql.Connection con;
    
    /**
     * Creates new form Profiles
     */
    public Courses() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        con=DBConnect.connect();
        PreparedStatement pst;
        ResultSet rs;
        
        this.setSize(1200,800);
        
        setLecturer();
        setDepartment();
        displayTable();
        setCourseET();
        
    }
    
     public void displayTable(){
       Course co=new Course();
       Course_Lecturer co_lec=new Course_Lecturer();
       
       DefaultTableModel model=(DefaultTableModel) courses.getModel();
       DefaultTableModel model2=(DefaultTableModel) course_lecturer.getModel();
       
        
         model.setRowCount(0);
         model2.setRowCount(0);
         co.display();
         co_lec.display();
         
          for (Object data : co_lec.getData()) {
            model2.addRow((Vector)data);
        }
         
         for (Object data : co.getData()) {
            model.addRow((Vector)data);
        }
    }
     
    
    
    public void setLecturer(){   
        
        try {
            String sql="SELECT *FROM users WHERE user_role='Lecturer'";
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            
            while(rs.next()) { 
            ET_lecturer.addItem(rs.getString("user_id"));
           
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
       
        
    }
    
     public void setDepartment(){
         try {
            String sql="SELECT *FROM department";
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            
            while(rs.next()) { 
           department.addItem(rs.getString("name"));
           
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
      public void setCourseET(){   
        
        try {
            String sql="SELECT *FROM course WHERE department_fk='ET'";
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            
            while(rs.next()) { 
            ET_course.addItem(rs.getString("title"));
           
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
       
        
    }
     
   
     
     
    
    
    public void clear(){
            course_title.setText("");
            course_codin.setText("");
            course_credit.setText("");
            
            
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
        courses = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        department = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        course_title = new javax.swing.JTextField();
        course_codin = new javax.swing.JTextField();
        course_credit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        level = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ET_course = new javax.swing.JComboBox<>();
        ET_lecturer = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        course_lecturer = new javax.swing.JTable();

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

        courses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Course Title", "Course Coordinator", "Course Credit", "Department", "Level"
            }
        ));
        courses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coursesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(courses);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Course Details"));

        jLabel12.setText("Course Coordinator");

        department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));

        jLabel13.setText("Course Credit");

        jLabel11.setText("Course Title");

        jLabel9.setText("Department");

        course_title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course_titleActionPerformed(evt);
            }
        });

        jLabel2.setText("Level");

        level.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Level 1", "Level 2", "Level 3", "Level 4", " " }));

        jButton6.setText("Save");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Update");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Delete");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Clear");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(department, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(course_title, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(course_codin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(course_credit)
                            .addComponent(level, 0, 253, Short.MAX_VALUE))
                        .addGap(75, 75, 75))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(course_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(course_codin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(course_credit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton9)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(268, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Create Course", jPanel3);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Course Name");

        jLabel3.setText("Lecturer");

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        course_lecturer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Course Name", "Lecturer"
            }
        ));
        course_lecturer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                course_lecturerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(course_lecturer);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ET_course, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ET_lecturer, 0, 196, Short.MAX_VALUE))))
                .addContainerGap(505, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ET_course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ET_lecturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(103, 103, 103)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(210, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Assign Lecturers", jPanel1);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 0, 988, 716);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void course_titleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course_titleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_course_titleActionPerformed

    private void coursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coursesMouseClicked
        try {
            Course co=new Course();
            DefaultTableModel d = (DefaultTableModel)courses.getModel();
            int row=courses.getSelectedRow();
            int id=(int) courses.getValueAt(row, 0);
            //JOptionPane.showMessageDialog(null, row);
            int count=courses.getRowCount();

            //JOptionPane.showMessageDialog(null, id);
            co.select(id);
            course_title.setText(co.getTitle());
            course_codin.setText(co.getCoordinator());
            course_credit.setText(co.getCredit().toString());
            department.setSelectedItem(co.getDepartment());
            level.setSelectedItem(co.getLevel());

            jButton6.setEnabled(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_coursesMouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        clear();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            Course co=new Course();
            DefaultTableModel d = (DefaultTableModel)courses.getModel();
            int row=courses.getSelectedRow();
            int id=(int) courses.getValueAt(row, 0);
            //JOptionPane.showMessageDialog(null, row);
            int count=courses.getRowCount();

            //JOptionPane.showMessageDialog(null, id);

            co.delete(id);
           displayTable();
            clear();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
            try {
            Course co=new Course();
            
            DefaultTableModel d = (DefaultTableModel)courses.getModel();
            int row=courses.getSelectedRow();
            int id=(int) courses.getValueAt(row, 0);
            //JOptionPane.showMessageDialog(null, row);
            int count=courses.getRowCount();
            
            String course_title=this.course_title.getText();
            String course_codinator=course_codin.getText();
            Integer course_credit=Integer.parseInt(this.course_credit.getText());
            String department=this.department.getSelectedItem().toString();
            String level=this.level.getSelectedItem().toString();

            //JOptionPane.showMessageDialog(null, id);
            co.select(id);
            co.setTitle(course_title);
            co.setCoordinator(course_codinator);
            co.setCredit(course_credit);
            co.setDepartment(department);
            co.setLevel(level);

            co.update();
           displayTable();
            
            clear();

             jButton6.setEnabled(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
            Course co=new Course();
            
            String course_title=this.course_title.getText();
            String course_codinator=course_codin.getText();
            Integer course_credit=Integer.parseInt(this.course_credit.getText());
            String department=this.department.getSelectedItem().toString();
            String level=this.level.getSelectedItem().toString();
            
            co.setTitle(course_title);
            co.setCoordinator(course_codinator);
            co.setCredit(course_credit);
            co.setDepartment(department);
            co.setLevel(level);
            
            co.insert();
            displayTable();
            clear();
            
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            Course_Lecturer co_lec=new Course_Lecturer();
            
            String Et_Course=ET_course.getSelectedItem().toString();
            String Et_Lecturer=ET_lecturer.getSelectedItem().toString();
            
        
            co_lec.setCourse(Et_Course);
            co_lec.setLecturer(Et_Lecturer);
            
            co_lec.insert();
            displayTable();
            clear();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void course_lecturerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_course_lecturerMouseClicked
            try {
            Course_Lecturer co_lec=new Course_Lecturer();
            DefaultTableModel d = (DefaultTableModel)course_lecturer.getModel();
            int row=course_lecturer.getSelectedRow();
            int id=(int) course_lecturer.getValueAt(row, 0);
            //JOptionPane.showMessageDialog(null, row);
            int count=course_lecturer.getRowCount();

            //JOptionPane.showMessageDialog(null, id);
            co_lec.select(id);
            ET_course.setSelectedItem(co_lec.getCourse());
            ET_lecturer.setSelectedItem(co_lec.getLecturer());

            jButton6.setEnabled(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_course_lecturerMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            try {
            Course_Lecturer co_lec=new Course_Lecturer();
            
            DefaultTableModel d = (DefaultTableModel)course_lecturer.getModel();
            int row=course_lecturer.getSelectedRow();
            int id=(int) course_lecturer.getValueAt(row, 0);
            //JOptionPane.showMessageDialog(null, row);
            int count=course_lecturer.getRowCount();
            
            String Et_Course=ET_course.getSelectedItem().toString();
            String Et_Lecturer=ET_lecturer.getSelectedItem().toString();

            //JOptionPane.showMessageDialog(null, id);
            co_lec.select(id);
            co_lec.setCourse(Et_Course);
            co_lec.setLecturer(Et_Lecturer);

            co_lec.update();
            displayTable();
            
            clear();

             jButton6.setEnabled(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ET_course;
    private javax.swing.JComboBox<String> ET_lecturer;
    private javax.swing.JTextField course_codin;
    private javax.swing.JTextField course_credit;
    private javax.swing.JTable course_lecturer;
    private javax.swing.JTextField course_title;
    private javax.swing.JTable courses;
    private javax.swing.JComboBox<String> department;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JComboBox<String> level;
    // End of variables declaration//GEN-END:variables

        
    
    
}


