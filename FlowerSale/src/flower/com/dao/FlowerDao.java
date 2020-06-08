package flower.com.dao;

import java.util.List;

import flower.com.entity.Flower;

/*�����淶����find��updata��delete��save��ͷ*/
public interface FlowerDao {
	/*��ѯ���еĻ���*/
	public List<Flower> findAllFlower();
	/*ͨ��id�һ�*/
	public Flower findFlowerById(int id);
	/*ͨ��price�һ���*/
	public List<Flower> findFlowerByPrice(float price);
	/*ͨ�������֣����߻����һ���*/
	public List<Flower> findFlowerByFlowerName(String searchInfo);
	/*��ҳ��ѯ*/
	public List<Flower> findFlowerPage(int min,int max);
	/*���ݻ��������һ���*/
	public List<Flower> findFlowersByStoreName(String storeName);
	/*���»�����Ϣ*/
	public boolean updataFlowerInfo(Flower flower);
	/*���滨��*/
	public boolean saveFlower(Flower flower);
	public List<Flower> findFlowerByFlowernameAndStoreName(String flowername,String storename);
}
