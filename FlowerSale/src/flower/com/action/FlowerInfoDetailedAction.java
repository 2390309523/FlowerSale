package flower.com.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.FlowerBiz;
import flower.com.entity.Flower;

/*ª®ª‹œÍ«È“≥√Ê*/
public class FlowerInfoDetailedAction extends ActionSupport{
 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String flowerId;
	public String getFlowerId() {
		return flowerId;
	}
	public void setFlowerId(String flowerId) {
		this.flowerId = flowerId;
	}
	public FlowerBiz getFlowerBiz() {
		return flowerBiz;
	}
	public void setFlowerBiz(FlowerBiz flowerBiz) {
		this.flowerBiz = flowerBiz;
	}
	private FlowerBiz flowerBiz;
	public String flowerInfoDetailed(){
		ActionContext.getContext().put("flower", (Flower)this.flowerBiz.getFlowerByFlowerId(Integer.parseInt(this.flowerId)));
		return "success";
	}
}
