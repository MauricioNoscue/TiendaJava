package com.Sena.CrudJava.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.Sena.CrudJava.DTO.responseDTO;
import com.Sena.CrudJava.DTO.requestRegister.requesRegisterProduct;
import com.Sena.CrudJava.Interface.ICategory;
import com.Sena.CrudJava.Interface.IProduct;
import com.Sena.CrudJava.Model.Category;
import com.Sena.CrudJava.Model.Product;



@Service
public class productService {
       @Autowired
       private IProduct productData;
       @Autowired
       private ICategory categoryData;


    public List<Product> finAll(){
        return productData.findAll();
    }
    
    public Optional<Product> finById(int id ){
        return productData.findById(id);
    }
    
    public List<requesRegisterProduct> buscar(String nombre){
        List<Product> productos = productData.buscarPorNombreLike(nombre);
        return productos.stream()
        .map(producto -> {
            requesRegisterProduct dto = new requesRegisterProduct();
            dto.setProductId(producto.getProductId());
            dto.setProductName(producto.getProductName());
            dto.setDescription(producto.getDescription());
            dto.setProductPrice(producto.getProductPrice());
            // Configura otros campos si son necesarios
            
            return dto;
        })
        .collect(Collectors.toList());
    }
   

    public responseDTO save(requesRegisterProduct product){
        responseDTO response = new responseDTO();
        try {
            productData.save(convertRegistProduct(product));
            response.setStatus(HttpStatus.OK);
            response.setMessage("product saved");
            return response;
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage("product  no guardado");
            return response;
        }
    }

    public responseDTO update(requesRegisterProduct productUpdate){
        responseDTO response = new responseDTO();

        var product = productData.findById(productUpdate.getProductId());
        
       
    
        if(product.isPresent()){
            Category category = new Category();
            category.setCategoryId(productUpdate.getCategoryId());
            product.get().setProductName(productUpdate.getProductName());
            product.get().setDescription(productUpdate.getDescription());
            product.get().setProductPrice(productUpdate.getProductPrice());
            product.get().setCategory(category);
            productData.save(product.get());
            response.setStatus(HttpStatus.OK);
            response.setMessage("actualizado bien");
            return response;

        }else{
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage("actualizado mal");
            return response;
        }
    }

    public responseDTO Deleted(int id){
        var product = productData.findById(id);
        responseDTO response = new responseDTO();
        if(product.isPresent()){
            productData.delete(product.get());
            response.setStatus(HttpStatus.OK);
            response.setMessage("Se elimino correctamente");
            return response;
        }else{
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setMessage("No se encontro el registro");
            return response;
        }
    }

    public Product convertRegistProduct(requesRegisterProduct product){

        Category category = new Category();
        category.setCategoryId(product.getCategoryId());
        return new Product(
            0,
            product.getProductName(),
            product.getDescription(),
            product.getProductPrice(),
            category,
            null
            
        );
    }

    
}
