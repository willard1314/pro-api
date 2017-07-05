package com.willard.javaee.spring.annotation;

import org.springframework.stereotype.Service;

@Service("service_t")
public class TencentCompanyImpl implements Company {
	@Override
	public void employPay() {
		// TODO Auto-generated method stub
		System.out.println("this is a qq");
	}

}
