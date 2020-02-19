package com.financialhouse.util;

import javax.validation.constraints.NotNull;
import java.util.Optional;


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
        if (value == null) {
            return true;
        } else {
            return false;
        }
    }
}
