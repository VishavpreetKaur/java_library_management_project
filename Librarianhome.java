package Library;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Librarianhome 
{
	JFrame f;
	Librarianhome()
	{
		f=new JFrame("Librarian Home Page");
		JLabel l1,l2,l3;
		final JTextField a1;
		final JPasswordField a2;
		JButton b1,b2;
		l1=new JLabel("Librarian Login Here");
		l1.setFont(new Font ("forte",Font.BOLD,50));
		l1.setForeground(Color.yellow);
		l2=new JLabel("UserID");
		l3=new JLabel("Password");
		l2.setForeground(Color.RED);
		l3.setForeground(Color.RED);
		l2.setFont(new Font ("Times New Roman",Font.BOLD,26));
		l3.setFont(new Font ("Times New Roman",Font.BOLD,26));
		l1.setBounds(100,150,500,50);
		l2.setBounds(150,250,200,30);
		l3.setBounds(150,320,200,30);
		f.add(l1);f.add(l2);f.add(l3);
		a1=new JTextField();
		a2=new JPasswordField();
		a1.setBounds(300,250,210,30);
		a2.setBounds(300,320,210,30);
		f.add(a1);f.add(a2);
		b1=new JButton("Sign In");
		b2=new JButton("Back");
		b1.setForeground(Color.RED);b2.setForeground(Color.RED);
		b1.setBackground(Color.yellow);b2.setBackground(Color.yellow);
		b1.setFont(new Font ("Times New Roman",Font.BOLD,26));
		b2.setFont(new Font ("Times New Roman",Font.BOLD,26));
		b1.setBounds(200,400,120,30);
		b2.setBounds(350,400,120,30);
		f.add(b1);f.add(b2);
		
		JLabel ll=new JLabel();

		ll.setIcon(new ImageIcon("C:\\untitled1\\src\\Library\\Image\\l14.jpg"));
		ll.setBounds(0,0,700,600);
		f.add(ll);
		
		
		f.setSize(700,600);
		f.setLayout(null);
		f.setVisible(true);
		f.setResizable(false);
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				    String user=a1.getText();
				    String pw=a2.getText();
					if(a1.getText().equals("")&&a2.getText().equals(""))
				    {
					  JOptionPane.showMessageDialog(null,"Enter the userID & Password");
				    }
					else if(user.equals("Lib")&&pw.equals("123456"))
					{
						JOptionPane.showMessageDialog(null, "thank u");
						  new Librariansection();
					}
			        else
				    {
					   JOptionPane.showMessageDialog(null,"Enter the Correct userID & Password");
				    }
					f.dispose();
			}
		});
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new Adminstart();
				f.dispose();
			}
		});
	}
	public static void main(String[] args) 
	{
		new Librarianhome();
	}

}
