package flower.com.dao;

import java.util.List;

import flower.com.entity.Address;

public interface AddressDao {
	/*ͨ��username�ֶβ�ѯ*/
	public List<Address> findAddressByUsernam(String username);
	public Address findAddressById(int id);
	public List<Address> findAddressByUsernameAndIsDefault(String username,int isDefault);
	/*����*/
	public boolean savaAddress(Address address);
	public boolean updataAddress(Address address);
	public boolean deleteAddress(Address address);
	public Address findAddressUserDefault(String username);
	
}
