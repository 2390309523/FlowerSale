package flower.com.biz;

import java.util.List;

import flower.com.entity.ShopCar;

public interface ShopCarBiz {
	/*���浽shopCar*/
	public boolean saveToShopCar(ShopCar car);
	/*��shopCar��ѯ�Ƿ���ڼ�¼*/
	public ShopCar findShopCarByCar(ShopCar car);
	/*����*/
	public boolean updataShopCar(ShopCar car);
	/*���û�������*/
	public List<ShopCar> findShopCarsByUsername(String username);
	/*ɾ������ShopCar*/
	public boolean deleteSingleShopCar(ShopCar shopCar);
	public ShopCar findShopPCarById(int id);
}
