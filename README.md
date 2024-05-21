# Задание 1

## Написать функцию, создающую резервную копию всех файлов в директории во вновь созданную папку ./backup

# Задание 2

## Доработайте класс Tree и метод print который мы разработали на семинаре. Ваш метод должен распечатать полноценное дерево директорий и файлов относительно корневой директории.

Revised **print()** of class **Tree**. Added the following condition to the loop:

                if (files[i].length() > 0){
                    File[] files_f = files[i].listFiles();
                    for (int j = 0; j < files_f.length-1; j++) {
                        System.out.println(indent+"│ ├─"+ files_f[j].getName());
                    }
                    System.out.println(indent+"│ └─"+ files_f[files_f.length-1].getName());
                }
            }
        }
