//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.05.26 at 07:37:26 PM EEST 
//


package com.bulpros.integrations.regix.model.MON.GetChildStudentStatus;

import javax.xml.bind.annotation.*;


/**
 * Входни параметри на справка за състоянието на ученик / дете
 * 
 * <p>Java class for ChildStudentStatusRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChildStudentStatusRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ChildIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChildStudentStatusRequestType", namespace = "http://egov.bg/RegiX/MON/Schools/SchoolStudentStatusRequest", propOrder = {
    "childIdentifier"
})
@XmlRootElement(name = "ChildStudentStatusRequest", namespace = "http://egov.bg/RegiX/MON/Schools/SchoolStudentStatusRequest")
public class ChildStudentStatusRequestType {

    @XmlElement(name = "ChildIdentifier", required = true)
    protected String childIdentifier;

    /**
     * Gets the value of the childIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildIdentifier() {
        return childIdentifier;
    }

    /**
     * Sets the value of the childIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildIdentifier(String value) {
        this.childIdentifier = value;
    }

}
