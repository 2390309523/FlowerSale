package flower.com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

/*ÍË³öµÇÂ¼*/
public class LoginOutAction extends ActionSupport
implements ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpSession session;
	/*ÍË³öµÇÂ¼£¬Ïú»Ùsession*/
	@Override
	public String execute(){
		session = this.request.getSession();
		session.removeAttribute("user");
		session.removeAttribute("store");
		session.removeAttribute("flower");
		return "success";
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
	
}
