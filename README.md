# CatFact

Приложение, которое запрашивает случайне факты о котах и выводит их на главный экран приложения.

Описание:
1. Пользователь открывает приложение, выполняется  GET запрос https://catfact.ninja/fact запрос на сервер.
Полученный ответ добавляется в список о фактах, и этот список отображается на экране.
2. Если пользователь делает pull to refresh (свайп сверху вниз) выполняется запрос на сервер.
Результат запроса добавляется в список фактов о котах.
3. На главном экране также сделать кнопку, по нажатию на которую нужно очищать список фактов.

Стек:
Api: https://catfact.ninja
MVVM 
StateFlow
Jetpack Compose
Koin

