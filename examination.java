import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class OnlineTest extends JFrame implements ActionListener
{
JLabel l;
JRadioButton jb[]=new JRadioButton[5];
JButton b1,b2;
ButtonGroup bg;
int count=0,current=0,x=1,y=1,now=0;
int m[]=new int[10];
OnlineTest(String s)
{
super(s);
l=new JLabel();
add(l);
bg=new ButtonGroup();
for(int i=0;i<5;i++)
{
jb[i]=new JRadioButton();
add(jb[i]);
bg.add(jb[i]);
}
b1=new JButton("Next");
b2=new JButton("Bookmark");
b1.addActionListener(this);
b2.addActionListener(this);
add(b1);add(b2);
set();
l.setBounds(30,40,450,20);
jb[0].setBounds(50,80,100,20);
jb[1].setBounds(50,110,100,20);
jb[2].setBounds(50,140,100,20);
jb[3].setBounds(50,170,100,20);
b1.setBounds(100,240,100,30);
b2.setBounds(270,240,100,30);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(null);
setLocation(250,100);
setVisible(true);
setSize(600,350);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
if(check())
count=count+1;
current++;
set();
if(current==4)
{
b1.setEnabled(false);
b2.setText("Result");
}
}
if(e.getActionCommand().equals("Bookmark"))
{
JButton bk=new JButton("Bookmark"+x);
bk.setBounds(480,20+30*x,100,30);
add(bk);
bk.addActionListener(this);
m[x]=current;
x++;
current++;
set();
if(current==9)
b2.setText("Result");
setVisible(false);
setVisible(true);
}
for(int i=0,y=1;i<x;i++,y++)
{
if(e.getActionCommand().equals("Bookmark"+y))
{
if(check())
count=count+1;
now=current;
current=m[y];
set();
((JButton)e.getSource()).setEnabled(false);
current=now;
}
}
if(e.getActionCommand().equals("Result"))
{
if(check())
count=count+1;
current++;
//System.out.println("correct ans="+count);
JOptionPane.showMessageDialog(this,"correct ans="+count);
System.exit(0);
}
}
void set()
{
jb[4].setSelected(true);
if(current==0)
{
l.setText("Que1:Which of the following can be operands of arithmetic operators??");
jb[0].setText("int");jb[1].setText("Float");jb[2].setText("boolean");jb[3].setText("char");
}
if(current==1)
{
l.setText("Que2: Decrement operator, −−, decreases the value of variable by what number?");
jb[0].setText("Swing");jb[1].setText("Applet");jb[2].setText("Object");jb[3].setText("ActionEvent");
}
if(current==2)
{
l.setText("Que3: Can 8 byte long data type be automatically type cast to 4 byte float data type?");
jb[0].setText("swing");jb[1].setText("applet");jb[2].setText("net");jb[3].setText("lang");
}
if(current==3)
{
l.setText("Que4: String class is defined in which package?");
jb[0].setText("lang");jb[1].setText("Swing");jb[2].setText("Applet");jb[3].setText("awt");
}
if(current==4)
{
l.setText("Que5: If an expression contains double, int, float, long, then the whole expression will be promoted into which of these data types?");
jb[0].setText("Utek");jb[1].setText("Aptech");jb[2].setText("SSSIT");jb[3].setText("jtek");
}
l.setBounds(30,40,450,20);
for(int i=0,j=0;i<=90;i+=30,j++)
jb[j].setBounds(50,80+i,200,20);
}
boolean check()
{
if(current==0)
return(jb[1].isSelected());
if(current==1)
return(jb[2].isSelected());
if(current==2)
return(jb[3].isSelected());
if(current==3)
return(jb[0].isSelected());
if(current==4)
return(jb[2].isSelected());
return false;
}
public static void main(String s[])
{
new OnlineTest("Online Test Of Java");
}
}