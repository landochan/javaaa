import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class mori {
	JFrame f;
	JButton build;
	JButton play;
	JButton list;
	JMenuBar menubar;
	JMenu menu;
	JMenuItem buildf;
	JMenuItem playf;
	JMenuItem listf;
	JPanel pplay;
	JPanel pbuild;
	JPanel plist;
	public static void main (String[] args){
		mori mori1 = new mori();

	}
	
	public mori(){
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		f = new JFrame("MORI by LANDO CHAN");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menubar = new JMenuBar();
		menu = new JMenu("File");
		buildf = new JMenuItem("Build");
		build = new JButton("Build");
		build.setBackground(Color.red);
		build.setForeground(Color.white);
		build.setFont(new Font("Arial", Font.PLAIN, 20));
		playf = new JMenuItem("Play");
		play = new JButton("Play");
		play.setBackground(Color.red);
		play.setForeground(Color.white);
		play.setFont(new Font("Arial", Font.PLAIN, 20));
		listf = new JMenuItem("List");
		list = new JButton("List");
		list.setBackground(Color.red);
		list.setForeground(Color.white);
		list.setFont(new Font("Arial", Font.PLAIN, 20));
		homebackground phome = new homebackground();

		pbuild = new JPanel();
		pbuild.setOpaque(false);
		pbuild.setBorder(BorderFactory.createEmptyBorder(150,0,0,0));
		pplay = new JPanel();
		pplay.setOpaque(false);
		pplay.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		plist = new JPanel();
		plist.setOpaque(false);
		plist.setBorder(BorderFactory.createEmptyBorder(0,0,600,0));

		buildf.addActionListener(new buildaction());
		build.addActionListener(new buildaction());
		playf.addActionListener(new playaction());
		play.addActionListener(new playaction());
		listf.addActionListener(new listaction());
		list.addActionListener(new listaction());
		
		phome.add(pbuild);
		phome.add(pplay);
		phome.add(plist);
		
		phome.setLayout(new BoxLayout(phome, BoxLayout.Y_AXIS));

		menubar.add(menu);
		menu.add(buildf);
		menu.add(playf);
		menu.add(listf);

		f.setJMenuBar(menubar);
		
		f.getContentPane().add(BorderLayout.CENTER, phome);
		pbuild.add(build);
		pplay.add(play);
		plist.add(list);
		
		f.setSize(screen.width, screen.height);
		f.setVisible(true);
	}

	class homebackground extends JPanel {
		public void paintComponent (Graphics g){
			BufferedImage image = null;
			File f = null;
			try{
				f = new File ("welcome.jpg");
				image = new BufferedImage(1350, 740, BufferedImage.TYPE_INT_ARGB);
				image = ImageIO.read(f);
			} catch (IOException ex){System.out.print("caught"); ex.printStackTrace();}
			g.drawImage(image,0,0,1350,740,null);
		}
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
	class listaction implements ActionListener {
		public void actionPerformed (ActionEvent ev) {
			f.dispose();
			list a = new list();
		}
	}
		
}

		
