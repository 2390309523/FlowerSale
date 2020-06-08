package flower.com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.FlowerBiz;
import flower.com.entity.Flower;
import flower.com.entity.Store;

public class GetStoreAndFlowerNameAction extends ActionSupport implements
ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpSession session;
	private FlowerBiz flowerBiz;
	private String flowerName;
	public void getStoreAndFlowerName() throws IOException{
		session = request.getSession();
		Store store = (Store)session.getAttribute("store");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Flower flower = new Flower();
		for(Flower f:this.flowerBiz.findFlowerByStoreAndFlower(this.flowerName, store.getStoreName())){
			if(f.getFlowerName().equals(this.flowerName)){
				flower = f;
			}
		}
		if(this.flowerName.equals(flower.getFlowerName())){
			String flowerInfo = "yes";
			out.print(flowerInfo);
			out.flush();
			out.close();
			flower = null;
			
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
	public FlowerBiz getFlowerBiz() {
		return flowerBiz;
	}
	public void setFlowerBiz(FlowerBiz flowerBiz) {
		this.flowerBiz = flowerBiz;
	}
	public String getFlowerName() {
		return flowerName;
	}
	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}

}
