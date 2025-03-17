package br.com.fernandes.controller;

import br.com.fernandes.service.dto.request.ComentsResponse;
import br.com.fernandes.service.interfaces.ComentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("${base.url}")
@RestController
public class ComentsController {

    @Autowired
    private ComentsService comentsService;

    @GetMapping("/comments")
    public ResponseEntity<List<ComentsResponse>> getComents() {
        List<ComentsResponse> coments = comentsService.getComents();

        return ResponseEntity.ok().body(coments);
    }
}
