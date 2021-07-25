package CRS;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class usermain
{
    JFrame f = new JFrame("CAR RENTAL SYSTEM");
    JTextField tf1;
    JButton b,b2,b3;
    JLabel l1,l2;
    JPasswordField value;
    public usermain()
    {
        l1 = new JLabel("Email");
        l1.setBounds(100,50,150,40);
        f.add(l1);
        tf1 = new JTextField();
        tf1.setBounds(200,60,180,20);
        f.add(tf1);
        l2 = new JLabel("Password");
        l2.setBounds(100,140,150,40);
        f.add(l2);
        value= new JPasswordField();
        value.setBounds(200,150,180,20);
        f.add(value);
        b = new JButton("Login");
        b.setBounds(100,230,80,30);
        f.add(b);
        b2 = new JButton("Signup");
        b2.setBounds(200,230,80,30);
        f.add(b2);
	b3 = new JButton("Back");
	b3.setBounds(300,230,80,30);
	f.add(b3);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int flag = 0;
                String line;
                String admin = null;
                String filename = "C:\\Users\\Nikhil\\OneDrive\\Desktop\\user1.csv";
                try
                {
                    BufferedReader s = new BufferedReader(new FileReader(filename));

                    while((line = s.readLine())!= null)
                    {
                        String[] values = line.split(",");
		
                        if((tf1.getText().equals(values[4]))&&(String.valueOf(value.getPassword()).equals(values[5])))
                        {
                            admin = values[6];
                            flag = 1;
                            break;
                        }
                        else
                        {
			    
                            flag = 0;
                        }
                    }
		    
                    if((flag == 1)&&(admin.equals("user")))
                    {
                        
                        new user(tf1.getText());
                        f.dispose();

                    }
                    else
                    {
                        new wronguser();
                        f.dispose();
                    }
                    s.close();
                }
                catch (Exception ae)
                {
                    ae.printStackTrace();
                }
            }
        });
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new registration();
                f.dispose();
            }
        });
	b3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new login();
                f.dispose();
            }
        });
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(550,350);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
