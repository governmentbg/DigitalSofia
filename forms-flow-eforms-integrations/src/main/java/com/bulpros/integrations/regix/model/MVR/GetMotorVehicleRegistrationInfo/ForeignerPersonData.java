//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.05.26 at 07:37:27 PM EEST 
//


package com.bulpros.integrations.regix.model.MVR.GetMotorVehicleRegistrationInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Данни за физическо лице - чужденец
 * 
 * <p>Java class for ForeignerPersonData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ForeignerPersonData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LNCh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Names" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NamesLatin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GenderName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GenderNameLatin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ForeignerPersonData", propOrder = {
    "egn",
    "lnCh",
    "names",
    "namesLatin",
    "genderName",
    "genderNameLatin"
})
public class ForeignerPersonData {

    @XmlElement(name = "EGN")
    protected String egn;
    @XmlElement(name = "LNCh")
    protected String lnCh;
    @XmlElement(name = "Names")
    protected String names;
    @XmlElement(name = "NamesLatin")
    protected String namesLatin;
    @XmlElement(name = "GenderName")
    protected String genderName;
    @XmlElement(name = "GenderNameLatin")
    protected String genderNameLatin;

    /**
     * Gets the value of the egn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEGN() {
        return egn;
    }

    /**
     * Sets the value of the egn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEGN(String value) {
        this.egn = value;
    }

    /**
     * Gets the value of the lnCh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLNCh() {
        return lnCh;
    }

    /**
     * Sets the value of the lnCh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLNCh(String value) {
        this.lnCh = value;
    }

    /**
     * Gets the value of the names property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNames() {
        return names;
    }

    /**
     * Sets the value of the names property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNames(String value) {
        this.names = value;
    }

    /**
     * Gets the value of the namesLatin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamesLatin() {
        return namesLatin;
    }

    /**
     * Sets the value of the namesLatin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamesLatin(String value) {
        this.namesLatin = value;
    }

    /**
     * Gets the value of the genderName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenderName() {
        return genderName;
    }

    /**
     * Sets the value of the genderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenderName(String value) {
        this.genderName = value;
    }

    /**
     * Gets the value of the genderNameLatin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenderNameLatin() {
        return genderNameLatin;
    }

    /**
     * Sets the value of the genderNameLatin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenderNameLatin(String value) {
        this.genderNameLatin = value;
    }

}
