
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
 *         &amp;lt;element name="message" type="{http://schemas.datacontract.org/2004/07/EDelivery.Common.DataContracts}DcMessageDetails" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="senderUniqueIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="receiverUniqueIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="receiverPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="receiverEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="receiverFirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="receiverLastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="serviceOID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="operatorEGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
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
    "message",
    "senderUniqueIdentifier",
    "receiverUniqueIdentifier",
    "receiverPhone",
    "receiverEmail",
    "receiverFirstName",
    "receiverLastName",
    "serviceOID",
    "operatorEGN"
})
@XmlRootElement(name = "SendMessageOnBehalfToPerson")
public class SendMessageOnBehalfToPerson {

    @XmlElementRef(name = "message", namespace = "https://edelivery.egov.bg/services/integration", type = JAXBElement.class, required = false)
    protected JAXBElement<DcMessageDetails> message;
    @XmlElementRef(name = "senderUniqueIdentifier", namespace = "https://edelivery.egov.bg/services/integration", type = JAXBElement.class, required = false)
    protected JAXBElement<String> senderUniqueIdentifier;
    @XmlElementRef(name = "receiverUniqueIdentifier", namespace = "https://edelivery.egov.bg/services/integration", type = JAXBElement.class, required = false)
    protected JAXBElement<String> receiverUniqueIdentifier;
    @XmlElementRef(name = "receiverPhone", namespace = "https://edelivery.egov.bg/services/integration", type = JAXBElement.class, required = false)
    protected JAXBElement<String> receiverPhone;
    @XmlElementRef(name = "receiverEmail", namespace = "https://edelivery.egov.bg/services/integration", type = JAXBElement.class, required = false)
    protected JAXBElement<String> receiverEmail;
    @XmlElementRef(name = "receiverFirstName", namespace = "https://edelivery.egov.bg/services/integration", type = JAXBElement.class, required = false)
    protected JAXBElement<String> receiverFirstName;
    @XmlElementRef(name = "receiverLastName", namespace = "https://edelivery.egov.bg/services/integration", type = JAXBElement.class, required = false)
    protected JAXBElement<String> receiverLastName;
    @XmlElementRef(name = "serviceOID", namespace = "https://edelivery.egov.bg/services/integration", type = JAXBElement.class, required = false)
    protected JAXBElement<String> serviceOID;
    @XmlElementRef(name = "operatorEGN", namespace = "https://edelivery.egov.bg/services/integration", type = JAXBElement.class, required = false)
    protected JAXBElement<String> operatorEGN;

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DcMessageDetails }{@code >}
     *     
     */
    public JAXBElement<DcMessageDetails> getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DcMessageDetails }{@code >}
     *     
     */
    public void setMessage(JAXBElement<DcMessageDetails> value) {
        this.message = value;
    }

    /**
     * Gets the value of the senderUniqueIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSenderUniqueIdentifier() {
        return senderUniqueIdentifier;
    }

    /**
     * Sets the value of the senderUniqueIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSenderUniqueIdentifier(JAXBElement<String> value) {
        this.senderUniqueIdentifier = value;
    }

    /**
     * Gets the value of the receiverUniqueIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReceiverUniqueIdentifier() {
        return receiverUniqueIdentifier;
    }

    /**
     * Sets the value of the receiverUniqueIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReceiverUniqueIdentifier(JAXBElement<String> value) {
        this.receiverUniqueIdentifier = value;
    }

    /**
     * Gets the value of the receiverPhone property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReceiverPhone() {
        return receiverPhone;
    }

    /**
     * Sets the value of the receiverPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReceiverPhone(JAXBElement<String> value) {
        this.receiverPhone = value;
    }

    /**
     * Gets the value of the receiverEmail property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReceiverEmail() {
        return receiverEmail;
    }

    /**
     * Sets the value of the receiverEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReceiverEmail(JAXBElement<String> value) {
        this.receiverEmail = value;
    }

    /**
     * Gets the value of the receiverFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReceiverFirstName() {
        return receiverFirstName;
    }

    /**
     * Sets the value of the receiverFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReceiverFirstName(JAXBElement<String> value) {
        this.receiverFirstName = value;
    }

    /**
     * Gets the value of the receiverLastName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReceiverLastName() {
        return receiverLastName;
    }

    /**
     * Sets the value of the receiverLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReceiverLastName(JAXBElement<String> value) {
        this.receiverLastName = value;
    }

    /**
     * Gets the value of the serviceOID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getServiceOID() {
        return serviceOID;
    }

    /**
     * Sets the value of the serviceOID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setServiceOID(JAXBElement<String> value) {
        this.serviceOID = value;
    }

    /**
     * Gets the value of the operatorEGN property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOperatorEGN() {
        return operatorEGN;
    }

    /**
     * Sets the value of the operatorEGN property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOperatorEGN(JAXBElement<String> value) {
        this.operatorEGN = value;
    }

}
