package CRS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class wrongId
{
    JFrame f = new JFrame("Wrong ID");
    JLabel l;
    JButton b;
    public wrongId()
    {
        l = new JLabel("ENTER A VALID ID");
        l.setBounds(180,80,400,30);
        f.add(l);
        b= new JButton("OK");
        b.setBounds(190,130,60,30);
        f.add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new admin();
                f.dispose();
            }
        });

        f.setLayout(null);
        f.setVisible(true);
        f.setSize(450,300);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
