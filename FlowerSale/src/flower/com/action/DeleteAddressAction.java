package flower.com.action;

import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.AddressBiz;

public class DeleteAddressAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String addressId;
	private AddressBiz addressBiz;
	public String deleteAddress(){
		System.out.println("--------"+addressId+"-----------");
		this.addressBiz.deleteAddressById(Integer.parseInt(addressId));
		return "";
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public AddressBiz getAddressBiz() {
		return addressBiz;
	}
	public void setAddressBiz(AddressBiz addressBiz) {
		this.addressBiz = addressBiz;
	}
	
	

}
