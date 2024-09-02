package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Model.AdminVisi.Product;
import api_validvisi.API.Repo.AdminVisi.ProductRepo;
import api_validvisi.API.Service.AdminVisi.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ProductService productService;

    @GetMapping("/admin-visi/product")
    public Map<String, Object> getProduct() {
        List<Product> productList = productRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", productList);
        return response;
    }

    @GetMapping("/admin-visi/product/total-product")
    public Map<String, Object> getTotalProduct() {
        Long totalProduct = productService.getTotalProduct();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("total_product", totalProduct);
        return response;
    }
}
