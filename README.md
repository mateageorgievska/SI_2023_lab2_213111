# Matea Georgievska 213111
2. **Control flow graph**
![CFG_full](https://github.com/mateageorgievska/SI_2023_lab2_213111/assets/127094207/2d7fa837-cbfa-4779-8c70-3cfb49ce1d76)
3. Цикломатската комплексност на овој граф е 9. Истата може да се добие според бројот на региони или преку формулата P+1, каде P - број на предикатни јазли, во случајов 8, 8+1=9.
4.  Тест случаи според **Every Branch** критериумот
- Според Every Branch критериумот, тест случаите треба да ги опфаќаат двата можни исходи (точно и неточно) од сите јазли за одлука во кодот.
- Како input треба да се внесе еден user и листа на users, во случајов листа од 2 корисници.
- Тест случаи со кои ќе се опфатат сите можни исходи се:
(user, user[0], user[1])

(1) null, null, null, null
   user0, username0, user0@gmail.com, user@
   user1, username1, user1@gmail.com, P@ss

(2) user, username0, user0gmail, user r
   user, username0, user0@gmail.com, user r
   user1, username1, user1@gmail, P@ss

(3) user, username, user@gmail.com, P@ssword!
   user0, username0, user0@gmail.com, user@
   user1, username1, user1@gmail.com, P@ss

(4) user, username, user@gmail.com, P@ssword!
   user0, username, user@gmail.com, user@
   user1, username1, user1@gmail.com, P@ss
   
- Во табелата подолу, во првата колона се преставени сите можни исходи од разгранувањата (прво точниот, па неточниот исход соодветно), а во секоја колона има по еден test case, за кој подолу во истата колона со „*“ е означено кои случаи ги опфаќа. Со овие 4 тест случаи, се опфатени барем по еднаш сите исходи, што го задоволува Every Branch критериумот.


| Arcs       | Test case (1) | Test case (2) | Test case (3) | Test case (4) |
| ---------- | ------------- | ------------- | ------------- | ------------- |
| 1-2        | *             |               |               |               |
| 1-3        |               | *             | *             | *             |
| 3-4        | *             |               |               |               |
| 3-5        |               | *             | *             | *             |
| 6-7        |               |               | *             | *             |
| 6-16,17,18 |               | *             |               |               |
| 11-12      |               |               |               | *             |
| 11-13      |               |               | *             |               |
| 13-14      |               |               |               | *             |
| 13-15      |               |               | *             |               |
| 19-20      |               | *             |               |               |
| 19-21      |               |               | *             | *             |
| 21-22      |               |               | *             | *             |
| 21-27      |               | *             |               |               |
| 24-25      |               |               | *             | *             |
| 24-26      |               | *             |               |               |

4. **Multiple condition метода** - со оваа метода се евалуираат сите јазли на одлука, во двете насоки (точно и неточно) со тоа што ги опфаќа сите можни комбинации на изразот.
За да ги опфатиме сите комбинации за условот if(user==null||user.getPassword()==null||user.getEmail()==null), потребно е да ги напишеме сите вредности (true/false) за секој израз посебно. Бидејќи имаме логичко ИЛИ (or) оператор, за условот да е неточен потребно е сите изрази да се неточни, а соодветно да е точен, ни е потребен само еден точен израз, додека пак за другите може било која вредност да биде (Х).

| Possible combination     | Test case                       | Branch        | 
| ------------------------ | ------------------------------- | ------------- |
| TXX                      | null, P@ssword!, user@gmail.com | 1-2           |
| FTX                      | user, null, user@gmail.com      | 1-2           |
| FFT                      | user, P@ssword!, null           | 1-2           |
| FFF                      | user, P@ssword!, user@gmail.com | 1-3           |
