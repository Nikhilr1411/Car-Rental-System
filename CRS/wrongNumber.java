package CRS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class wrongNumber
{
    JFrame f = new JFrame("INVALID");
    JLabel l1;
    JButton b;
    public wrongNumber()
    {
        l1 = new JLabel("ENTER A VALID PHONE NUMBER");
        l1.setBounds(150,80,400,30);
        f.add(l1);

        b = new JButton("OK");
        b.setBounds(200,140,80,30);
        f.add(b);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new registration();
                f.dispose();
            }
        });


        f.setLayout(null);
        f.setVisible(true);
        f.setSize(500,300);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
