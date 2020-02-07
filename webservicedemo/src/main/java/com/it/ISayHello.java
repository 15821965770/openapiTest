package com.it;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author 徐老板
 * @date 2020/2/6   15:56
 */
@WebService
public interface ISayHello {
    @WebMethod
    String sayHello(String name);
}
