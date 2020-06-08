package flower.com.biz;


import flower.com.entity.Store;

public interface StoreBiz {
	/*通过用id查找店铺*/
	public Store getStoreById(int id);
	/*持久化店铺*/
	public boolean saveStore(Store store);
	/*通过店铺名找店铺*/
	public Store getStoreByStoreName(String storeName);
	/*更新店铺信息*/
	public boolean updataStoreInfo(Store store);
}
