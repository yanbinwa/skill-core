package com.emotibot.skill.core.module;

import java.util.List;
import java.util.concurrent.Future;

import com.emotibot.event.Event;

public abstract class BaseModule 
{    
    private int timeout;
    private List<BaseModule> modules;
    public abstract  void initialize();
    public abstract Future<Event> process(Event evt);
    public abstract List<Event> process(List<Event> events);
    public abstract void close();
    
    public List<BaseModule> getModules() 
    {
        return modules;
    }
    
    public void setModules(List<BaseModule> modules) 
    {
        this.modules = modules;
    }
    
    public int getTimeout() 
    {
        return timeout;
    }
    
    public void setTimeout(int timeout) 
    {
        this.timeout = timeout;
    }
}