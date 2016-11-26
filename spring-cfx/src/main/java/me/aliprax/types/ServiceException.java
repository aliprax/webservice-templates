package me.aliprax.types;

import javax.xml.ws.WebFault;

@WebFault(name = "serviceFault", messageName = "serviceException")
public class ServiceException extends Exception {

    private ServiceFault faultInfo;

    public ServiceException() {
        super();
    }

    public ServiceException(ServiceFault faultInfo) {
        this.faultInfo = faultInfo;
    }

    public ServiceException(String message, Throwable cause, ServiceFault faultInfo) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    public ServiceFault getFaultInfo() {
        return faultInfo;
    }

    public void setFaultInfo(ServiceFault faultInfo) {
        this.faultInfo = faultInfo;
    }
}
