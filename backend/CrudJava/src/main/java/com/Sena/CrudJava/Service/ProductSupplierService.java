package com.Sena.CrudJava.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.Sena.CrudJava.DTO.responseDTO;
import com.Sena.CrudJava.DTO.requestRegister.requestRegisterProductSupplier;
import com.Sena.CrudJava.DTO.responseDTo.ResponseProductSupplier;
import com.Sena.CrudJava.Interface.IProductSupplier;
import com.Sena.CrudJava.Model.Product;
import com.Sena.CrudJava.Model.ProductSupplier;
import com.Sena.CrudJava.Model.Supplier;

@Service
public class ProductSupplierService {

    @Autowired
    private IProductSupplier productSupplierData;



    public List<ResponseProductSupplier> getProductSupplierInfo() {
        return productSupplierData.findAllProductSupplierInfo();
    }

    public ResponseProductSupplier getProductSupplierInfoById(int id) {
        return productSupplierData.findProductSupplierInfoById(id);
    }

    public Optional<ProductSupplier> finByIdSupplier(int id ){
        return productSupplierData.findById(id);
    }
    

    public responseDTO save(requestRegisterProductSupplier productSupplier){
        responseDTO response = new responseDTO();
        try {
            productSupplierData.save(convertProductSupplier(productSupplier));
            response.setStatus(HttpStatus.OK);
            response.setMessage("productSupplier saved");
            return response;
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            return response;
        }
    }

    public responseDTO update(requestRegisterProductSupplier  productsupplierUpdate){
        responseDTO response = new responseDTO();
        var  porductsuplier = finByIdSupplier(productsupplierUpdate.getProductSupplierId());
        if(porductsuplier.isPresent()){
            Supplier supplier = new Supplier();
            Product product = new Product();
            product.setProductId(productsupplierUpdate.getProductId());
            supplier.setSupplierID(productsupplierUpdate.getSupplierId());
            porductsuplier.get().setSupplier(supplier);
            porductsuplier.get().setProduct(product);
            productSupplierData.save(porductsuplier.get());
            response.setStatus(HttpStatus.OK);
            response.setMessage("actualizado bien");
            return response;
        }else{
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage("actualizado mal");
            return response;
        }
    }


    public ProductSupplier convertProductSupplier(requestRegisterProductSupplier productSupplier){
        Product product = new Product();
        product.setProductId(productSupplier.getProductId());

        Supplier supplier = new Supplier();
        supplier.setSupplierID(productSupplier.getSupplierId());

        return new ProductSupplier(
            0,
            product,
            supplier
        );
    }



    public responseDTO Deleted(int id){
        var supplier = productSupplierData.findById(id);
        responseDTO response = new responseDTO();
        if(supplier.isPresent()){
            productSupplierData.delete(supplier.get());
            response.setStatus(HttpStatus.OK);
            response.setMessage("Se elimino correctamente");
            return response;
        }else{
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setMessage("No se encontro el registro");
            return response;
        }
    }
}
