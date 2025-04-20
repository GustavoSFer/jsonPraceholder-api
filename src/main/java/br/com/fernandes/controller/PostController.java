package br.com.fernandes.controller;

import br.com.fernandes.service.dto.request.PostResponse;
import br.com.fernandes.service.interfaces.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("${base.url}")
@RestController
public class PostController {

    private static Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<List<PostResponse>> getPosts() {
        logger.atInfo().setMessage("Inicio da busca de posts");
        List<PostResponse> posts = postService.getPosts();
        logger.atInfo().setMessage("").addKeyValue("chave", posts);
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable String id) {
        PostResponse post = postService.getById(id);

        return ResponseEntity.ok().body(post);
    }
}
