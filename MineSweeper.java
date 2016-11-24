import java.util.Random;

/**
Creates an array that represents the board and each entry in the array says whether or not a mine is at that position on the board. Includes methods for creating a game with
varying amount of bombs placed randomly, getting a value of a point in the array and checking squares surrounding a square for bombs
*/
public class MineSweeper
{
	public static final int isMine = 1;
	public static final int isBlank = 0;
	
	private int initialMines;
	private int blanksLeft;
	private boolean gameOver;
	
	private int[][] board;
	private int boardWidth;
	private int boardLength;
	
	private Random generator;
	
	/**
	Constructor initialises number of mines and size of game board. calls createMinefield() to initialise minefield
	@param boardWidth Width of the board
	@param boardLength Length of the board
	@param mines The number of mines in the minefield
	*/
	public MineSweeper(int boardWidth, int boardLength, int mines)
	{
		initialMines = mines;
		this.boardWidth = boardWidth;
		this.boardLength = boardLength;
		blanksLeft = (boardLength * boardWidth) - mines;
		board = new int[boardWidth][boardLength];
		
		generator = new Random();
		gameOver = false;
		
		createMinefield();
	}
	/**
	Randomly places the correct amount of mines around the minefield
	*/
	private void createMinefield()
	{
		gameOver = false;
		blanksLeft = (boardLength * boardWidth) - initialMines;
		for(int i = 0; i < boardWidth; i++)	//clears the array first 
		{
			for(int j = 0; j < boardLength; j++)
			{
				board[i][j] = isBlank;
			}
		}
		for(int i = 0; i < initialMines; i++)
		{
			int x = generator.nextInt(boardWidth);
			int y = generator.nextInt(boardLength);
			if(board[x][y] == isMine)	//if location already a mine, try again
			{
				i = i - 1;
			}
			else
			{
				board[x][y] = isMine;
			}
		}
	}
	/**
	Changes number of mines to be used in minefield
	@param mines The number of mines
	*/
	public void changeDifficulty(int mines)
	{
		initialMines = mines;
	}
	
	
	/**
	Returns the value at a point on the board - allows one to determine whether or not a square is a mine
	@param i x-coordinate in array
	@param j y-coordinate in array
	@return the value at given point in the array
	*/
	public int get(int i, int j)
	{
		return board[i][j];
	}
	
	/**
	Carries out updates associated with a turn being made. If mine is found, game over, else just continue
	@param i x-coordinate in array
	@param j y-coordinate in array
	*/
	public void turn(int i, int j)
	{
		if(board[i][j] == isMine)
		{
			gameOver = true;
		}
		else
		{
			board[i][j] = 2;	//signifies that the button at this position has been clicked, so can be disable and display number of neighbouring mines
			blanksLeft = blanksLeft - 1;
			if(blanksLeft == 0)
			{
				gameOver = true;
			}
		}

	}
	/**
	Checks whether the game is over or not
	@return boolean stating whether or not game is over
	*/
	public boolean isGameOver()
	{
		return gameOver;
	}
	
	/**
	Checks whether the game was won or not
	@return true if game is won, false if not
	*/
	public boolean gameWon()
	{
		if(blanksLeft == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	Creates a new game using current difficulty setting
	*/
	public void newGame()
	{
		createMinefield();
	}
	
	/**
	Checks the 8 squares surrounding a given square and returns the number of mines around that square as a string
	@param x x-coordinate of the square
	@param y y-coordinate of the square
	@return the number of mines surrounding the square
	*/
	public String checkNearby(int x, int y)
	{
		int bombsNearby = 0;
		String sBombsNearby = "0";
		for(int i = 0; i < 8; i++)
		{
			switch (i) {
				case 0: if(x != 0)
						{
							if(board[x-1][y] == isMine)
							{
								bombsNearby = bombsNearby + 1;
							}
						}
						break;
				case 1:	if( x != 0 && y != 0)
						{	
							if(board[x-1][y-1] == isMine)
							{
								bombsNearby = bombsNearby + 1;
							}
						}
						break;
				case 2: if(x != 0 && y != boardLength - 1)
						{
							if(board[x-1][y+1] == isMine)
							{
								bombsNearby = bombsNearby + 1;
							}
						}
						break;
				case 3: if(y != boardLength - 1)
						{
							if(board[x][y+1] == isMine)
							{
								bombsNearby = bombsNearby + 1;
							}
						}
						break;
				case 4: if(x != boardLength - 1)
						{
							if(board[x+1][y] == isMine)
							{
								bombsNearby = bombsNearby + 1;
							}
						}
						break;
				case 5: if(y != boardLength - 1 && x != boardWidth -1)
						{
							if(board[x+1][y+1] == isMine)
							{
								bombsNearby = bombsNearby + 1;
							}
						}
						break;
				case 6: if(x != boardLength - 1 && y != 0)
						{
							if(board[x+1][y-1] == isMine)
							{
								bombsNearby = bombsNearby + 1;
							}
						}
						break;
				case 7: if(y != 0)
						{
							if(board[x][y-1] == isMine)
							{
								bombsNearby = bombsNearby + 1;
							}
						}
						break;
			}
		}
		switch (bombsNearby) {
			case 1: sBombsNearby = "1";
					break;
			case 2: sBombsNearby = "2";
					break;
			case 3: sBombsNearby = "3";
					break;
			case 4: sBombsNearby = "4";
					break;
			case 5: sBombsNearby = "5";
					break;
			case 6: sBombsNearby = "6";
					break;
			case 7: sBombsNearby = "7";
					break;
			case 8: sBombsNearby = "8";
					break;
		}
		return sBombsNearby;
	}
	
	/**
	Sets GameOver to true so that when board is repainted, all mines will be shown
	*/
	public void revealMines()
	{
		gameOver = true;
	}
}