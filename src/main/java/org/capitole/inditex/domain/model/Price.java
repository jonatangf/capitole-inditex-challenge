package org.capitole.inditex.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Price {
    private Long id;
    private Instant startDate;
    private Instant endDate;
    private Integer priority;
    private Double price;
    private String currency;
}
