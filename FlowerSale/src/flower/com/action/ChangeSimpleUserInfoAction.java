package flower.com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;

import flower.com.biz.FlowerBiz;
import flower.com.biz.OrderBiz;
import flower.com.biz.StoreBiz;
import flower.com.biz.UserBiz;
import flower.com.entity.Flower;
import flower.com.entity.Order;
import flower.com.entity.Store;
import flower.com.entity.User;
import flower.com.util.ImageUtil;

public class ChangeSimpleUserInfoAction implements ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FlowerBiz flowerBiz;
	private UserBiz userBiz;
	private HttpServletRequest request;
	private HttpSession session;
	private String daliyName;
	private File headImage;
	private String headImageFileName ;  
	private String headImageContentType;
	private String email;
	private String phoneNumber;
	
	
	public String changeSimpleUserInfo() throws IOException{
		session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(null!=this.headImage){
			String path = ServletActionContext.getRequest().getRealPath(File.separator+"UploadFile"+File.separator+"UserHeaderImage");
			try {
				/*将文件转化成为400*400大小*/
				/*ImageUtil.toLowerSize(headImage, 400, 400);*/
				InputStream is = new FileInputStream(headImage);
				/*创建一个以时间戳命名的靶文件加入OS里面*/
				String newFileName = ImageUtil.renameToCurrentMillis(headImageFileName);
				File updataFile = new File(path,newFileName);
				//if(!updataFile.exists()) try{updataFile.createNewFile();}catch(IOException e){e.printStackTrace();}
				OutputStream os = new FileOutputStream(new File(path,newFileName));
				int i = 0;
				byte[] buffer = new byte[1024];
				while(i != -1){
					i = is.read(buffer);
		            os.write(buffer);
				}
				ImageUtil.toLowerSize(new File(path,newFileName), 400,400);
				if(user.getHeadImageRealPath()!=null){
					File realFile = new File(user.getHeadImageRealPath());
					realFile.delete();
					realFile = null;	
				}
				is.close();
				os.close();
				user.setHeadImage("."+
						File.separator+"UploadFile"+File.separator+"UserHeaderImage"+File.separator+newFileName);
				user.setHeadImageRealPath(path+File.separator+newFileName);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(!"".equals(this.daliyName)) user.setDailyName(this.daliyName);
		if(!"".equals(this.phoneNumber)) user.setPhone(this.phoneNumber);
		if(!"".equals(this.email)) user.setEmail(this.email);
		if(this.userBiz.updataUser(user)) session.setAttribute("user", user);
		ActionContext.getContext().put("updataUserInfo", "用户信息更新成功");
		return "success";
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	public FlowerBiz getFlowerBiz() {
		return flowerBiz;
	}
	public void setFlowerBiz(FlowerBiz flowerBiz) {
		this.flowerBiz = flowerBiz;
	}
	public UserBiz getUserBiz() {
		return userBiz;
	}
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	public String getDaliyName() {
		return daliyName;
	}
	public void setDaliyName(String daliyName) {
		this.daliyName = daliyName;
	}
	public File getHeadImage() {
		return headImage;
	}
	public void setHeadImage(File headImage) {
		this.headImage = headImage;
	}
	public String getHeadImageFileName() {
		return headImageFileName;
	}
	public void setHeadImageFileName(String headImageFileName) {
		this.headImageFileName = headImageFileName;
	}
	public String getHeadImageContentType() {
		return headImageContentType;
	}
	public void setHeadImageContentType(String headImageContentType) {
		this.headImageContentType = headImageContentType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
