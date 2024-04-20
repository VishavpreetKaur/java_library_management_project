package Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class Addlibrarian extends JFrame implements ActionListener
{
JFrame f=new JFrame();
	public Addlibrarian()
	{
		JLabel c,l1,l2,l3,l4,l5,l6,l7;
		final JTextField userID,password,name,emailID,address,city,contact;
		c=new JLabel("Add Librarian");
		l1=new JLabel("User ID");
		l2=new JLabel("Password");
		l3=new JLabel("Name");
		l4=new JLabel("Email ID");
		l5=new JLabel("Address");
		l6=new JLabel("City");
		l7=new JLabel("Contact");
		c.setFont(new Font ("Times New Roman",Font.BOLD,46));
		c.setForeground(Color.ORANGE);
		l1.setForeground(Color.GREEN);
		l2.setForeground(Color.GREEN);
		l3.setForeground(Color.GREEN);
		l4.setForeground(Color.GREEN);
		l5.setForeground(Color.GREEN);
		l6.setForeground(Color.GREEN);
		l7.setForeground(Color.GREEN);
		l1.setFont(new Font ("Times New Roman",Font.BOLD,22));
		l2.setFont(new Font ("Times New Roman",Font.BOLD,22));
		l3.setFont(new Font ("Times New Roman",Font.BOLD,22));
		l4.setFont(new Font ("Times New Roman",Font.BOLD,22));
		l5.setFont(new Font ("Times New Roman",Font.BOLD,22));
		l6.setFont(new Font ("Times New Roman",Font.BOLD,22));
        l7.setFont(new Font ("Times New Roman",Font.BOLD,22));
		c.setBounds(150,50,400,40);
		l1.setBounds(130,100,100,30);
		l2.setBounds(130,160,100,30);
		l3.setBounds(130,220,100,30);
		l4.setBounds(130,280,100,30);
		l5.setBounds(130,340,100,30);
		l6.setBounds(130,400,100,30);
		l7.setBounds(130,460,100,30);f.add(c);
		f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);f.add(l6);f.add(l7);
		userID=new JTextField();
		password=new JTextField();
		name=new JTextField();
		emailID=new JTextField();
		address=new JTextField();
		city=new JTextField();
		contact=new JTextField();
		userID.setBounds(290,100,170,30);
    	password.setBounds(290,160,170,30);
		name.setBounds(290,220,170,30);
		emailID.setBounds(290,280,170,30);
		address.setBounds(290,340,170,30);
		city.setBounds(290,400,170,30);
		contact.setBounds(290,460,170,30);
		f.add(userID);f.add(password);f.add(name);f.add(emailID);f.add(address);f.add(city);f.add(contact);
		JButton b1=new JButton("Insert");
		JButton b2=new JButton("Back");
		JButton b3=new JButton("Exit");
		b1.setForeground(Color.GREEN);
		b2.setForeground(Color.GREEN);
		b3.setForeground(Color.GREEN);
		b1.setBackground(Color.orange);
		b2.setBackground(Color.orange);
		b3.setBackground(Color.orange);
		b1.setFont(new Font ("Times New Roman",Font.BOLD,22));
		b2.setFont(new Font ("Times New Roman",Font.BOLD,22));
		b3.setFont(new Font ("Times New Roman",Font.BOLD,22));
		b1.setBounds(130,520,90,30);
    	b2.setBounds(250,520,90,30);
    	b3.setBounds(370,520,90,30);
		f.add(b1);f.add(b2);f.add(b3);
		JLabel i=new JLabel();
		i.setIcon(new ImageIcon("C:\\untitled1\\src\\Library\\Image\\l15.jpg") );

		i.setBounds(0,0,600,600);
		f.add(i);
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{	
				String m1=contact.getText();
				if(userID.getText().equals("")||password.getText().equals("")||name.getText().equals("")||emailID.getText().equals("")||address.getText().equals("")||city.getText().equals("")||contact.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Fill all Columns");	
				}
				else if(m1.length()<10||m1.length()>10)
				{
					JOptionPane.showMessageDialog(null,"Enter Number in Contact Field");
				}
				else
				{
				try{
					
			        Connection conn=Connectiondemo.getConnection();
			        PreparedStatement ps=conn.prepareStatement("insert into addlibrarian values(?,?,?,?,?,?,?)");
			        ps.setString(1, userID.getText());
			        ps.setString(2, password.getText());
			        ps.setString(3, name.getText());
			        ps.setString(4, emailID.getText());
			        ps.setString(5, address.getText());
			        ps.setString(6, city.getText());
			        ps.setString(7, contact.getText());
			        ps.executeUpdate();
			        JOptionPane.showMessageDialog(null,"Librarian Added Sucessfully!");
			        userID.setText("");
			        password.setText("");
			        name.setText("");
			        emailID.setText("");
			        address.setText("");
			        city.setText("");
			        contact.setText("");
			        }
				catch(Exception ex)
			        {
			        	JOptionPane.showMessageDialog(null, ex);
			        }
			}
			}
		});
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new Adminsection();
				f.dispose();
			}
		});
		b3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);
				f.dispose();
			}
		});
		f.setLayout(null);
		f.setVisible(true);
		f.setResizable(true);
		f.setSize(600,600);
	}
	public static void main(String[] args)
	{
		new Addlibrarian();
	}
	public void actionPerformed(ActionEvent e) 
	{	
	}
}
