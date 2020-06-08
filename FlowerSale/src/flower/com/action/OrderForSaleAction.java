package flower.com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.OrderBiz;
import flower.com.biz.StoreBiz;
import flower.com.entity.Order;
import flower.com.entity.Store;

/*����������*/
public class OrderForSaleAction extends ActionSupport
implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpSession session;
	private String orderCheck;
	private OrderBiz orderBiz;
	private StoreBiz storeBiz;
	public String orderForSale(){
		System.out.println("-----------------"+this.getOrderCheck()+"------------------");
		String[] orderCheckList = orderCheck.split(",");
		/*session = request.getSession();
		Store store = (Store)session.getAttribute("store");*/
		String senderInfo = new String();
		for(String orderId:orderCheckList){
			Order order = this.orderBiz.findOrderById(Integer.parseInt(orderId.trim()));
			if(0 == order.getStateCode()){
				order.setStateCode(1);
				this.orderBiz.updataOrder(order);
				//store.setStoreSoleNum(store.getStoreSoleNum()+order.getNum());
			}else{
				senderInfo+="�������ܣ�"+order.getFlower()+"\t�������룺"+order.getId();
			}
		}
		//this.storeBiz.updataStoreInfo(store);
		if(!"".equals(senderInfo)){
			senderInfo+="����ʧ�ܣ�ԭ�򣺶����Ѿ���������ɾ����";
			ActionContext.getContext().put("senderInfo", senderInfo);
		}
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
	public String getOrderCheck() {
		return orderCheck;
	}
	public void setOrderCheck(String orderCheck) {
		this.orderCheck = orderCheck;
	}
	public OrderBiz getOrderBiz() {
		return orderBiz;
	}
	public void setOrderBiz(OrderBiz orderBiz) {
		this.orderBiz = orderBiz;
	}
	public StoreBiz getStoreBiz() {
		return storeBiz;
	}
	public void setStoreBiz(StoreBiz storeBiz) {
		this.storeBiz = storeBiz;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
