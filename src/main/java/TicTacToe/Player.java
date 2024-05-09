package TicTacToe;

import java.util.Scanner;

public class Player {
    String name;
    char symbol;

    public Player(Character alreadyUsedSymbol) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Who is the next player? ");
        this.name = sc.nextLine();

        System.out.println("Which symbol has the player? ");
        this.symbol = sc.nextLine().charAt(0);

        while (Character.valueOf(symbol) == alreadyUsedSymbol) {
            System.out.println("Symbol already in use.");
            System.out.println("Which symbol has the player? ");
            this.symbol = sc.nextLine().charAt(0);
        }
    }
}