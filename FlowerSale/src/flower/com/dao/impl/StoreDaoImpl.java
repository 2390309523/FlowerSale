package flower.com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import flower.com.dao.StoreDao;
import flower.com.entity.Store;

@Repository("storeDao")
public class StoreDaoImpl extends HibernateDaoSupport implements StoreDao {

	@Override
	public Store getStoreById(int id) {
		// TODO Auto-generated method stub
		return (Store)this.getHibernateTemplate().get(Store.class, id);
	}

	@Override
	public boolean saveStore(Store store) {
		// TODO Auto-generated method stub
		try{
			this.getHibernateTemplate().save(store);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Store> getStoreByStoreName(String storeName) {
		// TODO Auto-generated method stub
		String hql = "from Store s where s.storeName=?";
		return (List<Store>)this.getHibernateTemplate().find(hql, storeName);
	}

	@Override
	public boolean updataStoreInfo(Store store) {
		// TODO Auto-generated method stub
		try{
			this.getHibernateTemplate().update(store);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

}
