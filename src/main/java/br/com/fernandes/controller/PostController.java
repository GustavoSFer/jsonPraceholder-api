package br.com.fernandes.controller;

import br.com.fernandes.service.PostServiceImpl;
import br.com.fernandes.service.dto.request.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/jsonplaceholder-api")
@RestController
public class PostController {

    @Autowired
    private PostServiceImpl postService;

    @GetMapping("/posts")
    public ResponseEntity<List<PostResponse>> getPosts() {
        List<PostResponse> posts = postService.getPosts();

        return ResponseEntity.ok().body(posts);
    }
}
