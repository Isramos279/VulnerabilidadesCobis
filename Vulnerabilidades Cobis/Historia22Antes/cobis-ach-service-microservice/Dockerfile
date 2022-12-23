FROM amazoncorretto@sha256:5cab8451adb8a919c6799ececf2503eca84c18b9b96df47f4549ea00dde90a65
RUN adduser --shell /sbin/nologin --disabled-password --no-create-home -S appuser -G wheel
EXPOSE 8079
ARG JAR_FILE=target/app.jar
ENV PROFILE onpremise
ADD ${JAR_FILE} app.jar
COPY ./entrypoint.sh /
RUN apk --no-cache --upgrade add curl && chmod +x /entrypoint.sh
HEALTHCHECK --interval=10s --timeout=3s --retries=3 \
  CMD curl -f http://localhost:8079/cobis/ach/actuator/health/ || exit 1
ENTRYPOINT ["sh", "/entrypoint.sh"]
