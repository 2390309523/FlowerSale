package flower.com.biz;

import java.util.List;

import flower.com.entity.Address;

public interface AddressBiz {
	public List<Address> findAddressByUsernam(String username);
	public Address findAddressById(int id);
	public Address findAddressByUsernameAndIsDefault(String username,int isDefault);
	public boolean savaAddressAsDefault(Address address);
	public boolean updataAddressAsDefault(Address address);
	public boolean deleteAddressById(int id);
	public boolean saveAddress(Address address);
	public boolean updataAddress(Address address);
	public Address findUserDefault(String username);
}
