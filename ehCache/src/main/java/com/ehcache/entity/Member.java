package com.ehcache.entity;

import lombok.Builder;

@Builder
public record Member(
    Long id,
    String name
) {
}
