package org.zsl.testmybatis;  
  
import javax.annotation.Resource;  
  
import org.apache.log4j.Logger;  
import org.junit.Test;  
import org.junit.runner.RunWith;  

import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
  
import com.alibaba.fastjson.JSON;
import com.controller.InformAction;
import com.model.User;
import com.service.IUserService;  

  
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
  
public class TestMyBatis {  
    private static Logger logger = Logger.getLogger(TestMyBatis.class);  
//  private ApplicationContext ac = null;  
    @Resource  
    private IUserService userService = null;  
  
//  @Before  
//  public void before() {  
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
//      userService = (IUserService) ac.getBean("userService");  
//  }  
  
    @Test  
    public void test1() {  
        try {
			InformAction.getImeiToCell(null, null);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
//        logger.info(JSON.toJSONString(user));  
    }  
}  