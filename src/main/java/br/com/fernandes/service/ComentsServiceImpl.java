package br.com.fernandes.service;

import br.com.fernandes.client.adapter.ComentsHttpCliente;
import br.com.fernandes.service.dto.request.ComentsResponse;
import br.com.fernandes.service.interfaces.ComentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentsServiceImpl implements ComentsService {

    @Autowired
    ComentsHttpCliente comentsHttpCliente;

    @Override
    public List<ComentsResponse> getComents() {
        return comentsHttpCliente.getComents();
    }
}
