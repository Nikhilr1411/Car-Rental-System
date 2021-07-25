package CRS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class viewUser
{
    JFrame f = new JFrame("USER");
    JPanel tp,bp;
    JButton b1;
    public viewUser()
    {
        String l;
        try
        {
            int row = 0;
            File file = new File("C:\\Users\\Nikhil\\OneDrive\\Desktop\\user1.csv");
            BufferedReader b = new BufferedReader(new FileReader(file));
            l = b.readLine();
            String[] c = {"USER ID","FIRST NAME","LAST NAME","PHONE NO","EMAIL"};
            while ((l = b.readLine())!=null)
            {
		String[] values = l.split(",");
		if(values[6].equals("user"))
		{
			row++;
		}
            }
            b.close();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String d;
            String[][] s = new String[row][5];
            int r = -1;
            br.readLine();
            while((d=br.readLine())!=null)
            {
                String[]data = d.split(",");
		if(data[6].equals("user"))
		{
			r++;
			for(int i = 0;i<5;i++)
                	{
                    		s[r][i] = data[i];
                	}
		}        
            }
            br.close();
            JTable jt=new JTable(s,c);
            jt.setVisible(true);
            JScrollPane sp = new JScrollPane(jt);
            tp = new JPanel();
            tp.setLayout(new BorderLayout());
            tp.add(sp,BorderLayout.CENTER);
            f.getContentPane().add(tp,BorderLayout.PAGE_START);
            b1 = new JButton("Back");
            bp = new JPanel();
            bp.add(b1);
            f.getContentPane().add(bp,BorderLayout.LINE_END);
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new admin();
                    f.dispose();
                }
            });
        }
        catch (Exception e1)
        {
            e1.printStackTrace();
        }

        f.setVisible(true);
        f.setSize(900,500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}