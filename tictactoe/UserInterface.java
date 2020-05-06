package tictactoe;

import java.util.Scanner;

public class UserInterface {



    private Game tictactoe;
    private Scanner scan;

    public UserInterface(Game tictactoe, Scanner scan) {
        this.tictactoe = tictactoe;
        this.scan = scan;
    }

    public void start() {
        this.tictactoe.printMatrix();
        while(true){
            //ask the user to enter the cordinates
            System.out.print("Enter the coordinates: ");
            String input = scan.nextLine();
            String[] parts = input.split(" ");
            try{
                //checking if the cordinates are within 1-3 and is an int
                int b = Integer.parseInt(parts[0]);
                int c = Integer.parseInt(parts[1]);
                if(b < 0 || b >3 || c < 0 || c > 3){
                    throw new ArrayIndexOutOfBoundsException();

                }
                this.tictactoe.addMove(b, c); //add the move


            }
            catch(ArrayIndexOutOfBoundsException e){
                //throw indexout of bounds exception if user enters something out of range
                System.out.println("Coordinates should be from 1 to 3!");
            }
            catch(NumberFormatException e){
                System.out.println("You should enter numbers!");
            }
            finally {
                if(this.tictactoe.impossible()){
                    System.out.println("Impossible");
                }
                else if (this.tictactoe.xWin()) {
                    System.out.println("X wins");
                    break;
                } else if (this.tictactoe.oWin()) {
                    System.out.println("O wins");
                    break;
                }
                else if(!this.tictactoe.gameNotFinished() && this.tictactoe.draw()){
                    System.out.println("Draw");
                    break;
                }
            }





        }



    }
}
