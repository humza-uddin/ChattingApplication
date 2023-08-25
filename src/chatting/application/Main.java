package chatting.application;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

	//Frame - Constructor
	Main(){
		
		setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(30,94,84));
		panel1.setBounds(0,0,450,70);
		panel1.setLayout(null);
		add(panel1);
		
		ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/angle-left.png"));
		Image icon2 = icon1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		ImageIcon icon3 = new ImageIcon(icon2);
		JLabel back = new JLabel(icon3);
		back.setBounds(5,20,25,25);
		panel1.add(back);
		
		setSize(450, 700);
		setLocation(200, 30);
		getContentPane().setBackground(Color.WHITE);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Main(); // Anonymous object
		System.out.println("Hello");
	}

}
