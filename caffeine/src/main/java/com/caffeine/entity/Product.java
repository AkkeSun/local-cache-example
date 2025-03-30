package com.caffeine.entity;

import lombok.Builder;

@Builder
public record Product(
    Long id,
    Long name
) {

}
