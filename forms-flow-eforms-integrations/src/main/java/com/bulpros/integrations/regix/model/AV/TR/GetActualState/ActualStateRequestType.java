//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.05.26 at 07:37:26 PM EEST 
//


package com.bulpros.integrations.regix.model.AV.TR.GetActualState;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for ActualStateRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActualStateRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UIC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActualStateRequestType", namespace = "http://egov.bg/RegiX/AV/TR/ActualStateRequest", propOrder = {
    "uic"
})
@XmlRootElement(name = "ActualStateRequest", namespace = "http://egov.bg/RegiX/AV/TR/ActualStateRequest")
public class ActualStateRequestType {

    @XmlElement(name = "UIC")
    protected String uic;

    /**
     * Gets the value of the uic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUIC() {
        return uic;
    }

    /**
     * Sets the value of the uic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUIC(String value) {
        this.uic = value;
    }

}
