import javax.swing.*;
import java.awt.*;

class UserLoginGUI{
public UserLoginGUI(Library library, Search search, Settings settings){
JFrame loginFrame = new JFrame("User Login");
loginFrame.setSize(300, 200);
loginFrame.setLayout(new GridLayout(3, 2, 10, 10));

JLabel userLabel = new JLabel("Username:");
JLabel passLabel = new JLabel("Password:");
JTextField userField = new JTextField();
JPasswordField passField = new JPasswordField();
JButton loginButton = new JButton("Login");
JButton backButton = new JButton("Back");

loginButton.addActionListener(e->{
String username = userField.getText();
String password = new String(passField.getPassword());
if(MainMenu.getUserCredentials().containsKey(username) && MainMenu.getUserCredentials().get(username).equals(password)){
new UserInterfaceGUI(library, search, settings);
loginFrame.dispose();
} 
else{
JOptionPane.showMessageDialog(loginFrame, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
}
});
backButton.addActionListener(e->{
loginFrame.dispose();
new MainMenu(library, settings, search);
});

loginFrame.add(userLabel);
loginFrame.add(userField);
loginFrame.add(passLabel);
loginFrame.add(passField);
loginFrame.add(loginButton);
loginFrame.add(backButton);
loginFrame.setVisible(true);
}
}
