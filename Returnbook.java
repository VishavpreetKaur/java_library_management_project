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
public class Returnbook
{
	JFrame f=new JFrame("Return Book");
	Returnbook()
	{
		final JLabel l1,l2,l3,l4,l5,l6;
		final JTextField BookID,StudentID,StudentName,Contact,Branch;
		final JButton b1,b2;
		final JButton g=new JButton("Search");
		g.setBounds(450,120,100,30);f.add(g);
		g.setForeground(Color.GREEN);g.setBackground(Color.orange);
		g.setFont(new Font ("Times New Roman",Font.BOLD,22));
		l1=new JLabel("Return Book");
		l2=new JLabel("Book ID");
		l3=new JLabel("Student ID");
		l4=new JLabel("Student Name");
		l5=new JLabel("Contact");
		l6=new JLabel("Branch");
		l1.setFont(new Font ("Times New Roman",Font.BOLD,46));
		l1.setForeground(Color.orange);
		l2.setFont(new Font ("Times New Roman",Font.BOLD,22));
		l3.setFont(new Font ("Times New Roman",Font.BOLD,22));
		l4.setFont(new Font ("Times New Roman",Font.BOLD,22));
		l5.setFont(new Font ("Times New Roman",Font.BOLD,22));
		l6.setFont(new Font ("Times New Roman",Font.BOLD,22));
		l2.setForeground(Color.GREEN);l3.setForeground(Color.GREEN);l4.setForeground(Color.GREEN);
		l5.setForeground(Color.GREEN);l6.setForeground(Color.GREEN);
		l1.setBounds(220,60,400,50);
		l2.setBounds(150,170,120,30);
		l3.setBounds(150,230,120,30);
		l4.setBounds(150,290,140,30);
		l5.setBounds(150,350,120,30);
		l6.setBounds(150,410,120,30);
		f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);f.add(l6);
		BookID=new JTextField();
		StudentID=new JTextField();
		StudentName=new JTextField();
		Contact=new JTextField();
		Branch=new JTextField();
		BookID.setBounds(350,170,200,30);
		StudentID.setBounds(350,230,200,30);
		StudentName.setBounds(350,290,200,30);
		Contact.setBounds(350,350,200,30);
		Branch.setBounds(350,410,200,30);
		f.add(BookID);f.add(StudentID);f.add(StudentName);f.add(Contact);f.add(Branch);
		b1= new JButton("Return");
		b1.setBounds(150,500,130,30);f.add(b1);
		b2= new JButton("Back");
		b1.setForeground(Color.GREEN);b2.setForeground(Color.GREEN);
		b1.setBackground(Color.orange);b2.setBackground(Color.orange);
		b1.setFont(new Font ("Times New Roman",Font.BOLD,22));
		b2.setFont(new Font ("Times New Roman",Font.BOLD,22));
		b2.setBounds(410,500,130,30);f.add(b2);
		JLabel ll=new JLabel();
		ll.setIcon(new ImageIcon("C:\\untitled1\\src\\Library\\Image\\l13.jpg"));
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
					PreparedStatement ps=conn.prepareStatement("select * from issuebooks where callno='"+BookID.getText()+"'");
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						BookID.setText(rs.getString(1));
						StudentID.setText(rs.getString(2));
						StudentName.setText(rs.getString(3));
						Contact.setText(rs.getString(4));
						Branch.setText(rs.getString(5));
        				b1.setEnabled(true);
					}
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
          final String Bookid=BookID.getText();
       b1.addActionListener(new ActionListener()
       {
    		public void actionPerformed(ActionEvent arg0)
    		{
    			if(BookID.getText().equals("")||StudentID.getText().equals("")||StudentName.getText().equals("")||Contact.getText().equals("")||Branch.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Fill all Columns");	
				}
				else
				{
    			int ino = 0;
				try{
    			       Connection conn=Connectiondemo.getConnection();
    			       PreparedStatement ps=conn.prepareStatement("select * from addnewbooks where callno='"+Bookid+"'");
    			       ResultSet rs=ps.executeQuery();
    			       while(rs.next())
    			       {
    			       String qno = rs.getString(5);
    			       ino=rs.getInt(6);
    			       int qno2 = Integer.parseInt(qno);
    			       }
    			       
    			       }
    			       catch(Exception e){
    			       JOptionPane.showMessageDialog(null,e);
    			       }
    			       
    			try
    			{
    				ino--;
    				Connection conn=Connectiondemo.getConnection();
    				PreparedStatement ps=conn.prepareStatement("delete from issuebooks where callno='"+BookID.getText()+"' and studentid='"+StudentID.getText()+"'");
    				PreparedStatement ps1=conn.prepareStatement("update addnewbooks set issue='"+ino+"' where callno='"+Bookid+"'");
    				ps.executeUpdate();
    				ps1.executeUpdate();
    				JOptionPane.showMessageDialog(null, "Book Return Sucessfully!");
    				BookID.setText("");
    				StudentID.setText("");
    				StudentName.setText("");
    				Contact.setText("");
    				Branch.setText("");
    				b1.setEnabled(false);
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
		new Returnbook();
	}

}
