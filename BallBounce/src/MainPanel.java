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
	Ball ballE;
	Ball ballF;
	Ball ballG;
	Ball ballH;
	int wOffset = 23;
	int hOffset = 57;
	int radiusMin = 10;
	int radiusMax = 75;
	int speedMin = -3;
	int speedMax = 3;
	int massMin = 2;
	int massMax = 10;
	
	public MainPanel(int w, int h){
		setBackground(Color.BLACK);
		setFocusable(true);
		timer = new Timer(speed, this);
		timer.start();
		c = new CollisionDetection(w-wOffset, h-hOffset);
		bc = new BallCollider();
		
		/*
		 * Add balls as desired
		 * ARGS: xPos, yPos, Radius, xSpeed, ySpeed, Mass
		 * 
		 */
		ballA = new Ball(100, 100, RandomGen.getRandomInt(radiusMin, radiusMax), RandomGen.getRandomInt(speedMin, speedMax), RandomGen.getRandomInt(speedMin, speedMax), RandomGen.getRandomInt(massMin, massMax));
		ballB = new Ball(300, 200, RandomGen.getRandomInt(radiusMin, radiusMax), RandomGen.getRandomInt(speedMin, speedMax), RandomGen.getRandomInt(speedMin, speedMax), RandomGen.getRandomInt(massMin, massMax));
		ballC = new Ball(900, 100, RandomGen.getRandomInt(radiusMin, radiusMax), RandomGen.getRandomInt(speedMin, speedMax), RandomGen.getRandomInt(speedMin, speedMax), RandomGen.getRandomInt(massMin, massMax));
		ballD = new Ball(200, 500, RandomGen.getRandomInt(radiusMin, radiusMax), RandomGen.getRandomInt(speedMin, speedMax), RandomGen.getRandomInt(speedMin, speedMax), RandomGen.getRandomInt(massMin, massMax));
		ballE = new Ball(100, 500, RandomGen.getRandomInt(radiusMin, radiusMax), RandomGen.getRandomInt(speedMin, speedMax), RandomGen.getRandomInt(speedMin, speedMax), RandomGen.getRandomInt(massMin, massMax));
		ballF = new Ball(300, 400, RandomGen.getRandomInt(radiusMin, radiusMax), RandomGen.getRandomInt(speedMin, speedMax), RandomGen.getRandomInt(speedMin, speedMax), RandomGen.getRandomInt(massMin, massMax));
		ballG = new Ball(600, 100, RandomGen.getRandomInt(radiusMin, radiusMax), RandomGen.getRandomInt(speedMin, speedMax), RandomGen.getRandomInt(speedMin, speedMax), RandomGen.getRandomInt(massMin, massMax));
		ballH = new Ball(800, 500, RandomGen.getRandomInt(radiusMin, radiusMax), RandomGen.getRandomInt(speedMin, speedMax), RandomGen.getRandomInt(speedMin, speedMax), RandomGen.getRandomInt(massMin, massMax));
		bl = new BallList();
		bl.addBall(ballA);
		bl.addBall(ballB);
		bl.addBall(ballC);
		bl.addBall(ballD);
		bl.addBall(ballE);
		bl.addBall(ballF);
		bl.addBall(ballG);
		bl.addBall(ballH);

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
