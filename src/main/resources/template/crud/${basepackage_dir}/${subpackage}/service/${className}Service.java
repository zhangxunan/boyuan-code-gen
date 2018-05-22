<#include "/macro.include"/>
<#include "/copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.service.${subpackage};


import com.lzkj.common.exception.ServiceException;
import ${basepackage}.pojo.${subpackage}.${className};

/**
 * ${table.sqlRemark} 服务接口
 * <p>File：${className}Service.java </p>
 * <p>Title: ${className}Service </p>
 * <p>Description:${className}Service </p>
 * <p>Copyright: Copyright (c) 一月 20，2016 </p>
 * <p>Company: 陆泽科技</p>
 * @author 开发
 * @version 1.0
 */
public interface ${className}Service {


}
