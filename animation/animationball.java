import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
public class animationball {
	double x=70.0;
	double y=70.0;
	double z;
	public static void main(String [] ags){
		animationball animation = new animationball();
		animation.start();
	}

	public void start(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mydrawingpanel panel = new mydrawingpanel();
		frame.getContentPane().add(panel);
		frame.setSize(this.getWidth(), this.getHeight());
		frame.setVisible(true);
		for(int i=0; i<100000;i++){
			x+=0.2;
			y+=0.01;
			z = 
			panel.repaint();
			try{
				Thread.sleep(5);
			}catch(Exception ex){
			}
		}
	}
	class mydrawingpanel extends JPanel{
		public void paintComponent(Graphics g){
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.yellow);
			g2d.fillRect(0,0,this.getWidth(),this.getHeight());
	
			g2d.setColor(Color.green);
			Ellipse2D.Double shape = new Ellipse2D.Double(x,z,40,40);
			g2d.fill(shape);
		}
	}	
}

