//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.05.26 at 07:37:27 PM EEST 
//


package com.bulpros.integrations.regix.model.NELK.GetAllExpertDecisionsByIdentifier;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;


/**
 * Списък с експертни решения
 * 
 * <p>Java class for ExpertDecisionsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExpertDecisionsResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element name="ExpertDecisionDocument" type="{http://egov.bg/RegiX/NELK/EISME}ExpertDecisionDocument" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExpertDecisionsResponse", propOrder = {
    "expertDecisionDocument"
})
@XmlRootElement(name = "ExpertDecisionsResponse")
public class ExpertDecisionsResponse {

    @XmlElement(name = "ExpertDecisionDocument")
    protected List<ExpertDecisionDocument> expertDecisionDocument;

    /**
     * Gets the value of the expertDecisionDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the expertDecisionDocument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExpertDecisionDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExpertDecisionDocument }
     * 
     * 
     */
    public List<ExpertDecisionDocument> getExpertDecisionDocument() {
        if (expertDecisionDocument == null) {
            expertDecisionDocument = new ArrayList<ExpertDecisionDocument>();
        }
        return this.expertDecisionDocument;
    }

}
