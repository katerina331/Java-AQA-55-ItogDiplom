# Инструкция по настройке ReportPortal
## Подготовка

Сайт с инструкцией по установке ReportPortal [reportportal.io](https://reportportal.io/installation)

Для стабильной работы необходимо 5 гб оперативной памяти для контейнеров

## Настройка и первый запуск в docker
В проекте содержится настроенный docker-compose.yml для Windows. (На сайте можно скачать с настройками для Linux)

Для запуска ReportPortal в Docker используем команду
```
docker-compose -f docker-compose-ReportPortal.yml -p reportportal up -d --force-recreate
```
Где -f docker-compose-ReportPortal.yml определяет конкретный *.yml файл с настройками контейнеров.
Для скачивания некоторых контейнеров необходим VPN с не российской локализацией

После запуска всех контейнеров на локальной машине на порту: 8080 будет доступен ReportPortal
## Настраиваем проект и пользователя
Переходим в ReportPortal [localhost:8080](https://localhost:8080). Для запуска проекта необходим установленный браузер


Данные для входа админа:
 - логин
```
superadmin
```
 - пароль:
```
erebus
```
Заходим по логину-паролю, переходим в настройки пользователя и копируем от туда данные для подключения в файл [src/test/resources/reportportal.properties](../src/test/resources/reportportal.properties)
```
rp.endpoint = http://localhost:8080 //cсылка
rp.uuid = MpodF8YvlV_ullDg6vanVhRv21M //уникальный ключ
rp.launch = Test_Buy_Ticket //название группы тестов
rp.project = superadmin_personal //название проекта
```

## Настройка проекта
Все зависимости для ReportPortal прописаны в [build.gradle](../build.gradle). 
Также в папке resources содержатся дополнительные файлы настроек.

В проекте добавлены отдельные классы отвечающие за отправку настроенных логов тестов в ReportPortal