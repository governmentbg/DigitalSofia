//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.05.26 at 07:37:26 PM EEST 
//


package com.bulpros.integrations.regix.model.AV.TR.GetActualState;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StatusType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Нова партида"/&gt;
 *     &lt;enumeration value="Пререгистрирана партида"/&gt;
 *     &lt;enumeration value="Нова закрита партида"/&gt;
 *     &lt;enumeration value="Пререгистрирана закрита партида"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "StatusType")
@XmlEnum
public enum StatusType {

    @XmlEnumValue("\u041d\u043e\u0432\u0430 \u043f\u0430\u0440\u0442\u0438\u0434\u0430")
    НОВА_ПАРТИДА("\u041d\u043e\u0432\u0430 \u043f\u0430\u0440\u0442\u0438\u0434\u0430"),
    @XmlEnumValue("\u041f\u0440\u0435\u0440\u0435\u0433\u0438\u0441\u0442\u0440\u0438\u0440\u0430\u043d\u0430 \u043f\u0430\u0440\u0442\u0438\u0434\u0430")
    ПРЕРЕГИСТРИРАНА_ПАРТИДА("\u041f\u0440\u0435\u0440\u0435\u0433\u0438\u0441\u0442\u0440\u0438\u0440\u0430\u043d\u0430 \u043f\u0430\u0440\u0442\u0438\u0434\u0430"),
    @XmlEnumValue("\u041d\u043e\u0432\u0430 \u0437\u0430\u043a\u0440\u0438\u0442\u0430 \u043f\u0430\u0440\u0442\u0438\u0434\u0430")
    НОВА_ЗАКРИТА_ПАРТИДА("\u041d\u043e\u0432\u0430 \u0437\u0430\u043a\u0440\u0438\u0442\u0430 \u043f\u0430\u0440\u0442\u0438\u0434\u0430"),
    @XmlEnumValue("\u041f\u0440\u0435\u0440\u0435\u0433\u0438\u0441\u0442\u0440\u0438\u0440\u0430\u043d\u0430 \u0437\u0430\u043a\u0440\u0438\u0442\u0430 \u043f\u0430\u0440\u0442\u0438\u0434\u0430")
    ПРЕРЕГИСТРИРАНА_ЗАКРИТА_ПАРТИДА("\u041f\u0440\u0435\u0440\u0435\u0433\u0438\u0441\u0442\u0440\u0438\u0440\u0430\u043d\u0430 \u0437\u0430\u043a\u0440\u0438\u0442\u0430 \u043f\u0430\u0440\u0442\u0438\u0434\u0430");
    private final String value;

    StatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StatusType fromValue(String v) {
        for (StatusType c: StatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
