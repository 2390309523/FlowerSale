package flower.com.entity;

/**
 * Address entity. @author MyEclipse Persistence Tools
 */

public class Address implements java.io.Serializable {

	// Fields

	private Integer id;
	private String addressCountries;
	private String addressCity;
	private String addressCounty;
	private String adressSpecific;
	private String username;
	private String addressPhone;
	private Integer isdefault;
	private String resiveName;

	// Constructors

	/** default constructor */
	public Address() {
	}

	/** full constructor */
	public Address(String addressCountries, String addressCity,
			String addressCounty, String adressSpecific, String username,
			String addressPhone, Integer isdefault, String resiveName) {
		this.addressCountries = addressCountries;
		this.addressCity = addressCity;
		this.addressCounty = addressCounty;
		this.adressSpecific = adressSpecific;
		this.username = username;
		this.addressPhone = addressPhone;
		this.isdefault = isdefault;
		this.resiveName = resiveName;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddressCountries() {
		return this.addressCountries;
	}

	public void setAddressCountries(String addressCountries) {
		this.addressCountries = addressCountries;
	}

	public String getAddressCity() {
		return this.addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressCounty() {
		return this.addressCounty;
	}

	public void setAddressCounty(String addressCounty) {
		this.addressCounty = addressCounty;
	}

	public String getAdressSpecific() {
		return this.adressSpecific;
	}

	public void setAdressSpecific(String adressSpecific) {
		this.adressSpecific = adressSpecific;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddressPhone() {
		return this.addressPhone;
	}

	public void setAddressPhone(String addressPhone) {
		this.addressPhone = addressPhone;
	}

	public Integer getIsdefault() {
		return this.isdefault;
	}

	public void setIsdefault(Integer isdefault) {
		this.isdefault = isdefault;
	}

	public String getResiveName() {
		return this.resiveName;
	}

	public void setResiveName(String resiveName) {
		this.resiveName = resiveName;
	}

}