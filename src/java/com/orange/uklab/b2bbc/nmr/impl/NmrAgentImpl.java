package com.orange.uklab.b2bbc.nmr.impl;

import com.orange.uklab.b2bbc.nmr.NmrAgent;
import com.orange.uklab.b2bbc.runtime.contexts.RuntimeComponentContext;
import java.util.logging.Logger;
import javax.jbi.JBIException;
import javax.jbi.component.ComponentContext;
import javax.jbi.messaging.DeliveryChannel;
import javax.jbi.messaging.InOnly;
import javax.jbi.messaging.MessageExchangeFactory;
import javax.jbi.messaging.NormalizedMessage;
import javax.jbi.servicedesc.ServiceEndpoint;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;

/**
 *
 * @author hasanein
 */
public class NmrAgentImpl implements NmrAgent
{
    private Logger logger = null;
    private RuntimeComponentContext runtimeComponentContext = null;

    /**
     *
     */
    /**
     *
     */
    public NmrAgentImpl()
    {
        this.runtimeComponentContext = RuntimeComponentContext.getInstance();
        this.initLogger();
    }

    /**
     *
     * @param serviceEndpoint
     * @throws JBIException
     */
    /**
     *
     * @param serviceEndpoint
     * @throws JBIException
     */
    @Override
    public void activateServiceEndpoint(ServiceEndpoint serviceEndpoint) throws JBIException
    {
        ComponentContext componentContext = runtimeComponentContext.getComponentContext();
        if(serviceEndpoint != null)
        {
            QName serviceName = serviceEndpoint.getServiceName();
            String endpointName = serviceEndpoint.getEndpointName();
            componentContext.activateEndpoint(serviceName, endpointName);
            logger.info(this.getClass().getName() + ".activateServiceEndpoint(): Activating ServiceEndpoint: {" + serviceName.toString() + "}" + endpointName);
        }
        else
        {
            logger.info(this.getClass().getName() + ".activateServiceEndpoint(): The passed in ServiceEndpoint is null");
        }
    }

    /**
     *
     * @param serviceEndpoint
     * @throws JBIException
     */
    /**
     *
     * @param serviceEndpoint
     * @throws JBIException
     */
    @Override
    public void deActivateServiceEndpoint(ServiceEndpoint serviceEndpoint) throws JBIException
    {
        ComponentContext componentContext = runtimeComponentContext.getComponentContext();
        if(serviceEndpoint != null)
        {
            QName serviceName = serviceEndpoint.getServiceName();
            String endpointName = serviceEndpoint.getEndpointName();
            /**
             * Need to query the JBI framework for the RegisteredEndpoint for the
             * given serviceName and endpointName and then use the obtained
             * ServiceEndpoint as an argument to the DeActivation method.
             */
            ServiceEndpoint registeredServiceEndpoint = componentContext.getEndpoint(serviceName, endpointName);
            if(registeredServiceEndpoint != null)
            {
                /**
                 * DEBUG: USING REFLECTION TO GET THE RUNTIME TYPE OF THE registeredServiceEndpoint
                 */
                logger.severe("DEBUG: " + registeredServiceEndpoint.getClass().getName());
                componentContext.deactivateEndpoint(registeredServiceEndpoint);
                logger.info(this.getClass().getName() + ".deActivateServiceEndpoint(): DeActivating ServiceEndpoint: {" + serviceName.toString() + "}" + endpointName);
            }            
        }
        else
        {
            logger.info(this.getClass().getName() + ".deActivateServiceEndpoint(): The passed in ServiceEndpoint is null");
        }
    }

    private void initLogger()
    {
        this.logger = runtimeComponentContext.getLogger(NmrAgentImpl.class.getName(), null);
    }

    /**
     *
     * @param normalizedMessageContent
     * @param serviceEndpoint
     */
    /**
     *
     * @param normalizedMessageContent
     * @param serviceEndpoint
     */
    @Override
    public void sendNormalizedMessage(Source normalizedMessageContent, ServiceEndpoint serviceEndpoint, Object messageContent)
    {
        logger.info("Normalized Message received, getting ready to sent it to the NMR...");
        try
        {
            /**
             * We need to make sure that the ServiceEndpoint that this NM need to be sent to
             * is currently defined with the JBI, this need to be done by querying the JBI for
             * the given ServiceEndpoint
             */
            ServiceEndpoint[] serviceEndpoints = runtimeComponentContext.getComponentContext().getEndpointsForService(serviceEndpoint.getServiceName());

            if(serviceEndpoints != null)
            {
                logger.info("SIZE: "+ serviceEndpoints.length );
                if(serviceEndpoints.length == 0)
                {
                    logger.severe("No ServiceEndpoints defined with the JBI with the following parameters:");
                    logger.info("ServiceEndpoint Name: " + serviceEndpoint.getEndpointName());
                    logger.info("ServiceEndpoint Service Name: " + serviceEndpoint.getServiceName());
                    logger.severe("Discarding the received NMR messages...");
                }
                else
                {
                    logger.fine("ServiceEndpoint located. Sending a Normalized Message...");
                    /**
                     * Get the delivery channel
                     */
                    DeliveryChannel deliveryChannel = runtimeComponentContext.getDeliveryChannel();
                    /**
                     * Get a MessageExchange and address it to the appropriate ServiceEndpoint
                     * The component only supports In-Only message exchanges
                     */
                    MessageExchangeFactory messageExchangeFactory = deliveryChannel.createExchangeFactoryForService(serviceEndpoint.getServiceName());
                    InOnly inOnlyMessageExchange = messageExchangeFactory.createInOnlyExchange();
                    /**
                     * Create a normalized message and set it in the MessageExchange
                     */
                    NormalizedMessage normalizedMessage = inOnlyMessageExchange.createMessage();
                    normalizedMessage.setContent(normalizedMessageContent);

                    /**
                     * Set the sipMessageContent as an attribute with a pre
                     * defined name inside the NormalizedMessage
                     */
                    if(messageContent != null)
                    {
                        normalizedMessage.setProperty("com.orange.uklab.b2bbc.SIP_MESSAGE_PAYLOAD", messageContent);
                    }

                    inOnlyMessageExchange.setInMessage(normalizedMessage);
                    deliveryChannel.send(inOnlyMessageExchange);                    
                    logger.info("Normalized Message has been sent to the following ServiceEndpoint: " + serviceEndpoint.getEndpointName());
                }
            }
            else
            {
                logger.severe("Querying the JBI for ServiceEndpoint \"" + serviceEndpoint.getEndpointName() + "\" resulted in a NULL response");
            }
        }
        catch (Exception ex)
        {
            logger.severe(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
