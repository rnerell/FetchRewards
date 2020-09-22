package com.fetch.pyramid.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Input pyramid Pojo.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class PyramidInput {
    @NotNull (message = "input cannot be null")
    private String input;


    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
