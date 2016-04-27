
public class Ball{
	
	private int radius;
	private int xPos;
	private int yPos;
	private int xSpeed = 0;
	private int ySpeed = 0;

	Ball(int x, int y, int r) {
		this.setRadius(r);
		this.setxPos(x);
		this.setyPos(y);
	}


/*
 * Setters
 */
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}
	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}
	
/*
 * Getters
 */
	public int getRadius() {
		return radius;
	}
	public int getxPos() {
		return xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public int getxPosCenter(){
		return xPos + radius;
	}
	public int getyPosCenter(){
		return yPos + radius;
	}
	public int getxSpeed() {
		return xSpeed;
	}
	public int getySpeed() {
		return ySpeed;
	}










	

}
