import javax.jws.WebService;

@WebService(targetNamespace = "http://pizzaPrice/", endpointInterface = "pizzaPrice.PizzaPriceService", portName = "PizzaPriceServiceImpPort", serviceName = "PizzaPriceServiceImpService")
public class PizzaPriceServiceImp {

    public double getPizzaPrice(String pizzaType, int size) {

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

    public String getPizzaSpecialOffers(String pizzaType) {

        if (pizzaType.equalsIgnoreCase("Margherita")) {
            return "Free garlic bread with every Margherita pizza!";
        } else if (pizzaType.equalsIgnoreCase("Pepperoni")) {
            return "Buy one Pepperoni pizza, get the second at half price!";
        } else if (pizzaType.equalsIgnoreCase("Vegetarian")) {
            return "Upgrade to a large Vegetarian pizza for the price of a medium!";

        }else {
            return "No special offers available for this pizza type";
        }
    }
}
