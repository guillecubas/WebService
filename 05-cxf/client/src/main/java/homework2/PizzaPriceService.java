package homework2;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.5.8
 * 2024-03-31T23:44:25.229+02:00
 * Generated source version: 3.5.8
 *
 */
@WebService(targetNamespace = "http://homework2/", name = "PizzaPriceService")
@XmlSeeAlso({ObjectFactory.class})
public interface PizzaPriceService {

    @WebMethod
    @Action(input = "http://homework2/PizzaPriceService/getPizzaPriceRequest", output = "http://homework2/PizzaPriceService/getPizzaPriceResponse")
    @RequestWrapper(localName = "getPizzaPrice", targetNamespace = "http://homework2/", className = "homework2.GetPizzaPrice")
    @ResponseWrapper(localName = "getPizzaPriceResponse", targetNamespace = "http://homework2/", className = "homework2.GetPizzaPriceResponse")
    @WebResult(name = "return", targetNamespace = "")
    public double getPizzaPrice(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1
    );

    @WebMethod
    @Action(input = "http://homework2/PizzaPriceService/getPizzaSpecialOffersRequest", output = "http://homework2/PizzaPriceService/getPizzaSpecialOffersResponse")
    @RequestWrapper(localName = "getPizzaSpecialOffers", targetNamespace = "http://homework2/", className = "homework2.GetPizzaSpecialOffers")
    @ResponseWrapper(localName = "getPizzaSpecialOffersResponse", targetNamespace = "http://homework2/", className = "homework2.GetPizzaSpecialOffersResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String getPizzaSpecialOffers(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );
}
