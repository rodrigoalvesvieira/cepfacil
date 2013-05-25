/*
 * Copyright (c) 2013 Rodrigo Alves.
 * Licensed under the Eclipse Public License.
 * See the accompanying LICENSE file for terms.
 */

package cepfacil;

public class AddressNotFoundException extends Exception {
    private static final long serialVersionUID = -356392667447310893L;

    public AddressNotFoundException() {
        super("You either informed an invalid API token nonexistent zip code");
    }
}