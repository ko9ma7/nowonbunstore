/**
 * TestLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class TestLocator extends org.apache.axis.client.Service implements org.tempuri.Test {

    public TestLocator() {
    }


    public TestLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TestLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding_ITest
    private java.lang.String BasicHttpBinding_ITest_address = "http://localhost:34768/Test.svc";

    public java.lang.String getBasicHttpBinding_ITestAddress() {
        return BasicHttpBinding_ITest_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BasicHttpBinding_ITestWSDDServiceName = "BasicHttpBinding_ITest";

    public java.lang.String getBasicHttpBinding_ITestWSDDServiceName() {
        return BasicHttpBinding_ITestWSDDServiceName;
    }

    public void setBasicHttpBinding_ITestWSDDServiceName(java.lang.String name) {
        BasicHttpBinding_ITestWSDDServiceName = name;
    }

    public org.tempuri.ITest getBasicHttpBinding_ITest() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_ITest_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding_ITest(endpoint);
    }

    public org.tempuri.ITest getBasicHttpBinding_ITest(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.BasicHttpBinding_ITestStub _stub = new org.tempuri.BasicHttpBinding_ITestStub(portAddress, this);
            _stub.setPortName(getBasicHttpBinding_ITestWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBinding_ITestEndpointAddress(java.lang.String address) {
        BasicHttpBinding_ITest_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.ITest.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.BasicHttpBinding_ITestStub _stub = new org.tempuri.BasicHttpBinding_ITestStub(new java.net.URL(BasicHttpBinding_ITest_address), this);
                _stub.setPortName(getBasicHttpBinding_ITestWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BasicHttpBinding_ITest".equals(inputPortName)) {
            return getBasicHttpBinding_ITest();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "Test");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "BasicHttpBinding_ITest"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding_ITest".equals(portName)) {
            setBasicHttpBinding_ITestEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
