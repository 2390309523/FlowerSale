package flower.com.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.FlowerBiz;
import flower.com.entity.Flower;

/*Ä£ºý²éÑ¯*/
public class FuzzySearchAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FlowerBiz flowerBiz;
	private String searchInfo;
	public FlowerBiz getFlowerBiz() {
		return flowerBiz;
	}
	public void setFlowerBiz(FlowerBiz flowerBiz) {
		this.flowerBiz = flowerBiz;
	}
	public String getSearchInfo() {
		return searchInfo;
	}
	public void setSearchInfo(String searchInfo) {
		this.searchInfo = searchInfo;
	}
	public String fuzzySearch(){
		String isNum = "^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$";
		List<Flower> flowers;
		try{
			if(this.getSearchInfo() != null){
				if(this.searchInfo.matches(isNum)){
					flowers = this.flowerBiz.getFlowersByPrice(Float.parseFloat(searchInfo));
				}else{
					flowers = this.flowerBiz.getFlowersBySearchInfo(searchInfo);
				}
			}else{
				flowers = this.flowerBiz.getAllFlowers();
			}
		}catch(Exception e){
			e.printStackTrace();
			flowers = this.flowerBiz.getAllFlowers();
			return "default";
		}
		ActionContext.getContext().put("flowers", flowers);
		return "success";
	}
}
