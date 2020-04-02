FROM tomee


COPY target/jakartaeefrontend.war /usr/local/tomee/webapps/jakartaeefrontend.war
EXPOSE 8080
EXPOSE 8081
EXPOSE 9595
CMD ["catalina.sh", "run"]
