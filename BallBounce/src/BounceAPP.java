import javax.swing.JFrame;

public class BounceAPP {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Ball-Bounce");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setSize(1200, 800);
		MainPanel panel = new MainPanel(frame.getWidth(), frame.getHeight());
		frame.add(panel);
		frame.setVisible(true);
		
	}

}
