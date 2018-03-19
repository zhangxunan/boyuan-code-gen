<#include "/macro.include"/>
<#include "/copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage}.mapper;

import com.zttx.sdk.core.GenericMapper;
import com.zttx.sdk.annotation.MyBatisDao;
import ${basepackage}.${subpackage}.entity.${className};

/**
 * ${table.sqlRemark} 持久层接口
 * <p>File：${className}Dao.java </p>
 * <p>Title: ${className}Dao </p>
 * <p>Description:${className}Dao </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: 8637.com</p>
 * @author 章旭楠
 * @version 1.0
 */
@MyBatisDao
public interface ${className}Mapper extends GenericMapper<${className}>
{

}
