package com.zttx.web.gen.model.java;

/**
 * 方法参数对象
 * <p>File：MethodParameter.java</p>
 * <p>Title: MethodParameter</p>
 * <p>Description:MethodParameter</p>
 * @version 1.0
 */
public class MethodParameter
{
    /**
     * 实体对象中的GET/SET方法
     */
    private JavaMethod method;
    
    /**
     * 参数类型
     */
    private String     javaType;
    
    /**
     * 方法名称
     */
    private String     name;
    
    public JavaMethod getMethod()
    {
        return method;
    }
    
    public void setMethod(JavaMethod method)
    {
        this.method = method;
    }
    
    public String getJavaType()
    {
        return javaType;
    }
    
    public void setJavaType(String javaType)
    {
        this.javaType = javaType;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
}
