package com.example.gestiondestocktubconcept.modele;

import android.util.Log;

import org.json.JSONArray;

public class AccesDistant implements AsyncResponse {
    private static final String SERVERADDR = "http://192.168.1.70/Test_Json/Requete_JSON.php"; //adresse http du serveur//

    public AccesDistant(){
        super();
    }


    // s'execute au retour du serveur distant//
    @Override
    public void processFinish(String output) {
        Log.d("serveur","*******************************************************"+output);
        //découpage du message recu
        String[] message = output.split("%");
        //dans message de [0]  sois : "enreg", "dernier", "Erreur"
        //dans message de [1] :reste du message

        //s'il y a 2 case
        if(message.length>1){
            if (message[0].equals("enreg")) {
                Log.d("enreg","*****************************"+message[1]);

            }else{
                if (message[0].equals("dernier")){
                    Log.d("dernier","*****************************"+message[1]);
                }else{
                    if (message [0].equals("Erreur")){
                        Log.d("Erreur","*****************************"+message[1]);
                }
            }
        }



    }
}


    public void envoi(String operation, JSONArray lesdonnesJSON){
        AccesHTTP accesDonnes = new AccesHTTP();
        //lien de delegation
        accesDonnes.delegate = this;
        //ajout parametres
        accesDonnes.addParam("operation",operation);
        accesDonnes.addParam("les donnees",lesdonnesJSON.toString());
        //appel au serveur
        accesDonnes.execute(SERVERADDR);

}

}
