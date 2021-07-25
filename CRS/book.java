package CRS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;


public class book
{
    JFrame f = new JFrame("BOOK");
    JButton b2,b3;
    JLabel l1,l2;
    JComboBox cb1,cb2,cb3,cb4,cb5,cb6;
    int pole = 0;
    Date d1 = new Date();
    Date d2 = new Date();
    public book(String mail)
    {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        l1 = new JLabel("From Date");
        l1.setBounds(100, 90, 150, 40);
        f.add(l1);
        cb1 = new JComboBox();
        cb1.addItem("YYYY");
        for(int i=0;i<50;i++)
        {
            cb1.addItem(""+(LocalDate.now().getYear()+i));
        }
        cb1.setBounds(200, 100, 70, 20);
        f.add(cb1);

        String[] m = {"Jan","Feb","Mar","Apr","May","Jun","July","Aug","Sep","Oct","Nov","Dec"};
        cb2 = new JComboBox();
        cb2.addItem("MM");
        cb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cb2.removeAllItems();
                cb2.addItem("MM");
                if(cb1.getSelectedItem().equals(Integer.toString(LocalDate.now().getYear())))
                {
                    for(int i=LocalDate.now().getMonthValue()-1;i<12;i++)
                    {
                        cb2.addItem(m[i]);
                    }
                }
                else
                {
                    for(int i=0;i<12;i++)
                    {
                        cb2.addItem(m[i]);
                    }
                }
            }
        });
        cb2.setBounds(300,100,70,20);
        f.add(cb2);
        cb3 = new JComboBox();
        cb3.addItem("DD");

        cb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cb3.removeAllItems();
                cb3.addItem("DD");
                if(cb2.getSelectedItem()!=null)
                {
                    if(cb1.getSelectedItem().equals(Integer.toString(LocalDate.now().getYear()))&&
                            (LocalDate.now().getMonth().toString().toLowerCase().contains(cb2.getSelectedItem().toString().toLowerCase())))
                    {
                        if(cb2.getSelectedItem().equals("Feb"))
                        {
                            String a = cb1.getSelectedItem().toString();
                            int j = Integer.parseInt(a);
                            if((j%400==0)||(j%4==0))
                            {
                                for(int i=LocalDate.now().getDayOfMonth()-1;i<29;i++)
                                {
                                    cb3.addItem(""+(i+1));
                                }
                            }
                            else
                            {
                                for(int i=LocalDate.now().getDayOfMonth()-1;i<28;i++)
                                {
                                    cb3.addItem(""+(i+1));
                                }
                            }
                        }
                        else if(cb2.getSelectedItem().equals("Jan")||cb2.getSelectedItem().equals("Mar")||cb2.getSelectedItem().equals("May")
                                ||cb2.getSelectedItem().equals("July")||cb2.getSelectedItem().equals("Aug")||cb2.getSelectedItem().equals("Oct")
                                ||cb2.getSelectedItem().equals("Dec"))
                        {
                            for(int i =LocalDate.now().getDayOfMonth()-1;i<31;i++)
                            {
                                cb3.addItem(""+(1+i));
                            }
                        }
                        else if(cb2.getSelectedItem().equals("Apr")||cb2.getSelectedItem().equals("Jun")||cb2.getSelectedItem().equals("Sep")
                                ||cb2.getSelectedItem().equals("Nov"))
                        {
                            for(int i=LocalDate.now().getDayOfMonth()-1;i<30;i++)
                            {
                                cb3.addItem(""+(i+1));
                            }
                        }
                    }
                    else
                    {
                        if(cb2.getSelectedItem().equals("Feb"))
                        {
                            String a = cb1.getSelectedItem().toString();
                            int j = Integer.parseInt(a);
                            if((j%400==0)||(j%4==0))
                            {
                                for(int i=0;i<29;i++)
                                {
                                    cb3.addItem(""+(i+1));
                                }
                            }
                            else
                            {
                                for(int i=0;i<28;i++)
                                {
                                    cb3.addItem(""+(i+1));
                                }
                            }
                        }
                        else if(cb2.getSelectedItem().equals("Jan")||cb2.getSelectedItem().equals("Mar")||cb2.getSelectedItem().equals("May")
                                ||cb2.getSelectedItem().equals("July")||cb2.getSelectedItem().equals("Aug")||cb2.getSelectedItem().equals("Oct")
                                ||cb2.getSelectedItem().equals("Dec"))
                        {
                            for(int i =0;i<31;i++)
                            {
                                cb3.addItem(""+(1+i));
                            }
                        }
                        else if(cb2.getSelectedItem().equals("Apr")||cb2.getSelectedItem().equals("Jun")||cb2.getSelectedItem().equals("Sep")
                                ||cb2.getSelectedItem().equals("Nov"))
                        {
                            for(int i=0;i<30;i++)
                            {
                                cb3.addItem(""+(i+1));
                            }
                        }
                    }

                }
            }
        });
        cb3.setBounds(400,100,70,20);
        f.add(cb3);
        l2 = new JLabel("To date");
        l2.setBounds(100, 170, 80, 40);
        f.add(l2);
        cb4 = new JComboBox();
        cb4.addItem("YYYY");

        cb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cb4.removeAllItems();
                cb4.addItem("YYYY");
                if(cb2.getSelectedItem()!=null&&cb2.getSelectedItem().equals("Dec"))
                {
                    if(cb3.getSelectedItem()!=null&&cb3.getSelectedItem().equals(cb3.getItemAt(cb3.getItemCount()-1)))
                    {
                        for(int i=0;i<50;i++)
                        {
                            cb4.addItem(""+(Integer.parseInt(cb1.getSelectedItem().toString())+i+1));
                        }
                    }
                    else
                    {
                        for(int i=0;i<50;i++)
                        {
                            cb4.addItem(""+(Integer.parseInt(cb1.getSelectedItem().toString())+i));
                        }
                    }
                }
                else
                {
                    for(int i=0;i<50;i++)
                    {
                        cb4.addItem(""+(Integer.parseInt(cb1.getSelectedItem().toString())+i));
                    }
                }



            }
        });
        cb4.setBounds(200, 180, 70, 20);
        f.add(cb4);

        cb5 = new JComboBox();
        cb5.addItem("MM");
        if(cb3.getSelectedItem().equals(cb3.getItemAt(cb3.getItemCount()-1)))
        {
            for(int i=cb2.getSelectedIndex();i<12;i++)
            {
                cb5.addItem(m[i]);
            }
        }
        else
        {
            for(int i=0;i<12;i++)
            {
                cb5.addItem(m[i]);
            }
        }

        cb5.setBounds(300,180,70,20);
        f.add(cb5);
        cb6 = new JComboBox();
        cb6.addItem("DD");
        cb4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cb5.removeAllItems();
                cb5.addItem("MM");
                if(cb3.getSelectedItem()!=null&&cb2.getSelectedItem()!=null)
                {
                    if(cb1.getSelectedItem().equals(cb4.getSelectedItem()))
                    {
                        if(cb3.getSelectedItem().equals(cb3.getItemAt(cb3.getItemCount()-1)))
                        {
                            int j=0;
                            for(int i =0;i<12;i++)
                            {
                                if(m[i].equals(cb2.getSelectedItem()))
                                {
                                    j=i+1;
                                }
                            }
                            for(int i=j;i<12;i++)
                            {
                                cb5.addItem(m[i]);
                            }
                        }
                        else
                        {
                            String s = cb2.getSelectedItem().toString();
                            int l=0;
                            for(int i =0;i<12;i++)
                            {
                                if(m[i].equals(s))
                                {
                                    l=i;
                                }
                            }
                            for(int i=l;i<12;i++)
                            {
                                cb5.addItem(m[i]);
                            }
                        }
                    }
                    else
                    {
                        for(int i=0;i<12;i++)
                        {
                            cb5.addItem(m[i]);
                        }
                    }

                }

            }
        });
        cb5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cb6.removeAllItems();
                cb6.addItem("DD");
                if(cb5.getSelectedItem()!=null)
                {
                    if(cb1.getSelectedItem().equals(cb4.getSelectedItem()))
                    {
                        if(cb5.getSelectedItem().equals("Feb"))
                        {
                            String a = cb4.getSelectedItem().toString();
                            int j = Integer.parseInt(a);
                            if((j%400==0)||(j%4==0))
                            {
                                if(cb2.getSelectedItem().equals(cb5.getSelectedItem()))
                                {
                                    for(int i = Integer.parseInt(cb3.getSelectedItem().toString());i<29;i++)
                                    {
                                        cb6.addItem(""+(i+1));
                                    }
                                }
                                else
                                {
                                    for(int i=0;i<29;i++)
                                    {
                                        cb6.addItem(""+(i+1));
                                    }
                                }

                            }
                            else
                            {
                                if(cb2.getSelectedItem().equals(cb5.getSelectedItem()))
                                {
                                    for(int i = Integer.parseInt(cb3.getSelectedItem().toString());i<28;i++)
                                    {
                                        cb6.addItem(""+(i+1));
                                    }
                                }
                                else
                                {
                                    for(int i=0;i<28;i++)
                                    {
                                        cb6.addItem(""+(i+1));
                                    }
                                }

                            }
                        }
                        else if(cb5.getSelectedItem().equals("Jan")||cb5.getSelectedItem().equals("Mar")||cb5.getSelectedItem().equals("May")
                                ||cb5.getSelectedItem().equals("July")||cb5.getSelectedItem().equals("Aug")||cb5.getSelectedItem().equals("Oct")
                                ||cb5.getSelectedItem().equals("Dec"))
                        {
                            if(cb2.getSelectedItem().equals(cb5.getSelectedItem()))
                            {
                                for(int i = Integer.parseInt(cb3.getSelectedItem().toString());i<31;i++)
                                {
                                    cb6.addItem(""+(i+1));
                                }
                            }
                            else
                            {
                                for(int i =0;i<31;i++)
                                {
                                    cb6.addItem(""+(1+i));
                                }
                            }


                        }
                        else if(cb5.getSelectedItem().equals("Apr")||cb5.getSelectedItem().equals("Jun")||cb5.getSelectedItem().equals("Sep")
                                ||cb5.getSelectedItem().equals("Nov"))
                        {
                            if(cb2.getSelectedItem().equals(cb5.getSelectedItem()))
                            {
                                for(int i = Integer.parseInt(cb3.getSelectedItem().toString());i<30;i++)
                                {
                                    cb6.addItem(""+(i+1));
                                }
                            }
                            else
                            {
                                for(int i=0;i<30;i++)
                                {
                                    cb6.addItem(""+(i+1));
                                }
                            }

                        }
                    }
                    else
                    {
                        if(cb5.getSelectedItem().equals("Feb"))
                        {
                            String a = cb4.getSelectedItem().toString();
                            int j = Integer.parseInt(a);
                            if((j%400==0)||(j%4==0))
                            {
                                for(int i=0;i<29;i++)
                                {
                                    cb6.addItem(""+(i+1));
                                }


                            }
                            else
                            {
                                for(int i=0;i<28;i++)
                                {
                                    cb6.addItem(""+(i+1));
                                }

                            }
                        }
                        else if(cb5.getSelectedItem().equals("Jan")||cb5.getSelectedItem().equals("Mar")||cb5.getSelectedItem().equals("May")
                                ||cb5.getSelectedItem().equals("July")||cb5.getSelectedItem().equals("Aug")||cb5.getSelectedItem().equals("Oct")
                                ||cb5.getSelectedItem().equals("Dec"))
                        {
                            for(int i =0;i<31;i++)
                            {
                                cb6.addItem(""+(1+i));
                            }
                        }
                        else if(cb5.getSelectedItem().equals("Apr")||cb5.getSelectedItem().equals("Jun")||cb5.getSelectedItem().equals("Sep")
                                ||cb5.getSelectedItem().equals("Nov"))
                        {

                            for(int i=0;i<30;i++)
                            {
                                cb6.addItem(""+(i+1));
                            }

                        }
                    }

                }
            }
        });
        cb6.setBounds(400,180,70,20);
        f.add(cb6);


        String filename = "C:\\Users\\Nikhil\\OneDrive\\Desktop\\registration1.csv";
        String filename1 = "C:\\Users\\Nikhil\\OneDrive\\Desktop\\cardetails1.csv";
        b3 = new JButton("Back");
        b3.setBounds(400,300,100,30);
        f.add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new user(mail);
                f.dispose();
            }
        });
        b2 = new JButton("Search");
        b2.setBounds(130,300,100,30);
        f.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cb1.getSelectedItem().equals("YYYY")||cb2.getSelectedItem().equals("MM")||cb3.getSelectedItem().equals("DD")||
                cb4.getSelectedItem().equals("YYYY")||cb5.getSelectedItem().equals("MM")||cb6.getSelectedItem().equals("DD"))
                {
                    new invalidDate(mail);
                    f.dispose();
                }
                else
                {
                    f.dispose();
                    JFrame f1 = new JFrame("BOOK");
                    JPanel tp,cp,bp;
                    JLabel label;
                    JTextField tf;
                    JButton b,b4;
                    JTable t;
                    try
                    {
                        int month = 0,month1=0;
                        for(int i=0;i<12;i++)
                        {
                            month++;
                            if(cb2.getSelectedItem().equals(m[i]))
                            {
                                break;
                            }
                        }
                        for(int i=0;i<12;i++)
                        {
                            month1++;
                            if(cb5.getSelectedItem().equals(m[i]))
                            {
                                break;
                            }
                        }


                        if(month<=9)
                        {
                            d1 = sdf.parse(String.valueOf(cb3.getSelectedItem()) + "-" + "0" + month+ "-" + String.valueOf(cb1.getSelectedItem()));
                            d2= sdf.parse(String.valueOf(cb6.getSelectedItem()) + "-" + "0" + month1+ "-" + String.valueOf(cb4.getSelectedItem()));
                        }
                        else
                        {
                            d1 = sdf.parse(String.valueOf(cb3.getSelectedItem()) + "-" + month+ "-" + String.valueOf(cb1.getSelectedItem()));
                            d2 = sdf.parse(String.valueOf(cb6.getSelectedItem()) + "-" + month1+ "-" + String.valueOf(cb4.getSelectedItem()));
                        }
                        RandomAccessFile s = new RandomAccessFile(filename1,"rw");
                        RandomAccessFile s1 = new RandomAccessFile(filename,"rw");
                        s.readLine();
                        String line,line1;

                        int r = 0;

                        while((line = s.readLine())!=null)
                        {
                            int flag =0;
                            String[] values = line.split(",");
                            s1.seek(0);
                            if(values[6].equals("available"))
                            {
                                flag =0;
                                s1.readLine();
                                while((line1 = s1.readLine())!=null)
                                {
                                    String[] details = line1.split(",");
                                    Date d3 = new Date();
                                    Date d4 = new Date();
                                    if(details[2].equals(values[3]))
                                    {
                                        d3 = sdf.parse(String.valueOf(details[3]));
                                        d4 = sdf.parse(String.valueOf(details[4]));
                                        if(details[5].equals("booked"))
                                        {
                                            if(d1.compareTo(d3)>=0)
                                            {
                                                if(d1.compareTo(d4)<=0)
                                                {
                                                    flag = 1;
                                                }
                                            }
                                            else if(d2.compareTo(d3)>=0)
                                            {
                                                if(d2.compareTo(d4)<=0)
                                                {
                                                    flag = 1;
                                                }
                                            }
                                        }
                                    }
                                }
                                if(flag == 0)
                                {
                                    r++;
                                }
                            }
                        }
                        String[][]row = new String[r][8];
                        s.close();
                        s1.close();
                        RandomAccessFile s0 = new RandomAccessFile(filename1,"rw");
                        RandomAccessFile s2 = new RandomAccessFile(filename,"rw");
                        s0.readLine();
                        String l,l1;
                        int ro = -1;
                        while((l = s0.readLine())!=null)
                        {
                            int flag =0;
                            String[] values = l.split(",");
                            s2.seek(0);
                            if(values[6].equals("available"))
                            {
                                flag =0;
                                s2.readLine();
                                while((l1 = s2.readLine())!=null)
                                {
                                    String[] details = l1.split(",");
                                    Date d3 = new Date();
                                    Date d4 = new Date();
                                    if(details[2].equals(values[3]))
                                    {
                                        d3 = sdf.parse(String.valueOf(details[3]));
                                        d4 = sdf.parse(String.valueOf(details[4]));
                                        if(details[5].equals("booked"))
                                        {
                                            if(d1.compareTo(d3)>=0)
                                            {
                                                if(d1.compareTo(d4)<=0)
                                                {
                                                    flag = 1;
                                                }
                                            }
                                            else if(d2.compareTo(d3)>=0)
                                            {
                                                if(d2.compareTo(d4)<=0)
                                                {
                                                    flag = 1;
                                                }
                                            }
                                        }
                                    }
                                }
                                if(flag == 0)
                                {
                                    ro++;
                                    for(int i=0;i<8;i++)
                                    {
                                        row[ro][i]=values[i];
                                    }
                                }
                            }
                        }
                        s0.close();
                        s2.close();
                        String[] c = {"CAR ID","CAR NAME","CAR MODEL","REG NO","MILEAGE","CURRENT DAMAGES","STATUS","RENT"};
                        t = new JTable(row,c);
                        JScrollPane sp = new JScrollPane(t);
                        tp = new JPanel();
                        tp.setLayout(new BorderLayout());
                        tp.add(sp,BorderLayout.CENTER);
                        f1.getContentPane().add(tp,BorderLayout.PAGE_START);
                        label = new JLabel("Enter the id of the car to be booked");
                        tf = new JTextField(10);
                        cp = new JPanel();
                        cp.add(label);
                        cp.add(tf);
                        f1.getContentPane().add(cp,BorderLayout.CENTER);
                        bp = new JPanel();
                        b = new JButton("OK");
                        bp.add(b);
                        b4 = new JButton("Back");
                        bp.add(b4);
                        f1.getContentPane().add(bp,BorderLayout.SOUTH);

                        b4.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                new book(mail);
                                f1.dispose();
                            }
                        });
                        b.addActionListener(new ActionListener()
                        {
                            FileWriter fw = null;
                            public void actionPerformed(ActionEvent e)
                            {
                                try
                                {
                                    String l1;
                                    RandomAccessFile s10 = new RandomAccessFile(filename1,"rw");
                                    RandomAccessFile s12 = new RandomAccessFile(filename,"rw");
                                    while((l1 = s10.readLine())!=null)
                                    {
                                        int flag =0;
                                        String[] values = l1.split(",");
                                        s12.seek(0);
                                        if(values[6].equals("available"))
                                        {
                                            flag =0;
                                            s12.readLine();
                                            while((l1 = s12.readLine())!=null)
                                            {
                                                String[] details = l1.split(",");
                                                Date d3 = new Date();
                                                Date d4 = new Date();
                                                if(details[2].equals(values[3]))
                                                {
                                                    d3 = sdf.parse(String.valueOf(details[3]));
                                                    d4 = sdf.parse(String.valueOf(details[4]));
                                                    if(details[5].equals("booked"))
                                                    {
                                                        if(d1.compareTo(d3)>=0)
                                                        {
                                                            if(d1.compareTo(d4)<=0)
                                                            {
                                                                flag = 1;
                                                            }
                                                        }
                                                        else if(d2.compareTo(d3)>=0)
                                                        {
                                                            if(d2.compareTo(d4)<=0)
                                                            {
                                                                flag = 1;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            if(flag == 0)
                                            {
                                                if(tf.getText().equals(values[0]))
                                                    pole =1;
                                            }
                                        }
                                    }
                                    s10.close();
                                    s12.close();
                                    if(pole == 1)
                                    {
                                        String line;
                                        int id =1;
                                        BufferedReader s1 = new BufferedReader(new FileReader(filename));
                                        BufferedReader br = new BufferedReader(new FileReader(filename1));
                                        String[] values = {};
                                        String s = tf.getText();
                                        String regno = null;
                                        String rent = null;
                                        s1.readLine();
                                        while((line = s1.readLine())!= null)
                                        {
                                            values = line.split(",");
                                            id++;
                                        }

                                        while((line=br.readLine())!=null)
                                        {
                                            String[] reg = line.split(",");
                                            if(tf.getText().equals(reg[0]))
                                            {
                                                regno = reg[3];
                                                rent = reg[7];
                                            }
                                        }
                                        br.close();
                                        s1.close();
                                        fw = new FileWriter(filename,true);
                                        int month = 0,month1 = 0;
                                        for(int i=0;i<12;i++)
                                        {
                                            month++;
                                            if(cb2.getSelectedItem().equals(m[i]))
                                            {
                                                break;
                                            }
                                        }
                                        for(int i=0;i<12;i++)
                                        {
                                            month1++;
                                            if(cb5.getSelectedItem().equals(m[i]))
                                            {
                                                break;
                                            }
                                        }
                                        fw.write(id+","+mail+","+regno+","+cb3.getSelectedItem()+"-"+month+"-"+cb1.getSelectedItem()+","+
                                                cb6.getSelectedItem()+"-"+month1+"-"+cb4.getSelectedItem().toString()+","+"booked\n");
                                        fw.close();
                                        f1.dispose();
                                        JFrame f2 = new JFrame("BOOKED");
                                        JButton book = new JButton("OK");
                                        int year = Integer.parseInt(cb1.getSelectedItem().toString());
                                        int date = Integer.parseInt(cb3.getSelectedItem().toString());
                                        int year1 = Integer.parseInt(cb4.getSelectedItem().toString());
                                        int date1 = Integer.parseInt(cb6.getSelectedItem().toString());
                                        LocalDate d1 = LocalDate.of(year,month,date);
                                        LocalDate d2 = LocalDate.of(year1,month1,date1);
                                        long days = ChronoUnit.DAYS.between(d1,d2);
                                        JLabel info = new JLabel("Your car "+regno+" has been successfully registered");
                                        info.setBounds(80,80,400,30);
                                        JLabel cost = new JLabel("The total rent is "+(days+1)*Integer.parseInt(rent));
                                        cost.setBounds(170,120,400,30);
                                        book.setBounds(210,190,60,30);
                                        f2.add(book);
                                        f2.add(info);
                                        f2.add(cost);
                                        book.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                new user(mail);
                                                f2.dispose();
                                            }
                                        });

                                        f2.setLayout(null);
                                        f2.setVisible(true);
                                        f2.setSize(500,300);
                                        f2.setLocationRelativeTo(null);
                                        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    }
                                    else
                                    {
                                        new invalidId(mail);
                                        f1.dispose();
                                    }
                                }
                                catch (Exception es)
                                {
                                    es.printStackTrace();
                                }
                            }
                        });

                        f1.pack();
                        f1.setVisible(true);
                        f1.setSize(800,550);
                        f1.setLocationRelativeTo(null);
                        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    }
                    catch(Exception e1)
                    {
                        e1.printStackTrace();
                    }
                }
            }
        });
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(600, 500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
