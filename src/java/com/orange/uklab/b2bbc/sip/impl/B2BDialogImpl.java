/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.orange.uklab.b2bbc.sip.impl;
import com.orange.uklab.b2bbc.sip.B2BDialog;
import gov.nist.javax.sip.header.RecordRouteList;
import java.util.Date;
import java.util.HashMap;
import javax.sip.Dialog;
import javax.sip.address.SipURI;

/**
 *
 * @author hasanein
 */
public class B2BDialogImpl implements B2BDialog
{
    private String callId = null;
    private String remoteTag = null;
    private String localTag = null;
    private SipURI localUri = null;
    private SipURI remoteUri = null;
    private RecordRouteList routeSet = null;
    private String b2bDialogState = null;
    private HashMap<String, Object> attributes = new HashMap<String, Object>();
    private Date creationTime = null;
    private long localSeqNumber = 0;
    private long remoteSeqNumber = 0;
    private boolean secure = false;
    private SipURI remoteTarget = null;
    private String b2bSessionId = null;
    private String dialogId = null;
    private Dialog underlyingSipDialog = null;


    public Dialog getUnderlyingSipDialog()
    {
        return underlyingSipDialog;
    }

    public void setUnderlyingSipDialog(Dialog underlyingSipDialog)
    {
        this.underlyingSipDialog = underlyingSipDialog;
    }

    public void setDialogId(String dialogId)
    {
        this.dialogId = dialogId;
    }

    public String getDialogId()
    {
        return dialogId;
    }

    @Override
    public String getCallId()
    {
        return callId;
    }

    @Override
    public void setCallId(String callId)
    {
        this.callId = callId;
    }

    @Override
    public String getRemoteTag()
    {
        return remoteTag;
    }

    @Override
    public void setRemoteTag(String remoteTag)
    {
        this.remoteTag = remoteTag;
    }

    @Override
    public String getLocalTag()
    {
        return localTag;
    }

    @Override
    public void setLocalTag(String localTag)
    {
        this.localTag = localTag;
    }

    @Override
    public SipURI getLocalUri()
    {
        return localUri;
    }

    @Override
    public void setLocalUri(SipURI sipURI)
    {
        this.localUri = sipURI;
    }

    @Override
    public SipURI getRemoteUri()
    {
        return remoteUri;
    }

    @Override
    public void setRemoteUri(SipURI sipURI)
    {
        this.remoteUri = sipURI;
    }

    @Override
    public RecordRouteList getRouteSet()
    {
        return routeSet;
    }

    @Override
    public void setRouteSet(RecordRouteList routeSet)
    {
        this.routeSet = routeSet;
    }

    @Override
    public String getB2BSessionID()
    {
        return b2bSessionId;
    }

    @Override
    public void setB2BSessionID(String b2bSessionId)
    {
        this.b2bSessionId = b2bSessionId;
    }

    @Override
    public String getState()
    {
        return b2bDialogState;
    }

    @Override
    public void setState(String state)
    {
        this.b2bDialogState = state;
    }

    @Override
    public Object getAttribute(String attributeName)
    {
        return attributes.get(attributeName);
    }

    @Override
    public void setAttribute(String attributeName, Object attribute)
    {
        attributes.put(attributeName, attribute);
    }

    @Override
    public Date getCreationTime()
    {
        return creationTime;
    }

    @Override
    public void setCreationTime(Date creationTime)
    {
        this.creationTime = creationTime;
    }

    @Override
    public long getLocalSeqNumber()
    {
        return localSeqNumber;
    }

    @Override
    public void setLocalSeqNumber(long localSeqNumber)
    {
        this.localSeqNumber = localSeqNumber;
    }

    @Override
    public long getRemoteSeqNumber()
    {
        return remoteSeqNumber;
    }

    @Override
    public void setRemoteSeqNumber(long remoteSeqNumber)
    {
        this.remoteSeqNumber = remoteSeqNumber;
    }

    @Override
    public boolean isSecure()
    {
        return secure;
    }

    @Override
    public void setSecure(boolean secureFlag)
    {
        this.secure = secureFlag;
    }

    @Override
    public SipURI getRemoteTarget()
    {
        return remoteTarget;
    }

    @Override
    public void setRemoteTarget(SipURI remoteTarget)
    {
        this.remoteTarget = remoteTarget;
    }
}
