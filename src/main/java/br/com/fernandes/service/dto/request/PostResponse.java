package br.com.fernandes.service.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@RedisHash
public record PostResponse (

        @JsonProperty("userId")
        int userId,
        @Id
        @Indexed
        @JsonProperty("id")
        int id,
        @JsonProperty("title")
        String title,
        @JsonProperty("body")
        String body
) implements Serializable {
        private static final long serialVersionUID = 1L;
}
