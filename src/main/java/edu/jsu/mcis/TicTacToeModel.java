package edu.jsu.mcis;

public class TicTacToeModel{
    
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY(" ");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
		
		grid = new Mark[width][width];
        
        /* Create grid (width x width) as a 2D Mark array */

        /* INSERT YOUR CODE HERE */
		for (int i = 0; i < width; ++i) {
			for (int j = 0; j < width; ++j) {
				grid[i][j] = Mark.EMPTY;
				
			
        /* Initialize grid by filling every square with empty marks */

        /* INSERT YOUR CODE HERE */
			}
		}
    }
	
    public boolean makeMark(int row, int col) {
        if(xTurn){
            if(isValidSquare(row,col) && !isSquareMarked(row,col)) {
		grid[row][col] = Mark.X;
		xTurn = false;
		return true;
	}
        }
	else if(!xTurn){
            if(isValidSquare(row,col) && !isSquareMarked(row,col)) {
		grid[row][col] = Mark.O;
                xTurn = true;
		return true;
	}
        }	
        
        return false;
        
	}
	
    public boolean isValidSquare(int row, int col) {
        if(row >= 0 && row < width && col >= 0 && col < width){
            return true;
        }
        else{
            return false;
        }

    }
	
    public boolean isSquareMarked(int row, int col) {
        if(grid[row][col] == Mark.X || grid[row][col] == Mark.O){
			return true;
		}
		else{
			return false;
		}    
    }
	
    public Mark getMark(int row, int col) {
		if(grid[row][col].equals(Mark.X)){
			return Mark.X;
		}
		else if(grid[row][col].equals(Mark.O)){
			return Mark.O;
		}
		else{
			return (Mark.EMPTY);
                }
        
        /* Return mark from the square at the specified location */
        
        /* INSERT YOUR CODE HERE */
            
    }
	
    public Result getResult() {
		if(isMarkWin(Mark.X)){
			return Result.X;
		}
		else if(isMarkWin(Mark.O)){
			return Result.O;
		}
		else if(isTie()){
			return Result.TIE;
		}
		else{
			return Result.NONE;
                }
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        
        /* INSERT YOUR CODE HERE */

    }
	
    private boolean isMarkWin(Mark mark) {
		int consecutiveMarks = 0;
		//vertical
		for(int i = 0; i < width; ++i){
			for(int j = 0; j < width; ++j){
				if(getMark(i,j).equals(mark)){
					consecutiveMarks ++;
					if(consecutiveMarks == width){
						return true;
				}
				}
				else{
					consecutiveMarks = 0;
                                        break;
				}
			}
		}
		//horizontal
		consecutiveMarks = 0;
		for(int i = 0; i < width; ++i){
			for(int j = 0; j < width; ++j){
				if(getMark(j,i).equals(mark)){
					consecutiveMarks ++;
                    if(consecutiveMarks == width){
                        return true;
                   }
				}
				else{
					consecutiveMarks = 0;
                        break;
				}
			}
		}
		//diagonal
		consecutiveMarks = 0;
		for(int i = 0; i < width; ++i){
			if(getMark(i,i).equals(mark)){
				consecutiveMarks ++;
                if(consecutiveMarks == width){
                    return true;
                    }
			}
			else{
				consecutiveMarks = 0;
                    break;
			}
		}
		consecutiveMarks = 0;
		for(int i = 0; i < width; ++i){
			if(!getMark(width - 1 -i,i).equals(mark)){
				consecutiveMarks = 0;
                    break;
			}
			else{
				consecutiveMarks ++;
                if(consecutiveMarks == width){
                    return true;
                    }
			}
		}
		return false;
	}
				
			
			
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        /* INSERT YOUR CODE HERE */

    
	
    private boolean isTie() {
		for(int i = 0; i < width; ++i){
			for(int j = 0; j < width; ++j){
				if(getMark(i,j).equals(Mark.EMPTY)){
					return false;
				}
			}
		}
		return true;

        
    }

    public boolean isGameover(){
        
        /* Return true if the game is over */
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn(){
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth(){
        
        /* Getter for width */
        
        return width;
        
    }
    
}