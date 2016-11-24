import javax.swing.JFrame;
/**
Class contains main method to create MineSweeper object and a JFrame to put a MineComponent on
*/
public class MineSweeperGUI
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("MineSweeper");
		
		frame.setSize(800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MineSweeper mine = new MineSweeper(10, 10, 10);
		
		MineComponent comp = new MineComponent(mine);
		
		frame.add(comp);
		
		frame.setVisible(true);
	}
}