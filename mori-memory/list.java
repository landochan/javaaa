import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class list {
	JButton nextbutton;
	JFrame f;
	JMenuBar menubar;
	JMenu menu;
	JMenuItem homef;
	JMenuItem buildf;
	JMenuItem playf;
	JPanel homepanel;
	JPanel qpanel;
	JPanel apanel;
	JPanel lastpanel;
	public list(){
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		f = new JFrame("MORI LIST");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menubar = new JMenuBar();
		menu = new JMenu("File");
		homef = new JMenuItem("Home");
		buildf = new JMenuItem("Build");
		playf = new JMenuItem("List");
	
		homepanel = new JPanel();
		qpanel = new JPanel();
		apanel = new JPanel();
		lastpanel = new JPanel();
		nextbutton = new JButton("Next");

		f.getContentPane().add(BorderLayout.CENTER, homepanel);
		homepanel.add(qpanel);
		homepanel.add(apanel);
		homepanel.add(lastpanel);
		lastpanel.add(nextbutton);

		homef.addActionListener(new moriaction());
		buildf.addActionListener(new buildaction());
		playf.addActionListener(new playaction());
		
		menubar.add(menu);
		menu.add(homef);
		menu.add(buildf);
		menu.add(playf);

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
	class playaction implements ActionListener {
		public void actionPerformed (ActionEvent ev) {
			f.dispose();
			playlist a = new playlist();
		}
	}
	class moriaction implements ActionListener {
		public void actionPerformed (ActionEvent ev) {
			f.dispose();
			mori a = new mori();
		}
	}
}
