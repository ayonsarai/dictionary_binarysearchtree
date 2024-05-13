// Programer: Sarai Ayon
// Class: CS&141 F2P
// Date: 11/28/23
// Assignment: Lab 6: Binary Search Tree Dictionary
// Reference Materials: CH 13, CH 18, CH 17
/* Purpose:  the Dictionary class orchestrates the interaction between the user and the employee information management system. It utilizes a Binary Search Tree to efficiently 
store and manipulate employee records while providing a simple and interactive command-line interface for users.*/



public class Dictionary {
   // This is the starting point of our program. Every program needs a main method where execution begins.
   public static void main(String[] args) {
      // We're creating a BinarySearchTree (bst) to store and manage employee information.
      BinarySearchTree bst = new BinarySearchTree();
      // We're also creating a scanner to take input from the user.
      Scanner scanner = new Scanner(System.in);
   
      // This loop keeps running until the user decides to exit the program.
      while (true) {
         // Displaying a menu to the user, asking them what action they want to perform.
         bst.displayMenu();
         System.out.print("Enter your choice: ");
      
         // We want to make sure the user enters a number, so we're checking if the input is an integer.
         while (!scanner.hasNextInt()) {
            // If the input is not an integer, we tell the user there was an error and ask for input again.
            System.out.println("Oops! Please enter a valid integer.");
            scanner.next(); // Consume the invalid input
         }
      
         // Once we're sure the input is an integer, we store it in the variable 'choice'.
         int choice = scanner.nextInt();
      
         // We use a switch statement to perform different actions based on the user's choice.
         switch (choice) {
            case 1:
               // Add Record
               // We're asking the user for employee details and handling potential errors.
               System.out.println("Enter employee details:");
            
               try {
                  // Asking for and validating the employee ID.
                  System.out.print("1. Employee ID (6 digits): ");
                  String idString = scanner.next();
                  if (idString.length() != 6 || !idString.matches("\\d+")) {
                     // If the input is not a 6-digit number, we throw an exception and handle it in the catch block.
                     throw new Exception("Invalid input. Defaulting to catch block.");
                  }
               
                  // Converting the valid ID to an integer.
                  int id = Integer.parseInt(idString);
               
                  // Consuming the newline character to prevent issues with the next input.
                  scanner.nextLine(); 
               
                  // Asking for other employee details.
                  System.out.print("2. First name: ");
                  String firstName = scanner.nextLine();
                  System.out.print("3. Last name: ");
                  String lastName = scanner.nextLine();
               
                  System.out.print("4. Street address: ");
                  String streetAddress = scanner.nextLine();
                  System.out.print("5. City: ");
                  String city = scanner.nextLine();
                  System.out.print("6. State: ");
                  String state = scanner.nextLine();
                  System.out.print("7. ZIP: ");
                  String zip = scanner.nextLine();
                  System.out.print("8. Email: ");
                  String email = scanner.nextLine();
                  System.out.print("9. Phone number: ");
                  String phoneNumber = scanner.nextLine();
               
                  // Adding the new employee to the Binary Search Tree.
                  bst.add(id, firstName, lastName, streetAddress, city, state, zip, email, phoneNumber);
                  System.out.println("Record added successfully!");
               } catch (Exception e) {
                  // If there's an error (e.g., invalid input), we catch the exception and inform the user.
                  System.out.println("Oops! Invalid input. Please try again.");
                  scanner.nextLine(); // Consume the entire line to prevent an infinite loop
               }// end of catch
               break;
         
            case 2:
               // Delete Record
               // We're asking the user for the employee ID to delete and then deleting that employee.
               System.out.print("Enter employee ID to delete: ");
               int deleteId = scanner.nextInt();
               bst.delete(deleteId);
               System.out.println("Record deleted successfully!");
               break;
         
            case 3:
               // View Rolodex
               // Displaying all employee information in a nice list (Rolodex).
               bst.viewRolodex();
               break;
         
            // Other cases for modifying, looking up, and listing records can be added here
         
            case 6:
               // Exit
               // Exiting the program when the user chooses to exit.
               System.out.println("Exiting program. Goodbye!");
               System.exit(0);
               break;
         
            default:
               // If the user enters an invalid choice, we inform them and ask for input again.
               System.out.println("Oops! Invalid choice. Please try again.");
         }// end of switch
         
      }// end of while 
      
      
   }// end of Main
   
   
}// end of CLASS
