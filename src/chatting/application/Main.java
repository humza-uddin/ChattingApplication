package chatting.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {

	//Frame - Constructor
	Main(){
		
		setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(30,94,84));
		panel1.setBounds(0,0,450,70);
		panel1.setLayout(null);
		add(panel1);
		
		ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/angle-left.png"));
		Image icon1a = icon1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		ImageIcon icon1b = new ImageIcon(icon1a);
		JLabel back1 = new JLabel(icon1b);
		back1.setBounds(5,20,25,25);
		panel1.add(back1);
		
		back1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae)
			{
				System.exit(0);
			}
		});
		
		ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icons/phone-call.png"));
		Image icon2a = icon2.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		ImageIcon icon2b = new ImageIcon(icon2a);
		JLabel back2 = new JLabel(icon2b);
		back2.setBounds(280,20,25,25);
		panel1.add(back2);
		
		ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icons/search.png"));
		Image icon3a = icon3.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		ImageIcon icon3b = new ImageIcon(icon3a);
		JLabel back3 = new JLabel(icon3b);
		back3.setBounds(320,20,25,25);
		panel1.add(back3);
		
		ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.png"));
		Image icon4a = icon4.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		ImageIcon icon4b = new ImageIcon(icon4a);
		JLabel back4 = new JLabel(icon4b);
		back4.setBounds(360,20,25,25);
		panel1.add(back4);
		
		ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icons/angle-right.png"));
		Image icon5a = icon5.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		ImageIcon icon5b = new ImageIcon(icon5a);
		JLabel back5 = new JLabel(icon5b);
		back5.setBounds(400,20,25,25);
		panel1.add(back5);
		
		setSize(450, 700);
		setLocation(200, 30);
		getContentPane().setBackground(Color.WHITE);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
	}
	
	public static void main(String[] args) {
		
		new Main(); // Anonymous object
		System.out.println("Hello");
	}

}
