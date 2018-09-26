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
			button1.setText("Ouchhhhh");
			mydrawpanel1 panel1 = new mydrawpanel1();
			frame.getContentPane().add(BorderLayout.CENTER, panel1);
			nes.startGUI1();
		}
		class mydrawpanel1 extends JPanel{
			public void paintComponent(Graphics j){
				j.setColor(Color.red);
				j.fillRect(0,0,this.getWidth(),this.getHeight());
			}
		}
	}
	class changegreen extends JPanel implements ActionListener {
		public void actionPerformed(ActionEvent event){
			button2.setText("Oucchhh");
			mydrawpanel2 panel2 = new mydrawpanel2();
			frame.getContentPane().add(BorderLayout.CENTER, panel2);
			nes.startGUI2();
		}
		class mydrawpanel2 extends JPanel{
			public void paintComponent(Graphics g){
				g.setColor(Color.green);
				g.fillRect(0,0,this.getWidth(),this.getHeight());
			}
		}
	}
	public void startGUI1(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button1 = new JButton("Stay on red");
		button2 = new JButton("change to green");
		button2.addActionListener(new changegreen());
		frame.getContentPane().setBackground(Color.red);
		frame.getContentPane().add(BorderLayout.SOUTH, button2);
		frame.getContentPane().add(BorderLayout.NORTH, button1);
		frame.setSize(900,900);
		frame.setVisible(true);
	}	
	public void startGUI2(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button1 = new JButton("change to red");
		button2 = new JButton("stay on green");
		button1.addActionListener(new changered());
		frame.getContentPane().add(BorderLayout.NORTH, button1);
		frame.getContentPane().add(BorderLayout.SOUTH, button2);
		frame.getContentPane().setBackground(Color.green);
		frame.setSize(900,900);
		frame.setVisible(true);
	}		
}
