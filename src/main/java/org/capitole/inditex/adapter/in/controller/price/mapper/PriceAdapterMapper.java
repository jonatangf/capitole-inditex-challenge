package org.capitole.inditex.adapter.in.controller.price.mapper;

import org.capitole.inditex.adapter.in.controller.price.model.PriceDTO;
import org.capitole.inditex.domain.model.Price;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriceAdapterMapper {

    PriceDTO mapToDTO(Price price);
    List<PriceDTO> mapToDTO(List<Price> price);
}
