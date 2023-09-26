package com.example.demo;

import com.example.demo.webflux.app.openapi.Entry;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ContextConfiguration(classes = Entry.class)
class EntryTests {

	@Test
	void contextLoads() {
		assertThat(1 + 1).isEqualTo(2);
	}

}
