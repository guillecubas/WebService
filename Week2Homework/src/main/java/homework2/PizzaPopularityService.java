package homework2;

@jakarta.jws.WebService
public interface PizzaPopularityService {
	@jakarta.jws.WebMethod
	int getPizzaPopularity(String pizzaType);

}
