package org.capitole.inditex.adapter.in.controller.price;

import org.capitole.inditex.adapter.in.controller.price.model.SearchPriceRequestBody;
import org.capitole.inditex.adapter.in.controller.price.model.SearchPriceResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

    @GetMapping
    public SearchPriceResponseBody searchPrice(
            @ModelAttribute SearchPriceRequestBody searchPriceRequestBody
    ) {
        return new SearchPriceResponseBody();
    }
}
