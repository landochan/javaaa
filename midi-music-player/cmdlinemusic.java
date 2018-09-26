import javax.sound.midi.*;

public class cmdlinemusic {
	public static void main(String[] args) throws Exception {
		cmdlinemusic ne = new cmdlinemusic();
		System.out.println("start");

		if(args.length < 2){
			System.out.println("Don't forget the instrument");
		} else {
			int instrument = Integer.parseInt(args[0]);
			int note = Integer.parseInt(args[1]);
			
			ne.play(instrument, note);
		}
		System.out.println("finish");
	}

	public void play(int instrument, int note) {
		try {
			Sequencer seqr = MidiSystem.getSequencer();
			seqr.open();
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track newtrack = seq.createTrack();
			
			ShortMessage first = new ShortMessage();
			first.setMessage(192,1,instrument,50);
			MidiEvent changeinstrument = new MidiEvent(first, 1);
			newtrack.add(changeinstrument);
			ShortMessage b = new ShortMessage();
			b.setMessage(144,1,note,100);
			MidiEvent not = new MidiEvent(b,1);
			newtrack.add(not);
			
			ShortMessage c = new ShortMessage();
			c.setMessage(128,1,note,100);
			MidiEvent notaa = new MidiEvent (c, 16);
			newtrack.add(notaa);
			seqr.setSequence(seq);
			System.out.println("Sequence start");
			seqr.start();
			System.out.println("themusicplays");
		} catch(Exception ex){ex.printStackTrace();System.out.println("got caught");
		}
	}
}

