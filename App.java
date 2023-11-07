import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections; // got this import idea from geeksforgeeks.org
public class App {
    public static void main(String[] args) throws Exception {
    
    // GameBoard appBoard = new GameBoard();
    // String[][] board = appBoard.getGameBoard();
    GameBoard board = new GameBoard();
    TikTakToe newBoard = new TikTakToe(board.getGameBoard());

    Player john = new Player("John",0, 'x');
    Player seth = new Player("Seth", 0, 'o');
    
    String[][] newnew = board.getGameBoard();
    int moveCounter = 0;


    // this arraylist will store the players that win for the history
    ArrayList<Player> playerList = new ArrayList<Player>();
    
    //initializes binery search
    ArrayList<Integer> bineryList = new ArrayList<>();
    Collections.sort(bineryList);

    // initializes leaderboard
    Player[] playerWins = new Player[2];
    playerWins[0] = john;
    playerWins[1] = seth;

    Scanner scanner = new Scanner(System.in);

    // stores response if player wants to play another game
    String anotherGame;
    

    // counters for counting the number of times each player won
    int player1Counter = 0;
    int player2Counter = 0;
    

    // puts together all the functionality from TikTakToe class

    do { // learned how to use do while loops on javatpoint.com

    // retstarts board every time the game is renewed
    board = new GameBoard();
    newBoard = new TikTakToe(board.getGameBoard());
    newnew = board.getGameBoard();
    moveCounter = 0;

    // while less than 9 moves have been made, it allows player input
    while (moveCounter < 9) {
    newBoard.playerInput();
    printBoard(newnew);
    String winner = newBoard.checkWinner(newnew);
    System.out.println(newBoard.checkWinner(newnew));

    // checks if player 1 has won
    if(winner.equalsIgnoreCase("Winner is player 1")) {
        System.out.println(john.getName() + " is the winner!!");
        
        player1Counter++;
        // this adds a integer representation of the winners that binnery search can then use to search for past winners
        bineryList.add(1);
        playerWins[0].setWins(player1Counter);

        //history of wins
        playerList.add(john);
        break;

        // checks if player 2 has won
    } else if (winner.equalsIgnoreCase("Winner is player 2")) {
        System.out.println(seth.getName() + " is the winner!!");

        player2Counter++;
        // this adds a integer representation of the winners that binnery search can then use to search for past winners
        bineryList.add(0);
        playerWins[1].setWins(player2Counter);

        //history of wins
        playerList.add(seth);
        break;
    }

    // determins if the players had a draw
    moveCounter++;
    newBoard.determineDraw(moveCounter);
    }
    

    System.out.println("Please enter | yes | if you would like to play again");
    anotherGame = scanner.nextLine();

    
    // if someone says yes to another game... part of the do, while loop
} while (anotherGame.equalsIgnoreCase("yes"));
    
    // if someone says no to another game
    System.out.println("The game has ended. I hope you enjoyed your time playing!!");
    

    // this uses selection sort to sort the players in order
    sortPlayerByScore(playerWins);

    System.out.println("Here is the leaderboard: ");
    System.out.println("Player Name: "  + playerWins[0].getName() + " - Player Score:"+ playerWins[0].getWins());
    System.out.println("Player Name: "  + playerWins[1].getName() + " - Player Score:"+ playerWins[1].getWins());

    // history of wins
    System.out.println("History of winners: ");
    for (Player player : playerList) {
        
        System.out.println("Winner:" + player.getName());
    }



    // prints out the results of binery search
    // change key to 0 and seth.getName() if you want to search for if seth has won before
    if (searchBinery(bineryList, 1) == true) {
        System.out.println("Yes, "+ john.getName() +" has won before!");
    } else if (searchBinery(bineryList,1) == false) {
        System.out.println("No, " + john.getName() + " has not won before :(");
    }


    
    }


    


    // prints the board
    public static void printBoard(String[][] board) {
        
        System.out.print("[" + board[0][0]+"]" + "[" + board[0][1]+"]" + "[" + board[0][2]+"]"+"\n");
        System.out.print("[" + board[1][0]+"]" + "[" + board[1][1]+"]" + "[" + board[1][2]+"]"+"\n");
        System.out.print("[" + board[2][0]+"]" + "[" + board[2][1]+"]" + "[" + board[2][2]+"]"+"\n");

    
        
    
}

    // is not used anymore however if needed, sets the board to all null
    // used for restarting after every game
public static void setBoardNull(String[][] board) {
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
            board[i][j] = null;
        }
    }

}

// this sorts the players by their wins
public static Player[] sortPlayerByScore(Player[] players) {
    
    // this iteratres through the list and looks and compares value to see max value
    int playerLength = players.length;
    for (int i = 0; i < playerLength-1; i++) {
        int maxIndex = i;
        for (int j = i+1; j < playerLength; j++) {
            if (players[j].getWins() > players[maxIndex].getWins()){
                maxIndex = j;

            }

        }

        // it assigns a player object to a temporary value then assigns the actual min index value to the value of the first object
        if (maxIndex != i){
            Player kitty = players[i];
            players[i] = players[maxIndex];
            players[maxIndex] = kitty;
        }

    }
    return players;
}


// this is used to sort the int array so we can apply binery search

// conducts binery search
public static boolean searchBinery(ArrayList<Integer> intArray, int key) {
    int left = 0;
    int right = intArray.size() -1;

    while (left <= right) {
        int mid = (left + right) / 2;
        if ( intArray.get(mid) == key) {
            return true;
        } else if (intArray.get(mid) < key) {
            left = mid + 1;

        }else {
            right = right -1;
        }

    }
    return false;
}


}
