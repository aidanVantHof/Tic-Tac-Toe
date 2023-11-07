import java.util.InputMismatchException;
import java.util.Scanner;
public class TikTakToe {



    private String[][] board;
    int counter = 0;

    public TikTakToe(String[][] gameBoard) {
       board = gameBoard;


    }
    

    
    int playerCounter = 0;

    // declare row and column


    // add method to determine players move
    public void playerInput() {

        
        Scanner scanner = new Scanner(System.in);
        int row;
        int column;

        // determine row position
        while (true) {
            try {
            System.out.println("Please select a row (0~2)");
            row = scanner.nextInt();
            // checks if row meets the qualifications
            if (row >= 0 && row <3) {
                // if it meets the qualifications basically nothing happens
                break;
            } else {
                System.out.println("The input was wrong. Please input a row int between 0 and 2.");
            }
            //catch block
        } catch (InputMismatchException e) {
            System.out.println(e);
            scanner.next();
        }
    }
            
        // determine column position
        while (true) {
            try {
                System.out.println("Please enter the column integer between 0 and 2");
                column = scanner.nextInt();
                // checks if the number fits within the range
                
                if (column >= 0 && column <3) {
                    // checks if space is empty
                    if (board[row][column].equals(" ")) {
                    break;
                    } else {
                        System.out.println("Sorry the position was full. Please enter at a different position.");
                    }
                } else {
                    System.out.println("The input was incorrect. Please enter an integer that is between 0 and 2");
                }
            
            } catch (InputMismatchException e) {
                System.out.println(e);
                scanner.next();
            }
        }
        
        
        
    
        
        
    // increases player counter
    playerCounter++;
    // determins the turn of the player
    if (playerCounter % 2 == 1) {
        board[row][column] = "x";
    } else if (playerCounter % 2 == 0) {
        board[row][column] = "o";
    }
    
    
}


    
    // Check if the board is full

    // Check for a win condition
    public String checkWinner(String[][] board) {
        String winner;
        String threeInRow;
        
            //its to 9 because 9 is max amount of turns
        for (int i = 0; i<9;i++) {
        threeInRow = "";
        
        switch (i) {
                // three strait horizontal rows
            case 0:
            threeInRow = board[0][0] + board[0][1] + board[0][2];
            break;
            case 1:
            threeInRow = board[1][0] + board[1][1] + board[1][2];
            break;
            case 2:
            threeInRow = board[2][0] + board[2][1] + board[2][2];
            break;
            
            //three vertical rows
            case 3:
            threeInRow = board[0][0] + board[1][0] + board[2][0];
            break;
            case 4:
            threeInRow = board[0][1] + board[1][1] + board[2][1];
            break;
            case 5:
            threeInRow = board[0][2] + board[1][2] + board[2][2];
            break;

            // diagonals
            case 6:
            threeInRow = board[0][0] + board[1][1] + board[2][2];
            break;
            case 7:
            threeInRow = board[0][2] + board[1][1] + board[2][0];
            break;

        }
        // counts one everytime this is run
        

        // determines winner
        if (threeInRow.equalsIgnoreCase("xxx")) {
            winner = "Winner is player 1" ;
            return winner;
        }

        if (threeInRow.equalsIgnoreCase("ooo")) {
            winner = "Winner is player 2";
            return winner;
        }

        
        // look through all the rows and colums
        // combine them into a string and determine if the
    }
    
    //determines draw
    
        
        return "no winners yet";

    // Take a player's move and update the board

    // Switch between players after each move



        //get information from user input
    // convert userinput into coordinates in which a value gets put in
    //user input will probably be put ina for loop because it can repeat until one of the win cases is true
    //
}

    public  void determineDraw(int counter) {
        if (counter == 9) {
            System.out.println("It's a draw");
            
        }
    }
}
