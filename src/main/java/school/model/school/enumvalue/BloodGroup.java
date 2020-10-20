package school.model.school.enumvalue;

public enum BloodGroup {
     
	 O_Posetive("(O+)"),
	 B_Posetive("(B+)"),
	 A_Posetive("(A+)"),
	 AB_Posetive("(AB+)"),
     O_Negetive("(O-)"),
     A_Negetive("(A-)"),
     B_Negetive("(B-)"),
     AB_Negetive("(AB-)");
	 private String value;
     private BloodGroup(String value)
     {
        this.value = value;
     }

     public String toString()
     {
        return this.value; //will return , or ' instead of COMMA or APOSTROPHE
     }
}
