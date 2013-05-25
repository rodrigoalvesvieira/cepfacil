/*
 * Copyright (c) 2013 Rodrigo Alves.
 * Licensed under the Eclipse Public License.
 * See the accompanying LICENSE file for terms.
 */

package main;

import java.io.IOException;

import cepfacil.AddressNotFoundException;
import cepfacil.CepFacil;
import cepfacil.InvalidZipCodeException;

public class Program {

    public static void main(String[] args) throws IOException, InvalidZipCodeException, AddressNotFoundException {
        // zipCode, state, addressType, city, neighborhood, street, status
        String token = "0E2ACA03-FC7F-4E87-9046-A8C46637BA9D";
        CepFacil ruaCasa = new CepFacil("53416-540", token);

        CepFacil ufpe;

        try {
            ufpe = new CepFacil("53416-540", token);
        } catch (AddressNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(ruaCasa.getZipCode());
        System.out.println(ruaCasa.getStreet());

        System.out.println(ruaCasa.isValid());

        System.out.println(ruaCasa);

        CepFacil masp = new CepFacil("01310-200", token);
        System.out.println(masp); // AVENIDA PAULISTA, SÃO PAULO 01310-200 - SP, Brasil

        // Throws AddressNotFoundException because there is no such address
        // correspondent to the 00000-000 zip code in Brazil
        try {
            CepFacil infinitopolis = new CepFacil("00000-000", token);
        } catch (AddressNotFoundException e) {
            System.out.println("oops. Fail");
            e.printStackTrace();
        }
    }
}