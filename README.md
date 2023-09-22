# Reactive FSM

A spring boot state machine to test reactive programming. 


## Note on building

This project depends on lombok; specifically stuff that's generated under the build folder. As such, before you can run this locally with gradle you'll likely need to build the project successfully before it'll run, and make sure those gen files are there. 

IMPORTANT: To run this, if you use clean, it'll remove the
`generate-resources` build folder which is where these files
that this depends on are generated. To run this project
you need to do `clean -> openApiGenerate -> build`. 
.dependsOn may fix this, but not 100% sure. 

## More debug notes

Needed this constructor to get things working. Did not like just
passing in WebProperties.Resources initially. 
```java
public class GlobalExceptionHandler extends AbstractErrorWebExceptionHandler {
	/*
      Create a new {@code AbstractErrorWebExceptionHandler}.
   
      @param errorAttributes    the error attributes
   * @param serverCodecConfigurer          the resources configuration properties
   * @param applicationContext the application context
   * @since 2.4.0
   */
	public GlobalExceptionHandler(ErrorAttributes errorAttributes,
	                              ApplicationContext applicationContext,
	                              @NotNull ServerCodecConfigurer serverCodecConfigurer) {
		super(errorAttributes, new WebProperties.Resources(), applicationContext);
		super.setMessageWriters(serverCodecConfigurer.getWriters());
		super.setMessageReaders(serverCodecConfigurer.getReaders());
	}
}
```

## DB errors

`  No database found to handle r2dbc:postgresql://localhost:5432/spring_reactive`

i don't remember. but when it complained about permission denied that was a matter of changing to postgres instead of ajsnow as the user. 

# does not exist, not found, no valid role, etc

e.g. 
`Unable to obtain connection from database 
(jdbc:postgresql://localhost:5432/test_db;)
for user 'postgres': FATAL: database "test_db;" does not exist`

It's because I put a comma in the url, I spent way too long trying to figure this out. 
I can feel the few remaining brain cells I have left withering away as I write this