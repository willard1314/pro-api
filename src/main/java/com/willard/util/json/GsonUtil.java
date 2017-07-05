package com.willard.util.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;


/** 
* @ClassName: GsonUtil 
* @Description: json工具类 Gson方式
* @author willard
* @date 2017年6月29日 下午4:50:22 
*  
*/
public class GsonUtil {
	
	private static Logger LOGGER = Logger.getLogger(GsonUtil.class);

	protected static Gson gson = new Gson();

	/**
	 * 转换成String的List集合
	 * @param list
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "null" })
	public static List<String> toJson(List list){
		List<String> listString = null;
		if(list == null || list.size() == 0 ){
			return listString;
		}
		try{
			listString = new ArrayList<String>();
			for(Object o :list){
				listString.add(gson.toJson(o));
			}
		}catch(Exception e){
			LOGGER.error(" toJson(List list) failed ", e);
		}
		return listString;
	}
    /**
     *
     * @param set
     * @return
     */
	@SuppressWarnings({ "rawtypes", "null" })
	public static Set<String> toJson(Set set){
		Set<String> setString = null;
		if(set == null || set.size() == 0 ){
			return setString;
		}
		try{
			setString = new HashSet<String>();
			for(Object o:set){
				if(o instanceof String) {
					setString.add((String)o);
				}else{
					setString.add(gson.toJson(o));
				}
			}
		}catch(Exception e){
			LOGGER.error("toJson(Set set) failed ", e);
		}
		return setString;
	}
	/**
	 *
	 * @param o
	 * @return
	 */
	public static String toJson(Object o){
		if(o == null){
			return null;
		}
		//避免两个出现重复双引号
		if(o instanceof String) {
		    return (String)o;
		}
		String jsonString = null;
		try{
			jsonString =  gson.toJson(o);
		}catch(Exception e){
			LOGGER.error("toJson(Object o) failed ", e);
		}
		return jsonString;
	}

	/**
	 *
	 * @param map
	 * @return
	 */
	@SuppressWarnings({ "rawtypes"})
    public static Map<String,String> toJson(Map map){
			Map<String, String> map2 = new HashMap<String, String>();
			Iterator iterator = map.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry entry = (Entry) iterator.next();
				String key = (String) entry.getKey();
				Object value = entry.getValue();
				map2.put(key, GsonUtil.toJson(value));
			}
			return map2;
	}

	/**
	 *
	 * @param jsonString
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object fromJson(String jsonString,Class clazz){
		Object o = null;
		if(jsonString == null){
			return o;
		}
		if(clazz.equals(String.class)) {
		    return jsonString;
		}
		try{
			o = gson.fromJson(jsonString, clazz);
		}catch(Exception e){
			LOGGER.error("fromJson(String jsonString,Class clazz) failed ", e);
		}
		return o;
	}
    /**
     *
     * @param listString
     * @param clazz
     * @return
     */
	@SuppressWarnings({ "rawtypes", "null", "unchecked" })
	public static List fromJson(List<String> listString,Class clazz){
		List list = null;
		if(listString == null || listString.size() == 0){
			return list;
		}
		list = new ArrayList();
		try{
			for(String jsonString :listString){
				list.add(gson.fromJson(jsonString, clazz));
			}
		}catch(Exception e){
			LOGGER.error("fromJson(List<String> listString,Class clazz) failed ", e);
		}
		return list;
	}
    /**
     *
     * @param setString
     * @param clazz
     * @return
     */
	@SuppressWarnings({ "rawtypes", "null", "unchecked" })
	public static Set fromJson(Set<String> setString,Class clazz){
		Set set = null;
		if(setString == null || setString.size() == 0){
			return set;
		}
		set = new HashSet();
		try{
			for(String jsonString :setString){
				set.add(gson.fromJson(jsonString, clazz));
			}
		}catch(Exception e){
			LOGGER.error("fromJson(Set<String> setString,Class clazz) failed ", e);
		}
		return set;
	}
	
	/** 
	* &lt;p&gt;Title: writeJsonToView &lt;/p&gt;
	* &lt;p&gt;Description:返回json格式数据给前端&lt;/p&gt; 
	* 
	*/
	public static String writeJsonToView(String data,String str,String notice){
		 Map<String,String> map = new HashMap<String,String>();  
		 ObjectMapper mapper = new ObjectMapper();  
		 map.put("data", data);
		 map.put("result", str);
		 try {
			String result =mapper.writeValueAsString(map);
			System.out.println("result:"+result);
			return result;
		} catch (JsonProcessingException e) {
			System.out.println(e.getMessage());
		}
		 return null ;
	}
	
	/** 
	* @Title: writeJsonToView 
	* @Description: 返回json格式数据给前端，并指定跳转地址
	* @param @param result
	* @param @param url
	* @param @return   
	* @return String   
	* @throws 
	*/
	public static String writeJsonToView(String result ,String url){
		Map<String ,String> map = new HashMap<String,String>();  
		ObjectMapper mapper = new ObjectMapper();  
		map.put("result", result);
		map.put("url", url);
		try {
		String res =mapper.writeValueAsString(map);
		return res;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String writeJsonToView(Object data){
		Map<Object ,Object> map = new HashMap<Object,Object>();  
		ObjectMapper mapper = new ObjectMapper();  
		map.put("data", data);
		try {
		String res =mapper.writeValueAsString(map);
		return res;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
