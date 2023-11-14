
package com.bulpros.integrations.regix.model.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for ResultWrapper complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ResultWrapper"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="ServiceResultData" type="{http://egov.bg/RegiX/SignedData}ServiceResultData"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultWrapper", propOrder = {
    "serviceResultData"
})
public class ResultWrapper {

    @XmlElement(name = "ServiceResultData", required = true)
    protected ServiceResultData serviceResultData;

    /**
     * Gets the value of the serviceResultData property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceResultData }
     *     
     */
    public ServiceResultData getServiceResultData() {
        return serviceResultData;
    }

    /**
     * Sets the value of the serviceResultData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceResultData }
     *     
     */
    public void setServiceResultData(ServiceResultData value) {
        this.serviceResultData = value;
    }

}
