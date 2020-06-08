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
	/*���ļ�������Ϊʱ���������������ע�⣬����ֻ�����ͼƬ���ֶ��Եı���head.jpg-��124512454.jpg*/
	public static String renameToCurrentMillis(String filename){
		return System.currentTimeMillis()+"."+filename.split("\\.")[1];
	}
	public static String renameToCurrentMillis(File file){
		String filename = file.getName();
		return System.currentTimeMillis()+"."+filename.split("\\.")[1];
	}
	/*��ȡ�ļ����ļ�����������ָ�ı���c://user/desktop/jiarui.txt,����ֵΪjiarui.txt*/
	public static String getFilename(File file){
		/*��ȡ�ļ���ȫ�����ƣ�Ҳ���ǰ���·��*/
		String fileGlobleName = file.getName();
		return fileGlobleName;
	}
	
	/*���ļ�ת��Ϊ�����ļ������룬path��ָ���ļ�·��*/
	public static boolean toFile(File file,String path,String rename) throws FileNotFoundException,IOException{
		int length = 0;
		/*�����ļ�����������ͨ���������ֽ�*/
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
	/*��д����*/
	public static boolean toFile(File file,String path) throws FileNotFoundException,IOException{
		/*�����ļ�����������ͨ���������ֽ�*/
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
	/*���ļ�ת����Ϊ��С�ĳߴ�,���ұ���,ԭ�򣺵ȱ���ѹ�����Կ��Ϊ׼*/
	public static boolean toLowerSize(File file,int height,int width){
		try{
			Thumbnails.of(file).size(height, width).toFile(file);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	/*����ͼƬ�����ȣ�Ҳ����ͼƬ������С�����ļ��ĳߴ粻��,���ͷֱ���*/
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
	/*���ļ�������������������·�����ƣ�*/
	public static String getFullPath(File file){
		String filePath = file.getAbsolutePath();
		String fileName = file.getName();
/*		������һ������ImageUtil.rename�Ĳ��������ļ���ת��Ϊʱ���*/
 		return filePath+ImageUtil.pathChar+fileName;
	}
	/*���ļ�����������ȡ,���ҷ����ļ�����������֣�·��+�ļ�����*/
	public static List<String> saveFileList(List<File> files,String path) throws IOException{
		List<String> result = null;
		for(int i = 0; i<files.size();i++){
			String[] name = files.get(i).getName().toString().split("\\.");
			String fullName= files.get(i).getPath()+ImageUtil.pathChar+System.currentTimeMillis()+"."+name[1];
			/*���ļ����д�ȡ*/
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
	/*���ļ���������ɾ��*/
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
	/*ͨ���ļ���������·�������ļ���ɾ���ļ�*/
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
	/*�滻����ɾ���ļ�*/
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
