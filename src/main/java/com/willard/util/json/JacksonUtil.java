package com.willard.util.json;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * 
 * <p>Title: JsonUtils.java </p>
 * <p>Description: json数据处理工具类</p>
 * Date: 2016年12月27日上午9:29:24
 * @author zlb
 * @version 1.0 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2016年12月27日上午9:29:24             zlb         
 * ==========================================================
 */
public class JacksonUtil {
	
	
	private static Logger logger = Logger.getLogger(JacksonUtil.class);
	 
	/** 
	*@Title: convertStrToObj 
	*@Description: 将对象转换成json
	*@return   
	*@return String   
	*@throws 
	*/
	public static String convertObjToStr(Object obj){
		ObjectMapper objMapper =getObjectMapper();
		try {
			String jsonStr = objMapper.writeValueAsString(obj);
			return jsonStr ;
		} catch (Exception e) {
			logger.info("conver object to string exception" +e);
		}
		return null ;
	}
	
	/** 
	*@Title: convertJStrToObj 
	*@Description: 对json串进行转换，匹配对应的bean
	*@param jsonStr
	*@param clazz
	*@return   
	*@return Object   
	*@throws 
	*/
	public static <T> Object convertJStrToObj(String jsonStr,Class<T> clazz){
		ObjectMapper objMapper =getObjectMapper();
		Object obj = null;
		try {
			obj = objMapper.readValue(jsonStr, clazz);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.info("conver json String to bean object exception" +e);
		}
		return obj;
	}
	
	/** 
	*@Title: getObjectMapper 
	*@Description: 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性 
	*@return   
	*@return ObjectMapper   
	*@throws 
	*/
	private static ObjectMapper getObjectMapper(){
		ObjectMapper mapper = new ObjectMapper(); 
		mapper.configure(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true) ; 
		mapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);  
		mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
		return mapper;
	}
}
