package com.it;

/**
 * @author 徐老板
 * @date 2020/2/6   16:10
 */
public class Demo {
    public static void main(String[] args) {
        //三层封装 ISayHello ->ISayHelloImpl 这个是服务端 然后转到cli端ISayHelloImpl变成了接口 实现类变成了ISayHelloService
        //调用方法的时候又变成了ISayHelloService 的一个封装类ISayHelloImplPort 去调用里面的方法 底层的东西真的麻烦
        ISayHelloImplService service=new ISayHelloImplService();
        ISayHelloImpl iSayHelloImplPort = service.getISayHelloImplPort();
        System.out.println(iSayHelloImplPort.sayHello("张三"));

    }
}
