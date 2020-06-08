package flower.com.dao;

import java.util.List;

import flower.com.entity.Store;

public interface StoreDao {
	/*ͨ����id���ҵ���*/
	public Store getStoreById(int id);
	/*�־û�����*/
	public boolean saveStore(Store store);
	/*ͨ���������ҵ���*/
	public List<Store> getStoreByStoreName(String storeName);
	/*���µ�����Ϣ*/
	public boolean updataStoreInfo(Store store);
}
