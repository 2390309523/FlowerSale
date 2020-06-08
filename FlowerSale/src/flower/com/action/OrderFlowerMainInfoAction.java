package flower.com.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.FlowerBiz;
import flower.com.biz.FlowerFileBiz;
import flower.com.biz.OrderBiz;
import flower.com.entity.Flower;
import flower.com.entity.FlowerFile;
import flower.com.entity.Order;

public class OrderFlowerMainInfoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrderBiz orderBiz;
	private FlowerBiz flowerBiz;
	private FlowerFileBiz flowerFileBiz;
	private String orderId;
	
	@Override
	public String execute(){
		ActionContext context = ActionContext.getContext();
		Order order = this.orderBiz.findOrderById(Integer.parseInt(orderId));
		System.out.println(order.getStore()+";"+order.getFlower());
		Flower flower = this.flowerBiz.findFlowerByStorenameAndFlowername(order.getFlower(),order.getStore());
		List<FlowerFile> flowerFiles = this.flowerFileBiz.getFileByFlowerId(flower.getId());
		context.put("flower", flower);
		context.put("flowerFiles", flowerFiles);
		return "success";
	}
	public OrderBiz getOrderBiz() {
		return orderBiz;
	}
	public void setOrderBiz(OrderBiz orderBiz) {
		this.orderBiz = orderBiz;
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
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}
