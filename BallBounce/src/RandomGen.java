
public class RandomGen {

	RandomGen(){}
	
	public static int getRandomInt(int min, int max){
		double x = (Math.random()*(max-min)) + min;
		return (int) x;
	}
	
		
}
