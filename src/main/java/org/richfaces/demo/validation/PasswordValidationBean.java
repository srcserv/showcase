package org.richfaces.demo.validation;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

@ManagedBean
@SessionScoped
public class PasswordValidationBean implements Cloneable{
    @Size(min = 5, max = 15, message = "Wrong size for password")
    private String password="";
    @Size(min = 5, max = 15, message = "Wrong size for confirmation")
    private String confirm="";

    @AssertTrue(message = "Different passwords entered!")
    public boolean isPasswordsEquals() {
        return password.equals(confirm);
    }

    public void storeNewPassword() {
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Succesfully changed!", "Succesfully changed!"));
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirm() {
        return confirm;
    } 
}