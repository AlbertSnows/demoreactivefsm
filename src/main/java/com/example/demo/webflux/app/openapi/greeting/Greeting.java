package com.example.demo.webflux.app.openapi.greeting;


//import lombok.Getter;

//@Getter
public class Greeting {

	private String message;

	public Greeting() {
	}

	public Greeting(String message) {
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Greeting{" +
						"message='" + message + '\'' +
						'}';
	}
}