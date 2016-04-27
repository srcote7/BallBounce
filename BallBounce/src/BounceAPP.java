import javax.swing.JFrame;

public class BounceAPP {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Ball-Bounce");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setSize(700, 500);
		MyPanel panel = new MyPanel(frame.getWidth(), frame.getHeight());
		frame.add(panel);
		frame.setVisible(true);
		
	}

}
