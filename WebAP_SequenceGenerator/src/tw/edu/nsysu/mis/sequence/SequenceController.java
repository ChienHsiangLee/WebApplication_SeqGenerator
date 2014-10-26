package tw.edu.nsysu.mis.sequence;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.edu.nsysu.mis.sequence.SequenceGenerator;


@Controller
@RequestMapping("/seq")
public class SequenceController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showSequence(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("seq-service.xml");		
		SequenceGenerator generator = (SequenceGenerator) context.getBean("sequenceGenerator");
		
		List<String> seqs = new ArrayList<String>();
		
		seqs.add(generator.getSequence());
		seqs.add(generator.getSequence());
		//seqs.add("seq1");
		//seqs.add("seq2");

		model.addAttribute("sequences", seqs);
		return "showSequence";
	}
	

}
