package flower.com.entity;

/**
 * File entity. @author MyEclipse Persistence Tools
 */

public class File implements java.io.Serializable {

	// Fields

	private Integer id;
	private Store store;
	private String fileRealPath;
	private String filePath;

	// Constructors

	/** default constructor */
	public File() {
	}

	/** full constructor */
	public File(Store store, String fileRealPath, String filePath) {
		this.store = store;
		this.fileRealPath = fileRealPath;
		this.filePath = filePath;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getFileRealPath() {
		return this.fileRealPath;
	}

	public void setFileRealPath(String fileRealPath) {
		this.fileRealPath = fileRealPath;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}