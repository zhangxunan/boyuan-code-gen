package com.zttx.web.gen.model.java;

/**
 * 实体对象字段
 * <p>File：JavaClassField.java</p>
 * <p>Title: JavaClassField</p>
 * <p>Description:JavaClassField</p>
 * @version 1.0
 */
public class JavaClassField
{
    /**
     * 属性对应的JAVA类文件
     */
    private JavaClass classDto;
    
    /**
     * JAVA类型
     */
    private String    javaType;
    
    /**
     * 属性名称
     */
    private String    fieldName;
    
    public String getFieldName()
    {
        return fieldName;
    }
    
    public void setFieldName(String fieldName)
    {
        this.fieldName = fieldName;
    }
    
    public JavaClass getClassDto()
    {
        return classDto;
    }
    
    public void setClassDto(JavaClass classDto)
    {
        this.classDto = classDto;
    }
    
    public String getJavaType()
    {
        return javaType;
    }
    
    public void setJavaType(String javaType)
    {
        this.javaType = javaType;
    }
    
    public boolean getIsDateTimeField()
    {
        return javaType.equalsIgnoreCase("java.sql.Date") || javaType.equalsIgnoreCase("java.util.Date");
    }
}
