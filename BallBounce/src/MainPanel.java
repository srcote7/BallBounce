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
	BallList bl;
	BallCollider bc;
	Ball ballA;
	Ball ballB;
	Ball ballC;
	Ball ballD;
	int wOffset = 23;
	int hOffset = 57;
	
	public MainPanel(int w, int h){
		setBackground(Color.BLACK);
		setFocusable(true);
		timer = new Timer(speed, this);
		timer.start();
		c = new CollisionDetection(w-wOffset, h-hOffset);
		bc = new BallCollider();
		
		ballA = new Ball(75, 75, 25, -3, 3, 1);
		ballB = new Ball(200, 50, 25, 3, 3, 5);
		ballC = new Ball(300, 300, 25, 3,-3, 10);
		ballD = new Ball(250, 150, 25, -3,-3, 1);
		bl = new BallList();
		bl.addBall(ballA);
		bl.addBall(ballB);
		bl.addBall(ballC);
		bl.addBall(ballD);

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
		g.setColor(Color.RED);
		g.fillOval(ballD.getxPos(), ballD.getyPos(), ballD.getRadius()*2, ballD.getRadius()*2);

		for (int i=0; i < bl.getSize(); i++){
			Ball tempBall = bl.getBall(i);
			tempBall.setxPos((tempBall.getxPos()+tempBall.getxSpeed()));
			tempBall.setyPos((tempBall.getyPos()+tempBall.getySpeed()));
		}	
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		stepGraphics();
	}
	

}
