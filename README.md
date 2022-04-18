We can simulate a service to service invocation with a basic REST api
Both services are running on differnet ports - ServiceA on port 8090 and ServiceB on 8080

How To:
Clone the repo
start both the servers up 
url for ServiceA - http://localhost:8090/helloworld/serviceA
Stop running serviceB and observe serviceA call fails 

NOTE: Theres a docker file in both the folders to play around with as well
