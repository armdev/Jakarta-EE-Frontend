/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.javafrontend;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author armena
 */
@Named(value = "showInfoBean")
@ViewScoped
public class ShowInfoBean implements Serializable {

    private String message;

    /**
     * Creates a new instance of ShowInfoBean
     */
    public ShowInfoBean() {
    }

    public void doShowInfo() {
        message = "Secret information";

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
