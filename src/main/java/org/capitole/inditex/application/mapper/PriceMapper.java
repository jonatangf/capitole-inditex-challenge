package org.capitole.inditex.application.mapper;

import org.capitole.inditex.adapter.out.persistence.model.PriceEntity;
import org.capitole.inditex.domain.model.Price;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    Price mapToDomain(PriceEntity priceEntity);

    List<Price> mapToDomain(List<PriceEntity> priceEntity);

    PriceEntity mapToEntity(Price price);
}
