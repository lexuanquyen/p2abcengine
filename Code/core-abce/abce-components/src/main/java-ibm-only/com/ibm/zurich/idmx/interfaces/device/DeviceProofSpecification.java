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

// * Licensed Materials - Property of IBM *
// * com.ibm.zurich.idmx.2.3.40 *
// * (C) Copyright IBM Corp. 2013. All Rights Reserved. *
// * US Government Users Restricted Rights - Use, duplication or *
// * disclosure restricted by GSA ADP Schedule Contract with IBM Corp. *
// */**/****************************************************************
package com.ibm.zurich.idmx.interfaces.device;

import java.net.URI;

//TODO: Remove this file once the new crypto architecture is ready.

public interface DeviceProofSpecification {
  /**
   * Ask the secrets manager to perform a proof of possession of the device secret key and (if
   * applicable) the credential secret key in the credential public key of the given device.
   * PoK{(x,v): C = gd^x * gr^v (mod n)} or PoK{(x): C = gr^x (mod n)}.
   * 
   * @param deviceId
   * @param credentialUri
   */
  public void addCredentialProof(URI deviceId, URI credentialUri);

  /**
   * Ask the secrets manager to perform a proof of possession of the device secret key in the scope
   * exclusive pseudonym of the given scope on the given device. PoK{(x): P =
   * (hash(scope)^cofactor)^x (mod p)}
   * 
   * @param deviceId
   * @param scope
   */
  public void addScopeExclusivePseudonymProof(URI deviceId, URI scope);

  /**
   * Ask the secrets manager to perform a proof of possession of the device secret key in the device
   * public key of the given device. PoK{(x): D = g^x (mod p)}
   * 
   * @param deviceId
   */
  public void addPublicKeyProof(URI deviceId);
}
