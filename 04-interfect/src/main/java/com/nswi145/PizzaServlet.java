package com.nswi145;

import java.io.IOException;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.soap.*;

@WebServlet("/PizzaServlet")
public class PizzaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PizzaServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Post request received ...");
        getPizzaPopularity(request, response);
    }

    private void getPizzaPopularity(HttpServletRequest r, HttpServletResponse resp) {
        try {
            SOAPConnection soapc = SOAPConnectionFactory.newInstance().createConnection();
            String endpoint = "http://127.0.0.1:8000/PizzaPopularityService";

            String pizzaType = "";

            SOAPMessage message = MessageFactory.newInstance().createMessage(new MimeHeaders(), r.getInputStream());

            System.out.println("SOAP message exists");

            if(message.getSOAPHeader().hasChildNodes()) {
                Iterator<Node> it = message.getSOAPHeader().getChildElements();
                while(it.hasNext()) {
                    Node n = it.next();
                    if(n.getNodeName().equals("pizzaType")) {
                        pizzaType = n.getTextContent();
                        System.out.println("Pizza type: " + pizzaType);
                    }
                }
            }

            SOAPMessage response = soapc.call(message, endpoint);
            System.out.println("We have response");
            soapc.close();

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

                int popularity = Integer.parseInt(returnResult.getValue());
                System.out.println("Popularity: " + popularity);

                response.writeTo(System.out);
                response.writeTo(resp.getOutputStream());
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}