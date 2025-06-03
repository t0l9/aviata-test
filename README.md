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
## 🛠️ Технологии и инструменты

| Java | IntelliJ IDEA | GitHub | JUnit 5 | Gradle | Selenide | Selenoid | Allure Report | Jenkins | Telegram |
|:----:|:-------------:|:------:|:-------:|:------:|:--------:|:--------:|:-------------:|:-------:|:--------:|
| <img src="media/java-svgrepo-com.svg" width="50" height="50" alt="Java"/> | <img src="media/intellij-idea-svgrepo-com.svg" width="50" height="50" alt="IDEA"/> | <img src="media/github-badge-svgrepo-com.svg" width="50" height="50" alt="GitHub"/> | <img src="media/Junit5.svg" width="50" height="50" alt="JUnit 5"/> | <img src="media/gradle-svgrepo-com.svg" width="50" height="50" alt="Gradle"/> | <img src="media/Selenide.svg" width="50" height="50" alt="Selenide"/> | <img src="media/Selenoid.svg" width="50" height="50" alt="Selenoid"/> | <img src="media/Allure.svg" width="50" height="50" alt="Allure"/> | <img src="media/Jenkins.svg" width="50" height="50" alt="Jenkins"/> | <img src="media/Telegram.svg" width="50" height="50" alt="Telegram"/> |

---

<a id="cases"></a>
## ✅ Реализованные проверки

- Проверка количества кнопок в header меню на главной странице.
- Переход на страницу **Новости** и проверка заголовка "Новости".
- Переход на страницу **Контакты** и проверка заголовка "Контакты".
- Переход на страницу **Продукты** и проверка заголовка "Продукты".
- Переход на страницу **Награды** и проверка заголовка "Награды".

---

<a id="jenkins"></a>
## 🧩 Сборка в [Jenkins](https://jenkins.autotests.cloud/job/C34-Olejjka1337-unit14-UseTech/)

<p align="center">
  <img src="media/JenkinsBuild.jpg" alt="Jenkins Build" width="950"/>
</p>

### ⚙️ Параметры сборки

- `browser` — браузер (по умолчанию `chrome`)
- `browserVersion` — версия браузера (по умолчанию `127.0`)
- `browserSize` — размер окна (по умолчанию `1920x1080`)

### 🔧 Команды для запуска из терминала

**Локальный запуск**
```bash
gradle clean UseTech
