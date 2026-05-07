package cl.duoc.lmorderms.clients;


import cl.duoc.lmorderms.dtos.ClienteOrderResponseDTO;
import cl.duoc.lmorderms.dtos.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// APIName = "APICustomer";
// APIURL = "http://localhost:8082/clientes";

@FeignClient(name = "APICustomer", url = "http://localhost:8082/api/v1/clientes")
public interface ToAPICustomerFeing {

    @GetMapping("/{id}")
    ClienteOrderResponseDTO findById(@PathVariable Long id);
}


