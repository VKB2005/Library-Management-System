import java.util.Scanner;

class AdminPanel{
private Library library;
private Settings settings;
private Scanner scanner;

AdminPanel(Library library,Settings settings,Scanner scanner){
this.library = library;
this.settings = settings;
this.scanner = scanner;
}
public void start(){
int choice = 0;
do{
System.out.println("\n--- Admin Panel ---");
System.out.println("1. Add Book");
System.out.println("2. Remove Book");
System.out.println("3. Add Member");
System.out.println("4. Remove Member");
System.out.println("5. View Library Report");
System.out.println("6. Update Settings");
System.out.println("7. Exit Admin Panel");
System.out.print("Enter your choice: ");
if(!scanner.hasNextInt()){
System.out.println("Invalid input! Please enter a number.");
scanner.next();
continue;
}
choice = scanner.nextInt();
scanner.nextLine(); 
switch(choice){
case 1:
addBook();
break;
case 2:
removeBook();
break;
case 3:
addMember();
break;
case 4:
removeMember();
break;
case 5:
viewLibraryReport();
break;
case 6:
updateSettings();
break;
case 7:
System.out.println("Exiting Admin Panel.");
break;
default:
System.out.println("Invalid choice! Please try again.");
}
}while(choice != 7);
}
private void addBook(){
System.out.print("Enter the book title: ");
String title = scanner.nextLine();
System.out.print("Enter the author name: ");
String author = scanner.nextLine();
System.out.print("Enter the genre: ");
String genre = scanner.nextLine();
System.out.print("Enter the published year: ");
if(!scanner.hasNextInt()){
System.out.println("Invalid input! Published year must be a number.");
scanner.next();
return;
}
int year = scanner.nextInt();
scanner.nextLine();
Books book = new Books(title, author, year, genre);
library.addBook(book);
System.out.println("Book added successfully!");
}
private void removeBook(){
System.out.print("Enter the book ID to remove: ");
String bookID = scanner.nextLine();
library.removeBook(bookID);
}
private void addMember(){
System.out.print("Enter the member name: ");
String name = scanner.nextLine();
System.out.print("Enter the contact info: ");
String contact = scanner.nextLine();
Members member = new Members(name, contact);
library.registerMember(member);
System.out.println("Member added successfully!");
}
private void removeMember(){
System.out.print("Enter the member ID to remove: ");
String memberID = scanner.nextLine();
library.removeMember(memberID);
}
private void viewLibraryReport(){
System.out.println("Generating Library Report...");
library.generateLibraryReport();
}
private void updateSettings(){
System.out.println("\n--- Update Settings ---");
System.out.println("1. Update Library Name");
System.out.println("2. Update Address");
System.out.println("3. Update Contact Info");
System.out.println("4. Update Fine Rate");
System.out.println("5. View Current Settings");
System.out.println("6. Exit Settings");
System.out.print("Enter your choice: ");
int choice;
if(!scanner.hasNextInt()){
System.out.println("Invalid input! Please enter a number.");
scanner.next();
return;
}
choice = scanner.nextInt();
scanner.nextLine(); 
switch(choice){
case 1:
System.out.print("Enter new library name: ");
String libraryName = scanner.nextLine();
settings.setLibraryName(libraryName);
System.out.println("Library name updated successfully!");
break;
case 2:
System.out.print("Enter new address: ");
String address = scanner.nextLine();
settings.setAddress(address);
System.out.println("Address updated successfully!");
break;
case 3:
System.out.print("Enter new contact info: ");
String contactInfo = scanner.nextLine();
settings.setContactInfo(contactInfo);
System.out.println("Contact info updated successfully!");
break;
case 4:
System.out.print("Enter new fine rate: ");
if(!scanner.hasNextDouble()){
System.out.println("Invalid input! Fine rate must be a number.");
scanner.next();
return;
}
double fineRate = scanner.nextDouble();
scanner.nextLine(); 
settings.setFineRate(fineRate);
System.out.println("Fine rate updated successfully!");
break;
case 5:
System.out.println("Current Settings:");
settings.displaySettings();
break;
case 6:
System.out.println("Exiting Settings.");
break;
default:
System.out.println("Invalid choice! Please try again.");
}
}
}
