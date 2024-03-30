package com.nswi145;

import javax.xml.namespace.QName;
import javax.xml.soap.*;

public class Main {

    public static void main(String[] args) {
        try {
            SOAPConnectionFactory factory = SOAPConnectionFactory.newInstance();
            SOAPConnection connection = factory.createConnection();

            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapm = messageFactory.createMessage();
                
            SOAPPart soapp = soapm.getSOAPPart();
            SOAPEnvelope soape = soapp.getEnvelope();
            SOAPBody soapb = soape.getBody();

            soape.getHeader().detachNode();
            QName name = new QName("http://homework2/", "getPizzaPopularity", "tns");
            SOAPElement soapel = soapb.addBodyElement(name);

            soapel.addChildElement(new QName("arg0")).addTextNode("Margherita");

            String endpoint = "http://127.0.0.1:8000/PopularityService";
            SOAPMessage response = connection.call(soapm, endpoint);
            connection.close();
            SOAPBody responseBody = response.getSOAPBody();
            if (responseBody.hasFault()) {
                System.out.println(responseBody.getFault().getFaultString()); 
            } else {
                QName getPizzaPopularityResponseName = new QName("http://homework2/", "getPizzaPopularityResponse", "ns2");
                QName returnName = new QName("return");
                SOAPBodyElement getPizzaPopularityResponse = (SOAPBodyElement)
                        responseBody.getChildElements(getPizzaPopularityResponseName).next();

                SOAPBodyElement returnResult = (SOAPBodyElement)
                        getPizzaPopularityResponse.getChildElements(returnName).next();

                System.out.println(returnResult.getValue());
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}