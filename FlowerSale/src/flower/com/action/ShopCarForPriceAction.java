package flower.com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.FlowerBiz;
import flower.com.biz.OrderBiz;
import flower.com.biz.ShopCarBiz;
import flower.com.biz.StoreBiz;
import flower.com.entity.Flower;
import flower.com.entity.Order;
import flower.com.entity.ShopCar;
import flower.com.entity.Store;
import flower.com.entity.User;

public class ShopCarForPriceAction extends ActionSupport implements ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpSession session;
	private StoreBiz storeBiz;
	private ShopCarBiz shopCarBiz;
	private OrderBiz orderBiz;
	private FlowerBiz flowerBiz;
	private String[] flowerCheched; //复选框
	private String[] flowerChose;	//输入框
	public String shopCarForPrice(){
		session = request.getSession();
		User user = (User)session.getAttribute("user");
		ShopCar shopCar = new ShopCar();
		Order order = new Order();
		Flower flower = new Flower();
		Store store = new Store();
		System.out.println();
		for(int i = 0 ;i<flowerCheched.length;i++){
			shopCar = this.shopCarBiz.findShopPCarById(Integer.parseInt(flowerCheched[i]));
			flower = this.flowerBiz.getFlowerByFlowerId(shopCar.getFlowerId());
			store = this.storeBiz.getStoreByStoreName(flower.getStoreName());
			order.setNum(Integer.parseInt(flowerChose[i]));
			order.setFlower(flower.getFlowerName());
			order.setStateCode(0);
			order.setUsername(user.getUsername());
			order.setStore(store.getStoreName());
			Order o = this.orderBiz.findOrderByInfo(order);
			if(null!=o){
				o.setNum(order.getNum()+store.getStoreSoleNum());
				this.orderBiz.updataOrder(o);
			}else{
				this.orderBiz.saveToOrder(order);
			}
			store.setStoreSoleNum(order.getNum()+store.getStoreSoleNum());
			this.storeBiz.updataStoreInfo(store);
		}
		user=null;shopCar=null;order=null;store=null;
		ActionContext.getContext().put("shopCarForPriceInfo", "购买成功");
		return "success";
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request =request;
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
	public StoreBiz getStoreBiz() {
		return storeBiz;
	}
	public void setStoreBiz(StoreBiz storeBiz) {
		this.storeBiz = storeBiz;
	}
	public ShopCarBiz getShopCarBiz() {
		return shopCarBiz;
	}
	public void setShopCarBiz(ShopCarBiz shopCarBiz) {
		this.shopCarBiz = shopCarBiz;
	}
	public String[] getFlowerCheched() {
		return flowerCheched;
	}
	public void setFlowerCheched(String[] flowerCheched) {
		this.flowerCheched = flowerCheched;
	}
	public String[] getFlowerChose() {
		return flowerChose;
	}
	public void setFlowerChose(String[] flowerChose) {
		this.flowerChose = flowerChose;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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

}
