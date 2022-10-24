package altera.pelatihan.tugasspringboot.controller;

import altera.pelatihan.tugasspringboot.form.RequestProduct;
import altera.pelatihan.tugasspringboot.model.ProductModel;
import altera.pelatihan.tugasspringboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductConroller {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Object> saveProduct(@Valid @RequestBody RequestProduct requestProduct, Errors errors) {
        try {
            if (!errors.hasErrors()) {
                ProductModel productModels = productService.save(requestProduct);
                return ResponseEntity.ok(productModels);
            }else {
                List<String> message = new ArrayList<>();
                for (ObjectError error : errors.getAllErrors()) {
                    message.add(error.getDefaultMessage());
                    break;
                }
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
            }
        }catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch (Throwable e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@Valid @RequestBody RequestProduct requestProduct, Errors errors, @PathVariable("id") Long id) {
        try {
            if (!errors.hasErrors()) {
                ProductModel productModels = productService.update(id, requestProduct);
                return ResponseEntity.ok(productModels);
            }else {
                List<String> message = new ArrayList<>();
                for (ObjectError error : errors.getAllErrors()) {
                    message.add(error.getDefaultMessage());
                    break;
                }
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
            }
        }catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch (Throwable e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List> findProducts() {
        try {
            List<ProductModel> productModels = productService.findAll();
            return ResponseEntity.ok(productModels);
        }catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }catch (Throwable e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> findProduct(@PathVariable("id") Long id) {
        try {
            ProductModel productModel = productService.findOne(id);
            return ResponseEntity.ok(productModel);
        }catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }catch (Throwable e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        try {
            productService.deleteOne(id);
            return ResponseEntity.ok("success deleted");
        }catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch (Throwable e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
