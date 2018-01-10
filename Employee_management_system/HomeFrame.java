import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class HomeFrame extends JFrame
{

Container c;
JButton btnAdd,btnUpdate,btnView,btnDelete;


HomeFrame()
{
c=getContentPane();
c.setLayout(new FlowLayout());
btnAdd=new JButton("Add");
btnView=new JButton("View");
btnUpdate=new JButton("Update");
btnDelete=new JButton("Delete");

c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);

setSize(500,150);
setTitle("Home");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setVisible(true);

btnAdd.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
AddFrame a = new AddFrame();
dispose();
}
});



btnView.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
ViewEmployee ve= new ViewEmployee();
dispose();
}
});

btnUpdate.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
UpdateEmp ue= new UpdateEmp();
dispose();
}
});

btnDelete.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
DeleteEmp d = new DeleteEmp();
dispose();
}
});
}//end of constructor

public static void main(String[] args)
{
HomeFrame h=new HomeFrame();

}  //end of main()


}//end of class

 class DatabaseHandler
{
public static Connection con;
public static void getConn()
{
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kunal","kunal123");
}
catch(Exception e)
{
JOptionPane.showMessageDialog(new JDialog(),""+e);
}
}
public void addEmployee(int eid,String ename)
{
try
{
getConn();
String s1="insert into employee values(?,?)";
PreparedStatement pst=con.prepareStatement(s1);
pst.setInt(1,eid);
pst.setString(2,ename);
int r=pst.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(),r+"records inserted");
}
catch(Exception e)
{
JOptionPane.showMessageDialog(new JDialog(),""+e);
}
}

public String viewEmployee()
{
StringBuffer sb=new StringBuffer();
try
{
getConn();
String q="select * from employee order by eid";
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(q);
sb.append("ID:"+"\t"+"NAME:"+"\n");
while(rs.next())
{
sb.append(rs.getString(1)+"\t"+rs.getString(2)+"\n");
}// end of while 
rs.close();
}//end of try
 
catch(Exception e)
{
JOptionPane.showMessageDialog(new JDialog(),""+e);
}//end of catch
return sb.toString();
}

public void updateEmployee(int eid,String ename)
{
try
{
getConn();
String s1="update Employee set ename=? where eid =?";
PreparedStatement pst=con.prepareStatement(s1);
pst.setInt(2,eid);
pst.setString(1,ename);
int r=pst.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(),r+"records updated");
}
catch(Exception e)
{
JOptionPane.showMessageDialog(new JDialog(),""+e);
}
}

public void deleteEmployee(int eid)
{
try
{
getConn();
String s1="delete from Employee where eid =?";
PreparedStatement pst=con.prepareStatement(s1);
pst.setInt(1,eid);
int r=pst.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(),r+"records deleted");
}
catch(Exception e)
{
JOptionPane.showMessageDialog(new JDialog(),""+e);
}
}
}

