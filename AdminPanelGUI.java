import javax.swing.*;
import java.awt.*;

class AdminPanelGUI{
private Library library;
private Settings settings;
private ReportsGUI reportsGUI; 

AdminPanelGUI(Library library,Settings settings){
if (settings == null){
throw new IllegalArgumentException("Settings object cannot be null");
}
this.library = library;
this.settings = settings;
this.reportsGUI = null;
createAdminPanel();
}
private void createAdminPanel(){
JFrame adminFrame = new JFrame("Admin Panel");
adminFrame.setSize(400, 500);
adminFrame.setLayout(new GridLayout(7, 1, 10, 10)); 

JButton addBookButton = new JButton("Add Book");
JButton removeBookButton = new JButton("Remove Book");
JButton addMemberButton = new JButton("Add Member");
JButton removeMemberButton = new JButton("Remove Member");
JButton reportsButton = new JButton("Reports");
JButton settingsButton = new JButton("Settings");
JButton backButton = new JButton("Back");

addBookButton.addActionListener(e->new AddBookGUI(library));
removeBookButton.addActionListener(e->new RemoveBookGUI(library));
addMemberButton.addActionListener(e->new AddMemberGUI(library));
removeMemberButton.addActionListener(e->new RemoveMemberGUI(library));
reportsButton.addActionListener(e->new ReportsGUI(library,settings));
settingsButton.addActionListener(e->new SettingsGUI(settings));
backButton.addActionListener(e->{
new MainMenu(library, settings, new Search(library));
adminFrame.dispose(); 
});

adminFrame.add(addBookButton);
adminFrame.add(removeBookButton);
adminFrame.add(addMemberButton);
adminFrame.add(removeMemberButton);
adminFrame.add(reportsButton);
adminFrame.add(settingsButton);
adminFrame.add(backButton);
adminFrame.setVisible(true);
}
}
