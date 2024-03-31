
package homework2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the homework2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetPizzaPrice_QNAME = new QName("http://homework2/", "getPizzaPrice");
    private final static QName _GetPizzaPriceResponse_QNAME = new QName("http://homework2/", "getPizzaPriceResponse");
    private final static QName _GetPizzaSpecialOffers_QNAME = new QName("http://homework2/", "getPizzaSpecialOffers");
    private final static QName _GetPizzaSpecialOffersResponse_QNAME = new QName("http://homework2/", "getPizzaSpecialOffersResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: homework2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPizzaPrice }
     * 
     */
    public GetPizzaPrice createGetPizzaPrice() {
        return new GetPizzaPrice();
    }

    /**
     * Create an instance of {@link GetPizzaPriceResponse }
     * 
     */
    public GetPizzaPriceResponse createGetPizzaPriceResponse() {
        return new GetPizzaPriceResponse();
    }

    /**
     * Create an instance of {@link GetPizzaSpecialOffers }
     * 
     */
    public GetPizzaSpecialOffers createGetPizzaSpecialOffers() {
        return new GetPizzaSpecialOffers();
    }

    /**
     * Create an instance of {@link GetPizzaSpecialOffersResponse }
     * 
     */
    public GetPizzaSpecialOffersResponse createGetPizzaSpecialOffersResponse() {
        return new GetPizzaSpecialOffersResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPizzaPrice }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPizzaPrice }{@code >}
     */
    @XmlElementDecl(namespace = "http://homework2/", name = "getPizzaPrice")
    public JAXBElement<GetPizzaPrice> createGetPizzaPrice(GetPizzaPrice value) {
        return new JAXBElement<GetPizzaPrice>(_GetPizzaPrice_QNAME, GetPizzaPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPizzaPriceResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPizzaPriceResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://homework2/", name = "getPizzaPriceResponse")
    public JAXBElement<GetPizzaPriceResponse> createGetPizzaPriceResponse(GetPizzaPriceResponse value) {
        return new JAXBElement<GetPizzaPriceResponse>(_GetPizzaPriceResponse_QNAME, GetPizzaPriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPizzaSpecialOffers }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPizzaSpecialOffers }{@code >}
     */
    @XmlElementDecl(namespace = "http://homework2/", name = "getPizzaSpecialOffers")
    public JAXBElement<GetPizzaSpecialOffers> createGetPizzaSpecialOffers(GetPizzaSpecialOffers value) {
        return new JAXBElement<GetPizzaSpecialOffers>(_GetPizzaSpecialOffers_QNAME, GetPizzaSpecialOffers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPizzaSpecialOffersResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPizzaSpecialOffersResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://homework2/", name = "getPizzaSpecialOffersResponse")
    public JAXBElement<GetPizzaSpecialOffersResponse> createGetPizzaSpecialOffersResponse(GetPizzaSpecialOffersResponse value) {
        return new JAXBElement<GetPizzaSpecialOffersResponse>(_GetPizzaSpecialOffersResponse_QNAME, GetPizzaSpecialOffersResponse.class, null, value);
    }

}
