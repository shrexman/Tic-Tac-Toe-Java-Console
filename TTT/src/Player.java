
public class Player {

	private String name; // player's name
	private char token; // the player's token or sign
	
	// Default constructor
	public Player() {
		this.name = null;
		this.token = 0;
	}
	
	// Parameterized constructor
	public Player(String name, char token) {
		this.name = name;
		this.token = token;
	}
	
	// Getter for name
	public String getName() {
		return name;
	}
	
	// setter for name
	public void setName(String name) {
		this.name = name;
	}
	
	// retter for the token of the player
	public char gettoken() {
		return this.token;
	}
	
	// Method to mark the board at a given spot. Takes a board and spot row and column to mark.
	// The method returns true if the spot was available, false otherwise
	public boolean mark(Game g, char row, int col)
	{
		String A = "ABCDEFGHI"; // Max size of board is 9, so the max amount of letters is up to 'I'
		int rowNum = A.indexOf(row);
		
		if (g.getBoard()[rowNum][col-1] == 0)
		{
			g.getBoard()[rowNum][col-1] = token;
			return true;
		}else
		{
			return false;
		}
	}
}
