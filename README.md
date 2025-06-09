<p align="center">
  <a href="https://freedom-travel.kz/">
    <img src="media/img.png" width="330" height="200" alt="Freedom Travel">
  </a>
</p>

<h1 align="center">Проект по автоматизации тестирования для компании <a href="https://freedom-travel.kz/">Aviata</a></h1>

---

## ☑️ Содержание

- [Технологии и инструменты](#tools)
- [Реализованные проверки](#cases)
- [Сборка в Jenkins и запуск из терминала](#jenkins)
- [Allure-отчёт](#allure)
- [Уведомление в Telegram](#telegram)
- [Примеры видео выполнения тестов](#video)

---

<a id="tools"></a>
<a id="tools"></a>
<h2>🛠️ Технологии и инструменты</h2>

<table>
  <tr>
    <th><a href="https://www.oracle.com/java/" target="_blank">Java</a></th>
    <th><a href="https://www.jetbrains.com/idea/" target="_blank">IntelliJ IDEA</a></th>
    <th><a href="https://github.com/" target="_blank">GitHub</a></th>
    <th><a href="https://junit.org/junit5/" target="_blank">JUnit 5</a></th>
    <th><a href="https://gradle.org/" target="_blank">Gradle</a></th>
    <th><a href="https://selenide.org/" target="_blank">Selenide</a></th>
    <th><a href="https://aerokube.com/selenoid/" target="_blank">Selenoid</a></th>
    <th><a href="https://docs.qameta.io/allure/" target="_blank">Allure Report</a></th>
    <th><a href="https://www.jenkins.io/" target="_blank">Jenkins</a></th>
    <th><a href="https://telegram.org/" target="_blank">Telegram</a></th>
  </tr>
  <tr>
    <td align="center">
      <a href="https://www.oracle.com/java/" target="_blank">
        <img src="media/java-svgrepo-com.svg" width="50" height="50" alt="Java"/>
      </a>
    </td>
    <td align="center">
      <a href="https://www.jetbrains.com/idea/" target="_blank">
        <img src="media/intellij-idea-svgrepo-com.svg" width="50" height="50" alt="IDEA"/>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/" target="_blank">
        <img src="media/github-badge-svgrepo-com.svg" width="50" height="50" alt="GitHub"/>
      </a>
    </td>
    <td align="center">
      <a href="https://junit.org/junit5/" target="_blank">
        <img src="media/Junit5.svg" width="50" height="50" alt="JUnit 5"/>
      </a>
    </td>
    <td align="center">
      <a href="https://gradle.org/" target="_blank">
        <img src="media/gradle-svgrepo-com.svg" width="50" height="50" alt="Gradle"/>
      </a>
    </td>
    <td align="center">
      <a href="https://selenide.org/" target="_blank">
        <img src="media/Selenide.svg" width="50" height="50" alt="Selenide"/>
      </a>
    </td>
    <td align="center">
      <a href="https://aerokube.com/selenoid/" target="_blank">
        <img src="media/Selenoid.svg" width="50" height="50" alt="Selenoid"/>
      </a>
    </td>
    <td align="center">
      <a href="https://docs.qameta.io/allure/" target="_blank">
        <img src="media/Allure.svg" width="50" height="50" alt="Allure"/>
      </a>
    </td>
    <td align="center">
      <a href="https://www.jenkins.io/" target="_blank">
        <img src="media/Jenkins.svg" width="50" height="50" alt="Jenkins"/>
      </a>
    </td>
    <td align="center">
      <a href="https://telegram.org/" target="_blank">
        <img src="media/Telegram.svg" width="50" height="50" alt="Telegram"/>
      </a>
    </td>
  </tr>
</table>


<a id="cases"></a>
## ✅ Реализованные проверки

- Проверка наличия информационных блоков на главной странице.
- Проверка информации в футере главной страницы.
- Проверка кнопки "Куда Угодно" с Главной страницы.
- Проверка поиска авиаперелета на главной странице.
- Проверка "Меню" в хедере главной страницы на 2 языках.

---

<a id="jenkins"></a>
## 🧩 Сборка в [Jenkins](https://jenkins.autotests.cloud/job/035-t0l9-lesson-14/)

<p align="center">
  <img src="media/jenkinsEx.png" alt="Jenkins Build" width="950"/>
</p>

### ⚙️ Параметры сборки

- `browser` — браузер (по умолчанию `chrome`)
- `browserVersion` — версия браузера (по умолчанию `127.0`)
- `browserSize` — размер окна (по умолчанию `1920x1080`)
- `language` - язык уведомлений в телеграмм

### 🔧 Команды для запуска из терминала

**Локальный запуск**
```bash
gradle clean test
```

**Запуск с параметрами**
```bash
-Dbrowser=chrome -DbrowserSize=1920x1080 -DbrowserVersion=128.0
```

**Удалённый запуск через Jenkins**
```bash
clean test
-Dbrowser="${BROWSER}"
-DbrowserSize="${BROWSER_SIZE}"
-DbrowserVersion="${BROWSER_VERSION}"
```

---

<a id="allure"></a>
## 📊 Allure Report

<p align="center">
  <img src="media/allure.png" width="850" alt="Allure Overview Dashboard"/>
</p>

---

<a id="telegram"></a>
## 📩 Уведомления в Telegram

<p align="center">
  <img src="media/tgAllert.jpeg" width="550" alt="Telegram Alert"/>
</p>

## 📩 Подписаться на бота через QR код

<p align="center">
  <img src="media/tgSubscribe.jpeg" width="550" alt="Telegram Subscribe"/>
</p>

---

<a id="video"></a>
## 🎥 Пример видео выполнения тестов (Selenoid)

<p align="center">
  <img src="media/video1.gif" width="550" height="350" alt="Video Example"/>
</p>
