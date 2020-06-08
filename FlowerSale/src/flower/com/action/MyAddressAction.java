package flower.com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import oracle.net.aso.s;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.AddressBiz;
import flower.com.entity.Address;
import flower.com.entity.User;

public class MyAddressAction extends ActionSupport implements
ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpSession session;
	private AddressBiz addressBiz;
	public String myAddress(){
		session = request.getSession();
		User user = (User)session.getAttribute("user");
		String username = user.getUsername().trim();
		List<Address> addresses = this.addressBiz.findAddressByUsernam(username);
		ActionContext.getContext().put("addresses", addresses);
		ActionContext.getContext().put("myAddressInfo", "0X123");
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
	public AddressBiz getAddressBiz() {
		return addressBiz;
	}
	public void setAddressBiz(AddressBiz addressBiz) {
		this.addressBiz = addressBiz;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
