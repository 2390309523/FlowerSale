package flower.com.biz;

import java.util.List;

import flower.com.entity.FlowerFile;

public interface FlowerFileBiz {
	/*通过flower的id找文件*/
	public List<FlowerFile> getFileByFlowerId(int flowerId);
	/*批量保存文件*/
	public boolean saveFlowerFiles(List<FlowerFile> flowerFiles);
	public boolean savaFlowerFile(FlowerFile flowerFile);
}
