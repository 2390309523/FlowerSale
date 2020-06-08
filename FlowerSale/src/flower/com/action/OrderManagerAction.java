package flower.com.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.FlowerBiz;
import flower.com.biz.OrderBiz;
import flower.com.biz.UserBiz;
import flower.com.entity.Flower;
import flower.com.entity.Order;
import flower.com.entity.Store;
import flower.com.entity.User;

/*订单管理*/
public class OrderManagerAction extends ActionSupport implements
ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpSession session;
	private OrderBiz orderBiz;
	private FlowerBiz flowerBiz;
	private UserBiz userBiz;
	@Override
	public String execute(){
		session = request.getSession();
		Store store = (Store)session.getAttribute("store");
		List<Order> orders = this.orderBiz.findOrderByStorename(store.getStoreName());
		List<Flower> flowers  = new ArrayList<Flower>();
		List<User> users = new ArrayList<User>();
		System.out.println(orders.size());
		for(Order order:orders){
			Flower flower = this.flowerBiz.findFlowerByStorenameAndFlowername(order.getFlower(),store.getStoreName());
			User user = this.userBiz.findUserByUsername(order.getUsername());
			flowers.add(flower);
			users.add(user);
			if(flower!=null) System.out.println(flower.getFlowerName());
		}
		System.out.println("flowers:"+flowers.size());
		System.out.println("users:"+users.size());
		ActionContext.getContext().put("orders", orders);
		ActionContext.getContext().put("flowers", flowers);
		ActionContext.getContext().put("users", users);
		ActionContext.getContext().put("orderManagerInfo", "订单提交成功");
		return "success";
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	public OrderBiz getOrderBiz() {
		return orderBiz;
	}
	public void setOrderBiz(OrderBiz orderBiz) {
		this.orderBiz = orderBiz;
	}
	public FlowerBiz getFlowerBiz() {
		return flowerBiz;
	}
	public void setFlowerBiz(FlowerBiz flowerBiz) {
		this.flowerBiz = flowerBiz;
	}
	public UserBiz getUserBiz() {
		return userBiz;
	}
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	
}
