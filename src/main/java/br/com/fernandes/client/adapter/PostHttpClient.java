package br.com.fernandes.client.adapter;

import br.com.fernandes.client.PostFeignClient;
import br.com.fernandes.core.client.PostClient;
import br.com.fernandes.service.dto.request.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostHttpClient implements PostClient {

    @Autowired
    private PostFeignClient postFeignClient;

    @Override
    public List<PostResponse> getPosts() {
        try {
            return postFeignClient.getPosts();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
