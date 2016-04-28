
public class Ball{
	
	private int radius;
	private double xPos;
	private double yPos;
	private double xSpeed;
	private double ySpeed;
	private int mass;
	private int id;
	private static int idSetter = 5;
	private int lastIdHit;

	Ball(int x, int y, int r, int xs, int ys, int m) {
		this.setRadius(r);
		this.setxPos(x);
		this.setyPos(y);
		this.setxSpeed(xs);
		this.setySpeed(ys);
		this.setMass(m);
		this.id = idSetter;
		idSetter++;
	}


/*
 * Setters
 */
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public void setxPos(double x) {
		this.xPos = x;
	}
	public void setyPos(double y) {
		this.yPos = y;
	}
	public void setxSpeed(double xs) {
		this.xSpeed = xs;
	}
	public void setySpeed(double ys) {
		this.ySpeed = ys;
	}
	public void setMass(int mass) {
		this.mass = mass;
	}
	public void setLastIdHit(int lastIdHit) {
		this.lastIdHit = lastIdHit;
	}
	
/*
 * Getters
 */
	public int getRadius() {
		return radius;
	}
	public int getxPos() {
		return (int) xPos;
	}
	public int getyPos() {
		return (int) yPos;
	}
	public int getxPosCenter(){
		return (int) xPos + radius;
	}
	public int getyPosCenter(){
		return (int) yPos + radius;
	}
	public double getxSpeed() {
		return xSpeed;
	}
	public double getySpeed() {
		return ySpeed;
	}
	public int getMass() {
		return mass;
	}
	public int getLastIdHit() {
		return lastIdHit;
	}
	public int getId() {
		return id;
	}





















	

}
