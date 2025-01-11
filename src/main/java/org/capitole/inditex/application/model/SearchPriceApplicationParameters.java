package org.capitole.inditex.application.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SearchPriceApplicationParameters {
    private Long brandId;
    private Long productId;
    private Instant effectiveDate;
    @Builder.Default
    private Integer page = 0;
    @Builder.Default
    private Integer size = 20;
}
