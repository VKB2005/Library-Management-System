class Librarian extends BaseMember{
private String Id;
private String role;
private int yearsOfExperience;
private static int next=0; 

Librarian(String name,String contactInfo,int experience){
super(name, contactInfo);
this.role = "Senior";
this.yearsOfExperience = experience;
this.Id="ID-"+(next++);
}
Librarian(String name,String contactInfo){
super(name,contactInfo);
this.role = "Junior"; 
this.yearsOfExperience = 0; 
this.Id="ID-"+(next++);
}
public String getID(){
return Id;
}
public void getDetails(){
System.out.println("Name of librarian: " + getName() +", ID: " + getID() +", Contact: " + getContactInfo() +", Role: " + role +", Experience: " + yearsOfExperience + " years.");
}
public void updateExperience(int experience){
this.yearsOfExperience = experience;
System.out.println("Updated experience for " + getName() + ": " + yearsOfExperience + " years.");
}
}
