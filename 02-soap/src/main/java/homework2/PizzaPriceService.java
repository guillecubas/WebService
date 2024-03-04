package homework2;


@jakarta.jws.WebService
public interface PizzaPriceService {
	@jakarta.jws.WebMethod
    double getPizzaPrice(String pizzaType, int size);
}
