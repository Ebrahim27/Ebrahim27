package com.eki.ee.realbank.enums;


import com.eki.ee.realbank.exceptions.EkiDaoException;
import com.eki.ee.realbank.enums.ErrorCode ;
/**
 * @author mosio
 */
public class ObjectNotFoundException extends EkiDaoException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param errorCode
     */
    public ObjectNotFoundException() {
        super(ErrorCode.OBJECT_NOT_FOUND);
    }


    /**
     * @param message
     */
    public ObjectNotFoundException ( String message) {
        super(message, ErrorCode.OBJECT_NOT_FOUND);
    }
}
