package com.zttx.web.gen;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.zttx.web.gen.model.db.Table;
import com.zttx.web.gen.provider.DbModelHelper;
import com.zttx.web.gen.provider.DbTableProvider;
import com.zttx.web.gen.utils.PropertiesProvider;

/**
 * 文件生成器
 * <p>File：GeneratorFile.java</p>
 * <p>Title: GeneratorFile</p>
 * <p>Description:GeneratorFile</p>
 * @version 1.0
 */
public class GeneratorFile
{
    GeneratorCore generator = new GeneratorCore();
    
    String        path      = "src/main/resources/template/crud";
    
    /**
     * 删除文件夹
     * @throws IOException
     */
    public void clean() throws IOException
    {
        generator.removeJavaFile();
        generator.removePageFile();
    }
    
    /**
     * 根据指定的表生成文件代码（指定单个表）
     * @param tableName
     * @throws Exception
     */
    public void generateCRUDByTable(String tableName) throws Exception
    {
        generator.templateRootDir = new File(path).getAbsoluteFile();
        generator.modelProvider = new DbTableProvider(tableName);
        generator.generateByModelProvider();
    }
    
    /**
     * 根据指定的表在对应的模块下生成文件代码（指定单个表）
     * @param moduleName 模块名
     * @param tableName 表名
     * @throws Exception
     */
    public void generateCRUDByTable(String moduleName, String tableName) throws Exception
    {
        PropertiesProvider.getProperties().setProperty("subpackage", moduleName);
        generateCRUDByTable(tableName);
    }
    
    /**
     * 根据指定的表生成文件代码(指定具体的一部份表)
     * @param tableNames
     * @throws Exception
     */
    public void generateCRUDByTables(String[] tableNames) throws Exception
    {
        for (String tableName : tableNames)
        {
            generator.templateRootDir = new File(path).getAbsoluteFile();
            generator.modelProvider = new DbTableProvider(tableName);
            generator.generateByModelProvider();
        }
    }
    
    /**
     * 根据指定的表在对应的模块下生成文件代码(指定具体的一部份表)
     * @param moduleName 模块名
     * @param tableNames 表名
     * @throws Exception
     */
    public void generateCRUDByTables(String moduleName, String[] tableNames) throws Exception
    {
        PropertiesProvider.getProperties().setProperty("subpackage", moduleName);
        generateCRUDByTables(tableNames);
    }
    
    /**
     * 生成数据库中所有表的文件及代码
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public void generateCRUDByAllTable() throws Exception
    {
        generator.templateRootDir = new File(path).getAbsoluteFile();
        List<Table> allTable = DbModelHelper.getInstance().getAllTables();
        for (Table t : allTable)
        {
            if (!"fk_sequence".equals(t.getSqlName()))
            {
                generator.modelProvider = new DbTableProvider(t.getSqlName());
                generator.generateByModelProvider();
            }
        }
    }
}
