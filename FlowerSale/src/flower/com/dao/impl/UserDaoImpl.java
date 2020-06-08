package flower.com.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import flower.com.dao.UserDao;
import flower.com.entity.User;

@Repository("userDao")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	
	@Override
	public List<User> findUserByUsername(String username) {
		String hql = "FROM User u where u.username=?";
		return (List<User>)this.getHibernateTemplate().find(hql,username);
	}

	@Override
	public List<User> findUserByUsernameAndPassword(String username,
			String password) {
		// TODO Auto-generated method stub
		String hql = "FROM User u where u.username=? and u.password=?";
		return (List<User>)this.getHibernateTemplate().find(hql,new String[]{username,password});
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(User.class, id);
	}
	
	@Override
	public boolean updataUserInfo(User user) {
		// TODO Auto-generated method stub
		try{
			this.getHibernateTemplate().update(user);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		try{
			this.getHibernateTemplate().save(user);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<User> findUserByEmailAndPassword(String Email, String password) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.email=? and u.password=?";
		return (List<User>)this.getHibernateTemplate().find(hql, new String[]{Email,password});
	}

	@Override
	public List<User> findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return (List<User>)this.getHibernateTemplate().find("from User u where u.email=?", email);
	}


}
