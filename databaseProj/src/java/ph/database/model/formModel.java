/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ph.database.model;

/**
 *
 * @author Xander
 */
public class formModel {
    private String username;
    private String email;
    private String password;
    
    
   public formModel(String username, String email, String password) {
                this.username = username;
        this.email = email;
        this.password = password;
    }

   

    
    public String getusername(){
        return username;
    }
    
    public void setusername(String username){
        this.username = username;
    }
    
    public String getemail(){
        return email;
    }
    
    public void setemail(String email){
        this.email = email;
    }
    
    public String getpassword(){
        return password;
    }
    
    public void setpassword(String password){
        this.password = password;
    }    
}
