package cn.bcf.dubbo.demo01.provider.service.impl;

import cn.bcf.dubbo.demo01.rely.service.DemoService;

public class ProviderServiceImpl implements DemoService {

    @Override
    public String sayHello(String str) {
        return str;
    }
}
