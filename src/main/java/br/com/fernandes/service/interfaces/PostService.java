package br.com.fernandes.service.interfaces;

import br.com.fernandes.service.dto.request.PostResponse;

import java.util.List;

public interface PostService {
    List<PostResponse> getPosts();
    PostResponse getById(String id);
}
