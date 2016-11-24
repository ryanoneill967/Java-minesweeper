import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.BoxLayout;

/**
Adds controls to start a new game, exit the game, reveal mines and change the difficulty of the game
*/
public class ControlPanel extends JPanel
{
	/**
	Creates all the relevant buttons and ButtonGroup
	@param model The MineModel
	*/
	public ControlPanel(MineModel model)
	{
		super();
		
		JButton restart = new JButton("New Game");
		restart.addActionListener(e -> model.newGame());
		
		JButton exit = new JButton("Exit");
		exit.addActionListener(e -> System.exit(0));
		
		JButton revealMines = new JButton("Reveal mines");
		revealMines.addActionListener(e -> model.revealMines());
		
		String a = "Easy";
		String m = "Medium";
		String h = "Hard";
		
		JRadioButton easy = new JRadioButton("Easy (10 mines)");
		easy.setActionCommand(a);
		easy.addActionListener(e -> model.changeDifficulty(10));
		
		JRadioButton medium = new JRadioButton("Medium (15 mines)");
		medium.setActionCommand(m);
		medium.addActionListener(e -> model.changeDifficulty(15));
		
		JRadioButton hard = new JRadioButton("Hard (20 mines)");
		hard.setActionCommand(h);
		hard.addActionListener(e -> model.changeDifficulty(20));
		
		ButtonGroup difficulties = new ButtonGroup();
		
		difficulties.add(easy);
		difficulties.add(medium);
		difficulties.add(hard);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(restart);
		add(revealMines);
		add(easy);
		add(medium);
		add(hard);
		add(exit);
	}
}