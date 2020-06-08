package flower.com.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {
	/*����SMTP���������֤������*/
	public static final String SMTP = "qawtzigmhmwlecbd";
	/*Ĭ�Ϸ��ͷ�*/
	public static final String sendUserEmail = "2390309523@QQ.COM";
	/*�����ʼ�*/
	public static boolean sendMessage(String sendUserEmail,String resiveUserEmail,String title,String mes){
		try{
			// ����Properties �����ڼ�¼�����һЩ����
	        final Properties props = new Properties();
	        // ��ʾSMTP�����ʼ���������������֤
	        props.put("mail.smtp.auth", "true");
	        //�˴���дSMTP������
	        props.put("mail.smtp.host", "smtp.qq.com");
	        //�˿ںţ�QQ����˿�587
	        props.put("mail.smtp.port", "587");
	        // �˴���д��д���˵��˺�
	        props.put("mail.user", sendUserEmail);
	        // �˴���д16λSTMP����
	        props.put("mail.password", EmailUtil.SMTP);

	        // ������Ȩ��Ϣ�����ڽ���SMTP���������֤
	        Authenticator authenticator = new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                // �û���������
	                String userName = props.getProperty("mail.user");
	                String password = props.getProperty("mail.password");
	                return new PasswordAuthentication(userName, password);
	            }
	        };
	        // ʹ�û������Ժ���Ȩ��Ϣ�������ʼ��Ự
	        Session mailSession = Session.getInstance(props, authenticator);
	        // �����ʼ���Ϣ
	        MimeMessage message = new MimeMessage(mailSession);
	        // ���÷�����
	        InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
	        message.setFrom(form);
	        // �����ռ��˵�����
	        InternetAddress to = new InternetAddress(resiveUserEmail);
	        message.setRecipient(RecipientType.TO, to);
	        // �����ʼ�����
	        message.setSubject(title);
	        // �����ʼ���������
	        message.setContent(mes,"text/html;charset=UTF-8");
	        // �����ʼ���
	        Transport.send(message);
	        return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
}
