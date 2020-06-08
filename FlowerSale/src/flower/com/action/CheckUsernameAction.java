package flower.com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.UserBiz;

public class CheckUsernameAction extends ActionSupport{
	private String username;
	private UserBiz userBiz;
	public void checkUsername() throws IOException{
		HttpServletResponse response  = ServletActionContext.getResponse();
		String info = "";
		if(this.userBiz.isExistUser(username)){ /*”√ªß¥Ê‘⁄*/
			info= "yes";
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(info);
			out.flush();
			out.close();
		}
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserBiz getUserBiz() {
		return userBiz;
	}
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
}
