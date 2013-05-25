/*
 * Copyright (c) 2013 Rodrigo Alves.
 * Licensed under the Eclipse Public License.
 * See the accompanying LICENSE file for terms.
 */

package cepfacil;

public class InvalidZipCodeException extends Exception {
    private static final long serialVersionUID = -356392667447310493L;

    public InvalidZipCodeException(String zipCode) {
        super("The informed zip code is invalid: " + zipCode + ".\n" +
        		"A valid Brazilian zip code contains 8 numeric characters\n");
    }
}