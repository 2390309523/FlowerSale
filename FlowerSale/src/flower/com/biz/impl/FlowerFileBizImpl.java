package flower.com.biz.impl;

import java.util.List;

import flower.com.biz.FlowerFileBiz;
import flower.com.dao.FlowerFileDao;
import flower.com.entity.FlowerFile;

public class FlowerFileBizImpl implements FlowerFileBiz{
	private FlowerFileDao flowerFileDao;

	public FlowerFileDao getFlowerFileDao() {
		return flowerFileDao;
	}

	public void setFlowerFileDao(FlowerFileDao flowerFileDao) {
		this.flowerFileDao = flowerFileDao;
	}

	@Override
	public List<FlowerFile> getFileByFlowerId(int flowerId) {
		// TODO Auto-generated method stub
		return this.flowerFileDao.findFlowerFileByFlowerId(flowerId);
	}

	@Override
	public boolean saveFlowerFiles(List<FlowerFile> flowerFiles) {
		// TODO Auto-generated method stub
		return this.flowerFileDao.saveFlowerFiles(flowerFiles);
	}

	@Override
	public boolean savaFlowerFile(FlowerFile flowerFile) {
		// TODO Auto-generated method stub
		return this.flowerFileDao.saveFlowerFile(flowerFile);
	}
}
