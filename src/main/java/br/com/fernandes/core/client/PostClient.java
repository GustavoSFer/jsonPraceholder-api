package br.com.fernandes.core.client;

import br.com.fernandes.service.dto.request.PostResponse;

import java.util.List;

public interface PostClient {
    List<PostResponse> getPosts();
    PostResponse getById(String id);
}
