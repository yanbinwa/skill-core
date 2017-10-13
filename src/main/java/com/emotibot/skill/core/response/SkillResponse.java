package com.emotibot.skill.core.response;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SkillResponse
{
    @SerializedName("status")
    @Expose
    private int status = -1;
    
    @SerializedName("error_message")
    @Expose
    private String error_message = "";
    
    @SerializedName("datas")
    @Expose
    private List<DataElement> datas = null;
    
    public void setStatus(int status)
    {
        this.status = status;
    }
    
    public int getStatus()
    {
        return this.status;
    }
    
    public void setError_message(String error_message)
    {
        this.error_message = error_message;
    }
    
    public String getError_message()
    {
        return this.error_message;
    }
    
    public void setDatas(List<DataElement> datas)
    {
        this.datas = datas;
    }
    
    public List<DataElement> getDatas()
    {
        return this.datas;
    }
}
