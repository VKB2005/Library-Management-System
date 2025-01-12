import java.time.LocalDate;

class BaseTransaction{
private Members member;   
private Books book;
private LocalDate issueDate;
private LocalDate dueDate;
private LocalDate returnDate;
private double fine;

BaseTransaction(Members member,Books book,LocalDate issueDate,LocalDate dueDate,double fine){
this.member = member;
this.book = book;
this.issueDate = issueDate;
this.dueDate = dueDate;
this.returnDate = null;
this.fine = fine;
}
public Members getMember(){
return member;
}
public Books getBook(){
return book;
}
public LocalDate getIssueDate(){
return issueDate;
}
public LocalDate getDueDate(){
return dueDate;
}
public LocalDate getReturnDate(){
return returnDate;
}
public double getFine(){
return fine;
}
public void completeTransaction(LocalDate returnDate){
this.returnDate = returnDate;
int overdueDays = (int) java.time.temporal.ChronoUnit.DAYS.between(dueDate, returnDate);
this.fine = overdueDays > 0 ? overdueDays * 1.0 : 0.0;
}
}
