import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.border.*;

public class playlist {	
	JMenuBar menubar;
	JMenu menu;
	JMenuItem buildf;
	JMenuItem listf;
	JMenuItem homef;
	static String ac;
	ArrayList<JButton> playbutton;
	JFrame f;
	JScrollPane scroller;
	JPanel homepanel;
	JPanel backpanel;
	JPanel leftpanel;
	JPanel rightpanel;
	JLabel a;
	LineBorder borderline;
	JButton b;
	ArrayList<String> namelist;
	public playlist(){
		menubar = new JMenuBar();
		menu = new JMenu("File");
		buildf = new JMenuItem("build");
		listf = new JMenuItem("list");
		homef = new JMenuItem("home");
		menubar.add(menu);
		menu.add(homef);
		menu.add(buildf);
		menu.add(listf);
		homef.addActionListener(new moriaction());
		buildf.addActionListener(new buildaction());
		listf.addActionListener(new listaction());


		ac = new String();
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		f= new JFrame("MORI PLAYER");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playbutton = new ArrayList<JButton>();
		leftpanel = new JPanel();
		rightpanel = new JPanel();
		backpanel = new JPanel();

		
		namelist = new ArrayList<String>();
		leftpanel.setLayout(new BoxLayout(leftpanel, BoxLayout.Y_AXIS));
		rightpanel.setLayout(new BoxLayout(rightpanel, BoxLayout.Y_AXIS));
		
		
		try { 	BufferedReader reader = new BufferedReader(new FileReader(new File("game")));
			String line = null;
			while((line = reader.readLine())!= null){
				String[] result = line.split("/");
				for(int i=0; i<result.length ; i++){
					namelist.add(result[i]);
				}
			}
		} catch (IOException ex){System.out.println("caught you"); ex.printStackTrace();}
		GridLayout grid = new GridLayout(namelist.size(), 2);
		homepanel = new JPanel(grid);
		borderline = new LineBorder(Color.white);

		homepanel.setBorder(borderline);
		backpanel.setBorder(borderline);
		f.getContentPane().add(BorderLayout.NORTH, backpanel);
		
		f.getContentPane().setBackground(Color.white);
		homepanel.setBackground(Color.white);
		backpanel.setBackground(Color.white);
		backpanel.setBorder(BorderFactory.createEmptyBorder(0,300,0,300));
		
		
		scroller = new JScrollPane(homepanel);
		scroller.setBorder(borderline);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		backpanel.add(scroller);
		for (int i=0; i< namelist.size(); i++) {
			a = new JLabel(namelist.get(i), JLabel.CENTER);
			homepanel.add(a);
			a.setBorder(BorderFactory.createEmptyBorder(0,0,0,40));
			b = new JButton("PLAY");
			String c = new String();
			c = namelist.get(i);
			playbutton.add(b);
			buttonaction d = new buttonaction();
			d.setfile(c);
			playbutton.get(i).addActionListener(d);
			homepanel.add(playbutton.get(i));
		}
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
	class buttonaction implements ActionListener {
		private String a;
		public void setfile (String b) {
			a= b;
		}
		public void actionPerformed(ActionEvent ev) {
			f.dispose();
			play c = new play (a);
		}
	}
}			

		
		
		
		
