package br.com.fernandes.client.adapter;

import br.com.fernandes.client.ComentsFeignClient;
import br.com.fernandes.core.client.ComentsClient;
import br.com.fernandes.service.dto.request.ComentsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ComentsHttpCliente implements ComentsClient {

    @Autowired
    ComentsFeignClient comentsFeignClient;

    @Override
    public List<ComentsResponse> getComents() {
        try {
            return comentsFeignClient.getComents();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
