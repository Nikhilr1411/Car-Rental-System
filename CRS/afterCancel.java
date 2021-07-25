package CRS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class afterCancel
{
    JFrame f = new JFrame("CANCELLED");
    JLabel l;
    JButton b;
    public afterCancel(String mail)
    {
        l= new JLabel("The car has been successfully cancelled");
        l.setBounds(130,80,400,30);
        f.add(l);
        b = new JButton("OK");
        b.setBounds(200,130,80,30);
        f.add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

