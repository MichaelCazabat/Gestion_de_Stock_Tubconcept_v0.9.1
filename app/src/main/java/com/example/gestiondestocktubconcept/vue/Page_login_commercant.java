package com.example.gestiondestocktubconcept.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gestiondestocktubconcept.R;
import com.example.gestiondestocktubconcept.controleur.Controle;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Page_login_commercant extends AppCompatActivity {

        String test = "2001";
        private Controle controle;

        @Override
        protected void onCreate(Bundle savedInstanceState) {            // au lancement de l'application, ce qu'il y a dans les crochets va s'executer.
                super.onCreate(savedInstanceState);
                setContentView(R.layout.connexion_commercant);
                this.controle = controle.getInstance();

                /* ++propriétées++ */
                EditText txt_id_commercant = findViewById(R.id.txt_id_commercant);
                EditText mdp_commercant = findViewById(R.id.mdp_commercant);
                Button btn_connexion_commercant = (Button) findViewById(R.id.btn_connexion_commercant);

                /* --propriétées-- */


                btn_connexion_commercant.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                                if (mdp_commercant.getText().toString().equals("azerty") && txt_id_commercant.getText().toString().equals("tubconcept")) {
                                        Intent l = new Intent(Page_login_commercant.this, liste_produits.class);
                                        startActivity(l);
                                }else{
                                        Toast.makeText(Page_login_commercant.this, "Vos identifiants sonts incorrects", Toast.LENGTH_LONG).show();

                                }

                        }
                });



        }



        // partie qui convert les string en hashing sha1
        String sha1Hash( String toHash )
        {
                String hash = null;
                try
                {
                        MessageDigest digest = MessageDigest.getInstance( "SHA-1" );
                        byte[] bytes = toHash.getBytes("UTF-8");
                        digest.update(bytes, 0, bytes.length);
                        bytes = digest.digest();

                        // This is ~55x faster than looping and String.formating()
                        hash = bytesToHex( bytes );
                }
                catch( NoSuchAlgorithmException e )
                {
                        e.printStackTrace();
                }
                catch( UnsupportedEncodingException e )
                {
                        e.printStackTrace();
                }
                return hash;
        }

        // http://stackoverflow.com/questions/9655181/convert-from-byte-array-to-hex-string-in-java
        final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
        public static String bytesToHex( byte[] bytes )
        {
                char[] hexChars = new char[ bytes.length * 2 ];
                for( int j = 0; j < bytes.length; j++ )
                {
                        int v = bytes[ j ] & 0xFF;
                        hexChars[ j * 2 ] = hexArray[ v >>> 4 ];
                        hexChars[ j * 2 + 1 ] = hexArray[ v & 0x0F ];
                }
                return new String( hexChars );
        }



}