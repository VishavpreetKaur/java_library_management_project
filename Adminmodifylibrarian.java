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

public class Adminmodifylibrarian 
{
	JFrame f=new JFrame("Update Librarian");
	public Adminmodifylibrarian()
	{
		JLabel c,l1,l2,l3,l4,l5,l6,l7;
		final JTextField userid,password,name,email,address,city,contact;
		final JButton g=new JButton("Search");
		g.setBounds(400,120,100,30);f.add(g);
		g.setForeground(Color.blue);g.setBackground(Color.CYAN);
		g.setFont(new Font ("Times New Roman",Font.BOLD,20));
		c=new JLabel(" Update Librarian");
		l1=new JLabel("User ID");
		l2=new JLabel("Password");
		l3=new JLabel("Name");
		l4=new JLabel("Email");
		l5=new JLabel("Address");
		l6=new JLabel("City");
		l7=new JLabel("Contact");
		c.setFont(new Font ("Times New Roman",Font.BOLD,46));
		c.setForeground(Color.cyan);
		l1.setForeground(Color.blue);
		l2.setForeground(Color.blue);
		l3.setForeground(Color.blue);
		l4.setForeground(Color.blue);
		l5.setForeground(Color.blue);
		l6.setForeground(Color.blue);
		l7.setForeground(Color.blue);
		l1.setFont(new Font ("Times New Roman",Font.BOLD,22));
		l2.setFont(new Font ("Times New Roman",Font.BOLD,22));
		l3.setFont(new Font ("Times New Roman",Font.BOLD,22));
		l4.setFont(new Font ("Times New Roman",Font.BOLD,22));
		l5.setFont(new Font ("Times New Roman",Font.BOLD,22));
		l6.setFont(new Font ("Times New Roman",Font.BOLD,22));
        l7.setFont(new Font ("Times New Roman",Font.BOLD,22));
		c.setBounds(150,60,450,50);
		l1.setBounds(150,160,100,30);
		l2.setBounds(150,220,100,30);
		l3.setBounds(150,280,100,30);
		l4.setBounds(150,340,100,30);
		l5.setBounds(150,400,100,30);
		l6.setBounds(150,460,100,30);
		l7.setBounds(150,520,100,30);f.add(c);
		f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);f.add(l6);f.add(l7);
		userid=new JTextField();
		password=new JTextField();
		name=new JTextField();
		email=new JTextField();
		address=new JTextField();
		city=new JTextField();
		contact=new JTextField();
		userid.setBounds(350,160,170,30);
    	password.setBounds(350,220,170,30);
		name.setBounds(350,280,170,30);
		email.setBounds(350,340,170,30);
		address.setBounds(350,400,170,30);
		city.setBounds(350,460,170,30);
		contact.setBounds(350,520,170,30);
		f.add(userid);f.add(password);f.add(name);f.add(email);f.add(address);f.add(city);f.add(contact);
		final JButton b1=new JButton("Update");
		JButton b2=new JButton("Back");
		b1.setForeground(Color.blue);
		b2.setForeground(Color.blue);
		b1.setBackground(Color.CYAN);
		b2.setBackground(Color.CYAN);
		b1.setFont(new Font ("Times New Roman",Font.BOLD,22));
		b2.setFont(new Font ("Times New Roman",Font.BOLD,22));
		b1.setBounds(150,580,130,30);
    	b2.setBounds(380,580,130,30);
		f.add(b1);f.add(b2);
		JLabel i=new JLabel();
		i.setIcon(new ImageIcon("/c:/l7.jpg"));
		i.setBounds(0,0,700,700);
		f.add(i);
		g.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String m1=contact.getText();
				if(userid.getText().equals("")||password.getText().equals("")||name.getText().equals("")||email.getText().equals("")||address.getText().equals("")||city.getText().equals("")||contact.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Fill all Columns");	
				}
				else if(m1.length()<10||m1.length()>10)
				{
					JOptionPane.showMessageDialog(null,"Enter Number in Contact Field");
				}
				else
				{
			try
			{
				Connection conn=Connectiondemo.getConnection();
	        	PreparedStatement ps=conn.prepareStatement("select * from addlibrarian where userid='"+userid.getText()+"'");
	        	ResultSet rs=ps.executeQuery();
	        	while(rs.next())
	        	{
	        		userid.setText(rs.getString(1));
	        		password.setText(rs.getString(2));
	        		name.setText(rs.getString(3));
	        		email.setText(rs.getString(4));
	        		address.setText(rs.getString(5));
	        		city.setText(rs.getString(6));
	        		contact.setText(rs.getString(7));
	        		b1.setEnabled(true);
	        		userid.setEditable(false);
	        		password.setEditable(false);
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
	        String userid1=userid.getText();
	        String password1=password.getText();
	        String name1=name.getText();
	        String email1=email.getText();
	        String address1=address.getText();
	        String city1=city.getText();
	        String contact1=contact.getText();
	        try
	        {
	        	Connection conn=Connectiondemo.getConnection();
	        	PreparedStatement ps=conn.prepareStatement("update addlibrarian set userid='"+userid1+"',password='"+password1+"',name='"+name1+"',email='"+email1+"',address='"+address1+"',city='"+city1+"',contact='"+contact1+"' where userid='"+userid1+"'");
	        	ps.executeUpdate();
	        	JOptionPane.showMessageDialog(null, "Librarian Detail Update Suceessfully!");
	        }
	        catch(Exception e)
	        {
	        	JOptionPane.showMessageDialog(null, e);
	        }
	        f.dispose();
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
	f.setSize(700,700);
}
	public static void main(String[] args) 
	{
		new Adminmodifylibrarian();
	}

}
