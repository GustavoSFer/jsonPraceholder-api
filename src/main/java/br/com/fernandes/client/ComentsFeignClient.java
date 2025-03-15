package br.com.fernandes.client;

import br.com.fernandes.service.dto.request.ComentsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "ComentsFeignClient" , url="${url.placeholder}")
public interface ComentsFeignClient {

    @GetMapping("/comments")
    List<ComentsResponse> getComents();

}
