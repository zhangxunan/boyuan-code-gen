<#include "/macro.include"/>
<#include "/copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.dao;

import ${basepackage}.pojo.${subpackage}.${className};
import com.lzkj.common.exception.DAOException;

/**
 * ${table.sqlRemark} 持久层接口
 * <p>File：${className}DAO.java </p>
 * <p>Title: ${className}DAO </p>
 * <p>Description:${className}DAO </p>
 * <p>Copyright: Copyright (c) 一月 20，2016 </p>
 * <p>Company: 陆泽科技</p>
 * @author 开发
 * @version 1.0
 */
public interface ${className}DAO
{
    /**
     * 通过id获取对象
     *
     * @param id 主键
     * @throws DAOException
     */
    ${className} getBeanById(Long id) throws DAOException;

    /**
     * 新增
     *
     * @param ${classNameLower}
     * @throws DAOException
     */
    void insert(${className} ${classNameLower}) throws DAOException;

    /**
     * 修改
     *
     * @param ${classNameLower}
     * @throws DAOException
     */
    void update(${className} ${classNameLower}) throws DAOException;
}
