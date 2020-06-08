package flower.com.test;

import javax.annotation.Resource;
import javax.faces.application.Application;

import org.jboss.weld.context.ApplicationContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import flower.com.biz.FlowerBiz;
import flower.com.biz.FlowerFileBiz;
import flower.com.biz.OrderBiz;
import flower.com.biz.UserBiz;
import flower.com.dao.FlowerDao;
import flower.com.dao.FlowerFileDao;
import flower.com.dao.ShopCarDao;
import flower.com.dao.StoreDao;
import flower.com.dao.UserDao;
import flower.com.entity.Flower;
import flower.com.entity.Order;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class JunitTest {
//	@Resource(name="userDao")
//	private UserDao userDao;
//
//	public UserDao getUserDao() {
//		return userDao;
//	}
//
//	public void setUserDao(UserDao userDao) {
//		this.userDao = userDao;
//	}
	/*userDaoTest*/
	/*@org.junit.Test
	public void TestUser(){
		String username = "jiarui123",
		password = "123456",classpath="applicationContext.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(classpath);
		UserDao userDao = context.getBean("userDao",UserDao.class);
		System.out.println(userDao.findUserByEmail("2390309523@qq.com").size());
		UserBiz userBiz = context.getBean("userBiz",UserBiz.class);
		System.out.println(userBiz.findUserByUsername("jiarui123").getDailyName());
	}*/
	
	
	@Test
	public void TestFlower(){
		String classpath="applicationContext.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(classpath);
		FlowerBiz flowerBiz = context.getBean("flowerBiz",FlowerBiz.class);
		System.out.println("FlowerDao:"+flowerBiz.findFlowerByStorenameAndFlowername("栀子花", "城口皇家瑞瑞超市").getId());
	}
	
	/*@Test
	public void TestFlowerFile(){
		String classpath="applicationContext.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(classpath);
		FlowerFileBiz flowerFileBiz = context.getBean("flowerFileBiz",FlowerFileBiz.class);
		System.out.println("FlowerFileBiz:"+flowerFileBiz.getFileByFlowerId(1).size());
	}
	
	@Test
	public void TestStore(){
		String classpath="applicationContext.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(classpath);
		StoreDao storeDao = context.getBean("storeDao",StoreDao.class);
		System.out.print(storeDao.getStoreById(1).getStoreName());
	}
	
	@Test
	public void TestShopCar(){
		String classpath="applicationContext.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(classpath);
		ShopCarDao shopCarDao = context.getBean("shopCarDao",ShopCarDao.class);
		System.out.print(shopCarDao.findShopCarByUsernameAndFlowerId("jiarui123", 4).size());
	}
	
	@Test
	public void TestShopCar(){
		String classpath="applicationContext.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(classpath);
		Order order = new Order();
		order.setFlower("紫罗兰");
		order.setUsername("jiarui123");
		order.setStore("城口瑞瑞超市");
		OrderBiz orderBiz = context.getBean("orderBiz",OrderBiz.class);
		System.out.print(orderBiz.findOrderByInfo(order).getNum());
	}*/
}
