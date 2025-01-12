import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

class MainMenu{
private Library library;
private Settings settings;
private Search search;
private static HashMap<String, String> adminCredentials = new HashMap<>();
private static HashMap<String, String> userCredentials = new HashMap<>();

MainMenu(Library library,Settings settings,Search search){
this.library = library;
this.settings = settings;
this.search = search;
adminCredentials.put("admin", "admin123");
userCredentials.put("user", "user123");
launch();
}
public void launch(){
JFrame mainFrame = new JFrame("Library Management System");
mainFrame.setSize(400, 300);
mainFrame.setLayout(new GridLayout(4, 1, 10, 10));
mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JButton userButton = new JButton("User Interface");
JButton adminButton = new JButton("Admin Panel");
JButton createLoginButton = new JButton("Create New Login");
JButton exitButton = new JButton("Exit");

userButton.addActionListener(e->{
new UserLoginGUI(library, search,settings);
mainFrame.dispose();
});
adminButton.addActionListener(e->{
new AdminLoginGUI();
mainFrame.dispose();
});
createLoginButton.addActionListener(e->{
new CreateLoginGUI(this);
mainFrame.dispose();
});
exitButton.addActionListener(e->System.exit(0));

mainFrame.add(userButton);
mainFrame.add(adminButton);
mainFrame.add(createLoginButton);
mainFrame.add(exitButton);

applyStyling(mainFrame);
mainFrame.setVisible(true);
}
public static HashMap<String, String> getAdminCredentials(){
return adminCredentials;
}
public static HashMap<String, String> getUserCredentials(){
return userCredentials;
}
private void applyStyling(JFrame frame){
for(Component component : frame.getContentPane().getComponents()){
if (component instanceof JButton){
component.setFont(new Font("Arial", Font.BOLD, 14));
component.setBackground(new Color(173, 216, 230));
}
}
}
public Library getLibrary(){
return library;
}
public Settings getSettings(){
return settings;
}
public Search getSearch(){
return search;
}
}
