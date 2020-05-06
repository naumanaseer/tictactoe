package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //start a new program
        Scanner scan = new Scanner(System.in);
        Game tictactoe = new Game();
        UserInterface ui = new UserInterface(tictactoe,scan);
        ui.start();




    }




}
