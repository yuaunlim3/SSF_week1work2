package vttp.ssf.week1Work.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Info {

    @NotEmpty(message = "Name cannot be empty")
    @Size(min =2, max=32, message ="Task must between 2 to 32 characters")
    private String name;


    @NotEmpty(message = "Password cannot be empty")
    private String password;

    private Integer caption;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer  getCaption() {
        return caption;
    }
    public void setCaption(Integer caption) {
        this.caption = caption;
    }
    @Override
    public String toString() {
        return "InfoCap [name=" + name + ", password=" + password + ", caption=" + caption + "]";
    }

    

    
    
}
