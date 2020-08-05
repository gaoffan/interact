package org.sacc.interact.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private Business business;

    public BusinessException(Business business){
        super(business.getMessage());
        this.business = business;
    }
    public BusinessException(Business business, Throwable throwable){
        super(business.getMessage(),throwable);
        this.business = business;
    }


}
