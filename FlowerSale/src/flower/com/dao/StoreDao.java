package flower.com.dao;

import java.util.List;

import flower.com.entity.Store;

public interface StoreDao {
	/*通过用id查找店铺*/
	public Store getStoreById(int id);
	/*持久化店铺*/
	public boolean saveStore(Store store);
	/*通过店铺名找店铺*/
	public List<Store> getStoreByStoreName(String storeName);
	/*更新店铺信息*/
	public boolean updataStoreInfo(Store store);
}
