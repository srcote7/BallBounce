import java.util.LinkedList;

public class BallList {

	LinkedList<Ball> ballList = new LinkedList<>();
	
	BallList(){
	}
	
	public void addBall(Ball b){
		ballList.add(b);
	}
	
	public Ball getBall(int i){
		return ballList.get(i);
	}
	
	public int getSize(){
		return ballList.size();
	}
	
	
	
	
}
