package com;


import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.*;

import org.w3c.dom.NodeList;

import javax.xml.namespace.QName;


@WebServlet("/main")
public class main extends HttpServlet {
	
	
    private static final long serialVersionUID = 1L;
    
    
    public main() {
        super();
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Post request received ...");
        String pizzaType = request.getParameter("arg0");
        System.out.println(pizzaType);
        try {
        	getPizzaPrice(request, response);
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();

        }
    }
    
    private void getPizzaPrice(HttpServletRequest req, HttpServletResponse resp) {
        try {
            // Obtener el tipo de pizza del parámetro de la solicitud
            String pizzaType = "Vegetarian";

            // Construir la solicitud SOAP
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage(new MimeHeaders(), req.getInputStream());
            String Number = null;
            SOAPHeader soapHeader = soapMessage.getSOAPHeader();
            if (soapHeader != null) {
                Iterator<Node> headerIterator = soapHeader.getChildElements();
                while (headerIterator.hasNext()) {
                    Node node = headerIterator.next();
                    if(node.getNodeName().equals("tweak")) {
						Number = node.getAttributes().getNamedItem("Number").getNodeValue();
						System.out.println("Number of pizza: " + Number);
					}
                }
            }
            
            
            String url = "http://127.0.0.1:8001/Price";
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            SOAPMessage responseFromService = soapConnection.call(soapMessage, url);
            System.out.println("We have response");
            soapConnection.close();
            
            SOAPPart soapPart = soapMessage.getSOAPPart();
            SOAPEnvelope envelope = soapPart.getEnvelope();
            
            SOAPBody responseBody = responseFromService.getSOAPBody();
			if (responseBody.hasFault()) {
			    System.out.println(responseBody.getFault().getFaultString()); 
			} else {
				QName getPizzaType = new QName("http://homework/", "getPizzaPrice", "hom");
				SOAPBodyElement getPizzaPriceResponse = (SOAPBodyElement)responseBody.getChildElements().next();		
				System.out.println("Price: " + getPizzaPriceResponse);
				
				if(responseFromService.getSOAPHeader() != null) {
					responseFromService.getSOAPHeader().addHeaderElement(new QName("http://tweaks.com/","tweaked")).addTextNode("getPizzaPriceResponse:");
				}
				else {
					SOAPHeader h = responseFromService.getSOAPPart().getEnvelope().addHeader();
					h.addHeaderElement(new QName("http://tweaks.com/","tweaked")).addTextNode("Number of pizza:" + Number);
				}
                NodeList returnNodeList = responseBody.getElementsByTagName("return");
                String priceString = returnNodeList.item(0).getTextContent();
                double price = Double.parseDouble(priceString);
                int numberOfPizzas = Integer.parseInt(Number);

                // Calculate total price
                double totalPrice = price * numberOfPizzas;
                String totalPriceString = String.valueOf(totalPrice);

				responseFromService.getSOAPBody().addChildElement(new QName("http://homework/", "TotalPrice", "ns2")).addTextNode(totalPriceString);



                // Write the SOAP response to the output stream
				responseFromService.writeTo(System.out);
				responseFromService.writeTo(resp.getOutputStream());
                // Write the total price to the response
                resp.setContentType("text/xml");
                resp.getWriter().write("<TotalPrice>" + totalPrice + "</TotalPrice>");
			}
        } catch (Exception e) {
            e.printStackTrace();

            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.setContentType("text/plain");
            try {
				resp.getWriter().write("Error al obtener el precio de la pizza");
			} catch (IOException e1) {

				e1.printStackTrace();
			}
        }
    }
}
