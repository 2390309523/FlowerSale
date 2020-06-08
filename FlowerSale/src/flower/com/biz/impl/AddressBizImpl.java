package flower.com.biz.impl;

import java.util.List;

import flower.com.biz.AddressBiz;
import flower.com.dao.AddressDao;
import flower.com.entity.Address;

public class AddressBizImpl implements AddressBiz {
	private AddressDao addressDao;

	public AddressDao getAddressDao() {
		return addressDao;
	}

	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	@Override
	public List<Address> findAddressByUsernam(String username) {
		// TODO Auto-generated method stub
		return this.addressDao.findAddressByUsernam(username);
	}

	@Override
	public Address findAddressById(int id) {
		// TODO Auto-generated method stub
		return this.addressDao.findAddressById(id);
	}

	@Override
	public Address findAddressByUsernameAndIsDefault(String username,
			int isDefault) {
		// TODO Auto-generated method stub
		List<Address> addresses = this.addressDao.findAddressByUsernameAndIsDefault(username, isDefault);
		try{
			for(Address address:addresses){
				if(username.equals(address)){
					return address;
				}else{
					return null;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public boolean savaAddressAsDefault(Address address) {
		// TODO Auto-generated method stub
		List<Address> addressess = this.addressDao.findAddressByUsernam(address.getUsername());
		for(Address a:addressess){
			a.setIsdefault(0);
			this.addressDao.updataAddress(a);
		}
		this.addressDao.savaAddress(address);
		return true;
	}

	@Override
	public boolean updataAddressAsDefault(Address address) {
		// TODO Auto-generated method stub
		List<Address> addressess = this.addressDao.findAddressByUsernam(address.getUsername());
		for(Address a:addressess){
			if(a.getId()!=address.getId()){
				a.setIsdefault(0);
				this.addressDao.updataAddress(a);
			}else{
				a.setIsdefault(1);
				this.addressDao.updataAddress(a);
			}
		}
		return true;
	}

	@Override
	public boolean deleteAddressById(int id) {
		// TODO Auto-generated method stub
		Address address=this.addressDao.findAddressById(id);
		try{
			this.addressDao.deleteAddress(address);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public boolean saveAddress(Address address) {
		// TODO Auto-generated method stub
		return this.addressDao.savaAddress(address);
	}

	@Override
	public boolean updataAddress(Address address) {
		// TODO Auto-generated method stub
		return this.addressDao.updataAddress(address);
	}

	@Override
	public Address findUserDefault(String username) {
		// TODO Auto-generated method stub
		return this.addressDao.findAddressUserDefault(username);
	}
}
