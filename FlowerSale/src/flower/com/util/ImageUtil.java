package flower.com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import net.coobird.thumbnailator.Thumbnails;

public class ImageUtil {
	static final String pathChar = File.separator;
	/*将文件重命名为时间戳，避免重名，注意，这里只是针对图片名字而言的比如head.jpg-》124512454.jpg*/
	public static String renameToCurrentMillis(String filename){
		return System.currentTimeMillis()+"."+filename.split("\\.")[1];
	}
	public static String renameToCurrentMillis(File file){
		String filename = file.getName();
		return System.currentTimeMillis()+"."+filename.split("\\.")[1];
	}
	/*获取文件的文件名，这里是指的比如c://user/desktop/jiarui.txt,返回值为jiarui.txt*/
	public static String getFilename(File file){
		/*获取文件的全局名称，也就是包含路径*/
		String fileGlobleName = file.getName();
		return fileGlobleName;
	}
	
	/*将文件转化为流向文件中输入，path是指的文件路径*/
	public static boolean toFile(File file,String path,String rename) throws FileNotFoundException,IOException{
		int length = 0;
		/*设置文件输入流，向通道中输入字节*/
		InputStream is = new FileInputStream(file);
		File tofile = new File(path,rename);
		OutputStream os = new FileOutputStream(tofile);
		byte[] fileBuffer = new byte[1024];
		while(-1 != (length = is.read(fileBuffer,0,fileBuffer.length))){
			os.write(fileBuffer);
		}
		is.close();
		os.close();
		return true;
	}
	/*重写方法*/
	public static boolean toFile(File file,String path) throws FileNotFoundException,IOException{
		/*设置文件输入流，向通道中输入字节*/
		InputStream is = new FileInputStream(file);
		File tofile = new File(path,file.getName());
		OutputStream os = new FileOutputStream(tofile);
		byte[] fileBuffer = new byte[1024];
		int length = 0;
		while(-1 != (length = is.read(fileBuffer,0,fileBuffer.length))){
			os.write(fileBuffer);
		}
		is.close();
		os.close();
		return true;
	}
	/*把文件转化成为更小的尺寸,并且保存,原则：等比例压缩，以宽度为准*/
	public static boolean toLowerSize(File file,int height,int width){
		try{
			Thumbnails.of(file).size(height, width).toFile(file);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	/*控制图片清晰度，也就是图片扩大缩小但是文件的尺寸不变,降低分辨率*/
	public static boolean toLowerSize(File file,float picClear){
		try{
			Thumbnails.of(file).scale(1f).outputQuality(picClear).toFile(file);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public static String getPathchar() {
		return pathChar;
	}
	/*将文件重命名（返回完整的路径名称）*/
	public static String getFullPath(File file){
		String filePath = file.getAbsolutePath();
		String fileName = file.getName();
/*		这里有一步调用ImageUtil.rename的操作，将文件名转化为时间戳*/
 		return filePath+ImageUtil.pathChar+fileName;
	}
	/*对文件进行批量存取,并且返回文件名数组的名字（路径+文件名）*/
	public static List<String> saveFileList(List<File> files,String path) throws IOException{
		List<String> result = null;
		for(int i = 0; i<files.size();i++){
			String[] name = files.get(i).getName().toString().split("\\.");
			String fullName= files.get(i).getPath()+ImageUtil.pathChar+System.currentTimeMillis()+"."+name[1];
			/*对文件进行存取*/
			FileInputStream fis = new FileInputStream(files.get(i));
			FileOutputStream fos = new FileOutputStream(fullName);
			int len = 0;
			byte[] bytes = new byte[1024];
			while ((len = fis.read(bytes)) != -1) {
			     fos.write(bytes, 0, len);
			}
			fis.close();
			fos.close();
			result.add(fullName);
		}
		return result;
	}
	/*对文件进行批量删除*/
	public static boolean delFileListByListFile(List<File> files){
		try{
			for(File file:files){
				file.delete();
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	/*通过文件的完整的路径包括文件名删除文件*/
	public static boolean delFileListByListPath(List<String> fullPath){
		try{
			for(String filefull:fullPath){
				File file = new File(filefull);
				file.delete();
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	/*替换并且删除文件*/
	public static boolean replaceFile(File file,File replace){
		try{
			FileInputStream fis = new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream(replace);
			int len = 0;
			byte[] buffer = new byte[1024];
			while ((len = fis.read(buffer)) != -1) {
			     fos.write(buffer, 0, len);
			}
			fis.close();
			fos.close();
			file.delete();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
