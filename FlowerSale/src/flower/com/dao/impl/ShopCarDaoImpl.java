package flower.com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import flower.com.dao.ShopCarDao;
import flower.com.entity.ShopCar;

@Repository("shopCarDao")
public class ShopCarDaoImpl extends HibernateDaoSupport implements ShopCarDao{

	@Override
	public boolean deleteShopCar(List<ShopCar> cars) {
		// TODO Auto-generated method stub
		try{
			for(ShopCar car:cars){
				this.getHibernateTemplate().delete(car);
			}return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteShopCar(ShopCar car) {
		// TODO Auto-generated method stub
		try{
			this.getHibernateTemplate().delete(car);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean saveToShopCar(List<ShopCar> cars) {
		// TODO Auto-generated method stub
		try{
			for(ShopCar car:cars){
				this.getHibernateTemplate().save(car);
			}return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean saveToShopCar(ShopCar car) {
		// TODO Auto-generated method stub
		try{
			this.getHibernateTemplate().save(car);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<ShopCar> findShopCarByUsername(String username) {
		// TODO Auto-generated method stub
		String hql = "from ShopCar car where car.username=?";
		return (List<ShopCar>)this.getHibernateTemplate().find(hql, username);
	}

	@Override
	public List<ShopCar> findShopCarByUsernameAndFlowerId(String username,
			int flowerId) {
		// TODO Auto-generated method stub
		String hql = "from ShopCar car where car.username=? and car.flowerId=?";
		Object[] obj = {username,flowerId};
		return (List<ShopCar>)this.getHibernateTemplate().find(hql, obj);
	}

	@Override
	public boolean updataShopCar(ShopCar shopCar) {
		// TODO Auto-generated method stub
		try{
			this.getHibernateTemplate().update(shopCar);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public ShopCar findShopCarById(int shopCarId) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(ShopCar.class,shopCarId);
	}

}
