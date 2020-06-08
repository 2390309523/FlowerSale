package flower.com.entity;

/**
 * ShopCar entity. @author MyEclipse Persistence Tools
 */

public class ShopCar implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private Integer flowerId;
	private Integer flowerNum;
	private Integer stateCode;

	// Constructors

	/** default constructor */
	public ShopCar() {
	}

	/** minimal constructor */
	public ShopCar(String username, Integer flowerId, Integer flowerNum) {
		this.username = username;
		this.flowerId = flowerId;
		this.flowerNum = flowerNum;
	}

	/** full constructor */
	public ShopCar(String username, Integer flowerId, Integer flowerNum,
			Integer stateCode) {
		this.username = username;
		this.flowerId = flowerId;
		this.flowerNum = flowerNum;
		this.stateCode = stateCode;
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

	public Integer getFlowerId() {
		return this.flowerId;
	}

	public void setFlowerId(Integer flowerId) {
		this.flowerId = flowerId;
	}

	public Integer getFlowerNum() {
		return this.flowerNum;
	}

	public void setFlowerNum(Integer flowerNum) {
		this.flowerNum = flowerNum;
	}

	public Integer getStateCode() {
		return this.stateCode;
	}

	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
	}

}