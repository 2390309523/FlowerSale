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
import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.FlowerBiz;
import flower.com.biz.OrderBiz;
import flower.com.biz.StoreBiz;
import flower.com.biz.UserBiz;
import flower.com.entity.Flower;
import flower.com.entity.Order;
import flower.com.entity.Store;
import flower.com.entity.User;
import flower.com.util.ImageUtil;

/*修改个人信息*/
public class ChangeUserInfoAction extends ActionSupport
implements ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StoreBiz storeBiz;
	private FlowerBiz flowerBiz;
	private UserBiz userBiz;
	private OrderBiz orderBiz;
	private HttpServletRequest request;
	private HttpSession session;
	private String daliyName;
	private File headImage;
	private String headImageFileName ;  
	private String headImageContentType;
	private String email;
	private String phoneNumber;
	private String storeName;
	
	public String updataUserInfo() throws IOException{
		session = request.getSession();
		User user = (User)session.getAttribute("user");
		Store store = (Store)session.getAttribute("store");
		if(null!=this.headImage){
			String path = ServletActionContext.getRequest().getRealPath(File.separator+"UploadFile"+File.separator+"UserHeaderImage");
			/*System.out.println(path);
			将上传的文件转化成为宽只有四百
			ImageUtil.toLowerSize(headImage, 400, 400);
			String fileName = ImageUtil.renameToCurrentMillis(headImageFileName);
			headImage.renameTo(new File(path+File.separator+fileName));
			try {
				if(ImageUtil.toFile(headImage, path)){
					System.out.println(fileName+" save successfully!");
					if(new File(user.getHeadImage())!=null){
						(new File(user.getHeadImage())).delete();
					}
					user.setHeadImage(ImageUtil.getFullPath(new File(headImage, path)));
					System.out.println(ImageUtil.getFullPath(new File(headImage, path)));
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
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
		if(null!=this.daliyName && !"".equals(this.daliyName)) user.setDailyName(this.daliyName);
		if(null!=this.phoneNumber && !"".equals(this.phoneNumber)) user.setPhone(this.phoneNumber);
		if(null!=this.storeName && !"".equals(this.storeName)){
			user.setStoreName(this.storeName);
			List<Order> orders = this.orderBiz.findOrderByStorename(this.storeName);
			for(Order order:orders){
				this.orderBiz.updataOrder(order);
			}
		}
		if(null!=this.storeName && !"".equals(this.storeName)) {
			List<Flower> flowers = this.flowerBiz.findFlowersByStoreName(store.getStoreName());
			for(Flower f:flowers){
				f.setStoreName(this.storeName);
				this.flowerBiz.updataFlowerInfo(f);
			}
			store.setStoreName(this.storeName);
		}
		
		if(this.userBiz.updataUser(user)) session.setAttribute("user", user);
		if(this.storeBiz.updataStoreInfo(store)) session.setAttribute("store",store);
		ActionContext.getContext().put("updataUserInfo", "用户信息更新成功");
		return "success";
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
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
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public FlowerBiz getFlowerBiz() {
		return flowerBiz;
	}
	public void setFlowerBiz(FlowerBiz flowerBiz) {
		this.flowerBiz = flowerBiz;
	}
	public OrderBiz getOrderBiz() {
		return orderBiz;
	}
	public void setOrderBiz(OrderBiz orderBiz) {
		this.orderBiz = orderBiz;
	}
}
