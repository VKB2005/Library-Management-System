import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ReturnBookGUI{
public ReturnBookGUI(Library library,Search search){
JFrame returnFrame = new JFrame("Return Book");
returnFrame.setSize(400, 300);
returnFrame.setLayout(new GridLayout(5, 2, 10, 10));

JLabel memberLabel = new JLabel("Enter Member Name:");
JTextField memberField = new JTextField();
JLabel bookLabel = new JLabel("Enter Book Title:");
JTextField bookField = new JTextField();
JLabel overdueLabel = new JLabel("Enter Overdue Days:");
JTextField overdueField = new JTextField();
JButton returnButton = new JButton("Return Book");
JButton backButton = new JButton("Back");

JTextArea resultArea = new JTextArea();
resultArea.setEditable(false);
returnButton.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e) {
String memberName = memberField.getText();
String bookTitle = bookField.getText();
int overdueDays;
try{
overdueDays = Integer.parseInt(overdueField.getText());
}catch(NumberFormatException ex){
resultArea.setText("Invalid input for overdue days.");
return;
}
Members member = search.findMemberByName(memberName);
Books book = search.findBookByTitle(bookTitle);
library.setFineCalculator(new StandardFineCalculator()); 
double fine = library.calculateFine(overdueDays); 
if(member != null && book != null){
if(member.getBorrowedBooks().contains(book)){
library.returnBook(member, book, overdueDays);
resultArea.setText("Book returned successfully:\n" +"Book: " + book.getTitle() + "\n" +"Member: " + member.getName() + "\n" +"Fine: $" + fine);
} 
else{
resultArea.setText("This book was not borrowed by the member.");
}
}
else{
resultArea.setText("Invalid member or book details.");
}
}
});
backButton.addActionListener(e -> returnFrame.dispose());

returnFrame.add(memberLabel);
returnFrame.add(memberField);
returnFrame.add(bookLabel);
returnFrame.add(bookField);
returnFrame.add(overdueLabel);
returnFrame.add(overdueField);
returnFrame.add(returnButton);
returnFrame.add(backButton);
returnFrame.add(new JScrollPane(resultArea));

returnFrame.setVisible(true);
}
}
