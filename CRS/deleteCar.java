package CRS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class deleteCar
{
    JFrame f = new JFrame("DELETE CAR");
    JButton b,b3;
    JLabel label;
    JTextField tf;
    JTable t;
    JPanel tp,bp,cp;
    public deleteCar()
    {
        String[] c = {"CAR ID","CAR NAME","CAR MODEL","REG.NO","MILEAGE","CURRENT DAMAGE","STATUS","RENT"};
        String line;
        int r = 0;
        File file = new File("C:\\Users\\Nikhil\\OneDrive\\Desktop\\cardetails1.csv");
        String filename = "C:\\Users\\Nikhil\\OneDrive\\Desktop\\cardetails1.csv";
        File temp = new File("C:\\Users\\Nikhil\\OneDrive\\Desktop\\cardetails2.csv");
        try
        {
            BufferedReader s = new BufferedReader(new FileReader(filename));
            s.readLine();
            while((line = s.readLine())!=null)
            {
                r++;
            }
            s.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        String[][] ro = new String[r][8];
        int row = -1;
        try
        {
            BufferedReader b = new BufferedReader(new FileReader(filename));
            b.readLine();
            while((line=b.readLine())!=null)
            {
                row++;
                String[] values = line.split(",");
                for(int i =0;i<8;i++)
                {
                    ro[row][i]=values[i];
                }
            }
            b.close();
        }
        catch (Exception e1)
        {
            e1.printStackTrace();
        }
        t = new JTable(ro,c);
        tp = new JPanel(new BorderLayout());
        JScrollPane sp = new JScrollPane(t);
        tp.add(sp,BorderLayout.CENTER);
        f.getContentPane().add(tp,BorderLayout.PAGE_START);
        cp = new JPanel();
        label = new JLabel("Enter the id of the car to be deleted");
        tf = new JTextField(10);
        cp = new JPanel();
        cp.add(label);
        cp.add(tf);
        f.getContentPane().add(cp,BorderLayout.CENTER);
        bp = new JPanel();
        b = new JButton("OK");
        bp.add(b);
        b3 = new JButton("Back");
        bp.add(b3);
        f.getContentPane().add(bp,BorderLayout.SOUTH);
        b3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new admin();
                f.dispose();
            }
        });
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int pole = 0;
                String l;
                FileWriter w = null;
                try
                {
                    BufferedReader b1 = new BufferedReader(new FileReader(file));
                    while((l= b1.readLine())!=null)
                    {
                        String[] a = l.split(",");
                        if(tf.getText().equals(a[0]))
                        {
                            pole = 1;
                        }
                    }
                    b1.close();
                    if(pole == 1)
                    {
                        int carid=0;
                        BufferedReader b = new BufferedReader(new FileReader(file));
                        w = new FileWriter(temp);
                        w.write("carid,carname,carmodel,regno,mileage,current damage,status,rent\n");
                        b.readLine();
                        while((l=b.readLine())!=null)
                        {
                            carid++;
                            String[] car = l.split(",");
                            if(tf.getText().equals(car[0]))
                            {
                                continue;
                            }
                            else
                            {
                                w.write(carid+","+car[1]+","+car[2]+","+car[3]+","+car[4]+","+car[5]+","+car[6]+","+car[7]+"\n");
                            }
                        }
                        w.close();
                        b.close();
                        BufferedReader br = new BufferedReader(new FileReader(temp));
                        FileWriter fw = new FileWriter(filename);
                        while((l= br.readLine())!=null)
                        {
                            String[] newcar = l.split(",");
                            fw.write(newcar[0]+","+newcar[1]+","+newcar[2]+","+newcar[3]+","+newcar[4]+","+newcar[5]+","+newcar[6]+","+newcar[7]+"\n");
                        }
                        fw.close();
                        br.close();
                        new afterDelete();
                        f.dispose();
                    }
                    else
                    {
                        f.dispose();
                        new wrongId();
                    }

                }
                catch (Exception e0)
                {
                    e0.printStackTrace();
                }
            }
        });


        f.setVisible(true);
        f.setSize(800,550);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}