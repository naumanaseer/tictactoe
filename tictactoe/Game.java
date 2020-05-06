package tictactoe;

public class Game {

    protected char[][]initialMatrix;
    protected char lastMove;

    public Game() {

        this.initialMatrix = new char [3][3];
        //initialize the game with an empty 3X3 matrix of _
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.initialMatrix[i][j] = '_';


            }
        }
        this.lastMove = 'X'; //game starts with X
    }

    public void printMatrix(){
        //print the current game in the specified format
        System.out.print("---------");
        for(int i = 0; i < 3; i++){
            System.out.print("\n| ");
            for(int j = 0; j < 3; j++){
                System.out.print(this.initialMatrix[i][j]+" ");
            }
            System.out.print("|");

        }
        System.out.println("\n---------");
    }
    public void addMove(int b, int c){
        //user input in the cordinates

        int colNo = b;
        int rowNo = c;
        //get the actual rowNo and colNo for the userinput coordinates
        switch(c){
            case 3:
                rowNo = 0;
                break;
            case 2:
                rowNo = 1;
                break;

            case 1:
                rowNo =2;
                break;
        }
        switch(b){
            case 3:
                colNo = 2;
                break;
            case 2:
                colNo = 1;
                break;

            case 1:
                colNo =0;
                break;

        }
        //if the place is empty "_", add the move
        if(this.initialMatrix[rowNo][colNo] == '_'){
            this.initialMatrix[rowNo][colNo] = this.lastMove;
            //if this time u played X, next time O and vice versa
            if(lastMove == 'O'){
                this.lastMove = 'X';
            }
            else if(lastMove == 'X'){
                this.lastMove = 'O';
            }
            //each time a move is successfully played the game is printed

            this.printMatrix();

        }
        else{
            //if the place isnt empty, tell user its occupied
            System.out.println("This cell is occupied! Choose another one!");

        }

    }



    public boolean xWin(){
        boolean xWin = false; //initially xWin is false
        //if 3 Xs diagonal,horizontal or vertical x wins
        if(this.horizontalCheck('X') || this.verticalCheck('X') || this.diagonalCheck('X')){
            xWin = true;

        }
        return xWin;

    }
    public boolean oWin(){
        boolean oWin = false; //intially oWin is false
        //if 3 Os diagonal,horizontal or vertical O wins
        if(this.horizontalCheck('O') || this.verticalCheck('O') || this.diagonalCheck('O')){
            oWin = true;
        }
        return oWin;
    }
    public  boolean gameNotFinished(){
        //if X didnt win and O didnt win and there are empty places game isnt finished
        if(!this.xWin() && !this.oWin()){
            for(int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (this.initialMatrix[i][j] == '_') {
                        return true;
                    }

                }
            }
        }
        return false;

    }

    public boolean draw(){
        //if game is finished and x and o didnt win, its a draw
        if(!gameNotFinished() && !this.xWin() && !this.oWin()){
            return true;
        }
        return false;
    }

    public  boolean tooManyDifference() {
        //if the difference between X and O played is greater than 1, its toomany
        int xCount = 0;
        int yCount = 0;

        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.initialMatrix[i][j] == 'X') {
                    xCount++;
                }
                else if (this.initialMatrix[i][j] == 'O') {
                    yCount++;
                }
            }
        }

        if(xCount-yCount > 1 || yCount - xCount >1){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean impossible(){

        if((this.xWin() && this.oWin() )|| tooManyDifference()){
            return true;
        }
        else {
            return false;
        }
    }



    public boolean horizontalCheck(char value){

        for(int i = 0; i < 3; i++){
            int count = 0;
            for (int j = 0; j < 3; j++){
                if(this.initialMatrix[i][j] == value){
                    count++;
                }
            }
            if(count == 3){
                return true;
            }
        }
        return false;
    }

    public boolean verticalCheck(char value){

        for(int j = 0; j < 3; j++){
            int count = 0;
            for(int i = 0; i < 3; i++){
                if (this.initialMatrix[i][j] == value){
                    count++;
                }
            }
            if (count == 3){
                return true;
            }


        }
        return false;
    }

    public boolean diagonalCheck(char value){
        boolean win = false;
        if(this.initialMatrix[0][0] == value && initialMatrix[1][1] == value && initialMatrix[2][2]== value){
            win = true;
        }
        else if(this.initialMatrix[0][2] ==value && this.initialMatrix[1][1] ==value && this.initialMatrix[2][0]==value){
            win = true;
        }
        return win;
    }
}
