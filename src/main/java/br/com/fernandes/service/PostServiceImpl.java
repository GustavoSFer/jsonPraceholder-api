package br.com.fernandes.service;

import br.com.fernandes.core.client.PostClient;
import br.com.fernandes.service.dto.request.PostResponse;
import br.com.fernandes.service.interfaces.PostRedisRepository;
import br.com.fernandes.service.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final int MINUTO = 1000;
    private final long MINUTOS = MINUTO;

    @Autowired
    private PostClient postClient;

    @Autowired
    private PostRedisRepository redisRepository;

    @Override
    public List<PostResponse> getPosts() {
        List<PostResponse> posts = postClient.getPosts();
        redisRepository.saveAll(posts);
        deleteDataRedis();
        return posts;
    }

    @Override
    public PostResponse getById(String id) {
        return postClient.getById(id);
    }

    @Override
    @Scheduled(fixedDelay = MINUTOS)
    public void deleteDataRedis() {
        List<PostResponse> posts = (List<PostResponse>) redisRepository.findAll();

        if (!CollectionUtils.isEmpty(posts)) {
            redisRepository.deleteAll(posts);
        } else {
            System.out.println("Não existe dados para ser deletado!");
        }
    }

}
