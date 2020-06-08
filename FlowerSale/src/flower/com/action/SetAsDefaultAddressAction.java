package flower.com.action;

import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.AddressBiz;
import flower.com.entity.Address;

public class SetAsDefaultAddressAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AddressBiz addressBiz;
	
	public String setAsDefault(){
		Address address = this.addressBiz.findAddressById(Integer.parseInt(addressId));
		System.out.println(address.getAdressSpecific());
		this.addressBiz.updataAddressAsDefault(address);
		return "";
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
	private String addressId;

}
