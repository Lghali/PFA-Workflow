package pfa.emsi;

import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkflowApplication {

	public static void main(String[] args) throws ParseException {
//		ApplicationContext ctx = 
		SpringApplication.run(WorkflowApplication.class, args);
//		AdminRepository adminRepository = ctx.getBean(AdminRepository.class);
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		adminRepository.save(new Admin("adresse", df.parse("2018-12-20"), "admin@gmail.com", "admin", "nom", "0619000000", "admin", "prenom"));

//		ChefServiceRepository chfserviceRepository = ctx.getBean(ChefServiceRepository.class);

//		chfserviceRepository.save(new ChefService("adresse", df.parse("2018-12-20"), df.parse("2015-04-15"), "email", "login", "nom", "numTe", "password", "prenom"));

	}

}
