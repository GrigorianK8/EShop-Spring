package am.itspace.eshopspring.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import am.itspace.eshopspring.entity.Product;
import am.itspace.eshopspring.service.CategoryService;
import am.itspace.eshopspring.service.ProductService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/products/{id}")
    public String productSinglePage(@PathVariable("id") int id, ModelMap modelMap){
        Product byId = productService.findById(id);
        if(byId == null){
            return "redirect:/";
        }
        modelMap.addAttribute("product", byId);
        modelMap.addAttribute("categories", categoryService.findAll());
        return "user/singleProduct";
    }
}
