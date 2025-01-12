import java.util.ArrayList;
class Main{
public static void main(String[] args){
Library library = new Library();  
Settings settings = new Settings("City Library", "123 Main St", "contact@citylibrary.com", 1.5);
Search search = new Search(library);
     
ArrayList<Books> books = new ArrayList<>();
ArrayList<Members> members = new ArrayList<>();

for(Books book : books){
library.addBook(book);
}
for(Members member : members){
library.registerMember(member); 
}

System.out.println("Library Books: " + library.getLibraryBooks().size());
System.out.println("Library Members: " + library.getMembers().size());
System.out.println("Library Transactions: " + library.getTransactions().size());
        
new MainMenu(library, settings, search);
}
}

