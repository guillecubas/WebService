package homework2;
import jakarta.jws.WebService;

@WebService(endpointInterface = "homework2.PizzaPopularityService")
public class PizzaPopularityServiceImp {
	public int getPizzaPopularity(String pizzaType) {
        // Mock pizza popularity data
        if (pizzaType.equalsIgnoreCase("Margherita")) {
            return 10; // High popularity
        } else if (pizzaType.equalsIgnoreCase("Pepperoni")) {
            return 8; // Moderate popularity
        } else if (pizzaType.equalsIgnoreCase("Vegetarian")) {
            return 6; // Low popularity
        } else {
            return -1; // Invalid pizza type
        }
    }

}
