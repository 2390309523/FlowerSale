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

import flower.com.biz.FlowerBiz;
import flower.com.biz.FlowerFileBiz;
import flower.com.entity.Flower;
import flower.com.entity.FlowerFile;
import flower.com.entity.Store;
import flower.com.util.ImageUtil;

/*更新花卉信息*/
public class UpdataFlowerInfoAction extends ActionSupport implements
ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpSession session;
	private String flowerName;
	private String flowerPrice;
	private String flowerUpdataPrice;
	private String flowerColor;
	private String flowerMaxBuy;
	private String flowerStock;
	private String flowerType;
	private String flowerEnglishName;
	private String flowerArea;
	private String flowerExpress;
	private String flowerIntroduce;
	private String flowerId;
	private File picture;
	private String pictureFileName ;  
	private String pictureContentType;
	private FlowerBiz flowerBiz;
	private FlowerFileBiz flowerFileBiz;
	public String updataFlowerInfo(){
		ActionContext  context = ActionContext.getContext();
		FlowerFile flowerFile = new FlowerFile();
		String isFloat ="^\\+?([1-9]+\\.\\d+|0\\.\\d*[1-9])$";
		String isInteger = "^\\+?[0-9]\\d*$";
		session = request.getSession();
		Flower flower = this.flowerBiz.getFlowerByFlowerId(Integer.parseInt(this.flowerId));
		System.out.println(flowerName);
		if(!"".equals(this.flowerName)) flower.setFlowerName(this.flowerName);
		if(!"".equals(this.flowerPrice) && flowerPrice.matches(isFloat)) flower.setFlowerPrice(Double.parseDouble(this.flowerPrice));
		if(!"".equals(this.flowerUpdataPrice) && flowerUpdataPrice.matches(isFloat)) flower.setFlowerUpdataPrice(Double.parseDouble(this.flowerUpdataPrice));
		if(!"".equals(this.flowerColor)&& null!=flowerColor) flower.setFlowerColor(this.flowerColor);
		if(!"".equals(this.flowerMaxBuy) && flowerMaxBuy.matches(isInteger)) flower.setFlowerMaxBuy(Integer.parseInt(this.flowerMaxBuy));
		if(!"".equals(this.flowerStock) && flowerStock.matches(isInteger)) flower.setFlowerStoke(Integer.parseInt(this.flowerStock));
		if(!"".equals(this.flowerType)) flower.setFlowerType(this.flowerType);
		if(!"".equals(this.flowerEnglishName)) flower.setEnglishName(this.flowerEnglishName);
		if(!"".equals(this.flowerArea) && flowerArea.length()>10 && flowerArea.length()<255) flower.setFlowerArea(this.flowerArea);
		if(!"".equals(this.flowerExpress) && flowerExpress.length()<255 && flowerExpress.length()>20)
			flower.setFlowerExpress(flowerExpress);
		if(!"".equals(this.flowerIntroduce) && flowerIntroduce.length()<255 && flowerIntroduce.length()>20)
			flower.setFlowerIntroduce(this.flowerIntroduce);
		if(!"".equals(this.pictureFileName) && picture!=null){
			
			String path = ServletActionContext.getRequest().getRealPath(File.separator+"UploadFile"+File.separator+"FlowerShowImage");
			try {
				InputStream is = new FileInputStream(picture);
				String newFileName = ImageUtil.renameToCurrentMillis(pictureFileName);
				File updataFile = new File(path,newFileName);
				OutputStream os = new FileOutputStream(new File(path,newFileName));
				int i = 0;
				byte[] buffer = new byte[1024];
				while(i != -1){
					i = is.read(buffer);
		            os.write(buffer);
				}
				is.close();
				os.close();
				flower.setFilePath("."+
						File.separator+"UploadFile"+File.separator+"FlowerShowImage"+File.separator+newFileName);
				flowerFile.setFilePath("."+
						File.separator+"UploadFile"+File.separator+"FlowerShowImage"+File.separator+newFileName);
				flowerFile.setFileRealPath(path+File.separator+newFileName);
				flowerFile.setFlowerId(Integer.parseInt(this.flowerId));
				if(this.flowerFileBiz.savaFlowerFile(flowerFile)){
					System.out.println("-------------saveFileSuccessful--------------");
				}else{
					System.out.println("-------------saveFileDefault--------------");
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		this.flowerBiz.updataFlowerInfo(flower);
		context.put("updataUserInfo", "0X123");
		return "success";
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
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
	public String getFlowerName() {
		return flowerName;
	}
	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}
	public String getFlowerPrice() {
		return flowerPrice;
	}
	public void setFlowerPrice(String flowerPrice) {
		this.flowerPrice = flowerPrice;
	}
	public String getFlowerUpdataPrice() {
		return flowerUpdataPrice;
	}
	public void setFlowerUpdataPrice(String flowerUpdataPrice) {
		this.flowerUpdataPrice = flowerUpdataPrice;
	}
	public String getFlowerColor() {
		return flowerColor;
	}
	public void setFlowerColor(String flowerColor) {
		this.flowerColor = flowerColor;
	}
	public String getFlowerMaxBuy() {
		return flowerMaxBuy;
	}
	public void setFlowerMaxBuy(String flowerMaxBuy) {
		this.flowerMaxBuy = flowerMaxBuy;
	}
	public String getFlowerStock() {
		return flowerStock;
	}
	public void setFlowerStock(String flowerStock) {
		this.flowerStock = flowerStock;
	}
	public String getFlowerType() {
		return flowerType;
	}
	public void setFlowerType(String flowerType) {
		this.flowerType = flowerType;
	}
	public String getFlowerEnglishName() {
		return flowerEnglishName;
	}
	public void setFlowerEnglishName(String flowerEnglishName) {
		this.flowerEnglishName = flowerEnglishName;
	}
	public String getFlowerArea() {
		return flowerArea;
	}
	public void setFlowerArea(String flowerArea) {
		this.flowerArea = flowerArea;
	}
	public String getFlowerId() {
		return flowerId;
	}
	public void setFlowerId(String flowerId) {
		this.flowerId = flowerId;
	}
	public String getFlowerExpress() {
		return flowerExpress;
	}
	public void setFlowerExpress(String flowerExpress) {
		this.flowerExpress = flowerExpress;
	}
	public String getFlowerIntroduce() {
		return flowerIntroduce;
	}
	public void setFlowerIntroduce(String flowerIntroduce) {
		this.flowerIntroduce = flowerIntroduce;
	}
	public File getPicture() {
		return picture;
	}
	public void setPicture(File picture) {
		this.picture = picture;
	}
	public String getPictureFileName() {
		return pictureFileName;
	}
	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}
	public String getPictureContentType() {
		return pictureContentType;
	}
	public void setPictureContentType(String pictureContentType) {
		this.pictureContentType = pictureContentType;
	}
	public FlowerBiz getFlowerBiz() {
		return flowerBiz;
	}
	public void setFlowerBiz(FlowerBiz flowerBiz) {
		this.flowerBiz = flowerBiz;
	}
	public FlowerFileBiz getFlowerFileBiz() {
		return flowerFileBiz;
	}
	public void setFlowerFileBiz(FlowerFileBiz flowerFileBiz) {
		this.flowerFileBiz = flowerFileBiz;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
