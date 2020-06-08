package flower.com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import oracle.net.aso.s;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.AddressBiz;
import flower.com.entity.Address;
import flower.com.entity.User;

public class AddAddressAction extends ActionSupport implements
ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpSession session;
	private String countries;
	private String city;
	private String country;
	private String resiveName;
	private String phone;
	private String specific;
	private AddressBiz addressBiz;
	public String addAddress(){
		session = request.getSession();
		User user = (User)session.getAttribute("user");
		Address address = new Address();
		if(!"".equals(this.countries.trim())) address.setAddressCountries(countries);
		if(!"".equals(this.country.trim())) address.setAddressCounty(country);
		if(!"".equals(this.city.trim())) address.setAddressCity(city);
		if(!"".equals(this.phone.trim())){
			address.setAddressPhone(phone);
		}else{
			address.setAddressPhone(user.getPhone());
		}
		if(!"".equals(this.specific.trim())) address.setAdressSpecific(specific);
		if(!"".equals(resiveName.trim())) address.setResiveName(resiveName);
			else address.setResiveName(user.getDailyName());
		if(this.addressBiz.findAddressByUsernam(user.getUsername()).size()==0){
			address.setIsdefault(1);
		}else{
			address.setIsdefault(0);
		}
		address.setUsername(user.getUsername());
		this.addressBiz.saveAddress(address);
		return "success";
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	public AddressBiz getAddressBiz() {
		return addressBiz;
	}

	public void setAddressBiz(AddressBiz addressBiz) {
		this.addressBiz = addressBiz;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
