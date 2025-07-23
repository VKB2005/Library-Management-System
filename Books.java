class Books {
private String title;
private String author;
private String BN; 
private String genre;
private int publishedYear;
private boolean available;
private static int next = 0;

static String generateBN(){
return "BookNo_" + next++;
}
Books() {
this.title = "UNKNOWN";
this.author = "UNNAMED";
this.publishedYear = 2024;
this.genre = "General";
this.BN = generateBN();
this.available = true;
}
Books(String title) {
this.title = title;
this.author = "Babu";
this.publishedYear = 2024;
this.genre = "General";
this.BN = generateBN();
this.available = true;
}
Books(String title,String author){
this.title = title;
this.author = author;
this.publishedYear = 2024;
this.genre = "General";
this.BN = generateBN();
this.available = true;
}
Books(String title,String author,int publishedYear,String genre){
this.title = title;
this.author = author;
this.publishedYear = publishedYear;
this.genre = genre;
this.BN = generateBN();
this.available = true;
}
Books(int id,String title,String author,String genre,boolean available){
this.BN =generateBN() ;
this.title = title;
this.author = author;
this.genre = genre;
this.available = available;
}
public String getID(){
return this.BN;
}
public String getTitle(){
return title;
}
public String getAuthor(){
return author;
}
public String getGenre(){
return genre;
}
public int getYearPublished(){
return publishedYear;
}
public boolean isAvailable(){
return available;
}
public String bookDetails(){
return("Book ID: " + BN + ", Title: " + title + ", Author: " + author +", Genre: " + genre + ", Year Published: " + publishedYear + ", Availability: " + available);
}
public void borrowBook(){
available = false;
}
public void returnBook(){
available = true;
}
}
