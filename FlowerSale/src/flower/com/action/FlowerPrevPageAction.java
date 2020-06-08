package flower.com.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.FlowerBiz;
import flower.com.entity.Flower;
import flower.com.paging.Paging;

/*…œ“ª“≥*/
public class FlowerPrevPageAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
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
	public Paging getFlowerPaging() {
		return flowerPaging;
	}
	public void setFlowerPaging(Paging flowerPaging) {
		this.flowerPaging = flowerPaging;
	}
	private HttpSession session;
	private FlowerBiz flowerBiz;
	private Paging flowerPaging;
	public String flowerPrevPaging(){
		session = request.getSession();
		List<Flower> flowers = new ArrayList<Flower>();
		flowerPaging = (Paging)session.getAttribute("flowerPaging");
		if(flowerPaging.getFirstIndex()<=flowerPaging.getAdder()){
			flowerPaging.setFirstIndex(0);
			flowerPaging.setMaxIndex(flowerPaging.getAdder());
			flowers = this.flowerBiz.getFlowerPaging(flowerPaging.getFirstIndex(), flowerPaging.getMaxIndex());
			ActionContext.getContext().put("flowers",flowers);
		}else{
			flowerPaging.setFirstIndex(flowerPaging.getFirstIndex()-flowerPaging.getAdder());
			flowerPaging.setMaxIndex(flowerPaging.getMaxIndex()-flowerPaging.getAdder());
			flowers = this.flowerBiz.getFlowerPaging(flowerPaging.getFirstIndex(),flowerPaging.getMaxIndex());
			ActionContext.getContext().put("flowers", flowers);
		}
		session.setAttribute("flowerPaging", flowerPaging);
		return "success";
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
}
