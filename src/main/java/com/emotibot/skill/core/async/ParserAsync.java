package com.emotibot.skill.core.async;

import java.util.concurrent.Future;

import com.emotibot.event.Event;
import com.emotibot.skill.core.module.BaseModule;

public class ParserAsync 
{
    private static ParserAsync instance = null;
    
    public static ParserAsync getInstance()
    {
        if(instance == null)
        {
            instance = new ParserAsync();
        }
        return instance;
    }
    
    private ParserAsync()
    {
        
    }  
    
    public Future<Event> handlerAsync(BaseModule module, Event event)
    {
        return module.process(event);
    }
}
