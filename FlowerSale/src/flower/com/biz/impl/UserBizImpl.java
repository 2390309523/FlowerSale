package flower.com.biz.impl;

import java.util.List;

import flower.com.biz.UserBiz;
import flower.com.dao.UserDao;
import flower.com.entity.User;

public class UserBizImpl implements UserBiz {
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		List<User> users = this.userDao.findUserByUsernameAndPassword(username, password);
		for(User user:users){
			if(user.getUsername()!=null){
				return user;
			}else{
				return null;
			}
		}return null;	
	}
	
	@Override
	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		return this.userDao.saveUser(user);
	}
	@Override
	public boolean isExistUser(String username) {
		List<User> users = this.userDao.findUserByUsername(username);
		if(users.size()>0){
			return true;
		}
		return false;
	}
	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		try{
			for(User user:this.userDao.findUserByUsername(username)){
				if(user.getUsername().equals(username)){
					return user;
				}
			}
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public User findUserByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return this.userDao.findUserByEmailAndPassword(email, password).get(0);
	}
	@Override
	public List<User> findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return this.userDao.findUserByEmail(email);
	}
	@Override
	public boolean updataUser(User user) {
		// TODO Auto-generated method stub
		return this.userDao.updataUserInfo(user);
	}
	
}
