package com.eki.ee.realbank.exceptions;

import com.eki.ee.realbank.enums.ErrorCode;

/**
 * @author mosio
 */
public class SaveObjectException extends EkiDaoException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param errorCode
     */
    public SaveObjectException () {
        super(ErrorCode.SAVE_ERROR);
    }
}
