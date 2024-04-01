=======================================================================
                         Pizza Price Calculator
=======================================================================

This servlet interacts with a SOAP web service to calculate the total price of pizzas based on the pizza type and the number of pizzas.

1. Introduction:
   - This servlet, when accessed via http://localhost:8080/servlet/main, interacts with a SOAP web service located at http://127.0.0.1:8001/Price.
   - It processes a SOAP request sent by the client, extracting the number of pizzas from the SOAP header and the type of pizza from the SOAP body.
   - The servlet then calculates the total price, which is the product of the pizza price and the number of pizzas.
   - It constructs a SOAP response message with the total price and returns it to the client.

2. Usage:
   - Access the servlet via http://localhost:8080/servlet/main.
   - The client should send a SOAP request to the servlet containing the pizza type in the body and the number of pizzas in the header.
   - The servlet will calculate the total price and send back a SOAP response with the total price to the client.

3. Installation:
   - Deploy the servlet to a servlet container such as Apache Tomcat.
   - Ensure that the SOAP web service is running at http://127.0.0.1:8001/Price.
   - Access the servlet using the provided URL.




