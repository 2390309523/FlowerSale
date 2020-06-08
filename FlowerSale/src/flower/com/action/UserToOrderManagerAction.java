package flower.com.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.AddressBiz;
import flower.com.biz.FlowerBiz;
import flower.com.biz.OrderBiz;
import flower.com.entity.Address;
import flower.com.entity.Flower;
import flower.com.entity.Order;
import flower.com.entity.User;

public class UserToOrderManagerAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpSession session;
	private AddressBiz addressBiz;
	private OrderBiz orderBiz;
	private FlowerBiz flowerBiz;
	public String userToOrderManager(){
		ActionContext context  = ActionContext.getContext();
		session = request.getSession();
		User user= (User)session.getAttribute("user");
		List<Order> orders = this.orderBiz.findOrderByUsername(user.getUsername());
		List<Flower> flowers = new ArrayList<Flower>();
		List<Address> addresses = new ArrayList<Address>();
		for(Order order:orders){
			flowers.add(this.flowerBiz.findFlowerByStorenameAndFlowername(order.getFlower(), order.getStore()));
			if("".equals(order.getAddressId()) || order.getAddressId() == null){
				Address address=this.addressBiz.findUserDefault(order.getUsername());
				if(address!=null){
					order.setAddressId(address.getId());
				}
				this.orderBiz.updataOrder(order);
				addresses.add(address);
			}else{
				addresses.add(this.addressBiz.findAddressById(order.getAddressId()));
			}
			
		}
		context.put("flowers", flowers);
		context.put("orders", orders);
		context.put("addresses", addresses);
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
	public AddressBiz getAddressBiz() {
		return addressBiz;
	}
	public void setAddressBiz(AddressBiz addressBiz) {
		this.addressBiz = addressBiz;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
