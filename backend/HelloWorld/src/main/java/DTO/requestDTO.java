package DTO;

public class requestDTO {

    private String FirsTname;
    private String LastName;
    private String email;
    
    
    public requestDTO() {
    }

    public requestDTO(String firsTname, String lastName, String email) {
        FirsTname = firsTname;
        LastName = lastName;
        this.email = email;
    }
    
    public String getFirsTname() {
        return FirsTname;
    }
    public void setFirsTname(String firsTname) {
        FirsTname = firsTname;
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
   


}
