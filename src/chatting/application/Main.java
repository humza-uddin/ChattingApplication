package chatting.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.*;
import java.text.*;
import java.net.*;
import java.io.*;

public class Main implements ActionListener {

	JTextField text1;
	JPanel panel2;
	
	static Box vertical = Box.createVerticalBox();
	static JFrame f = new JFrame();
	static DataOutputStream dout;
	
	
	//Frame - Constructor
	Main(){
		
		f.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(30,94,84));
		panel1.setBounds(0,0,450,70);
		panel1.setLayout(null);
		f.add(panel1);
		
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
		
		panel2 = new JPanel();
		panel2.setBounds(5, 75, 440, 570);
		f.add(panel2);
		
		text1 = new JTextField();
		text1.setBounds(5, 655, 330, 40);
		text1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16) );
		f.add(text1);
		
		JButton send = new JButton("Send");
		send.setBounds(320,655,133,40);
		send.setBackground(new Color(30,94,84));
		  send.setForeground(Color.WHITE);
		send.addActionListener(this);
		send.setFont(new Font("SAN_SERIF", Font.PLAIN, 16) );
		f.add(send);
		
		f.setSize(450, 700);
		f.setLocation(200, 30); 
		f.setUndecorated(true);
		f.getContentPane().setBackground(Color.WHITE);
		
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {

		try {
		String out = text1.getText();
		
		JPanel output1 = formatLabel(out);
		
		panel2.setLayout(new BorderLayout());
		
		JPanel right = new JPanel(new BorderLayout());
		right.add(output1, BorderLayout.LINE_END);
		vertical.add(right);
		vertical.add(Box.createVerticalStrut(15));
		
		panel2.add(vertical, BorderLayout.PAGE_START);
		
		dout.writeUTF(out);
		
		text1.setText("");
		
		f.repaint();
		f.invalidate();
		f.validate();
	} catch (Exception a)
	{
		a.printStackTrace();
	}
	}
	public static JPanel formatLabel(String out) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel output = new JLabel("<html><p style=\"width:150 px\">" + out + "</p></html>");
		output.setFont(new Font("Tahoma", Font.PLAIN, 16));
		output.setBackground(new Color(37, 211,102));
		output.setOpaque(true);
		output.setBorder(new EmptyBorder(15, 15, 15,50));
		
		panel.add(output);
		
		Calendar cal= Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		
		JLabel time = new JLabel();
		time.setText(sdf.format(cal.getTime()));
		
		panel.add(time);
		
		return panel;
	}
	
	public static void main(String[] args) {
		
		new Main(); // Anonymous object
		System.out.println("TEST");
		
		try {
			ServerSocket skt = new ServerSocket(2000);
			while(true) {
				Socket s = skt.accept();
				DataInputStream din = new DataInputStream(s.getInputStream());
				dout = new DataOutputStream(s.getOutputStream());
				
				while(true) {
					String msg = din.readUTF();
					JPanel panel = formatLabel(msg);
					
					JPanel left = new JPanel(new BorderLayout());
					left.add(panel, BorderLayout.LINE_START);
					vertical.add(left);
					f.validate();
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
