import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
public class midiwithgui extends JPanel implements ControllerEventListener{
	static int i;
	static int j;
	JFrame frame;
	static midiwithgui a;
	public static void main (String[] args) throws MidiUnavailableException, InvalidMidiDataException {
		a = new midiwithgui();
		a.open();
	}

	public void open() throws MidiUnavailableException, InvalidMidiDataException{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screensize.width,screensize.height);
		frame.getContentPane().add(a);
		frame.setVisible(true);

		Sequencer seqr = MidiSystem.getSequencer();
		seqr.open();
		Sequence seq = new Sequence(Sequence.PPQ, 4);
		Track track = seq.createTrack();
		int[] thisevent = {127};
		seqr.addControllerEventListener(this, thisevent);
		for(i=60; i<120; i++){
			track.add(makeEvent(144,3,i,100,i));
			track.add(makeEvent(176,3,127,0,i));
			track.add(makeEvent(128,3,i,100,i+2));
		}
		for(j = 120;j>60;j--){
			track.add(makeEvent(144,3,j,100,i));
			track.add(makeEvent(176,3,127,100,i));
			track.add(makeEvent(128,3,j,100,i+2));
			i++;
		}
		seqr.setSequence(seq);
		seqr.start();
		
	}
		
	public MidiEvent makeEvent(int comd, int chan, int note1, int note2, int tempo){
		MidiEvent event = null;			
		try{ShortMessage mess = new ShortMessage();
		mess.setMessage(comd,chan,note1,note2);
		event = new MidiEvent(mess, tempo);
		} catch (Exception ex) {}
		return event;
	}
	boolean is = false;
	
	public void controlChange(ShortMessage event){
		is= true;
		a.repaint();
	}
	public void paintComponent(Graphics g){
		g.setColor(Color.red);
		g.fillRect(0,0,this.getWidth(), this.getHeight());
		if(is){
		int red = (int)(Math.random()* 250);
		int green = (int)(Math.random()* 250);
		int blue = (int)(Math.random()* 250);
		g.setColor(new Color(red, green, blue));
		int d = (int)(Math.random()* 120 +10);
		int f = (int)(Math.random()* 120 +10);
		int l = (int)(Math.random()* 40 +10);
		int h = (int)(Math.random()* 40+10);
		g.fillRect(l,h,d,f);
		is = false;
	}}

}
