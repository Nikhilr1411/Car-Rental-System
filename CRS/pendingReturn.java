package CRS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class pendingReturn
{
    JFrame f =new JFrame("PENDING RETURN");
    JTable t;
    JPanel tp,bp;
    JButton button;
    public pendingReturn()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate current = LocalDate.now();
        int id=0;
        sdf.setLenient(false);
        try
        {
            Date dcurrent = sdf.parse(dtf.format(current));
            BufferedReader b = new BufferedReader(new FileReader("C:\\Users\\Nikhil\\OneDrive\\Desktop\\registration1.csv"));
            String l;
            String[] c = {"ID","EMAIL","REG.NO","FROM DATE","TO DATE"};
            b.readLine();
            while((l=b.readLine())!=null)
            {
                String[]details = l.split(",");
                if(details[5].equals("booked"))
                {
                    Date d = sdf.parse(details[4]);
                    if(d.compareTo(dcurrent)<0)
                    {
                        id++;
                    }
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
                Date d = sdf.parse(details[4]);
                if(details[5].equals("booked"))
                {
                    if(d.compareTo(dcurrent)<0)
                    {
                        row++;
                        for(int i =0;i<5;i++)
                        {
                            r[row][i]=details[i];
                        }
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
            button = new JButton("Back");
            bp = new JPanel();
            bp.add(button);
            f.getContentPane().add(bp,BorderLayout.CENTER);
            button.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    new admin();
                    f.dispose();
                }
            });
            f.setVisible(true);
            f.setSize(900,500);
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
