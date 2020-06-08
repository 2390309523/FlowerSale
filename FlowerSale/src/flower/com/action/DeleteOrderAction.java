package flower.com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.OrderBiz;
import flower.com.entity.Order;

/*删除订单*/
public class DeleteOrderAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrderBiz orderBiz;
	private String orderCheck;
	public String deleteOrder(){
		if(orderCheck!=null) System.out.println("-----------------"+orderCheck+"------------------");
		String deleterInfo = new String();
		String[] orderCheckList = orderCheck.split(",");
		for(String orderId:orderCheckList){
			Order order = this.orderBiz.findOrderById(Integer.parseInt(orderId.trim()));
			if(1 == order.getStateCode()){
				order.setStateCode(2);
				this.orderBiz.updataOrder(order);
			}else{
				deleterInfo+="订单花卉："+order.getFlower()+"\t订单号码："+order.getId();
			}	
		}
		if(!"".equals(deleterInfo)){
			deleterInfo+="删除失败，原因：您还没有发货，删除个屁啊！";
			ActionContext.getContext().put("deleterInfo", deleterInfo);
		}
		return "success";
	}
	public OrderBiz getOrderBiz() {
		return orderBiz;
	}
	public void setOrderBiz(OrderBiz orderBiz) {
		this.orderBiz = orderBiz;
	}
	public String getOrderCheck() {
		return orderCheck;
	}
	public void setOrderCheck(String orderCheck) {
		this.orderCheck = orderCheck;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
