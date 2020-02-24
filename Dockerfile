FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
COPY glowroot /app/glowroot
ENTRYPOINT ["java","-javaagent:app/glowroot/glowroot.jar","-cp","app:app/lib/*","com.example.demo.DemoApplication"]