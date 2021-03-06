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

package eu.abc4trust.cryptoEngine.verifier;

import eu.abc4trust.cryptoEngine.CryptoEngineException;
import eu.abc4trust.exceptions.TokenVerificationException;
import eu.abc4trust.xml.PresentationToken;

public interface CryptoEngineVerifier {
    /**
     * This method verifies that the cryptographic evidence in the given
     * presentation token t supports the description of t. If the evidence is
     * deemed valid, this method returns true, and a list of error messages
     * otherwise. In order to verify the token, this method may call upon the
     * KeyManager to obtain Issuer parameters, Inspector public keys, Revocation
     * Authority parameters, and the current revocation information by invoking
     * the methods KeyManager.getIssuerParameters(issuid),
     * KeyManager.getInspectorPublicKey(ipkuid),
     * KeyManager.getRevocationAuthorityParameters(rapuid), and
     * KeyMangaer.getCurrentRevocationInformation(rapuid).
     * 
     * @param t
     * @return
     * @throws TokenVerificationException
     *             A list of verification errors.
     * @throws CryptoEngineException
     */
    public boolean verifyToken(PresentationToken t)
            throws TokenVerificationException, CryptoEngineException;
}
