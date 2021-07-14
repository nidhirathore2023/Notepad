import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class notepad extends JFrame  implements ActionListener{
JFrame f;
JMenuBar m;
JMenu file;
JMenu edit;
JMenu help;
JMenuItem save;
JMenuItem open;
JMenuItem copy;
JMenuItem cut;
JMenuItem new1;
JMenuItem exit;
JMenuItem paste;
JMenuItem about;
JTextArea area;
JScrollPane pane;
String out;

notepad()
{
	f=new JFrame("Notepad");
	m=new JMenuBar();
	file=new JMenu("File");
	edit=new JMenu("Edit");
	help=new JMenu("Help");
	save=new JMenuItem("Save");
	open=new JMenuItem("Open ");
	cut=new JMenuItem("Cut");
	new1=new JMenuItem("New");
	copy=new JMenuItem("Copy");
	paste=new JMenuItem("Paste");
	exit=new JMenuItem("Exit");
	about=new JMenuItem("About");
	area=new JTextArea();
	pane=new JScrollPane(area);
	f.setVisible(true);
	f.setSize(1150,650);
	f.setLayout(null);
	f.add(m);
	m.setBounds(0,0,1132,20);
	m.add(file);
	m.add(edit);
	m.add(help);
	f.add(pane,BorderLayout.CENTER);
	f.add(area);
	area.setBounds(0,20,1132,630);
	area.setLineWrap(true);
	area.setWrapStyleWord(true);
	
	area.setFont(new Font("SAN_SARIF",Font.BOLD,16));
	f.setBounds(0,30,1150,650);
	new1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK) );
	open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
	save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK) );
	open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
	copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK) );
	cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
	paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
	exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0));
	file.add(new1);
	file.add(open);
	file.add(save);
	file.add(exit);
	edit.add(copy);
	edit.add(cut);
	edit.add(paste);
	help.add(about);
	new1.addActionListener(this);
	open.addActionListener(this);
	save.addActionListener(this);
	exit.addActionListener(this);
	copy.addActionListener(this);
	cut.addActionListener(this);
	paste.addActionListener(this);
	about.addActionListener(this);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
}
      @Override
   public void actionPerformed(ActionEvent e) {
   if(e.getSource()==new1)
   {
	area.setText("");;
	  
   }
   if(e.getSource()==save)
   {
	   JFileChooser c=new JFileChooser();
	   c.setApproveButtonText("Save");
	   int a=c.showOpenDialog(this);
	   if(a!=JFileChooser.APPROVE_OPTION)
		   return ;
	   File file=new File(c.getSelectedFile()+".txt");
	   BufferedWriter h=null;
	   try
	   {
		h=new BufferedWriter(new FileWriter(file));
		area.write(h);
	   }
	   catch(Exception k)
	   {
		   
	   }
   }
   if(e.getSource()==open)
   {
	   JFileChooser c1=new JFileChooser();
	   c1.setAcceptAllFileFilterUsed(false);
	   FileNameExtensionFilter k=new FileNameExtensionFilter("only .txt files","txt");
	   c1.addChoosableFileFilter(k);
	   int a=c1.showOpenDialog(this);
	   if(a!=JFileChooser.APPROVE_OPTION)
		   return ;
	   File file =c1.getSelectedFile();
	   try
	   {
		   BufferedReader j=new BufferedReader(new FileReader(file));
		   area.read(j, null);
	   }
	   catch(Exception f)
	   {
		   
	   }
   }
	if(e.getSource()==exit)
	{
		System.exit(0);
	}
	if(e.getSource()==copy) {
		out=area.getSelectedText();
		
	  }
       if(e.getSource()==cut) {
		 out=area.getSelectedText();
		 area.replaceRange(null, area.getSelectionStart(), area.getSelectionEnd());
		
	  }
         if(e.getSource()==paste) {
	        area.insert(out, area.getCaretPosition());
     }
         if(e.getSource()==about)
         {
        	 About l=new About();
        	 
         }
        }
	
	
	
	
	public static void main(String args[])
	{
		notepad j=new notepad();
	}





	
}
