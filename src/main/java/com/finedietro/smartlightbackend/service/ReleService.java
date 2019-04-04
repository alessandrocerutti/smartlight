package com.finedietro.smartlightbackend.service;

import com.finedietro.smartlightbackend.connections.ReleConnection;
import com.finedietro.smartlightbackend.model.Action;
import com.finedietro.smartlightbackend.model.Rele;

public class ReleService {

    private Rele rele;
    private static String STATUS_ON = "ON";
    private static String STATUS_OFF = "OFF";

    private static String STATUS_ERROR = "ERROR";
    private static String ACTION_ACCENDI = "ACCESO";
    private static String ACTION_SPEGNI = "SPENTO";

    ReleConnection rl = new ReleConnection();

    public ReleService(String id) {

        rele = new Rele(id);

    }

    public ReleService() {
    }

    public Rele getReleStatus(String id) {

        // viene chiamato il rele fisico facendo le relative chiamate http per ottenere lo stato dell'interruttore
        try {
            rele = rl.getReleStatus();

        } catch (Exception e) {
            rele.setStatus(STATUS_ERROR);
            rele.setMessage(e.getMessage());

        }
        return rele;

    }

    public Rele setReleStatus(Action action) {
        try {
            rele = rl.setReleStatus(action);
        } catch (Exception e) {
            rele.setStatus(STATUS_ERROR);
            rele.setMessage(e.getMessage());
        }
        return rele;
    }

}
