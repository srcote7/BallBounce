
public class CollisionDetection {

	private int panelWidth;
	private int panelHeight;
	
	CollisionDetection(int w, int h){
		this.panelWidth = w;
		this.panelHeight = h;
	}
	
	/*public boolean cornerHit(Ball ball){
		if ((topWallHit(ball) && leftWallHit(ball)) ||
			(topWallHit(ball) && rightWallHit(ball)) ||
			(bottomWallHit(ball) && leftWallHit(ball)) ||
			(bottomWallHit(ball) && rightWallHit(ball))
			){
			System.out.println("CORNER HIT!!");
			return true;
		} else {
			return false;
		}
	}*/
	
	public boolean horizontalWallHit(Ball ball){
		if (topWallHit(ball) || bottomWallHit(ball)){
			return true;
		}
		return false;
	}
	private boolean topWallHit(Ball ball){
		if (ball.getyPosCenter() <= ball.getRadius() && ball.getLastIdHit() != 1){
			ball.setLastIdHit(1);
			//System.out.println(ball.getId() + " hit top wall.");
			return true;
		}
		return false;
	}
	private boolean bottomWallHit(Ball ball){
		if (ball.getyPosCenter() >= panelHeight - ball.getRadius() && ball.getLastIdHit() != 2){
			ball.setLastIdHit(2);
			//System.out.println(ball.getId() + " hit bottom wall.");
			return true;
		}
		return false;
	}

	public boolean verticalWallHit(Ball ball){
		if (leftWallHit(ball) || rightWallHit(ball)){
			return true;
		}
		return false;
	}
	private boolean leftWallHit(Ball ball){
		if (ball.getxPosCenter() <= ball.getRadius() && ball.getLastIdHit() != 3){
			ball.setLastIdHit(3);
			//System.out.println(ball.getId() + " hit left wall.");
			return true;
		}
		return false;
	}
	private boolean rightWallHit(Ball ball){
		if (ball.getxPosCenter() >= panelWidth - ball.getRadius() && ball.getLastIdHit() != 4){
			ball.setLastIdHit(4);
			//System.out.println(ball.getId() + " hit right wall.");
			return true;
		}
		return false;
	}
	
	public boolean ballBallHit(Ball ballA, Ball ballB){
		int radiusA = ballA.getRadius();
		int radiusB = ballB.getRadius();
		float deltaX = Math.abs(ballA.getxPosCenter() - ballB.getxPosCenter());
		float deltaY = Math.abs(ballA.getyPosCenter() - ballB.getyPosCenter());
		float distance = (float) Math.pow(deltaX*deltaX + deltaY*deltaY, .5);
		if(distance <= radiusA + radiusB && (ballA.getLastIdHit() != ballB.getId() || ballB.getLastIdHit() != ballA.getId())){
			//System.out.println("Collision between (" + ballA.getId() + ") and (" + ballB.getId() + ") distance: " + distance);
			ballA.setLastIdHit(ballB.getId());
			ballB.setLastIdHit(ballA.getId());
			return true;

		}
		return false;
	}
	
}
