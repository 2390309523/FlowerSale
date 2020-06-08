package flower.com.dao;

import java.util.List;

import flower.com.entity.Order;

public interface OrderDao {
	/*���涩��*/
	public boolean saveOrder(Order order);
	/*ͨ��id��Order*/
	public Order findOrderById(int orderId);
	/*��ȡ�û��µ����ж���*/
	public List<Order> findOrderByUserName(String username);
	/*��ȡ�����µ����ж���*/
	public List<Order> findOrderByStoreId(int storeId);
	public List<Order> findOrderByStoreName(String storeName);
	/*ɾ������*/
	public boolean deleteOrder(List<Order> orders);
	/*ɾ������*/
	public boolean deleteOrder(Order order);
	/*���¶�����Ϣ*/
	public boolean updataOrder(Order order);
	/*��ȡ������Ϣͨ��username��store,flower*/
	public List<Order> findOrderByInfo(String store,String username,String flower,int stateCode);
	public List<Order> findOrderByStorenameAndStateCode(String storeName,int code);
	public List<Order> findOrderByUsernameAndStateCode(String username,int code);
}
