package cl.duoc.lmorderms.clients;

import cl.duoc.lmorderms.dtos.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "APICatalog", url = "http://localhost:8088/api/v1/productos")
public interface ToAPICatalogFeing {

    @GetMapping("/{id}")
    public ProductoDTO obtener(@PathVariable Long id);
}
