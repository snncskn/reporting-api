package com.financialhouse.util;

import javax.validation.constraints.NotNull;


/**
 * @author Sinan
 */
public class Utils {

    /**
     * is optional empty method
     *
     * @param value
     * @return
     */
    public static <T> boolean isEmpty(@NotNull final T value) {
        return value == null;
    }
}
