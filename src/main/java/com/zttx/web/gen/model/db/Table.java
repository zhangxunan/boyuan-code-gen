package com.zttx.web.gen.model.db;

import java.lang.reflect.InvocationTargetException;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.zttx.web.gen.model.IModel;
import com.zttx.web.gen.provider.DbModelHelper;
import com.zttx.web.gen.utils.StringHelper;

/**
 * 数据库表模型
 * <p>File：Table.java</p>
 * <p>Title: Table</p>
 * <p>Description:Table</p>
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
public class Table implements IModel
{
    public static final String PKTABLE_NAME      = "PKTABLE_NAME";
    
    public static final String PKCOLUMN_NAME     = "PKCOLUMN_NAME";
    
    public static final String FKTABLE_NAME      = "FKTABLE_NAME";
    
    public static final String FKCOLUMN_NAME     = "FKCOLUMN_NAME";
    
    public static final String KEY_SEQ           = "KEY_SEQ";
    
    // SQL名
    String                     sqlName;
    
    // 备注
    String                     sqlRemark;
    
    // 类名
    String                     className;
    
    // 属性集
    List                       columns           = new ArrayList();
    
    // 主键集
    List                       primaryKeyColumns = new ArrayList();
    
    String                     catalog           = DbModelHelper.getInstance().catalog;
    
    String                     schema            = DbModelHelper.getInstance().schema;
    
    // 用户名
    private String             ownerName         = null;
    
    private ForeignKeys        exportedKeys;
    
    private ForeignKeys        importedKeys;
    
    public String getDisplayDescription()
    {
        return getSqlName();
    }
    
    public String getClassName()
    {
        return className == null ? StringHelper.makeAllWordFirstLetterUpperCase(getSqlName()) : className;
    }
    
    public void setClassName(String className)
    {
        this.className = className;
    }
    
    public String getClassNameLower()
    {
        return StringHelper.makeWordFirstLetterLowerCase(getClassName());
    }
    
    public List getColumns()
    {
        return columns;
    }
    
    public void setColumns(List columns)
    {
        this.columns = columns;
    }
    
    public String getOwnerName()
    {
        return ownerName;
    }
    
    public void setOwnerName(String ownerName)
    {
        this.ownerName = ownerName;
    }
    
    public List getPrimaryKeyColumns()
    {
        return primaryKeyColumns;
    }
    
    public void setPrimaryKeyColumns(List primaryKeyColumns)
    {
        this.primaryKeyColumns = primaryKeyColumns;
    }
    
    public String getSqlName()
    {
        return sqlName;
    }
    
    public void setSqlName(String sqlName)
    {
        this.sqlName = sqlName;
    }
    
    public String getSqlRemark()
    {
        if (null != sqlRemark && sqlRemark.length() > 0) return sqlRemark;
        return sqlName;
    }
    
    public void setSqlRemark(String sqlRemark)
    {
        this.sqlRemark = sqlRemark;
    }
    
    @SuppressWarnings("unchecked")
    public void addColumn(Column column)
    {
        columns.add(column);
    }
    
    public boolean isSingleId()
    {
        int pkCount = 0;
        for (int i = 0; i < columns.size(); i++)
        {
            Column c = (Column) columns.get(i);
            if (c.isPk())
            {
                pkCount++;
            }
        }
        return pkCount > 1 ? false : true;
    }
    
    public boolean isCompositeId()
    {
        return !isSingleId();
    }
    
    @SuppressWarnings("unchecked")
    public List getCompositeIdColumns()
    {
        List results = new ArrayList();
        List columns = getColumns();
        for (int i = 0; i < columns.size(); i++)
        {
            Column c = (Column) columns.get(i);
            if (c.isPk())
            {
                results.add(c);
            }
        }
        return results;
    }
    
    public Column getIdColumn()
    {
        List columns = getColumns();
        for (int i = 0; i < columns.size(); i++)
        {
            Column c = (Column) columns.get(i);
            if (c.isPk()) { return c; }
        }
        return null;
    }
    
    public void initImportedKeys(DatabaseMetaData dbmd) throws java.sql.SQLException
    {
        ResultSet fkeys = dbmd.getImportedKeys(catalog, schema, this.sqlName);
        while (fkeys.next())
        {
            String pktable = fkeys.getString(PKTABLE_NAME);
            String pkcol = fkeys.getString(PKCOLUMN_NAME);
            String fkcol = fkeys.getString(FKCOLUMN_NAME);
            String seq = fkeys.getString(KEY_SEQ);
            Integer iseq = new Integer(seq);
            getImportedKeys().addForeignKey(pktable, pkcol, fkcol, iseq);
        }
        fkeys.close();
    }
    
    /**
     * This method was created in VisualAge.
     */
    public void initExportedKeys(DatabaseMetaData dbmd) throws java.sql.SQLException
    {
        ResultSet fkeys = dbmd.getExportedKeys(catalog, schema, this.sqlName);
        while (fkeys.next())
        {
            String pkcol = fkeys.getString(PKCOLUMN_NAME);
            String fktable = fkeys.getString(FKTABLE_NAME);
            String fkcol = fkeys.getString(FKCOLUMN_NAME);
            String seq = fkeys.getString(KEY_SEQ);
            Integer iseq = new Integer(seq);
            getExportedKeys().addForeignKey(fktable, fkcol, pkcol, iseq);
        }
        fkeys.close();
    }
    
    /**
     * @return Returns the exportedKeys.
     */
    public ForeignKeys getExportedKeys()
    {
        if (exportedKeys == null)
        {
            exportedKeys = new ForeignKeys(this);
        }
        return exportedKeys;
    }
    
    /**
     * @return Returns the importedKeys.
     */
    public ForeignKeys getImportedKeys()
    {
        if (importedKeys == null)
        {
            importedKeys = new ForeignKeys(this);
        }
        return importedKeys;
    }
    
    public String getContentName()
    {
        return "${pageContext.request.contextPath}";
    }
    
    /**
     * 合并文件路径模型
     */
    @SuppressWarnings("unchecked")
    public void mergeFilePathModel(Map fileModel) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
    {
        fileModel.putAll(BeanUtils.describe(this));
    }
    
    public String getTemplateModelName()
    {
        return "table";
    }
}
