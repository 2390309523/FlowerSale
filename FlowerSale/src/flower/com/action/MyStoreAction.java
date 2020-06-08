package flower.com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.FlowerBiz;
import flower.com.entity.Flower;
import flower.com.entity.Store;
import flower.com.entity.User;

/*查询我的花店*/
public class MyStoreAction extends ActionSupport implements
ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpSession session;
	private FlowerBiz flowerBiz;
	private String storeName;
	@Override
	public String execute(){
		ActionContext context = ActionContext.getContext();
		session = request.getSession();
		Store store = (Store)session.getAttribute("store");
		User user = (User)session.getAttribute("user");
		if("simple_user".equals(user.getIndentity())){
			List<Flower> flowers = this.flowerBiz.findFlowersByStoreName(store.getStoreName());
			context.put("myStoreInfo", "0X123");
			context.put("flowers", flowers);
		}else{
			List<Flower> flowers = this.flowerBiz.findFlowersByStoreName(store.getStoreName());
			context.put("myStoreInfo", "0X123");
			context.put("flowers", flowers);
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public FlowerBiz getFlowerBiz() {
		return flowerBiz;
	}
	public void setFlowerBiz(FlowerBiz flowerBiz) {
		this.flowerBiz = flowerBiz;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

}
