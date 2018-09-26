import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
public class animationgravity {
	double x=50.0;
	double y=0.0;
	double z;
	int a;
	double vo;
	double t;
	double gravity;
	int b;
	double c;
	int limit;
	public static void main(String [] ags){
		animationgravity animation1 = new animationgravity();
		animation1.start();
	}

	public void start(){
		gravity = 10;
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mydrawingpanel panel = new mydrawingpanel();
		frame.getContentPane().add(panel);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		a = (int)screensize.width;
		b = (int)screensize.height;
		System.out.print(b);
		vo = Math.sqrt(2*gravity*(b-90));
		t= 2*(vo/gravity);
		limit =5000;
		
		
		frame.setSize(a,b);
		frame.setVisible(true);
			for(int e=0; e<limit;e++){
			if(e==limit-2){e=0;}
			x+=0.02;
			y= e*t/limit;
			z =b-90-(vo*y)+(0.5*gravity*y*y);
			panel.repaint();
			try{
				Thread.sleep(2);
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

