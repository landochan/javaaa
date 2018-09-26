import javax.swing.*;
import java.awt.*;
public class shrinkingcircle {
	JFrame frame;
	int a;
	int b;
	int x;
	int y=600;
	public static void main(String[] args){
		shrinkingcircle circle = new shrinkingcircle();
		circle.shrink();
	}
	public void shrink(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screensize.width,screensize.height);
		frame.setVisible(true);
		mydrawingboard panel = new mydrawingboard();
		frame.getContentPane().add(panel);
		for (x= 1600;x>0; x--){
			y++;
			panel.repaint();
			try{
				Thread.sleep(60);
			} catch(Exception ex){
			}
		}
	}
	
		




	class mydrawingboard extends JPanel {
		public void paintComponent(Graphics g){
			g.setColor(Color.white);
			g.fillRect(0,0,this.getWidth(), this.getHeight());
			a= (int)this.getWidth();
			b= (int)this.getHeight();
			g.setColor(Color.black);
			g.fillOval((a-x)/2,(b-x)/2,x,x);
			g.setColor(Color.white);
			g.fillOval((a-y)/2,(b-y)/2,y,y);
		}
	}
}
