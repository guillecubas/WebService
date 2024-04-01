package homework4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;

@WebServlet("/servlet")
public class sevlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public sevlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Post request received ...");
        getPizzaPopularity(request, response);
    }

    private void getPizzaPopularity(HttpServletRequest r, HttpServletResponse resp) {
        try {
            SOAPConnection soapc = SOAPConnectionFactory.newInstance().createConnection();
            String endpoint = "http://localhost:8080/04-intermidaiary/servlet";

            String pizzaType = "Margherita";

            MessageFactory messageFactory = MessageFactory.newInstance();
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = r.getInputStream().read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
            SOAPMessage message = messageFactory.createMessage(null, new ByteArrayInputStream(outStream.toByteArray()));

            System.out.println("SOAP message exists");

            SOAPHeader soapHeader = message.getSOAPHeader();
            if (soapHeader != null && soapHeader.hasChildNodes()) {
                Iterator<?> it = soapHeader.getChildElements();
                while (it.hasNext()) {
                    Object obj = it.next();
                    if (obj instanceof SOAPHeaderElement) {
                        SOAPHeaderElement headerElement = (SOAPHeaderElement) obj;
                        if (headerElement.getNodeName().equals("pizzaType")) {
                            pizzaType = headerElement.getValue();
                            System.out.println("Pizza type: " + pizzaType);
                        }
                    }
                }
            }

            SOAPMessage responseMessage = soapc.call(message, endpoint);
            System.out.println("We have response");
            soapc.close();

            SOAPBody responseBody = responseMessage.getSOAPBody();
            if (responseBody.hasFault()) {
                System.out.println(responseBody.getFault().getFaultString());
            } else {
                QName getPizzaPopularityResponseName = new QName("http://homework2/", "getPizzaPriceResponse", "ns2");
                QName returnName = new QName("return");

                SOAPBodyElement getPizzaPopularityResponse = (SOAPBodyElement) responseBody.getChildElements(getPizzaPopularityResponseName).next();
                SOAPBodyElement returnResult = (SOAPBodyElement) getPizzaPopularityResponse.getChildElements(returnName).next();

                int popularity = Integer.parseInt(returnResult.getValue());
                System.out.println("Popularity: " + popularity);

                responseMessage.writeTo(System.out);
                responseMessage.writeTo(resp.getOutputStream());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
