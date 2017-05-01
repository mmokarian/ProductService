package com.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT,
        reason = "Item Could not be deleted from the database")
public class ItemNotDeletedFromDatabaseException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(ItemNotDeletedFromDatabaseException.class);

    public ItemNotDeletedFromDatabaseException(final Integer userId, final Integer productId) {
        super();
        logger.info("Item Could not be deleted from the database for userId:" + userId + ", productId:" + productId);

    }
}