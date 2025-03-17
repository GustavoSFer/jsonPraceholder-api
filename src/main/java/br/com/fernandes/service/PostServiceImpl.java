package br.com.fernandes.service;

import br.com.fernandes.core.client.PostClient;
import br.com.fernandes.service.dto.request.PostResponse;
import br.com.fernandes.service.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostClient postClient;

    @Override
    public List<PostResponse> getPosts() {
        return postClient.getPosts();
    }

}
