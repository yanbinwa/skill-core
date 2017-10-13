package com.emotibot.skill.core.event;

import java.util.concurrent.ConcurrentHashMap;

import com.emotibot.event.Event;

public abstract class AbstactEvent implements Event
{
    private static final String REQUEST_KEY  = "REQUEST";
    private static final String RESPONSE_KEY = "RESPONSE";
    
    private String uniqId = null;
    private ConcurrentHashMap<String, Object> headers = new ConcurrentHashMap<String, Object>();
    private byte[] body = new byte[0];
    
    public AbstactEvent()
    {
        uniqId = Thread.currentThread().getName() + System.currentTimeMillis();
    }
    
    public String getUniqId()
    {
        return this.uniqId;
    }
    
    public void setRequest(Object req) 
    {
        this.headers.put(REQUEST_KEY, req);
    }

    public Object getRequest() 
    {
        return  this.headers.get(REQUEST_KEY);
    }

    public void setResponse(Object res) 
    {
        this.headers.put(RESPONSE_KEY, res);
    }

    public Object getResponse() 
    {
        return this.headers.get(RESPONSE_KEY);
    }
    
    @Override
    public byte[] getBody()
    {
        return body;
    }

    @Override
    public ConcurrentHashMap<String, Object> getHeaders()
    {
        return headers;
    }

    @Override
    public void setBody(byte[] body)
    {
        this.body = body;
    }

    @Override
    public void setHeaders(ConcurrentHashMap<String, Object> headers)
    {
        this.headers = headers;
    }
}
