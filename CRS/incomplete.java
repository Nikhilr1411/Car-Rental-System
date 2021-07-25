package CRS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class incomplete
{
    JFrame f = new JFrame("INCOMPLETE FILLING");
    JLabel l;
    JButton b;
    public incomplete()
    {
        l = new JLabel("FILL ALL THE OPTIONS");
        l.setBounds(180,80,400,30);
        f.add(l);

        b = new JButton("OK");
        b.setBounds(200,140,80,30);
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
