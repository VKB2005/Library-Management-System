import java.util.ArrayList;
import java.util.List;

class Members extends BaseMember{
private String memberId;
private List<Books> borrowedBooks;
private static int memberCount = 0;
private final int maxBorrowLimit = 5;

Members(String name,String contactInfo){
super(name, contactInfo);
this.memberId = "M" + (++memberCount);
this.borrowedBooks = new ArrayList<>();
}
public String getMemberId(){ 
return memberId; 
}
public List<Books> getBorrowedBooks(){ 
return borrowedBooks; 
}
public void borrowBook(Books book){
if(borrowedBooks.size() < maxBorrowLimit && book.isAvailable()){
borrowedBooks.add(book);
book.borrowBook();
System.out.println(getName() + " borrowed: " + book.getTitle());
} 
else{
System.out.println(getName() + " cannot borrow " + book.getTitle() +". Limit reached or book unavailable.");
}
}
public void returnBook(Books book,int overdueDays){
if(borrowedBooks.contains(book)){
borrowedBooks.remove(book);
book.returnBook();
System.out.println(getName() + " returned: " + book.getTitle());
} 
else{
System.out.println(getName() + " did not borrow " + book.getTitle());
}
}
public String getName(){ 
return name; 
}
public String getContactInfo(){ 
return contactInfo; 
}
public boolean isEligibleToBorrow(){ 
return borrowedBooks.size() < maxBorrowLimit; 
}
public String memberDetails(){
System.out.println("Borrowed Books: ");
if (borrowedBooks.isEmpty()){
System.out.println("No books borrowed.");
} 
else{
for (Books book : borrowedBooks){
book.bookDetails();
}
}
return("Member ID: " + memberId + ", Name: " + this.getName() + ", Contact Info: " + this.getContactInfo());
}
}
