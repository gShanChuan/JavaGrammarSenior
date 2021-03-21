package com.shanchuan.java3;

/**
 * @Description:
 * @Author: ShanChuan
 * @Data: 13:172020/8/10
 */

interface clothFactory{
    void produceCloth();
}

//代理类
class proxyClothFactory implements clothFactory{

    private clothFactory factory;

    public proxyClothFactory(clothFactory factory){
        this.factory=factory;
    }
    @Override
    public void produceCloth() {
        System.out.println("代理工厂准备就绪");
        factory.produceCloth();
    }
}
//被代理类
class NikeClothFactory implements clothFactory{

    @Override
    public void produceCloth() {
        System.out.println("nike工厂生产服装");
    }
}
public class StaticProxyTest {
    public static void main(String[] args) {
        //被代理类
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        //代理类
        proxyClothFactory p = new proxyClothFactory(nikeClothFactory);
        p.produceCloth();
    }
}
