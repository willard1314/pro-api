package com.willard.util;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Properties;


/**
 * 配置文件管理工具
 */
public class ConfigUtil {
	
	
	//配置项缓冲池
    private static Hashtable<String, String> gConfigUtilCachePool = new java.util.Hashtable<String, String>();
	
	
	/**
	 * 根据配置文件的名字和配置项的名字，读取配置项的数值。以String格式返回。
	 * eg：System.out.println(ConfigUtil.getProperty(null, "DatabaseUrl", true));
	 * 
	 * @param propFileName 配置文件的名字，如：“xxx.properties”，一般放在Classes的根目录下。但本参数为 null 或 "" 时，自动赋值 "main.properties"
	 * @param key 配置项的名称，如：“DatabaseAccount”
	 * @param useCacheFlag 是否使用缓冲的标识开关，当开启的时候，仅第一次会读取物理配置文件，后续均是从内存中写入。
	 * @return 返回配置项的配置数值
	 * @throws Exception
	 */
    public static String getProperty(String propFileName, String key, boolean useCacheFlag) throws Exception {
    	if(propFileName==null || propFileName.equals("")) propFileName = "main.properties";
    	if(useCacheFlag){
    		//检查缓冲池中是否有缓冲配置项，若有，直接获取后返回
    		String valueStr = gConfigUtilCachePool.get("[Property]["+propFileName+"]["+key+"]");
    		if(valueStr!=null) return valueStr;
    	}
    	//不使用缓冲或者第一次读取缓冲池中尚无数据的，从配置文件总读取配置项
        InputStream in = ConfigUtil.class.getClassLoader().getResourceAsStream(propFileName);
        Properties  props = new Properties();
        props.load(in);
        in.close();
        String valueStr = props.getProperty(key);
        //若开启了缓冲选项，将本次结果缓冲到缓冲池中
        if(useCacheFlag){ gConfigUtilCachePool.put("[Property]["+propFileName+"]["+key+"]", valueStr); }
        //返回结果
        return valueStr;
    }
    
    
    
    /**
     *  设置某个配置文件的某个配置项的值，可以选择是否保存配置信息到配置文件。最后一项 saveToPropFile ，
     *  为 false 时，则仅更新内存中的配置项缓存（必须内存中先有数据了才会更新）；为true时，除更新内存中的配置项缓存外，还会将结果写入配置文件。
     *  eg: ConfigUtil.setProperty("main.properties", "DatabaseUrl", "127.0.0.1:3306", true);
     * 
	 * @param propFileName 配置文件的名字，如：“xxx.properties”，一般放在Classes的根目录下。但本参数为 null 或 "" 时，自动赋值 "main.properties"
	 * @param key 配置项的名称，如：“DatabaseAccount”
     * @param value 配置项的值，如：“hello”
     * @param saveToPropFile 是否将本次更改写入配置文件中
     * @throws Exception 
     */
    public static void setProperty(String propFileName, String key, String value, boolean saveToPropFile) throws Exception {
    	if(propFileName==null || propFileName.equals("")) propFileName = "main.properties";
		//若缓存中有了相关配置项，更新缓存中的值
		String valueStr = gConfigUtilCachePool.get("[Property]["+propFileName+"]["+key+"]");
		if(valueStr!=null) gConfigUtilCachePool.put("[Property]["+propFileName+"]["+key+"]", value);
    	//若是要存储到配置文件中，则写文件
    	if(saveToPropFile){ 
	        Properties prop = new Properties();
	        InputStream fis =  ConfigUtil.class.getClassLoader().getResourceAsStream(propFileName);
	        prop.load(fis);
	        OutputStream fos = new FileOutputStream(ConfigUtil.class.getClassLoader().getResource(propFileName).getFile());
	        prop.setProperty(key, value);
	        prop.store(fos,"last update");
	        fis.close();
	        fos.close();
    	}
    }
    
    
   
    
    
}
