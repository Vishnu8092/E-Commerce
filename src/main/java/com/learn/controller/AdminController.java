package com.learn.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.learn.dao.ProductDao;
import com.learn.model.Category;
import com.learn.model.Product;
import com.learn.service.CategoryService;
import com.learn.service.ProductService;

@Controller
public class AdminController {

	public static String uploadDir = System.getProperty("user.dir")+ "/src/main/resources/static/productImages";
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;

	@GetMapping("/admin")
	public String adminHome() {
		return "adminHome";
	}

	@GetMapping("/admin/categories")
	public String getCat(Model model) {
		model.addAttribute("categories", categoryService.getAllCategory());
		return "categories";
	}

	@GetMapping("/admin/categories/add")
	public String getCatAdd(Model model) {
		model.addAttribute("category", new Category());
		return "categoriesAdd";
	}

	@PostMapping("/admin/categories/add")
	public String postCatAdd(@ModelAttribute("category") Category category) {
		categoryService.addCategory(category);
		return "redirect:/admin/categories";
	}

	@GetMapping("/admin/categories/delete/{id}")
	public String CatDelete(@PathVariable int id) {
		categoryService.removeCategoryById(id);
		return "redirect:/admin/categories";
	}

	@GetMapping("/admin/categories/update/{id}")
	public String CatUpdate(@PathVariable int id, Model model) {
		Optional<Category> category = categoryService.getCategoryById(id);
		if (category.isPresent()) {
			model.addAttribute("category", category.get());
			return "categoriesAdd";
		} else
			return "404";
	}

//---------------------------------PRODUCT SECTION---------------------------------------------------------

	@GetMapping("/admin/products")
	public String getProduct(Model model) {
		model.addAttribute("products", productService.getAllProduct());
		return "products";
	}

	@GetMapping("/admin/products/add")
	public String getProductAdd(Model model) {
		model.addAttribute("productDao", new ProductDao());
		model.addAttribute("categories", categoryService.getAllCategory());
		return "productsAdd";
	}

	@PostMapping("/admin/products/add")
	public String productAddPost(@ModelAttribute("productDao") ProductDao productDao,
			@RequestParam("productImage") MultipartFile file, @RequestParam("imgName") String imgName)
			throws IOException {

		Product product = new Product();
//Products add form
		
		product.setId(productDao.getId());
		product.setName(productDao.getName());
		product.setCategory(categoryService.getCategoryById(productDao.getCategory()).get());
		product.setPrice(productDao.getPrice());
		product.setDescription(productDao.getDescription());
		product.setQuantity(productDao.getQuantity());
 //Image upload on product
		String imageUUID;
		if(!file.isEmpty()) {
			imageUUID = file.getOriginalFilename();
			Path fileNameAndPath = Paths.get(uploadDir,imageUUID);
			Files.write(fileNameAndPath, file.getBytes());
		}else {
			imageUUID = imgName;
		}
		product.setImageName(imageUUID);
		productService.addProduct(product);
		
		return "redirect:/admin/products";
	}
	
	
	//Delete product
	@GetMapping("/admin/product/delete/{id}")
	public String deleteProduct(@PathVariable long id) {
		productService.removeProductById(id);
		System.out.println("product id"+id);
		return "redirect:/admin/products";
	}
	
	//Update product
	@GetMapping("/admin/product/update/{id}")
	public String updateProduct(@PathVariable long id,Model model) {
		Product product = productService.getProductById(id).get();
		ProductDao productDao = new ProductDao();
		productDao.setId(product.getId());
		productDao.setName(product.getName());
		productDao.setCategory((product.getCategory().getId()));
		productDao.setPrice(product.getPrice());
		productDao.setQuantity(product.getQuantity());
		productDao.setDescription(product.getDescription());
		productDao.setImageName(product.getImageName());
		
		model.addAttribute("categories",categoryService.getAllCategory());
		model.addAttribute("productDao", productDao);
		
		return "productsAdd";
	}
	
	
	
}
