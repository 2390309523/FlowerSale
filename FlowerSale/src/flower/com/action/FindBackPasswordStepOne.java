package flower.com.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.UserBiz;
import flower.com.entity.User;
import flower.com.util.EmailUtil;
import flower.com.util.GetRoundUtil;
/*找回密码1*/
public class FindBackPasswordStepOne extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserBiz userBiz;
	private String username;
	private String email;
	
	public UserBiz getUserBiz() {
		return userBiz;
	}
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	public String getUsername(){
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String execute(){
		ActionContext context = ActionContext.getContext();
		if(this.username == null || this.email == null){
			return "default";
		}else{
			try{
				User user = this.userBiz.findUserByUsername(this.username);
				String emailCheckCode = new String();
				if(user == null){
					context.put("findpassInfo", "用户不存在");
					return "default";
				}else if(!email.equals(user.getEmail().toUpperCase())){
					emailCheckCode = GetRoundUtil.getVerificationCode();
					EmailUtil.sendMessage(EmailUtil.sendUserEmail, this.email, "DROWHAND找回密码验证码", "您的验证码为"+emailCheckCode+",请在三分钟之内验证");
					context.put("username", user.getUsername());
					context.put("emailCheckInfo", emailCheckCode);
					return "success";
				}else{
					context.put("findpassInfo", "用户名和邮箱不匹配");
					return "default";
				}
			}catch(Exception e){
				e.printStackTrace();
				return "default";
			}
		}
		
	}
	
}
