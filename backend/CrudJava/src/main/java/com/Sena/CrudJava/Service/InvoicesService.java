package com.Sena.CrudJava.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.Sena.CrudJava.DTO.responseDTO;
import com.Sena.CrudJava.DTO.requestRegister.requestRegisterInvoices;
import com.Sena.CrudJava.DTO.responseDTo.ResponseInvoicesDTO;
import com.Sena.CrudJava.Interface.IInvoices;
import com.Sena.CrudJava.Interface.IUser;
import com.Sena.CrudJava.Model.Invoices;
import com.Sena.CrudJava.Model.Users;

@Service
public class InvoicesService {
    @Autowired
    private IInvoices invoicesData;
    @Autowired
    private IUser userData;

    public List<Invoices> finAllSupplier(){
        return invoicesData.findAll();
    }

    public Optional<Invoices> finByIdSupplier(int id ){
        return invoicesData.findById(id);
    }

public List<ResponseInvoicesDTO> findAllInvoices() {
    return invoicesData.findAll().stream()
        .map(inv -> new ResponseInvoicesDTO(
            inv.getInvoicesId(),
            inv.getUsers().getUserId(),
            inv.getNameInvoices(),
            inv.getDate()
        ))
        .toList();
}


     public responseDTO save(requestRegisterInvoices invoices){
        responseDTO response = new responseDTO();
        try {
            invoicesData.save(convertRegistSupplier(invoices));
            response.setStatus(HttpStatus.OK);
            response.setMessage("Supplier saved");
            return response;
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            return response;
        }
    }



    public responseDTO update(requestRegisterInvoices invoicesUpdate) {
        responseDTO response = new responseDTO();
        var optionalInvoice = finByIdSupplier(invoicesUpdate.getInvoicesId());
    
        if (optionalInvoice.isPresent()) {
            Invoices invoice = optionalInvoice.get();
    
            // Creamos el objeto Users solo con el ID
            Users user = new Users();
            user.setUserId(invoicesUpdate.getUserId());
    
            invoice.setUsers(user);
            invoice.setNameInvoices(invoicesUpdate.getNameInvoices());
            invoice.setDate(invoicesUpdate.getDate());
            // Si necesitas actualizar los productos, también debes manejarlos aquí
    
            invoicesData.save(invoice); // guarda la entidad modificada
    
            response.setStatus(HttpStatus.OK);
            response.setMessage("actualizado bien");
        } else {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage("actualizado mal");
        }
    
        return response;
    }
    


    public Invoices convertRegistSupplier(requestRegisterInvoices invoices){
        
         Users user = userData.findById(invoices.getUserId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        
    return new Invoices(
        0,
        user,
        invoices.getNameInvoices(),
        invoices.getDate(),
        null
    );
    }

    public responseDTO Deleted(int id){
        var supplier = invoicesData.findById(id);
        responseDTO response = new responseDTO();
        if(supplier.isPresent()){
            invoicesData.delete(supplier.get());
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
