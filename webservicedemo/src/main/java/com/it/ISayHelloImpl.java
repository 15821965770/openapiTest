package com.it;

import javax.jws.WebService;

/**
 * @author 徐老板
 * @date 2020/2/6   15:57
 */
@WebService
public class ISayHelloImpl implements ISayHello {
    @Override
    public String sayHello(String name) {
        System.out.println("call sayHello()");
        return "Hello,"+name+",I am jack";
    }
}
