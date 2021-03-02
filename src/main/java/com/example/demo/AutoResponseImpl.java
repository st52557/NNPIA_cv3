package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AutoResponseImpl implements AutoResponse{

    private String response = "";


    @Override
    public String getResponse(String msg) {

        if(response.length() > 1){
            return response;
        }

        response = "Nyní bohužel nejsem k dispozici.";
        if(msg.length() >0){
            if(Character.isUpperCase(msg.charAt(0))){
                response = "Děkuji za zprávu, brzi se Vám ozvu. S přáním hezkého dne Lukáš Semorád.";
            }
        }

        return response;

    }

}
