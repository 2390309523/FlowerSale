package flower.com.dao;

import java.util.List;

import flower.com.entity.FlowerFile;

public interface FlowerFileDao {
	/*ͨ��id��ȡ�ļ�*/
	public List<FlowerFile> findFlowerFileById(int id);
	/*ͨ��flowerid���ļ�*/
	public List<FlowerFile> findFlowerFileByFlowerId(int flowerId);
	/*��������*/
	public boolean saveFlowerFiles(List<FlowerFile> flowerFiles);
	public boolean saveFlowerFile(FlowerFile flowerFile);
}
