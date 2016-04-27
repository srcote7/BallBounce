import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	int speed = 1;
	Timer timer;
	CollisionDetection c;
	BallList bl;
	Ball ballA;
	Ball ballB;
	Ball ballC;
	int wOffset = 23;
	int hOffset = 57;
	
	public MyPanel(int w, int h){
		setBackground(Color.BLACK);
		setFocusable(true);
		timer = new Timer(speed, this);
		timer.start();
		c = new CollisionDetection(w-wOffset, h-hOffset);
		
		ballA = new Ball(50, 50, 12);
		ballA.setxSpeed(1);
		ballA.setySpeed(1);
		ballB = new Ball(300, 300, 25);
		ballB.setxSpeed(-1);
		ballB.setySpeed(-1);
		ballC = new Ball(500, 100, 50);
		ballC.setxSpeed(1);
		ballC.setySpeed(-1);
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
				Ball nextBall = bl.getBall(i+1);
				c.ballBallHit(tempBall, nextBall);
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
			tempBall.setxPos(tempBall.getxPos()+tempBall.getxSpeed());
			tempBall.setyPos(tempBall.getyPos()+tempBall.getySpeed());
		}	
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		stepGraphics();
	}
	

}
