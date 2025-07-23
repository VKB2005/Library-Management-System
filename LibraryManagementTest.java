import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

class LibraryManagementTest{
public static void main(String[] args){
Library library = new Library("City Library", "123 Main St", "contact@citylibrary.com");
Settings settings = new Settings("City Library", "123 Main St", "contact@citylibrary.com", 1.5);
library.addBook(new Books("The Great Gatsby", "F. Scott Fitzgerald", 1925, "Fiction"));
library.addBook(new Books("To Kill a Mockingbird", "Harper Lee", 1960, "Fiction"));
library.registerMember(new Members("John Doe", "john.doe@example.com"));
library.registerMember(new Members("Jane Smith", "jane.smith@example.com"));

ArrayList<Books> books = new ArrayList<>();
ArrayList<Members> members = new ArrayList<>();
for(Books book : books){
library.addBook(book); 
}
for(Members member : members){
library.registerMember(member);
}
Scanner scanner = new Scanner(System.in);
HashMap<String, String> adminCredentials = new HashMap<>();
HashMap<String, String> userCredentials = new HashMap<>();
adminCredentials.put("admin", "admin123");
userCredentials.put("user", "user123"); 
int choice = 0;
do{
System.out.println("\n--- Library Management System ---");
System.out.println("1. User Interface");
System.out.println("2. Admin Panel");
System.out.println("3. Create New Login");
System.out.println("4. Exit");
System.out.print("Enter your choice: ");
if(scanner.hasNextInt()){
choice = scanner.nextInt();
scanner.nextLine();
switch (choice){
case 1:
if(authenticate(scanner,userCredentials,"user")){
UserInterface ui = new UserInterface(library, new Search(library), settings, scanner);
ui.start();
} 
else{
System.out.println("Access denied. Invalid user credentials.");
}
break;
case 2:
if(authenticate(scanner,adminCredentials,"admin")){
AdminPanel adminPanel = new AdminPanel(library, settings, scanner);
adminPanel.start();
} 
else{
System.out.println("Access denied. Invalid admin credentials.");
}
break;
case 3:
createLogin(scanner,adminCredentials,userCredentials);
break;
case 4:
System.out.println("Exiting Library Management System. Goodbye!");
break;
default:
System.out.println("Invalid choice. Please try again.");
}
} 
else{
System.out.println("Invalid input. Please enter a valid number.");
scanner.next();
}
}while(choice != 4);
scanner.close();
}
private static boolean authenticate(Scanner scanner,HashMap<String, String> credentials,String role){
System.out.println("\n--- " + role.toUpperCase() + " Login ---");
System.out.print("Enter username: ");
String username = scanner.nextLine();
System.out.print("Enter password: ");
String password = scanner.nextLine();
if(credentials.containsKey(username) && credentials.get(username).equals(password)){
System.out.println(role.substring(0, 1).toUpperCase() + role.substring(1) + " login successful!");
return true;
} 
else{
return false;
}
}
private static void createLogin(Scanner scanner,HashMap<String, String> adminCredentials,HashMap<String, String> userCredentials){
System.out.println("\n--- Create New Login ---");
System.out.println("1. Create Admin Login");
System.out.println("2. Create User Login");
System.out.print("Enter your choice: ");
int choice = scanner.nextInt();
scanner.nextLine(); 
if (choice == 1 || choice == 2) {
System.out.print("Enter username: ");
String username = scanner.nextLine();
System.out.print("Enter password: ");
String password = scanner.nextLine();
if (choice == 1){
if(adminCredentials.containsKey(username)){
System.out.println("Admin username already exists. Choose a different username.");
} 
else{
adminCredentials.put(username, password);
System.out.println("Admin login created successfully.");
}
} 
else{
if(userCredentials.containsKey(username)){
System.out.println("User username already exists. Choose a different username.");
}
else{
userCredentials.put(username, password);
System.out.println("User login created successfully.");
}
}
} 
else{
System.out.println("Invalid choice. Returning to the main menu.");
}
}
}
