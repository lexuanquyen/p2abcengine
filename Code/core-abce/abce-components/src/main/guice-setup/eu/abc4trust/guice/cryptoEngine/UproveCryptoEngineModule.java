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

package eu.abc4trust.guice.cryptoEngine;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

import eu.abc4trust.cryptoEngine.inspector.CryptoEngineInspector;
import eu.abc4trust.cryptoEngine.inspector.CryptoEngineInspectorImpl;
import eu.abc4trust.cryptoEngine.issuer.CryptoEngineIssuer;
import eu.abc4trust.cryptoEngine.issuer.CryptoEngineReIssuer;
import eu.abc4trust.cryptoEngine.revauth.AccumCryptoEngineRevAuthImpl;
import eu.abc4trust.cryptoEngine.revocation.CryptoEngineRevocation;
import eu.abc4trust.cryptoEngine.uprove.issuer.UProveCryptoEngineIssuerImpl;
import eu.abc4trust.cryptoEngine.uprove.issuer.UProveCryptoEngineReIssuerImpl;
import eu.abc4trust.cryptoEngine.uprove.user.UProveCryptoEngineUserImpl;
import eu.abc4trust.cryptoEngine.uprove.util.UProveBindingManager;
import eu.abc4trust.cryptoEngine.uprove.util.UProveLauncher;
import eu.abc4trust.cryptoEngine.uprove.verifier.UProveCryptoEngineVerifierImpl;
import eu.abc4trust.cryptoEngine.user.CryptoEngineUser;
import eu.abc4trust.cryptoEngine.verifier.CryptoEngineVerifier;

public class UproveCryptoEngineModule extends AbstractModule {

  @Override
  protected void configure() {
    this.bind(CryptoEngineIssuer.class).to(UProveCryptoEngineIssuerImpl.class).in(Singleton.class);
    this.bind(CryptoEngineReIssuer.class).to(UProveCryptoEngineReIssuerImpl.class).in(Singleton.class);
    this.bind(CryptoEngineVerifier.class).to(UProveCryptoEngineVerifierImpl.class).in(Singleton.class);
    this.bind(CryptoEngineUser.class).to(UProveCryptoEngineUserImpl.class).in(Singleton.class);
    this.bind(CryptoEngineInspector.class).to(CryptoEngineInspectorImpl.class).in(Singleton.class);
    this.bind(CryptoEngineRevocation.class).to(AccumCryptoEngineRevAuthImpl.class).in(Singleton.class);
    
    this.bind(UProveBindingManager.class).in(Singleton.class);
    this.bind(UProveLauncher.class).in(Singleton.class);
  }

}
