package Library;

import Library.Connectiondemo;

import Library.Librariansection;
import Library.viewbook;
import Library.viewbook;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class viewbook 	extends JFrame 
{

	public viewbook() 
	{
        initComponents();
        getContentPane().setBackground(Color.black);
        select();
    }
    public void select()
    {
    	
    	int sr=0;
        String BookID,BookName,Author,Publisher,Quantity;
        int issue;
        DefaultTableModel obj=(DefaultTableModel) table1.getModel();
        try{
        Connection conn=Connectiondemo.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from addnewbooks");
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
        sr++;

            BookID=rs.getString("callno");
        BookName=rs.getString("name");
        Author=rs.getString("author");
        Publisher=rs.getString("publisher");
        Quantity=rs.getString("quantity");
        // issue=rs.getInt("issue");

        obj.addRow(new Object[]{sr,BookID,BookName,Author,Publisher,Quantity,/* issue*/});
        
        }
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
        }

    private void initComponents()
    {
        jScrollPane1 = new JScrollPane();
        table1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        setPreferredSize(new java.awt.Dimension(892, 510));
        setResizable(false);
        getContentPane().setLayout(null);
        table1.setModel(new DefaultTableModel(
            new Object [][] 
            		{
            },
            new String [] 
            		{
                "SR NO.", "BookID", "BookName", "Author", "Publisher", "Quantity",/*"issue"*/
            }
        ));
        jScrollPane1.setViewportView(table1);
        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 58, 886, 380);
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 30)); 
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("Books Details");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(339, 11, 178, 30);
        jButton1.setForeground(new Color(0, 153, 153));
        jButton1.setText("BACK");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(18, 17, 132, 30);
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex) 
        {
            java.util.logging.Logger.getLogger(viewbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (InstantiationException ex) 
        {
            java.util.logging.Logger.getLogger(viewbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) 
        {
            java.util.logging.Logger.getLogger(viewbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (javax.swing.UnsupportedLookAndFeelException ex) 
        {
            java.util.logging.Logger.getLogger(viewbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run()
            {
                new viewbook().setVisible(true);
            }
        });
    }
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private javax.swing.JTable table1;
}
