package flower.com.biz.impl;

import java.util.List;

import flower.com.biz.ShopCarBiz;
import flower.com.dao.ShopCarDao;
import flower.com.entity.ShopCar;

public class ShopCarBizImpl implements ShopCarBiz {
	private ShopCarDao shopCarDao;

	public ShopCarDao getShopCarDao() {
		return shopCarDao;
	}

	public void setShopCarDao(ShopCarDao shopCarDao) {
		this.shopCarDao = shopCarDao;
	}

	@Override
	public boolean saveToShopCar(ShopCar car) {
		// TODO Auto-generated method stub
		return this.shopCarDao.saveToShopCar(car);
	}

	@Override
	public ShopCar findShopCarByCar(ShopCar car) {
		// TODO Auto-generated method stub
		List<ShopCar> cars = this.shopCarDao.findShopCarByUsernameAndFlowerId(car.getUsername(), car.getFlowerId());
		if(null == cars){
			return null;
		}else{
			for(ShopCar c:cars){
				if(c.getUsername().equals(car.getUsername())){
					return c;
				}
			}
			return null;
		}
	}

	@Override
	public boolean updataShopCar(ShopCar car) {
		// TODO Auto-generated method stub
		return this.shopCarDao.updataShopCar(car);
	}

	@Override
	public List<ShopCar> findShopCarsByUsername(String username) {
		// TODO Auto-generated method stub
		return this.shopCarDao.findShopCarByUsername(username);
	}

	@Override
	public boolean deleteSingleShopCar(ShopCar shopCar) {
		// TODO Auto-generated method stub
		return this.shopCarDao.deleteShopCar(shopCar);
	}

	@Override
	public ShopCar findShopPCarById(int id) {
		// TODO Auto-generated method stub
		return this.shopCarDao.findShopCarById(id);
	}
}
