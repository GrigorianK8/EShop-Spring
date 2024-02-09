package am.itspace.eshopspring.controller;


import am.itspace.eshopspring.entity.Product;
import am.itspace.eshopspring.security.SpringUser;
import am.itspace.eshopspring.service.CategoryService;
import am.itspace.eshopspring.service.ProductPictureService;
import am.itspace.eshopspring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final CategoryService categoryService;
    private final ProductService productService;
    private final ProductPictureService productPictureService;

    @GetMapping("/admin/home")
    public String adminHome() {
        return "admin/home";
    }

    @GetMapping("/admin/product/add")
    public String addProductPage(ModelMap modelMap) {
        modelMap.addAttribute("categories", categoryService.findAll());
        return "admin/addProduct";
    }

    @PostMapping("/admin/product/add")
    public String addProduct(@AuthenticationPrincipal SpringUser springUser,
                             @ModelAttribute Product product,
                             @RequestParam("pics") List<MultipartFile> pics) {
        product.setUser(springUser.getUser());
        Product saved = productService.save(product);
        productPictureService.saveAll(saved, pics);
        return "redirect:/admin/home";
    }
}
