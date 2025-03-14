package br.com.fernandes.client.adapter;

import br.com.fernandes.service.dto.request.PostResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "PostFeignClient", url = "https://jsonplaceholder.typicode.com")
public interface PostFeignClient {

    @GetMapping("/posts")
    List<PostResponse> getPosts();
}
