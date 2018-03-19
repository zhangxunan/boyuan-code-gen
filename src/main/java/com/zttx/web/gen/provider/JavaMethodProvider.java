package com.zttx.web.gen.provider;

import com.zttx.web.gen.IModelProvider;
import com.zttx.web.gen.model.IModel;

/**
 * 实体类中方法的实现
 * <p>File：JavaMethodProvider.java</p>
 * <p>Title: JavaMethodProvider</p>
 * <p>Description:JavaMethodProvider</p>
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
public class JavaMethodProvider implements IModelProvider
{
    private String methodName;
    
    private Class  clazz;
    
    public JavaMethodProvider(Class clazz, String methodName)
    {
        super();
        this.clazz = clazz;
        this.methodName = methodName;
    }
    
    public IModel getModel()
    {
        return JavaModelHelper.getInstance().createJavaMethod(clazz, methodName);
    }
}
