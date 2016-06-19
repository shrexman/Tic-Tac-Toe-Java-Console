import java.util.Arrays;

public class Game 
{

	private char[][] board; // 2D array representing the board of the game
	private int size; // variable representing the size of the board


	// Default constructor
	public Game() 
	{
		this.board = null;
		this.size = 0;
	}

	// Parameterized constructor
	public Game(int size) 
	{
		this.board = new char[size][size]; // 2D array of char all initialized to default values 0's
		this.size = size;
	}

	// Method that returns a 2D array of characters representing the board 
	public char[][] getBoard() 
	{
		return board;
	}

	// Getter method that returns the size of the board
	public int getSize() 
	{
		return size;
	}

	// Method that iterates through the array representing the board, once a 0 is found (empty spot), then it's not full thus returns false
	public boolean isFull()
	{
		for (int i = 0; i<size; i++)
		{
			for (int j = 0; j<size; j++)
			{
				if (board[i][j] == 0)
				{
					return false;
				}
			}
		}
		return true;
	}

	// Method that verifies the board for a given player sign. If the sign forms a complete line in any direction, then return true
	public boolean didWin(char sign)
	{
		int rowCounter = 0, colCounter = 0, diagonalCounter1 = 0, diagonalCounter2 = 0;
		// go through rows for winning
		for(int i = 0; i<size; i++)
		{
			for(int j = 0; j<size; j++)
			{
				if (board[i][j] == sign) // counting signs in a row
				{
					rowCounter++;
				}
				if (board[j][i] == sign) // counting signs in a column
				{
					colCounter++;
				}
				if (i==j && board[j][i] == sign) // counting signs in a diagonal
				{
					diagonalCounter1++;
				}
				if (board[size-1-j][j] == sign && i == 0) // counting signs in a diagonal
				{
					diagonalCounter2++;
				}
			}
			if (rowCounter == size || colCounter == size || diagonalCounter1 == size || diagonalCounter2 == size) // found a winner
			{
				return true;
			} else // reset counters before checking the next. NO need to reset the diagonal as there is only N incrementations
			{
				rowCounter = colCounter = 0;
			}
		}
		return false;
	}

	// Overriding the toString method to print the board as an object.
	@Override
	public String toString() {
		String output = "";
		for (int i = 0; i<=size; i++)
		{
			if (i != 0)
			{
				output+=(char)('A'+i-1);
			}
			for (int j = 0; j<size; j++)
			{
				if (i == 0)
				{
					output+=("  "+(j+1)+"");
				}else
				{
					char c = board[i-1][j];
					if (c != 0)
					{
						output+=("["+board[i-1][j]+"]");
					}else
					{
						output+=("[ ]");
					}
				}
			}
			output+=("\n");
		}
		return output;
	}

}
