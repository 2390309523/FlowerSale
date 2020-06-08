package flower.com.dao;

import java.util.List;

import flower.com.entity.User;

/*�����淶����find��updata��delete��save��ͷ*/
public interface UserDao {
	/*ͨ��������User*/
	public List<User> findUserByUsername(String username);
	/*ͨ���������û�*/
	public List<User> findUserByEmail(String email);
	/*ͨ���û������������û�*/
	public List<User> findUserByUsernameAndPassword(String username,String password);
	/*ͨ�������ȥ�û���*/
	public List<User> findUserByEmailAndPassword(String Email,String password);
	/*ͨ��id���û�*/
	public User findUserById(int id);
	/*�����û���Ϣ*/
	public boolean updataUserInfo(User user);
	/*�־û�һ���û�*/
	public boolean saveUser(User user);
}
