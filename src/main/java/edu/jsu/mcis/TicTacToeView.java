package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
		System.out.print("  ");
        for(int i = 0; i < model.getWidth(); ++i){
			System.out.print(i);
		}
		System.out.println(" ");
		for(int j = 0; j < model.getWidth(); ++j){
			System.out.print(j + " ");
			for(int k = 0; k < model.getWidth(); ++k){
				if(model.getMark(j,k).equals(TicTacToeModel.Mark.EMPTY)){
					System.out.print("-");
				}
				else{
                                    System.out.print(model.getMark(j,k));
			}

		}
		System.out.println();
        /* Print the board to the console (see examples) */
        
        /* INSERT YOUR CODE HERE */

    }
    }

    public void showNextMovePrompt(){
	if(model.isXTurn()){
		System.out.println("Player 1 (X) Move:");
		System.out.println("Enter the row and column numbers, separated by a space:");
	}
	else{
		System.out.println("Player 1 (O) Move:");
		System.out.println("Enter the row and column numbers, separated by a space:");
	}

        /* Display a prompt for the player's next move (see examples) */

        /* INSERT YOUR CODE HERE */

    }

    public void showInputError() {
		System.out.println("Error, incorrect input");

        /* Display an error if input is invalid (see examples) */

        /* INSERT YOUR CODE HERE */

    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}