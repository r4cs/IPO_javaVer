package com.PlayerDataBD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BuscarCep {

    public BuscarCep(){};

    public static String buscarCep(String cep) throws IOException {
        URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

//        System.out.println(response.toString());
        return response.toString();
    }


    public static void setValue(String key, String value) {
        System.out.println(key + ": " + value);
    }

    public static void setFocus(String field) {
        System.out.println("Campo focado: " + field);
    }

}
