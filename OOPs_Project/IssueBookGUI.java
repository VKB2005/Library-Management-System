import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class IssueBookGUI{
public IssueBookGUI(Library library,Search search){
JFrame issueFrame = new JFrame("Issue Book");
issueFrame.setSize(400, 300);
issueFrame.setLayout(new GridLayout(4, 2, 10, 10));

JLabel memberLabel = new JLabel("Enter Member Name:");
JTextField memberField = new JTextField();
JLabel bookLabel = new JLabel("Enter Book Title:");
JTextField bookField = new JTextField();
JButton issueButton = new JButton("Issue Book");
JButton backButton = new JButton("Back");

JTextArea resultArea = new JTextArea();
resultArea.setEditable(false);

issueButton.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
String memberName = memberField.getText();
String bookTitle = bookField.getText();

Members member = search.findMemberByName(memberName);
Books book = search.findBookByTitle(bookTitle);
if(member != null && book != null){
if(book.isAvailable()){
library.issueBook(member,book);
resultArea.setText("Book issued successfully:\n" +"Book: " + book.getTitle() + "\n" +"Member: " + member.getName());
} 
else{
resultArea.setText("Book is already issued!");
}
}else{
resultArea.setText("Invalid member or book details.");
}
}
});
backButton.addActionListener(e->issueFrame.dispose());
issueFrame.add(memberLabel);
issueFrame.add(memberField);
issueFrame.add(bookLabel);
issueFrame.add(bookField);
issueFrame.add(issueButton);
issueFrame.add(backButton);
issueFrame.add(new JScrollPane(resultArea));
issueFrame.setVisible(true);
}
}
