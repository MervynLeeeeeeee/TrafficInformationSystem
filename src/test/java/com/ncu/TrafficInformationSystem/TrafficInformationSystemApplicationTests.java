package com.ncu.TrafficInformationSystem;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrafficInformationSystemApplicationTests {

	@Test
	public void contextLoads() {
		JsonWebToken jsonWebToken = new JsonWebToken();
		System.out.println(jsonWebToken.createJsonWebToken());

	}

}
