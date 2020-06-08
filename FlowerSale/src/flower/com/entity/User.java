package flower.com.entity;

import java.sql.Timestamp;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private String dailyName;
	private String indentity;
	private String headImage;
	private String email;
	private String storeName;
	private String phone;
	private Timestamp createTime;
	private Timestamp updataTime;
	private String headImageRealPath;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username) {
		this.username = username;
	}

	/** full constructor */
	public User(String username, String password, String dailyName,
			String indentity, String headImage, String email, String storeName,
			String phone, Timestamp createTime, Timestamp updataTime,
			String headImageRealPath) {
		this.username = username;
		this.password = password;
		this.dailyName = dailyName;
		this.indentity = indentity;
		this.headImage = headImage;
		this.email = email;
		this.storeName = storeName;
		this.phone = phone;
		this.createTime = createTime;
		this.updataTime = updataTime;
		this.headImageRealPath = headImageRealPath;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDailyName() {
		return this.dailyName;
	}

	public void setDailyName(String dailyName) {
		this.dailyName = dailyName;
	}

	public String getIndentity() {
		return this.indentity;
	}

	public void setIndentity(String indentity) {
		this.indentity = indentity;
	}

	public String getHeadImage() {
		return this.headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStoreName() {
		return this.storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdataTime() {
		return this.updataTime;
	}

	public void setUpdataTime(Timestamp updataTime) {
		this.updataTime = updataTime;
	}

	public String getHeadImageRealPath() {
		return this.headImageRealPath;
	}

	public void setHeadImageRealPath(String headImageRealPath) {
		this.headImageRealPath = headImageRealPath;
	}

}