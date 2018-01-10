import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class W1 extends JFrame
{
Container c;
JButton b1;
W1()
{
c=getContentPane();
c.setLayout(new FlowLayout());
b1=new JButton("Click me");
c.add(b1);
b1.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
JOptionPane.showMessageDialog(c,"Welcum to my First App");
}
});

}//end of constructor

public static void main(String args[])
{
W1 w = new W1();
w.setSize(300,300);
w.setTitle("Mera App");
w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
w.setResizable(false);
w.setLocationRelativeTo(null);//center pe window aaega bhale koi bhi deskstop ki size ho
w.setVisible(true);

}//end of main
}//end of class