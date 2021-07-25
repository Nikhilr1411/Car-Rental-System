package CRS;

import javax.swing.*;
import java.awt.event.*;

public class wronguser
{
    JFrame f = new JFrame("INVALID");
    JLabel l1,l2;
    JButton b;
    public wronguser()
    {
        l1 = new JLabel("ENTER A VALID USER EMAIL ID OR PASSWORD");
        l1.setBounds(130,80,400,30);
        f.add(l1);

        l2 = new JLabel("IF NOT REGISTERED, CREATE A NEW ACCOUNT AND LOGIN");
        l2.setBounds(70,110,400,30);
        f.add(l2);

        b = new JButton("OK");
        b.setBounds(200,190,60,30);
        f.add(b);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new usermain();
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

