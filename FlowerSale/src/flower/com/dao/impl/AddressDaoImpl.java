package flower.com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import flower.com.dao.AddressDao;
import flower.com.entity.Address;

@Repository("addressDao")
public class AddressDaoImpl extends HibernateDaoSupport implements  AddressDao {

	@Override
	public List<Address> findAddressByUsernam(String username) {
		// TODO Auto-generated method stub
		String hql = "from Address a where a.username=?";
		return (List<Address>)this.getHibernateTemplate().find(hql,username);
	}

	@Override
	public Address findAddressById(int id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Address.class, id);
	}

	@Override
	public List<Address> findAddressByUsernameAndIsDefault(String username,
			int isDefault) {
		// TODO Auto-generated method stub
		String hql = "from Address a where a.username=? and a.isdefault=?";
		Object[] obj = {username,isDefault};
		return (List<Address>)this.getHibernateTemplate().find(hql,obj);
	}

	@Override
	public boolean savaAddress(Address address) {
		// TODO Auto-generated method stub
		try{
			this.getHibernateTemplate().save(address);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updataAddress(Address address) {
		// TODO Auto-generated method stub
		try{
			this.getHibernateTemplate().update(address);
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteAddress(Address address) {
		// TODO Auto-generated method stub
		try{
			this.getHibernateTemplate().delete(address);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Address findAddressUserDefault(String username) {
		// TODO Auto-generated method stub
		String hql = "from Address add where add.username=? and add.isdefault=1";
		List<Address> addresses = (List<Address>)this.getHibernateTemplate().find(hql, username);
		for(Address address:addresses){
			if(!"".equals(address.getId()))
				return address;
		}
		return null;
	}

}
