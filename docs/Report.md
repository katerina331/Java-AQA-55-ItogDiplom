# Отчет по тестированию
## Смирновой Екатерины Викторовны

Отчет приложения [aqa-shop.jar](artifacts/aqa-shop.jar) "Путешествие дня" по карте или в кредит.

## Краткое описание
В предложенном приложении тестировались функции отправки данных карты для приобретения путевки.
Реализовано тестирование методов приобретения по карте и в кредит.
Выполнены позитивные тесты со сверкой с базой данных и тесты на валидацию полей: номер карты, месяц карты, год карты, владелец карты и CVC/CVV карты.

## В плане автоматизации было заложено 94 тест-кейса по разным направлениям

| Вид тестирования карты | количество тестов покупки | количество тестов кредита |
|------------------------|:-------------------------:|:-------------------------:|
| Позитивные             |             2             |             2             |
|                        |
| Негативные             |            45             |            45             |
|                        |
| номер                  |             9             |             9             |
| месяц                  |             8             |             8             |
| год                    |            10             |            10             |
| владелец               |            11             |            11             |
| CVC/CVV                |             7             |             7             |
|                        |
| Всего                  |                           |            94             |

Все тесты были автоматизированны

## Результаты авто тестов
| Количество           | Всего |  %  |
|----------------------|:-----:|:---:|
| выполненных тестов   |  52   | 55  |
| проваленных тестов   |  42   | 45  |
| багов приложения     |  38   | 42  |
| фич приложения       |   4   |  3  |
| issues по тестам     |   5   | 83  |
| issues по приложению |   1   | 17  |

## Рекомендации по итогу авто тестирования
Результаты тестирования показали то, что оно не готово к релизу и требует исправления критичных багов.