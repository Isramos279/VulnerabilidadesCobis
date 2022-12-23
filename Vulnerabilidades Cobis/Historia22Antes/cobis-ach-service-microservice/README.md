#Llamar la microservicio with I18N

* Enviar petitición por curl con el Lenguage Español-Ecuador

```bash
curl -i -H "Accept-Language: ES-EC" http://localhost:8087/cobis/core/admin/catalogs/findByName?name=ad_dia_semana
```
* Enviar petición sin lenguage para que tome el por default. 
```bash
curl -i http://localhost:8087/cobis/core/admin/catalogs/findByName?name=ad_dia_semana
```

* Setear un Locale por default a nivel de la JVM
```bash
java -noverify -Duser.country=EC -Duser.language=es -Dspring.profiles.active=$PROFILE $JAVA_OPTS -jar app.jar
```

* Shudown when actuator is Enabled
``bash
curl -X POST  http://localhost:8087/cobis/core/admin/actuator/shutdown
``

* Health check
CMD-SHELL, curl -f http://localhost:8087/cobis/core/admin/actuator/health/ || exit 1
