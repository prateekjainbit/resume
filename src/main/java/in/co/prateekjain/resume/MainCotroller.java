package in.co.prateekjain.resume;

import java.io.IOException;
import com.sendgrid.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Controller
public class MainCotroller {
//	@Autowired
//    private JavaMailSender javaMailSender;

	
	@RequestMapping("/")
	public String home()
	{
		return "index.html";
	}
	
	@RequestMapping(value= "/sendMail", method = RequestMethod.GET)
	public ModelAndView sendMail(@RequestParam(value = "contactName")String contactName,@RequestParam(value = "contactEmail") String contactEmail, @RequestParam(value = "contactSubject")String contactSubject, @RequestParam(value = "contactMessage")String contactMessage) throws IOException
		{
//			try {
//		
//	        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
//	        Request request = new Request();
//	        request.setMethod(Method.POST);
//	        request.setEndpoint("mail/send");
//	        request.setBody(contactName+"\n"+contactEmail+"\n"+contactSubject+"\n"+contactMessage);
//	        Response response = sg.api(request);
//	        System.out.println(response.getStatusCode());
//	        System.out.println(response.getBody());
//	        System.out.println(response.getHeaders());
//	      } catch (IOException ex) {
//	        throw ex;
//	      }
		 
		
		
//		SimpleMailMessage msg = new SimpleMailMessage();
//	        msg.setTo("prateek_jain@programmer.net");
//
//	        msg.setSubject("Resume Contact Email from your website :"+contactSubject);
//	        msg.setText(contactMessage+"\n From \n"+contactName+"\n"+contactEmail);
//
//	        javaMailSender.send(msg);
//		
//	
//		System.out.println("function called");

		Email from = new Email("prateekjainbit@gmail.com");
	    String subject = contactSubject;
	    Email to = new Email("prateekjainbitm@gmail.com");
	    Content content = new Content("text/plain", contactEmail+"\n"+contactMessage);
	    Mail mail = new Mail(from, subject, to, content);

	    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
	    Request request = new Request();
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      Response response = sg.api(request);
	      System.out.println(response.getStatusCode());
	      System.out.println(response.getBody());
	      System.out.println(response.getHeaders());
	    } catch (IOException ex) {
	      throw ex;
	    }
		return new ModelAndView("index.html");
	}
	
	
	
}

