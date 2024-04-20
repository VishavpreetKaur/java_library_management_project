package Library;

import Library.Connectiondemo;
import Library.viewissuebook;

import Library.Connectiondemo;
import Library.Librariansection;
import Library.viewissuebook;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


	public class viewissuebook extends JFrame
	{
	    public viewissuebook() 
	    {
	        initComponents();
	        getContentPane().setBackground(Color.black);
	        select();
	    }
	    public void select()
	    {
	        int sr=0;
	    String callno,studentid,studentname,studentcontact,studentbranch;
	    DefaultTableModel obj=(DefaultTableModel) table1.getModel();
	    try{
	    Connection conn=Connectiondemo.getConnection();
	    PreparedStatement ps=conn.prepareStatement("select * from issuebooks");
	    ResultSet rs=ps.executeQuery();
	    while(rs.next())
	    {
	    sr++;
	    callno=rs.getString("callno");
	    studentid=rs.getString("studentid");
	    studentname=rs.getString("studentname");
	    studentcontact=rs.getString("studentcontact");
	    studentbranch=rs.getString("studentbranch");
	    obj.addRow(new Object[]{sr,callno,studentid,studentname,studentcontact,studentbranch});
	    
	    }
	    }catch(Exception e){
	    JOptionPane.showMessageDialog(null, e);
	    }
	    }
	    private void initComponents() {

	        jLabel1 = new JLabel();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        table1 = new javax.swing.JTable();
	        jButton1 = new JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        jLabel1.setFont(new Font("Times New Roman", 1, 30)); // NOI18N
	        jLabel1.setForeground(new Color(255, 255, 255));
	        jLabel1.setText(" Issued Books Details");

	        table1.setModel(new DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	                "SR NO.", "callno", "studentid", "studentname", "studentcontact", "studentbranch"
	            }
	        ));
	        jScrollPane1.setViewportView(table1);

	        jButton1.setBackground(new Color(255, 255, 255));
	        jButton1.setFont(new Font("Tahoma", 0, 18)); // NOI18N
	        jButton1.setForeground(new Color(0, 51, 255));
	        jButton1.setText("BACK");
	        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(20, 20, 20)
	                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(131, 131, 131)
	                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(259, Short.MAX_VALUE))
	            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(jButton1)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(4, 4, 4)))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(42, Short.MAX_VALUE))
	        );

	        pack();
	        setLocationRelativeTo(null);
	    }

	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) 
	    {
	        Librariansection obj=new Librariansection();
	        //obj.setVisible(true);
	        setVisible(false);

	    }
	    public static void main(String args[]) 
	    {    
	        try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(viewissuebook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(viewissuebook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(viewissuebook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(viewissuebook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new viewissuebook().setVisible(true);
	            }
	        });
	    }
	    private JButton jButton1;
	    private JLabel jLabel1;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JTable table1;
	}