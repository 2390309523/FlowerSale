package flower.com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import flower.com.entity.User;

public class ToPersonalPageAction extends ActionSupport
implements ServletRequestAware{
	private User user;
	private HttpServletRequest request;
	private HttpSession session;
	@Override
	public String execute(){
		session = request.getSession();
		user = (User)session.getAttribute("user");
		if("simple_user".equals(user.getIndentity())){
			return "simple_user";
		}else{
			return "administrator";
		}
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	
}
