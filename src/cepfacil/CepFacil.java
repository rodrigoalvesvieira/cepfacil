/*
 * Copyright (c) 2013 Rodrigo Alves Vieira.
 * Licensed under the Eclipse Public License.
 * See the accompanying LICENSE file for terms.
 */

package cepfacil;

import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CepFacil {
    public static final String VERSION = "0.0.1"; // Library version
    private String zipCode, apiKey, state, addressType, city, neighborhood, street, status = "";

    public CepFacil(String zipCode, String apiKey) throws IOException, InvalidZipCodeException {
        this.zipCode = zipCode;
        String line, result = "";

        try {
            URL apiUrl = new URL("http://www.cepfacil.com.br/service/?filiacao=" + apiKey + "&cep=" + 
                    CepFacil.parseZipCode(zipCode) + "&formato=texto");

            BufferedReader in = new BufferedReader(new InputStreamReader(apiUrl.openStream()));

            /*
             * Reads line by line of the response text and attaches it to the
             * result String, to be parsed later in this constructor method
             */
            while ((line = in.readLine()) != null) {
                result += line;
            }
            in.close();

            this.status = result.split("=")[1].split("&")[0]; // status

            /* Set all attributes as null if either the informed zipCode
             * or apiKey is wrong
             */
            if (this.status.equals("nao-encontrado")) {
                this.addressType = null;
                this.state = null;
                this.city = null;
                this.neighborhood = null;
                this.street = null;
            } else {
                /*
                 * Breaks the response text into pieces and set each piece as the right
                 * object attribute
                 */
                this.status = result.split("=")[1].split("&")[0]; // status
                this.addressType = result.split("=")[3].split("&")[0]; // type of the way
                this.state = result.split("=")[4].split("&")[0]; // state
                this.city = result.split("=")[5].split("&")[0]; // city
                this.neighborhood = result.split("=")[6].split("&")[0]; // neighborhood
                this.street = result.split("=")[7].split("&")[0]; // name of the way
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    static String parseZipCode(String zipCode) throws InvalidZipCodeException {
        /*
         * This method parses the user informed zip code into a String object that contains
         * no dashes so the webservice can find it. So, for example, 55555-555 becomes 55555555.
         * @param zipCode the zipCode from which you want to extract an address
         * @return the zip code String without the dash
         */
        String parsedZipCode = zipCode.replaceAll("[^0-9]+", "");
        
        if (parsedZipCode.length() != 8) {
            throw new InvalidZipCodeException();
        }
        
        return parsedZipCode;
    }

    public boolean isValid() {
        /*
         * @return true if the informed zip code corresponds to an actual address. Returns false otherwise.
         */
        return this.status.equals("encontrado");
    }

    public String fullAddress() {
        /*
         * Returns the String object for a full description of the address, containing
         * exactly the address type (street/avenue/lane), street name, neighborhood, city
         * zip code, state and country name (Brazil only, of course).
         */
        return this.addressType + " " + this.street + ", " + this.neighborhood + ", " + this.city + " "
        + this.zipCode + " - " + this.state + ", Brasil";   
    }

    @Override
    public String toString() {
        return this.addressType + " " + this.street + ", " + this.city + " " + this.zipCode + " - " + 
                this.state + ", Brasil";   
    }

    /*
     * Getter methods come right below
     */
    public String getAPiKey() {
        return this.apiKey;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public String getState() {
        return this.state;
    }

    public String getAddressType() {
        return this.addressType;
    }

    public String getCity() {
        return this.city;
    }

    public String getNeighborhood() {
        return this.neighborhood;
    }

    public String getStreet() {
        return this.street;
    }

    public String getStatus() {
        return this.status;
    }
}