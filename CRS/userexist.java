package CRS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userexist
{
    JFrame f = new JFrame("USER EXISTS");
    JLabel l1;
    JButton b;
    public userexist()
    {
        l1 = new JLabel("EMAIL ID WITH PASSWORD ALREADY EXISTS");
        l1.setBounds(120,80,400,30);
        f.add(l1);

        b = new JButton("OK");
        b.setBounds(180,140,80,30);
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
