package com.nisholas.staybook.infrastructure.Converter;

import com.nisholas.staybook.core.enums.AcomodacaoTipos;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AcomodacaoTiposConverter implements Converter<String, AcomodacaoTipos> {

    @Override
    public AcomodacaoTipos convert(String source) {
        return AcomodacaoTipos.valueOf(source.toUpperCase());
    }
}
