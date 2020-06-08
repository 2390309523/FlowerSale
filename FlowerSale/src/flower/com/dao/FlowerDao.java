package flower.com.dao;

import java.util.List;

import flower.com.entity.Flower;

/*命名规范化，find，updata，delete，save开头*/
public interface FlowerDao {
	/*查询所有的花卉*/
	public List<Flower> findAllFlower();
	/*通过id找花*/
	public Flower findFlowerById(int id);
	/*通过price找花朵*/
	public List<Flower> findFlowerByPrice(float price);
	/*通过花名字，或者花店找花朵*/
	public List<Flower> findFlowerByFlowerName(String searchInfo);
	/*分页查询*/
	public List<Flower> findFlowerPage(int min,int max);
	/*根据花店名字找花朵*/
	public List<Flower> findFlowersByStoreName(String storeName);
	/*更新花卉信息*/
	public boolean updataFlowerInfo(Flower flower);
	/*保存花卉*/
	public boolean saveFlower(Flower flower);
	public List<Flower> findFlowerByFlowernameAndStoreName(String flowername,String storename);
}
