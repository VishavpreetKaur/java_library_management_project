
package Library;
import javax.swing.*;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Adminhome 
{
	JFrame f;
	Adminhome()
	{
		f=new JFrame("Admin Home Page");
		JLabel l1,l2,l3;
		final JTextField a1;
		final JPasswordField a2;
		JButton b1,b2;
		l1=new JLabel("Admin Login Here");
		l1.setFont(new Font ("Times New Roman",Font.BOLD,50));
		//l1.setForeground(Color.blue);
		l2=new JLabel("UserID");
		l3=new JLabel("Password");
		l2.setFont(new Font ("Times New Roman",Font.BOLD,26));
		l3.setFont(new Font ("Times New Roman",Font.BOLD,26));
		l1.setBounds(100,150,450,55);
		l2.setBounds(100,250,200,30);
		l3.setBounds(100,320,200,30);
		f.add(l1);f.add(l2);f.add(l3);
		a1=new JTextField();
		a2=new JPasswordField();
		a1.setBounds(250,250,210,30);
		a2.setBounds(250,320,210,30);
		f.add(a1);f.add(a2);
		b1=new JButton("Login");
		b2=new JButton("Back");
		b1.setForeground(Color.gray);
		b2.setForeground(Color.gray);
		b1.setBackground(Color.white);
		b2.setBackground(Color.white);
		b1.setFont(new Font ("Times New Roman",Font.BOLD,26));
		b2.setFont(new Font ("Times New Roman",Font.BOLD,26));
		b1.setBounds(170,400,100,30);
		b2.setBounds(320,400,100,30);
		f.add(b1);f.add(b2);
		JLabel ll=new JLabel();
		ll.setIcon(new ImageIcon("C:\\untitled1\\src\\Library\\Image\\l14.jpg"));
		ll.setBounds(0,0,600,600);
		f.add(ll);
		f.setSize(600,600);
		f.setLayout(null);  
		f.setVisible(true);
		f.setResizable(true);
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				String user=a1.getText();
				String pw=a2.getText();
				if(a1.getText().equals("")&&a2.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Enter the UserID & Password");
				}
				else if(user.equals("Admin")&&pw.equals("12345"))
				{
					JOptionPane.showMessageDialog(null, "thank u");
					new Adminsection();
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
		new Adminhome();
	}
}
