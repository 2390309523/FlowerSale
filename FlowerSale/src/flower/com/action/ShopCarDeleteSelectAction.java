package flower.com.action;

import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.ShopCarBiz;
import flower.com.entity.ShopCar;

/*删除所选的 的购物车*/
public class ShopCarDeleteSelectAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ShopCarBiz shopCarBiz;
	private String[] flowerCheched;
	public String shopCarDeleteSelect(){
		System.out.println("----------------"+flowerCheched+"-----------");
		ShopCar shopCar = new ShopCar();
		for(String carId:flowerCheched){
			shopCar = this.shopCarBiz.findShopPCarById(Integer.parseInt(carId));
			this.shopCarBiz.deleteSingleShopCar(shopCar);
		}
		return "success";
	}
	public ShopCarBiz getShopCarBiz() {
		return shopCarBiz;
	}
	public void setShopCarBiz(ShopCarBiz shopCarBiz) {
		this.shopCarBiz = shopCarBiz;
	}
	public String[] getFlowerCheched() {
		return flowerCheched;
	}
	public void setFlowerCheched(String[] flowerCheched) {
		this.flowerCheched = flowerCheched;
	}
}
