import java.time.LocalDate;

class Transaction extends BaseTransaction{
private String transactionID;

Transaction(String transactionID,Members member,Books book,LocalDate issueDate,LocalDate dueDate,double fine){
super(member, book, issueDate, dueDate,fine);
this.transactionID = transactionID;
}
Transaction(int transactionId,Books book,Members member,LocalDate issueDate,LocalDate returnDate,double fine){
super(member, book, issueDate, returnDate,fine);
this.transactionID = transactionID;
}
public String getTransactionID(){
return transactionID;
}
public Books getBook(){
return super.getBook();
}
public Members getMember(){
return super.getMember();
}
public double PendingFine(){
return getFine();
}
public void printDetails(){
System.out.println("Transaction ID: " + transactionID);
System.out.println("Member: " + getMember().getName());
System.out.println("Book: " + getBook().getTitle());
System.out.println("Issue Date: " + getIssueDate());
System.out.println("Due Date: " + getDueDate());
System.out.println("Return Date: " + getReturnDate());
System.out.println("Fine: $" + PendingFine());
}
}
