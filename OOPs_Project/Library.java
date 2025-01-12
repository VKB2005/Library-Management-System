import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

class Library implements LibraryOperations{
private static Library instance;
private String libraryName;
private String address;
private String contactInfo;
private List<Books> libraryBooks;
private List<Members> members;
private List<Librarian> librarians;
private List<Transaction> transactions;
private int totalBooks;
private Settings settings;
private FineCalculator fineCalculator;

Library(String libraryName,String address,String contactInfo,FineCalculator fineCalculator){
this.libraryName = libraryName;
this.address = address;
this.contactInfo = contactInfo;
this.libraryBooks = new ArrayList<>();
this.members = new ArrayList<>();
this.librarians = new ArrayList<>();
this.transactions = new ArrayList<>();
this.totalBooks = 0;
this.fineCalculator =  fineCalculator != null ? fineCalculator : new
StandardFineCalculator();
}
Library(String libraryName,String address,String contactInfo){
//this(libraryName,address,contactInfo,new StandardFineCalculator());
this.libraryName = libraryName;
this.address = address;
this.contactInfo = contactInfo;
}
Library(){
this.libraryBooks = new ArrayList<>();  
this.members = new ArrayList<>();
this.transactions = new ArrayList<>();
}
Library(List<Books> libraryBooks,List<Members> members,List<Transaction> transactions){
this.libraryBooks = libraryBooks;
this.members = members;
this.transactions = transactions;
}
public void addBook(Books book){
libraryBooks.add(book);
totalBooks++;
System.out.println("Book added: " + book.getTitle() + " by " + book.getAuthor());
}
public void removeBook(String bookID){
Books bookToRemove = findBookByID(bookID);
if(bookToRemove != null){
libraryBooks.remove(bookToRemove);
totalBooks--;
System.out.println("Book removed: " + bookToRemove.getTitle());
}
else{
System.out.println("Book with ID " + bookID + " not found.");
}
}
public void listAllBooks(){
System.out.println("Listing all books in the library:");
for (Books book : libraryBooks) {
book.bookDetails();
}
}
public void registerMember(Members member){
members.add(member);
System.out.println("Member registered: " + member.getName());
}
public void removeMember(String memberID){
Members memberToRemove = findMemberByID(memberID);
if(memberToRemove != null){
members.remove(memberToRemove);
System.out.println("Member removed: " + memberToRemove.getName());
}
else{
System.out.println("Member with ID " + memberID + " not found.");
}
}
public void listAllMembers(){
System.out.println("Listing all members:");
for(Members member : members){
member.memberDetails();
}
}
public void addLibrarian(Librarian librarian){
librarians.add(librarian);
System.out.println("Librarian added: " + librarian.getName());
}
public void removeLibrarian(String librarianID){
Librarian librarianToRemove = null;
for(Librarian librarian : librarians){
if(librarian.getID().equals(librarianID)){
librarianToRemove = librarian;
break;
}
}
if(librarianToRemove != null){
librarians.remove(librarianToRemove);
System.out.println("Librarian removed: " + librarianToRemove.getName());
} 
else{
System.out.println("Librarian with ID " + librarianID + " not found.");
}
}
public void issueBook(Members member, Books book){
if(member.isEligibleToBorrow() && book.isAvailable()){
member.borrowBook(book);
transactions.add(new Transaction("TXN-" + transactions.size(), member,book,
java.time.LocalDate.now(),java.time.LocalDate.now().plusDays(14),0.0));
System.out.println("Book issued: " + book.getTitle() + " to " + member.getName());
}
else{
System.out.println("Book cannot be issued. Either the book is not available or the member has reached the borrowing limit.");
}
}
public void returnBook(Members member, Books book, int overdueDays){
if (member.getBorrowedBooks().contains(book)){
member.returnBook(book, overdueDays);
double fine = fineCalculator.calculateFine(overdueDays);
if(fine > 0){
System.out.println("Member " + member.getName() + " has an overdue fine of $" + fine);
} 
else{
System.out.println("Member " + member.getName() + " returned on time.");
}
} 
else{
System.out.println("Member " + member.getName() + " did not borrow this book.");
}
}
public void generateLibraryReport(){
System.out.println("Library Report: ");
System.out.println("Total books in the library: " + totalBooks);
listAllBooks();
System.out.println("Total members in the library: " + members.size());
listAllMembers();
}
public List<Books> getLibraryBooks(){
if (libraryBooks == null) {
libraryBooks = new ArrayList<>();
}
System.out.println("Library books count: " + libraryBooks.size());
return libraryBooks;
}
public void setFineRate(double newFineRate){
if(fineCalculator instanceof StandardFineCalculator){
((StandardFineCalculator) fineCalculator).setFineRate(newFineRate);
}
}
public int getTotalBooks(){
return totalBooks;
}
public List<Members> getMembers(){
return members;
}
public List<Transaction> getTransactions(){
return transactions;
}
private Books findBookByID(String bookID){
for(Books book : libraryBooks){
if(book.getID().equals(bookID)){
return book;
}
}
return null;
}
public FineCalculator getFineCalculator(){
return fineCalculator;
}
private Members findMemberByID(String memberID){
for(Members member : members){
if(member.getMemberId().equals(memberID)){
return member;
}
}
return null;
}
public Books findBookByTitle(String title){
for(Books book : libraryBooks){
if(book.getTitle().equalsIgnoreCase(title)){
return book;
}
}
return null;
}
public Members findMemberByName(String name){
for(Members member : members){
if(member.getName().equalsIgnoreCase(name)){
return member;
}
}
return null;
}

public Transaction findTransaction(Members member,Books book){
for(Transaction transaction : transactions){
if(transaction.getBook().equals(book) && transaction.getMember().equals(member)){
return transaction;
}
}
return null;
}
public Settings getSettings(){
return settings;
}
public void updateLibraryInfo(String newName,String newAddress,String newContactInfo){
this.libraryName = newName;
this.address = newAddress;
this.contactInfo = newContactInfo;
System.out.println("Library information updated.");
}
public static Library getInstance(){
if(instance == null){
instance = new Library();
}
return instance;
}
public void addTransaction(Transaction transaction){
transactions.add(transaction);
}
public double calculateFine(int overdueDays){
return overdueDays * 1.0;
}
public void addMember(Members member){
members.add(member);
}
public void setFineCalculator(FineCalculator fineCalculator){
if (fineCalculator == null){
throw new IllegalArgumentException("FineCalculator cannot be null");
}
this.fineCalculator = fineCalculator;
}
}
