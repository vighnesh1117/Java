import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddFrame extends JFrame
{
Container c;
JLabel lblId,lblName;
JTextField txtId,txtName;
JPanel p1,p2;
JButton btnSave,btnBack;
AddFrame()
{
c=getContentPane();
p1=new JPanel();
p1.setLayout(new FlowLayout());
lblId = new JLabel("ID:");
txtId = new JTextField(4);
lblName = new JLabel("NAME:");
txtName = new JTextField(10);

p1.add(lblId);
p1.add(txtId);
p1.add(lblName);
p1.add(txtName);

c.add(p1);
p2 = new JPanel();
p2.setLayout(new FlowLayout());
btnSave = new JButton("Save");
btnBack = new JButton("Back");
p2.add(btnSave);
p2.add(btnBack);
c.add("South",p2);

setSize(500,150);
setTitle("Add Employee");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setVisible(true);

btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae) {
HomeFrame a = new HomeFrame();
dispose();
}
});

btnSave.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae) {
int id=Integer.parseInt(txtId.getText());
String name=txtName.getText();
DatabaseHandler db=new DatabaseHandler();
db.addEmployee(id,name);
txtId.setText("");
txtName.setText("");
}
});

}//end of constructor

}//end of class