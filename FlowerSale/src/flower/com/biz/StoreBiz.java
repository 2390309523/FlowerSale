package flower.com.biz;


import flower.com.entity.Store;

public interface StoreBiz {
	/*ͨ����id���ҵ���*/
	public Store getStoreById(int id);
	/*�־û�����*/
	public boolean saveStore(Store store);
	/*ͨ���������ҵ���*/
	public Store getStoreByStoreName(String storeName);
	/*���µ�����Ϣ*/
	public boolean updataStoreInfo(Store store);
}
