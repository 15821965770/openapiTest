package com.it;

import javax.xml.ws.Endpoint;

/**
 * @author 徐老板
 * @date 2020/2/6   15:59
 */
public class Bootstrap {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8888/vip/hello",new ISayHelloImpl() );
        System.out.println("publish success");
    }
}
