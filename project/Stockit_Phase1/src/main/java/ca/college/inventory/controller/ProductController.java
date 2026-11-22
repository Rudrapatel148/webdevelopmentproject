package ca.college.inventory.controller;
import ca.college.inventory.model.*;
import ca.college.inventory.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Set;
@Controller @RequestMapping("/products") public class ProductController {
 private final ProductRepository repo;
 private static final Set<String> SORTABLE=Set.of("name","price","quantity","createdAt");
 public ProductController(ProductRepository repo){this.repo=repo;}
 @ModelAttribute("categories") public Category[] categories(){return Category.values();}
 @GetMapping public String list(@RequestParam(required=false) Category category,@RequestParam(required=false) String stock,@RequestParam(defaultValue="name") String sort,@RequestParam(defaultValue="asc") String direction,@RequestParam(defaultValue="0") int page,Model model){
  String safeSort=SORTABLE.contains(sort)?sort:"name";String safeDir="desc".equalsIgnoreCase(direction)?"desc":"asc";
  String safeStock=("LOW".equals(stock)||"OK".equals(stock))?stock:null;
  Pageable pageable=PageRequest.of(Math.max(0,page),8,Sort.by(Sort.Direction.fromString(safeDir),safeSort));
  Page<Product> results=repo.search(category,safeStock,pageable);
  model.addAttribute("products",results);model.addAttribute("selectedCategory",category);model.addAttribute("stock",safeStock);model.addAttribute("sort",safeSort);model.addAttribute("direction",safeDir);return "products/list";
 }
 @GetMapping("/new") public String newForm(Model model){model.addAttribute("product",new Product());return "products/new";}
 @PostMapping public String create(@Valid @ModelAttribute("product") Product product,BindingResult errors,Model model,RedirectAttributes redirect){
  if(product.getSku()!=null&&repo.existsBySkuIgnoreCase(product.getSku()))errors.rejectValue("sku","duplicate","This SKU is already registered");
  if(errors.hasErrors())return "products/new";
  Product saved=repo.save(product);redirect.addFlashAttribute("success","Product saved successfully!");return "redirect:/products/"+saved.getId();
 }
 @GetMapping("/{id}") public String detail(@PathVariable Long id,Model model){model.addAttribute("product",repo.findById(id).orElseThrow(()->new org.springframework.web.server.ResponseStatusException(org.springframework.http.HttpStatus.NOT_FOUND,"Product not found")));return "products/detail";}
}
