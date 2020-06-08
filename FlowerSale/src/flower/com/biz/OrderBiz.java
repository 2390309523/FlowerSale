package flower.com.biz;

import java.util.List;

import flower.com.entity.Order;

public interface OrderBiz {
	/*加入订单*/
	public boolean saveToOrder(Order order);
	/*更新订单信息*/
	public boolean updataOrder(Order order);
	/*查询订单是否存在*/
	public boolean findOrderIsExist(Order order);
	/*查询是否存在订单并且返回*/
	public Order findOrderByInfo(Order order);
	/*通过店铺的名字找ORDER*/
	public List<Order> findOrderByStorename(String storename);
	public List<Order> findOrderByUsername(String username);
	public Order findOrderById(int id);
	public List<Order> findOrderByStoreAndCode(String storename,int code);
	public boolean deleteOrder(Order order);
	public List<Order> findOrderByUserAndCode(String username,int code);
}
