import java.util.Scanner;

public class SnakesAndLadders {

    int Ladders[],Snakes[],LaddersEnd[],SnakesEnd[];

    //Boolean class variable to check if the game is over or not
    boolean gameOver = false;

    //Scanner class object to take input from the user
    Scanner sc = new Scanner(System.in);

    //Array to store the positions of the players
    int playerPositions[];

    //Method to start the snakes and ladders game
    public void snakesAndLadders() {

        //Initializing the game over variable to false

        gameOver = false;

        //Initializing the Ladders and Snakes array
        Ladders = new int[]{1,4,8,21,28,50,71,80};
        Snakes = new int[]{17,54,62,64,87,93,95,98};
        LaddersEnd = new int[]{38,14,31,42,84,67,91,100};
        SnakesEnd = new int[]{7,34,19,60,24,73,75,79};

        // Code for Snake Game

        System.out.println("\n\nWelcome to Snake and Ladder Game!");
        System.out.print("\n\nHow many players are playing : ");
        int numberOfPlayers = sc.nextInt();



        playerPositions = new int[numberOfPlayers];
        for(int i = 0; i < numberOfPlayers; i++){
            playerPositions[i] = 0;
        }
        while(!gameOver){
            

            for(int i = 0; i < numberOfPlayers; i++){

                if(i >= 0 && playerPositions[i] >= 100){
                    System.out.println("\n\nPlayer " + (i+1) + " has won!\n");
                        gameOver = true;
                    break;

                }
                System.out.println("\nPlayer " + (i+1) + " playing!");
                System.out.println("Press "+(i+1)+" to roll the dice player "+(i+1)+"!");

                if(sc.nextInt() == i+1){
                    playerPositions[i] = snakesAndLaddersMove(playerPositions[i]);
                    System.out.println("Player " + (i+1) + " current position: " + playerPositions[i]);
                    
                }
                else{
                    System.out.println("Invalid input. Please try again.");
                    i--;
                }
                    

            }

            if(gameOver){
                System.out.println("\n\nGame Over!");
                
            }


        }


        
    }

    private int snakesAndLaddersMove(int poistion){

        int dice = (int)(Math.random() * 6) + 1;
        System.out.println("Dice: " + dice);
        poistion += dice;
        
        for (int i = 0; i < Ladders.length; i++){
            if (poistion == Ladders[i]){
                System.out.println("The player has climbed a ladder!");
                poistion = LaddersEnd[i];
            }
            else if (poistion == Snakes[i]){
                System.out.println("The player has been bitten by a snake!");
                poistion = SnakesEnd[i];
            }    

        }

        return poistion;


    }
    
}
