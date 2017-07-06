package com.willard.java2e.jmx;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.rmi.registry.LocateRegistry;

import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

import com.sun.jdmk.comm.HtmlAdaptorServer;
//import com.sun.jdmk.comm.HtmlAdaptorServer;
import com.willard.java2e.jmx.bean.Hello;

/**
 *  
 * <p>Title: JMXClientUtil.java </p>
 * <p>Description: JMX</p>
 * Date: 2016�?12�?6日下�?3:12:04
 * @author zlb
 * @version 1.0 
 * Significant Modify�?
 * Date               Author           Content
 * ==========================================================
 * 2016�?12�?6日下�?3:12:04             zlb         
 * 
 * ==========================================================
 */
public class JMXClientUtil {
	private JMXServiceURL JMXaddress;
	private static JMXConnector connector;
	private static MBeanServerConnection mBeanServerconnection;
	
	
	/**
	 * 将MBean注册到MBeanServer中
	 * @param domain  key value 形式 eg ："MY_127.0.0.1:name=HelloJmx"
	 * @param object  eg :MBean的实例对象 new person()
	 * @param ip
	 * @param port
	 * @throws Exception
	 */
	public static void registerMBeanForServer(String domain ,Object object,String ip,int port) throws Exception{
		//1.0 创建MBeanServer
		MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
		try {
		//2.0创建ObjectName域  (就是存储了一个domain(域)下的一些属性,属性的存储采取key-value的方式来存储)
		ObjectName  name =new  ObjectName(domain);
		//3.0注册MBean到Server
		mBeanServer.registerMBean(object, name);
		//4.0这个步骤很重要，注册一个端口，绑定url后用于客户端通过rmi方式连接JMXConnectorServer
        LocateRegistry.createRegistry(port);
        //5.0URL路径的结尾可以随意指定，但如果需要用Jconsole来进行连接，则必须使用jmxrmi
        JMXServiceURL url = new JMXServiceURL
              ("service:jmx:rmi:///jndi/rmi://"+ip+":"+port+"/jmxrmi");
        JMXConnectorServer jcs = JMXConnectorServerFactory.newJMXConnectorServer(url, null, mBeanServer);
        System.out.println("begin rmi start url ：" + url);
       
        ObjectName adapterName = new ObjectName("HelloAgent:name=htmladapter,port=8882");
		HtmlAdaptorServer adapter = new HtmlAdaptorServer();
		mBeanServer.registerMBean(adapter, adapterName);
        jcs.start();
        System.out.println("rmi start");
		} catch (MalformedObjectNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	/** 
	* @Title: connectJmxAgent 
	* @Description: 连接JMXAgent并返回beanServer的连接
	* @param @param ip
	* @param @param port   
	* @return mBeanServerconnection   
	* @throws 
	*/
	public static MBeanServerConnection  connectJmxAgent(String ip ,String port){
		/*Connect to JMX Agent*/
		JMXClientUtil JMXinstance = new JMXClientUtil();
		String remoteURL = JMXinstance.getUrlAddress(ip, port);
		JMXinstance.JMXClientCreateConnection(remoteURL);
		/*List Mbeans*/		
		return mBeanServerconnection;
	}

	
	
	/** 
	* @Title: getUrlAddress 
	* @Description: 拼接JMX所需通讯地址
	* @param @param JMXip
	* @param @param JMXPort
	* @param @return   
	* @return String   
	* @throws 
	*/
	public String getUrlAddress(String JMXip, String JMXPort){
		 String JMXAddress = "service:jmx:rmi://" + JMXip + ":" + JMXPort + 
				 				"/jndi/rmi://" + JMXip + ":" + JMXPort + "/jmxDefault";
		 return JMXAddress;
	 }
	
	/** 
	* @Title: JMXClientCreateConnection 
	* @Description: 创建连接
	* @param @param JMXUrl   
	* @return void   
	* @throws 
	*/
	public void JMXClientCreateConnection(String JMXUrl) {
		try {
			JMXaddress = new JMXServiceURL(JMXUrl);
			connector = JMXConnectorFactory.connect(JMXaddress);
			mBeanServerconnection = connector.getMBeanServerConnection();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @throws IOException 
	 * @throws ReflectionException 
	 * @throws MBeanException 
	 * @throws InstanceNotFoundException  
	* @Title: operationMBeanMethod 
	* @Description: 执行指定的MBean指定的方法
	* @param @return   
	* @return String   
	* @throws 
	*/
	public static String operationMBeanMethod(String ip ,String port,String appName,String name,String operation,String command) throws InstanceNotFoundException, MBeanException, ReflectionException, IOException{
		MBeanServerConnection  mbsc = connectJmxAgent(ip,port);
		name = "name=" + name;
		ObjectName execObject = getSingleObject(appName, ip, name);// ObjectName 由两部分组成： domain 和 键/值对
		String result = (String)mbsc.invoke(execObject, operation, new Object[]{command}, new String[]{"java.lang.String"});
		//String command = "RCTR:C/MC28S4";
		JMXClientUtil.closeJmxConnection();
		//System.exit(0);
		return result ;
	}
	
	 public static ObjectName getSingleObject(String AppName, String ip, String name) {
		 String domain = AppName + "_" + ip;
		try {
			ObjectName execObject = new ObjectName(domain + ":" + name);
			return execObject;
		} catch (MalformedObjectNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	 }
	 
	 
    /** 
	* @Title: closeJmxConnection 
	* @Description: 关闭JMX连接 
	* @param    
	* @return void   
	* @throws 
	*/
	private static void closeJmxConnection()	{
		 try {
			connector.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
	
	public static void main(String  args[]) throws Exception{
		//测试注册MBean到server
		registerMBeanForServer("MY_127.0.0.1:name=HelloMBean", new Hello(), "127.0.0.1", 8882);
		/*args[0] = "10.6.80.4";
		args[1] = "6300";
		args[2] = "RIMU";
		args[3] = "showPnrOriginalText";//showPnrOriginalText  reloadCache
		args[4] = "sihSynchHelper";//sihSynchHelper businessCacheReloadManager
		args[5] = "RCTR:C/MC28S4";
		args[6] = "attl/on";
		args[7] = "gen";
		
		String ip = args[0];
		String port = args[1];
		String AppName = args[2];
		String operation = args[3];*/
		//System.out.println("执行结果"+operationMBeanMethod("10.6.80.4", "6300", "RIMU", "sihSynchHelper", "showPnrOriginalText", "RCTR:C/MC28S4"));
		
	}

}
