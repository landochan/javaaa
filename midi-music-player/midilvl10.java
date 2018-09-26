import javax.sound.midi.*;

public class midilvl10{
	static int i;
	static int j;
	public static void main(String[] args)throws MidiUnavailableException, InvalidMidiDataException{
		
		Sequencer seqr = MidiSystem.getSequencer();
		seqr.open();
		neSequence seq = new neSequence();
		Track trackk = seq.createTrack();
		for(i =5;i<61;i++){
			trackk.add(getEvent(144,3,i,100,i));
			trackk.add(getEvent(128,3,i,100,i+2));
			System.out.println(i);
		}
		
		for(j = 61;j>5;j--){
			trackk.add(getEvent(144,3,j,100,i));
			trackk.add(getEvent(128,3,j,100,i+2));
			i++;
			System.out.println(i);
		}
		seqr.setSequence(seq);
		seqr.start();	
	}

	


	public static MidiEvent getEvent(int command, int channel, int data1, int data2, int tempo){
		MidiEvent event = null;
		try{
			ShortMessage mess = new ShortMessage();
			mess.setMessage(command, channel, data1, data2);
			event = new MidiEvent(mess, tempo);
			
		}catch(Exception ex) {}
		return event;
	
	}
}
		
