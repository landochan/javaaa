import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class daikungfu{
	JFrame frame;
	JButton button1;
	JButton button2;
	static daikungfu nes;
	public static void main(String [] args){

		nes = new daikungfu();
		nes.startGUI();
	}

	public void startGUI(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button1 = new JButton("change to red");
		button2 = new JButton("change to green");
		button1.addActionListener(new changered());
		button2.addActionListener(new changegreen());
		frame.getContentPane().add(BorderLayout.NORTH, button1);
		frame.getContentPane().add(BorderLayout.SOUTH, button2);
		frame.setSize(900,900);
		frame.setVisible(true);
	}
	
	class changered extends JPanel implements ActionListener {
		public void actionPerformed(ActionEvent event){
			button1.setText("stay on red");
			button2.setText("change to green");
			frame.getContentPane().setBackground(Color.red);
		}
	
	}
	class changegreen extends JPanel implements ActionListener {
		public void actionPerformed(ActionEvent event){
			button2.setText("stay on green");
			button1.setText("change to red");
			frame.getContentPane().setBackground(Color.green);
		}
	}
}
