package me.aliprax.soap;

import me.aliprax.types.HelloCountType;
import me.aliprax.types.HelloType;
import me.aliprax.types.ServiceException;
import me.aliprax.types.UserType;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Messages are wrapped in methodName
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED, use = SOAPBinding.Use.LITERAL)
public interface HelloPort {


    @WebMethod
    @WebResult(name = "hello")
    HelloType createHello(
            @WebParam(name = "user") UserType user)
            throws ServiceException;

    @WebMethod
    @WebResult(name = "hello")
    HelloType createHelloMayFault(
            @WebParam(name = "user") UserType user)
            throws ServiceException;

    @WebMethod
    @WebResult(name = "hello-count")
    HelloCountType getHelloCount()
            throws ServiceException;


    @WebMethod
    @WebResult(name = "hello")
    HelloType createFault(
            @WebParam(name = "user") UserType user)
            throws ServiceException;
}