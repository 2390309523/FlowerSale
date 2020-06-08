package flower.com.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.FlowerBiz;
import flower.com.entity.Flower;

public class ToUpdataFlowerInfo extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FlowerBiz flowerBiz;
	private String flowerId;
	public String toUpdataFlower(){
		ActionContext context = ActionContext.getContext();
		Flower flower = this.flowerBiz.getFlowerByFlowerId(Integer.parseInt(flowerId));
		context.put("flower",flower);
		context.put("toUpdataFlowerInfo", "0x123");
		return "success";
	}
	public FlowerBiz getFlowerBiz() {
		return flowerBiz;
	}
	public void setFlowerBiz(FlowerBiz flowerBiz) {
		this.flowerBiz = flowerBiz;
	}
	public String getFlowerId() {
		return flowerId;
	}
	public void setFlowerId(String flowerId) {
		this.flowerId = flowerId;
	}
}
