package com.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT,
        reason = "Item Could not be added to the database")
public class ItemNotAddedToDatabaseException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(ItemNotAddedToDatabaseException.class);

    public ItemNotAddedToDatabaseException(final Integer userId, final Integer productId) {
        super();
        logger.info("Item Could not be added to the database for userId:" + userId + ", productId:" + productId);
    }
}