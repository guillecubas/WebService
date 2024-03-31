import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "PizzaPriceService", targetNamespace = "http://pizzaPrice/")
public interface PizzaPriceService {
	
    @WebMethod(operationName = "getPizzaPrice", action = "urn:GetPizzaPrice")
	double getPizzaPrice(String pizzaType, int size);
    
    @WebMethod(operationName = "getPizzaSpecialOffers", action = "urn:GetPizzaSpecialOffers")
	String getPizzaSpecialOffers(String pizzaType);
}
