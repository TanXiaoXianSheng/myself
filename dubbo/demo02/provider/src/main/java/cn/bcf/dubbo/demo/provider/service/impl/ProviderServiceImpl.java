package cn.bcf.dubbo.demo.provider.service.impl;

import cn.bcf.dubbo.demo.rely.service.DemoService;

public class ProviderServiceImpl implements DemoService {

    @Override
    public String sayHello(String str) {
        return str;
    }
}
