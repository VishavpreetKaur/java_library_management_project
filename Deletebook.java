package Library;
import java.awt.Color;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.*;
public class Deletebook extends JFrame implements ActionListener
{
	JFrame f=new JFrame("Delete Book");
	Deletebook()
	{
		JLabel l1,l2,l3,l4,l5,l6;
		final JTextField BookID,BookName,Author,Publisher,Quantity;
		final JButton b1,b2;
		final JButton g=new JButton("Search");
		g.setBounds(440,140,110,30);f.add(g);
		g.setForeground(Color.magenta);g.setBackground(Color.lightGray);
		g.setFont(new Font ("Times New Roman",Font.BOLD,24));
		l1=new JLabel("Delete Book");
		l2=new JLabel("Book ID");
		l3=new JLabel("Book Name");
		l4=new JLabel("Author");
		l5=new JLabel("Publisher");
		l6=new JLabel("Quantity");
		l1.setFont(new Font ("firte",Font.BOLD,46));
		l1.setForeground(Color.magenta);
		l2.setForeground(Color.darkGray);
		l3.setForeground(Color.darkGray);
		l4.setForeground(Color.darkGray);
		l5.setForeground(Color.darkGray);
		l6.setForeground(Color.darkGray);
		l2.setFont(new Font ("Times New Roman",Font.BOLD,24));
		l3.setFont(new Font ("Times New Roman",Font.BOLD,24));
		l4.setFont(new Font ("Times New Roman",Font.BOLD,24));
		l5.setFont(new Font ("Times New Roman",Font.BOLD,24));
		l6.setFont(new Font ("Times New Roman",Font.BOLD,24));
		l1.setBounds(230,80,400,40);
		l2.setBounds(150,190,100,30);
		l3.setBounds(150,250,120,30);
		l4.setBounds(150,310,120,30);
		l5.setBounds(150,370,100,30);
		l6.setBounds(150,430,100,30);
		f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);f.add(l6);
		BookID=new JTextField();
		BookName=new JTextField();
		Author=new JTextField();
		Publisher=new JTextField();
		Quantity=new JTextField();
		BookID.setBounds(330,190,220,30);
		BookName.setBounds(330,250,220,30);
		Author.setBounds(330,310,220,30);
		Publisher.setBounds(330,370,220,30);
		Quantity.setBounds(330,430,220,30);
		f.add(BookID);f.add(BookName);f.add(Author);f.add(Publisher);f.add(Quantity);
		b1= new JButton("Delete");
		b2= new JButton("Back");
		b1.setForeground(Color.magenta);
		b2.setForeground(Color.magenta);
		b1.setBackground(Color.lightGray);
		b2.setBackground(Color.lightGray);
		b1.setFont(new Font ("Times New Roman",Font.BOLD,24));
		b2.setFont(new Font ("Times New Roman",Font.BOLD,24));
		b1.setBounds(150,510,100,30);f.add(b1);
		b2.setBounds(450,510,100,30);f.add(b2);
		JLabel ll=new JLabel();
		ll.setIcon(new ImageIcon("C:\\untitled1\\src\\Library\\Image\\l12.jpg"));
		ll.setBounds(0,0,700,700);
		f.add(ll);
		f.setSize(700,700);
		f.setLayout(null);
		f.setVisible(true);
		f.setResizable(false);
		g.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					Connection conn=Connectiondemo.getConnection();
					PreparedStatement ps=conn.prepareStatement("select * from addnewbooks where callno='"+BookID.getText()+"'");
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						BookID.setText(rs.getString(1));
						BookName.setText(rs.getString(2));
						Author.setText(rs.getString(3));
						Publisher.setText(rs.getString(4));
						Quantity.setText(rs.getString(5));
        				b1.setEnabled(true);
					}
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(BookID.getText().equals("")||BookName.getText().equals("")||Author.getText().equals("")||Publisher.getText().equals("")||Quantity.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Fill all Columns");	
				}
				else
				{
				try
				{
			        Connection conn=Connectiondemo.getConnection();
			        PreparedStatement ps=conn.prepareStatement("delete from addnewbooks where callno='"+BookID.getText()+"'");
			        ps.executeUpdate();
			        JOptionPane.showMessageDialog(null, "Librarian Record Delete Sucessfully!");
			        BookID.setText("");
			        BookName.setText("");
			        Author.setText("");
			        Publisher.setText("");
			        Quantity.setText("");
			    }
				catch(Exception e)
			    {
			        JOptionPane.showMessageDialog(null, e);
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
		new Deletebook();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{	
	}
}
