package flower.com.biz;

import java.util.List;

import flower.com.entity.Flower;
/*�����淶����find/get��register��save����updata��del*/
public interface FlowerBiz {
	/*��ȡ���еĻ���*/
	public List<Flower> getAllFlowers();
	/*ͨ��id�һ���*/
	public Flower getFlowerByFlowerId(int flowerId);
	/*ͨ���۸���Flowers*/
	public List<Flower> getFlowersByPrice(float price);
	/*�����û��ύ����Ϣģ����ѯ*/
	public List<Flower> getFlowersBySearchInfo(String searchInfo);
	/*��ҳ*/
	public List<Flower> getFlowerPaging(int min,int max);
	/*ͨ��������Flowers*/
	public List<Flower> findFlowersByStoreName(String storeName);
	/*���»���*/
	public boolean updataFlowerInfo(Flower flower);
	/*���滨��*/
	public boolean saveFlower(Flower flower);
	/*ͨ�������͵�����List<Flower>*/
	public List<Flower> findFlowerByStoreAndFlower(String flowername,String storename);
	/*ͨ��������Ψһ��Flower*/
	public Flower findFlowerByStorenameAndFlowername(String flowername,String storename);
}

