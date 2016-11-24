import java.util.Observable;

/**
An observable model of an object of the MineSweeper class
*/
public class MineModel extends Observable 
{
	private MineSweeper mine;
	
	/**
	Initialises observerable object and sets value of mine
	@param mine The MineSweeper object
	*/
	public MineModel(MineSweeper mine)
	{
		super();
		this.mine = mine;
	}
	
	/**
	Changes number of mines to be used in minefield
	@param mines The number of mines
	*/
	public void changeDifficulty(int mines)
	{
		mine.changeDifficulty(mines);
	}
	
	/**
	gets value at given point using get method in MineSweeper class
	@param i x-coordinate of square
	@param j y-coordinate of square
	*/
	public int get(int i, int j)
	{
		return mine.get(i, j);
	}
	
	/**
	calls same name method from MineSweeper class to carry out updates. Notfies observers and sets changed
	@param i x-coordinate in array
	@param j y-coordinate in array
	*/
	public void turn(int i, int j)
	{
		mine.turn(i, j);
		setChanged();
		notifyObservers();
	}
	
	/**
	Checks whether the game is over or not
	@return boolean stating whether or not game is over
	*/
	public boolean isGameOver()
	{
		return mine.isGameOver();
	}
	
	/**
	Checks whether the game was won or not
	@return true if game is won, false if not
	*/
	public boolean gameWon()
	{
		return mine.gameWon();
	}
	/**
	creates a new game and notifies observers of a change
	@param mines Number of mines in new game
	*/
	public void newGame()
	{		
		mine.newGame();
		setChanged();
		notifyObservers();
	}
	
	/**
	Checks the 8 squares surrounding a given square and returns the number of mines around that square as a string
	@param x x-coordinate of the square
	@param y y-coordinate of the square
	@return the number of mines surrounding the square
	*/
	public String checkNearby(int x, int y)
	{
		return mine.checkNearby(x, y);
	}
	
	/**
	Sets GameOver to true so that when board is repainted, all mines will be shown
	*/
	public void revealMines()
	{
		mine.revealMines();
		setChanged();
		notifyObservers();
	}
}