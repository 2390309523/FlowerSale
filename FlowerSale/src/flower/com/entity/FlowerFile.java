package flower.com.entity;

/**
 * FlowerFile entity. @author MyEclipse Persistence Tools
 */

public class FlowerFile implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer flowerId;
	private String filePath;
	private Double fileSize;
	private String fileRealPath;

	// Constructors

	/** default constructor */
	public FlowerFile() {
	}

	/** minimal constructor */
	public FlowerFile(Integer flowerId) {
		this.flowerId = flowerId;
	}

	/** full constructor */
	public FlowerFile(Integer flowerId, String filePath, Double fileSize,
			String fileRealPath) {
		this.flowerId = flowerId;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.fileRealPath = fileRealPath;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFlowerId() {
		return this.flowerId;
	}

	public void setFlowerId(Integer flowerId) {
		this.flowerId = flowerId;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Double getFileSize() {
		return this.fileSize;
	}

	public void setFileSize(Double fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileRealPath() {
		return this.fileRealPath;
	}

	public void setFileRealPath(String fileRealPath) {
		this.fileRealPath = fileRealPath;
	}

}