// Programer: Sarai Ayon
// Class: CS&141 F2P
// Date: 11/28/23
// Assignment: Lab 6: Binary Search Tree Dictionary
// Reference Materials: CH 13, CH 18, CH 17
/* Purpose: this code helps us define what a "Node" is in a computer program. In our case, a Node is like a box that holds information about an employee. 
The information includes things like the employee's name, address, and contact details. Additionally, each box (Node) has two arrows that can point to other boxes, representing 
connections between different employees. The constructor is like a set of instructions that helps us create a new box (Node) with the specific details of an employee.*/



// We are creating a blueprint for a Node, which is like a container for storing information about an employee.
public class Node {
    // These are variables to store different pieces of information about an employee.
    int key;  // An identification number for the employee
    String firstName;  // The first name of the employee
    String lastName;   // The last name of the employee
    String streetAddress;  // The street address where the employee lives
    String city;  // The city where the employee lives
    String state;  // The state where the employee lives
    String zip;  // The ZIP code (postal code) of the employee's location
    String email;  // The email address of the employee
    String phoneNumber;  // The phone number of the employee

    // These are references to other nodes. Think of them like connections to other containers.
    Node left;  // A reference to the left container (node) in the tree
    Node right;  // A reference to the right container (node) in the tree

    // This is a special method called a constructor. It helps us create a new Node.
    // When we create a new Node, we provide all the necessary information about the employee.
    public Node(int key, String firstName, String lastName, String streetAddress, String city, String state, String zip, String email, String phoneNumber) {
        // Here, we are setting the values for all the variables with the information we received.
        this.key = key;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.phoneNumber = phoneNumber;

        // We initialize the left and right references to null because, initially, the node doesn't have any connections.
        this.left = this.right = null;
    } // end of the constructor for the Node.

} // Tend of the Node class.
