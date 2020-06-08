package flower.com.dao;

import java.util.List;

import flower.com.entity.FlowerFile;

public interface FlowerFileDao {
	/*通过id获取文件*/
	public List<FlowerFile> findFlowerFileById(int id);
	/*通过flowerid找文件*/
	public List<FlowerFile> findFlowerFileByFlowerId(int flowerId);
	/*新增花卉*/
	public boolean saveFlowerFiles(List<FlowerFile> flowerFiles);
	public boolean saveFlowerFile(FlowerFile flowerFile);
}
