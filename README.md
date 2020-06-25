 ## Назначение
 Проверка что все из перечисленных комбинаций возможны:
 - 3,2
 - 3,4
 - 7,2
 - 7,4

## тесты

TRY74 - исходный пример, выдает 7, 4
TRY34 - задержка между операциями в первом потоке.
TRY32 - задержка между потоками

TRY72 - эмуляция Reordering и задержки см. https://habr.com/ru/post/133981/
Тут очень интересно, jvm обеспечивает happens-before, но если прочитать:  
https://stackoverflow.com/questions/16213443/instruction-reordering-happens-before-relationship-in-java
То там есть такие предложения: From T1's perspective, an execution must be consistent with ...

Я понимаю это так, что поскольку первый процесс независим от второго то порядок не гарантируется.

Так же там есть такая фраза  With proper synchronization ... Что есть proper я не нашел 

Думаю это исследование может занять много часов)


##Volatile

Связи Reordering и Volatile не нашел. Написано A write to a volatile field happens before every subsequent read of that same field.
как я это понимаю Volatile int d=1 будет атомарной и не более, на соседней код это не влияет.