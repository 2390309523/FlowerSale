package flower.com.biz;

import java.util.List;

import flower.com.entity.Order;

public interface OrderBiz {
	/*���붩��*/
	public boolean saveToOrder(Order order);
	/*���¶�����Ϣ*/
	public boolean updataOrder(Order order);
	/*��ѯ�����Ƿ����*/
	public boolean findOrderIsExist(Order order);
	/*��ѯ�Ƿ���ڶ������ҷ���*/
	public Order findOrderByInfo(Order order);
	/*ͨ�����̵�������ORDER*/
	public List<Order> findOrderByStorename(String storename);
	public List<Order> findOrderByUsername(String username);
	public Order findOrderById(int id);
	public List<Order> findOrderByStoreAndCode(String storename,int code);
	public boolean deleteOrder(Order order);
	public List<Order> findOrderByUserAndCode(String username,int code);
}
