package com.red.util.exception;

import com.red.util.Messages;

/**
 * Random Wrapper Exception.
 *
 * @author Alexander Sokolov
 * @since 2020-05-23
 */
public class RandomWrapperException extends IllegalArgumentException {

    public RandomWrapperException(Messages message) {
        super(message.toString());
    }

    public RandomWrapperException() {
    }

    @Override
    public String toString() {
        return Messages.DATA_INPUT_ERROR + super.getMessage();
    }
}
