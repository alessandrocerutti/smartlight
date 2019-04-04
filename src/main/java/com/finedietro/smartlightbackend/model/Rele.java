package com.finedietro.smartlightbackend.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Rele {

    private String id;
    private String status;
    private String message;
    private String statusLampadina ="";
    private String error = "";

    public String getStatusLampadina() {
        return statusLampadina;
    }

    public void setStatusLampadina(String statusLampadina) {
        this.statusLampadina = statusLampadina;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    

    public Rele(String idBulb) {
        this.id = idBulb;
    }

    public Rele() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
