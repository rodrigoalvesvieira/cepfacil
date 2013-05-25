/*
 * Copyright (c) 2013 Rodrigo Alves.
 * Licensed under the Eclipse Public License.
 * See the accompanying LICENSE file for terms.
 */

package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import cepfacil.CepFacil;
import cepfacil.InvalidZipCodeException;

@RunWith(JUnit4.class)
public class CepFacilTest {
    @Test
    public void testZipCodeFormat() throws InvalidZipCodeException {
      String zipCode = "53416-540";
      assertEquals("53416540", CepFacil.parseZipCode(zipCode));
    }

}
