package edu.jsu.mcis;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeView extends JPanel implements ActionListener{

    private TicTacToeModel model;
    private JButton[][] squares;
    private JPanel squaresPanel;
    private JLabel resultLabel;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        int width = model.getWidth();
        setLayout(new GridLayout(width + 1, width + 1));
        squares = new JButton[width][width];
        squaresPanel = new JPanel(new GridLayout(width, width));
        resultLabel = new JLabel();
        resultLabel.setName("ResultLabel");
        
        for(int row = 0; row < width; ++row){
            for (int col = 0; col < width; ++col){
                squares[row][col] = new JButton();
                squares[row][col].addActionListener(this);
                squares[row][col].setName("Square" + Integer.toString(row) + Integer.toString(col));
                squares[row][col].setPreferredSize(new Dimension(64,64));
                add(squares[row][col]);
            }
        }
        resultLabel.setName("ResultLabel");
        add(squaresPanel);
        add(resultLabel);
    }
    @Override
    public void actionPerformed(ActionEvent event){
        int width = model.getWidth();
        JButton toggled = (JButton)event.getSource();
        int row = (int) (toggled.getName().charAt(6)) - 48;
        int col = (int) (toggled.getName().charAt(7)) -48;
        if(!model.isGameover()){
            model.makeMark(row, col);
            toggled.setText(model.getMark(row, col).toString().toUpperCase());
            if(model.isMarkWin(model.getMark(row,col)) || model.isTie()){
                resultLabel.setText(model.getResult().toString().toUpperCase());
            }
        }
    }
    public void viewModel() {
		System.out.print("  ");
        for(int i = 0; i < model.getWidth(); ++i){
			System.out.print(i);
		}
		System.out.println("   ");
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