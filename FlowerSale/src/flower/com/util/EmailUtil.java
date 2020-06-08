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
	/*进行SMTP进行身份验证：密码*/
	public static final String SMTP = "qawtzigmhmwlecbd";
	/*默认发送方*/
	public static final String sendUserEmail = "2390309523@QQ.COM";
	/*发送邮件*/
	public static boolean sendMessage(String sendUserEmail,String resiveUserEmail,String title,String mes){
		try{
			// 创建Properties 类用于记录邮箱的一些属性
	        final Properties props = new Properties();
	        // 表示SMTP发送邮件，必须进行身份验证
	        props.put("mail.smtp.auth", "true");
	        //此处填写SMTP服务器
	        props.put("mail.smtp.host", "smtp.qq.com");
	        //端口号，QQ邮箱端口587
	        props.put("mail.smtp.port", "587");
	        // 此处填写，写信人的账号
	        props.put("mail.user", sendUserEmail);
	        // 此处填写16位STMP口令
	        props.put("mail.password", EmailUtil.SMTP);

	        // 构建授权信息，用于进行SMTP进行身份验证
	        Authenticator authenticator = new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                // 用户名、密码
	                String userName = props.getProperty("mail.user");
	                String password = props.getProperty("mail.password");
	                return new PasswordAuthentication(userName, password);
	            }
	        };
	        // 使用环境属性和授权信息，创建邮件会话
	        Session mailSession = Session.getInstance(props, authenticator);
	        // 创建邮件消息
	        MimeMessage message = new MimeMessage(mailSession);
	        // 设置发件人
	        InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
	        message.setFrom(form);
	        // 设置收件人的邮箱
	        InternetAddress to = new InternetAddress(resiveUserEmail);
	        message.setRecipient(RecipientType.TO, to);
	        // 设置邮件标题
	        message.setSubject(title);
	        // 设置邮件的内容体
	        message.setContent(mes,"text/html;charset=UTF-8");
	        // 发送邮件啦
	        Transport.send(message);
	        return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
}
