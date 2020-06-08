package flower.com.biz.impl;

import java.util.List;

import flower.com.biz.FlowerBiz;
import flower.com.dao.FlowerDao;
import flower.com.entity.Flower;

public class FlowerBizImpl implements FlowerBiz {
	private FlowerDao flowerDao;
	public FlowerDao getFlowerDao() {
		return flowerDao;
	}
	public void setFlowerDao(FlowerDao flowerDao) {
		this.flowerDao = flowerDao;
	}
	@Override
	public List<Flower> getAllFlowers() {
		// TODO Auto-generated method stub
		return this.flowerDao.findAllFlower();
	}
	@Override
	public Flower getFlowerByFlowerId(int flowerId) {
		// TODO Auto-generated method stub
		return this.flowerDao.findFlowerById(flowerId);
	}
	@Override
	public List<Flower> getFlowersBySearchInfo(String searchInfo) {
		return this.flowerDao.findFlowerByFlowerName(searchInfo);
	}
	@Override
	public List<Flower> getFlowersByPrice(float price) {
		// TODO Auto-generated method stub
		return this.flowerDao.findFlowerByPrice(price);
	}
	@Override
	public List<Flower> getFlowerPaging(int min, int max) {
		// TODO Auto-generated method stub
		return this.flowerDao.findFlowerPage(min, max);
	}
	@Override
	public List<Flower> findFlowersByStoreName(String storeName) {
		// TODO Auto-generated method stub
		return this.flowerDao.findFlowersByStoreName(storeName);
	}
	@Override
	public boolean updataFlowerInfo(Flower flower) {
		// TODO Auto-generated method stub
		return this.flowerDao.updataFlowerInfo(flower);
	}
	@Override
	public boolean saveFlower(Flower flower) {
		// TODO Auto-generated method stub
		return this.flowerDao.saveFlower(flower);
	}
	@Override
	public List<Flower> findFlowerByStoreAndFlower(String flowername,
			String storename) {
		// TODO Auto-generated method stub
		return this.flowerDao.findFlowerByFlowernameAndStoreName(flowername, storename);
	}
	@Override
	public Flower findFlowerByStorenameAndFlowername(String flowername,
			String storename) {
		// TODO Auto-generated method stub
		try{
			List<Flower> flowers = this.flowerDao.findFlowerByFlowernameAndStoreName(flowername, storename);
			for(Flower flower:flowers){
				if(flower!=null){
					return flower;
				}
			}
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
