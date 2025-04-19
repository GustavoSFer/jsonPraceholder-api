package br.com.fernandes.client;

import br.com.fernandes.service.dto.request.PostResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "PostFeignClient", url = "${url.placeholder}")
public interface PostFeignClient {

    @GetMapping("/posts")
    List<PostResponse> getPosts();

    @GetMapping("/posts/{id}")
    PostResponse getById(@PathVariable String id);
}
