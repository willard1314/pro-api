package com.willard.javaee.spring.annotation;

import org.springframework.stereotype.Service;

@Service("service_a")
public class AliCompanyImpl implements Company {

	@Override
	public void employPay() {
		System.out.println("ali salary is million");
	}
}
