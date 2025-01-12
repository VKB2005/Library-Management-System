class Settings{
private static Settings instance;
private String libraryName;
private String address;
private String contactInfo;
private double fineRate;

Settings(String libraryName,String address,String contactInfo,double fineRate){
this.libraryName = libraryName;
this.address = address;
this.contactInfo = contactInfo;
this.fineRate = fineRate;
}
Settings(String libraryName,String address,double fineRate){
this.libraryName = libraryName;
this.address = address;
this.contactInfo = "Not Provided";
this.fineRate = fineRate;
}
private Settings(){
this.libraryName = "Mahindra University";
this.address = "Bahadurpally,Hyderabad";
this.contactInfo = "mahindrauniversity@gmail.com";
this.fineRate = 1.0;
}
public static Settings getInstance(){
if(instance == null){
instance = new Settings();
}
return instance;
}
public String getLibraryName(){
return libraryName;
}
public String getAddress(){
return address;
}
public String getContactInfo(){
return contactInfo;
}
public double getFineRate(){
return fineRate;
}
public void setLibraryName(String libraryName){
this.libraryName = libraryName;
}
public void setAddress(String address){
this.address = address;
}
public void setContactInfo(String contactInfo){
this.contactInfo = contactInfo;
}
public void setFineRate(double fineRate){
this.fineRate = fineRate;
}
public String displaySettings(){
return("Library Name: " + libraryName + ", Address: " + address +", Contact Info: " + contactInfo + ", Fine Rate: $" + fineRate + " per day");
}
}
