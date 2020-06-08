package flower.com.dao;

import java.util.List;

import flower.com.entity.ShopCar;

public interface ShopCarDao {
	/*批量删除订单*/
	public boolean deleteShopCar(List<ShopCar> cars);
	/*删除订单*/
	public boolean deleteShopCar(ShopCar car);
	/*保存订单*/
	public boolean saveToShopCar(List<ShopCar> cars);
	public boolean saveToShopCar(ShopCar car);
	/*通过username获取shopCar*/
	public List<ShopCar> findShopCarByUsername(String username);
	/*通过Username和flowerId获取Car*/
	public List<ShopCar> findShopCarByUsernameAndFlowerId(String username,int flowerId);
	public boolean updataShopCar(ShopCar shopCar);
	public ShopCar findShopCarById(int shopCarId);
} 
