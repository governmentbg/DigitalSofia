//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.05.26 at 07:37:26 PM EEST 
//


package com.bulpros.integrations.regix.model.AZ.GetJobSeekerStatus;

import javax.xml.bind.annotation.*;


/**
 * Данни за статус на търсещо работа лице
 * 
 * <p>Java class for JobSeekerStatusData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JobSeekerStatusData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element name="RegistrationGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="JobSeekerPersonData" type="{http://egov.bg/RegiX/AZ}PersonData" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JobSeekerStatusData", namespace = "http://egov.bg/RegiX/AZ/JobSeekerStatusResponse", propOrder = {
    "registrationGroup",
    "jobSeekerPersonData"
})
@XmlRootElement(name = "JobSeekerStatusResponse", namespace = "http://egov.bg/RegiX/AZ/JobSeekerStatusResponse")
public class JobSeekerStatusData {

    @XmlElement(name = "RegistrationGroup")
    protected String registrationGroup;
    @XmlElement(name = "JobSeekerPersonData")
    protected PersonData jobSeekerPersonData;

    /**
     * Gets the value of the registrationGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrationGroup() {
        return registrationGroup;
    }

    /**
     * Sets the value of the registrationGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrationGroup(String value) {
        this.registrationGroup = value;
    }

    /**
     * Gets the value of the jobSeekerPersonData property.
     * 
     * @return
     *     possible object is
     *     {@link PersonData }
     *     
     */
    public PersonData getJobSeekerPersonData() {
        return jobSeekerPersonData;
    }

    /**
     * Sets the value of the jobSeekerPersonData property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonData }
     *     
     */
    public void setJobSeekerPersonData(PersonData value) {
        this.jobSeekerPersonData = value;
    }

}
