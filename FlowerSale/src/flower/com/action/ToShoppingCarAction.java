package flower.com.action;

import java.util.ArrayList;
import java.util.List;

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

/*查看用户的购物车*/
public class ToShoppingCarAction extends ActionSupport implements
ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpSession session;
	private FlowerBiz flowerBiz;
	private ShopCarBiz shopCarBiz;
	public String toShoppingCar(){
		session  =request.getSession();
		ActionContext context = ActionContext.getContext();
		User user = (User)session.getAttribute("user");
		if("simple_user".equals(user.getIndentity().trim())||"administrator".equals(user.getIndentity())){
			List<ShopCar> shopCars = this.shopCarBiz.findShopCarsByUsername(user.getUsername());
			List<Flower> flowers = new ArrayList<Flower>();
			for(ShopCar shopCar:shopCars){
				Flower flower=  new Flower();
				flower = this.flowerBiz.getFlowerByFlowerId(shopCar.getFlowerId());
				if(null!=flower){
					flowers.add(flower);
				}
			}
			context.put("flowers", flowers);
			context.put("shopCars", shopCars);
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
	public FlowerBiz getFlowerBiz() {
		return flowerBiz;
	}
	public void setFlowerBiz(FlowerBiz flowerBiz) {
		this.flowerBiz = flowerBiz;
	}
	public ShopCarBiz getShopCarBiz() {
		return shopCarBiz;
	}
	public void setShopCarBiz(ShopCarBiz shopCarBiz) {
		this.shopCarBiz = shopCarBiz;
	}

}
