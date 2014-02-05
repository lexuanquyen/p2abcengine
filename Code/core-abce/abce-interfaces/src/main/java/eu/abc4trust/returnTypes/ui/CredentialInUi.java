//* Licensed Materials - Property of IBM                              *
//* eu.abc4trust.pabce.1.0                                            *
//* (C) Copyright IBM Corp. 2012. All Rights Reserved.                *
//* US Government Users Restricted Rights - Use, duplication or       *
//* disclosure restricted by GSA ADP Schedule Contract with IBM Corp. *
//*/**/****************************************************************

package eu.abc4trust.returnTypes.ui;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.abc4trust.returnTypes.ui.adapters.CredentialSpecAdapter;
import eu.abc4trust.returnTypes.ui.adapters.IssuerAdapter;
import eu.abc4trust.returnTypes.ui.adapters.RevocationAuthorityAdapter;
import eu.abc4trust.xml.CredentialDescription;
import eu.abc4trust.xml.CredentialSpecification;
import eu.abc4trust.xml.IssuerParameters;
import eu.abc4trust.xml.RevocationAuthorityParameters;

@XmlType(namespace = "http://abc4trust.eu/wp2/abcschemav1.0")
public class CredentialInUi {
  @XmlID
  @XmlAttribute
  public String uri;
  
  @XmlElement
  public CredentialDescription desc;
  
  /*@XmlElementWrapper
  @XmlElement(name = "ownershipInfo")
  public List<FriendlyDescription> ownershipInfos;
  
  @XmlElementWrapper
  @XmlElement(name = "validityInfo")
  public List<FriendlyDescription> validityInfos;*/
  
  @XmlElement
  @XmlJavaTypeAdapter(RevocationAuthorityAdapter.class)
  public RevocationAuthorityInUi revocationAuthority;
  
  @XmlElement
  @XmlJavaTypeAdapter(CredentialSpecAdapter.class)
  public CredentialSpecInUi spec;
  
  @XmlElement
  @XmlJavaTypeAdapter(IssuerAdapter.class)
  public IssuerInUi issuer;
  
  
  public CredentialInUi() {
    //this.ownershipInfos = new ArrayList<FriendlyDescription>();
    //this.validityInfos = new ArrayList<FriendlyDescription>();
  }
  
  public CredentialInUi(CredentialDescription desc, IssuerParameters ip, CredentialSpecification spec, RevocationAuthorityParameters rap) {
    this.uri = desc.getCredentialUID().toString();
    this.desc = desc;
    //this.ownershipInfos = new ArrayList<FriendlyDescription>();
    //this.validityInfos = new ArrayList<FriendlyDescription>();
    this.issuer = new IssuerInUi(ip, spec);
    if(rap != null) {
      this.revocationAuthority = new RevocationAuthorityInUi(rap);
    }
    this.spec = issuer.spec;
  }

  @Override
  public String toString() {
    return "CredentialInUi [uri=" + uri + ", desc=" + desc + /*", ownershipInfos=" + ownershipInfos
        + ", validityInfos=" + validityInfos +*/ ", revocationAuthority=" + revocationAuthority
        + ", spec=" + spec + ", issuer=" + issuer + "]";
  }
}