import java.util.Scanner;

class UserInterface{
private Library library;
private Search search;
private Settings settings;
private Scanner scanner;

UserInterface(Library library,Search search,Settings settings,Scanner scanner){
this.library = library;
this.search = search;
this.settings = settings;
this.scanner = scanner;
}
public void start(){
int choice=0;
do{
System.out.println("\n--- User Interface ---");
System.out.println("1. Search for a Book");
System.out.println("2. Search for a Member");
System.out.println("3. Borrow a Book");
System.out.println("4. Return a Book");
System.out.println("5. Exit");
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
searchBook();
break;
case 2:
searchMember();
break;
case 3:
issueBook();
break;
case 4:
returnBook();
break;
case 5:
System.out.println("Exiting User Interface.");
break;
default:
System.out.println("Invalid choice! Please try again.");
}
}while (choice != 5);
}
private void searchBook(){
System.out.print("Enter the book title: ");
String bookTitle = scanner.nextLine();
Books book = search.findBookByTitle(bookTitle);
if(book != null){
System.out.println("Book found:");
book.bookDetails();
} 
else{
System.out.println("Book not found!");
}
}
private void searchMember(){
System.out.print("Enter the member name: ");
String memberName = scanner.nextLine();
Members member = search.findMemberByName(memberName);
if(member != null){
System.out.println("Member found:");
member.memberDetails();
}
else{
System.out.println("Member not found!");
}
}
private void issueBook(){
System.out.print("Enter the member name: ");
String memberName = scanner.nextLine();
Members member = search.findMemberByName(memberName);
if(member == null){
System.out.println("Member not found!");
return;
}
System.out.print("Enter the book title: ");
String bookTitle = scanner.nextLine();
Books book = search.findBookByTitle(bookTitle);
if(book == null){
System.out.println("Book not found!");
return;
}
library.issueBook(member, book);
System.out.println("Book issued successfully!");
}
private void returnBook(){
System.out.print("Enter the member name: ");
String memberName = scanner.nextLine();
Members member = search.findMemberByName(memberName);
if(member == null){
System.out.println("Member not found!");
return;
}
System.out.print("Enter the book title: ");
String bookTitle = scanner.nextLine();
Books book = search.findBookByTitle(bookTitle);
if(book == null){
System.out.println("Book not found!");
return;
}
System.out.print("Enter the overdue days: ");
if(!scanner.hasNextInt()){
System.out.println("Invalid input! Overdue days must be a number.");
scanner.next();
return;
}
int overdueDays = scanner.nextInt();
scanner.nextLine();
library.returnBook(member, book, overdueDays);
System.out.println("Book returned successfully!");
}
}
