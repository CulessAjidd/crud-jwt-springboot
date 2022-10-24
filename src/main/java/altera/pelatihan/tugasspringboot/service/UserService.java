package altera.pelatihan.tugasspringboot.service;

import altera.pelatihan.tugasspringboot.form.RequestProduct;
import altera.pelatihan.tugasspringboot.model.ProductModel;
import altera.pelatihan.tugasspringboot.model.UserModel;

import java.util.List;

public interface UserService {

    String save(UserModel userModel);

    UserModel findOne(String id);

    List<UserModel> findAll();

    void deleteOne(String id);
}
