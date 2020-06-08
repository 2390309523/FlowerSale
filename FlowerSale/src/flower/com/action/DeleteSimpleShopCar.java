package flower.com.action;

import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.ShopCarBiz;
import flower.com.entity.ShopCar;

/*删除一个购物车*/
public class DeleteSimpleShopCar extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ShopCarBiz shopCarBiz;
	private String shopCarId;
	public String deleteSimpleShopCar(){
		ShopCar shopCar = this.shopCarBiz.findShopPCarById(Integer.parseInt(shopCarId));
		this.shopCarBiz.deleteSingleShopCar(shopCar);
		return "success";
	}
	public ShopCarBiz getShopCarBiz() {
		return shopCarBiz;
	}
	public void setShopCarBiz(ShopCarBiz shopCarBiz) {
		this.shopCarBiz = shopCarBiz;
	}
	public String getShopCarId() {
		return shopCarId;
	}
	public void setShopCarId(String shopCarId) {
		this.shopCarId = shopCarId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
