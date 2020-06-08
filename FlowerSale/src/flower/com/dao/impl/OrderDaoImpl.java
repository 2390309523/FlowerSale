package flower.com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import flower.com.dao.OrderDao;
import flower.com.entity.Order;

@Repository("orderDao")
public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {

	@Override
	public boolean saveOrder(Order order) {
		// TODO Auto-generated method stub
		try{
			this.getHibernateTemplate().save(order);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Order> findOrderByUserName(String username) {
		// TODO Auto-generated method stub
		String hql = "from Order o where o.username=?";
		return (List<Order>)this.getHibernateTemplate().find(hql, username);
	}

	@Override
	public List<Order> findOrderByStoreId(int storeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findOrderByStoreName(String storeName) {
		// TODO Auto-generated method stub
		String hql = "from Order o where o.store=?";
		return (List<Order>)this.getHibernateTemplate().find(hql, storeName);
	}

	@Override
	public boolean deleteOrder(List<Order> orders) {
		try{
			for(Order order:orders){
				this.getHibernateTemplate().delete(order);
			}return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteOrder(Order order) {
		// TODO Auto-generated method stub
		try{
			this.getHibernateTemplate().delete(order);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updataOrder(Order order) {
		// TODO Auto-generated method stub
		try{
			this.getHibernateTemplate().update(order);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public List<Order> findOrderByInfo(String store, String username,
			String flower,int stateCode) {
		// TODO Auto-generated method stub
		String hql = "from Order order where order.store=? and order.username=? and order.flower=? and order.stateCode=?";
		Object[] obj = {store,username,flower,stateCode};
		return (List<Order>)this.getHibernateTemplate().find(hql, obj);
	}

	@Override
	public Order findOrderById(int orderId) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Order.class, orderId);
	}

	@Override
	public List<Order> findOrderByStorenameAndStateCode(String storeName,
			int code) {
		// TODO Auto-generated method stub
		String hql = "from Order order where order.store=? and order.stateCode=?";
		Object[] obj = {storeName,code};
		return (List<Order>)this.getHibernateTemplate().find(hql, obj);
	}

	@Override
	public List<Order> findOrderByUsernameAndStateCode(String username, int code) {
		// TODO Auto-generated method stub
		String hql = "from Order o where o.username=? and stateCode=?";
		Object[] obj = {username,code};
		return (List<Order>)this.getHibernateTemplate().find(hql, obj);
	}

}
