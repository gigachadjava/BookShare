insert into book (id, name_book, author_book, post_time)
values (1, 'Гордость и предубеждение', 'Джейн Остен', CURRENT_TIMESTAMP),
       (2, '«Властелин колец»', 'Джон Р. Р. Толкин', CURRENT_TIMESTAMP),
       (3, '451° по Фаренгейту', 'Рэй Брэдбери', CURRENT_TIMESTAMP),
       (5, 'Автостопом по Галактике', 'Дуглас Адамс', CURRENT_TIMESTAMP),
       (6, 'Ромео и Джульетта', 'Уильям Шекспир', CURRENT_TIMESTAMP),
       (7, 'Анна Каренина', 'Лев Толстой', CURRENT_TIMESTAMP),
       (8, 'Ребекка', 'Дафна Дюморье', CURRENT_TIMESTAMP),
       (9, 'Приключения Шерлока Холмса', 'Артур Конан Дойл', CURRENT_TIMESTAMP),
       (10, 'Старик и море', 'Эрнест Хемингуэй', CURRENT_TIMESTAMP)
on conflict (id) do nothing;