import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            while (true) {

                System.out.println("\n----INDEX----\n1. Snakes and Ladders\n2. Tic Tac Toe\n3. \n4. Exit");
                System.out.print("\nEnter your choice: ");

                int choice = sc.nextInt();

                if(choice == 4){
                    break;
                }

                switch (choice) {
                    case 1:
                        break;

                    case 2:
                        break;

                    case 3:
                        break;  
                        
                    default:
                        System.out.println("Invalid choice. Please enter a valid choice.");
                        break;
                }


            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }




        sc.close();
        
    }
    
}