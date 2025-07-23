interface LibraryOperations{
void addBook(Books book);
void removeBook(String bookID);
void listAllBooks();
void registerMember(Members member);
void removeMember(String memberID);
void listAllMembers();
void addLibrarian(Librarian librarian);
void removeLibrarian(String librarianID);
void issueBook(Members member, Books book);
void returnBook(Members member, Books book, int overdueDays);
void generateLibraryReport();
}
