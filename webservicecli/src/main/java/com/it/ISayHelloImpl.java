
package com.it;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ISayHelloImpl", targetNamespace = "http://it.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ISayHelloImpl {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://it.com/", className = "com.it.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://it.com/", className = "com.it.SayHelloResponse")
    @Action(input = "http://it.com/ISayHelloImpl/sayHelloRequest", output = "http://it.com/ISayHelloImpl/sayHelloResponse")
    public String sayHello(
            @WebParam(name = "arg0", targetNamespace = "")
                    String arg0);

}
