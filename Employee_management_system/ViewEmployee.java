import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
class ViewEmployee extends JFrame
{
Container c;
JTextArea txtData;
JScrollPane sp1;
JButton btnBack;
JPanel p1,p2;

ViewEmployee()
{
c=getContentPane();
p1=new JPanel();
p1.setLayout(new FlowLayout());

txtData=new JTextArea(3,20);
txtData.setEditable(false);

sp1=new JScrollPane(txtData);
sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
sp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

p1.add(sp1);
c.add(p1);

p2=new JPanel();
p2.setLayout(new FlowLayout());
btnBack=new JButton("Back");
p2.add(btnBack);
c.add("South",p2);


setSize(500,150);
setTitle("View Employee");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setVisible(true);



btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae) {
HomeFrame a = new HomeFrame();
dispose();
}
});

DatabaseHandler db=new DatabaseHandler();
String data=db.viewEmployee();
txtData.setText(data);
}//end of constructor



}//end of class



