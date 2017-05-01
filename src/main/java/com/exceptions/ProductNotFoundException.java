package com.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Products")
public class ProductNotFoundException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(ProductNotFoundException.class);

    public ProductNotFoundException() {
        super();
        logger.info("no result could be retrieved from the repository for the user ");

    }
}