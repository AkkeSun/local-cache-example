package com.caffeine.entity;

import lombok.Builder;

@Builder
public record Order(
    Long id,
    Long name
) {

}
