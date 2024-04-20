package Library;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Adminstart 
{
	 JFrame f=new JFrame("Library Management");
	JButton b1,b2;
	Adminstart()
	{
		b1=new JButton("Admin Login");
		b2=new JButton("Librarian Login");
		b1.setBounds(300,280,250,40);
		b2.setBounds(300,480,250,40);
		b1.setFont(new Font("FORTE",Font.BOLD,26));
		b2.setFont(new Font("FORTE",Font.BOLD,26));
		b1.setForeground(Color.black);
		b2.setForeground(Color.black);
		b1.setBackground(Color.lightGray);
		b2.setBackground(Color.lightGray);
		f.add(b1);f.add(b2);
		JLabel ll=new JLabel();
		ll.setIcon(new ImageIcon("C:\\untitled1\\src\\Library\\Image\\l13.jpg"));
		ll.setBounds(0,0,800,800);
		f.add(ll);
		f.setSize(800,800);
		f.setLayout(null);
		f.setVisible(true);
		f.setResizable(true);
		
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
		{
		   new Adminhome();
		   f.dispose();
		}
		});
		b2.addActionListener(new ActionListener()
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
		new Adminstart();
	}

}

