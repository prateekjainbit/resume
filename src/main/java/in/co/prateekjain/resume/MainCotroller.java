package in.co.prateekjain.resume;

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

@Controller
public class MainCotroller {
	@Autowired
    private JavaMailSender javaMailSender;
	
	
	
	@RequestMapping("/")
	public String home()
	{
		return "index.html";
	}
	@RequestMapping(value= "/sendMail", method = RequestMethod.GET)
	public ModelAndView sendMail(@RequestParam(value = "contactName")String contactName,@RequestParam(value = "contactEmail") String contactEmail, @RequestParam(value = "contactSubject")String contactSubject, @RequestParam(value = "contactMessage")String contactMessage)
	{
		
		
		 SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo("prateek_jain@programmer.net");

	        msg.setSubject("Resume Contact Email from your website :"+contactSubject);
	        msg.setText(contactMessage+"\n From \n"+contactName+"\n"+contactEmail);

	        javaMailSender.send(msg);
		
	
		System.out.println("function called");
		return new ModelAndView("index.html");
	}
	
	
	




   
	
	
	
}
