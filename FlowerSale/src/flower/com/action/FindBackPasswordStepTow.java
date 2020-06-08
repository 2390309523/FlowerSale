package flower.com.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.UserBiz;
import flower.com.entity.User;
import flower.com.util.EmailUtil;
import flower.com.util.GetRoundUtil;

/*找回密码2*/
public class FindBackPasswordStepTow extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserBiz userBiz;
	private String emailCheckCode;
	private String emailCode;
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserBiz getUserBiz() {
		return userBiz;
	}
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	public String getEmailCheckCode() {
		return emailCheckCode;
	}
	public void setEmailCheckCode(String emailCheckCode) {
		this.emailCheckCode = emailCheckCode;
	}
	public String getEmailCode() {
		return emailCode;
	}
	public void setEmailCode(String emailCode) {
		this.emailCode = emailCode;
	}
	@Override
	public String execute(){
		ActionContext context = ActionContext.getContext();
		String updataPassword = new String();
		if(this.emailCheckCode.equals(this.emailCode)){
			updataPassword = GetRoundUtil.getRandomPassword();
			User user = this.userBiz.findUserByUsername(username);
			EmailUtil.sendMessage(EmailUtil.sendUserEmail, user.getEmail().toUpperCase(), "DrowHand密码修改通知", "尊敬的会员"+user.getDailyName()+"您的密码已经重置,重置后的密码是 "+updataPassword+"请尽快登录前往个人中心进行密码的修改");
			user.setPassword(updataPassword);
			this.userBiz.updataUser(user);
			context.put("userDailyName", user.getDailyName());
			return "success";
		}
		return "default";
	}
	
}
