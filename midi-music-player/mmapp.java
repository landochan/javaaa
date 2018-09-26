import javax.sound.midi.*;
public class mmapp {
	public static void main(String [] args){
		mmapp musicapp = new mmapp();
		musicapp.play();
		System.out.println("music plays");
	}

	public void play() {
		try {
			Sequencer s = MidiSystem.getSequencer();
			s.open();
			System.out.println("sequencer has been opened.");
			neSequence seq = new neSequence(Sequence.PPQ, 4);
			System.out.println("Sequence created");
			Track track = seq.createTrack();
			ShortMessage a = new ShortMessage();
			a.setMessage(144,1,44,100);
			MidiEvent noteon = new MidiEvent(a, 1);
			MidiEvent noteon1 = new MidiEvent (a,16);
			track.add(noteon);
			track.add(noteon1);
			ShortMessage b = new ShortMessage();
			b.setMessage(128,1,44,100);
			MidiEvent noteoff = new MidiEvent (b,30);
			System.out.println("Midievent created");
			track.add(noteoff);

			s.setSequence(seq);
			s.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
			

