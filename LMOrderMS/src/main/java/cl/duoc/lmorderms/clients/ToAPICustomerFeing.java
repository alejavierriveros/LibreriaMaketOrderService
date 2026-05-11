package cl.duoc.lmorderms.clients;


import cl.duoc.lmorderms.dtos.ClienteOrderResponseDTO;
import cl.duoc.lmorderms.dtos.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// APIName = LMCustomerMS;
// APIURL original sin Eureka y Gateway = "http://localhost:8082/clientes";

@FeignClient(name = "LMCustomerMS")
public interface ToAPICustomerFeing {

    @GetMapping("/{id}")
    ClienteOrderResponseDTO findById(@PathVariable Long id);
}


