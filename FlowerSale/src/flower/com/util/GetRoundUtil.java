package flower.com.util;

import java.util.Random;

public class GetRoundUtil {
	/*��ȡ��֤��*/
	public static String getVerificationCode(){
		Random random = new Random();
		String message = new String();
		for(int i =0;i<6;i++){
			message += random.nextInt(10)+"";
		}
		return message;
	}
	/*��ȡ��������д*1+Сд*4+����*5*/
	public static String getRandomPassword(){
		String pass = new String();
		for(int i = 0;i<10;i++){
			if(i==0){
				pass += (char)(Math.random()*(90-65)+65);
			}else if(i<5){
				pass += (char)(Math.random()*(122-97)+97);
			}else{
				pass += (char)(Math.random()*(57-48)+48);
			}
		}
		return pass;
	}
}
