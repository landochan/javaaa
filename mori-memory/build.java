import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
public class build {
	JLabel insertfilelabel;
	JTextField filename;
	JFrame f;
	JPanel filepanel;
	JPanel filepanel1;
	JPanel filepanel2;
	JButton createfile;
	JMenuBar menubar;
	JMenu menu;
	JMenuItem homef;
	JMenuItem playf;
	JMenuItem listf;
	
	public build() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		f = new JFrame("MORI BUILDER");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		insertfilelabel = new JLabel("Insert the name for this class of card you are going to create");
		menubar = new JMenuBar();
		menu = new JMenu("File");
		homef = new JMenuItem("Home");
		playf = new JMenuItem("Play");
		listf = new JMenuItem("List");
		homef.addActionListener(new moriaction());
		playf.addActionListener(new playaction());
		listf.addActionListener(new listaction());
		menubar.add(menu);
		menu.add(homef);
		menu.add(playf);
		menu.add(listf);

		f.setJMenuBar(menubar);
		createfile =new JButton("Continue creating");
		createfile.addActionListener(new createf());
		filename = new JTextField(20);
		filepanel = new JPanel();
		filepanel1= new JPanel();
		filepanel1.setBorder(BorderFactory.createEmptyBorder(270,0,0,0));
		filepanel2 = new JPanel();
		filepanel2.setBorder(BorderFactory.createEmptyBorder(0,0,270,0));
		filepanel.setLayout(new BoxLayout(filepanel, BoxLayout.Y_AXIS));
		filepanel.add(filepanel1);
		filepanel.add(filepanel2);
		f.getContentPane().add(BorderLayout.CENTER, filepanel);
		filepanel1.add(insertfilelabel);
		filepanel1.add(filename);
		filepanel2.add(createfile);
		f.setSize(screen.width, screen.height);
		f.setVisible(true);

	}
	class createf implements ActionListener {
		public void actionPerformed (ActionEvent ev) {
			f.dispose();
			String b = filename.getText();
			cfile a = new cfile(b);
		}
	}
	class playaction implements ActionListener {
		public void actionPerformed (ActionEvent ev) {
			f.dispose();
			playlist a = new playlist();
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
}
