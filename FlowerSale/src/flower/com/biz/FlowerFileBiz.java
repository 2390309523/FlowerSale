package flower.com.biz;

import java.util.List;

import flower.com.entity.FlowerFile;

public interface FlowerFileBiz {
	/*ͨ��flower��id���ļ�*/
	public List<FlowerFile> getFileByFlowerId(int flowerId);
	/*���������ļ�*/
	public boolean saveFlowerFiles(List<FlowerFile> flowerFiles);
	public boolean savaFlowerFile(FlowerFile flowerFile);
}
