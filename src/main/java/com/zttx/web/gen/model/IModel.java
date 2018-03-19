package com.zttx.web.gen.model;

import java.util.Map;

/**
 * 模板数据模型
 * <p>File：IModel.java</p>
 * <p>Title: IModel</p>
 * <p>Description:IModel</p>
 * @version 1.0
 */
public interface IModel
{
    /**
     * 获取描述信息
     * @return
     */
    String getDisplayDescription();
    
    /**
     * 为模板路径提供数据
     * @param fileModel
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    void mergeFilePathModel(Map fileModel) throws Exception;
    
    /**
     * 获取模型名称
     * @return
     */
    String getTemplateModelName();
}
