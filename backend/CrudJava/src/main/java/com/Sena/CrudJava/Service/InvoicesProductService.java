package com.Sena.CrudJava.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.Sena.CrudJava.DTO.responseDTO;
import com.Sena.CrudJava.DTO.requestRegister.requestInvoicesProduct;
import com.Sena.CrudJava.DTO.responseDTo.ResponseInvoicesProduct;
import com.Sena.CrudJava.Interface.IInvoicesProduct;
import com.Sena.CrudJava.Model.Invoices;
import com.Sena.CrudJava.Model.InvoicesProduct;
import com.Sena.CrudJava.Model.Product;

@Service
public class InvoicesProductService {

    @Autowired
    private IInvoicesProduct invoicesProductData;

    public List<ResponseInvoicesProduct> getProductSupplierInfo() {
        return invoicesProductData.findAllProductinvoicesInfo();
    }

    public ResponseInvoicesProduct getProductSupplierInfoById(int id) {
        return invoicesProductData.findProductinvoicesInfoById(id);
    }

    public Optional<InvoicesProduct> finByIdSupplier(int id ){
        return invoicesProductData.findById(id);
    }


    public responseDTO save(requestInvoicesProduct invoicesProduct){
        responseDTO response = new responseDTO();
        try {
            invoicesProductData.save(convInvoicesProduct(invoicesProduct));
            response.setStatus(HttpStatus.OK);
            response.setMessage("invoicesProduct saved");
            return response;
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            return response;
        }
    }

      public responseDTO update(requestInvoicesProduct  invoicesProductUpdate){
        responseDTO response = new responseDTO();
        var invoicesProductt = finByIdSupplier(invoicesProductUpdate.getInvoicesProductId());
        if(invoicesProductt.isPresent()){
            Invoices invoices = new Invoices();
            Product productt = new Product();
            invoices.setInvoicesId(invoicesProductUpdate.getInvoicesId());
            productt.setProductId(invoicesProductUpdate.getProductId());
            invoicesProductt.get().setInvoices(invoices);
            invoicesProductt.get().setProduct(productt);
            response.setStatus(HttpStatus.OK);
            response.setMessage("actualizado bien");
            return response;
        }else{
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage("actualizado mal");
            return response;
        }
    }



    public InvoicesProduct convInvoicesProduct(requestInvoicesProduct invoicesProduct){
        Invoices invoices = new Invoices();
        invoices.setInvoicesId(invoicesProduct.getInvoicesId());
           Product product = new Product();
        product.setProductId(invoicesProduct.getProductId());

        return new InvoicesProduct(
            0,
            invoices,
            product

        );
    }

      public responseDTO Deleted(int id){
        var supplier = invoicesProductData.findById(id);
        responseDTO response = new responseDTO();
        if(supplier.isPresent()){
            invoicesProductData.delete(supplier.get());
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
