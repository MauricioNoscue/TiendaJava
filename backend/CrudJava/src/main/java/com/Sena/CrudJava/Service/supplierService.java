package com.Sena.CrudJava.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.Sena.CrudJava.DTO.responseDTO;
import com.Sena.CrudJava.DTO.requestRegister.requestRegisterSupplier;
import com.Sena.CrudJava.Interface.ISupplier;
import com.Sena.CrudJava.Model.Supplier;

@Service
public class supplierService {

    @Autowired
    private ISupplier supplierData;

    public List<Supplier> finAllSupplier(){
        return supplierData.findAll();
    }

    public Optional<Supplier> finByIdSupplier(int id ){
        return supplierData.findById(id);
    }

    public responseDTO save(requestRegisterSupplier supplier){
        responseDTO response = new responseDTO();
        try {
            supplierData.save(convertRegistSupplier(supplier));
            response.setStatus(HttpStatus.OK);
            response.setMessage("Supplier saved");
            return response;
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage("Supplier  no guardado");
            return response;
        }
    }
    public responseDTO update(requestRegisterSupplier supplierUpdate){
        responseDTO response = new responseDTO();
        var supplierr = finByIdSupplier(supplierUpdate.getSupplierID());
        if(supplierr.isPresent()){
            supplierr.get().setAddress(supplierUpdate.getAddress());
            supplierr.get().setSupplierName(supplierUpdate.getSupplierName());
            supplierr.get().setEmail(supplierUpdate.getEmail());
            supplierr.get().setPhone(supplierUpdate.getPhone());
            supplierData.save(supplierr.get());
            response.setStatus(HttpStatus.OK);
            response.setMessage("actualizado bien");
            return response;
        }else{
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage("actualizado mal");
            return response;
        }
    }

    public Supplier convertRegistSupplier(requestRegisterSupplier suplier){
        return new Supplier(
            0,
            suplier.getAddress(),
            suplier.getSupplierName(),
            suplier.getEmail(),
            suplier.getPhone()
        );
    }

    public responseDTO Deleted(int id){
        var supplier = supplierData.findById(id);
        responseDTO response = new responseDTO();
        if(supplier.isPresent()){
            supplierData.delete(supplier.get());
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
