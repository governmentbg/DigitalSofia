
package com.bulpros.integrations.eDelivery.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for anonymous complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="GetSentMessagesListResult" type="{http://schemas.datacontract.org/2004/07/EDelivery.Common.DataContracts}ArrayOfDcMessage" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getSentMessagesListResult"
})
@XmlRootElement(name = "GetSentMessagesListResponse")
public class GetSentMessagesListResponse {

    @XmlElementRef(name = "GetSentMessagesListResult", namespace = "https://edelivery.egov.bg/services/integration", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfDcMessage> getSentMessagesListResult;

    /**
     * Gets the value of the getSentMessagesListResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDcMessage }{@code >}
     *     
     */
    public JAXBElement<ArrayOfDcMessage> getGetSentMessagesListResult() {
        return getSentMessagesListResult;
    }

    /**
     * Sets the value of the getSentMessagesListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDcMessage }{@code >}
     *     
     */
    public void setGetSentMessagesListResult(JAXBElement<ArrayOfDcMessage> value) {
        this.getSentMessagesListResult = value;
    }

}