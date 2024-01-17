package enviando_email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ObjetoEnviaEmail {

	private String usuario = "enviaremailjavamurilo517@gmail.com";
	private String senha = "rqxo heyj hxlg qrsc ";
	
	private String listaDestinatarios = "";
	private String remetente = "";
	private String assunto = "";
	private String textoEmail = "";
	
	public ObjetoEnviaEmail(String listaDestinario,String nomeRemetente, String assuntoDoEmail, String textoEmail) {
		this.listaDestinatarios = listaDestinario;
		this.remetente = nomeRemetente;
		this.assunto = assuntoDoEmail;
		this.textoEmail = textoEmail;
	}

	public void enviarEmail() throws Exception {

		Properties properties = new Properties();

		properties.put("mail.smtp.ssl.trust", "*");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(usuario, senha);
			}
		});

		Address[] toUser = InternetAddress.parse(listaDestinatarios);

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(usuario, remetente));
		message.setRecipients(Message.RecipientType.TO, toUser);
		message.setSubject(assunto);
		message.setText(textoEmail);

		Transport.send(message);

	}

}
