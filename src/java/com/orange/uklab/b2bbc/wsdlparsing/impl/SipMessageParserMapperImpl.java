/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.orange.uklab.b2bbc.wsdlparsing.impl;
import com.orange.uklab.b2bbc.runtime.contexts.RuntimeComponentContext;
import com.orange.uklab.b2bbc.wsdlparsing.SipMessageParserMapper;
import gov.nist.javax.sip.parser.*;
import gov.nist.javax.sip.parser.extensions.*;
import gov.nist.javax.sip.parser.ims.*;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 *
 * @author hasanein
 */
public class SipMessageParserMapperImpl implements SipMessageParserMapper
{
    private Logger logger = null;
    private HashMap<String, HeaderParser> headerParsersDb = null;

    /**
     *
     */
    public SipMessageParserMapperImpl()
    {
        initLogger();
    }

    private void initLogger()
    {
        RuntimeComponentContext runtimeComponentContext = RuntimeComponentContext.getInstance();
        logger = runtimeComponentContext.getLogger(this.getClass().getName(), null);
    }

    private void initSipHeaderMappingDB(String headerFieldTextContent)
    {
        /**
         * Initialize the mapping information between the Sip header field names
         * and their respective HeaderParsers. This is a static mapping and need
         * to be kept up to date.
         */
        headerParsersDb = new HashMap<String, HeaderParser>();
        /**
        * AcceptEncodingParser
        */
        AcceptEncodingParser acceptEncodingParser = new AcceptEncodingParser(headerFieldTextContent);
        headerParsersDb.put("Accept-Encoding", acceptEncodingParser);
        /**
        * AcceptLanguageParser
        */
        AcceptLanguageParser acceptLanguageParser = new AcceptLanguageParser(headerFieldTextContent);
        headerParsersDb.put("Accept-Language", acceptLanguageParser);
        /**
        * AllowEventsParser
        */
        AllowEventsParser allowEventsParser = new AllowEventsParser(headerFieldTextContent);
        headerParsersDb.put("Allow-Events", allowEventsParser);
        /**
        * AllowParser
        */
        AllowParser allowParser = new AllowParser(headerFieldTextContent);
        headerParsersDb.put("Allow", allowParser);
        /**
        * CallIDParser
        */
        CallIDParser callIDParser = new CallIDParser(headerFieldTextContent);
        headerParsersDb.put("Call-ID", callIDParser);
        /**
        * ChallengeParser
        */
//        ChallengeParser challengeParser = new ChallengeParser(headerFieldTextContent);
//        headerParsersDb.put("Challenge", challengeParser);
        /**
        * ContentEncodingParser
        */
        ContentEncodingParser contentEncodingParser = new ContentEncodingParser(headerFieldTextContent);
        headerParsersDb.put("Content-Encoding", contentEncodingParser);
        /**
        * ContentLanguageParser
        */
        ContentLanguageParser contentLanguageParser = new ContentLanguageParser(headerFieldTextContent);
        headerParsersDb.put("Content-Language", contentLanguageParser);
        /**
        * ContentLengthParser
        */
        ContentLengthParser contentLengthParser = new ContentLengthParser(headerFieldTextContent);
        headerParsersDb.put("Content-Length", contentLengthParser);
        /**
        * CSeqParser
        */
        CSeqParser cSeqParser = new CSeqParser(headerFieldTextContent);
        headerParsersDb.put("CSeq", cSeqParser);
        /**
        * DateParser
        */
        DateParser dateParser = new DateParser(headerFieldTextContent);
        headerParsersDb.put("Date", dateParser);
        /**
        * ExpiresParser
        */
        ExpiresParser expiresParser = new ExpiresParser(headerFieldTextContent);
        headerParsersDb.put("Expires", expiresParser);
        /**
        * InReplyToParser
        */
        InReplyToParser inReplyToParser = new InReplyToParser(headerFieldTextContent);
        headerParsersDb.put("In-Reply-To", inReplyToParser);
        /**
        * MaxForwardsParser
        */
        MaxForwardsParser maxForwardsParser = new MaxForwardsParser(headerFieldTextContent);
        headerParsersDb.put("Max-Forwards", maxForwardsParser);
        /**
        * MimeVersionParser
        */
        MimeVersionParser mimeVersionParser = new MimeVersionParser(headerFieldTextContent);
        headerParsersDb.put("Mime-Version", mimeVersionParser);
        /**
        * MinExpiresParser
        */
        MinExpiresParser minExpiresParser = new MinExpiresParser(headerFieldTextContent);
        headerParsersDb.put("Min-Expires", minExpiresParser);
        /**
        * OrganizationParser
        */
        OrganizationParser organizationParser = new OrganizationParser(headerFieldTextContent);
        headerParsersDb.put("Organization", organizationParser);
        /**
        * PAccessNetworkInfoParser
        */
        PAccessNetworkInfoParser pAccessNetworkInfoParser = new PAccessNetworkInfoParser(headerFieldTextContent);
        headerParsersDb.put("PAccess-Network-Info", pAccessNetworkInfoParser);
        /**
        * ParametersParser
        */
//        ParametersParser parametersParser = new ParametersParser(headerFieldTextContent);
//        headerParsersDb.put("Parameters", parametersParser);
        /**
        * PAssertedServiceParser
        */
        PAssertedServiceParser pAssertedServiceParser = new PAssertedServiceParser(headerFieldTextContent);
        headerParsersDb.put("PAsserted-Service", pAssertedServiceParser);
        /**
        * PMediaAuthorizationParser
        */
        PMediaAuthorizationParser pMediaAuthorizationParser = new PMediaAuthorizationParser(headerFieldTextContent);
        headerParsersDb.put("PMedia-Authorization", pMediaAuthorizationParser);
        /**
        * PPreferredServiceParser
        */
        PPreferredServiceParser pPreferredServiceParser = new PPreferredServiceParser(headerFieldTextContent);
        headerParsersDb.put("PPreferred-Service", pPreferredServiceParser);
        /**
        * PriorityParser
        */
        PriorityParser priorityParser = new PriorityParser(headerFieldTextContent);
        headerParsersDb.put("Priority", priorityParser);
        /**
        * PrivacyParser
        */
        PrivacyParser privacyParser = new PrivacyParser(headerFieldTextContent);
        headerParsersDb.put("Privacy", privacyParser);
        /**
        * ProxyRequireParser
        */
        ProxyRequireParser proxyRequireParser = new ProxyRequireParser(headerFieldTextContent);
        headerParsersDb.put("Proxy-Require", proxyRequireParser);
        /**
        * RAckParser
        */
        RAckParser rAckParser = new RAckParser(headerFieldTextContent);
        headerParsersDb.put("RAck", rAckParser);
        /**
        * RequireParser
        */
        RequireParser requireParser = new RequireParser(headerFieldTextContent);
        headerParsersDb.put("Require", requireParser);
        /**
        * RetryAfterParser
        */
        RetryAfterParser retryAfterParser = new RetryAfterParser(headerFieldTextContent);
        headerParsersDb.put("Retry-After", retryAfterParser);
        /**
        * RSeqParser
        */
        RSeqParser rSeqParser = new RSeqParser(headerFieldTextContent);
        headerParsersDb.put("RSeq", rSeqParser);
        /**
        * SecurityAgreeParser
        */
        SecurityAgreeParser securityAgreeParser = new SecurityAgreeParser(headerFieldTextContent);
        headerParsersDb.put("Security-Agree", securityAgreeParser);
        /**
        * ServerParser
        */
        ServerParser serverParser = new ServerParser(headerFieldTextContent);
        headerParsersDb.put("Server", serverParser);
        /**
        * SIPETagParser
        */
        SIPETagParser sIPETagParser = new SIPETagParser(headerFieldTextContent);
        headerParsersDb.put("SIPE-Tag", sIPETagParser);
        /**
        * SIPIfMatchParser
        */
        SIPIfMatchParser sIPIfMatchParser = new SIPIfMatchParser(headerFieldTextContent);
        headerParsersDb.put("SIP-If-Match", sIPIfMatchParser);
        /**
        * SubjectParser
        */
        SubjectParser subjectParser = new SubjectParser(headerFieldTextContent);
        headerParsersDb.put("Subject", subjectParser);
        /**
        * SubscriptionStateParser
        */
        SubscriptionStateParser subscriptionStateParser = new SubscriptionStateParser(headerFieldTextContent);
        headerParsersDb.put("Subscription-State", subscriptionStateParser);
        /**
        * SupportedParser
        */
        SupportedParser supportedParser = new SupportedParser(headerFieldTextContent);
        headerParsersDb.put("Supported", supportedParser);
        /**
        * TimeStampParser
        */
        TimeStampParser timeStampParser = new TimeStampParser(headerFieldTextContent);
        headerParsersDb.put("TimeStamp", timeStampParser);
        /**
        * UnsupportedParser
        */
        UnsupportedParser unsupportedParser = new UnsupportedParser(headerFieldTextContent);
        headerParsersDb.put("Unsupported", unsupportedParser);
        /**
        * UserAgentParser
        */
        UserAgentParser userAgentParser = new UserAgentParser(headerFieldTextContent);
        headerParsersDb.put("User-Agent", userAgentParser);
        /**
        * ViaParser
        */
        ViaParser viaParser = new ViaParser(headerFieldTextContent);
        headerParsersDb.put("Via", viaParser);
        /**
        * WarningParser
        */
        WarningParser warningParser = new WarningParser(headerFieldTextContent);
        headerParsersDb.put("Warning", warningParser);
        /**
        * ContactParser
        */
        ContactParser contactParser = new ContactParser(headerFieldTextContent);
        headerParsersDb.put("Contact", contactParser);
        /**
        * FromParser
        */
        FromParser fromParser = new FromParser(headerFieldTextContent);
        headerParsersDb.put("From", fromParser);
        /**
        * PAssertedIdentityParser
        */
        PAssertedIdentityParser pAssertedIdentityParser = new PAssertedIdentityParser(headerFieldTextContent);
        headerParsersDb.put("PAsserted-Identity", pAssertedIdentityParser);
        /**
        * PAssociatedURIParser
        */
        PAssociatedURIParser pAssociatedURIParser = new PAssociatedURIParser(headerFieldTextContent);
        headerParsersDb.put("PAssociated-URI", pAssociatedURIParser);
        /**
        * PathParser
        */
        PathParser pathParser = new PathParser(headerFieldTextContent);
        headerParsersDb.put("Path", pathParser);
        /**
        * PCalledPartyIDParser
        */
        PCalledPartyIDParser pCalledPartyIDParser = new PCalledPartyIDParser(headerFieldTextContent);
        headerParsersDb.put("PCalledPartyID", pCalledPartyIDParser);
        /**
        * PPreferredIdentityParser
        */
        PPreferredIdentityParser pPreferredIdentityParser = new PPreferredIdentityParser(headerFieldTextContent);
        headerParsersDb.put("PPreferred-Identity", pPreferredIdentityParser);
        /**
        * PProfileKeyParser
        */
        PProfileKeyParser pProfileKeyParser = new PProfileKeyParser(headerFieldTextContent);
        headerParsersDb.put("PProfile-Key", pProfileKeyParser);
        /**
        * RecordRouteParser
        */
        RecordRouteParser recordRouteParser = new RecordRouteParser(headerFieldTextContent);
        headerParsersDb.put("Record-Route", recordRouteParser);
        /**
        * ReferredByParser
        */
        ReferredByParser referredByParser = new ReferredByParser(headerFieldTextContent);
        headerParsersDb.put("Referred-By", referredByParser);
        /**
        * ReferToParser
        */
        ReferToParser referToParser = new ReferToParser(headerFieldTextContent);
        headerParsersDb.put("Refer-To", referToParser);
        /**
        * ReplyToParser
        */
        ReplyToParser replyToParser = new ReplyToParser(headerFieldTextContent);
        headerParsersDb.put("Reply-To", replyToParser);
        /**
        * RouteParser
        */
        RouteParser routeParser = new RouteParser(headerFieldTextContent);
        headerParsersDb.put("Route", routeParser);
        /**
        * ServiceRouteParser
        */
        ServiceRouteParser serviceRouteParser = new ServiceRouteParser(headerFieldTextContent);
        headerParsersDb.put("Service-Route", serviceRouteParser);
        /**
        * ToParser
        */
        ToParser toParser = new ToParser(headerFieldTextContent);
        headerParsersDb.put("To", toParser);
        /**
        * AcceptParser
        */
        AcceptParser acceptParser = new AcceptParser(headerFieldTextContent);
        headerParsersDb.put("Accept", acceptParser);
        /**
        * AddressParametersParser
        */
//        AddressParametersParser addressParametersParser = new AddressParametersParser(headerFieldTextContent);
//        headerParsersDb.put("AddressParameters", addressParametersParser);
        /**
        * AlertInfoParser
        */
        AlertInfoParser alertInfoParser = new AlertInfoParser(headerFieldTextContent);
        headerParsersDb.put("Alert-Info", alertInfoParser);
        /**
        * AuthenticationInfoParser
        */
        AuthenticationInfoParser authenticationInfoParser = new AuthenticationInfoParser(headerFieldTextContent);
        headerParsersDb.put("Authentication-Info", authenticationInfoParser);
        /**
        * CallInfoParser
        */
        CallInfoParser callInfoParser = new CallInfoParser(headerFieldTextContent);
        headerParsersDb.put("Call-Info", callInfoParser);
        /**
        * ContentDispositionParser
        */
        ContentDispositionParser contentDispositionParser = new ContentDispositionParser(headerFieldTextContent);
        headerParsersDb.put("Content-Disposition", contentDispositionParser);
        /**
        * ContentTypeParser
        */
        ContentTypeParser contentTypeParser = new ContentTypeParser(headerFieldTextContent);
        headerParsersDb.put("Content-Type", contentTypeParser);
        /**
        * ErrorInfoParser
        */
        ErrorInfoParser errorInfoParser = new ErrorInfoParser(headerFieldTextContent);
        headerParsersDb.put("Error-Info", errorInfoParser);
        /**
        * EventParser
        */
        EventParser eventParser = new EventParser(headerFieldTextContent);
        headerParsersDb.put("Event", eventParser);
        /**
        * JoinParser
        */
        JoinParser joinParser = new JoinParser(headerFieldTextContent);
        headerParsersDb.put("Join", joinParser);
        /**
        * MinSEParser
        */
        MinSEParser minSEParser = new MinSEParser(headerFieldTextContent);
        headerParsersDb.put("MinSE", minSEParser);
        /**
        * PChargingFunctionAddressesParser
        */
        PChargingFunctionAddressesParser pChargingFunctionAddressesParser = new PChargingFunctionAddressesParser(headerFieldTextContent);
        headerParsersDb.put("PCharging-Function-Addresses", pChargingFunctionAddressesParser);
        /**
        * PChargingVectorParser
        */
        PChargingVectorParser pChargingVectorParser = new PChargingVectorParser(headerFieldTextContent);
        headerParsersDb.put("PCharging-Vector", pChargingVectorParser);
        /**
        * PServedUserParser
        */
        PServedUserParser pServedUserParser = new PServedUserParser(headerFieldTextContent);
        headerParsersDb.put("PServed-User", pServedUserParser);
        /**
        * PUserDatabaseParser
        */
        PUserDatabaseParser pUserDatabaseParser = new PUserDatabaseParser(headerFieldTextContent);
        headerParsersDb.put("PUser-Database", pUserDatabaseParser);
        /**
        * PVisitedNetworkIDParser
        */
        PVisitedNetworkIDParser pVisitedNetworkIDParser = new PVisitedNetworkIDParser(headerFieldTextContent);
        headerParsersDb.put("PVisited-Network-ID", pVisitedNetworkIDParser);
        /**
        * ReasonParser
        */
        ReasonParser reasonParser = new ReasonParser(headerFieldTextContent);
        headerParsersDb.put("Reason", reasonParser);
        /**
        * ReferencesParser
        */
        ReferencesParser referencesParser = new ReferencesParser(headerFieldTextContent);
        headerParsersDb.put("References", referencesParser);
        /**
        * ReplacesParser
        */
        ReplacesParser replacesParser = new ReplacesParser(headerFieldTextContent);
        headerParsersDb.put("Replaces", replacesParser);
        /**
        * SessionExpiresParser
        */
        SessionExpiresParser sessionExpiresParser = new SessionExpiresParser(headerFieldTextContent);
        headerParsersDb.put("Session-Expires", sessionExpiresParser);
    }

    /**
     *
     * @param headerFieldName
     * @param headerFieldTextContent
     * @return
     */
    @Override
    public HeaderParser mapHeaderFieldName(String headerFieldName, String headerFieldTextContent)
    {
        initSipHeaderMappingDB(headerFieldTextContent);
        HeaderParser headerParser = headerParsersDb.get(headerFieldName);
        return headerParser;
    }
}
