class Statistics{
private Library library;

Statistics(Library library){
this.library = library;
}
public void generateStatistics(){
System.out.println("Library Usage Statistics:");
System.out.println("Total number of books: " + library.getTotalBooks());
System.out.println("Total number of members: " + library.getMembers().size());
int booksBorrowed = 0;
for(Members member : library.getMembers()){
booksBorrowed += member.getBorrowedBooks().size();
}
System.out.println("Total books currently borrowed: " + booksBorrowed);
}
}
