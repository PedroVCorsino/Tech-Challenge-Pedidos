package br.com.grupo27.techchallenge03.external.infrastructure.attributeConverter;

import br.com.grupo27.techchallenge03.domain.valuesObjects.ValidadorCPF;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ValidadorCPFConverter implements AttributeConverter<ValidadorCPF, String> {

    @Override
    public String convertToDatabaseColumn(ValidadorCPF attribute) {
        return attribute != null ? attribute.getValor() : null;
    }

    @Override
    public ValidadorCPF convertToEntityAttribute(String dbData) {
        return dbData != null ? new ValidadorCPF(dbData) : null;
    }
}
