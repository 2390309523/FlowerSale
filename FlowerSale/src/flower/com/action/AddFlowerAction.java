package flower.com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

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
import flower.com.entity.User;
import flower.com.util.ImageUtil;

public class AddFlowerAction extends ActionSupport implements ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpSession session;
	private FlowerBiz flowerBiz;
	private FlowerFileBiz flowerFileBiz;
	private String flowerName;
	private String flowerPrice;
	private String flowerUpdataPrice;
	private String flowerArea;
	private String flowerIntroduce;
	private String flowerColor;
	private String flowerType;
	private String flowerStock;
	private String flowerMaxBuy;
	private String flowerEnglishName;
	private String flowerExpress;
	private File[] pic;
	private String[] picFileName ;  
	
	public String[] getPicFileName() {
		return picFileName;
	}
	public void setPicFileName(String[] picFileName) {
		this.picFileName = picFileName;
	}
	public String[] getPicContentType() {
		return picContentType;
	}
	public void setPicContentType(String[] picContentType) {
		this.picContentType = picContentType;
	}
	private String[] picContentType;
	private InputStream is;
	private OutputStream os;
	public String addFlower() throws IOException{
		session = request.getSession();
		Flower flower = new Flower();
		List<FlowerFile> flowerFiles = new ArrayList<FlowerFile>();
		Store store = (Store)session.getAttribute("store");
		String path = ServletActionContext.getRequest().getRealPath(File.separator+"UploadFile"+File.separator+"FlowerShowImage");
		if("" != flowerName && "" != flowerPrice){
			flower.setStoreName(store.getStoreName());
			flower.setFlowerName(this.flowerName);
			flower.setFlowerPrice(Double.parseDouble(this.flowerPrice));
			flower.setFlowerArea("updata");
			flower.setFlowerStoke(9999);
			flower.setFlowerMaxBuy(9999);
			this.flowerBiz.saveFlower(flower);
			for(Flower f:this.flowerBiz.findFlowerByStoreAndFlower(flowerName, store.getStoreName())){
				if(flowerName.equals(f.getFlowerName()) && store.getStoreName().equals(f.getStoreName())){
					flower = f;
				}
			}
			if(null != flower.getId()){
				for(int i = 0 ; i<pic.length;i++){
					if(null != pic[i]){
						FlowerFile flowerFile = new FlowerFile();
						is = new FileInputStream(pic[i]);
						String newFileName = ImageUtil.renameToCurrentMillis(picFileName[i]);
						File updataFile = new File(path,newFileName);
						os = new FileOutputStream(updataFile);
						int j = 0;
						byte[] buffer = new byte[1024];
						while(j != -1){
							j = is.read(buffer);
				            os.write(buffer);
						}
						String filepath = "."+
								File.separator+"UploadFile"+File.separator+"FlowerShowImage"+File.separator+newFileName;
						String fileRealPath = path+File.separator+newFileName;
						if(0 == i){
							flower.setFilePath(filepath);
							flower.setFilePathReal(fileRealPath);
						}
						flowerFile.setFilePath(filepath);
						flowerFile.setFileRealPath(fileRealPath);
						flowerFile.setFlowerId(flower.getId());
						flowerFiles.add(flowerFile);
					}
					is.close();
					os.close();
				}
				
			}
			if(!"".equals(this.flowerUpdataPrice)) flower.setFlowerUpdataPrice(Double.parseDouble(this.flowerUpdataPrice));
			if(!"".equals(this.flowerArea)) flower.setFlowerArea(this.flowerArea);
			if(!"".equals(this.flowerIntroduce)) flower.setFlowerIntroduce(this.flowerIntroduce);
			if(!"".equals(this.flowerColor)) flower.setFlowerColor(this.flowerColor);
			if(!"".equals(this.flowerType)) flower.setFlowerType(this.flowerType);
			if(!"".equals(this.flowerStock)) flower.setFlowerStoke(Integer.parseInt(this.flowerStock));
			if(!"".equals(this.flowerMaxBuy)) flower.setFlowerMaxBuy(Integer.parseInt(this.flowerMaxBuy));
			if(!"".equals(this.flowerEnglishName)) flower.setEnglishName(this.flowerEnglishName);
			if(!"".equals(this.flowerExpress)) flower.setFlowerExpress(this.flowerExpress);
			this.flowerBiz.updataFlowerInfo(flower);
			this.flowerFileBiz.saveFlowerFiles(flowerFiles);
			ActionContext.getContext().put("addFlowerInfo", "花卉"+flowerName+"加入商店成功");	
		}else{
			ActionContext.getContext().put("addFlowerInfo", "花卉"+flowerName+"加入商店失败：原因，您的商店存在改商品，您可以修改");
		}
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
	public String getFlowerArea() {
		return flowerArea;
	}
	public void setFlowerArea(String flowerArea) {
		this.flowerArea = flowerArea;
	}
	public String getFlowerIntroduce() {
		return flowerIntroduce;
	}
	public void setFlowerIntroduce(String flowerIntroduce) {
		this.flowerIntroduce = flowerIntroduce;
	}
	public String getFlowerColor() {
		return flowerColor;
	}
	public void setFlowerColor(String flowerColor) {
		this.flowerColor = flowerColor;
	}
	public String getFlowerType() {
		return flowerType;
	}
	public void setFlowerType(String flowerType) {
		this.flowerType = flowerType;
	}
	public String getFlowerStock() {
		return flowerStock;
	}
	public void setFlowerStock(String flowerStock) {
		this.flowerStock = flowerStock;
	}
	public String getFlowerEnglishName() {
		return flowerEnglishName;
	}
	public void setFlowerEnglishName(String flowerEnglishName) {
		this.flowerEnglishName = flowerEnglishName;
	}
	public String getFlowerExpress() {
		return flowerExpress;
	}
	public void setFlowerExpress(String flowerExpress) {
		this.flowerExpress = flowerExpress;
	}
	public File[] getPic() {
		return pic;
	}
	public void setPic(File[] pic) {
		this.pic = pic;
	}
	public String getFlowerMaxBuy() {
		return flowerMaxBuy;
	}
	public void setFlowerMaxBuy(String flowerMaxBuy) {
		this.flowerMaxBuy = flowerMaxBuy;
	}
	

}
