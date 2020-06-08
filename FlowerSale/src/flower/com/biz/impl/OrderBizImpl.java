package flower.com.biz.impl;

import java.util.List;

import flower.com.biz.OrderBiz;
import flower.com.dao.OrderDao;
import flower.com.entity.Order;

public class OrderBizImpl implements OrderBiz {
	private OrderDao orderDao;

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public boolean saveToOrder(Order order) {
		// TODO Auto-generated method stub
		return this.orderDao.saveOrder(order);
	}

	@Override
	public boolean updataOrder(Order order) {
		// TODO Auto-generated method stub
		return this.orderDao.updataOrder(order);
	}

	@Override
	public boolean findOrderIsExist(Order order) {
		// TODO Auto-generated method stub
		if(this.orderDao.findOrderByInfo(order.getStore(), order.getUsername(), order.getFlower(),order.getStateCode())!=null){
			return true;
		}
		return false;
	}

	@Override
	public Order findOrderByInfo(Order order) {
		// TODO Auto-generated method stub
		List<Order> orders = this.orderDao.findOrderByInfo(order.getStore(), order.getUsername(), order.getFlower(),order.getStateCode());
		if(null == orders){
			return null;
		}else{
			for(Order o:orders){
				if(o.getUsername().equals(order.getUsername()) && o.getFlower().equals(order.getFlower())){
					return o;
				}
			}return null;
		}
	}

	@Override
	public List<Order> findOrderByStorename(String storename) {
		// TODO Auto-generated method stub
		return this.orderDao.findOrderByStoreName(storename);
	}

	@Override
	public List<Order> findOrderByUsername(String username) {
		// TODO Auto-generated method stub
		return this.orderDao.findOrderByUserName(username);
	}

	@Override
	public Order findOrderById(int id) {
		// TODO Auto-generated method stub
		return this.orderDao.findOrderById(id);
	}

	@Override
	public List<Order> findOrderByStoreAndCode(String storename,int code) {
		// TODO Auto-generated method stub
		return this.orderDao.findOrderByStorenameAndStateCode(storename, code);
	}

	@Override
	public boolean deleteOrder(Order order) {
		// TODO Auto-generated method stub
		return this.orderDao.deleteOrder(order);
	}

	@Override
	public List<Order> findOrderByUserAndCode(String username, int code) {
		// TODO Auto-generated method stub
		return this.orderDao.findOrderByUsernameAndStateCode(username, code);
	}
}
