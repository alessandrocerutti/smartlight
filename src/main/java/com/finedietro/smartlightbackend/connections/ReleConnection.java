package com.finedietro.smartlightbackend.connections;

import com.finedietro.smartlightbackend.model.Action;
import com.finedietro.smartlightbackend.model.Rele;

import java.net.HttpURLConnection;

import java.net.URL;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.client.Entity;

public class ReleConnection {

    private URL url;
    private HttpURLConnection connection;
    private Rele rele = new Rele();

    public Rele getReleStatus() {

        System.out.println("Sono in getReleStatus di ReleConnection");

        try {
            Client client = ClientBuilder.newClient();
            // In un oggetto WebTarget viene indicato il target della richiesta HTTP
            WebTarget target = client.target("http://192.168.0.194:8084/SmartLight/OutputState");
            //"http://********:****//SmartLight/OutputState"
            //http://localhost:8080/testwebapp/webapi/rele/001/status
            // Viene effettuata la richiesta la quale ritorna un JSON, successivamente viene convertito nella class Rele
            rele = target.request(MediaType.APPLICATION_JSON).get(Rele.class);
            System.out.println("Rele tornato: " + rele.getMessage() + " " + rele.getId());

            if (!rele.getStatusLampadina().equalsIgnoreCase("")) {
                rele.setStatus(rele.getStatusLampadina());
                if (!rele.getError().equalsIgnoreCase("")) {
                    rele.setStatus("ERROR");
                    rele.setMessage(rele.getError());
                }
            }

            System.out.println("Sono alla fine del try()");
        } catch (Exception error) {

            rele.setMessage(error.getMessage());
            rele.setStatus("ERROR");
            System.out.println("Eccezione : " + error);
        }

        return rele;

    }

    /* public Rele setReleStatus(Action action) {

        try {
            System.out.println("SONO in SetReleConnection");
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://192.168.0.194:8084/SmartLight/");
            //http://*******:8080/GestioneLuce/post"
            rele = target.request(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .post(Entity.json(action), Rele.class);

        } catch (Exception error) {

            rele.setMessage(error.getMessage());
            rele.setStatus("ERROR");
            System.out.println("SONO in SetReleConnection ERROR: " + rele.getId() + " " + rele.getStatus());
            return rele;
        }
        return rele;
    }*/
    public Rele setReleStatus(Action action) {
//PER SAMUELE
        try {
            Client client = ClientBuilder.newClient();
            // In un oggetto WebTarget viene indicato il target della richiesta HTTP
            WebTarget target = client.target("http://192.168.0.194:8084/SmartLight/switch");
            //"http://********:****//SmartLight/OutputState"
            //http://localhost:8080/testwebapp/webapi/rele/001/status
            // Viene effettuata la richiesta la quale ritorna un JSON, successivamente viene convertito nella class Rele
            rele = target.request(MediaType.APPLICATION_JSON).get(Rele.class);
            System.out.println("Rele tornato: " + rele.getMessage() + " " + rele.getId());

            
             if (!rele.getStatusLampadina().equalsIgnoreCase("")) {
                rele.setStatus(rele.getStatusLampadina());
                if (!rele.getError().equalsIgnoreCase("")) {
                    rele.setStatus("ERROR");
                    rele.setMessage(rele.getError());
                }
            }
        }
        
        catch (Exception error) {

            rele.setMessage(error.getMessage());
            rele.setStatus("ERROR");
            System.out.println("Eccezione : " + error);
        }
        return rele;

    }
}
