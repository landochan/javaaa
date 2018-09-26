import javax.swing.*;
import java.awt.*;
public class animationlvl1 {
	int x=70;
	int y=70;
	public static void main(String [] ags){
		animationlvl1 animation = new animationlvl1();
		animation.start();
	}

	public void start(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mydrawingpanel panel = new mydrawingpanel();
		frame.getContentPane().add(panel);
		frame.setSize(300,300);
		frame.setVisible(true);
		for(int i=0; i<130;i++){
			x++;
			y++;
			panel.repaint();
			try{
				Thread.sleep(50);
			}catch(Exception ex){
			}
		}
	}
	class mydrawingpanel extends JPanel{
		public void paintComponent(Graphics g){
			g.setColor(Color.black);
			g.fillRect(0,0,this.getWidth(),this.getHeight());
	
			g.setColor(Color.green);
			g.fillOval(x,y, 80,80);
		}
	}	
}

