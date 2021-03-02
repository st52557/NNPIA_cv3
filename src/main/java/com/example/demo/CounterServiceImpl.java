package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CounterServiceImpl implements CounterService {

    private Integer counter = 0;

    @Override
    public void add(){
        this.counter++;
    }

    @Override
    public int getCounter() {
        return counter;
    }
}
