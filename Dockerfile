# build image
FROM openjdk:19-jdk-alpine AS builder-wf

WORKDIR /wf_api_img

COPY . /wf_api_img

RUN chmod +x ./gradlew

RUN ./gradlew clean build -x test


# final image
FROM openjdk:19-jdk-alpine

COPY --from=builder-wf /wf_api_img/build/libs/wf-0.0.1.jar app.jar

ENTRYPOINT exec java -jar app.jar