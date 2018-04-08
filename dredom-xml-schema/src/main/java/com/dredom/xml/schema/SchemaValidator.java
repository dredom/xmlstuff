/**
 *
 */
package com.dredom.xml.schema;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import com.dredom.xml.schema.model.FooBar;
import com.dredom.xml.schema.model.GuildMembership;

/**
 * Build an object and validate it against a schema.
 *
 * @author andre
 *
 */
public class SchemaValidator {

    public FooBar buildFooBar() {
        FooBar out = new FooBar();
        String requiredElement = "stuff";
        out.setRequiredElement(requiredElement);
        return out;
    }

    public GuildMembership buildGuildMembership() {
        GuildMembership out = new GuildMembership();
        out.setId(2L);
        return out;
    }

    public boolean validateFooBar(FooBar in) throws JAXBException, SAXException {
        String schemaFilePath = "src/main/resources/FooBar.xsd";
        JAXBContext context = JAXBContext.newInstance(in.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, schemaFilePath);

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        File schemaFile = new File(schemaFilePath);
        if (! schemaFile.exists()) {
            throw new RuntimeException("Not found " + schemaFile.getAbsolutePath());
        }
        Schema schema = factory.newSchema(schemaFile);
        marshaller.setSchema(schema);

        marshaller.marshal(in, System.out);
        return true;
    }

    public boolean validate(GuildMembership in) throws JAXBException, SAXException {
        String schemaFilePath = "GuildMembership.xsd";
        JAXBContext context = JAXBContext.newInstance(in.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, schemaFilePath);

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        File schemaFile = new File(schemaFilePath);
        if (! schemaFile.exists()) {
            throw new RuntimeException("Not found " + schemaFile.getAbsolutePath());
        }
        Schema schema = factory.newSchema(schemaFile);
        marshaller.setSchema(schema);

        marshaller.marshal(in, System.out);
        return true;
    }

    public boolean validateXmlAgainstSchema(String xmlPath, String xsdPath) {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        File schemaFile = new File(xsdPath);
        if (! schemaFile.exists()) {
            throw new RuntimeException("Not found " + schemaFile.getAbsolutePath());
        }
        File xmlFile = new File(xmlPath);
        if (! xmlFile.exists()) {
            throw new RuntimeException("Not found " + xmlFile.getAbsolutePath());
        }
        try {
            Schema schema = factory.newSchema(schemaFile);
            javax.xml.validation.Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFile));
            return true;

        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }

    }
}
