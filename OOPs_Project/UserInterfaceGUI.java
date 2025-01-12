import javax.swing.*;
import java.awt.*;

class UserInterfaceGUI{
public UserInterfaceGUI(Library library,Search search,Settings settings){
JFrame userFrame = new JFrame("User Interface");
userFrame.setSize(400, 300);
userFrame.setLayout(new GridLayout(5, 1, 10, 10));

JButton searchBookButton = new JButton("Search Book");
JButton searchMemberButton = new JButton("Search Member");
JButton issueBookButton = new JButton("Borrow Book");
JButton returnBookButton = new JButton("Return Book");
JButton backButton = new JButton("Back");

searchBookButton.addActionListener(e->new SearchBookGUI(search));
searchMemberButton.addActionListener(e->new SearchMemberGUI(search));
issueBookButton.addActionListener(e->new IssueBookGUI(library, search));
returnBookButton.addActionListener(e->new ReturnBookGUI(library,search));
backButton.addActionListener(e->{
userFrame.dispose();
new MainMenu(library, settings, search);
});

userFrame.add(searchBookButton);
userFrame.add(searchMemberButton);
userFrame.add(issueBookButton);
userFrame.add(returnBookButton);
userFrame.add(backButton);
userFrame.setVisible(true);
}
}
