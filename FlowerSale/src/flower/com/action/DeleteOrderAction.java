package flower.com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.OrderBiz;
import flower.com.entity.Order;

/*ɾ������*/
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
				deleterInfo+="�������ܣ�"+order.getFlower()+"\t�������룺"+order.getId();
			}	
		}
		if(!"".equals(deleterInfo)){
			deleterInfo+="ɾ��ʧ�ܣ�ԭ������û�з�����ɾ����ƨ����";
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
