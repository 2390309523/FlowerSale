package flower.com.entity;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	private Integer id;
	private String store;
	private String username;
	private String flower;
	private Integer num;
	private Integer stateCode;
	private Integer addressId;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(String store, String username, String flower, Integer num,
			Integer stateCode, Integer addressId) {
		this.store = store;
		this.username = username;
		this.flower = flower;
		this.num = num;
		this.stateCode = stateCode;
		this.addressId = addressId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStore() {
		return this.store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFlower() {
		return this.flower;
	}

	public void setFlower(String flower) {
		this.flower = flower;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getStateCode() {
		return this.stateCode;
	}

	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
	}

	public Integer getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

}