package CRS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class viewBooking{
    JFrame f = new JFrame("BOOKING");
    JTable t;
    JTextField tf;
    JButton b,b2,b3;
    JLabel l;
    JPanel p,bp,cp,p1;
    public viewBooking(String mail)
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
                        for(int i=0;i<6;i++)
                        {
                            c[ro][i] = data[i];
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
        bp = new JPanel();
        p1 = new JPanel();
        b3 = new JButton("Back");
        b= new JButton("Reschedule");
        p1.add(b);
        f.getContentPane().add(p1,BorderLayout.LINE_START);

        bp.add(b3);
        f.getContentPane().add(bp,BorderLayout.LINE_END);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new user(mail);
                f.dispose();
            }
        });
        l = new JLabel("Enter the id of which the date is to be rescheduled");
        tf = new JTextField(10);
        cp = new JPanel();
        b2= new JButton("OK");
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                b.setVisible(false);
                bp.add(l);
                bp.add(tf);
                cp.add(b2);
                cp.add(b3);
                bp.revalidate();
                cp.revalidate();
                f.getContentPane().add(bp,BorderLayout.CENTER);
                f.getContentPane().add(cp,BorderLayout.SOUTH);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    int flag = 0;
                    String l;
                    BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\Nikhil\\OneDrive\\Desktop\\registration1.csv"));
                    while((l = r.readLine())!=null)
                    {
                        String[] a = l.split(",");
                        if(a[1].equals(mail))
                        {
                            if(a[5].equals("booked"))
                            {
                                String[] data = l.split(",");
                                if(data[0].equals(tf.getText()))
                                {
                                    flag = 1;
                                }
                            }
                        }
                    }
                    r.close();
                    if(flag == 1)
                    {
                        new reschedule(tf.getText(),mail);
                        f.dispose();
                    }
                    else
                    {
                        new invalidId(mail);
                        f.dispose();
                    }

                }catch (Exception e2)
                {
                    e2.printStackTrace();
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
