package flower.com.dao;

import java.util.List;

import flower.com.entity.User;

/*命名规范化，find，updata，delete，save开头*/
public interface UserDao {
	/*通过名字找User*/
	public List<User> findUserByUsername(String username);
	/*通过邮箱找用户*/
	public List<User> findUserByEmail(String email);
	/*通过用户名和密码找用户*/
	public List<User> findUserByUsernameAndPassword(String username,String password);
	/*通过邮箱过去用户名*/
	public List<User> findUserByEmailAndPassword(String Email,String password);
	/*通过id找用户*/
	public User findUserById(int id);
	/*更新用户信息*/
	public boolean updataUserInfo(User user);
	/*持久化一个用户*/
	public boolean saveUser(User user);
}
