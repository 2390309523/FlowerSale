package flower.com.dao;

import java.util.List;

import flower.com.entity.Order;

public interface OrderDao {
	/*保存订单*/
	public boolean saveOrder(Order order);
	/*通过id找Order*/
	public Order findOrderById(int orderId);
	/*获取用户下的所有订单*/
	public List<Order> findOrderByUserName(String username);
	/*获取店铺下的所有订单*/
	public List<Order> findOrderByStoreId(int storeId);
	public List<Order> findOrderByStoreName(String storeName);
	/*删除订单*/
	public boolean deleteOrder(List<Order> orders);
	/*删除订单*/
	public boolean deleteOrder(Order order);
	/*更新订单信息*/
	public boolean updataOrder(Order order);
	/*获取订单信息通过username，store,flower*/
	public List<Order> findOrderByInfo(String store,String username,String flower,int stateCode);
	public List<Order> findOrderByStorenameAndStateCode(String storeName,int code);
	public List<Order> findOrderByUsernameAndStateCode(String username,int code);
}
