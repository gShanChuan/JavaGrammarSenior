package com.shanchuan.java3;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:
 *
 * 动态代理
 *
 * @Author: ShanChuan
 * @Data: 13:232020/8/10
 */

interface Human{
    String getBelief();
    void eat(String food);
}

//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "共产党";
    }

    @Override
    public void eat(String food) {
        System.out.println("eat:"+food);
    }
}

/*
动态代理：
问题1.如何根据加载到内存的被代理类 ，动态创建代理类及其对象
问题2.实现通过代理类的对象调用方法时，如何动态的调用被代理类的方法
 */

class ProxyFactory{
    //解决问题1
    public static Object getProxyInstance(Object obj){

        MyInvocationHandler handler = new MyInvocationHandler();
        handler.Bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}

class MyInvocationHandler implements java.lang.reflect.InvocationHandler{

    private Object obj;//需要
    public void Bind(Object obj){
        this.obj=obj;
    }
    //解决问题2，当我们通过代理类的对象，调用方法a时，就会自动调用如下的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnValue = method.invoke(obj, args);
        return returnValue;
    }
}
public class ProxyTest {

    public static void main(String[] args) {

        SuperMan superMan = new SuperMan();
        //代理类的对象
        Human proxyInstance = (Human)ProxyFactory.getProxyInstance(superMan);
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("饺子");

    }
}
