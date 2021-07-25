package CRS;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class adminregistration
{
    public boolean phoneNumberValidation(String s)
    {
        int i,a,c=0;
        a = s.length();
        if(a==10&&(s.charAt(0)=='6'||s.charAt(0)=='7'||s.charAt(0)=='8'||s.charAt(0)=='9'))
        {
            for(i=0;i<a;i++)
            {
                if(Character.isDigit(s.charAt(i)))
                {
                    c++;
                }
            }
        }
        if(c==10)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean emailVerification(String s)
    {
        String id = "",mid = "",last = "";
        int d=0;
        int m;
        int length;
        length = s.length();
        for(int i =0;i<length;i++)
        {

            if(s.charAt(i)=='@')
            {
                break;
            }
            else
            {
                d++;
                id = id+s.charAt(i);
            }
        }
        m=d;
        for(int i=d+1;i<length;i++)
        {
            if(s.charAt(i)=='.')
            {
                break;
            }
            else
            {
                m++;
                mid=mid+s.charAt(i);
            }
        }
        m++;
        for(int i = m+1;i<length;i++)
        {
            last = last+s.charAt(i);
        }
        int idl=0;

        if(((id.charAt(id.length()-1))!='-'||(id.charAt(id.length()-1))!='_'||(id.charAt(id.length()-1))!='.')&&
                ((id.charAt(0))!='-'||(id.charAt(0))!='_'||(id.charAt(0))!='.'));
        {
            for(int i=0;i<id.length();i++)
            {
                if(Character.isDigit(id.charAt(i))||id.charAt(i)=='.'||id.charAt(i)=='-'||id.charAt(i)=='_'||(id.toLowerCase().charAt(i)>='a'&&id.toLowerCase().charAt(i)<='z'))
                {
                    idl++;
                }
            }
        }
        if(idl==id.length()&&(mid.equals("gmail")||mid.equals("yahoo"))&&(last.equals("com")||last.equals("in")))
        {
            return true;
        }
        else
            return false;
    }
    JFrame f1 = new JFrame("VERIFICATION");
    JLabel l;
    JPasswordField p;
    JButton bt,bt1;
    public adminregistration()
    {
    	l = new JLabel("Enter the password");
    	l.setBounds(80,80,120,40);
    	f1.add(l);
    	p = new JPasswordField();
    	p.setBounds(220,90,150,20);
    	f1.add(p);
 
    	bt = new JButton("OK");
        bt.setBounds(150,190,60,30);
        f1.add(bt);
        bt1 = new JButton("Back");
        bt1.setBounds(230,190,80,30);
        f1.add(bt1);
        bt.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(String.valueOf(p.getPassword()).equals("nikhil"))
                {
                    f1.dispose();
                    JFrame f = new JFrame("NEW LOGIN");
                    JTextField tf1,tf2,tf3,tf4,tf5;
                    JButton b,b2;
                    JLabel l1,l2,l3,l4,l5,l6;
                    JPasswordField value1,value2;

                    l1 = new JLabel("First Name");
                    l1.setBounds(100,90,150,40);
                    f.add(l1);
                    tf1 = new JTextField();
                    tf1.setBounds(200,100,180,20);
                    f.add(tf1);
                    l2 = new JLabel("Last Name");
                    l2.setBounds(100,180,150,40);
                    f.add(l2);
                    tf2 = new JTextField();
                    tf2.setBounds(200,190,180,20);
                    f.add(tf2);
                    l3 = new JLabel("Email Id");
                    l3.setBounds(100,270,150,40);
                    f.add(l3);
                    tf3 = new JTextField();
                    tf3.setBounds(200,280,180,20);
                    f.add(tf3);
                    l6 = new JLabel("Phone");
                    l6.setBounds(100,360,150,40);
                    f.add(l6);
                    tf4 = new JTextField("+91");
                    tf4.setBounds(200,370,30,20);
                    f.add(tf4);
                    tf5 = new JTextField();
                    tf5.setBounds(240,370,180,20);
                    f.add(tf5);
                    l4 = new JLabel("New Password");
                    l4.setBounds(100,450,150,40);
                    f.add(l4);
                    value1= new JPasswordField();
                    value1.setBounds(200,460,180,20);
                    f.add(value1);
                    l5 = new JLabel("Re-Enter Password");
                    l5.setBounds(80,540,150,40);
                    f.add(l5);
                    value2 = new JPasswordField();
                    value2.setBounds(200,550,180,20);
                    f.add(value2);
                    b = new JButton("Create");
                    b.setBounds(100,640,80,30);
                    f.add(b);
                    b2 = new JButton("Back");
                    b2.setBounds(300,640,80,30);
                    f.add(b2);
                    b.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent e)
                        {
                            if(tf1.getText().equals("")||tf2.getText().equals("")||tf5.getText().equals("")||tf3.getText().equals("")||String.valueOf(value1.getPassword()).equals(""))
                            {
                                JFrame f2 = new JFrame("INCOMPLETE FILLING");
                                JLabel l;
                                JButton b;
                                {
                                    l = new JLabel("FILL ALL THE OPTIONS");
                                    l.setBounds(180,80,400,30);
                                    f2.add(l);

                                    b = new JButton("OK");
                                    b.setBounds(200,140,80,30);
                                    f2.add(b);
                                    b.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent e)
                                        {
                                            new adminregistration();
                                            f2.dispose();
                                        }
                                    });
                                    f2.setLayout(null);
                                    f2.setVisible(true);
                                    f2.setSize(500,300);
                                    f2.setLocationRelativeTo(null);
                                    f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                }
                                f.dispose();
                            }
                            else
                            {
                            if(phoneNumberValidation(tf5.getText()))
                                    {
                                        if(emailVerification(tf3.getText()))
                                        {
                                            int userid = -1;
                                            int flag = 0;
                                            String line;
                                            String filename = "C:\\Users\\Nikhil\\OneDrive\\Desktop\\user1.csv";
                                            try
                                            {
                                                BufferedReader s = new BufferedReader(new FileReader(filename));

                                                while((line = s.readLine())!= null)
                                                {
                                                    userid++;
                                                    String[] values = line.split(",");
                                                    if((tf3.getText().equals(values[4]))&&(String.valueOf(value1.getPassword()).equals(values[5])))
                                                    {
                                                        flag = 1;
                                                        break;
                                                    }
                                                    else
                                                    {
                                                        flag = 0;
                                                    }
                                                }
                                                if(flag == 1)
                                                {
                                                    new adminexist();
                                                    f.dispose();
                                                }
                                                else
                                                {
                                                    if(String.valueOf(value1.getPassword()).equals(String.valueOf(value2.getPassword())))
                                                    {
                                                        try
                                                        {
                                                            FileWriter file = new FileWriter(filename,true);
                                                            file.write(userid+","+tf1.getText()+","+tf2.getText()+","+tf5.getText()+","+tf3.getText()+","+String.valueOf(value1.getPassword())+","+"admin\n");
                                                            file.flush();
                                                            file.close();
                                                            new afterCreation();
                                                            f.dispose();
                                                        }
                                                        catch (Exception ae)
                                                        {
                                                            ae.printStackTrace();
                                                        }
                                                    }
                                                    else
                                                    {
                                                        JFrame f3 = new JFrame("PASSWORD MISMATCH");
                                                        JLabel l1;
                                                        JButton b;
                                                        {
                                                            l1 = new JLabel("PASSWORD DOESNOT MATCH");
                                                            l1.setBounds(150,80,400,30);
                                                            f3.add(l1);
                                                            b = new JButton("OK");
                                                            b.setBounds(200,130,80,30);
                                                            f3.add(b);
                                                            b.addActionListener(new ActionListener()
                                                            {
                                                                public void actionPerformed(ActionEvent e)
                                                                {
                                                                    new adminregistration();
                                                                    f3.dispose();
                                                                }
                                                            });

                                                            f3.setLayout(null);
                                                            f3.setVisible(true);
                                                            f3.setSize(500,300);
                                                            f3.setLocationRelativeTo(null);
                                                            f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                        }
                                                        f.dispose();
                                                    }
                                                }
                                                s.close();
                                            }
                                            catch (Exception ae)
                                            {
                                                ae.printStackTrace();
                                            }
                                        }
                                        else
                                        {
                                            JFrame f4 = new JFrame("INVALID");
                                            JLabel l1;
                                            JButton b;

                                            {
                                                l1 = new JLabel("ENTER A VALID EMAIL");
                                                l1.setBounds(180,80,400,30);
                                                f4.add(l1);

                                                b = new JButton("OK");
                                                b.setBounds(200,130,80,30);
                                                f4.add(b);
                                                b.addActionListener(new ActionListener()
                                                {
                                                    public void actionPerformed(ActionEvent e)
                                                    {
                                                        new adminregistration();
                                                        f4.dispose();
                                                    }
                                                });


                                                f4.setLayout(null);
                                                f4.setVisible(true);
                                                f4.setSize(500,300);
                                                f4.setLocationRelativeTo(null);
                                                f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                            }
                                            f.dispose();
                                        }
                                    }
                                    else
                                    {
                                        JFrame f5 = new JFrame("INVALID");
                                        JLabel l1;
                                        JButton b;
                                        {
                                            l1 = new JLabel("ENTER A VALID PHONE NUMBER");
                                            l1.setBounds(150,80,400,30);
                                            f5.add(l1);

                                            b = new JButton("OK");
                                            b.setBounds(200,140,80,30);
                                            f5.add(b);
                                            b.addActionListener(new ActionListener()
                                            {
                                                public void actionPerformed(ActionEvent e)
                                                {
                                                    new adminregistration();
                                                    f5.dispose();
                                                }
                                            });


                                            f5.setLayout(null);
                                            f5.setVisible(true);
                                            f5.setSize(500,300);
                                            f5.setLocationRelativeTo(null);
                                            f5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        }
                                        f.dispose();
                                    }
                            }
                        }
                    });
                    b2.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent e)
                        {
                            new login();
                            f.dispose();
                        }
                    });

        			f.setLayout(null);
        			f.setVisible(true);
        			f.setSize(700,800);
        			f.setLocationRelativeTo(null);
        			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
                else
                {
                    new invalidadmin();
                    f1.dispose();
                }
		    }
	    });
        bt1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new login();
                f1.dispose();
            }
        });
	    f1.setLayout(null);
        f1.setVisible(true);
        f1.setSize(500,300);
        f1.setLocationRelativeTo(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    }
}
