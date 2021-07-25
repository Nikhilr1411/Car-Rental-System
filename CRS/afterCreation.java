package CRS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class afterCreation
{
    JFrame f = new JFrame("CREATED");
    JLabel l;
    JButton b;
    public afterCreation()
    {
        l = new JLabel("SUCCESSFULLY REGISTERED");
        l.setBounds(170,80,400,30);
        f.add(l);
        b = new JButton("OK");
        b.setBounds(200,130,80,30);
        f.add(b);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new login();
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
