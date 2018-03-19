package com.zttx.web.gen;

import com.zttx.web.gen.model.IModel;

/**
 * 提供模板数据模型
 * <p>File：IModelProvider.java</p>
 * <p>Title: IModelProvider</p>
 * <p>Description:IModelProvider</p>
 * @version 1.0
 */
public interface IModelProvider
{
    /**
     * 得到模板的数据模型
     * @return {@link IModel}
     * @throws Exception
     */
    public IModel getModel() throws Exception;
}
