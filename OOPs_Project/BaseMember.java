class BaseMember{
protected String name;
protected String contactInfo;

BaseMember(String name,String contactInfo){
this.name = name;
this.contactInfo = contactInfo;
}
public String getName(){ 
return name; 
}
public String getContactInfo(){ 
return contactInfo; 
}
public void updateContactInfo(String newContactInfo){
this.contactInfo = newContactInfo;
}
}
