import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	int speed = 4;
	Timer timer;
	CollisionDetection c;
	BallList bl;
	BallCollider bc;
	Ball ballA;
	Ball ballB;
	Ball ballC;
	int wOffset = 23;
	int hOffset = 57;
	
	public MainPanel(int w, int h){
		setBackground(Color.BLACK);
		setFocusable(true);
		timer = new Timer(speed, this);
		timer.start();
		c = new CollisionDetection(w-wOffset, h-hOffset);
		bc = new BallCollider();
		
		ballA = new Ball(50, 50, 12, 5, 5, 1);
		ballB = new Ball(300, 300, 25, -3, -3, 3);
		ballC = new Ball(500, 100, 50, 2, -2, 6);
		bl = new BallList();
		bl.addBall(ballA);
		bl.addBall(ballB);
		bl.addBall(ballC);

	}
	
	private void stepGraphics(){

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
		g.setColor(Color.RED);
		g.fillOval(ballA.getxPos(), ballA.getyPos(), ballA.getRadius()*2, ballA.getRadius()*2);
		g.setColor(Color.BLUE);
		g.fillOval(ballB.getxPos(), ballB.getyPos(), ballB.getRadius()*2, ballB.getRadius()*2);
		g.setColor(Color.GREEN);
		g.fillOval(ballC.getxPos(), ballC.getyPos(), ballC.getRadius()*2, ballC.getRadius()*2);

		for (int i=0; i < bl.getSize(); i++){
			Ball tempBall = bl.getBall(i);
			tempBall.setxPos((int) (tempBall.getxPos()+tempBall.getxSpeed()));
			tempBall.setyPos((int) (tempBall.getyPos()+tempBall.getySpeed()));
		}	
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		stepGraphics();
	}
	

}
