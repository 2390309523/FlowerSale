package flower.com.biz;

import java.util.List;

import flower.com.entity.ShopCar;

public interface ShopCarBiz {
	/*保存到shopCar*/
	public boolean saveToShopCar(ShopCar car);
	/*从shopCar查询是否存在记录*/
	public ShopCar findShopCarByCar(ShopCar car);
	/*更新*/
	public boolean updataShopCar(ShopCar car);
	/*用用户名查找*/
	public List<ShopCar> findShopCarsByUsername(String username);
	/*删除单个ShopCar*/
	public boolean deleteSingleShopCar(ShopCar shopCar);
	public ShopCar findShopPCarById(int id);
}
