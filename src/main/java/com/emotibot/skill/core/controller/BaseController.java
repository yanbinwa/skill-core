package com.emotibot.skill.core.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;

import com.emotibot.event.Event;
import com.emotibot.skill.core.async.ParserAsync;
import com.emotibot.skill.core.module.BaseModule;

public class BaseController 
{
    private static final Logger logger = Logger.getLogger(BaseController.class);
    
    public void handler(BaseModule parentModule, Event event)
    {
        long start = System.currentTimeMillis();
        List<BaseModule> modules = parentModule.getModules();
        List<Future<Event>> tasks = new ArrayList<Future<Event>>();
        ParserAsync aysnc = ParserAsync.getInstance();
        
        if (modules == null)
        {
            modules = new ArrayList<BaseModule>();
        }
        
        for(BaseModule module:modules)
        {
            module.initialize();
        }
        
        for(BaseModule module:modules)
        {
            Future<Event> task = aysnc.handlerAsync(module, event);
            tasks.add(task);
        }
        
        boolean wait = !allDone(tasks);
        while(wait)
        {
            wait = !allDone(tasks);
        }
        
        Future<Event> videoTask = aysnc.handlerAsync(parentModule, event);
        wait = !videoTask.isDone();
        while(wait)
        {
            wait = !videoTask.isDone();
        }
        long end = System.currentTimeMillis();
        logger.debug(parentModule.getClass().getSimpleName() + "耗时：" + (end - start) + "毫秒");
    }
    
    /**
     * 这里需要超时设置
     * 
     * @param tasks
     * @return
     */
    private boolean allDone(List<Future<Event>> tasks)
    {
        boolean allOver = true;
        for(Future<Event> task:tasks)
        {
            if(!task.isDone())
            {
                allOver = false;
            }
        }
        return allOver;
    }
}