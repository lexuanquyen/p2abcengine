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

package eu.abc4trust.cryptoEngine.idemix.util;

import org.w3c.dom.Element;

import com.ibm.zurich.idmx.showproof.Proof;

/**
 * A verifiable claim is a claim whose validity can be verified.
 * The validity is verified with respect to the technology-specific evidence.
 */
public interface VerifiableClaim extends Claim {

    /**
     * Verifies whether this claim is valid.
     * 
     */
    public boolean isValid();

    /**
     * Returns the evidence of this claim as String.
     * @return the evidence of this claim.
     */
    public String getEvidenceAsString();

    public void setEvidence(Proof proof);

    public Element getEvidenceAsElement();

}
