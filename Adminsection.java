package Library;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Adminsection 
{
	JFrame f=new JFrame();
	Adminsection()
	{
		JLabel l=new JLabel("Admin Section");
		l.setBounds(230,100,250,30);
		l.setFont(new Font ("FORTE",Font.BOLD,36));
		l.setForeground(Color.blue);f.add(l);
		JButton b1,b2,b3,b4,b5;
		final JButton g=new JButton("Back");
		g.setBounds(600,10,80,30);f.add(g);
		g.setForeground(Color.blue);g.setBackground(Color.cyan);
		g.setFont(new Font
				("Times New Roman",Font.BOLD,20));
		b1=new JButton("Add Librarian");
		b2=new JButton("View Librarian");
		b3=new JButton("Delete Librarian");
		b4=new JButton("Update Librarian");
		b5=new JButton("Logout");
		b1.setForeground(Color.blue);
		b2.setForeground(Color.blue);
		b3.setForeground(Color.blue);
		b4.setForeground(Color.blue);
		b5.setForeground(Color.blue);
		b1.setBackground(Color.cyan);b2.setBackground(Color.cyan);b3.setBackground(Color.cyan);
		b4.setBackground(Color.cyan);b5.setBackground(Color.cyan);
		b1.setFont(new Font ("Times New Roman",Font.BOLD,22));
		b2.setFont(new Font ("Times New Roman",Font.BOLD,22));
		b3.setFont(new Font ("Times New Roman",Font.BOLD,22));
		b4.setFont(new Font ("Times New Roman",Font.BOLD,22));
		b5.setFont(new Font ("Times New Roman",Font.BOLD,22));
		b1.setBounds(250,150,200,30);
		b2.setBounds(250,230,200,30);
		b3.setBounds(250,310,200,30);
		b4.setBounds(250,390,200,30);
		b5.setBounds(250,470,200,30);
		f.add(b1);f.add(b2);f.add(b3);f.add(b4);f.add(b5);
		JLabel ll=new JLabel();
		ll.setIcon(new ImageIcon("C:\\untitled1\\src\\Library\\Image\\l15.jpg"));
		ll.setBounds(0,0,700,600);
		f.add(ll);
		f.setSize(700,600);
		f.setLayout(null);
		f.setVisible(true);
		f.setResizable(true);
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new Addlibrarian();
				f.dispose();
			}
		});
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				Adminviewlibrarian v=new Adminviewlibrarian();
				v.setVisible(true);
				f.dispose();
			}
		});
		b3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new Admindeletelibrarian();
				f.dispose();
			}
		});
		b4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new Adminmodifylibrarian();
				f.dispose();
			}
		});
		g.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new Adminhome();
				f.dispose();
			}
		});
		b5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);
				f.dispose();
			}
		});	
	}
	public static void main(String[] args) 
	{
		new Adminsection();
	}

}
