package flower.com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import sun.security.krb5.internal.PAData;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.FlowerBiz;
import flower.com.entity.Flower;
import flower.com.paging.Paging;

/*
 * 欢迎页面，获取花卉，并且返回
 * */
public class WelcomeAction extends ActionSupport implements ServletRequestAware{
	private FlowerBiz flowerBiz;
	private HttpServletRequest request;
	private HttpSession session;
	public FlowerBiz getFlowerBiz() {
		return flowerBiz;
	}

	public void setFlowerBiz(FlowerBiz flowerBiz) {
		this.flowerBiz = flowerBiz;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String welcome(){
		ActionContext context = ActionContext.getContext();
		session = request.getSession();
		Paging paging = new Paging(0, 0, 0, 0);
		paging.setAdder(50);
		paging.setFirstIndex(0);
		paging.setMaxIndex(50);
		paging.setSumRecord(this.flowerBiz.getAllFlowers().size());
		List<Flower> flowers = this.flowerBiz.getFlowerPaging(paging.getFirstIndex(),paging.getMaxIndex());
		session.setAttribute("flowerPaging", paging);
		context.put("flowers",flowers);
		return "success";
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
}
