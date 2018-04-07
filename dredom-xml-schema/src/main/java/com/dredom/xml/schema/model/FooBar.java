package com.dredom.xml.schema.model;

import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 * This documentation will be copied as an XML Documentation Annotation for the ComplexType 'FooBar'. Define it to
 * augment usability/readability within the generated XSD.
 *
 * @author <a href="mailto:lj@jguru.se">Lennart J&ouml;relid</a>
 */
@XmlType(namespace = "http://some/namespace", propOrder = { "requiredElement", "aRequiredElementInAnotherNamespace",
        "optionalElement", "requiredAttribute", "optionalAttribute", "guildMemberships" })
@XmlAccessorType(XmlAccessType.FIELD)
public class FooBar {

    /**
     * This documentation will be copied as an XML Documentation Annotation for the 'requiredElement'. Define it to
     * augment usability/readability within the generated XSD.
     */
    @XmlElement(required = true, defaultValue = "requiredElementValue")
    private String requiredElement;

    @XmlElement(namespace = "http://another/namespace", required = true, defaultValue = "requiredElementValue")
    private String aRequiredElementInAnotherNamespace;

    /**
     * This documentation will be copied as an XML Documentation Annotation for the 'optionalElement'. Define it to
     * augment usability/readability within the generated XSD.
     */
    @XmlElement(required = false)
    private String optionalElement;

    @XmlAttribute(required = true)
    private String requiredAttribute;

    @XmlAttribute(required = false)
    private String optionalAttribute;

    /**
     * The Guild Memberships of this FooBar. A nil value implies no GuildMemberships exist.
     */
    @XmlElementWrapper(name = "guildMemberships", nillable = true, required = false)
    @XmlElement(name = "guildMembership")
    private Set<GuildMembership> guildMemberships;

}
