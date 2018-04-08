package com.dredom.xml.schema;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dredom.xml.schema.model.FooBar;
import com.dredom.xml.schema.model.GuildMembership;

public class ShemaValidatorTest {

    SchemaValidator service = new SchemaValidator();

//    @Test
    public void validateGuildMembership() throws Exception {
        GuildMembership obj = service.buildGuildMembership();

        service.validate(obj);
    }

//    @Test
    public void validateFooBar() throws Exception {
        FooBar obj = service.buildFooBar();

        service.validateFooBar(obj);
    }

    @Test
    public void validateXmlAgainstSchema() {
        final String path = "src/main/resources/";
        final String xsdPath = path + "Employee.xsd";

        assertTrue( service.validateXmlAgainstSchema(path + "EmployeeRequest.xml", xsdPath));
        assertFalse( service.validateXmlAgainstSchema(path + "employee-bad.xml", xsdPath));
    }
}
