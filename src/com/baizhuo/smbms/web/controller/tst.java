package com.baizhuo.smbms.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.baizhuo.smbms.entity.User;
import com.baizhuo.smbms.service.IUserService;

//import com.kxy.CampusGuard.module.CampusBully.entity.User;

import net.sf.json.JSONObject;


/**
 * Servlet implementation class tst
 */
@RequestMapping("tst")
@Controller
//@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class tst extends HttpServlet {
	private IUserService userService;

	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = (IUserService) context.getBean("userService");
	}
	
	private static final long serialVersionUID = 1L;

	private String appid = "wx77829bf1956b3b04";//填写小程序APPID
	private String REDIRECT_URI = "";
	private String SCOPE = "snsapi_base";
	private String secret ="aefc74b0fc8bd1f42600e1a603b04727";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
        /*设置响应头允许ajax跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "*");

        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        System.out.println("-----------------doPost");
	      String userInfo =request.getParameter("userInfo");
	      System.out.println("userInfo"+userInfo);
		// 获取操作类型，根据类型执行不同操作
		String operFlag = request.getParameter("operFlag");
		System.out.println("operFlag" + operFlag);
		String results = "";
		if ("getOpenid".equals(operFlag)) {
			String code = request.getParameter("code");
			// 拿到微信小程序传过来的code
			System.out.println(code);
			System.out.println(operFlag);
			//String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+ appid + "&redirect_uri="+ REDIRECT_URI + "&response_type=code&scope="+SCOPE+"&state=STATE#wechat_redirect";
			String url ="https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
			
			System.out.println("url" + url);
			results = sendGetReq(url);
			// 发送http请求
			System.out.println("resultsssss" + results);
			System.out.println("results" + userInfo);
            //解析微信返回过来的数据
			JSONObject jsonObject = JSONObject.fromObject(results);
			JSONObject jsonObject1 = JSONObject.fromObject(userInfo);
			//获取用户信息
			
//			JSONObject userInfoJSON=WechatGetUserInfoUtil.decrypt(results, jsonObject.getString("session_key"),iv,encodingFormat);

//ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//IUserService userService = (IUserService) ctx.getBean("userService");
			User user = new User();
			//wxOpenid
			String openid=jsonObject.getString("openid");
			//微信名称
			String nickName=jsonObject1.getString("nickName");
			//性别
			String gender=jsonObject1.getString("gender");
			//地址
			String city=jsonObject1.getString("city");
			
			System.out.println("微信id："+openid);
			System.out.println("微信名称：" + nickName);
			System.out.println("性别：" + gender);
			System.out.println("地址：" + city);
			results = sendGetReq(url);
			
			user.setOpenid(openid);
			user.setName(nickName);
			user.setGender(gender);
			user.setCity(city);
			
			System.out.println(user);
			System.out.println("12341:"+user.getCity());
			try {
				add(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		
//			try {
				//System.out.println("12341:"+mapper.insert(user));
			
//				System.out.println("12341:"+userService.addUser(user));
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				
//			}
			
		
			
		}
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("catch-control", "no-catch");
		PrintWriter out = response.getWriter();
		out.write(results);
		out.flush();
		out.close();
	}

	private String sendGetReq(String url) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			java.util.Map<String, List<String>> map = connection.getHeaderFields(); // 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			} // 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
		
	}
 public void add(User user) throws Exception {
	 System.out.println("2222222222"+user);
//	 mapper.insert(user);
	 userService.addUser(user);
 }
}
