package ca.college.inventory.controller;
import ca.college.inventory.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller public class PageController {
 private final ProductRepository repo;
 public PageController(ProductRepository repo){this.repo=repo;}
 @GetMapping("/") public String home(Model model){model.addAttribute("count",repo.count());return "home";}
 @GetMapping("/about") public String about(){return "about";}
 @GetMapping("/guide") public String guide(){return "guide";}
}
