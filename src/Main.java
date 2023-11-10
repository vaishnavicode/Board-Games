import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


            while (true) {

                System.out.println("\n----INDEX----\n1. Snakes and Ladders\n4. Exit");

                //To add: 2. Tic Tac Toe 3. Monopoly

                System.out.print("\nEnter your choice: ");

                int choice = sc.nextInt();

                if(choice == 4){
                    break;
                }

                switch (choice) {
                    case 1:
                        SnakesAndLaddersGame obj = new SnakesAndLaddersGame();
                        obj.snakesAndLadders();
                        break;  
                        
                    default:
                        System.out.println("Invalid choice. Please enter a valid choice.");
                        break;
                }


            }

        




        sc.close();
        
    }
    
}