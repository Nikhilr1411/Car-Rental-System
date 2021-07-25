package CRS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class returnCar
{
    JFrame f = new JFrame("RETURN");
    JTable t;
    JPanel tp,bp,cp;
    JButton button,bt;
    JLabel label;
    JTextField tf;
    String mail;
    public returnCar()
    {
        try
        {
            int id=0;
            BufferedReader b = new BufferedReader(new FileReader("C:\\Users\\Nikhil\\OneDrive\\Desktop\\registration1.csv"));
            String l;
            String[] c = {"ID","EMAIL","REG.NO","FROM DATE","TO DATE"};
            b.readLine();
            while((l=b.readLine())!=null)
            {
                String[]details = l.split(",");
                if(details[5].equals("booked"))
                {
                    id++;
                }
            }
            b.close();
            int row = -1;
            String[][]r = new String[id][5];
            BufferedReader b1 = new BufferedReader(new FileReader("C:\\Users\\Nikhil\\OneDrive\\Desktop\\registration1.csv"));
            b1.readLine();
            while((l=b1.readLine())!=null)
            {
                String[]details = l.split(",");
                if(details[5].equals("booked"))
                {
                    row++;
                    for(int i =0;i<5;i++)
                    {
                        r[row][i]=details[i];
                    }
                }
            }
            b1.close();
            t= new JTable(r,c);
            JScrollPane p =new JScrollPane(t);
            tp = new JPanel();
            tp.setLayout(new BorderLayout());
            tp.add(p,BorderLayout.CENTER);
            f.getContentPane().add(tp,BorderLayout.PAGE_START);


            label = new JLabel("Enter the id of the car to be returned");
            tf = new JTextField(10);
            cp = new JPanel();
            cp.add(label);
            cp.add(tf);
            f.getContentPane().add(cp, BorderLayout.CENTER);
            bp = new JPanel();
            button = new JButton("Back");
            bt = new JButton("OK");
            bp.add(bt);
            bp.add(button);
            f.getContentPane().add(bp, BorderLayout.SOUTH);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new admin();
                    f.dispose();
                }
            });
            bt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try
                    {
                        int year = 0,date = 0,year1 = 0,date1 = 0,month = 0,month1=0,flag = 0;
                        String regno = null;
                        String l;
                        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\Nikhil\\OneDrive\\Desktop\\registration1.csv"));
                        while ((l = r.readLine()) != null)
                        {
                            String[] a = l.split(",");
                            if (a[5].equals("booked"))
                            {
                                if (a[0].equals(tf.getText()))
                                {
                                    flag = 1;
                                    mail = a[1];
                                    regno = a[2];
                                    String [] cal = a[3].split("-");
                                    String[] cal1 = a[4].split("-");
                                    date = Integer.parseInt(cal[0]);
                                    date1 = Integer.parseInt(cal1[0]);
                                    month = Integer.parseInt(cal[1]);
                                    month1 = Integer.parseInt(cal1[1]);
                                    year = Integer.parseInt(cal[2]);
                                    year1 = Integer.parseInt(cal1[2]);

                                }
                            }
                        }
                        r.close();
                        if (flag == 1)
                        {
                            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Nikhil\\OneDrive\\Desktop\\registration1.csv"));
                            FileWriter fw = new FileWriter("C:\\Users\\Nikhil\\OneDrive\\Desktop\\registration2.csv");
                            while ((l = br.readLine()) != null)
                            {
                                String[] a = l.split(",");
                                if (a[0].equals(tf.getText()))
                                {
                                    fw.write(a[0] + "," + a[1] + "," + a[2] + "," + a[3] + "," + a[4] + "," + "available\n");
                                }
                                else
                                {
                                    fw.write(a[0] + "," + a[1] + "," + a[2] + "," + a[3] + "," + a[4] + "," + a[5]+"\n");
                                }
                            }
                            fw.close();
                            br.close();
                            BufferedReader bb = new BufferedReader(new FileReader("C:\\Users\\Nikhil\\OneDrive\\Desktop\\registration2.csv"));
                            FileWriter w = new FileWriter("C:\\Users\\Nikhil\\OneDrive\\Desktop\\registration1.csv");
                            String s;
                            int r1 = 0;
                            w.write("id,email,regno,from,to,status\n");
                            bb.readLine();
                            while ((s = bb.readLine()) != null)
                            {
                                r1++;
                                String[] d = s.split(",");
                                w.write(r1 + "," + d[1] + "," + d[2] + "," + d[3] + "," + d[4] + "," + d[5] + "\n");
                            }
                            bb.close();
                            w.close();
                            f.dispose();
                            JFrame f1 = new JFrame("RETURNED");

                            BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\Nikhil\\OneDrive\\Desktop\\cardetails1.csv"));
                            String line;
                            String rent=null;
                            while ((line = br1.readLine()) != null)
                            {
                                String[] reg = line.split(",");
                                if (regno.equals(reg[3]))
                                {
                                    rent = reg[7];
                                }
                            }
                            br1.close();
                            String m,m1,d,d0;
                            if(month<10)
                            {
                                m="0"+month;
                            }
                            else
                            {
                                m=""+month;
                            }
                            if(month1<10)
                            {
                                m1="0"+month1;
                            }
                            else
                            {
                                m1=""+month1;
                            }
                            if(date<10)
                            {
                                d0="0"+date;
                            }
                            else
                            {
                                d0=""+date;
                            }
                            if(date1<10)
                            {
                                d="0"+date1;
                            }
                            else
                            {
                                d=""+date1;
                            }
                            LocalDate d1 = LocalDate.parse(year+"-"+m+"-"+d0);
                            LocalDate d2 = LocalDate.parse(year1+"-"+m1+"-"+d);

                            LocalDate d3 = LocalDate.now();
                            long days = ChronoUnit.DAYS.between(d1,d2);
                            long days1 = ChronoUnit.DAYS.between(d2,d3);
                            long re = days1*Integer.parseInt(rent)+1000;

                            if(days1<0)
                            {
                                re=0;
                            }
                            JLabel info = new JLabel("Your car " + regno + " has been successfully returned");
                            info.setBounds(80,60,400,30);

                            JLabel fine = new JLabel("The fine amount is "+re);
                            fine.setBounds(170,100,400,30);
                            f1.add(fine);
                            long ret = ((days + 1)* Integer.parseInt(rent))+re;
                            JLabel cost = new JLabel("The total amount is " + ret);
                            cost.setBounds(170, 140, 400, 30);
                            JButton b = new JButton("OK");
                            b.setBounds(210,190,60,30);
                            f1.add(b);
                            f1.add(info);
                            f1.add(cost);
                            b.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
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
                            new wrongId();
                            f.dispose();
                        }

                    }
                    catch (Exception e0) {
                        e0.printStackTrace();
                    }
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        f.setVisible(true);
        f.setSize(900,550);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
