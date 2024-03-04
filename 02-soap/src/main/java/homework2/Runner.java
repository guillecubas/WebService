package homework2;
import jakarta.xml.ws.Endpoint;


public class Runner {
    public static void main(String[] args)
       {
        Endpoint.publish("http://127.0.0.1:8001/Price", new PizzaPriceServiceImp());
        Endpoint.publish("http://127.0.0.1:8002/Popularity", new PizzaPopularityServiceImp());
        
       }
}
