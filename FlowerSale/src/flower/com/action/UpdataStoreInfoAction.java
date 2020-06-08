package flower.com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import flower.com.biz.StoreBiz;
import flower.com.entity.FlowerFile;
import flower.com.entity.Store;
import flower.com.util.ImageUtil;

/*更新商店信息*/
public class UpdataStoreInfoAction extends ActionSupport implements
ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String storeIntroduce;
	private String storeAddress;
	private File storeIcon;
	private String storeIconFileName;
	private String pictureContentType;
	private HttpServletRequest request;
	private HttpSession session;
	private StoreBiz storeBiz;
	public String updataStoreInfo(){
		session = request.getSession();
		Store store = (Store)session.getAttribute("store");
		if(""!=storeIntroduce && storeIntroduce.length()>10 &&storeIntroduce.length()<255)
			store.setStoreIntroduce(this.storeIntroduce);
		if(""!=storeAddress && storeAddress.length()>10 && storeAddress.length()<255)
			store.setStoreAddress(this.storeAddress);
		if(null!=storeIcon){
			FlowerFile flowerFile = new FlowerFile();
			String path = ServletActionContext.getRequest().getRealPath(File.separator+"UploadFile"+File.separator+"StoreHeaderImage");
			try {
				/*将文件转化成为400*400大小*/
				/*ImageUtil.toLowerSize(headImage, 400, 400);*/
				InputStream is = new FileInputStream(storeIcon);
				/*创建一个以时间戳命名的靶文件加入OS里面*/
				String newFileName = ImageUtil.renameToCurrentMillis(storeIconFileName);
				File updataFile = new File(path,newFileName);
				//if(!updataFile.exists()) try{updataFile.createNewFile();}catch(IOException e){e.printStackTrace();}
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.storeBiz.updataStoreInfo(store);
		session.setAttribute("store", store);
		ActionContext.getContext().put("updataStoreInfo", "店铺信息更新成功");
		return "success";
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request =request;
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
	public String getPictureContentType() {
		return pictureContentType;
	}
	public void setPictureContentType(String pictureContentType) {
		this.pictureContentType = pictureContentType;
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
	public StoreBiz getStoreBiz() {
		return storeBiz;
	}
	public void setStoreBiz(StoreBiz storeBiz) {
		this.storeBiz = storeBiz;
	}

}
