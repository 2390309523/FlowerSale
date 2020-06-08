package flower.com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.UserBiz;
import flower.com.entity.User;

/*修改密码*/
public class ChangePasswordAction extends ActionSupport implements
ServletRequestAware{
	private HttpServletRequest request;
	private HttpSession session;
	private UserBiz userBiz;
	private User user;
	private String password;
	private String changePassword1;
	private String changePassword2;
	public UserBiz getUserBiz() {
		return userBiz;
	}
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getChangePassword1() {
		return changePassword1;
	}
	public void setChangePassword1(String changePassword1) {
		this.changePassword1 = changePassword1;
	}
	public String getChangePassword2() {
		return changePassword2;
	}
	public void setChangePassword2(String changePassword2) {
		this.changePassword2 = changePassword2;
	}
	public String changePassword(){
		session = request.getSession();
		user = (User)session.getAttribute("user");
		if(password.equals(user.getPassword())){
			if(this.changePassword1.equals(this.changePassword2)){
				user.setPassword(changePassword1);
				this.userBiz.updataUser(user);
				ActionContext.getContext().put("changePasswordInfo", "修改密码成功，请重新登录");
				return "success";
			}
		}
		if("simple_user".equals(user.getIndentity())) return "simpleUserDafault";
		else return "administratorDefault";
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
}
