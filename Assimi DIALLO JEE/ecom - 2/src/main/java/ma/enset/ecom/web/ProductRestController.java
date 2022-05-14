package ma.enset.ecom.web;

import ma.enset.ecom.dtos.CategoryDTO;
import ma.enset.ecom.dtos.ProductDTO;
import ma.enset.ecom.entities.Product;
import ma.enset.ecom.repositories.ProductRepository;
import ma.enset.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ProductRestController {
    @Autowired
    private ProductService productService;
    @GetMapping(path = "/products")
    public List<ProductDTO> productList(){
        return  productService.listProducts();
    }
    @GetMapping(path = "/products/{id}")
    public ProductDTO getProducts(@PathVariable(name = "id") String id){
        return productService.getProduct(id);
    }
    @PostMapping(path = "/products")
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO){
        return productService.save(productDTO);
    }

    @PutMapping(path = "/products/{id}")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO,@PathVariable String id){
        productDTO.setId(id);
        return productService.save(productDTO);
    }

    @DeleteMapping(path = "/products/{id}")
    public void deleteProduct(@PathVariable String id){
         productService.deleteProduct(id);
    }

}
