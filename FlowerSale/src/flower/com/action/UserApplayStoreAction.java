package flower.com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.StoreBiz;
import flower.com.biz.UserBiz;
import flower.com.entity.Store;
import flower.com.entity.User;
import flower.com.util.ImageUtil;

public class UserApplayStoreAction extends ActionSupport
implements ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String storeName;
	private String storeIntroduce;
	private String storeAddress;
	private File storeIcon;
	private String storeIconFileName;
	private StoreBiz storeBiz;
	private UserBiz userBiz;
	private HttpServletRequest request;
	private HttpSession session;
	@Override
	public String execute(){
		session=request.getSession();
		User user = (User)session.getAttribute("user");	
		if(!"".equals(storeName) && !"".equals(storeIntroduce) && !"".equals(storeAddress)){
			Store store =  new Store();
			store.setStoreName(storeName);
			store.setStoreAddress(storeAddress);
			store.setStoreIntroduce(storeIntroduce);
			store.setStoreSoleNum(0);
			store.setStoreCreateTime(new Timestamp(System.currentTimeMillis()));
			if(storeIcon!=null){
				String path = ServletActionContext.getRequest().getRealPath(File.separator+"UploadFile"+File.separator+"StoreHeaderImage");
				try {
					InputStream is = new FileInputStream(storeIcon);
					String newFileName = ImageUtil.renameToCurrentMillis(storeIconFileName);
					OutputStream os = new FileOutputStream(new File(path,newFileName));
					int i = 0;
					byte[] buffer = new byte[1024];
					while(i != -1){
						i = is.read(buffer);
			            os.write(buffer);
					}
					if(store.getStoreIconRelPath()!=null){
						File realFile = new File(store.getStoreIconRelPath());
						realFile.delete();
						realFile = null;	
					}
					is.close();
					os.close();
					store.setStoreIconPath("."+
							File.separator+"UploadFile"+File.separator+"StoreHeaderImage"+File.separator+newFileName);
					store.setStoreIconRelPath(path+File.separator+newFileName);

				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}else{
				store.setStoreIconPath("./UiFile/image/logo.png");
			}
			this.storeBiz.saveStore(store);
			user.setIndentity("administrator");
			user.setStoreName(storeName.trim());
			this.userBiz.updataUser(user);
			session.setAttribute("user", user);
			session.setAttribute("store",this.storeBiz.getStoreByStoreName(user.getStoreName()));
			return "yes";
		}else return "no";
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreIntroduce() {
		return storeIntroduce;
	}
	public void setStoreIntroduce(String storeIntroduce) {
		this.storeIntroduce = storeIntroduce;
	}
	public String getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	public File getStoreIcon() {
		return storeIcon;
	}
	public void setStoreIcon(File storeIcon) {
		this.storeIcon = storeIcon;
	}
	public String getStoreIconFileName() {
		return storeIconFileName;
	}
	public void setStoreIconFileName(String storeIconFileName) {
		this.storeIconFileName = storeIconFileName;
	}
	public StoreBiz getStoreBiz() {
		return storeBiz;
	}
	public void setStoreBiz(StoreBiz storeBiz) {
		this.storeBiz = storeBiz;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
