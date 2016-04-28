
public class CollisionDetection {

	private int panelWidth;
	private int panelHeight;
	
	CollisionDetection(int w, int h){
		this.panelWidth = w;
		this.panelHeight = h;
	}
	
	public boolean horizontalWallHit(Ball ball){
		if (topWallHit(ball) || bottomWallHit(ball)){
			return true;
		}
		return false;
	}
	private boolean topWallHit(Ball ball){
		if (ball.getyPosCenter() <= ball.getRadius()){
			return true;
		}
		return false;
	}
	private boolean bottomWallHit(Ball ball){
		if (ball.getyPosCenter() >= panelHeight - ball.getRadius()){
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
		if (ball.getxPosCenter() <= ball.getRadius()){
			return true;
		}
		return false;
	}
	private boolean rightWallHit(Ball ball){
		if (ball.getxPosCenter() >= panelWidth - ball.getRadius()){
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
		if(distance <= radiusA + radiusB){
			System.out.println("Collision between R1(" + ballA.getRadius() + ") and R2(" + ballB.getRadius() + ")");
			return true;
		}
		return false;
	}
	
}
