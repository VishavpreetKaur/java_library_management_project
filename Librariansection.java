package Library;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Librariansection 
{
	JFrame f=new JFrame();
	Librariansection()
	{
		JLabel c;
		JButton b1,b2,b3,b4,b5,b6,b7,b8;
		final JButton g=new JButton("Back");
		g.setBounds(600,20,80,30);f.add(g);
		g.setForeground(Color.white);g.setBackground(Color.blue);
		g.setFont(new Font ("Times New Roman",Font.BOLD,20));
		c=new JLabel("Librarian Section");
		c.setFont(new Font ("Times New Roman",Font.BOLD,36));
		c.setForeground(Color.cyan);f.add(c);
		c.setBounds(230,100,300,30);
		b1=new JButton("Add Books");
		b2=new JButton("View Books");
		b3=new JButton("Issue Book");
		b4=new JButton("View Issued Books");
		b5=new JButton("Return Book");
		b6=new JButton("Delete Book");
		b7=new JButton("Update Book");
		b8=new JButton("Logout");
		b1.setForeground(Color.white);b2.setForeground(Color.white);b3.setForeground(Color.white);
		b4.setForeground(Color.white);b5.setForeground(Color.white);b6.setForeground(Color.white);b7.setForeground(Color.white);
		b1.setBackground(Color.blue);b2.setBackground(Color.blue);b3.setBackground(Color.blue);
		b4.setBackground(Color.blue);b5.setBackground(Color.blue);b6.setBackground(Color.blue);b7.setBackground(Color.blue);
		b8.setForeground(Color.white);
		b8.setBackground(Color.blue);
		b1.setFont(new Font ("Times New Roman",Font.BOLD,22));
		b2.setFont(new Font ("Times New Roman",Font.BOLD,22));
		b3.setFont(new Font ("Times New Roman",Font.BOLD,22));
		b4.setFont(new Font ("Times New Roman",Font.BOLD,22));
		b5.setFont(new Font ("Times New Roman",Font.BOLD,22));
		b6.setFont(new Font ("Times New Roman",Font.BOLD,22));
		b7.setFont(new Font ("Times New Roman",Font.BOLD,22));
		b8.setFont(new Font ("Times New Roman",Font.BOLD,22));
		b1.setBounds(250,170,220,30);
		b2.setBounds(250,230,220,30);
		b3.setBounds(250,290,220,30);
		b4.setBounds(250,350,220,30);
		b5.setBounds(250,410,220,30);
		b6.setBounds(250,470,220,30);
		b7.setBounds(250,530,220,30);
		b8.setBounds(250,590,220,30);
		f.add(b1);f.add(b2);f.add(b3);f.add(b4);f.add(b5);f.add(b6);f.add(b7);f.add(b8);
		JLabel ll=new JLabel();
		ll.setIcon(new ImageIcon("\\c:\\l8.jpg"));
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
		   new Librarybook();
		   f.dispose();
		}
		});
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
		{
		   viewbook v1=new viewbook();
		   v1.setVisible(true);
		   f.dispose();
		}
		});
		b3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
		{
				Issuebook l1= new Issuebook();
		   f.setVisible(true);
		   f.dispose();
		}
		});
		b4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
		{
		  viewissuebook v2= new viewissuebook();
		  v2.setVisible(true);
		  f.dispose();
		}
		});
		b5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
		{
		   new Returnbook();
		   f.dispose();
		}
		});
		b6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
		{
		   new Deletebook();
		   f.dispose();
		}
		});
		b7.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
		{
		   new Modifybook();
		   f.dispose();
		}
		});
		b8.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
		{
		   System.exit(0);
		   f.dispose();
		}
		});
		g.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
		{
		   new Librarianhome();
		   f.dispose();
		}
		});
	}
	public static void main(String[] args) 
	{
		new Librariansection();
	}

}
