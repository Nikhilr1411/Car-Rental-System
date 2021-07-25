package CRS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class update
{
    JFrame f = new JFrame("UPDATING");
    JComboBox cb2;
    JButton b,b1;
    JPanel tp,cp,bp;
    JLabel label;
    JTextField tf;
    JTable t;
    public update()
    {
        String line;
        int r = 0;
        File file = new File("C:\\Users\\Nikhil\\OneDrive\\Desktop\\cardetails1.csv");
        String filename = "C:\\Users\\Nikhil\\OneDrive\\Desktop\\cardetails1.csv";
        File temp = new File("C:\\Users\\Nikhil\\OneDrive\\Desktop\\cardetails2.csv");
        String[] c = {"CAR ID","CAR NAME","CAR MODEL","REG.NO","MILEAGE","CURRENT DAMAGE","STATUS","RENT"};
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
        cb2 = new JComboBox();
        cb2.addItem("Select Status");
        cb2.addItem("available");
        cb2.addItem("in service");
        cb2.addItem("intrip");
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
        label = new JLabel("Enter the id of the car to be updated");
        tf = new JTextField(10);
        cp = new JPanel();
        cp.add(label);
        cp.add(tf);
        cp.add(cb2);
        f.getContentPane().add(cp,BorderLayout.CENTER);
        b = new JButton("Update");
        b1 = new JButton("Back");
        bp = new JPanel();
        bp.add(b);
        bp.add(b1);
        f.getContentPane().add(bp,BorderLayout.SOUTH);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new admin();
                f.dispose();
            }
        });
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(cb2.getSelectedItem().equals("Select Status"))
                {
                    new invalidUpdate();
                    f.dispose();
                }
                else
                {
                    FileWriter fw = null;
                    String l;
                    try
                    {
                        BufferedReader b2 = new BufferedReader(new FileReader(file));
                        int pole = 0;
                        while ((l = b2.readLine()) != null) {
                            String[] car = l.split(",");
                            if (tf.getText().equals(car[0]))
                            {
                                pole = 1;
                            }
                        }
                        if(pole == 1)
                        {
                            BufferedReader b = new BufferedReader(new FileReader(file));
                            fw = new FileWriter(temp);
                            while ((l = b.readLine()) != null) {
                                String[] car = l.split(",");
                                if (tf.getText().equals(car[0]))
                                {
                                    fw.write(car[0] + "," + car[1] + "," + car[2] + "," + car[3] + "," + car[4] + "," + car[5] + "," + cb2.getSelectedItem() +","+car[7]+ "\n");
                                }
                                else
                                {
                                    fw.write(car[0] + "," + car[1] + "," + car[2] + "," + car[3] + "," + car[4] + "," + car[5] + "," + car[6] +","+car[7]+"\n");
                                }
                            }
                            fw.close();
                            b.close();
                            BufferedReader br = new BufferedReader(new FileReader(temp));
                            FileWriter w = new FileWriter(filename);
                            while ((l = br.readLine()) != null)
                            {
                                String[] newcar = l.split(",");
                                w.write(newcar[0] + "," + newcar[1] + "," + newcar[2] + "," + newcar[3] + "," + newcar[4] + "," + newcar[5] + "," + newcar[6] +","+newcar[7]+"\n");
                            }
                            w.close();
                            br.close();
                            new afterUpdate();
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

            }
        });
        f.setVisible(true);
        f.setSize(800,550);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
