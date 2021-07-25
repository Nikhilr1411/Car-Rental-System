package CRS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class invalidDate
{
    JFrame f = new JFrame("INVALID DATE");
    JLabel l1;
    JButton b;
    public invalidDate(String mail)
    {
        l1 = new JLabel("SELECT A VALID DATE");
        l1.setBounds(180,80,400,30);
        f.add(l1);

        b = new JButton("OK");
        b.setBounds(200,140,80,30);
        f.add(b);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new user(mail);
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
