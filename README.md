<p align="center">
<a href="https://github.com/wikimedia/apps-android-wikipedia"> <img width=50%" src="media/wikipedia-logo.jpeg"> </a></h1>
<p align="center">

# <p align="center"> Проект по автоматизации тестовых сценариев для  мобильного приложения <a href="https://github.com/wikimedia/apps-android-wikipedia/">Wikipedia</a></h1> <p align="center">

## 🔨 Технологии и инструменты:
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img width="6%" title="IntelliJ IDEA" src="media/Intelij_IDEA.svg"></a>
<a href="https://www.java.com/"><img width="6%" title="Java" src="media/Java.svg"></a>
<a href="https://github.com/allure-framework"><img width="6%" title="Allure Report" src="media/Allure_Report.svg"></a>
<a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="media/AllureTestOps.svg"></a>
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="media/Gradle.svg"></a>
<a href="https://junit.org/junit5/"><img width="6%" title="JUnit5" src="media/JUnit5.svg"></a>
<a href="https://github.com/"><img width="6%" title="GitHub" src="media/GitHub (1).svg"></a>
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="media/Jenkins.svg"></a>
<a href="https://web.telegram.org/"><img width="6%" title="Telegram" src="media/Telegram (1).svg"></a>
<a href="https://www.atlassian.com/software/jira/"><img width="5%" title="Jira" src="media/Jira.svg"></a>
<a href="https://www.browserstack.com/"><img width="5%" title="BroserStack" src="media/Browserstack.svg"></a>
<a href="https://appium.io/"><img width="5%" title="Appium" src="media/Appium.svg"></a>
</p>

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворков <code>Rest Assured</code> и <code>JUnit 5</code>.
- В качестве сборщика был использован - <code>Gradle</code>.
- Использованы <code>Appium</code> и <code>BrowserStack</code> для локального/удаленного запуска приложения на мобильном устройстве.
- Для удаленного запуска реализована джоба в Jenkins с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота.
- Осуществлена интеграция с <code>Allure TestOps </code> и <code>Jira</code>.

## ![##46C3D3](https://placehold.co/15x15/46C3D3/46C3D3.png) Реализованные проверки
### При запуске локально (local) на эмуляторе:

- Проверка 4 страниц онбоардинга
- Проверка добавления языка на первом экране онбоардинга
- Проверка появления результатов поиска при выдаче
- Проверка открытия статьи, найденной через поиск
- Проверка добавления статьи в папку "Cохраненное"

### При запуске удаленно (remote) на Browserstack:

- Проверка появления результатов поиска при выдаче
- Проверка открытия статьи, найденной через поиск
- Проверка отображения карточки "In the news" на главной странице
- Проверка открытия статьи через карточку Featured Article на главной странице
  
## ![##46C3D3](https://placehold.co/15x15/46C3D3/46C3D3.png) Запуск автотестов

### Запуск локально (local) на эмуляторе:

```bash  
gradle clean local_test -DdeviceHost=local
```
> Внимание! Для запуска локальных тестов на компьютере должны быть установлены Android Studio, Appium Server и Appium

### Запуск удаленно (remote) на Browserstack:

```bash  
gradle clean remote_test -DdeviceHost=remote
```
> Для запуска необходимо нажать "Build now"


## ![##46C3D3](https://placehold.co/15x15/46C3D3/46C3D3.png) Сборка в [Jenkins](https://jenkins.autotests.cloud/job/021-Yulia_Malkova-mobile-project/)
<p align="center">
<img title="Jenkins Build" src="media/jenkins.png">
</p>

## ![##46C3D3](https://placehold.co/15x15/46C3D3/46C3D3.png) Пример [Allure-отчета](https://jenkins.autotests.cloud/job/021-Yulia_Malkova-mobile-project/allure/)
### Overview

<p align="center">
<img title="Allure Overview" src="media/allure-overview.png">
</p>

### Результат выполнения теста

<p align="center">
<img title="Test Results in Alure" src="media/allure-test.png">
</p>

## ![##46C3D3](https://placehold.co/15x15/46C3D3/46C3D3.png) Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/3778/dashboards)

Выполнена интеграция сборки <code>Jenkins</code> с <code>Allure TestOps</code>.
Результат выполнения автотестов отображается в <code>Allure TestOps</code>
На Dashboard в <code>Allure TestOps</code> отображена статистика пройденных тестов.

<p align="center">
<img title="Allure TestOps DashBoard" src="media/allure-testops-integration.png">
</p>

## ![##46C3D3](https://placehold.co/15x15/46C3D3/46C3D3.png) Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-950)

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>, в тикете отображается информация, какие тест-кейсы были написаны в рамках задачи и результат их прогона.

<p align="center">
<img title="Jira Task" src="media/jira-integration.png">
</p>

## ![##46C3D3](https://placehold.co/15x15/46C3D3/46C3D3.png) Уведомления в Telegram с использованием бота

После завершения сборки, бот созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/telegram-notification.png">
</p>
