package flower.com.biz;

import java.util.List;

import flower.com.entity.Flower;
/*命名规范化：find/get，register（save），updata，del*/
public interface FlowerBiz {
	/*获取所有的花卉*/
	public List<Flower> getAllFlowers();
	/*通过id找花卉*/
	public Flower getFlowerByFlowerId(int flowerId);
	/*通过价格找Flowers*/
	public List<Flower> getFlowersByPrice(float price);
	/*查找用户提交的信息模糊查询*/
	public List<Flower> getFlowersBySearchInfo(String searchInfo);
	/*分页*/
	public List<Flower> getFlowerPaging(int min,int max);
	/*通过店名找Flowers*/
	public List<Flower> findFlowersByStoreName(String storeName);
	/*更新花卉*/
	public boolean updataFlowerInfo(Flower flower);
	/*保存花卉*/
	public boolean saveFlower(Flower flower);
	/*通过花名和店名找List<Flower>*/
	public List<Flower> findFlowerByStoreAndFlower(String flowername,String storename);
	/*通过花名找唯一的Flower*/
	public Flower findFlowerByStorenameAndFlowername(String flowername,String storename);
}

