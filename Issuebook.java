package Library;
import Library.Connectiondemo;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
public class Issuebook
{
	JFrame f=new JFrame("Issue Book");
	Issuebook()
	{
		final JLabel l1,l2,l3,l4,l5,l6;
		final JTextField BookID;
		final JTextField StudentID, StudentName, Contact, Branch;
		final JButton b1,b2;
		l1=new JLabel("Issue Book");
		l2=new JLabel("Book ID");
		l3=new JLabel("Student ID");
		l4=new JLabel("Student Name");
		l5=new JLabel("Contact");
		l6=new JLabel("Branch");
		l1.setFont(new Font ("Times New Roman",Font.BOLD,46));
		l1.setForeground(Color.orange);
		l2.setForeground(Color.orange);
		l3.setForeground(Color.orange);
		l3.setForeground(Color.orange);
		l4.setForeground(Color.orange);
		l5.setForeground(Color.orange);
		l6.setForeground(Color.orange);
		l2.setFont(new Font ("Times New Roman",Font.BOLD,24));
		l3.setFont(new Font ("Times New Roman",Font.BOLD,24));
		l4.setFont(new Font ("Times New Roman",Font.BOLD,24));
		l5.setFont(new Font ("Times New Roman",Font.BOLD,24));
		l6.setFont(new Font ("Times New Roman",Font.BOLD,24));
		l1.setBounds(230,100,250,40);
		l2.setBounds(150,200,120,30);
		l3.setBounds(150,270,120,30);
		l4.setBounds(150,340,160,30);
		l5.setBounds(150,410,120,30);
		l6.setBounds(150,480,120,30);
		f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);f.add(l6);
		BookID=new JTextField();
		StudentID=new JTextField();
		StudentName=new JTextField();
		Contact=new JTextField();
		Branch=new JTextField();
		BookID.setBounds(350,200,200,30);
		StudentID.setBounds(350,270,200,30);
		StudentName.setBounds(350,340,200,30);
		Contact.setBounds(350,410,200,30);
		Branch.setBounds(350,480,200,30);
		f.add(BookID);f.add(StudentID);f.add(StudentName);f.add(Contact);f.add(Branch);
		b1= new JButton("Issue ");
		b1.setBounds(150,550,120,30);f.add(b1);
		b2= new JButton("Back");
		b1.setForeground(Color.orange);b2.setForeground(Color.orange);
		//b1.setBackground(Color.green);b2.setBackground(Color.green);
		b1.setFont(new Font ("Times New Roman",Font.BOLD,24));
		b2.setFont(new Font ("Times New Roman",Font.BOLD,24));
		b2.setBounds(420,550,120,30);f.add(b2);
		JLabel ll=new JLabel();
		ll.setIcon(new ImageIcon("C:\\untitled1\\src\\Library\\Image\\issuebooks.jpg"));
		ll.setBounds(0,0,700,700);
		f.add(ll);
		f.setSize(700,700);
		f.setLayout(null);
		f.setVisible(true);
		f.setResizable(false);
		b1.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0)
			{
				// String qno;
				// int ino = 0,qno2 = 0;
				if(BookID.getText().equals("")||StudentID.getText().equals("")||StudentName.getText().equals("")||Contact.getText().equals("")||Branch.getText().equals("")||Contact.getText().matches("[a-zA-Z]+")||BookID.getText().matches("[a-zA-Z]+"))
				{
					JOptionPane.showMessageDialog(null,"Please fill All the Columns and enter number in field BookID and Student Contact !");
				}
				else{
					String callno=BookID.getText();
					int k=0;
					try{
						Connection conn=Connectiondemo.getConnection();
						PreparedStatement ps=conn.prepareStatement("select * from addnewbooks where callno=callno");
								ResultSet rs=ps.executeQuery();
						while(rs.next())
						{
							k=1;
						}

					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,e);
					}

					try{
						Connection conn=Connectiondemo.getConnection();
						PreparedStatement ps=conn.prepareStatement("select * from addnewbooks where callno= callno");
								ResultSet rs=ps.executeQuery();
						while(rs.next())
						{
							// qno=rs.getString(2);
						//	ino=rs.getInt(1);
						//	qno2=Integer.parseInt(qno);
						}

					}
					catch(Exception e){
						JOptionPane.showMessageDialog(null,e);

					}

					//////

					if(k==1 /* && ino<qno2 */ )
					{
						try{
							// ino++;
							Connection conn=Connectiondemo.getConnection();
							PreparedStatement ps=conn.prepareStatement("insert into issuebooks values(?,?,?,?,?)");
							// PreparedStatement ps1=conn.prepareStatement("update addnewbooks set issue='"+/*ino+"' where callno=calln");
									ps.setString(1, BookID.getText());
							ps.setString(2, StudentID.getText());
							ps.setString(3, StudentName.getText());
							ps.setString(4, Contact.getText());
							ps.setString(5, Branch.getText());
							ps.executeUpdate();
							// ps1.executeUpdate();
							JOptionPane.showMessageDialog(null,"Book Issued Sucessfully!");
							BookID.setText("");
							StudentID.setText("");
							StudentName.setText("");
							Contact.setText("");
							Branch.setText("");
						}catch(SQLException e){
							JOptionPane.showMessageDialog(null," Sorry Already issuue book!");

						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Book Not Available!");
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
		new Issuebook();
	}
}
