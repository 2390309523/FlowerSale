package flower.com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.FlowerBiz;
import flower.com.biz.ShopCarBiz;
import flower.com.entity.Flower;
import flower.com.entity.ShopCar;
import flower.com.entity.User;

/*将商品加入购物车*/
public class AddToShopCarAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ShopCarBiz shopCarBiz;
	private FlowerBiz flowerBiz;
	private HttpServletRequest request;
	private HttpSession session;
	private String flowerNum;
	private String flowerId;
	public String addToShopCar(){
		ActionContext context = ActionContext.getContext();
		ShopCar car = new ShopCar();
		User user = (User)request.getSession().getAttribute("user");
		car.setFlowerNum(Integer.parseInt(this.flowerNum));
		car.setUsername(user.getUsername());
		car.setFlowerId(Integer.parseInt(this.flowerId));
		if(null != this.shopCarBiz.findShopCarByCar(car)){
			car  =this.shopCarBiz.findShopCarByCar(car);
			car.setFlowerNum(car.getFlowerNum()+Integer.parseInt(this.flowerNum));
			try{
				Flower flower = this.flowerBiz.getFlowerByFlowerId(Integer.parseInt(this.flowerId));
				context.put("addInfo", "加入购物车成功，商品详情:花名："+
						flower.getFlowerName()+";件数："+car.getFlowerNum()+";单价："+
						flower.getFlowerUpdataPrice()+";总价："+(flower.getFlowerUpdataPrice()*Integer.parseInt(this.flowerNum)));
				this.shopCarBiz.updataShopCar(car);
				flower.setFlowerStoke(flower.getFlowerStoke()-Integer.parseInt(this.flowerNum));
				this.flowerBiz.updataFlowerInfo(flower);
			}catch(Exception e){
				context.put("addInfo", "加入购物车失败，错误码："+e);
				
			}
		}else{
			try{
				Flower flower = this.flowerBiz.getFlowerByFlowerId(Integer.parseInt(this.flowerId));
				context.put("addInfo", "加入购物车成功，商品详情:花名："+
						flower.getFlowerName()+";件数："+car.getFlowerNum()+";单价："+
						flower.getFlowerUpdataPrice()+";总价："+(flower.getFlowerUpdataPrice()*Integer.parseInt(this.flowerNum)));
				car.setStateCode(0);
				this.shopCarBiz.saveToShopCar(car);
				flower.setFlowerStoke(flower.getFlowerStoke()-Integer.parseInt(this.flowerNum));
				this.flowerBiz.updataFlowerInfo(flower);
			}catch(Exception e){
				context.put("addInfo", "加入购物车失败，错误码："+e);
				
			}
		}
		return "success";
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	public ShopCarBiz getShopCarBiz() {
		return shopCarBiz;
	}
	public void setShopCarBiz(ShopCarBiz shopCarBiz) {
		this.shopCarBiz = shopCarBiz;
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
	public FlowerBiz getFlowerBiz() {
		return flowerBiz;
	}
	public void setFlowerBiz(FlowerBiz flowerBiz) {
		this.flowerBiz = flowerBiz;
	}

}
