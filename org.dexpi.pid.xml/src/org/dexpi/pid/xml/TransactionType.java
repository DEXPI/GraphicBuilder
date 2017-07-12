//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.10.22 um 01:08:11 PM CEST 
//


package org.dexpi.pid.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für TransactionType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="TransactionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="to approve"/>
 *     &lt;enumeration value="to check"/>
 *     &lt;enumeration value="to copy"/>
 *     &lt;enumeration value="to create"/>
 *     &lt;enumeration value="to modify"/>
 *     &lt;enumeration value="to request"/>
 *     &lt;enumeration value="to release"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TransactionType")
@XmlEnum
public enum TransactionType {

    @XmlEnumValue("to approve")
    TO_APPROVE("to approve"),
    @XmlEnumValue("to check")
    TO_CHECK("to check"),
    @XmlEnumValue("to copy")
    TO_COPY("to copy"),
    @XmlEnumValue("to create")
    TO_CREATE("to create"),
    @XmlEnumValue("to modify")
    TO_MODIFY("to modify"),
    @XmlEnumValue("to request")
    TO_REQUEST("to request"),
    @XmlEnumValue("to release")
    TO_RELEASE("to release");
    private final java.lang.String value;

    TransactionType(java.lang.String v) {
        this.value = v;
    }

    public java.lang.String value() {
        return this.value;
    }

    public static TransactionType fromValue(java.lang.String v) {
        for (TransactionType c: TransactionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
