import java.util.Scanner; // import scanner

public class Driver {

	public static void main(String[] args) {

		final int numPlayers = 2; // default number of players is 2
		Scanner key = new Scanner(System.in); // declare and initialize a Scanner object, we call it key

		// print a welcome message
		System.out.print("\t\t\t======================\n\n");
		System.out.print("\t\t\tWelcome to Tic-Tac-Toe\n\n");
		System.out.print("\t\t\t======================\n\n");

		int size; // declare a variable to hold the board size
		Game g; // declare a game object
		Player[] players; // declare array of players
		boolean winner; // declare a boolean variable to keep indicate if there is a winner or not
		
		// to start the game, assume the user answer is YES (ie. 'Y')
		// This loop corresponds to the whole program running
		String answer = "Y";
		while (answer.compareTo("Y") == 0)
		{
			System.out.print("Please enter the size of the board (between 3 - 9): ");
			size = key.nextInt();

			// validate the user input
			while(size < 3 || size > 9)
			{
				System.out.print("\nInvalid input... Please enter the size of the board (between 3 - 9): ");
				size = key.nextInt();
			}

			// create a game with the size given by the user
			g = new Game(size);
			
			// initialize and array of players using the default number of players
			players = new Player[numPlayers];
			
			// a boolean variable to keep indicate if there is a winner or not
			winner = false;

			for (int i = 0; i<players.length; i++)
			{
				System.out.print("Enter player "+(i+1)+" name: ");
				String name = key.next();

				System.out.print("Enter player "+(i+1)+" token: ");
				char token = key.next().charAt(0);
				players[i] = new Player(name,token);

				System.out.print("\n");
			}
			
			System.out.print("\n\n\t\t\tLet the game start...\n\n");
			
			// Loop the game as long as the board is not full, and there is no winner yet
			// This loop corresponds to one game
			while (!g.isFull() && !winner)
			{
				// loop through the array of players to give turns
				for (int i = 0; i<players.length; i++)
				{
					System.out.println(g);
					
					System.out.print("\nEnter row (character) of spot to mark: ");
					char row = key.next().toUpperCase().charAt(0); // take the first char of the given answer
					
					// validate user input, if the char passed is not bigger than the size of board
					while (row < 'A' || row > 'A'+g.getSize()-1)
					{
						System.out.print("\nInvalid row. Please enter row (character) of spot to mark: ");
						row = key.next().toUpperCase().charAt(0); // take the first char of the given answer
						
					}
					
					System.out.print("Enter column of spot to mark: ");
					int col = key.nextInt();

					System.out.print("\n");

					boolean isMarked = players[i].mark(g, row, col);

					// While the spot is not marked due to a pre-existing token
					while (!isMarked)
					{
						System.out.print("A token already exists there, enter row of spot to mark: ");
						row = key.next().toUpperCase().charAt(0);

						System.out.print("Enter column of spot to mark: ");
						col = key.nextInt();

						isMarked = players[i].mark(g, row, col);

						System.out.print("\n");
					}

					// Once the player has marked a spot, check if they won
					if (g.didWin(players[i].gettoken()))
					{
						System.out.println(g);
						System.out.println(players[i].getName()+" is the winner!");
						winner = true;
						break;
					}
				}
			}
			if (g.isFull() && !winner)
			{
				System.out.print("It's a draw! Intense competition\n\n");
			}
			System.out.print("Would you like to play again (Y/N)?");
			answer = key.next().toUpperCase();
			winner = false;
		}
		System.out.print("\n\nHope to see you again...");
	}
}
