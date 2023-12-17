ALTER TABLE book
    ADD description VARCHAR(255);

ALTER TABLE book
    ADD image_url VARCHAR(255);

UPDATE book SET image_url='https://www.moscowbooks.ru/image/book/603/orig/i603574.jpg',
                description= '«Го́рдость и предубежде́ние» — роман Джейн Остин, опубликованный в 1813 году.'
            WHERE id=1;
UPDATE book SET image_url='https://cdn.img-gorod.ru/310x500/nomenclature/24/233/2423346.jpg',
                description= '«Властели́н коле́ц» (англ. The Lord of the Rings) — роман-эпопея английского писателя Дж. Р. Р. Толкина, одно из самых известных произведений жанра фэнтези.'
            WHERE id=2;
UPDATE book SET image_url='https://cv6.litres.ru/pub/c/cover_415/39507162.jpg',
                description= '«451 градус по Фаренгейту» — научно-фантастический роман-антиутопия Рэя Брэдбери, изданный в 1953 году.'
            WHERE id=3;
UPDATE book SET image_url='https://cv1.litres.ru/pub/c/cover_max1500/166312.jpg',
                description= '«Автосто́пом по гала́ктике» — серия юмористических научно-фантастических романов английского писателя Дугласа Адамса.'
            WHERE id=5;
UPDATE book SET image_url='https://cv2.litres.ru/pub/c/cover_max1500/17035422.jpg',
                description= '«Роме́о и Джулье́тта» — трагедия Уильяма Шекспира, рассказывающая о любви юноши и девушки из двух враждующих веронских родов — Монтекки и Капулетти.'
            WHERE id=6;
UPDATE book SET image_url='https://cdn.eksmo.ru/v2/430000000000145684/COVER/cover1__w600.jpg',
                description= '«А́нна Каре́нина» — роман Льва Толстого о трагической любви замужней дамы Анны Карениной и блестящего офицера Алексея Вронского на фоне счастливой семейной жизни дворян Константина Лёвина и Кити Щербацкой.'
            WHERE id=7;
UPDATE book SET image_url='https://cv9.litres.ru/pub/c/cover_max1500/136396.jpg',
                description= '«Ребекка» — роман английской писательницы Дафны Дюморье, опубликованный в 1938 году. Он сразу принёс автору популярность и считается одной из её лучших работ, а также одним из лучших детективных романов всех времен.'
            WHERE id=8;
UPDATE book SET image_url='https://cdn.eksmo.ru/v2/ITD000000001271188/COVER/cover1__w820.jpg',
                description= 'Эта книга - настоящее сокровище для любителей детективного жанра, викторианской Англии и истории в деталях!'
            WHERE id=9;
UPDATE book SET image_url='https://cv5.litres.ru/pub/c/cover_max1500/25290752.jpg',
                description= '«Стари́к и мо́ре» — повесть американского писателя Эрнеста Хемингуэя, написанная в Бимини и вышедшая в 1952 году. Последнее известное художественное произведение Хемингуэя, опубликованное при его жизни.'
            WHERE id=10;

insert into book (id, name_book, author_book, image_url, description, post_time)
values (4,
        'Последнее желание',
        'Анджей Сапковский',
        'https://cv2.litres.ru/pub/c/cover_max1500/19487529.jpg',
        '«Последнее желание» — сборник рассказов писателя Анджея Сапковского в жанре фэнтези, объединённых общим персонажем — ведьмаком Геральтом из Ривии. Это первое произведение из цикла «Ведьмак» как по хронологии, так и по времени написания.',
        CURRENT_TIMESTAMP)
on conflict (id) do nothing;