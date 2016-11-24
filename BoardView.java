import java.util.Observer;
import java.util.Observable;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.GridLayout;

/**
Creates a view that observes a MineModel and reacts to its changes. Creates a grid on which the game is played
*/
public class BoardView extends JPanel implements Observer 
{
	private MineModel model;
	private JButton[][] cell;
	
	/**
	Constructor creates the gridlayout, the JButtons on it and an anonymous ActionListener for the buttons
	@param model The MineModel object
	*/
	public BoardView(MineModel model)
	{
		super();
		
		cell = new JButton[10][10];
		
		this.model = model;
		
		setLayout(new GridLayout(10, 10));
		
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				cell[i][j] = new JButton(" ");
				final int x = i; 
				final int y = j;
				cell[i][j].addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							model.turn(x, y);
						}
					}
				);
				add(cell[i][j]);
			}
		}	
	}
	/**
	Overrides method in Observer. Repaints the board according to changes in MineModel
	@param obs The Observable object
	@param obj The Object object 
	*/
	public void update(Observable obs, Object obj)
	{
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				if(model.get(i, j) == MineSweeper.isBlank)
				{
					cell[i][j].setText(" ");
					cell[i][j].setEnabled(true);
				}
				else if(model.get(i, j) == MineSweeper.isMine)
				{
					cell[i][j].setText(" ");
					cell[i][j].setEnabled(true);
				}
				else
				{
					cell[i][j].setText(model.checkNearby(i, j));
					cell[i][j].setEnabled(false);
				}
			}
		}
		
		if(model.isGameOver())
		{
			for(int i = 0; i < 10; i++)
			{
				for(int j = 0; j < 10; j++)
				{
					if(model.get(i, j) == MineSweeper.isMine)
					{
						cell[i][j].setText("Mine");
						cell[i][j].setEnabled(false);
					}
					else
					{
						cell[i][j].setText(model.checkNearby(i, j));
						cell[i][j].setEnabled(false);
					}
				}
			}
		}
		repaint();		
	}	
}