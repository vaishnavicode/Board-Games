import java.util.Scanner;

public class SnakesAndLaddersGame {

    //Boolean class variable to check if the game is over or not
    boolean gameOver = false;

    //Scanner class object to take input from the user
    Scanner sc = new Scanner(System.in);

    //Array to store the ladders and snakes
    SnakesAndLadders[] snakesAndLadders;

    //Method to start the snakes and ladders game
    public void snakesAndLadders() {

        //Initializing the game over variable to false

        gameOver = false;

        //Initializing the Ladders and Snakes array
        initializeLaddersAndSnakes();
        

        // Code for Snake Game

        System.out.println("\n\nWelcome to Snake and Ladder Game!");
        System.out.print("\n\nHow many players are playing : ");
        int numberOfPlayers = sc.nextInt();

        Player[] players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++){
            System.out.print("\nEnter the name of player " + (i+1) + " : ");
            players[i] = new Player(sc.next(), 0);
        }


        while(!gameOver){
            

            for (int i = 0; i < numberOfPlayers;i++){

                System.out.println("\nPlayer " + players[i].getName() + " is playing!");

                System.out.println("Press "+(i+1)+" to roll the dice player "+players[i].getName()+"!");

                if (sc.nextInt() == i+1){

                    int previousPosition = players[i].position;

                    players[i].position = snakesAndLaddersMove(players[i].position);

                    if(players[i].position > 100){

                        players[i].position = previousPosition;

                    }

                    System.out.println("Player " + players[i].getName() + " current position: " + players[i].getPosition());
                    
                }else{

                    System.out.println("Invalid input. Please try again.");
                    
                    i = i - 1;
                }

                if (i >= 0 && (gameOver = checkPosition(players[i].getPosition()))){

                    System.out.println("\n\nPlayer " + players[i].getName() + " has won!\n");
                    
                    break;

                }
                    

            }

            if(gameOver){

                System.out.println("\n\nGame Over!");
                
            }


        }


        
    }

    boolean checkPosition(int position){

        if(position >= 100){
            gameOver = true;
        }

        return gameOver;

    }

    private void initializeLaddersAndSnakes() {
        snakesAndLadders = new SnakesAndLadders[16];
        snakesAndLadders[0] = new SnakesAndLadders(3, 38);
        snakesAndLadders[1] = new SnakesAndLadders(4, 14);
        snakesAndLadders[2] = new SnakesAndLadders(8, 31);
        snakesAndLadders[3] = new SnakesAndLadders(21, 42);
        snakesAndLadders[4] = new SnakesAndLadders(28, 84);
        snakesAndLadders[5] = new SnakesAndLadders(50, 67);
        snakesAndLadders[6] = new SnakesAndLadders(71, 91);
        snakesAndLadders[7] = new SnakesAndLadders(80, 96);
        snakesAndLadders[8] = new SnakesAndLadders(17, 7);
        snakesAndLadders[9] = new SnakesAndLadders(54, 34);
        snakesAndLadders[10] = new SnakesAndLadders(62, 19);
        snakesAndLadders[11] = new SnakesAndLadders(64, 60);
        snakesAndLadders[12] = new SnakesAndLadders(87, 24);
        snakesAndLadders[13] = new SnakesAndLadders(93, 73);
        snakesAndLadders[14] = new SnakesAndLadders(95, 75);
        snakesAndLadders[15] = new SnakesAndLadders(98, 59);
        
    }

    private int snakesAndLaddersMove(int poistion){

        int dice = (int)(Math.random() * 6) + 1;
        System.out.println("Dice: " + dice);
        poistion += dice;
        
        for (int i = 0; i < snakesAndLadders.length; i++){

            if (poistion == snakesAndLadders[i].getPosition() && poistion < snakesAndLadders[i].getNext()){

                System.out.println("The player has climbed a ladder!");

                poistion = snakesAndLadders[i].getNext();
            }
            else if (poistion == snakesAndLadders[i].getPosition() && poistion > snakesAndLadders[i].getNext()){

                System.out.println("The player has been bitten by a snake!");

                poistion = snakesAndLadders[i].getNext();
            }    

        }

        return poistion;


    }
    
}

class SnakesAndLadders{
    private int position;
    private int next;

    public SnakesAndLadders(int position, int next) {
        this.position = position;
        this.next = next;
    }

    public int getPosition() {
        return position;
    }

    public int getNext() {
        return next;
    }
}

class Player{
    private String name;
    public int position;

    public Player(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}