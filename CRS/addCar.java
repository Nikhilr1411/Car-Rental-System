package CRS;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class addCar
{
    JFrame f = new JFrame("CAR RENTAL SYSTEM");
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
    JButton b,b2;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    public addCar()
    {
        l1 = new JLabel("Car Name");
        l1.setBounds(100,90,150,40);
        f.add(l1);
        tf1 = new JTextField();
        tf1.setBounds(200,100,180,20);
        f.add(tf1);
        l2 = new JLabel("Car model");
        l2.setBounds(100,180,150,40);
        f.add(l2);
        tf2 = new JTextField();
        tf2.setBounds(200,190,180,20);
        f.add(tf2);
        l3 = new JLabel("Register Number");
        l3.setBounds(100,270,150,40);
        f.add(l3);
        tf3 = new JTextField();
        tf3.setBounds(200,280,180,20);
        f.add(tf3);
        l6 = new JLabel("Mileage");
        l6.setBounds(100,360,150,40);
        f.add(l6);
        tf4 = new JTextField();
        tf4.setBounds(200,370,180,20);
        f.add(tf4);
        l4 = new JLabel("Current Damage");
        l4.setBounds(100,450,150,40);
        f.add(l4);
        tf5 = new JTextField();
        tf5.setBounds(200,460,180,20);
        f.add(tf5);
        l6 = new JLabel("Rent");
        l6.setBounds(100,540,150,40);
        f.add(l6);
        tf6 = new JTextField();
        tf6.setBounds(200,550,180,20);
        f.add(tf6);
        b = new JButton("Create");
        b.setBounds(200,630,80,30);
        f.add(b);
        b2 = new JButton("Back");
        b2.setBounds(300,630,80,30);
        f.add(b2);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
		if(tf1.getText().equals("")||tf2.getText().equals("")||tf3.getText().equals("")||tf4.getText().equals("")||tf5.getText().equals("")||tf6.getText().equals(""))
		{
			f.dispose();
			JFrame f1 = new JFrame("INCOMPLETE");
    			JLabel lb;
    			JButton bt;
 
        		lb = new JLabel("FILL ALL OPTIONS");
        		lb.setBounds(180,80,400,30);
        		f1.add(lb);

        		bt = new JButton("OK");
        		bt.setBounds(200,140,80,30);
        		f1.add(bt);
        		bt.addActionListener(new ActionListener()
        		{
            			public void actionPerformed(ActionEvent e)
            			{
                			new admin();
                			f1.dispose();
            			}
       			 });
        		f1.setLayout(null);
        		f1.setVisible(true);
        		f1.setSize(500,300);
        		f1.setLocationRelativeTo(null);
        		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		else
		{
		int carid = 0;
                int flag = 0;
                String line;
                String filename = "C:\\Users\\Nikhil\\OneDrive\\Desktop\\cardetails1.csv";
                try
                {
                    BufferedReader s = new BufferedReader(new FileReader(filename));

                    while((line = s.readLine())!= null)
                    {
                        carid++;

                    }
                    FileWriter file = null;
                    try
                    {
                        file = new FileWriter(filename,true);
                        file.write(carid+","+tf1.getText()+","+tf2.getText()+","+tf3.getText()+","+tf4.getText()+","+tf5.getText()+","+"available"+","+tf6.getText()+"\n");
                        file.flush();
                        file.close();
                        new afterAddCar();
                        f.dispose();
                    }
                    catch (Exception ae)
                    {
                        ae.printStackTrace();
                    }
                    s.close();
                }
                catch (Exception ae)
                {
                    ae.printStackTrace();
                }
		}
            }
        });
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new admin();
                f.dispose();
            }
        });

        f.setLayout(null);
        f.setVisible(true);
        f.setSize(700,800);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
