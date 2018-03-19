package com.zttx.web.gen.provider;

import com.zttx.web.gen.IModelProvider;
import com.zttx.web.gen.model.IModel;

/**
 * 数据库表模型的实现类
 * <p>File：DbTableProvider.java</p>
 * <p>Title: DbTableProvider</p>
 * <p>Description:DbTableProvider</p>
 * @version 1.0
 */
public class DbTableProvider implements IModelProvider
{
    /**
     * 表名
     */
    private String dbTableName;
    
    public DbTableProvider(String dbTableName)
    {
        super();
        this.dbTableName = dbTableName;
    }
    
    public IModel getModel() throws Exception
    {
        return DbModelHelper.getInstance().getTable(dbTableName);
    }
}
