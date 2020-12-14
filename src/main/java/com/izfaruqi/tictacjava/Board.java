package com.izfaruqi.tictacjava;

public class Board {
    private int[][] marks = new int[3][3]; // 3 rows x 3 cols
    private Player[] players;
    private int currentPlayer = 1;
    private boolean hasWon = false;

    public Board(Player[] players){
        this.players = players;
    }

    public Board(){
        this.players = new Player[] {new Player("Player A", 'X'), new Player("Player B", 'O')};
    }

    Player[] getPlayers(){
        return players;
    }

    Player getCurrentPlayer(){
        return players[currentPlayer-1];
    }

    private boolean checkIfMoveLegal(int row, int col){
        return marks[row][col] == 0;
    }

    private int checkWin(){
        for(int[] row : marks){ // Check horizontal wins
            if(row[0] == row[1] && row[0] == row[2]) return row[0];
        }

        for(int col = 0; col < marks[0].length; col++){ // Check vertical wins
            if(marks[0][col] == marks[1][col] && marks[0][col] == marks[2][col]) return marks[0][col];
        }

        // Check diagonal wins
        if(marks[0][0] == marks[1][1] && marks[0][0] == marks[2][2]) return marks[0][0];
        if(marks[2][0] == marks[1][1] && marks[2][0] == marks[0][2]) return marks[2][0];

        return 0;
    }

    int move(int row, int col){
        if(!checkIfMoveLegal(row, col)){
            return 1;
        }
        if(hasWon){
            return 2;
        }

        marks[row][col] = currentPlayer;

        if(checkWin() != 0){
            hasWon = true;
            return 2;
        } else {
            currentPlayer = (currentPlayer == players.length)? 1 : currentPlayer + 1;
        }

        return 0;
    }

    String printBoard(){
        StringBuilder board = new StringBuilder();
        board.append("_______");
        for(int[] row : marks){
            board.append("\n");

            board.append("|");
            for(int col : row){
                if(col == 0){
                    board.append(" ").append("|");
                } else {
                    board.append(players[col - 1].getPrintSymbol()).append("|");
                }
            }
        }
        board.append("\n‾‾‾‾‾‾‾‾‾");

        return board.toString();
    }
}
