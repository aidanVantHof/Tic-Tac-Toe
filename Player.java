public class Player {
    //player 1 (inputs an X) but the actual player just enters a position
    //player name and symbol

    //constructor for player objects
    // there will two players, one for x and one for o

    private String name;
    private int  wins;
    private char symbol;

    public Player(String name, int wins, char symbol) {
        this.name = name;
        this.wins = wins;
        this.symbol = symbol;
    }

    // getters
    public String getName() {
        return this.name;
    }

    public int getWins() {
        return this.wins;
    }

    public char getSymbol() {
        return this.symbol;
    }

    // setter
    public void setWins(int num) {
        wins = num;
    }


    
}
