package me.aliprax.soap;

import me.aliprax.types.*;

import javax.jws.WebService;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.soap.SOAPFaultException;

@WebService(endpointInterface = "me.aliprax.soap.HelloPort")
public class HelloPortImpl implements HelloPort {

    private Integer helloCount = 0;

    public HelloType createHello(UserType user) throws ServiceException {
        synchronized (this) {
            helloCount++;
        }
        HelloType hello = new HelloType();
        hello.setMessage(String.format("Hello %s %s %s", user.getTitle(), user.getName(), user.getSurname()));
        return hello;
    }

    public HelloType createHelloMayFault(UserType user) {
        synchronized (this) {
            helloCount++;
        }
        if (helloCount % 7 == 0) {
            SOAPFault fault;
            try {
                fault = SOAPFactory.newInstance().createFault();
                fault.setFaultCode("Conflict");
                fault.setFaultString("Cannot create message at the moment");
            } catch (SOAPException e) {
                throw new RuntimeException("Cannot create soap fault", e);
            }
            throw new SOAPFaultException(fault);
        }
        HelloType hello = new HelloType();
        hello.setMessage(String.format("Hello %s %s %s", user.getTitle(), user.getName(), user.getSurname()));
        return hello;
    }


    public HelloCountType getHelloCount() {
        return new HelloCountType(helloCount);
    }

    public HelloType createFault(UserType user) throws ServiceException {
        throw new ServiceException(new ServiceFault("001", "This is an error"));
    }
}