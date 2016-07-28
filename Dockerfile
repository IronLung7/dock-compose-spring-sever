FROM java:openjdk-7
EXPOSE 8080
ENV http_proxy http://proxy.houston.hpecorp.net:8080 
ENV https_proxy https://proxy.houston.hpecorp.net:8080
ADD . /targets
WORKDIR /targets
CMD java -jar test.jar