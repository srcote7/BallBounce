import javax.swing.JFrame;

public class BounceAPP {

	public static void main(String[] args) {
		
		int radiusMin = 10;
		int radiusMax = 75;
		int speedMin = -3;
		int speedMax = 3;
		int massMin = 2;
		int massMax = 10;
		BallList bl;
		Ball ballA;
		Ball ballB;
		Ball ballC;
		Ball ballD;
		Ball ballE;
		Ball ballF;
		Ball ballG;
		Ball ballH;
		
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
		
		JFrame frame = new JFrame("Ball-Bounce");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setSize(1200, 800);
		MainPanel panel = new MainPanel(frame.getWidth(), frame.getHeight(), bl);
		frame.add(panel);
		frame.setVisible(true);
		
	}

}
