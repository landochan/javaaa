import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
public class cfile {
	JButton nextbutton;
	JButton lastbutton;
	JMenuBar menubar;
	JMenu menu;
	String saveforlater;
	String stringtowrite;
	JFrame f;
	JMenuItem homef;
	JMenuItem playf;
	JMenuItem listf;
	JPanel qpanel;
	JPanel apanel;
	JPanel lastpanel;
	JPanel qlabelpanel;
	JPanel alabelpanel;
	JPanel qtextareapanel;
	JPanel atextareapanel;
	JLabel qlabel;
	JLabel alabel;
	JTextArea qtextarea;
	JTextArea atextarea;
	public cfile(String filename){
		stringtowrite = new String();
		saveforlater = new String();
		saveforlater = filename;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		f = new JFrame("MORI BUILDER");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menubar = new JMenuBar();
		menu = new JMenu("File");
		homef = new JMenuItem("Home");
		playf = new JMenuItem("Play");
		listf = new JMenuItem("List");
		qlabel = new JLabel("Question", JLabel.CENTER);
		alabel = new JLabel("Answer", JLabel.CENTER);
		qtextarea = new JTextArea(10,20);
		qtextarea.setLineWrap(true);
		atextarea = new JTextArea(10,20);
		atextarea.setLineWrap(true);
		qlabelpanel = new JPanel();
		qlabelpanel.setOpaque(false);	
		alabelpanel = new JPanel();
		alabelpanel.setOpaque(false);
		qtextareapanel = new JPanel();
		qtextareapanel.setOpaque(false);
		atextareapanel = new JPanel();
		atextareapanel.setOpaque(false);
	
		BuildPanel homepanel = new BuildPanel();			

		qlabelpanel.add(qlabel);
		qtextareapanel.add(qtextarea);
		alabelpanel.add(alabel);
		atextareapanel.add(atextarea);
		homepanel.setLayout(new BoxLayout(homepanel, BoxLayout.Y_AXIS));
		qpanel = new JPanel();
		qpanel.setLayout(new BoxLayout(qpanel, BoxLayout.Y_AXIS));
		apanel = new JPanel();
		apanel.setLayout(new BoxLayout(apanel, BoxLayout.Y_AXIS));
		lastpanel = new JPanel();
		nextbutton = new JButton("Next Card");
		lastbutton = new JButton ("Last Card");
		nextbutton.addActionListener(new saveaction());
		lastbutton.addActionListener(new finalcard());
	
		qpanel.add(qlabelpanel);
		qpanel.add(qtextareapanel);
		apanel.add(alabelpanel);
		apanel.add(atextareapanel);

		f.getContentPane().add(BorderLayout.CENTER, homepanel);
		homepanel.add(qpanel);
		qpanel.setOpaque(false);
		homepanel.add(apanel);
		apanel.setOpaque(false);
		homepanel.add(lastpanel);
		lastpanel.setOpaque(false);
		lastpanel.add(nextbutton);
		lastpanel.add(lastbutton);

		homef.addActionListener(new moriaction());
		playf.addActionListener(new playaction());
		listf.addActionListener(new listaction());
		
		menubar.add(menu);
		menu.add(homef);
		menu.add(playf);
		menu.add(listf);

		f.setJMenuBar(menubar);
		f.setSize(screen.width, screen.height);
		f.setVisible(true);
	}
	
	class saveaction implements ActionListener {
		public void actionPerformed (ActionEvent ev) {
			stringtowrite += qtextarea.getText() + "/" + atextarea.getText() + "/" + "\n";
			qtextarea.setText("");
			atextarea.setText("");
		}
	}
	class finalcard implements ActionListener {
		public void actionPerformed (ActionEvent ev){		
			stringtowrite += qtextarea.getText() + "/" + atextarea.getText() ;
			File filepath = new File(saveforlater);
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter (filepath));
				writer.write(stringtowrite);
				writer.close();
			} catch(IOException ex) { System.out.print("caught"); ex.printStackTrace(); }
			try {	
				File a = new File ("game");
				if (a.exists()){
					BufferedReader reader = new BufferedReader (new FileReader ("game"));
					String message = null;
					String message1 = null;
					message1 = "";
					while ((message = reader.readLine()) != null ){
						message1 += message;
					}	
					reader.close();
					BufferedWriter writer1 = new BufferedWriter(new FileWriter (new File("game")));
					writer1.write(message1 + saveforlater + "/");
					writer1.close();
				}
				else {
					BufferedWriter writer1 = new BufferedWriter(new FileWriter (new File("game")));
					writer1.write(saveforlater + "/");
					writer1.close();
				}
			} catch (IOException excc) { System.out.print("caught"); excc.printStackTrace(); }
			f.setVisible(false);
			mori a = new mori();
		}
	}
	class BuildPanel extends JPanel {
		public void paintComponent (Graphics g){
			BufferedImage image = null;
			File f = null;
			try {
				f= new File("build.jpg");
				image = new BufferedImage(1350,740,BufferedImage.TYPE_INT_ARGB);
				image = ImageIO.read(f);
			} catch( IOException e){System.out.print("caught"); e.printStackTrace();}
			g.drawImage(image,0,0,1350,740,null);
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

