package flower.com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.AddressBiz;
import flower.com.biz.FlowerBiz;
import flower.com.biz.OrderBiz;
import flower.com.biz.ShopCarBiz;
import flower.com.biz.StoreBiz;
import flower.com.entity.Address;
import flower.com.entity.Flower;
import flower.com.entity.Order;
import flower.com.entity.Store;
import flower.com.entity.User;
/*addToShoppingCar将商品加入订单*/
public class AddToOrderAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrderBiz orderBiz;
	private FlowerBiz flowerBiz;
	private AddressBiz addressBiz;
	private StoreBiz storeBiz;
	private HttpServletRequest request;
	private HttpSession session;
	private String flowerNum;
	private String flowerId;
	public String addToOrder(){
		ActionContext context = ActionContext.getContext();
		session = request.getSession();
		User user = (User)session.getAttribute("user");
		Address address = this.addressBiz.findAddressByUsernameAndIsDefault(user.getUsername(), 1);
		Flower flower = this.flowerBiz.getFlowerByFlowerId(Integer.parseInt(this.flowerId));
		/*Store store = this.storeBiz.getStoreByStoreName(flower.getStoreName());
		store.setStoreSoleNum(store.getStoreSoleNum()+Integer.parseInt(this.flowerNum));
		this.storeBiz.updataStoreInfo(store);*/
		Order order = new Order();
		order.setStore(flower.getStoreName());
		order.setUsername(user.getUsername());
		order.setNum(Integer.parseInt(this.flowerNum));
		order.setStateCode(0);
		order.setFlower(flower.getFlowerName());
		if(orderBiz.findOrderByInfo(order)!=null){
			try{
				
				order = this.orderBiz.findOrderByInfo(order);
				order.setNum(order.getNum()+Integer.parseInt(this.flowerNum));
				context.put("addInfo","加入订单成功，等待卖家审核，订单详情可以前往个人中心查看，商品详情：花名"+flower.getFlowerName()+"；单价："+
							flower.getFlowerUpdataPrice()+"；件数："+order.getNum()+
							";总价："+flower.getFlowerUpdataPrice()*order.getNum());
				Store store = this.storeBiz.getStoreByStoreName(flower.getStoreName());
				store.setStoreSoleNum(store.getStoreSoleNum()+Integer.parseInt(this.flowerNum));
				this.storeBiz.updataStoreInfo(store);
				flower.setFlowerStoke(flower.getFlowerStoke()-Integer.parseInt(this.flowerNum));
				if(null!=address){
					order.setAddressId(address.getId());
				}
				this.orderBiz.updataOrder(order);
			}catch(Exception e){
				e.printStackTrace();
				context.put("addInfo","加入订单失败，错误码"+e);
			}
		}else{
			try{
				context.put("addInfo","加入订单成功，等待卖家审核，订单详情可以前往个人中心查看，商品详情：花名"+flower.getFlowerName()+"；单价："+
							flower.getFlowerUpdataPrice()+"；件数："+this.flowerNum+
							";总价："+flower.getFlowerUpdataPrice()*Integer.parseInt(this.flowerNum));
				flower.setFlowerStoke(flower.getFlowerStoke()-Integer.parseInt(this.flowerNum));
				Store store = this.storeBiz.getStoreByStoreName(flower.getStoreName());
				store.setStoreSoleNum(store.getStoreSoleNum()+Integer.parseInt(this.flowerNum));
				this.storeBiz.updataStoreInfo(store);
				if(null!=address){
					order.setAddressId(address.getId());
				}
				this.orderBiz.saveToOrder(order);
			}catch(Exception e){
				e.printStackTrace();
				context.put("addInfo","加入订单失败，错误码"+e);
			}
		}
		this.flowerBiz.updataFlowerInfo(flower);
		return "success";
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
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

	public String getFlowerNum() {
		return flowerNum;
	}

	public void setFlowerNum(String flowerNum) {
		this.flowerNum = flowerNum;
	}

	public String getFlowerId() {
		return flowerId;
	}

	public void setFlowerId(String flowerId) {
		this.flowerId = flowerId;
	}

	public AddressBiz getAddressBiz() {
		return addressBiz;
	}

	public void setAddressBiz(AddressBiz addressBiz) {
		this.addressBiz = addressBiz;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public StoreBiz getStoreBiz() {
		return storeBiz;
	}

	public void setStoreBiz(StoreBiz storeBiz) {
		this.storeBiz = storeBiz;
	}
	

}
