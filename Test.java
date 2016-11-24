
/**
Class simply to test MineSweeper and MineModel classes
*/
public class Test
{
	public static void main(String[] args)
	{
		MineSweeper mine = new MineSweeper(10, 10, 15);
		
		MineModel model = new MineModel(mine);
		
		//loop prints out value at every point in grid, like printing a version of the board to command line
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				System.out.print(model.get(i, j));
			}
			System.out.println();
		}
		System.out.println(model.checkNearby(1, 1));
		
		model.changeDifficulty(20);
		
		model.newGame();
		model.turn(1, 1);
		
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				System.out.print(model.get(i, j));
			}
			System.out.println();
		}
	}
}