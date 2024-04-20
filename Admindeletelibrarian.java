package Library;
import Library.Connectiondemo;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class Admindeletelibrarian 
{
	JFrame f=new JFrame("Admin Delete Librarian");
	public Admindeletelibrarian()
	{
		JLabel c,l1,l2,l3,l4,l5,l6,l7;
		final JTextField userID,password,name,emailID,address,city,contact;
		final JButton g=new JButton("Search");
		g.setBounds(360,80,100,30);f.add(g);
		g.setForeground(Color.GREEN);g.setBackground(Color.orange);
		g.setFont(new Font ("Times New Roman",Font.BOLD,20));
		c=new JLabel("Delete Librarian");
		l1=new JLabel("User ID");
		l2=new JLabel("Password");
		l3=new JLabel("Name");
		l4=new JLabel("Email ID");
		l5=new JLabel("Address");
		l6=new JLabel("City");
		l7=new JLabel("Contact");
		c.setFont(new Font ("Times New Roman",Font.BOLD,36));
		c.setForeground(Color.GREEN);
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
		c.setBounds(170,40,350,30);
		l1.setBounds(120,120,100,30);
		l2.setBounds(120,180,100,30);
		l3.setBounds(120,240,100,30);
		l4.setBounds(120,300,100,30);
		l5.setBounds(120,360,100,30);
		l6.setBounds(120,420,100,30);
		l7.setBounds(120,480,100,30);
		f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);f.add(l6);f.add(l7);f.add(c);
		userID=new JTextField();
		password=new JTextField();
		name=new JTextField();
		emailID=new JTextField();
		address=new JTextField();
		city=new JTextField();
		contact=new JTextField();
		userID.setBounds(290,120,170,30);
    	password.setBounds(290,180,170,30);
		name.setBounds(290,240,170,30);
		emailID.setBounds(290,300,170,30);
		address.setBounds(290,360,170,30);
		city.setBounds(290,420,170,30);
		contact.setBounds(290,480,170,30);
		f.add(userID);f.add(password);f.add(name);f.add(emailID);f.add(address);f.add(city);f.add(contact);
		final JButton b1=new JButton("Delete");
		JButton b2=new JButton("Back");
		b1.setForeground(Color.GREEN);
		b2.setForeground(Color.GREEN);
		b1.setBackground(Color.orange);
		b2.setBackground(Color.orange);
		b1.setFont(new Font ("Times New Roman",Font.BOLD,22));
		b2.setFont(new Font ("Times New Roman",Font.BOLD,22));
		b1.setBounds(120,540,100,30);
    	b2.setBounds(360,540,100,30);
		f.add(b1);f.add(b2);
		JLabel i=new JLabel();
		i.setIcon(new ImageIcon("C:\\untitled1\\src\\Library\\Image\\l8.jpg"));
		i.setBounds(0,0,600,650);
		f.add(i);
		g.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
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
				        PreparedStatement ps=conn.prepareStatement("select * from addlibrarian where userid='"+userID.getText()+"'");
				        ResultSet rs=ps.executeQuery();
				        while(rs.next())
				        {
				        userID.setText(rs.getString(1));
				        password.setText(rs.getString(2));
				        name.setText(rs.getString(3));
				        emailID.setText(rs.getString(4));
				        address.setText(rs.getString(5)); 
				        city.setText(rs.getString(6));
				        contact.setText(rs.getString(7));
				        b1.setEnabled(true);
				        }
				        }
				 		catch(Exception e)
				 		{
				        JOptionPane.showMessageDialog(null, e);
				        }
				}
			}
		});
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					Connection conn=Connectiondemo.getConnection();
					PreparedStatement ps=conn.prepareStatement("delete from addlibrarian where userid='"+userID.getText()+"'");
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Librarian Record Delete Sucessfully!");
					userID.setText("");
					password.setText("");
					name.setText("");
					emailID.setText("");
					address.setText("");
					city.setText("");
					contact.setText("");
					b1.setEnabled(false);
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
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
	f.setLayout(null);
	f.setVisible(true);
	f.setResizable(true);
	f.setSize(600,650);
}
	public static void main(String[] args) 
	{
		new Admindeletelibrarian();
	}

}
