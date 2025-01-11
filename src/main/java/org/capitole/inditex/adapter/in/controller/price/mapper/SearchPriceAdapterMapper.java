package org.capitole.inditex.adapter.in.controller.price.mapper;

import org.capitole.inditex.adapter.in.controller.price.model.SearchPriceRequestBody;
import org.capitole.inditex.application.model.SearchPriceApplicationParameters;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SearchPriceAdapterMapper {

    SearchPriceApplicationParameters mapToApplicationParameters(SearchPriceRequestBody searchPriceRequestBody);
}
