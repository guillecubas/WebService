package homework2;
import jakarta.jws.WebService;

@WebService(endpointInterface = "homework2.PizzaPriceService")
public class PizzaPriceServiceImp {
	public double getPizzaPrice(String pizzaType, int size) {
        // Mock pizza price data
        double basePrice = 8.0; // Base price for a small pizza
        if (pizzaType.equalsIgnoreCase("Margherita")) {
            return basePrice + (size - 1) * 2.0; // Increase price based on size
        } else if (pizzaType.equalsIgnoreCase("Pepperoni")) {
            return basePrice + 1.5 + (size - 1) * 2.5; // Increase price based on size and additional toppings
        } else if (pizzaType.equalsIgnoreCase("Vegetarian")) {
            return basePrice + 2.0 + (size - 1) * 2.0; // Increase price based on size and additional toppings
        } else {
            return -1; // Invalid pizza type
        }
    }

}
