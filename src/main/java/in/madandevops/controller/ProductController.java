package in.madandevops.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.madandevops.binding.Product;
import in.madandevops.repository.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepo;

	@GetMapping("/")
	public String displayForm(Model model) {		
		Product productObj = new Product();
		model.addAttribute("product", productObj);

		List<Product> productsList = productRepo.findAll();
		model.addAttribute("products", productsList);
		
		return "index";
	}

	@PostMapping("/")
	public String saveProduct(Product product, Model model) {
				
		productRepo.save(product);
		List<Product> productsList = productRepo.findAll();
		model.addAttribute("products", productsList);
		
		Product productObj = new Product();
		model.addAttribute("product", productObj);
		
		
		model.addAttribute("msg", "Product saved successfully");		
		return "index";
	}
}
