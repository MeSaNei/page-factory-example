# language:ru
Функционал: Тестирование поиска Google

  @test
  Сценарий: Просмотр страницы кредитов
    Когда открывается страница "Главная страница"
    И пользователь (ищет) "макароны"
    Тогда открывается страница "Результаты поиска"
    И (количество результатов поиска должно быть) "10"