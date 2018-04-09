package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.User;
import com.service.IUserService;
import com.util.ResponseUtils;

import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;  


@Controller  
@RequestMapping("/action") 

public class InformAction {
    @Resource  
	 private IUserService userService;  
	 
	 @RequestMapping(value = "/getUser")  
	 @ResponseBody
	  public User findById(HttpServletRequest request, HttpServletResponse response) {  
		 int userId = Integer.parseInt("id"); 
		 
		 User user = this.userService.getUserById(userId);
		return user;

	 }
	 
	 
	 
	 @RequestMapping(value = "/getImeiToCell")  
	 @ResponseBody
	  public static  String getImeiToCell(HttpServletRequest request, HttpServletResponse respons) throws Exception {  
		 
//		 String strUrl = "http://www.sojson.com/open/api/weather/json.shtml?city=北京";
//		 String strUrl = "http://43.243.130.36:9007/imeiToMsisdnMd5.htm?";
		
		
//		 ResponseUtils.renderJson(response,strValue); 
		

		
		 
		 String  userName = "shuhemf";
		 String  passWord = "shmf2018";
		 
	     String  iemi = "862743030092243,862743030092250,356726088634969";
	    
//		 StringBuffer  imeiList = new StringBuffer();
//		 imeiList.append("{");
//		 imeiList.append("\"354381064401226\"");
//		 imeiList.append("}");
//		 
	     
	     
	     
	     long nowTime = new Date().getTime();
	     
		 StringBuffer signStr = new StringBuffer();
		 signStr.append(userName);
		 signStr.append(passWord);
		 signStr.append(String.valueOf(nowTime));
		 String  sign = getMD5(signStr.toString());
		 String strValue = null;
		 
		 String  content = "【极推】测试数据2，1234567。";
		 
		 String reqUrl = "http://43.243.130.37:8099/api/imei/send";
	        JSONObject paramJson=new JSONObject();
	        paramJson.put("username",userName);
	        paramJson.put("content",content);
	        paramJson.put("imei",iemi);
	        paramJson.put("timestamp",String.valueOf(nowTime));
	        paramJson.put("sign",sign);
	       
//	        String strValue =  RequestData(reqUrl, paramJson.toString());

	        HttpClient httpClient = new DefaultHttpClient();
	        HttpPost httpPost=new HttpPost(reqUrl);
	        httpPost.addHeader("Content-Type","application/json; charset=utf-8");
	        httpPost.setHeader("Accept", "application/json");
	        httpPost.setEntity(new StringEntity(paramJson.toString(), Charset.forName("UTF-8")));
	        try {
	            HttpResponse response = httpClient.execute(httpPost);
	            int statusCode = response.getStatusLine().getStatusCode();
	            if (statusCode != HttpStatus.SC_OK) {
	                System.err.println("Method failed:" + response.getStatusLine());
	            }else{
	
	                String resultStr =EntityUtils.toString(response.getEntity());
//	                resultStr = resultStr.replaceAll("\"\\", "");
//	                resultStr = resultStr.replaceAll("\"\"", "");
//	                JSONObject resultJSON=JSONObject.fromObject(resultStr);
//	                System.out.println("resultJSON:"+resultJSON);
	                strValue =resultStr;
//	                strValue = resultStr;
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
		 
		return strValue;
	 }
	 
	 
		public static String RequestData(String strUrl,String StrCS)throws Exception  {
			
	        URL url = new URL(strUrl);  
	        
	        // 将url 以 open方法返回的urlConnection  连接强转为HttpURLConnection连接  (标识一个url所引用的远程对象连接)  
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 此时cnnection只是为一个连接对象,待连接中  
	          
	        // 设置连接输出流为true,默认false (post 请求是以流的方式隐式的传递参数)  
	        connection.setDoOutput(true);       
	        // 设置连接输入流为true  
	        connection.setDoInput(true);        
	        // 设置请求方式为post  
	        connection.setRequestMethod("POST");  
	    
	        // post请求缓存设为false  
	        connection.setUseCaches(false);
	        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        connection.connect(); 
	        
	        DataOutputStream dataout = new DataOutputStream(connection.getOutputStream());
	        // 将参数输出到连接  
	        dataout.writeBytes(StrCS);  
	        // 输出完成后刷新并关闭流  
	        dataout.flush();  
	        dataout.close(); // 重要且易忽略步骤 (关闭流,切记!)   
	        
	        // 连接发起请求,处理服务器响应  (从连接获取到输入流并包装为bufferedReader)  
	        BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));   
	        String line;  
	        StringBuilder sb = new StringBuilder(); // 用来存储响应数据  
	          
	        // 循环读取流,若不到结尾处  
	        while ((line = bf.readLine()) != null) {  
//	            sb.append(bf.readLine());  
	            sb.append(line); 
	        }  
	        bf.close();    // 重要且易忽略步骤 (关闭流,切记!)   
	        connection.disconnect(); // 销毁连接  
	        
	        
			return sb.toString();  
		}
		
		
		
		
		// 获取32位MD5密文
		public static String getMD5(String str) throws Exception {
			
			MessageDigest md5 = MessageDigest.getInstance("MD5");  
			md5.update(str.getBytes("UTF-8"));  
			byte b[] = md5.digest();  
			  
			int i;  
			StringBuffer buf = new StringBuffer();  
			  
			for(int offset=0; offset<b.length; offset++){  
			    i = b[offset];  
			    if(i<0){  
			        i+=256;  
			    }  
			    if(i<16){  
			        buf.append("0");  
			    }  
			    buf.append(Integer.toHexString(i));  
			}
			return buf.toString();  
			
	    }
		

}
