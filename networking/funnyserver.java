import java.io.*;
import java.net.*;
import java.util.*;
public class funnyserver {
	ArrayList<PrintWriter> writercollection;
	public static void main(String[] args) {
		funnyserver mainserver = new funnyserver();
		mainserver.go();
	}
	public void go(){
		writercollection = new ArrayList<PrintWriter>();
		try {		
			
			ServerSocket ss = new ServerSocket(5000);
			while(true) {
				Socket sock = ss.accept();
				PrintWriter pw = new PrintWriter (sock.getOutputStream());
				writercollection.add(pw);
				Thread t = new Thread(new getreader(sock));
				t.start();
				System.out.println("connection established");
			}
		}catch(Exception ex ){ex.printStackTrace(); }
	}
	
	public class getreader implements Runnable {
		BufferedReader br;
		String message;
		Socket sock23;
		public getreader (Socket sock) {
			try{	
				sock23 = sock;
				System.out.println("connection made");
				InputStreamReader isr = new InputStreamReader(sock23.getInputStream());
				br = new BufferedReader(isr);
				System.out.println("connection made");
			}catch(Exception ex) {ex.printStackTrace(); }
		}
		public void run() {
			System.out.println("running");
			try {
				while ((message = br.readLine())!= null) {
					System.out.println ("read " + message);
					telleveryone(message);
				}
			}catch(Exception ex ) {ex.printStackTrace(); 
			}
		}
		
	}
	public void telleveryone(String message) {
		Iterator it = writercollection.iterator();
		try{	while(it.hasNext()){
				PrintWriter pw = (PrintWriter) it.next();
				pw.println(message);
				pw.flush();
			}
		}catch (Exception ex) {ex.printStackTrace(); }

	}
}			
