package CRS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class cancelBook{
    JFrame f = new JFrame("CANCEL BOOKING");
    JTable t;
    JTextField tf;
    JButton b,b2;
    JLabel l;
    JPanel p,bp,cp;
    public cancelBook(String mail)
    {
        int row = 0;

        try
        {
            BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\Nikhil\\OneDrive\\Desktop\\registration1.csv"));
            String line,line1;
            while((line = r.readLine())!=null)
            {
                String[] a = line.split(",");
                if(a[1].equals(mail))
                {
                    if(a[5].equals("booked"))
                        row++;
                }
            }
            r.close();
            BufferedReader r1 = new BufferedReader(new FileReader("C:\\Users\\Nikhil\\OneDrive\\Desktop\\registration1.csv"));
            int ro= -1;
            String[] s ={"ID","MAIL","REG.NO","FROM DATE","TO DATE","STATUS"};
            String[][] c = new String[row][6];
            while((line1 = r1.readLine())!=null)
            {
                String[] a = line1.split(",");
                if(a[1].equals(mail))
                {
                    if(a[5].equals("booked"))
                    {
                        ro++;
                        String[] data = line1.split(",");
                        for(int i=0,j=0;i<6||j<5;i++,j++)
                        {
                            c[ro][j] = data[i];
                        }
                    }
                }
            }

            r1.close();
            t = new JTable(c,s);
            t.setBounds(30,40,100,100);
            p =new JPanel();
            p.setLayout(new BorderLayout());
            JScrollPane sp = new JScrollPane(t);
            p.add(sp,BorderLayout.CENTER);
            f.getContentPane().add(p,BorderLayout.PAGE_START);


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        l = new JLabel("Enter the id of which the date is to be cancelled");
        tf = new JTextField(10);
        cp = new JPanel();
        bp = new JPanel();
        b= new JButton("Back");
        b2= new JButton("OK");
        bp.add(l);
        bp.add(tf);
        cp.add(b2);
        cp.add(b);
        f.getContentPane().add(bp,BorderLayout.CENTER);
        f.getContentPane().add(cp,BorderLayout.SOUTH);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new user(mail);
                f.dispose();
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    BufferedReader r2 = new BufferedReader(new FileReader("C:\\Users\\Nikhil\\OneDrive\\Desktop\\registration1.csv"));
                    int flag = 0;
                    String l1;
                    while((l1 = r2.readLine())!=null)
                    {
                        String[] a = l1.split(",");
                        if(a[1].equals(mail))
                        {
                            if(a[5].equals("booked"))
                            {
                                String[] data = l1.split(",");
                                if(tf.getText().equals(data[0]))
                                {
                                    flag = 1;
                                }
                            }
                        }
                    }
                    r2.close();
                    if(flag == 1)
                    {

                        String filename = "C:\\Users\\Nikhil\\OneDrive\\Desktop\\registration1.csv";
                        String temp1 = "C:\\Users\\Nikhil\\OneDrive\\Desktop\\registration2.csv";
                        File file = new File(filename);
                        File temp = new File(temp1);
                        String l;
                        BufferedReader b = new BufferedReader(new FileReader(file));
                        FileWriter fw  = new FileWriter(temp);
                        while ((l = b.readLine()) != null)
                        {
                            String[] car = l.split(",");
                            if (tf.getText().equals(car[0]))
                            {
                                fw.write(car[0] + "," + car[1] + "," + car[2] + "," + car[3] + "," + car[4] + ",cancelled\n");
                            }
                            else
                            {
                                fw.write(car[0] + "," + car[1] + "," + car[2] + "," + car[3] + "," + car[4] + "," + car[5] + "\n");
                            }
                        }
                        fw.close();
                        b.close();
                        BufferedReader br = new BufferedReader(new FileReader(temp));
                        FileWriter w = new FileWriter(filename);
                        while ((l = br.readLine()) != null)
                        {
                            String[] newcar = l.split(",");
                            w.write(newcar[0] + "," + newcar[1] + "," + newcar[2] + "," + newcar[3] + "," + newcar[4] + "," + newcar[5] +"\n");
                        }
                        w.close();
                        br.close();
                        new afterCancel(mail);
                        f.dispose();
                    }
                    else
                    {
                        new invalidId(mail);
                        f.dispose();
                    }
                }
                catch (Exception e0)
                {
                    e0.printStackTrace();
                }
            }
        });
        f.pack();
        f.setVisible(true);
        f.setSize(700,550);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
