import java.util.List;

public class Search{
private Library library;

public Search(Library library){
this.library = library;
}
public Books findBookByTitle(String title){
for(Books book : library.getLibraryBooks()){ 
if(book.getTitle().equalsIgnoreCase(title)){
return book;
}
}
return null;
}
public Members findMemberByName(String name){
for(Members member : library.getMembers()){ 
if(member.getName().equalsIgnoreCase(name)){
return member;
}
}
return null;
}
public void searchBookByTitle(String title){
Books book = findBookByTitle(title);
if(book != null){
System.out.println("Book found:");
book.bookDetails();
} 
else{
System.out.println("Book not found!");
}
}
public void searchMemberByName(String name){
Members member = findMemberByName(name);
if(member != null){
System.out.println("Member found:");
member.memberDetails();
} 
else{
System.out.println("Member not found!");
}
}
}
