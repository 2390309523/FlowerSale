package flower.com.biz;

import java.util.List;

import flower.com.entity.User;

/*�����淶����find��register��save����updata��del*/
public interface UserBiz {
	/*ͨ��username��password�Ҷ���*/
	public User findUserByUsernameAndPassword(String username,String password);
	/*ͨ��������������û�*/
	public User findUserByEmailAndPassword(String email,String password);
	/*�־û�һ��User*/
	public boolean saveUser(User user);
	/*�����Ƿ�����û�*/
	public boolean isExistUser(String username);
	/*ͨ���û��������û�*/
	public User findUserByUsername(String username);
	/*ͨ���������û�*/
	public List<User> findUserByEmail(String email);
	/*����*/
	public boolean updataUser(User user);
}
