package flower.com.biz.impl;

import flower.com.biz.StoreBiz;
import flower.com.dao.StoreDao;
import flower.com.entity.Store;

public class StoreBizImpl implements StoreBiz{
	private StoreDao storeDao;

	public StoreDao getStoreDao() {
		return storeDao;
	}

	public void setStoreDao(StoreDao storeDao) {
		this.storeDao = storeDao;
	}

	@Override
	public Store getStoreById(int id) {
		// TODO Auto-generated method stub
		return this.storeDao.getStoreById(id);
	}

	@Override
	public boolean saveStore(Store store) {
		// TODO Auto-generated method stub
		return this.storeDao.saveStore(store);
	}

	@Override
	public Store getStoreByStoreName(String storeName) {
		// TODO Auto-generated method stub
		return this.storeDao.getStoreByStoreName(storeName).get(0);
	}

	@Override
	public boolean updataStoreInfo(Store store) {
		// TODO Auto-generated method stub
		return this.storeDao.updataStoreInfo(store);
	}
}
