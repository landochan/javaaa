import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class BeatBox2 {
	Track track;
	Sequencer seqr;
	Sequence seq;
	JButton savebutton;
	JButton restorebutton;
	JFrame f;
	JPanel pstart;
	JPanel pgrid;
	JPanel pinstrument;
	JPanel panelfront;
	JLabel lNORTH;
	JLabel lSOUTH;
	JScrollPane scroller;
	JButton l1;
	JButton l2;
	JButton l3;
	JButton l4;
	ArrayList<String> instrumentnames = new ArrayList<String>();
	ArrayList<JCheckBox> listofcheckboxes = new ArrayList<JCheckBox>();
	int numofins = 127;
	int beatsin = 20;
	int totalcheck = numofins * beatsin;
	int w = (totalcheck - 1);
	int[] instrumentcodes = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128};
	public static void main(String [] args) {
		BeatBox2 bb = new BeatBox2();
		bb.getinstrumentnames();
		bb.makedisplay();
	}
	
	public void getinstrumentnames(){
		try{ Synthesizer s = MidiSystem.getSynthesizer();
			s.open();
			Instrument[] instrumentName = s.getAvailableInstruments();
			for(int i=0; i<instrumentName.length;i++){
				String aaa = new String();
				aaa = instrumentName[i].getName();
				instrumentnames.add(aaa);
			}
		}catch (MidiUnavailableException eu){}
	}
			
	public void makedisplay(){
		f = new JFrame("Music Player");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout grid = new GridLayout(numofins, beatsin);
		pstart = new JPanel();
		pgrid = new JPanel(grid);
		pinstrument = new JPanel();

		restorebutton = new JButton("restore");
		savebutton = new JButton("save");
		restorebutton.addActionListener(new restoreclass());
		savebutton.addActionListener(new saveclass());

		panelfront = new JPanel();
		
		scroller = new JScrollPane(panelfront);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelfront.add(pinstrument);
		panelfront.add(pgrid);
	

		lNORTH =new JLabel("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20", JLabel.CENTER);
		lNORTH.setFont(new Font("Arial", Font.PLAIN, 15));
		lSOUTH= new JLabel("©LandoChan");
		lSOUTH.setFont(new Font("Calibri",Font.PLAIN, 25));
		

		Box box = new Box (BoxLayout.Y_AXIS);
		Box box1 = new Box (BoxLayout.Y_AXIS);
		
		f.getContentPane().add(BorderLayout.NORTH, lNORTH);
		f.getContentPane().add(BorderLayout.SOUTH, lSOUTH);
		f.getContentPane().add(BorderLayout.EAST, pstart);
		f.getContentPane().add(BorderLayout.CENTER, scroller);
		

		l1 = new JButton("Start");
		l2 = new JButton("Stop");
		l3 = new JButton("Tempo Up");
		l4 = new JButton("Tempo Down");
		
		box1.add(l1);
		box1.add(l2);
		box1.add(l3);
		box1.add(l4);
		box1.add(savebutton);
		box1.add(restorebutton);
		

		l1.addActionListener(new start());
		l2.addActionListener(new stop());
		l3.addActionListener(new tempoup());
		l4.addActionListener(new tempodown());

		
		for (int i= 0; i<numofins ; i++){
			JLabel instrumen = new JLabel(instrumentnames.get(i));
			instrumen.setFont(new Font("Arial", Font.PLAIN, 20));
			box.add(instrumen);
		}
		pinstrument.add(box);
		pstart.add(box1);
	
		for(int j =0;j<totalcheck;j++){
			JCheckBox b = new JCheckBox();
			b.setSelected(false);
			b.setBorder(BorderFactory.createEmptyBorder(0,5,12,0));
			pgrid.add(b);
			listofcheckboxes.add(b);
		}
		Dimension  screensize = Toolkit.getDefaultToolkit().getScreenSize();
		f.setSize(screensize.width, screensize.height);
		f.pack();
		f.setVisible(true);
	}

	public class start implements ActionListener {
		public void actionPerformed(ActionEvent event){
			starting();
		}
	}
	public void starting() {
		try {seqr = MidiSystem.getSequencer();
		seq = new Sequence (Sequence.PPQ, 4);
		seqr.open();
		seqr.setTempoInBPM(300);
		seqr.setLoopCount(seqr.LOOP_CONTINUOUSLY);
				
		Track track = seq.createTrack();
			
		System.out.println("stage0");
		int m;
		int o;
		int p;			
		int n;
				
		System.out.println("stage1");

		for(int k=0;k<w;k++){
				
			m = k+1;
			o = m % beatsin;				
			p = m-o;
			n = p/beatsin;
						
			if(listofcheckboxes.get(k).isSelected()==true){
				track.add(makeEvent(144,1,instrumentcodes[n],100,o));
				track.add(makeEvent(128,1,instrumentcodes[n],100,o+2));
			}
		}
		System.out.println("stage 2");
		seqr.setSequence(seq);
		seqr.start();
		System.out.println("sTART LINKK");
		} catch (Exception e){ System.out.println("caught you"); e.printStackTrace();}
			
	}	
	
	public class stop implements ActionListener {
		public void actionPerformed(ActionEvent event){
			seqr.stop();
			System.out.println("STOPPP");
		}
	}
	
	public class tempoup implements ActionListener {
		public void actionPerformed(ActionEvent event){
			float speed = seqr.getTempoFactor();
			seqr.setTempoFactor((float)(speed* 1.03));
		}
	}

	public class tempodown implements ActionListener {
		public void actionPerformed(ActionEvent event){
			float speed = seqr.getTempoFactor();
			seqr.setTempoFactor ((float) (speed*.97));
		}
	}
	public class saveclass implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			boolean[] checkboxlisting = new boolean[2540];
			for(int i=0;i<2540;i++){
				JCheckBox checkbox = (JCheckBox) listofcheckboxes.get(i);
				if(checkbox.isSelected()){
					checkboxlisting[i] = true;
				}
			}
			try {
				ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream (new File("check.ser")));
				oos.writeObject(checkboxlisting);
				oos.close();
			} catch(Exception ex) {System.out.println("caught"); ex.printStackTrace();}
		}
	}
	public class restoreclass implements ActionListener {
		public void actionPerformed (ActionEvent ev) {
			boolean[] checkboxlisting2= new boolean[2540];
			try {
				ObjectInputStream ois = new ObjectInputStream( new FileInputStream (new File("check.ser")));
				checkboxlisting2 = (boolean[]) ois.readObject();
				ois.close();
			} catch (Exception ec) { System.out.println("caught2"); ec.printStackTrace();}
			for(int j = 0; j<2540; j++){
				if(checkboxlisting2[j]){
					listofcheckboxes.get(j).setSelected(true);
				}
				else {
					listofcheckboxes.get(j).setSelected(false);
				}
			}
			starting();
		}
	}
			

	
	public static MidiEvent makeEvent(int comd, int chan, int code1, int code2, int time){
		MidiEvent event = null;		
		try{ShortMessage messge = new ShortMessage();
		messge.setMessage(comd, chan, code1, code2);
		event = new MidiEvent(messge, time);
		System.out.println("reached");
		} catch(Exception e){
		e.printStackTrace();
		}
		return event;
	}
}
			

		
		
		
		
		
		
		
