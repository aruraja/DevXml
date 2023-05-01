package org.example;

import com.google.common.base.Charsets;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            JAXBContext context = JAXBContext.newInstance(Customer.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();

            Customer customer = (Customer) unmarshaller.unmarshal(
                    new File("sample.xml"));

            System.out.println("Customer Id : "
                    + customer.getId());

            System.out.println("Customer FirstName : "
                    + customer.getFirstName());

            System.out.println("Customer LastName : "
                    + customer.getLastName());

            System.out.println("Customer Email : "
                    + customer.getEmail());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
}

    public static String asString(String resource) {
        URL url = com.google.common.io.Resources.getResource(resource);
        try {
            return com.google.common.io.Resources.toString(url, Charsets.UTF_8);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}