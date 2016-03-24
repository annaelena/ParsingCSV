package com.mariana.projectcsv;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main();
    }

    public void main() {
        int numeroriga = 0;
        try{
            //FileReader fr = new FileReader("attivita_comm_media_grande_distrib.csv");

            InputStream ins = getResources().openRawResource(
                    getResources().getIdentifier("attivita_comm",
                            "raw", getPackageName()));
            BufferedReader br = new BufferedReader(new InputStreamReader(ins));

            String str = null;

            Map<Address, List<Integer>> indirizzi = new HashMap<>();
            br.readLine(); // salto la prima riga di intestazione

            while((str = br.readLine()) != null){
                numeroriga++;
                String[] items = str.split(";");
                if(items.length < 19){
                    continue;
                }

                Address a = new Address();

                a.setId(items[0]);
                a.setTipoVia(items[3]);
                a.setIndirizzo(items[4]);
                a.setNumCivico(items[5]);
                a.setCitta("Milano");

                int id = Integer.parseInt(items[0]);

                if(indirizzi.containsKey(a)){
                    List<Integer> myList = indirizzi.get(a);
                    myList.add(id);
                } else {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(id);
                    indirizzi.put(a, ids);
                }

            }

            for(Address s: indirizzi.keySet()) {
                System.out.println(s);
            }

			/*GeoApiContext context = new GeoApiContext().setApiKey(args[0]);
			GeocodingResult[] results =  GeocodingApi.geocode(context, indirizzi.get(100)).await();*/




        } catch(Exception e) {
            System.out.println("errore al numero di riga " + numeroriga);
            e.printStackTrace();
        }




    }

}
