package flower.com.dao;

import java.util.List;

import flower.com.entity.ShopCar;

public interface ShopCarDao {
	/*����ɾ������*/
	public boolean deleteShopCar(List<ShopCar> cars);
	/*ɾ������*/
	public boolean deleteShopCar(ShopCar car);
	/*���涩��*/
	public boolean saveToShopCar(List<ShopCar> cars);
	public boolean saveToShopCar(ShopCar car);
	/*ͨ��username��ȡshopCar*/
	public List<ShopCar> findShopCarByUsername(String username);
	/*ͨ��Username��flowerId��ȡCar*/
	public List<ShopCar> findShopCarByUsernameAndFlowerId(String username,int flowerId);
	public boolean updataShopCar(ShopCar shopCar);
	public ShopCar findShopCarById(int shopCarId);
} 
