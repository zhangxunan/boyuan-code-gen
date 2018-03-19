<#include "/macro.include"/>
<#include "/copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage}.pojo;

import java.io.Serializable;

/**
 * ${table.sqlRemark} 实体对象
 * <p>File：${className}.java</p>
 * <p>Title: ${className}</p>
 * <p>Description:${className}</p>
 * <p>Copyright: Copyright (c) 一月 20，2016 </p>
 * <p>Company: 泊源科技</p>
 * @author 章旭楠
 * @version 1.0
 */
public class ${className} implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	<@generateFields/>
	
	<@generateNotPkProperties/>
}

<#macro generateFields>
<#if table.compositeId>
	private ${className}Id id;
	<#list table.columns as column>
		<#if !column.pk >
	private ${column.javaType} ${column.columnNameLower};
		</#if>
	</#list>
<#else>
	<#list table.columns as column>
	/**${column.remark}*/
	private ${column.javaType} ${column.columnNameLower};
	</#list>
</#if>
</#macro>

<#macro generateNotPkProperties>
	<#list table.columns as column>

	public ${column.javaType} get${column.columnName}()
	{
		return this.${column.columnNameLower};
	}
	
	public void set${column.columnName}(${column.javaType} ${column.columnNameLower})
	{
		this.${column.columnNameLower} = ${column.columnNameLower};
	}

	</#list>
</#macro>