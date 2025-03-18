package br.com.fernandes.controller;

import br.com.fernandes.service.dto.request.PostResponse;
import br.com.fernandes.service.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("${base.url}")
@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<List<PostResponse>> getPosts() {
        List<PostResponse> posts = postService.getPosts();

        return ResponseEntity.ok().body(posts);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable String id) {
        PostResponse post = postService.getById(id);

        return ResponseEntity.ok().body(post);
    }
}
