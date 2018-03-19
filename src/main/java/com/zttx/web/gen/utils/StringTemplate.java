package com.zttx.web.gen.utils;

import java.util.Iterator;
import java.util.Map;

/**
 * 替换字符串
 * <p>File：StringTemplate.java</p>
 * <p>Title: StringTemplate</p>
 * <p>Description:StringTemplate</p>
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
public class StringTemplate
{
    private String str;
    
    private Map    params;
    
    public StringTemplate(String str, Map params)
    {
        this.str = str;
        this.params = params;
    }
    
    @Override
    public String toString()
    {
        String result = str;
        for (Iterator it = params.entrySet().iterator(); it.hasNext();)
        {
            Map.Entry entry = (Map.Entry) it.next();
            String key = (String) entry.getKey();
            Object value = entry.getValue();
            String strValue = value == null ? "" : value.toString();
            result = StringHelper.replace(result, "${" + key + "}", strValue);
        }
        return result;
    }
}
