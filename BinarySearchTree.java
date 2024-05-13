// Programer: Sarai Ayon
// Class: CS&141 F2P
// Date: 11/28/23
// Assignment: Lab 6: Binary Search Tree Dictionary
// Reference Materials: CH 13, CH 18, CH 17
// Purpose: This program allows users to add, delete, view, and perform other actions on employee records using a Binary Search Tree. 



import java.util.Scanner;

// This class represents a Binary Search Tree that manages employee information.
public class BinarySearchTree {
    // The root is like the starting point of the tree. It's the first piece of information we have.
    private Node root;

    // This special method is called a constructor. It helps create a new Binary Search Tree.
    public BinarySearchTree() {
        // Initially, when we create the tree, it doesn't have any information (null).
        this.root = null;
    }//end of method

    // This method adds a new employee's information to the tree.
    public void add(int key, String firstName, String lastName, String streetAddress, String city, String state, String zip, String email, String phoneNumber) {
        // We use a helper method addRecursive to do the actual adding, starting from the root.
        root = addRecursive(root, key, firstName, lastName, streetAddress, city, state, zip, email, phoneNumber);
    }// end of method

    // This is a private helper method for adding a new employee recursively.
    private Node addRecursive(Node node, int key, String firstName, String lastName, String streetAddress, String city, String state, String zip, String email, String phoneNumber) {
        // If the current node is empty, we create a new Node with the employee's information.
        if (node == null) {
            return new Node(key, firstName, lastName, streetAddress, city, state, zip, email, phoneNumber);
        }//end of IF

        // Depending on whether the employee's ID is smaller or larger, we go to the left or right.
        if (key < node.key) {
            node.left = addRecursive(node.left, key, firstName, lastName, streetAddress, city, state, zip, email, phoneNumber);
        } else if (key > node.key) {
            node.right = addRecursive(node.right, key, firstName, lastName, streetAddress, city, state, zip, email, phoneNumber);
        }//end of else

        // We return the modified node.
        return node;
    }// end of method


    // This method removes an employee from the tree based on their ID.
    public void delete(int key) {
        // We use a helper method deleteRecursive to do the actual deleting, starting from the root.
        root = deleteRecursive(root, key);
    }// end of method

    // This is a private helper method for deleting an employee recursively.
    private Node deleteRecursive(Node root, int key) {
        // If the current node is empty, we return it.
        if (root == null) {
            return root;
        }// end of if

        // Depending on whether the employee's ID is smaller or larger, we go to the left or right.
        if (key < root.key) {
            root.left = deleteRecursive(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRecursive(root.right, key);
        } else {
            // If we found the employee, we handle different cases to delete them properly.
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }// end else/if

            // We replace the employee's information with the smallest value from the right subtree.
            root.key = minValue(root.right);
            root.right = deleteRecursive(root.right, root.key);
        }// end else

        // We return the modified root.
        return root;
    }// end of method

    // This method finds the smallest value in a subtree, used during the deletion process.
    private int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }// end of while
        return minValue;
    } // end of method

    // This method displays a menu for the user to interact with the program.
    public void displayMenu() {
        System.out.println("***** Employee Information Management System *****");
        // Your ASCII art goes here

        System.out.println("1. Add Record");
        System.out.println("2. Delete Record");
        System.out.println("3. View Rolodex");
        // Other menu options can be added here
        System.out.println("6. Exit");
    }// end of method

    // This method displays a Rolodex of all employees in the tree.
    public void viewRolodex() {
        System.out.println("***** Rolodex *****");
        // We use a helper method viewRolodexInOrder to traverse the tree and display each employee's information.
        viewRolodexInOrder(root);
        System.out.println("********************");
    }// end of method

    // This is a private helper method for displaying the Rolodex in order.
    private void viewRolodexInOrder(Node node) {
        // If the current node is not empty, we display the employee's information and go to the left and right.
        if (node != null) {
            viewRolodexInOrder(node.left);

            // Display each employee's information as a single string
            String employeeInfo = "ID: " + node.key + ", Name: " + node.firstName + " " + node.lastName +
                    ", Address: " + node.streetAddress + ", " + node.city + ", " + node.state + " " + node.zip +
                    ", Email: " + node.email + ", Phone: " + node.phoneNumber;

            System.out.println(employeeInfo);

            viewRolodexInOrder(node.right);
        }// end of IF
    }// end of method

    // This method looks up and returns a specific employee's information based on their ID.
    public Node lookup(int key) {
        return lookupRecursive(root, key);
    }// end of method

    // This is a private helper method for looking up an employee recursively.
    private Node lookupRecursive(Node node, int key) {
        // If the current node is empty or we found the employee, we return the node.
        if (node == null || node.key == key) {
            return node;
        }// end if IF

        // Depending on whether the employee's ID is smaller or larger, we go to the left or right.
        if (key < node.key) {
            return lookupRecursive(node.left, key);
        } else {
            return lookupRecursive(node.right, key);
        }
    }// end of method

    // This method modifies an employee's information based on their ID.
    public void modify(int key, String newFirstName, String newLastName, String newStreetAddress, String newCity, String newState, String newZip, String newEmail, String newPhoneNumber) {
        root = modifyRecursive(root, key, newFirstName, newLastName, newStreetAddress, newCity, newState, newZip, newEmail, newPhoneNumber);
    }// end of method

    // This is a private helper method for modifying an employee's information recursively.
    private Node modifyRecursive(Node node, int key, String newFirstName, String newLastName, String newStreetAddress, String newCity, String newState, String newZip, String newEmail, String newPhoneNumber) {
        // If the current node is empty, we return null.
        if (node == null) {
            return null;
        }

        // Depending on whether the employee's ID is smaller or larger, we go to the left or right.
        if (key < node.key) {
            node.left = modifyRecursive(node.left, key, newFirstName, newLastName, newStreetAddress, newCity, newState, newZip, newEmail, newPhoneNumber);
        } else if (key > node.key) {
            node.right = modifyRecursive(node.right, key, newFirstName, newLastName, newStreetAddress, newCity, newState, newZip, newEmail, newPhoneNumber);
        } else {
            // If we found the employee, we modify their information.
            node.firstName = newFirstName;
            node.lastName = newLastName;
            node.streetAddress = newStreetAddress;
            node.city = newCity;
            node.state = newState;
            node.zip = newZip;
            node.email = newEmail;
            node.phoneNumber = newPhoneNumber;
        }

        // We return the modified node.
        return node;
    }// end of method

    // This method lists all employee records in the tree.
    public void listRecords() {
        listRecordsInOrder(root);
    }// end of method

    // This is a private helper method for listing employee records in order.
    private void listRecordsInOrder(Node node) {
        // If the current node is not empty, we display the employee's information and go to the left and right.
        if (node != null) {
            listRecordsInOrder(node.left);
            System.out.println("ID: " + node.key + ", Name: " + node.firstName + " " + node.lastName +
                    ", Address: " + node.streetAddress + ", " + node.city + ", " + node.state + " " + node.zip +
                    ", Email: " + node.email + ", Phone: " + node.phoneNumber);
            listRecordsInOrder(node.right);
        }
        
    }// end of method
    
}// end of CLASS

