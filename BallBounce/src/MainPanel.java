import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	int speed = 3;
	Timer timer;
	CollisionDetection c;
	BallCollider bc;
	int wOffset = 23;
	int hOffset = 57;
	BallList bl;
	
	public MainPanel(int w, int h, BallList bl){
		setBackground(Color.BLACK);
		setFocusable(true);
		timer = new Timer(speed, this);
		timer.start();
		c = new CollisionDetection(w-wOffset, h-hOffset);
		bc = new BallCollider();
		this.bl = bl;
		
	}
	
	private void stepGraphics(){
		
		System.out.println(bl.getSize());
		for (int i=0; i < bl.getSize(); i++){
			Ball tempBall = bl.getBall(i);
			if(c.horizontalWallHit(tempBall)){
				tempBall.setySpeed(tempBall.getySpeed()*-1);
			}
			if(c.verticalWallHit(tempBall)){
				tempBall.setxSpeed(tempBall.getxSpeed()*-1);
			}
			if (i < bl.getSize()-1){
				for (int j = i+1; j < bl.getSize(); j++){
					Ball nextBall = bl.getBall(j);
					if (c.ballBallHit(tempBall, nextBall)){
						bc.calculateVector(tempBall, nextBall);
						tempBall.setxSpeed(bc.getBallAX());
						tempBall.setySpeed(bc.getBallAY());
						nextBall.setxSpeed(bc.getBallBX());
						nextBall.setySpeed(bc.getBallBY());
					}
				}

			}
		}		

		repaint();
	}
	
	@Override
	public void paint(Graphics g){
		super.paintComponent(g);
		
		for (int i=0; i < bl.getSize(); i++){
			Ball tempBall = bl.getBall(i);
			
			if (tempBall.getMass() <= 2){
				g.setColor(Color.RED);
			} else if (tempBall.getMass() <= 5){
				g.setColor(Color.GREEN);
			} else if (tempBall.getMass() <= 8){
				g.setColor(Color.BLUE);
			} else {
				g.setColor(Color.ORANGE);
			}
			
			g.fillOval((int) tempBall.getxPos(), (int)tempBall.getyPos(), tempBall.getRadius()*2, tempBall.getRadius()*2);
			
			tempBall.setxPos((float) (tempBall.getxPos()+tempBall.getxSpeed()));
			tempBall.setyPos((float) (tempBall.getyPos()+tempBall.getySpeed()));
		}	
	}

	@Override
	
	public void actionPerformed(ActionEvent arg0) {
		stepGraphics();
	}
	

}
