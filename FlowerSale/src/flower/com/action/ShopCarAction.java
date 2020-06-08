package flower.com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.FlowerBiz;
import flower.com.biz.ShopCarBiz;
import flower.com.entity.User;

/*¹ºÎï³µ*/
public class ShopCarAction extends ActionSupport implements ServletRequestAware{
	private HttpServletRequest request;
	private HttpSession session;
	private ShopCarBiz shopCarBiz;
	private FlowerBiz flowerBiz;
	
	@Override
	public String execute(){
		session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		return "";
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
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
	public FlowerBiz getFlowerBiz() {
		return flowerBiz;
	}
	public void setFlowerBiz(FlowerBiz flowerBiz) {
		this.flowerBiz = flowerBiz;
	}
}
