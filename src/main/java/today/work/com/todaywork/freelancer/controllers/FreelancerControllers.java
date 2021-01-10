package today.work.com.todaywork.freelancer.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import  today.work.com.todaywork.freelancer.Freelancer;
import  today.work.com.todaywork.freelancer.repositories.*;
@Controller // This means that this class is a Controller
@RequestMapping(path="/employee") // This means URL's start with /demo (after Application path)
public class FreelancerControllers {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private FreeLancerRepository freeLancerRepository;

  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewUser (@RequestParam String name
      , @RequestParam String email , @RequestParam String mobile) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    Freelancer n = new Freelancer();
    n.setName(name);
    n.setEmail(email);
    n.setMobile(mobile);
    freeLancerRepository.save(n);
    return "Saved";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Freelancer> getAllUsers() {
    // This returns a JSON or XML with the users
    return freeLancerRepository.findAll();
  }
}