package CRS;

import java.awt.event.*;
import javax.swing.*;
public class admin
{
    JFrame f = new JFrame("ADMIN LOGIN");
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    public admin()
    {
	b8 = new JButton("View Users");
	b8.setBounds(120,120,180,30);
	f.add(b8);
        b1 = new JButton("View Cars");
        b1.setBounds(120,200,180,30);
        f.add(b1);
        b2 = new JButton("Add Car");
        b2.setBounds(120,280,180,30);
        f.add(b2);
        b3 = new JButton("Delete Car");
        b3.setBounds(120,360,180,30);
        f.add(b3);
        b4 = new JButton("Update Status");
        b4.setBounds(120,440,180,30);
        f.add(b4);
        b6 = new JButton("Pending return");
        b6.setBounds(120,520,180,30);
        f.add(b6);
        b7 = new JButton("Return car");
        b7.setBounds(120,600,180,30);
        f.add(b7);
        b5 = new JButton("Log Out");
        b5.setBounds(500,680,80,30);
        f.add(b5);
	b8.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e) {
	        new viewUser();
		f.dispose();
	    }
	});
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                new viewcar();
                f.dispose();
            }
        });
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new addCar();
                f.dispose();
            }
        });
        b3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new deleteCar();
                f.dispose();
            }
        });
        b4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new update();
                f.dispose();
            }
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new pendingReturn();
                f.dispose();

            }
        });
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new returnCar();
                f.dispose();
            }
        });
        b5.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new login();
                f.dispose();
            }
        });
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(800,800);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
