package Library;
import Library.Librarybook;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.*;
public class Librarybook 
{
	JFrame f=new JFrame("Add New Book");
	Librarybook()
	{
		JLabel l1,l2,l3,l4,l5,l6;
		final JTextField BookID,BookName,Author,Publisher,Quantity;
		JButton b1,b2;
		l1=new JLabel("Add Book");
		l2=new JLabel("Book ID");
		l3=new JLabel("Book Name");
		l4=new JLabel("Author");
		l5=new JLabel("Publisher");
		l6=new JLabel("Quantity");
		l1.setFont(new Font ("Times New Roman",Font.BOLD,36));
		l1.setForeground(Color.RED);
		l2.setFont(new Font ("Times New Roman",Font.BOLD,22));
		l3.setFont(new Font ("Times New Roman",Font.BOLD,22));
		l4.setFont(new Font ("Times New Roman",Font.BOLD,22));
		l5.setFont(new Font ("Times New Roman",Font.BOLD,22));
		l6.setFont(new Font ("Times New Roman",Font.BOLD,22));
		l2.setForeground(Color.BLUE);		l3.setForeground(Color.BLUE);		l4.setForeground(Color.BLUE);
		l5.setForeground(Color.BLUE);		l6.setForeground(Color.BLUE);
		l1.setBounds(220,90,250,30);
		l2.setBounds(100,150,100,30);
		l3.setBounds(100,200,120,30);
		l4.setBounds(100,250,100,30);
		l5.setBounds(100,300,100,30);
		l6.setBounds(100,350,100,30);
		f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);f.add(l6);
		BookID=new JTextField();
		BookName=new JTextField();
		Author=new JTextField();
		Publisher=new JTextField();
		Quantity=new JTextField();
		BookID.setBounds(250,150,220,30);
		BookName.setBounds(250,200,220,30);
		Author.setBounds(250,250,220,30);
		Publisher.setBounds(250,300,220,30);
		Quantity.setBounds(250,350,220,30);
		f.add(BookID);f.add(BookName);f.add(Author);f.add(Publisher);f.add(Quantity);
		b1= new JButton("Insert");
		b2= new JButton("Back");
		b1.setForeground(Color.BLUE);		b2.setForeground(Color.BLUE);
		b1.setBackground(Color.red);		b2.setBackground(Color.red);
		b1.setFont(new Font ("Times New Roman",Font.BOLD,22));
		b2.setFont(new Font ("Times New Roman",Font.BOLD,22));
		b1.setBounds(140,420,90,30);f.add(b1);
		b2.setBounds(340,420,90,30);f.add(b2);
		JLabel ll=new JLabel();
		ll.setIcon(new ImageIcon("C:\\untitled1\\src\\Library\\Image\\l14.jpg\\"));
		ll.setBounds(10,10,1000,900);
		f.add(ll);
		f.setSize(600,600);
		f.setLayout(null);
		f.setVisible(true);
		f.setResizable(true);
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(BookID.getText().equals("")||BookName.getText().equals("")||Author.getText().equals("")||Publisher.getText().equals("")||Quantity.getText().equals(""))
		        {
		        JOptionPane.showMessageDialog(null, "Please fill all columns");
		        }
		        else if(BookID.getText().matches("[a-zA-Z]+")||Quantity.getText().matches("[a-zA-Z]+"))
		    {
		     JOptionPane.showMessageDialog(null, "Enter Number Filed callno and quantity!");
		    }
		    else{
		        try{
		        Connection conn=Connectiondemo.getConnection();
		        PreparedStatement ps=conn.prepareStatement("insert into addnewbooks values(?,?,?,?,?,?)");
		        ps.setString(1, BookID.getText());
		        ps.setString(2,BookName.getText());
		        ps.setString(3, Author.getText());
		        ps.setString(4, Publisher.getText());
		        ps.setString(5,Quantity.getText());
				ps.setInt(6,0);


				ps.executeUpdate();
		        JOptionPane.showMessageDialog(null,"Add Books Sucessfully");
		        BookID.setText("");
		        BookName.setText("");
		        Author.setText("");
		        Publisher.setText("");
		        Quantity.setText("");
		        }catch(Exception e1){
		        JOptionPane.showMessageDialog(null, e1);
		        }
		        }				
			}
		});
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
		   new Librariansection();
		   f.dispose();
		}
		});
		
	}
	public static void main(String[] args) 
	{
		 try {
	            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Librarybook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Librarybook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Librarybook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(Librarybook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new Librarybook().setVisible(true);
	            }
	        });
	}
	    protected void setVisible(boolean b) {
		
		
	}
	}
