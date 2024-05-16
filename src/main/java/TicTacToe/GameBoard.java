package TicTacToe;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class GameBoard {
    Scanner playerInput = new Scanner(System.in);
    int row=3, col=3;
    Character[][] state = new Character[row][col];

    public List<Character> getState()
    {
        List<Character> currentState = new ArrayList<>(9);
        for (int rowIndex = 0; rowIndex<3; rowIndex++)
        {
            for (int colIndex = 0; colIndex<3; colIndex++)
            {
                currentState.add(state[rowIndex][colIndex]);
            }
        }
        return currentState;
    }
    public void rowsAndCols(){
        System.out.println("How many rows do you wish to play with? ");
        row = Integer.parseInt(playerInput.nextLine());
        System.out.println("How many columns do you wish to play with? ");
        col = Integer.parseInt(playerInput.nextLine());
        state = new Character[row][col];
    }

    public Character finished() {
        ArrayList<Character> winners = new ArrayList<>();

        winners.add(rowsWin());
        winners.add(columnWin());
        winners.add(diagonalWin());
        winners.add(boardFilled());

        for (int i = 0; i < 4; i++) {
            if (winners.get(i) != null) {
                return winners.get(i);
            }
        }

        return null;
    }

    public short determineBeginner(String name1, String name2) {
        short nextPlayer = 2;
        if (Math.random() < 0.5) {
            System.out.printf(name1 + " begins." + '\n');
            nextPlayer = 1;
        }
        if (nextPlayer == 2) {
            System.out.printf(name2 + " begins." + '\n');
        }
        return nextPlayer;
    }

    public void display() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col - 1; j++) {
                try {
                    System.out.printf(nullToSpace(state[i][j]) + " | ");
                } catch (Exception e) {

                }
            }
            System.out.printf("" + nullToSpace(state[i][col-1]) + '\n');
        }
    }

    public String findWinnerName(char winnerSymbol, Player player1, Player player2) {
        String winner = "Nobody";
        if (winnerSymbol == player1.symbol) {
            winner = player1.name;
        }
        if (winnerSymbol == player2.symbol) {
            winner = player2.name;
        }
        return winner;
    }

    public short enterMove(short nextPlayer, Player player1, Player player2) {
        if (nextPlayer == 1) {
            requestInputMove(player1);
            nextPlayer = 2;
        } else {
            requestInputMove(player2);
            nextPlayer = 1;
        }
        return nextPlayer;
    }

    private void requestInputMove(Player player) {
        System.out.printf(player.name + ", enter your move: ");
        Scanner sc = new Scanner(System.in);
        int playerInput = Integer.parseInt(sc.nextLine());

        boolean movePlaced = false;
        while (!movePlaced)
        {
            movePlaced = placeMove(playerInput, player.symbol);
        }

        requestInputMove(player);
    }
    public boolean placeMove(int playerInput, char symbol) {
        if (state[rowNum(playerInput)][colNum(playerInput)] == null)
        {
            state[rowNum(playerInput)][colNum(playerInput)] = symbol;
            return true;
        }
        return false;
    }
    private int rowNum(int playerInput){
        return playerInput / 10 - 1;
    }

    private int colNum(int playerInput){
       return playerInput % 10 - 1;
    }

    private Character rowsWin() {
        for (int i = 0; i < row; i++) {
            Character symbol = state[i][0];
            int numOfSameSymbols = 0;
            for(int j = 0; j<col; j ++){
                if(symbol == state[i][j] && symbol != null){
                    numOfSameSymbols ++;
                    if(numOfSameSymbols==3){
                        return symbol;
                    }
                }else{
                    numOfSameSymbols = 1;
                    symbol = state[i][j];
                }
            }
        }
        return null;
    }

    private Character columnWin() {
        for (int i = 0; i < col; i++) {
            Character symbol = state[0][i];
            int numOfSameSymbols = 0;
            for(int j = 0; j<row; j ++){
                if(symbol == state[j][i] && symbol != null){
                    numOfSameSymbols ++;
                    if(numOfSameSymbols==3){
                        return symbol;
                    }
                }else{
                    numOfSameSymbols = 1;
                    symbol = state[j][i];
                }
            }
        }
        return null;
    }
    private Character diagonalWin() {
        /*for (int i = 0; i < col; i++) {
            Character symbol = state[0][i];
            int numOfSameSymbols = 0;
            for(int j = 0; j<row; j ++){
                if(symbol == state[j][j] && symbol != null){
                    numOfSameSymbols ++;
                    if(numOfSameSymbols==3){
                        return symbol;
                    }
                }else{
                    numOfSameSymbols = 1;
                    symbol = state[j][i];
                }
            }
        }
        return null;*/

        if (state[0][0] == state[1][1] && state[0][0] == state[2][2]) {
            return state[1][1];
        }
        if (state[1][1] == state[0][2] && state[1][1] == state[2][0]) {
            return state[1][1];
        }
        return null;
    }

    private Character boardFilled() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (state[i][j] == null) {
                    return null;
                }
            }
        }
        return ' ';
    }

    private char nullToSpace (Character a)
    {
        return Objects.requireNonNullElse(a, ' ');
    }
}