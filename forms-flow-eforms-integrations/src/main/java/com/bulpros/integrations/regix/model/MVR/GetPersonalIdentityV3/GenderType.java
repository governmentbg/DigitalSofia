//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.06.18 at 03:52:47 PM EEST 
//


package com.bulpros.integrations.regix.model.MVR.GetPersonalIdentityV3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GenderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GenderType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GenderCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Cyrillic" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Latin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenderType", propOrder = {
    "genderCode",
    "cyrillic",
    "latin"
})
public class GenderType {

    @XmlElement(name = "GenderCode")
    protected String genderCode;
    @XmlElement(name = "Cyrillic", required = true)
    protected String cyrillic;
    @XmlElement(name = "Latin")
    protected String latin;

    /**
     * Gets the value of the genderCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenderCode() {
        return genderCode;
    }

    /**
     * Sets the value of the genderCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenderCode(String value) {
        this.genderCode = value;
    }

    /**
     * Gets the value of the cyrillic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCyrillic() {
        return cyrillic;
    }

    /**
     * Sets the value of the cyrillic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCyrillic(String value) {
        this.cyrillic = value;
    }

    /**
     * Gets the value of the latin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLatin() {
        return latin;
    }

    /**
     * Sets the value of the latin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLatin(String value) {
        this.latin = value;
    }

}
