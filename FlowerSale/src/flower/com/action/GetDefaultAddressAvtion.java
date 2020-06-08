package flower.com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.AddressBiz;
import flower.com.entity.Address;

public class GetDefaultAddressAvtion extends ActionSupport{
	private String username;
	private AddressBiz addressBiz;
	public void getDefaultAddress() throws IOException{
		
		Address address = this.addressBiz.findUserDefault(username);
		HttpServletResponse response = ServletActionContext.getResponse();
		String addressInfo = "";
		if(address!=null){	
			addressInfo = address.getAdressSpecific();
		}else{
			addressInfo = "0";
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(addressInfo);
		out.flush();
		out.close();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public AddressBiz getAddressBiz() {
		return addressBiz;
	}
	public void setAddressBiz(AddressBiz addressBiz) {
		this.addressBiz = addressBiz;
	}
}
