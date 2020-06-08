package flower.com.action;

import java.sql.Timestamp;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.UserBiz;
import flower.com.entity.User;

/*�û�ע��*/
public class RegisterAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String passwordAgain;
	private String email;
	private UserBiz userBiz;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordAgain() {
		return passwordAgain;
	}
	public void setPasswordAgain(String passwordAgain) {
		this.passwordAgain = passwordAgain;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserBiz getUserBiz() {
		return userBiz;
	}
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	public String register(){
		ActionContext context  =ActionContext.getContext();
		User user = new User();
		if(this.userBiz.isExistUser(username)){
			context.put("registerInfo", "�û��Ѿ����ڣ�������ѡ���û�����");
			return "default";
		}else{
			user.setUsername(username);
			if((password.trim()).equals(passwordAgain.trim())){
				user.setPassword(password);
				if(!"".equals(this.email) && 
						this.userBiz.findUserByEmail(this.email).size()==0){
					user.setEmail(email.toUpperCase());
					user.setHeadImage("UiFile/image/logo.png");
					user.setIndentity("simple_user");
					user.setCreateTime(new Timestamp(System.currentTimeMillis()));
					user.setUpdataTime(user.getCreateTime());
					context.put("registerInfo", "ע��ɹ�������ٵ�¼ǰ�����������������ϰɣ�");
					context.put("username", username);
					try{
						this.userBiz.saveUser(user);
						return "success";
					}catch(Exception e){
						context.put("registerInfo", "ע��ʧ�ܣ�������Ϣ��"+e);
						return "default";
					}
				}else{
					context.put("registerInfo", "�����ʽ����������ѱ�ռ��!");
					return  "default";
				}
			}else{
				context.put("registerInfo", "�������벻һ�£�ע��ʧ�ܣ�");
				return "default";
			}
		}
		
	}
}
