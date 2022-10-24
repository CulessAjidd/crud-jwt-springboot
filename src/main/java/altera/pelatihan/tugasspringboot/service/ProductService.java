package altera.pelatihan.tugasspringboot.service;

import altera.pelatihan.tugasspringboot.form.RequestProduct;
import altera.pelatihan.tugasspringboot.model.ProductModel;

import java.util.List;

public interface ProductService {

    List<ProductModel> findAll();

    ProductModel findOne(Long id);

    ProductModel save(RequestProduct requestProduct);

    ProductModel update(Long id, RequestProduct requestProduct);

    void deleteOne(Long id);
}
