import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DeleteEmp extends JFrame
{
Container c;
JLabel lblId;
JTextField txtId;
JPanel p1,p2;
JButton btnSave,btnBack;
DeleteEmp()
{
c=getContentPane();
p1=new JPanel();
p1.setLayout(new FlowLayout());
lblId = new JLabel("ID:");
txtId = new JTextField(4);


p1.add(lblId);
p1.add(txtId);


c.add(p1);
p2 = new JPanel();
p2.setLayout(new FlowLayout());
btnSave = new JButton("Save");
btnBack = new JButton("Back");
p2.add(btnSave);
p2.add(btnBack);
c.add("South",p2);

setSize(500,150);
setTitle("Delete Employee");
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

DatabaseHandler db=new DatabaseHandler();
db.deleteEmployee(id);
txtId.setText("");
}
});

}//end of constructor

}//end of class