package br.com.fernandes.service.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ComentsResponse(
        @JsonProperty("postId")
        int postId,
        @JsonProperty("id")
        int id,
        @JsonProperty("name")
        String name,
        @JsonProperty("email")
        String email,
        @JsonProperty("body")
        String body
) {
}
