public class GameBoard {
        // creates the gameboard
    private String[][] gameBoard = new String[3][3];
    
    // define the amount of colums and rows
    public GameBoard() {
        for (int i = 0; i <gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = new String(" ");
            }
        }
        }
    
    // getter
    public String[][] getGameBoard() {
        return gameBoard;
    }


}
