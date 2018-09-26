import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class newplayer {
	JTextField insertarea;
	public static void main (String[] args) {
		newplayer player1 = new newplayer();
	}
	public newplayer(){
		JFrame frame = new JFrame ("New Player");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainpanel = new JPanel ();
		insertarea = new JTextField(30);
		JButton createbutton = new JButton("Create");
		createbutton.addActionListener(new createlistener());
		frame.getContentPane().add(BorderLayout.CENTER, mainpanel);
		mainpanel.add(insertarea);
		mainpanel.add(createbutton);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize (screen.width, screen.height);
		frame.setVisible(true);
	}
	public class createlistener implements ActionListener {
		public void actionPerformed (ActionEvent ev) {
			System.out.println ("clicked");
			funnyclient a = new funnyclient();
			a.name = insertarea.getText();
		}
	}
}
		
	
