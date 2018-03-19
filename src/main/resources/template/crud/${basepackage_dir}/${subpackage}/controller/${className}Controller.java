<#include "/macro.include"/>
<#include "/copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.controller.${subpackage};

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boyuan.common.BaseController;
import com.boyuan.common.utils.CookieUtil;
import ${basepackage}.pojo.${subpackage}.${className};
import ${basepackage}.service.${subpackage}.${className}Service;


/**
 * 控制器
 * <p>File：${className}Controller.java </p>
 * <p>Title: ${className}Controller </p>
 * <p>Description:${table.sqlRemark} 控制器 </p>
 * <p>Copyright: Copyright (c) 一月 20，2016 </p>
 * <p>Company: 泊源科技</p>
 * @author 章旭楠
 * @version 1.0
 */
@Controller
@RequestMapping("/${subpackage}/${classNameLower}")
public class ${className}Controller extends BaseController
{
    @Autowired(required = true)
    private ${className}Service ${classNameLower}Service;

    /**
     * 页面跳转
     */
    @RequestMapping(value = "/index")
    public String index()
    {
        return "/${subpackage}/${classNameLower}/index";
    }


}
