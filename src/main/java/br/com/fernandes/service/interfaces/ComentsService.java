package br.com.fernandes.service.interfaces;

import br.com.fernandes.service.dto.request.ComentsResponse;

import java.util.List;

public interface ComentsService {
    List<ComentsResponse> getComents();
}
