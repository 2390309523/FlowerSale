package flower.com.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Store entity. @author MyEclipse Persistence Tools
 */

public class Store implements java.io.Serializable {

	// Fields

	private Integer id;
	private String storeName;
	private String storeIntroduce;
	private String storeAddress;
	private Timestamp storeCreateTime;
	private String storeIconPath;
	private Integer storeSoleNum;
	private String storeIconRelPath;
	private Set files = new HashSet(0);

	// Constructors

	/** default constructor */
	public Store() {
	}

	/** minimal constructor */
	public Store(String storeName) {
		this.storeName = storeName;
	}

	/** full constructor */
	public Store(String storeName, String storeIntroduce, String storeAddress,
			Timestamp storeCreateTime, String storeIconPath,
			Integer storeSoleNum, String storeIconRelPath, Set files) {
		this.storeName = storeName;
		this.storeIntroduce = storeIntroduce;
		this.storeAddress = storeAddress;
		this.storeCreateTime = storeCreateTime;
		this.storeIconPath = storeIconPath;
		this.storeSoleNum = storeSoleNum;
		this.storeIconRelPath = storeIconRelPath;
		this.files = files;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStoreName() {
		return this.storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreIntroduce() {
		return this.storeIntroduce;
	}

	public void setStoreIntroduce(String storeIntroduce) {
		this.storeIntroduce = storeIntroduce;
	}

	public String getStoreAddress() {
		return this.storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public Timestamp getStoreCreateTime() {
		return this.storeCreateTime;
	}

	public void setStoreCreateTime(Timestamp storeCreateTime) {
		this.storeCreateTime = storeCreateTime;
	}

	public String getStoreIconPath() {
		return this.storeIconPath;
	}

	public void setStoreIconPath(String storeIconPath) {
		this.storeIconPath = storeIconPath;
	}

	public Integer getStoreSoleNum() {
		return this.storeSoleNum;
	}

	public void setStoreSoleNum(Integer storeSoleNum) {
		this.storeSoleNum = storeSoleNum;
	}

	public String getStoreIconRelPath() {
		return this.storeIconRelPath;
	}

	public void setStoreIconRelPath(String storeIconRelPath) {
		this.storeIconRelPath = storeIconRelPath;
	}

	public Set getFiles() {
		return this.files;
	}

	public void setFiles(Set files) {
		this.files = files;
	}

}