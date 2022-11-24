# Rest1Rest2Batch

We have a Batch java program (normal maven project, no spring)
and 2 rest services built with spring. 

The batch makes an http call to R1, which makes an http call to R2. 
The batch wait for a response from R1, which waits for a response from R2. 

Maybe some db are required, but can comment out and do other things. 


One thing to notice is how we inject the RestTemplate bean.
You have to inject it with @Autowired in a Bean (yes, a Class automatically instantiated by Spring. If it is not, you can't inject the RestTemplate already configured).
Or, you can just pass it as parameter in a method of a Bean (for example, inside a RestController method).

