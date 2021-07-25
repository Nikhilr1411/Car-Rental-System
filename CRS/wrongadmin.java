package CRS;
import java.awt.event.*;
import javax.swing.*;

public class wrongadmin
{
    JFrame f = new JFrame("INVALID");
    JLabel l;
    JButton b;
    public wrongadmin()
    {
        l = new JLabel("Enter a valid Admin ID");
        l.setBounds(180,80,400,30);
        f.add(l);
        b= new JButton("OK");
        b.setBounds(190,130,60,30);
        f.add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new adminmain();
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