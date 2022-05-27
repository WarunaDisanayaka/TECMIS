/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Admin;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
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
public class Lecture_Marks extends javax.swing.JInternalFrame {
    
    java.sql.Connection con;
    
    /**
     * Creates new form Profiles
     */
    public Lecture_Marks(String dep,String user_id) {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        con=DBConnect.connect();
        PreparedStatement pst;
        ResultSet rs;
        
        this.setSize(1200,800);
        
       
        setStudentId(dep);
        setSubjectId(user_id);
        DisplayMarks();
        
        //imgPath.setVisible(false);
    }
    
    public void tableClick(){
       
    }
    
    public void displayTable(){
        Admin admin=new Admin();
        
       DefaultTableModel model=(DefaultTableModel) marks.getModel();
        
         model.setRowCount(0);
         admin.display();
         
         for (Object data : admin.getData()) {
            model.addRow((Vector)data);
        }
    }
    
     public void DisplayMarks(){
        try {
            String sql="SELECT * FROM marks";
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            
            ResultSetMetaData rsd = (ResultSetMetaData) rs.getMetaData();
            int c = rsd.getColumnCount();
            DefaultTableModel d = (DefaultTableModel)marks.getModel();
            d.setRowCount(0);
            
              while(rs.next())
            {
            
           Vector v2 = new Vector();
            
            
           for(int i=1; i<=c; i++)
           {
           v2.add(rs.getString("student_id"));
           v2.add(rs.getString("course_id"));
           v2.add(rs.getString("quiz01"));
           v2.add(rs.getString("quiz02"));
           v2.add(rs.getString("quiz03"));
           v2.add(rs.getString("quiz04"));
           v2.add(rs.getString("assign1"));
           v2.add(rs.getString("assign2"));
           v2.add(rs.getString("assign3"));
           v2.add(rs.getString("midexam"));
           v2.add(rs.getString("endexamtheory"));
           v2.add(rs.getString("endexamprac"));
           
           } 
               
           d.addRow(v2);
           
               
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    } 
    
    
    public void setStudentId(String dep){   
        
        try {
            String sql="SELECT * FROM users WHERE department=? AND user_role='Student'";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, dep);
            ResultSet rs=pst.executeQuery();
            
            while(rs.next()) { 
                
                Student_id.addItem(rs.getString("user_id"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
       
        
    }
    
     public void setSubjectId(String user_id){
        try {
            String sql="SELECT * FROM course_lecturer WHERE lecturer=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, user_id);
            ResultSet rs=pst.executeQuery();
            
            while(rs.next()) { 
                
                subject_id.setText(rs.getString("course"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
     
   
     
     
    
    
    public void clear(){
            
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
        marks = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        quiz02 = new javax.swing.JTextField();
        quiz01 = new javax.swing.JTextField();
        quiz03 = new javax.swing.JTextField();
        quiz04 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        assignment01 = new javax.swing.JTextField();
        assignment02 = new javax.swing.JTextField();
        assignment03 = new javax.swing.JTextField();
        midexam = new javax.swing.JTextField();
        endExamTheory = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        endExamPrac = new javax.swing.JTextField();
        subject_id = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Student_id = new javax.swing.JComboBox<>();

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
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(1155, 600));

        marks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Subject Id", "Quiz 01", "Quiz 02", "Quiz 03", "Quiz 04", "Assingment 01", "Assingment 02", "Assingment 03", "Mid Exam", "End Exam Theory", "End Exam Practical"
            }
        ));
        marks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                marksMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(marks);

        jLabel11.setText("Student Id");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Quiz");

        jLabel18.setText("Quiz 01");

        jLabel20.setText("Quiz 02");

        jLabel21.setText("Quiz 03");

        jLabel22.setText("Quiz 04");

        quiz03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quiz03ActionPerformed(evt);
            }
        });

        jLabel25.setText("Assingment 02");

        jLabel26.setText("Assingment 03");

        jLabel24.setText("Assingment 01");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Assingment");

        midexam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                midexamActionPerformed(evt);
            }
        });

        endExamTheory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endExamTheoryActionPerformed(evt);
            }
        });

        jLabel27.setText("Mid Exam");

        jLabel28.setText("End Exam Practicle Marks");

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

        jLabel29.setText("End Exam Theory Marks");

        jButton8.setText("Delete");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        endExamPrac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endExamPracActionPerformed(evt);
            }
        });

        subject_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subject_idActionPerformed(evt);
            }
        });

        jLabel12.setText("Subject Id");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1054, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(quiz03, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel12)
                                                .addGap(26, 26, 26)
                                                .addComponent(subject_id, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(jLabel18)
                                                .addGap(36, 36, 36)
                                                .addComponent(quiz01, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel22)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(quiz04, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel20)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(quiz02, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGap(51, 51, 51))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addGap(24, 24, 24)
                        .addComponent(Student_id, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(38, 38, 38)
                                .addComponent(assignment01))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(38, 38, 38)
                                .addComponent(assignment02))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(38, 38, 38)
                                .addComponent(assignment03)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel27)
                                .addGap(38, 38, 38))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(midexam, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(endExamTheory, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(endExamPrac, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(172, 172, 172))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8)
                        .addContainerGap(509, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(Student_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(subject_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)
                            .addComponent(assignment01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel25)
                                    .addComponent(assignment02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(assignment03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26))
                                .addGap(11, 11, 11))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(quiz01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(quiz02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(midexam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(endExamTheory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(endExamPrac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(quiz03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(quiz04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );

        jTabbedPane1.addTab("Marks", jPanel3);

        getContentPane().add(jTabbedPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void marksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_marksMouseClicked
        try {
            DefaultTableModel d = (DefaultTableModel)marks.getModel();
            int Index=marks.getSelectedRow();
            
            Student_id.setSelectedItem(d.getValueAt(Index, 0));
            subject_id.setText((String) d.getValueAt(Index, 1));
            quiz01.setText((String) d.getValueAt(Index, 2));
            quiz02.setText((String) d.getValueAt(Index, 3));
            quiz03.setText((String) d.getValueAt(Index, 4));
            quiz04.setText((String) d.getValueAt(Index, 5));
            
            assignment01.setText((String) d.getValueAt(Index, 6));
            assignment02.setText((String) d.getValueAt(Index, 7));
            assignment03.setText((String) d.getValueAt(Index, 8));
            
            midexam.setText((String) d.getValueAt(Index, 9));
            endExamTheory.setText((String) d.getValueAt(Index, 10));
            endExamPrac.setText((String) d.getValueAt(Index, 11));
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_marksMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            Users std=new Users();
            DefaultTableModel d = (DefaultTableModel)marks.getModel();
            int row=marks.getSelectedRow();
            int id=(int) marks.getValueAt(row, 0);
            //JOptionPane.showMessageDialog(null, row);
            int count=marks.getRowCount();

            //JOptionPane.showMessageDialog(null, id);

            std.delete(id);
            //displayStudent();
            clear();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            Users std=new Users();
            DefaultTableModel d = (DefaultTableModel)marks.getModel();
            int row=marks.getSelectedRow();
            int id=(int) marks.getValueAt(row, 0);
            //JOptionPane.showMessageDialog(null, row);
            int count=marks.getRowCount();

            //JOptionPane.showMessageDialog(null, id);
            

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
          String student_id=Student_id.getSelectedItem().toString();
          String course_id=subject_id.getText();
          Float quiz01=Float.parseFloat(this.quiz01.getText());
          Float quiz02=Float.parseFloat(this.quiz02.getText());
          Float quiz03=Float.parseFloat(this.quiz03.getText());
          Float quiz04=Float.parseFloat(this.quiz03.getText());
          
          Float assignment01=Float.parseFloat(this.assignment01.getText());
          Float assignment02=Float.parseFloat(this.assignment02.getText());
          Float assignment03=Float.parseFloat(this.assignment03.getText());
          
          Float midexam=Float.parseFloat(this.midexam.getText());
          Float endexamtheory=Float.parseFloat(this.endExamTheory.getText());
          Float endexamprac=Float.parseFloat(this.endExamPrac.getText());
          
          try {
            String sql="INSERT INTO `marks`(`student_id`, `course_id`, `quiz01`, `quiz02`, `quiz03`, `quiz04`, `assign1`, `assign2`, `assign3`, `midexam`, `endexamtheory`, `endexamprac`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, student_id);
            pst.setString(2, course_id);
            pst.setFloat(3, quiz01);
            pst.setFloat(4, quiz02);
            pst.setFloat(5, quiz03);
            pst.setFloat(6, quiz04);
            pst.setFloat(7, assignment01);
            pst.setFloat(8, assignment02);
            pst.setFloat(9, assignment03);
            pst.setFloat(10, midexam);
            pst.setFloat(11, endexamtheory);
            pst.setFloat(12, endexamprac);
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Saved!");
              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
          
          
          
          
    }//GEN-LAST:event_jButton6ActionPerformed

    private void midexamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_midexamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_midexamActionPerformed

    private void endExamTheoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endExamTheoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endExamTheoryActionPerformed

    private void endExamPracActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endExamPracActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endExamPracActionPerformed

    private void subject_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subject_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subject_idActionPerformed

    private void quiz03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quiz03ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quiz03ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Student_id;
    private javax.swing.JTextField assignment01;
    private javax.swing.JTextField assignment02;
    private javax.swing.JTextField assignment03;
    private javax.swing.JTextField endExamPrac;
    private javax.swing.JTextField endExamTheory;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable marks;
    private javax.swing.JTextField midexam;
    private javax.swing.JTextField quiz01;
    private javax.swing.JTextField quiz02;
    private javax.swing.JTextField quiz03;
    private javax.swing.JTextField quiz04;
    private javax.swing.JTextField subject_id;
    // End of variables declaration//GEN-END:variables

        
    
    
}

