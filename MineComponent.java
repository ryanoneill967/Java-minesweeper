import javax.swing.JPanel;
import java.awt.BorderLayout;
/**
a JPanel that brings BoardView and ControlPanel together in a BorderLayout
*/
public class MineComponent extends JPanel
{	
	/**
	creates the MineModel object and adds observers to it. Also creates layout for GUI
	@param mine The MineSweeper object
	*/
	public MineComponent(MineSweeper mine)
	{
		MineModel model = new MineModel(mine);
		
		BoardView view = new BoardView(model);
		ControlPanel controls = new ControlPanel(model);
		
		model.addObserver(view);
		
		setLayout(new BorderLayout());
		
		add(view, BorderLayout.CENTER);
		add(controls, BorderLayout.EAST);
		
	}
}