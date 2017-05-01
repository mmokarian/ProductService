package com.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,
        reason = "no items could be retrieved from the repository for provided userId")
public class NoMatchedItemsForUserException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(NoMatchedItemsForUserException.class);

    public NoMatchedItemsForUserException(final Integer userId) {
        super();
        logger.info("no items could be retrieved from the repository for the user id:" + userId);

    }
}