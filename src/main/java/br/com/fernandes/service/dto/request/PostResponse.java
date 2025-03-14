package br.com.fernandes.service.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PostResponse(
        @JsonProperty("userId")
        int userId,
        @JsonProperty("id")
        int id,
        @JsonProperty("title")
        String title,
        @JsonProperty("body")
        String body
) {
}
