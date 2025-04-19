package br.com.fernandes.service.interfaces;

import br.com.fernandes.service.dto.request.PostResponse;
import org.springframework.data.repository.CrudRepository;

public interface PostRedisRepository extends CrudRepository<PostResponse, Integer> {
}
