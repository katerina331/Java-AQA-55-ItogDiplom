# Дипломная работа профессии «Тестировщик ПО»
## Смирновой Екатерины Викторовны

В данном проекте реализован процесс автоматизации тестирования функционала приложения [aqa-shop.jar](artifacts/aqa-shop.jar) "Путешествие дня" по карте или в кредит.
Для тестирования будет использоваться язык программирования Java.
Окружение реализовано в IntelliJ IDEA и Docker, в котором будет запущены необходимые компоненты база данных MySQL или Postgres, заглушка для сервисов на Node, и Allure для создания отчетов.  

План расположен в файл [Plan.md](docs/Plan.md)

## Начало работы

Копию проекта можно скачать с GitHub [ссылка на проект](https://github.com/katerina331/Java-AQA-55-ItogDiplom).

В проекте есть [docker-compose.yml](docker-compose.yml) с настройками для запуска окружения в Docker. В котором прописаны все необходимые настройки для MySQL, Postgres и Node.

Для запуска приложения есть настройки [application.properties](application.properties). В которых прописаны связи с: сервисами; базой данных, логином, паролем; портом.

### Prerequisites

Для запуска проекта необходим установленные _Google Chrome, IntelliJ IDEA, Docker_ и _Git_. Их можно скачать по ссылкам: [Google Chrome](https://www.google.com/intl/ru_ru/chrome/), [IntelliJ IDEA](https://www.jetbrains.com/ru-ru/idea/download/), [Docker](https://www.docker.com/), [Git](https://git-scm.com/downloads).

### Установка и запуск
Устанавливаем Git.
Устанавливаем IntelliJ IDEA.
Устанавливаем Docker.

Запускаем IntelliJ IDEA. Загружаем скаченный проект [ссылка](https://github.com/katerina331/Java-AQA-55-ItogDiplom).

Редактируем настройки в [docker-compose.yml](docker-compose.yml), выбираем базу данных.

Запускаем окружение командой в терминале
```
docker-compose up
```

Запускаем приложение командой в терминале с базой MySQL
```
java -jar artifacts/aqa-shop.jar --spring.datasource.url=jdbc:mysql://localhost:3306/app
```
или PostgreSQL
```
java -jar artifacts/aqa-shop.jar --spring.datasource.url=jdbc:postgresql://localhost:5432/app
```
После запуска в браузере по ссылке [localhost:8080](http://localhost:8080) будет доступно приложение

![img.png](docs/img.png)

Все зависимости и настройки для тестирования прописаны в [build.gradle](build.gradle)

Запуск тестов с базой MySQL выполняется командой
```
./gradlew clean test -DsqlUrl='jdbc:mysql://localhost:3306/app'
```
Запуск тестов с базой PostgreSQL выполняется командой
```
./gradlew clean test -DsqlUrl='jdbc:postgresql://localhost:5432/app'
```


После прохождения тестов будет доступен отчет о тестировании Allure на локальном компьютере по команде.
```
./gradlew allureServe
```

#### Отчет о тестирование, изображения выполненного тестирования.
![Allure-1.png](docs%2FAllure-1.png)
![Allure-2.png](docs%2FAllure-2.png)

## Лицензия

Все приложения используют лицензии для домашнего использования. Нет необходимости приобретения дополнительного ПО.
