# Отчет по контрольной точке KT-1

Тема: система контроля версий Git

Выполнил: Kostyushin

Удаленный репозиторий: https://github.com/valer1q/Kostyushin

## Ход выполнения

Все действия выполнялись в консоли git.

### 1. Создание нового репозитория

Создана папка Kostyushin (по фамилии студента), в ней создан пустой репозиторий с основной веткой master. Для репозитория указаны имя и почта автора коммитов.

```
mkdir Kostyushin
cd Kostyushin
git init -b master
git config user.name "Kostyushin"
git config user.email "kostyushin.art@yandex.ru"
```

```
Initialized empty Git repository in /Users/v/Desktop/retake-AKP/KT-1/Kostyushin/.git/
```

### 2. Добавление файлов и первый коммит

В папку репозитория добавлены два файла.

readme.txt:

```
Контрольная точка KT-1 по системе контроля версий Git
Автор: Kostyushin
```

list.txt:

```
Строка 1
Строка 2
Строка 3
Строка 4
Строка 5
```

Проверка состояния репозитория:

```
git status
```

```
On branch master

No commits yet

Untracked files:
  (use "git add <file>..." to include in what will be committed)
	list.txt
	readme.txt
```

Файлы добавлены в индекс и зафиксированы:

```
git add readme.txt list.txt
git commit -m "Первый коммит: добавлены файлы readme.txt и list.txt"
```

```
[master (root-commit) 5dc03db] Первый коммит: добавлены файлы readme.txt и list.txt
 2 files changed, 7 insertions(+)
 create mode 100644 list.txt
 create mode 100644 readme.txt
```

### 3. Изменение файлов и фиксация нового состояния

В readme.txt добавлена строка «Версия: 2», в list.txt добавлена строка «Строка 6». Изменения видны в выводе команды git diff:

```
git diff
```

```
@@ -3,3 +3,4 @@
 Строка 3
 Строка 4
 Строка 5
+Строка 6

@@ -1,2 +1,3 @@
 Контрольная точка KT-1 по системе контроля версий Git
 Автор: Kostyushin
+Версия: 2
```

```
git add readme.txt list.txt
git commit -m "Изменены файлы readme.txt и list.txt"
```

```
[master 8276228] Изменены файлы readme.txt и list.txt
 2 files changed, 2 insertions(+)
```

### 4. Создание ветки branch1 и изменения в ней

Создана новая ветка branch1, выполнено переключение на нее:

```
git branch branch1
git checkout branch1
```

```
Switched to branch 'branch1'
```

В ветке branch1 выполнены изменения:

1. Добавлен новый файл branch1.txt с текстом «Этот файл создан в ветке branch1».
2. В файле list.txt удалена строка «Строка 2», изменена строка «Строка 3», добавлена строка «Строка 7 добавлена в ветке branch1».

```
git diff
```

```
@@ -1,6 +1,6 @@
 Строка 1
-Строка 2
-Строка 3
+Строка 3 изменена в ветке branch1
 Строка 4
 Строка 5
 Строка 6
+Строка 7 добавлена в ветке branch1
```

```
git add branch1.txt list.txt
git commit -m "branch1: добавлен файл branch1.txt, изменен list.txt"
```

```
[branch1 83256d5] branch1: добавлен файл branch1.txt, изменен list.txt
 2 files changed, 3 insertions(+), 2 deletions(-)
 create mode 100644 branch1.txt
```

### 5. Изменения в ветке master

Выполнено переключение на ветку master:

```
git checkout master
```

```
Switched to branch 'master'
```

В ветке master выполнены изменения:

1. Добавлен новый файл master.txt с текстом «Этот файл создан в ветке master».
2. В файле list.txt добавлена строка «Строка 0 добавлена в ветке master», изменена строка «Строка 3», удалена строка «Строка 5».
3. В файле readme.txt строка «Версия: 2» заменена на «Версия: 3».

```
git diff
```

```
@@ -1,6 +1,6 @@
+Строка 0 добавлена в ветке master
 Строка 1
 Строка 2
-Строка 3
+Строка 3 изменена в ветке master
 Строка 4
-Строка 5
 Строка 6

@@ -1,3 +1,3 @@
 Контрольная точка KT-1 по системе контроля версий Git
 Автор: Kostyushin
-Версия: 2
+Версия: 3
```

```
git add master.txt list.txt readme.txt
git commit -m "master: добавлен файл master.txt, изменены list.txt и readme.txt"
```

```
[master 711f60b] master: добавлен файл master.txt, изменены list.txt и readme.txt
 3 files changed, 4 insertions(+), 3 deletions(-)
 create mode 100644 master.txt
```

### 6. Слияние веток и разрешение конфликта

Находясь в ветке master, выполнено слияние с веткой branch1:

```
git merge branch1
```

```
Auto-merging list.txt
CONFLICT (content): Merge conflict in list.txt
Automatic merge failed; fix conflicts and then commit the result.
```

Возник конфликт, так как в обеих ветках была изменена одна и та же часть файла list.txt. Состояние репозитория:

```
git status
```

```
On branch master
You have unmerged paths.

Changes to be committed:
	new file:   branch1.txt

Unmerged paths:
  (use "git add <file>..." to mark resolution)
	both modified:   list.txt
```

Содержимое файла list.txt с отметками конфликта:

```
Строка 0 добавлена в ветке master
Строка 1
<<<<<<< HEAD
Строка 2
Строка 3 изменена в ветке master
=======
Строка 3 изменена в ветке branch1
>>>>>>> branch1
Строка 4
Строка 6
Строка 7 добавлена в ветке branch1
```

Между `<<<<<<< HEAD` и `=======` находится вариант из ветки master, между `=======` и `>>>>>>> branch1` находится вариант из ветки branch1. Остальные изменения (строка 0, удаление строки 5, строка 7) Git объединил автоматически.

Конфликт разрешен вручную: отметки удалены, строка 2 оставлена, строка 3 объединяет оба варианта. Итоговый файл list.txt:

```
Строка 0 добавлена в ветке master
Строка 1
Строка 2
Строка 3 изменена в ветках master и branch1
Строка 4
Строка 6
Строка 7 добавлена в ветке branch1
```

Разрешенный файл добавлен в индекс, слияние зафиксировано:

```
git add list.txt
git commit -m "Слияние ветки branch1 в master, конфликт в list.txt разрешен"
```

```
[master 325becb] Слияние ветки branch1 в master, конфликт в list.txt разрешен
```

### 7. Просмотр дерева изменений веток

```
git log --oneline --graph --all
```

```
*   325becb Слияние ветки branch1 в master, конфликт в list.txt разрешен
|\
| * 83256d5 branch1: добавлен файл branch1.txt, изменен list.txt
* | 711f60b master: добавлен файл master.txt, изменены list.txt и readme.txt
|/
* 8276228 Изменены файлы readme.txt и list.txt
* 5dc03db Первый коммит: добавлены файлы readme.txt и list.txt
```

На графе видно, что после второго коммита история разделилась на две ветки, а затем ветки были объединены коммитом слияния 325becb.

### 8. Откат изменений в ветке branch1

Выполнено переключение на ветку branch1:

```
git checkout branch1
```

**Откат незафиксированных изменений.** В файл branch1.txt добавлена строка «Ненужная строка». Git показывает, что файл изменен:

```
git status
```

```
On branch branch1
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
	modified:   branch1.txt
```

Изменение отменено командой git restore, файл вернулся к последнему зафиксированному состоянию:

```
git restore branch1.txt
git status
```

```
On branch branch1
nothing to commit, working tree clean
```

**Откат зафиксированных изменений.** В файл list.txt добавлена строка «Ошибочная строка», изменение зафиксировано:

```
git add list.txt
git commit -m "branch1: ошибочное изменение list.txt"
```

```
[branch1 66bd308] branch1: ошибочное изменение list.txt
 1 file changed, 1 insertion(+)
```

Для отмены этого коммита использована команда git revert. Она создает новый коммит, который отменяет изменения выбранного коммита. После запуска открывается редактор с готовым сообщением коммита, его нужно сохранить и закрыть.

```
git revert HEAD
```

```
[branch1 4d1edeb] Revert "branch1: ошибочное изменение list.txt"
 1 file changed, 1 deletion(-)
```

Строка «Ошибочная строка» удалена из list.txt. История ветки branch1:

```
git log --oneline
```

```
4d1edeb Revert "branch1: ошибочное изменение list.txt"
66bd308 branch1: ошибочное изменение list.txt
83256d5 branch1: добавлен файл branch1.txt, изменен list.txt
8276228 Изменены файлы readme.txt и list.txt
5dc03db Первый коммит: добавлены файлы readme.txt и list.txt
```

После этого выполнено возвращение в ветку master:

```
git checkout master
```

### 9. Создание удаленного репозитория

На github.com в аккаунте valer1q создан публичный репозиторий Kostyushin:

https://github.com/valer1q/Kostyushin

### 10. Отправка данных на удаленный репозиторий

Удаленный репозиторий подключен под именем origin:

```
git remote add origin https://github.com/valer1q/Kostyushin.git
git remote -v
```

```
origin	https://github.com/valer1q/Kostyushin.git (fetch)
origin	https://github.com/valer1q/Kostyushin.git (push)
```

На удаленный репозиторий отправлены обе ветки:

```
git push -u origin master
git push -u origin branch1
```

```
To https://github.com/valer1q/Kostyushin.git
 * [new branch]      master -> master
branch 'master' set up to track 'origin/master'.

To https://github.com/valer1q/Kostyushin.git
 * [new branch]      branch1 -> branch1
branch 'branch1' set up to track 'origin/branch1'.
```

### 11. Добавление участников проекта

Работа выполнялась в одиночку, поэтому других участников в репозиторий добавлять не потребовалось. При работе в подгруппе участники добавляются на странице репозитория: Settings → Collaborators → Add people. Там вводится логин участника на GitHub и отправляется приглашение. После принятия приглашения участник может отправлять изменения в репозиторий.

Шаги, которые по заданию выполняют прочие студенты подгруппы, выполнены мной из второй локальной копии репозитория в папке Kostyushin_copy. Эта копия играет роль второго участника, поэтому в сообщениях ее коммитов указано «Второй участник».

### 12. Получение данных из удаленного репозитория

Удаленный репозиторий клонирован во вторую папку Kostyushin_copy:

```
git clone https://github.com/valer1q/Kostyushin.git Kostyushin_copy
cd Kostyushin_copy
```

```
Cloning into 'Kostyushin_copy'...
```

В папке Kostyushin_copy появились все файлы проекта: branch1.txt, list.txt, master.txt, readme.txt.

### 13. Изменение полученных данных

Во второй копии в list.txt добавлена строка «Строка 8 добавлена вторым участником» и создан новый файл student2.txt:

```
git status
```

```
On branch master
Your branch is up to date with 'origin/master'.

Changes not staged for commit:
	modified:   list.txt

Untracked files:
	student2.txt
```

### 14. Фиксация и отправка изменений

Изменения во второй копии зафиксированы и отправлены на удаленный репозиторий:

```
git add list.txt student2.txt
git commit -m "Второй участник: изменен list.txt, добавлен student2.txt"
git push
```

```
[master 377b857] Второй участник: изменен list.txt, добавлен student2.txt
 2 files changed, 2 insertions(+)
 create mode 100644 student2.txt
To https://github.com/valer1q/Kostyushin.git
   325becb..377b857  master -> master
```

В основном репозитории Kostyushin сначала получены изменения из второй копии:

```
git pull
```

```
From https://github.com/valer1q/Kostyushin
   325becb..377b857  master     -> origin/master
Updating 325becb..377b857
Fast-forward
 list.txt     | 1 +
 student2.txt | 1 +
 2 files changed, 2 insertions(+)
 create mode 100644 student2.txt
```

Затем в readme.txt добавлена строка «Изменения отправлены всеми участниками», изменение зафиксировано и отправлено:

```
git add readme.txt
git commit -m "Kostyushin: изменен readme.txt после получения данных"
git push
```

```
[master faf3754] Kostyushin: изменен readme.txt после получения данных
 1 file changed, 1 insertion(+)
To https://github.com/valer1q/Kostyushin.git
   377b857..faf3754  master -> master
```

### 15. Получение данных из удаленного репозитория

Во второй копии Kostyushin_copy получены последние изменения:

```
git pull
```

```
From https://github.com/valer1q/Kostyushin
   377b857..faf3754  master     -> origin/master
Updating 377b857..faf3754
Fast-forward
 readme.txt | 1 +
 1 file changed, 1 insertion(+)
```

Содержимое readme.txt во второй копии после получения данных:

```
Контрольная точка KT-1 по системе контроля версий Git
Автор: Kostyushin
Версия: 3
Изменения отправлены всеми участниками
```

### 16. Просмотр истории изменений

```
git log --oneline --graph --all
```

```
* faf3754 Kostyushin: изменен readme.txt после получения данных
* 377b857 Второй участник: изменен list.txt, добавлен student2.txt
*   325becb Слияние ветки branch1 в master, конфликт в list.txt разрешен
|\
* | 711f60b master: добавлен файл master.txt, изменены list.txt и readme.txt
| | * 4d1edeb Revert "branch1: ошибочное изменение list.txt"
| | * 66bd308 branch1: ошибочное изменение list.txt
| |/
| * 83256d5 branch1: добавлен файл branch1.txt, изменен list.txt
|/
* 8276228 Изменены файлы readme.txt и list.txt
* 5dc03db Первый коммит: добавлены файлы readme.txt и list.txt
```

Подробная история последних коммитов:

```
git log -3
```

```
commit faf3754d84eede8d99fdd920402c4aca4fd3d85a
Author: Kostyushin <kostyushin.art@yandex.ru>
Date:   Fri Oct 9 00:52:47 2026 +0300

    Kostyushin: изменен readme.txt после получения данных

commit 377b857b71bc2685f998a68f4b7b95309b4b5939
Author: Kostyushin <kostyushin.art@yandex.ru>
Date:   Fri Oct 9 00:52:39 2026 +0300

    Второй участник: изменен list.txt, добавлен student2.txt

commit 325becbfd44f2a32fa214100a66fb46a52f0806b
Merge: 711f60b 83256d5
Author: Kostyushin <kostyushin.art@yandex.ru>
Date:   Fri Oct 9 00:52:11 2026 +0300

    Слияние ветки branch1 в master, конфликт в list.txt разрешен
```
