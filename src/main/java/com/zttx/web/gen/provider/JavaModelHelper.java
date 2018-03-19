package com.zttx.web.gen.provider;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.zttx.web.gen.model.java.JavaClass;
import com.zttx.web.gen.model.java.JavaClassField;
import com.zttx.web.gen.model.java.JavaMethod;
import com.zttx.web.gen.model.java.MethodParameter;

/**
 * 实体对象反射工具
 * <p>File：JavaModelHelper.java</p>
 * <p>Title: JavaModelHelper</p>
 * <p>Description:JavaModelHelper</p>
 * @version 1.0
 */
public class JavaModelHelper
{
    /**
     * 单例对象
     */
    private static JavaModelHelper instance = new JavaModelHelper();
    
    private JavaModelHelper()
    {
    }
    
    public static JavaModelHelper getInstance()
    {
        return instance;
    }
    
    /**
     * 生成JAVA类
     * 
     * @param clazz
     * @return {@link JavaClass}
     */
    @SuppressWarnings("rawtypes")
    public JavaClass createJaveClass(Class clazz)
    {
        JavaClass javaClass = new JavaClass();
        javaClass.setClassName(clazz.getSimpleName());
        javaClass.setPackageName(clazz.getPackage().getName());
        if (clazz.getSuperclass() != null)
        {
            javaClass.setSuperclassName(clazz.getSuperclass().getName());
        }
        List<JavaClassField> javaClassFields = getJaveClassFields(javaClass, clazz);
        javaClass.setFields(javaClassFields);
        List<JavaMethod> javaMethods = getJaveClassMethod(javaClass, clazz);
        javaClass.setMethods(javaMethods);
        return javaClass;
    }
    
    /**
     * 生成JAVA方法
     * 
     * @param cl
     * @param method
     * @return {@link JavaMethod}
     */
    @SuppressWarnings("rawtypes")
    public JavaMethod createJavaMethod(Class cl, String method)
    {
        JavaClass clazz = createJaveClass(cl);
        for (JavaMethod m : clazz.getMethods())
        {
            if (m.getMethodName().equals(method)) { return m; }
        }
        throw new RuntimeException("not found method:" + method);
    }
    
    /**
     * 生成JAVA属性
     * 
     * @param javaClass
     * @param pojo
     * @return {@link List}
     */
    @SuppressWarnings("rawtypes")
    private List<JavaClassField> getJaveClassFields(JavaClass javaClass, Class pojo)
    {
        List<JavaClassField> javaClassFields = new ArrayList<JavaClassField>();
        Field[] fields = pojo.getDeclaredFields();
        for (Field f : fields)
        {
            JavaClassField javaClassField = new JavaClassField();
            javaClassField.setClassDto(javaClass);
            javaClassField.setFieldName(f.getName());
            javaClassField.setJavaType(f.getType().getName());
            javaClassFields.add(javaClassField);
        }
        return javaClassFields;
    }
    
    /**
     * 取得JAVA方法
     * 
     * @param javaClass
     * @param cl
     * @return {@link List}
     */
    @SuppressWarnings("rawtypes")
    private List<JavaMethod> getJaveClassMethod(JavaClass javaClass, Class cl)
    {
        List<JavaMethod> javaMethods = new ArrayList<JavaMethod>();
        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods)
        {
            JavaMethod javaMethod = new JavaMethod();
            javaMethod.setMethodName(method.getName());
            javaMethod.setClazz(javaClass);
            MethodParameter returnValue = new MethodParameter();
            returnValue.setMethod(javaMethod);
            returnValue.setName("returnValue");
            returnValue.setJavaType(method.getReturnType().getName());
            javaMethod.setReturnType(returnValue);
            List<MethodParameter> parameters = getJavaClassField(javaMethod, method);
            javaMethod.setParameters(parameters);
            javaMethods.add(javaMethod);
        }
        return javaMethods;
    }
    
    /**
     * 取得JAVA属性
     * 
     * @param javaMethod
     * @param method
     * @return {@link List}
     */
    @SuppressWarnings("rawtypes")
    private List<MethodParameter> getJavaClassField(JavaMethod javaMethod, Method method)
    {
        List<MethodParameter> javaClassFields = new ArrayList<MethodParameter>();
        Class[] parameterTypes = method.getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++)
        {
            Class cl = parameterTypes[i];
            MethodParameter methodParameter = new MethodParameter();
            methodParameter.setMethod(javaMethod);
            methodParameter.setJavaType(cl.getName());
            methodParameter.setName("param" + i);
            javaClassFields.add(methodParameter);
        }
        return javaClassFields;
    }
}
