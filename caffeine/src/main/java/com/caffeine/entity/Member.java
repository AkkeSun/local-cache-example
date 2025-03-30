package com.caffeine.entity;

import lombok.Builder;

@Builder
public record Member(
    Long id,
    String name
) {
}
