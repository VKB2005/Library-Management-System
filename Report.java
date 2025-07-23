import java.time.LocalDate;
import java.util.List;

class Report{
private List<Books> libraryBooks;
private List<Members> membersList;
private LocalDate reportDate;

Report(List<Books> libraryBooks,List<Members> membersList){
this.libraryBooks = libraryBooks;
this.membersList = membersList;
this.reportDate = LocalDate.now();
}
public void generateBookReport(){
System.out.println("Library Book Report");
System.out.println("Total Books: " + libraryBooks.size());
for(Books book : libraryBooks){
System.out.println("ID: " + book.getID() + ", Title: " + book.getTitle() +", Author: " + book.getAuthor() +", Published Year: " + book.getYearPublished());
}
}
public void generateMemberReport(){
if(membersList == null || membersList.isEmpty()){
System.out.println("No members found.");
return;
}
System.out.println("\nLibrary Member Report");
System.out.println("===========================");
System.out.println("Report Date: " + reportDate);
System.out.println("===========================");
for (Members member : membersList) {
System.out.println("- " + member.getName() + ", Email: " + member.getContactInfo());
}
}
public void generateTransactionReport(List<Transaction> transactions){
System.out.println("\nTransaction Report");
System.out.println("===========================");
System.out.println("Report Date: " + reportDate);
System.out.println("===========================");
for(Transaction transaction : transactions){
transaction.printDetails();
}
}
}
