
public class BallCollider {
	
	private double nx, ny ;
	private double unx;
	private double uny;
	private double utx;
	private double uty;
	private double v1x;
	private double v1y;
	private double v2x;
	private double v2y;
	private double v1n;
	private double v2n;
	private double v1t;
	private double v2t;
	private double v1np;
	private double v2np;
	private double v1nxp;
	private double v1nyp;
	private double v2nxp;
	private double v2nyp;
	private double v1txp;
	private double v1typ;
	private double v2txp;
	private double v2typ;
	private double v1xp;
	private double v1yp;
	private double v2xp;
	private double v2yp;
	
	BallCollider(){}
	
	public void calculateVector(Ball ballA, Ball ballB){
		this.nx = ballA.getxPosCenter()-ballB.getxPosCenter();
		this.ny = ballA.getyPosCenter()-ballB.getyPosCenter();
		this.unx = nx/Math.pow(nx*nx+ny*ny, .5);
		this.uny = ny/Math.pow(nx*nx+ny*ny, .5);
		this.utx = -uny;
		this.uty = unx;
		this.v1x = ballA.getxSpeed();
		this.v1y = ballA.getySpeed();
		this.v2x = ballB.getxSpeed();
		this.v2y = ballB.getySpeed();
		this.v1n = unx * v1x + uny * v1y;
		this.v2n = unx * v2x + uny * v2y;
		this.v1t = utx * v1x + uty * v1y;
		this.v2t = utx * v2x + uty * v2y;
		int m1 = ballA.getMass();
		int m2 = ballB.getMass();
		this.v1np = (v1n*(m1-m2)+2*m2*v2n)/(m1+m2);
		this.v2np = (v2n*(m2-m1)+2*m1*v1n)/(m1+m2);
		this.v1nxp = v1np * unx;
		this.v1nyp = v1np * uny;
		this.v2nxp = v2np * unx;
		this.v2nyp = v2np * uny;
		this.v1txp = v1t * utx;
		this.v1typ = v1t * uty;
		this.v2txp = v2t * utx;
		this.v2typ = v2t * uty;
		this.v1xp = v1nxp + v1txp;
		this.v1yp = v1nyp + v1typ;
		this.v2xp = v2nxp + v2txp;
		this.v2yp = v2nyp + v2typ;
	}

	public double getBallAX(){
		return v1xp;
	}
	public double getBallAY(){
		return v1yp;
	}
	public double getBallBX(){
		return v2xp;
	}
	public double getBallBY(){
		return v2yp;
	}

}
