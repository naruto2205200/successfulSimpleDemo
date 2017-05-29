package com.example.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * Created by naruto on 2017/5/29.
 */
public class SendEmail {

    private static final String HOST="smtp.163.com";
    private static final String PROTOCOL="smtp";
    private static final int PORT=25;
    private static final String FROM ="perfect_zhangxf@163.com";//发件人的email
    private static final String PWD="zhangxiaofeng";//发件人密码
    private static final String URL = "http://localhost:8080/iclass";//项目主页
    private static final int TIMELIMIT = 1000*60*60*24; //激活邮件过期时间24小时
    private static final String TITLE = "iClass账户激活邮件";

    /**
     * 获取Session
     * @return
     */
    private static Session getSession() {
        Properties props = new Properties();
        props.put("mail.smtp.host", HOST);//设置服务器地址
        props.put("mail.store.protocol" , PROTOCOL);//设置协议
        props.put("mail.smtp.port", PORT);//设置端口
        props.put("mail.smtp.auth" , true);


//        Authenticator authenticator = new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(FROM,PWD);
//            }
//        };
//        Session session = Session.getDefaultInstance(props , authenticator);

        Session session = Session.getInstance(props);
        return session;
    }

    public static void send(String toEmail , String content) {
        Session session = getSession();
        try {
            System.out.println("--send--"+content);
            MimeMessage message = new MimeMessage(session);//由邮件会话新建一个消息对象
            message.setFrom(new InternetAddress(FROM));//设置发件人的地址
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));//设置收件人,并设置其接收类型为TO
            message.setSubject(TITLE);//设置标题
            //设置信件内容
            //message.setText(mailContent); //发送 纯文本 邮件 todo
            message.setContent(content, "text/html;charset=utf-8"); //发送HTML邮件，内容样式比较丰富
            message.setSentDate(new Date());//设置发信时间
            message.saveChanges();//存储邮件信息
            //发送邮件
            Transport transport = session.getTransport(PROTOCOL);
            //Transport transport = session.getTransport();
            transport.connect(FROM, PWD);
            transport.sendMessage(message, message.getAllRecipients());//发送邮件,其中第二个参数是所有已设好的收件人地址
            transport.close();
        }
        catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
