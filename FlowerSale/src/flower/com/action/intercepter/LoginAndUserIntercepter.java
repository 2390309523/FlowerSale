package flower.com.action.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import flower.com.entity.User;

public class LoginAndUserIntercepter extends MethodFilterInterceptor{
	private HttpServletRequest request;
	private HttpSession session;
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		ActionContext ac = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) ac.get(ServletActionContext.HTTP_REQUEST);
		// TODO Auto-generated method stub
		session = request.getSession();
		/*获取一个全局的Session对User判空*/
		User user = (User)session.getAttribute("user");
		if(user == null && user.getUsername().equals("administrator")){
			/*返回没登录，在action里面对应unLogin的结果*/
			return "unLogin";
		}
		return invocation.invoke();
	}
}
