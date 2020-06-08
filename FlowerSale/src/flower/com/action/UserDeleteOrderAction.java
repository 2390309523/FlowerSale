package flower.com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.AddressBiz;
import flower.com.biz.FlowerBiz;
import flower.com.biz.OrderBiz;
import flower.com.entity.Order;

public class UserDeleteOrderAction extends ActionSupport
implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] orderCheck;
	private OrderBiz orderBiz;
	private HttpServletRequest request;
	private HttpSession session;
	public String userDeleteOrder(){
		for(String orderId:orderCheck){
			Order order = this.orderBiz.findOrderById(Integer.parseInt(orderId));
			if(0 == order.getStateCode() || 1 == order.getStateCode()){
				order.setStateCode(2);
				this.orderBiz.updataOrder(order);
			}else{
				this.orderBiz.deleteOrder(order);
			}
		}
		return "success";
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	public String[] getOrderCheck() {
		return orderCheck;
	}
	public void setOrderCheck(String[] orderCheck) {
		this.orderCheck = orderCheck;
	}
	public OrderBiz getOrderBiz() {
		return orderBiz;
	}
	public void setOrderBiz(OrderBiz orderBiz) {
		this.orderBiz = orderBiz;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
