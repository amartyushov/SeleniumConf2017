package io.mart.util;

import org.springframework.stereotype.Component;

@Component
public class ResultHolder<T> {

    private T result;

    public T storeResult(T result){
        this.result = result;
        return result;
    }

    public T getResult(){
        return result;
    }
}
