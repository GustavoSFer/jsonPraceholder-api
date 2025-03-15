package br.com.fernandes.core.client;

import br.com.fernandes.service.dto.request.ComentsResponse;

import java.util.List;

public interface ComentsClient {

    List<ComentsResponse> getComents();

}
