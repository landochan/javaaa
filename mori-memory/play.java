import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class play {
	static int jj;
	static int limitnum;
	String[] qanda;
	JLabel displaylabel;
	JTextArea display;
	JButton nextbutton;
	JFrame f;
	JMenuBar menubar;
	JMenu menu;
	JMenuItem homef;
	JMenuItem buildf;
	JMenuItem listf;
	JPanel homepanel;
	JPanel panel;
	JPanel lastpanel;

	public play(String v){
		jj =0;
		display = new JTextArea(10,20);
		display.setEditable(false);
		displaylabel = new JLabel("Question :");
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		f = new JFrame("MORI PLAYER");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		menubar = new JMenuBar();
		menu = new JMenu("File");
		homef = new JMenuItem("Home");
		buildf = new JMenuItem("Build");
		listf = new JMenuItem("List");
	
		homepanel = new JPanel();
		panel = new JPanel();
		panel.add(displaylabel);
		panel.add(display);
		lastpanel = new JPanel();
		nextbutton = new JButton("Answer");
		nextbutton.addActionListener(new playing());

		File filepath = new File(v);
		try{
			BufferedReader reader = new BufferedReader (new FileReader (filepath));
			String abc = null;
			String cba = new String("");
			while((abc = reader.readLine()) != null) {
				cba += abc;
			}
			reader.close();
			qanda = cba.split("/");
		}catch (IOException exc){exc.printStackTrace();}
		display.setText(qanda[jj]);
		jj++;
		limitnum = (qanda.length) -1;
		

		f.getContentPane().add(BorderLayout.CENTER, homepanel);
		homepanel.add(panel);
		homepanel.add(lastpanel);
		lastpanel.add(nextbutton);

		homef.addActionListener(new moriaction());
		buildf.addActionListener(new buildaction());
		listf.addActionListener(new listaction());
		
		menubar.add(menu);
		menu.add(homef);
		menu.add(buildf);
		menu.add(listf);

		f.setJMenuBar(menubar);
		f.setSize(screen.width, screen.height);
		f.setVisible(true);
	}
	class buildaction implements ActionListener {
		public void actionPerformed (ActionEvent ev) {
			f.dispose();
			build a = new build();
		}
	}
	class listaction implements ActionListener {
		public void actionPerformed (ActionEvent ev) {
			f.dispose();
			list a = new list();
		}
	}
	class moriaction implements ActionListener {
		public void actionPerformed (ActionEvent ev) {
			f.dispose();
			mori a = new mori();
		}
	}
	class playing implements ActionListener {
		public void actionPerformed (ActionEvent ev) {
			if(limitnum >0){
				if((jj%2)==0){
					displaylabel.setText("Question :");
					nextbutton.setText("Answer");
				}
				if((jj%2)!= 0){
					displaylabel.setText("Answer :");
					nextbutton.setText("Next Question");
				}
				display.setText(qanda[jj]);
				jj++;
				limitnum--;
			}
			else {
			displaylabel.setText("FINISH");
			displaylabel.setFont(new Font("Arial", Font.PLAIN, 30));
			display.setText("");
			display.setVisible(false);
			nextbutton.setVisible(false);
			}
		}
	}			
}
