package flower.com.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.StoreBiz;
import flower.com.biz.UserBiz;
import flower.com.entity.Store;
import flower.com.entity.User;

/*用户登录*/
public class LoginAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpSession session;
	private StoreBiz storeBiz;
	private String username;
	private String password;
	private String identity;
	private UserBiz userBiz;
	public String login(){
		session = request.getSession();
		ActionContext context = ActionContext.getContext();
		User user = new User();
		if(this.username.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")){
			user = this.userBiz.findUserByEmailAndPassword(username, password);
		}else{
			user = this.userBiz.findUserByUsername(username); 
		}
		if(user == null){
			context.put("loginInfo", "没有该用户,检查用户名是否正确");
			return "default";
		}else{
			if(password.trim().equals(user.getPassword())){
				if(identity.trim().equals(user.getIndentity())){
					if("simple_user".equals(user.getIndentity())){
						session.setAttribute("user", user);
						user.setUpdataTime(new Timestamp(System.currentTimeMillis()));
						this.userBiz.updataUser(user);
						context.put("loginInfo", "登录成功，尊敬的客户"+user.getDailyName());
						return "success";
					}else{
						session.setAttribute("user", user);
						user.setUpdataTime(new Timestamp(System.currentTimeMillis()));
						this.userBiz.updataUser(user);
						context.put("loginInfo", "登录成功，尊敬的"+user.getStoreName()+"店主"+user.getDailyName());
						session.setAttribute("store", (Store)this.storeBiz.getStoreByStoreName(user.getStoreName()));
						return "success";
					}
				}else{
					context.put("loginInfo", "身份不匹配");
					return "default";
				}
			}else{
				context.put("loginInfo", "密码错误");
				return "default";
			}
		}
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
	public StoreBiz getStoreBiz() {
		return storeBiz;
	}
	public void setStoreBiz(StoreBiz storeBiz) {
		this.storeBiz = storeBiz;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public UserBiz getUserBiz() {
		return userBiz;
	}
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	
}
