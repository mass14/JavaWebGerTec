package br.com.calculareceita.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

@ManagedBean
public class EnivaEmailMB {

	private String from, subject, msg, to;


	public void enviar(){
		MultiPartEmail email = new MultiPartEmail();
		email.setSSLOnConnect(true);
		email.setHostName("smtp.gmail.com");
		email.setSslSmtpPort("465");
		email.setAuthenticator(new DefaultAuthenticator("rodrigo.candido@edu.sc.senai.br", "1111"));
		
		FacesContext context = FacesContext.getCurrentInstance();
		try{
			email.setFrom("rodrigo.candido@edu.sc.senai.br"); 
			email.setDebug(true);
			email.setSubject(subject); 
			email.setMsg(msg);
			email.addTo(to);
			email.send();
			context.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, "E-mail enviado com sucesso!", ""));
		}catch(EmailException e){
			context.addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro!", ""));
			e.printStackTrace();
		}

		
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
}
