package CRS;
import javax.swing.*;
import java.awt.event.*;

public class user
{
    JFrame f = new JFrame("USER LOGIN");
    JButton b1,b2,b3,b4,b5;
    public user(String email)
    {
        b2 = new JButton("View Bookings");
        b2.setBounds(120,150,180,30);
        f.add(b2);
        b3 = new JButton("Book");
        b3.setBounds(120,230,180,30);
        f.add(b3);
        b4 = new JButton("Cancel Book");
        b4.setBounds(120,310,180,30);
        f.add(b4);
        b5 = new JButton("Logout");
        b5.setBounds(400,400,100,30);
        f.add(b5);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new login();
                f.dispose();
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new viewBooking(email);
                f.dispose();
            }
        });
        b3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new book(email);
                f.dispose();
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new cancelBook(email);
                f.dispose();
            }
        });

        f.setLayout(null);
        f.setVisible(true);
        f.setSize(700,500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
