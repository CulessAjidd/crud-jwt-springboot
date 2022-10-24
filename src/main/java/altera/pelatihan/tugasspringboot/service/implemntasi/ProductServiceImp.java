package altera.pelatihan.tugasspringboot.service.implemntasi;

import altera.pelatihan.tugasspringboot.form.RequestProduct;
import altera.pelatihan.tugasspringboot.model.ProductModel;
import altera.pelatihan.tugasspringboot.repository.ProductRepository;
import altera.pelatihan.tugasspringboot.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductModel findOne(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public ProductModel save(RequestProduct requestProduct) {
        ProductModel productModel = new ProductModel(requestProduct.getName(), requestProduct.getHarga());
        return productRepository.save(productModel);
    }

    @Override
    public ProductModel update(Long id, RequestProduct requestProduct) {
        ProductModel productModel = findOne(id);
        productModel.setName(requestProduct.getName());
        productModel.setHarga(requestProduct.getHarga());
        return productRepository.save(productModel);
    }

    @Override
    public void deleteOne(Long id) {
        productRepository.deleteById(id);
    }
}
