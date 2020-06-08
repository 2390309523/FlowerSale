package flower.com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.AddressBiz;
import flower.com.entity.Address;

public class UpdataAddressAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String countries;
	private String city;
	private String country;
	private String resiveName;
	private String phone;
	private String specific;
	private AddressBiz addressBiz;
	private String addressId;
	public String updataAddress(){
		Address address = this.addressBiz.findAddressById(Integer.parseInt(addressId));
		if(!"".equals(countries.trim())) address.setAddressCountries(this.countries);
		if(!"".equals(city.trim())) address.setAddressCity(this.city);
		if(!"".equals(country.trim())) address.setAddressCounty(this.country);
		if(!"".equals(this.resiveName.trim())) address.setResiveName(this.resiveName);
		if(!"".equals(this.phone.trim())) address.setAddressPhone(this.phone);
		if(!"".equals(this.specific)) address.setAdressSpecific(this.specific);
		this.addressBiz.updataAddress(address);
		return "success";
	}
	public String getCountries() {
		return countries;
	}
	public void setCountries(String countries) {
		this.countries = countries;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getResiveName() {
		return resiveName;
	}
	public void setResiveName(String resiveName) {
		this.resiveName = resiveName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSpecific() {
		return specific;
	}
	public void setSpecific(String specific) {
		this.specific = specific;
	}
	public AddressBiz getAddressBiz() {
		return addressBiz;
	}
	public void setAddressBiz(AddressBiz addressBiz) {
		this.addressBiz = addressBiz;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
