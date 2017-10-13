package com.emotibot.skill.core.response;

import java.util.Map;

import com.emotibot.middleware.utils.JsonUtils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataElement
{
    @SerializedName("domain")
    @Expose
    private String domain;
    
    @SerializedName("cmd")
    @Expose
    private String cmd;
    
    @SerializedName("batch")
    @Expose
    private int batch = 0;
    
    @SerializedName("params")
    @Expose
    private Map<String, Object> params;
    
    public void setDomain(String domain)
    {
        this.domain = domain;
    }
    
    public String getDomain()
    {
        return domain;
    }
    
    public void setCmd(String cmd)
    {
        this.cmd = cmd;
    }
    
    public String getCmd()
    {
        return this.cmd;
    }
    
    public void setBatch(int batch)
    {
        this.batch = batch;
    }
    
    public int getBatch()
    {
        return this.batch;
    }
    
    public void setParams(Map<String, Object> params)
    {
        this.params = params;
    }
    
    public Map<String, Object> getParams()
    {
        return this.params;
    }
    
    @Override
    public String toString()
    {
        return JsonUtils.getJsonStr(this);
    }
}
