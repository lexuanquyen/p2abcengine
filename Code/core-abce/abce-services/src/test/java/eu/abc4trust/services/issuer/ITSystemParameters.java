//* Licensed Materials - Property of IBM, Miracle A/S, and            *
//* Alexandra Instituttet A/S                                         *
//* eu.abc4trust.pabce.1.0                                            *
//* (C) Copyright IBM Corp. 2012. All Rights Reserved.                *
//* (C) Copyright Miracle A/S, Denmark. 2012. All Rights Reserved.    *
//* (C) Copyright Alexandra Instituttet A/S, Denmark. 2012. All       *
//* Rights Reserved.                                                  *
//* US Government Users Restricted Rights - Use, duplication or       *
//* disclosure restricted by GSA ADP Schedule Contract with IBM Corp. *
//*                                                                   *
//* This file is licensed under the Apache License, Version 2.0 (the  *
//* "License"); you may not use this file except in compliance with   *
//* the License. You may obtain a copy of the License at:             *
//*   http://www.apache.org/licenses/LICENSE-2.0                      *
//* Unless required by applicable law or agreed to in writing,        *
//* software distributed under the License is distributed on an       *
//* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY            *
//* KIND, either express or implied.  See the License for the         *
//* specific language governing permissions and limitations           *
//* under the License.                                                *
//*/**/****************************************************************

package eu.abc4trust.services.issuer;

import static org.junit.Assert.assertNotNull;

import java.net.URI;

import org.junit.Ignore;
import org.junit.Test;

import eu.abc4trust.services.ITAbstract;
import eu.abc4trust.xml.ObjectFactory;
import eu.abc4trust.xml.SystemParameters;

public class ITSystemParameters extends ITAbstract {

    static ObjectFactory of = new ObjectFactory();


    final String baseUrl = "http://localhost:9500/abce-services/issuer";

    @Test
    public void setupSystemParametersIdemix() throws Exception {
        IssuerServiceFactory issuerServiceFactory = new IssuerServiceFactory();
        SystemParameters systemParameters = issuerServiceFactory
                .getSystemParameters(80,
                        URI.create("urn:abc4trust:1.0:algorithm:idemix"));

        assertNotNull(systemParameters);
    }

    @Test
    public void setupSystemParametersUProve() throws Exception {
        IssuerServiceFactory issuerServiceFactory = new IssuerServiceFactory();
        SystemParameters systemParameters = issuerServiceFactory
                .getSystemParameters(80,
                        URI.create("urn:abc4trust:1.0:algorithm:uprove"));

        assertNotNull(systemParameters);
    }

    @Ignore
    @Test
    public void setupSystemParametersBridged() throws Exception {
        IssuerServiceFactory issuerServiceFactory = new IssuerServiceFactory();
        SystemParameters systemParameters = issuerServiceFactory
                .getSystemParameters(80,
                        URI.create("urn:abc4trust:1.0:algorithm:bridged"));

        assertNotNull(systemParameters);
    }

    @Ignore
    @Test
    public void setupSystemParametersBridgedWithIdemix() throws Exception {
        IssuerServiceFactory issuerServiceFactory = new IssuerServiceFactory();
        SystemParameters systemParameters = issuerServiceFactory
                .getSystemParameters(
                        80,
                        URI.create("urn:abc4trust:1.0:algorithm:bridged:idemix:issuer"));

        assertNotNull(systemParameters);
    }

    @Ignore
    @Test
    public void setupSystemParametersBridgedWithUProve() throws Exception {
        IssuerServiceFactory issuerServiceFactory = new IssuerServiceFactory();
        SystemParameters systemParameters = issuerServiceFactory
                .getSystemParameters(
                        80,
                        URI.create("urn:abc4trust:1.0:algorithm:bridged:uprove:issuer"));

        assertNotNull(systemParameters);
    }


}
