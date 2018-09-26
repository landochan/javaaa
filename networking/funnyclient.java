import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class funnyclient {
	String name;
	JTextField inputarea;
	JTextArea outputarea;
	JButton sendbutton;
	PrintWriter pw;
	BufferedReader br;
	Socket sock;
	public funnyclient(){
		System.out.println("reached constructor");
		JFrame f = new JFrame("Chat Display");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainpanel = new JPanel();
		JPanel uppanel = new JPanel();
		JPanel downpanel = new JPanel ();
		outputarea = new JTextArea (15,30);
		outputarea.setEditable(false);
		outputarea.setLineWrap(true);
		outputarea.setWrapStyleWord(true);
		JScrollPane scroller = new JScrollPane(outputarea);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		inputarea = new JTextField(30);
		sendbutton = new JButton ("Send");
		sendbutton.addActionListener(new sendlistener());
		JPanel uppanell = new JPanel();
		JPanel downpanell = new JPanel();
		uppanell.add(scroller);
		downpanell.add(inputarea);
		downpanell.add(sendbutton);
		uppanel.add(uppanell);
		downpanel.add(downpanell);
		f.getContentPane().add(BorderLayout.CENTER, mainpanel);
		mainpanel.add(uppanel);
		mainpanel.add(downpanel);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		manageconnection();
		try {
			Thread display = new Thread(new displayrunnable());
			display.start();
		} catch (Exception ex ){ ex.printStackTrace(); }
		f.setSize(screen.width, screen.height);
		f.setVisible(true);
	}
	
	public void manageconnection() {
		try {
			sock = new Socket("127.0.0.1", 5000);
			InputStreamReader isr = new InputStreamReader(sock.getInputStream());
			br = new BufferedReader (isr);
			pw = new PrintWriter (sock.getOutputStream());
			System.out.println("connection established");
		} catch (Exception ex) {ex.printStackTrace(); }
	}
	
	public class displayrunnable implements Runnable {
		public void run() {
			System.out.println("it reached me");
			String message;
			try{	
				while ((message = br.readLine())!= null) {
					System.out.println("read "+ message);
					outputarea.append(name + " : " + message +"\n");
				}
			}catch(Exception ex ){ ex.printStackTrace(); }
		}
	}

	public class sendlistener implements ActionListener{
		public void actionPerformed (ActionEvent ev){ 
			String letter = new String(inputarea.getText());
			pw.println(letter);
			pw.flush();
			System.out.println ("Sending " + letter);
			inputarea.setText("");
		}
	}
}
