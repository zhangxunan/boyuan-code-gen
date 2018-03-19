package com.zttx.web.gen;

import junit.framework.TestCase;

/**
 * <p>File：GeneratorFileTest.java </p>
 * <p>Title: GeneratorFileTest </p>
 * <p>Description: GeneratorFileTest </p>
 * <p>Copyright: Copyright (c) 十月 27，2015</p>
 * <p>Company: 8637.com</p>
 *
 * @author 章旭楠
 * @version 1.0
 */
public class GeneratorFileTest extends TestCase
{
    protected GeneratorFile generatorFile = new GeneratorFile();
    
    public void testGeneratorCode() throws Exception
    {
        generatorFile.clean();
        generatorFile.generateCRUDByTables("batchtool", "batch_tool_sku_search_log,batch_tool_modify_record,batch_tool_modify_detail".split(","));
    }

    public void testClean() throws Exception
    {
        // generatorFile.clean();
    }
    
    public void testGenerateCRUDByTable() throws Exception
    {
        // generatorFile.generateCRUDByTable("dealer","DealerShopEnvTemp");
    }
    
    public void testGenerateCRUDByTables() throws Exception
    {
        // generatorFile.generateCRUDByTables("dealer", new String[]{"DealerShopEnvTemp"});
    }
    
    public void testGenerateCRUDByAllTable() throws Exception
    {
        // generatorFile.generateCRUDByAllTable();
    }
}