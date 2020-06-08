package flower.com.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.FlowerBiz;
import flower.com.biz.FlowerFileBiz;
import flower.com.entity.Flower;
import flower.com.entity.FlowerFile;

public class FlowerInfoAction extends  ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String flowerId;
	private FlowerBiz flowerBiz;
	private FlowerFileBiz flowerFileBiz;
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
	public FlowerFileBiz getFlowerFileBiz() {
		return flowerFileBiz;
	}
	public void setFlowerFileBiz(FlowerFileBiz flowerFileBiz) {
		this.flowerFileBiz = flowerFileBiz;
	}
	public String flowerInfo(){
		ActionContext context = ActionContext.getContext();
		Flower flower = new Flower();
		flower = this.flowerBiz.getFlowerByFlowerId(Integer.parseInt(this.flowerId));
		List<FlowerFile> flowerFiles = this.flowerFileBiz.getFileByFlowerId(flower.getId());
		context.put("flower", flower);
		context.put("flowerFiles", flowerFiles);
		return "success";
	}

}
