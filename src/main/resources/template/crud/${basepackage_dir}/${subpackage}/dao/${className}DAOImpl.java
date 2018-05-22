<#include "/macro.include"/>
<#include "/copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign tableName =  table.sqlName>
package ${basepackage}.dao;

import org.springframework.stereotype.Repository;

import com.lzkj.common.exception.DAOException;
import com.lzkj.common.BaseDAO;
import ${basepackage}.pojo.${subpackage}.${className};

/**
 * ${table.sqlRemark} 持久层接口
 * <p>File：${className}DAOImpl.java </p>
 * <p>Title: ${className}DAOImpl </p>
 * <p>Description:${className}DAOImpl </p>
 * <p>Copyright: Copyright (c) 一月 20，2016 </p>
 * <p>Company: 陆泽科技</p>
 * @author 开发
 * @version 1.0
 */
@Repository
public class ${className}DAOImpl extends BaseDAO implements ${className}DAO
{

    public static final String SQL_GET_BEAN_BYID = "SELECT * FROM bd_${tableName} WHERE id=?";

    @Override
    public ${className} getBeanById(Long id) throws DAOException
    {
        return super.queryForBean(SQL_GET_BEAN_BYID,${className}.class,id);
    }

    public static final String SQL_INSERT = "INSERT INTO bd_${tableName}"
        + "(<@generateInsertFields/>)"
        + " VALUES "
        + "(<@generateValueFields/>)";

    @Override
    public void insert(${className} ${classNameLower}) throws DAOException
    {
        super.update(SQL_INSERT, ${classNameLower});
    }

    public static final String SQL_UPDATE = "UPDATE bd_${tableName} "
        + "SET <@generateSetValueFields/> "
        + "WHERE id=:id";

    @Override
    public void update(${className} ${classNameLower}) throws DAOException
    {
        super.update(SQL_UPDATE, ${classNameLower});
    }
}

<#macro generateInsertFields><#list table.columns as column>${column.columnNameLower}<#if column_has_next>,</#if></#list></#macro>

<#macro generateValueFields><#list table.columns as column>:${column.columnNameLower}<#if column_has_next>,</#if></#list></#macro>

<#macro generateSetValueFields><#list table.columns as column>${column.columnNameLower}=:${column.columnNameLower}<#if column_has_next>,</#if></#list></#macro>