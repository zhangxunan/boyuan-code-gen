<#include "/macro.include"/>
<#include "/copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.service.${subpackage};

import ${basepackage}.pojo.${subpackage}.${className};
import ${basepackage}.dao.${subpackage}.${className}DAO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.boyuan.common.BaseService;
import com.boyuan.common.exception.ServiceException;

/**
 * ${table.sqlRemark} 服务实现类
 * <p>File：${className}ServiceImpl.java </p>
 * <p>Title: ${className}ServiceImpl </p>
 * <p>Description:${className}ServiceImpl </p>
 * <p>Copyright: Copyright (c) 一月 20，2016 </p>
 * <p>Company: 泊源科技</p>
 * @author 章旭楠
 * @version 1.0
 */
@Service
public class ${className}ServiceImpl extends BaseService implements ${className}Service
{
    @Autowired
    private ${className}DAO ${classNameLower}DAO;

}
