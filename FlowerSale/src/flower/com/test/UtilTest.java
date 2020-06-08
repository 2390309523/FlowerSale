package flower.com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import com.opensymphony.xwork2.ActionSupport;

import flower.com.action.ChangeUserInfoAction;
import flower.com.util.GetRoundUtil;
import flower.com.util.ImageUtil;

/*自定义工具类的测试类*/
public class UtilTest{
	@Test
	public void imageTest() throws IOException{
		/*System.out.println(ImageUtil.renameToCurrentMillis("jiarui.jpg"));*/
		/*StringBuffer separator  = new StringBuffer(File.separator);
		File file = new File("C:"+separator+"Users"+separator+"贾瑞"+separator+"Desktop"+separator+"TEST"+separator+"p.jpg");
		if(ImageUtil.toLowerSize(file,0.1f)){
			System.out.println("success");
		}else System.out.println("default");
		*/
		List<String> s = new ArrayList<String>();
		s.add("zhangsan");
		s.add("lisi");
		System.out.println(s.get(0));
		/*for(int i = 0;i<10;i++){
			System.out.println(GetRoundUtil.getRandomPassword());
			//System.out.println((char)Integer.parseInt("65"));
		}*/
		/*File file = new File("C:"+File.separator+"Users"+File.separator+"贾瑞"+File.separator+"Desktop"+File.separator+
				"TEST"+File.separator+"pic1.jpg");
		System.out.println(ImageUtil.getFullPath(file)+";");*/
		
	}
	
}
