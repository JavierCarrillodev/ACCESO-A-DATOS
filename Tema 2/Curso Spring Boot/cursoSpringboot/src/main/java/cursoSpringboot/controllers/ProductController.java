package cursoSpringboot.controllers;

import cursoSpringboot.domain.Product;
import cursoSpringboot.service.ProductsServicelmpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {
    ProductsServicelmpl productsServicelmpl = new ProductsServicelmpl();

    @GetMapping
    public ResponseEntity<?> getProducts(){
        List<Product> products = productsServicelmpl.getProducts();

        return ResponseEntity.ok(products);
    }

}
