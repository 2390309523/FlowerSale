package flower.com.biz;

import java.util.List;

import flower.com.entity.User;

/*命名规范化：find，register（save），updata，del*/
public interface UserBiz {
	/*通过username和password找对象*/
	public User findUserByUsernameAndPassword(String username,String password);
	/*通过邮箱和密码找用户*/
	public User findUserByEmailAndPassword(String email,String password);
	/*持久化一个User*/
	public boolean saveUser(User user);
	/*查找是否存在用户*/
	public boolean isExistUser(String username);
	/*通过用户名字找用户*/
	public User findUserByUsername(String username);
	/*通过邮箱找用户*/
	public List<User> findUserByEmail(String email);
	/*更新*/
	public boolean updataUser(User user);
}
