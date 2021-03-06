/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.orange.uklab.b2bbc.descriptor;
import java.io.Serializable;
import javax.jbi.servicedesc.ServiceEndpoint;
import javax.xml.namespace.QName;
import org.w3c.dom.DocumentFragment;

/**
 *
 * @author hasanein
 */
public abstract class AbstractServiceEndpoint implements ServiceEndpoint, Serializable
{
    /**
     *
     */
    public static final String ENDPOINT_TYPE_PROVIDE = "provides";
    /**
     *
     */
    public static final String ENDPOINT_TYPE_CONSUME = "consumes";
    /**
     *
     */
    protected String serviceUnitName;
    /**
     *
     */
    protected String endpointType;
    /**
     *
     */
    protected String endpointName;
    /**
     *
     */
    protected QName[] interfaceNames;
    /**
     *
     */
    protected QName serviceName;

    /**
     *
     * @return
     */
    public String getEndpointType()
    {
        return endpointType;
    }

    /**
     *
     * @param endpointType
     */
    public void setEndpointType(String endpointType)
    {
        this.endpointType = endpointType;
    }


    /**
     * This method returns a String representing the name of the deployed
     * ServiceUnit that this ServiceEndpoint belongs to.
     * @return
     */
    public String getServiceUnitName()
    {
        return serviceUnitName;
    }

    /**
     *
     * @param serviceUnitName
     */
    public void setServiceUnitName(String serviceUnitName)
    {
        this.serviceUnitName = serviceUnitName;
    }
    
    /**
     *
     * @param arg0
     * @return
     */
    @Override
    public DocumentFragment getAsReference(QName arg0)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     * @return
     */
    @Override
    public String getEndpointName()
    {
        return this.endpointName;
    }

    /**
     *
     * @param endpointName
     */
    public void setEndpointName(String endpointName)
    {
        this.endpointName = endpointName;
    }

    /**
     *
     * @return
     */
    @Override
    public QName[] getInterfaces()
    {
        return interfaceNames;
    }

    /**
     *
     * @param interfaceNames
     */
    public void setInterfaceNames(QName[] interfaceNames)
    {
        this.interfaceNames = interfaceNames;
    }

    /**
     *
     * @return
     */
    @Override
    public QName getServiceName()
    {
        return serviceName;
    }

    /**
     *
     * @param serviceName
     */
    public void setServiceName(QName serviceName)
    {
        this.serviceName = serviceName;
    }   

}
