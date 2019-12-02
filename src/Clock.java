
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
public class Clock extends JFrame implements ActionListener
{
    JLabel label=new JLabel(String.format("%tY年%<tm月%<td日 %<tT",new Date()));
    Timer timer=new Timer(50,this);    //创建一个定时器
    public static void main(String[] args)
    {
        Clock theFrame = new Clock("小时钟");
        theFrame.setBounds(100,100,380,80);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.setVisible(true);
    }
    Clock(String s)
    {
        setTitle(s);
        setLayout(new FlowLayout());
        label.setFont(new Font("宋体",Font.BOLD,25));      	//设置字体
        add(label);
        timer.start();   	//定时器开始
    }
    public void actionPerformed(ActionEvent e)
    {
        String s = String.format("%tY年%<tm月%<td日 %<tT",new Date());
        label.setText(s);
    }
}