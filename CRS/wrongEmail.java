package CRS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class wrongEmail
{
    JFrame f = new JFrame("INVALID");
    JLabel l1;
    JButton b;
    public wrongEmail()
    {
        l1 = new JLabel("ENTER A VALID EMAIL");
        l1.setBounds(180,80,400,30);
        f.add(l1);

        b = new JButton("OK");
        b.setBounds(200,130,80,30);
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
