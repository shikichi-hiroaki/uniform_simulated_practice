package util;

import java.util.Properties;
import java.util.Date;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import bean.*;

import javax.mail.internet.InternetAddress;

public class SendMail {

	public void MailSetup(String userid, Purchase purchase, String product_name) {
		try {
			Properties props = System.getProperties();

			Purchase purchases=new Purchase();

			// SMTPサーバのアドレスを指定（今回はxserverのSMTPサーバを利用）
			props.put("mail.smtp.host", "sv5215.xserver.jp");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.debug", "true");

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					// メールサーバにログインするメールアドレスとパスワードを設定
					return new PasswordAuthentication("test.sender@kanda-it-school-system.com", "kandaSender");
				}
			});

			MimeMessage mimeMessage = new MimeMessage(session);

			// 送信元メールアドレスと送信者名を指定
			mimeMessage.setFrom(new InternetAddress("test.sender@kanda-it-school-system.com", "神田IT School", "iso-2022-jp"));

			String mail_adress=purchases.getmail_adress();

			// 送信先メールアドレスを指定
			mimeMessage.setRecipients(Message.RecipientType.TO, mail_adress);

			// メールのタイトルを指定
			mimeMessage.setSubject("書籍ご購入明細", "iso-2022-jp");

			String message = userid + "様\n\nユニフォームのご購入ありがとうございます。\n" + "以下内容でご注文を受け付けましたので、ご連絡致します。\n\n";


			message += product_name+ " " + purchase.getCount() + " " + purchase.getAmount_money() + "円\n";

			message += "またのご利用よろしくお願いします。";

			// メールの内容を指定
			mimeMessage.setText(message, "iso-2022-jp");

			// メールの形式を指定
			mimeMessage.setHeader("Content-Type", "text/plain; charset=iso-2022-jp");

			// 送信日付を指定
			mimeMessage.setSentDate(new Date());

			// 送信します
			Transport.send(mimeMessage);

			// 送信成功
			System.out.println("送信に成功しました。");

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("送信に失敗しました。\n" + e);
		}
	}
}
