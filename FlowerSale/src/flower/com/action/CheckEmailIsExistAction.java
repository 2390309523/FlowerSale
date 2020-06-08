package flower.com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.UserBiz;
import flower.com.entity.User;

public class CheckEmailIsExistAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private UserBiz userBiz;
	public void checkEmail() throws IOException{
		List<User> users = this.userBiz.findUserByEmail(this.email.toUpperCase());
		if(users.size()>0){
			String info = "yes";
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(info.trim());
			out.flush();
			out.close();
		}
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserBiz getUserBiz() {
		return userBiz;
	}
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
