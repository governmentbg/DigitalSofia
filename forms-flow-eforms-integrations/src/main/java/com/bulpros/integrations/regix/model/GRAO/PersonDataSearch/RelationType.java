//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.05.26 at 07:37:25 PM EEST 
//


package com.bulpros.integrations.regix.model.GRAO.PersonDataSearch;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RelationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RelationType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Баща"/&gt;
 *     &lt;enumeration value="Осиновител"/&gt;
 *     &lt;enumeration value="Майка"/&gt;
 *     &lt;enumeration value="Осиновителка"/&gt;
 *     &lt;enumeration value="Син"/&gt;
 *     &lt;enumeration value="Дъщеря"/&gt;
 *     &lt;enumeration value="Брат"/&gt;
 *     &lt;enumeration value="Сестра"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RelationType")
@XmlEnum
public enum RelationType {

    @XmlEnumValue("\u0411\u0430\u0449\u0430")
    БАЩА("\u0411\u0430\u0449\u0430"),
    @XmlEnumValue("\u041e\u0441\u0438\u043d\u043e\u0432\u0438\u0442\u0435\u043b")
    ОСИНОВИТЕЛ("\u041e\u0441\u0438\u043d\u043e\u0432\u0438\u0442\u0435\u043b"),
    @XmlEnumValue("\u041c\u0430\u0439\u043a\u0430")
    МАЙКА("\u041c\u0430\u0439\u043a\u0430"),
    @XmlEnumValue("\u041e\u0441\u0438\u043d\u043e\u0432\u0438\u0442\u0435\u043b\u043a\u0430")
    ОСИНОВИТЕЛКА("\u041e\u0441\u0438\u043d\u043e\u0432\u0438\u0442\u0435\u043b\u043a\u0430"),
    @XmlEnumValue("\u0421\u0438\u043d")
    СИН("\u0421\u0438\u043d"),
    @XmlEnumValue("\u0414\u044a\u0449\u0435\u0440\u044f")
    ДЪЩЕРЯ("\u0414\u044a\u0449\u0435\u0440\u044f"),
    @XmlEnumValue("\u0411\u0440\u0430\u0442")
    БРАТ("\u0411\u0440\u0430\u0442"),
    @XmlEnumValue("\u0421\u0435\u0441\u0442\u0440\u0430")
    СЕСТРА("\u0421\u0435\u0441\u0442\u0440\u0430");
    private final String value;

    RelationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RelationType fromValue(String v) {
        for (RelationType c: RelationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
