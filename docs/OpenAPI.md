# OpenAPI

Documenting api info

## Access

You can access docs info at these directories. 
http://localhost:8080/v3/api-docs
http://localhost:8080/webjars/swagger-ui/index.html#/

## Generation

Below code is unnecessary? 
Used to try some openapi generation content through
the build folder. 
```
sourceSets {
	main {
		java {
			srcDirs += ["build/generate-resources/main/src/main/java/com/example/springreactiveopenapicodegen"]
		}
	}
}
```
also this 
```groovy
	implementation files("build/generate-resources/main/src/main/java/com/example/springreactiveopenapicodegen")
```