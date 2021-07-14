import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class About extends JFrame implements ActionListener {
	JFrame f;
	JButton b1;
	JLabel l1;
	JLabel l2;
	JLabel l8;
	About()
	{
		f=new JFrame("About");
		b1=new JButton("ok");
		ImageIcon k=new ImageIcon(ClassLoader.getSystemResource("windows.png"));
		Image l=k.getImage().getScaledInstance(200,100, Image.SCALE_DEFAULT);
		ImageIcon k1=new ImageIcon(l);
		l1=new JLabel(k1);
		ImageIcon k2=new ImageIcon(ClassLoader.getSystemResource("notepad.png"));
		Image l5=k2.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
		ImageIcon k3=new ImageIcon(l5);
		l8=new JLabel("<html>This Notepad is made by Nidhi Rathore<br> This Notpad is very simliar to original Notpad <br><br> EASY TO USE</html> ");
		l2=new JLabel(k3);
		f.setSize(500,400);
		f.setVisible(true);
		f.setLocation(300,100);
		f.setLayout(null);
		f.add(b1);
		f.add(l1);
		f.add(l2);
		f.add(l8);
		b1.setBounds(410,300,50,30);
		l1.setBounds(200,50,200,100);
		l2.setBounds(20,120, 100,80);
		l8.setBounds(150,80,200,250);
		b1.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	   f.dispose();
		
	}

}
