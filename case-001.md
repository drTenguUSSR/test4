# case-001

## info

TengedSedsvcEmu пет-проект реализующий интерфейс СЭДсервиса

[СЭД-сервис в рамках CMJ](https://sup.inttrust.ru:8446/prjdocs/master/specs/sedsvc/index.html)

[СЭДсервис как отдельный компонент](https://sup.inttrust.ru:8446/prjdocs/sedsvc/master/specs/sedsvc/index.html)

- - -
BEG text text text text text text text text text text text text text text
text text text text text text text text text text text text text text text
text text text text text text text text text text text text text text text
text text text text text text text text text text text text text text text
text text text text text text text text text text text text text text END
- - -

## ссылка относительная на репку

ref to other repo [ссылка на drTenguUSSR репку](../../../drTenguUSSR)

## картинки-1

![tengu portrait](images/tengu-port.png)
Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

<!-- 
## картинки-2

альтернатива img 200 (рабочая, картинка-ссылка на md-файла_с_картинкой)

<img alt="tengu-port" src="images/tengu-port.png"
width="200" height="200">
 -->
## картинки-3. выравнивание вправо

<img alt="tengu-port" align="right" src="images/tengu-port.png"
width="200" height="200">

Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

## картинки-4. выравнивание влево

<img alt="tengu-port" align="left" src="images/tengu-port.png"
width="200" height="200">

Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
<br>
<br>
<br>

## markdown bold

Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
<hr>

markdown**is**bold

markdown some **other** text

markdown some **other long text** text

markdown text is ***really important***.

## таблица-0

| left | center | right |
| :--------- | :---: | ----------- |
| Ячейка 1-1 | Ячейка 1-2  | Ячейка 1-3 mark-down-bold **other** text |
| Ячейка 2-1 | Ячейка 2-2  | Ячейка 2-3 SpringBoot + Kotlin [^1] |

SpringBoot + Kotlin [^1]

## таблица-1

<table>
  <caption>
    подпись таблицы
  </caption>
  <thead class="header">
    <tr>
      <th width="10%">№</th>
      <th width="45%">оригинальная реализация и проблемы</th>
      <th width="45%">emulator</th>
    </tr>
  </thead>
<tbody>
<tr><td align="right">1</td><td valign="top">
    Для отображения пользовательского интерфейса
    используется HTML 3.2/4.0 внутри JSP страницы
</td><td valign="top">
    Для отображения пользовательского интерфейса
    используется HTML5 + CSS3. применяются семантические теги и БЭМ
</td></tr>

<tr><td align="right">2</td><td valign="top">
    для определения url точки доступа применяется серверный компонент,
    написанный на java
    <ul>
    <li>пояснение-1: если URL точки входа определяется сервером, то
        корректный проброс порта через промежуточный сервер (proxy)
        становится затруднительным</li>
    <li>
    пояснение-2: если адрес определен не верно, то нет возможности его исправить
    </li>
</td><td valign="top">
    точка входа сервера определяется клиентом, исходя из текущего адреса
    страницы и имеется возможность ее редактирования
</td></tr>

<tr><td align="right">3</td><td valign="top">
        серверная сторона написана на Java 8 + Spring 4.1
    </td><td valign="top">
        перевод на Java JVM актуальной версии LTS (21?)
        + SpringBoot + Kotlin [^1]
</td></tr>

<tr><td>X</td><td valign="top">
    mark-col-X1 mark-col-X1 mark-col-X1 mark-col-X1 mark-col-X1 mark-col-X1
    mark-col-X1 mark-col-X1 mark-col-X1 mark-col-X1 mark-col-X1 mark-col-X1
    mark-col-X1 mark-col-X1 mark-col-X1 mark-col-X1 mark-col-X1 mark-col-X1
    mark-col-X1 mark-col-X1 mark-col-X1 mark-col-X1 mark-col-X1 mark-col-X1
</td><td valign="top">
    BErk-col-X2 mark-col-X2 mark-col-X2 mark-col-X2 mark-col-X2 mark-col-X2
    mark-col-X2 mark-col-X2 mark-col-X2 mark-col-X2 mark-col-X2 mark-col-X2
    mark-col-X2 mark-col-X2 mark-col-X2 mark-col-X2 mark-col-X2 mark-col-EN
    SpringBoot + Kotlin [^1]
</td></tr>

</tbody>
</table>

[^1]: план TengedSedsvcEmu, 2.x

## emoji and list

* smile, code - &#128512;
* man shrug - ¯\_(ツ)_/¯
* warn-exploded, code - &#128163;
* tengu, code - &#128122;
* head exploded, code - &#129327;
* anchor, char -⚓
* biohazard, char - ☣️, code - &#9763; &#x2623;

## color text

```diff
- text in red
+ text in green
! text in orange
# text in gray
@@ text in purple (and bold)@@
```

## preformatted text

стили не работают (как тег <style></style>> так и атрибут тега style="float: right;")

`````text
<title>
<textarea>
`````

[консольный клиент https://github.com/igorshubovych/markdownlint-cli](https://github.com/igorshubovych/markdownlint-cli)

````text
Usage: markdownlint [options] <files|directories|globs>

  MarkdownLint Command Line Interface

  Options:
    -V, --version                               output the version number
    -c, --config [configFile]                   configuration file (JSON, JSONC, JS, YAML, or TOML)
    -d, --dot                                   include files/folders with a dot (for example `.github`)
    -f, --fix                                   fix basic errors (does not work with STDIN)
    -i, --ignore [file|directory|glob]          file(s) to ignore/exclude (default: [])
    -j, --json                                  write issues in json format
    -o, --output [outputFile]                   write issues to file (no console)
    -p, --ignore-path [file]                    path to file with ignore pattern(s)
    -q, --quiet                                 do not write issues to STDOUT
    -r, --rules  [file|directory|glob|package]  include custom rule files (default: [])
    -s, --stdin                                 read from STDIN (does not work with files)
    --enable [rules...]                         Enable certain rules, e.g. --enable MD013 MD041 --
    --disable [rules...]                        Disable certain rules, e.g. --disable MD013 MD041 --
    -h, --help                                  display help for command
````

BErk-col-X2 mark-col-X2 mark-col-X2 mark-col-X2 mark-col-X2 mark-col-X2
mark-col-X2 mark-col-X2 mark-col-X2 mark-col-X2 mark-col-X2 mark-col-X2
mark-col-X2 mark-col-X2 mark-col-X2 mark-col-X2 mark-col-X2 mark-col-EN

### case-C

````markdown
preformatted 
        *text*
        **text2*
        ***text3***
````
