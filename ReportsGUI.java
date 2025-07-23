import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

class ReportsGUI{
private JFrame reportsFrame;
private Library library;
private Settings settings;
private DefaultTableModel booksModel;
private DefaultTableModel membersModel;
private DefaultTableModel transactionsModel;

ReportsGUI(Library library,Settings settings) {
this.library = library;
this.settings=settings;
createReportsGUI();
}

private void createReportsGUI() {
reportsFrame = new JFrame("Library Reports");
reportsFrame.setSize(700, 500);
reportsFrame.setLayout(new BorderLayout(10, 10));
JTabbedPane tabbedPane = new JTabbedPane();
booksModel = new DefaultTableModel(new String[]{"Book ID", "Title", "Author", "Genre", "Availability"}, 0);
JPanel booksPanel = createPanelWithTable(booksModel);
tabbedPane.addTab("Books", booksPanel);
membersModel = new DefaultTableModel(new String[]{"Member ID", "Name", "Contact Info"}, 0);
JPanel membersPanel = createPanelWithTable(membersModel);
tabbedPane.addTab("Members", membersPanel);
transactionsModel = new DefaultTableModel(new String[]{"Transaction ID", "Book", "Member", "Issue Date", "Return Date", "Fine"}, 0);
JPanel transactionsPanel = createPanelWithTable(transactionsModel);
tabbedPane.addTab("Transactions", transactionsPanel);
JButton backButton = new JButton("Back");
backButton.addActionListener(e -> {
new AdminPanelGUI(library,settings);
reportsFrame.dispose();
});
reportsFrame.add(tabbedPane, BorderLayout.CENTER);
reportsFrame.add(backButton, BorderLayout.SOUTH);
refreshData(); 
reportsFrame.setVisible(true);
}

private JPanel createPanelWithTable(DefaultTableModel model) {
JTable table = new JTable(model);
JScrollPane scrollPane = new JScrollPane(table);
JPanel panel = new JPanel(new BorderLayout());
panel.add(scrollPane, BorderLayout.CENTER);
return panel;
}

public void refreshData() {
booksModel.setRowCount(0);
for(Books book : library.getLibraryBooks()){
booksModel.addRow(new Object[]{book.getID(), book.getTitle(), book.getAuthor(), book.getGenre(), book.isAvailable() ? "Available" : "Issued"});
}
membersModel.setRowCount(0);
for(Members member : library.getMembers()){
membersModel.addRow(new Object[]{member.getMemberId(), member.getName(), member.getContactInfo()});
}
transactionsModel.setRowCount(0);
for(Transaction transaction : library.getTransactions()){
transactionsModel.addRow(new Object[]{transaction.getTransactionID(), transaction.getBook().getTitle(), transaction.getMember().getName(), transaction.getIssueDate(),
transaction.getReturnDate(), transaction.getFine()});
}
}
public void showReports(){
reportsFrame.setVisible(true);
}
}
