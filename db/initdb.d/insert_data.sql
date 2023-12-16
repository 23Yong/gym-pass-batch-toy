INSERT INTO package (package_name, gym_seq, count, period, created_at)
VALUES ('Starter PT 10회', 1, 10, 60, '2023-12-16 00:00:00'),
       ('Starter PT 20회', 1, 20, 120, '2023-12-16 00:00:00'),
       ('Starter PT 30회', 1, 30, 180, '2023-12-16 00:00:00'),
       ('무료 이벤트 필라테스 1회', 2, 1, NULL, '2023-12-16 00:00:00'),
       ('바디 챌린지 PT 4주', 3, NULL, 28, '2023-12-16 00:00:00'),
       ('바디 챌린지 PT 8주', 3, NULL, 48, '2023-12-16 00:00:00'),
       ('인바디 상담', 4, NULL, NULL, '2023-12-16 00:00:00'),
       ('헬스 1개월', 5, NULL, 30, '2023-12-16 00:00:00'),
       ('헬스 3개월', 5, NULL, 90, '2023-12-16 00:00:00'),
       ('헬스 6개월', 5, NULL, 180, '2023-12-16 00:00:00');

INSERT INTO `user` (user_id, user_name, status, phone, meta, created_at)
VALUES ('A1000000', '우영우', 'ACTIVE', '01011112222', NULL, '2022-08-01 00:00:00'),
       ('A1000001', '최수연', 'ACTIVE', '01033334444', NULL, '2022-08-01 00:00:00'),
       ('A1000002', '이준호', 'INACTIVE', '01055556666', NULL, '2022-08-01 00:00:00'),
       ('B1000010', '권민우', 'ACTIVE', '01077778888', NULL, '2022-08-01 00:00:00'),
       ('B1000011', '동그라미', 'INACTIVE', '01088889999', NULL, '2022-08-01 00:00:00'),
       ('B2000000', '한선영', 'ACTIVE', '01099990000', NULL, '2022-08-01 00:00:00'),
       ('B2000001', '태수미', 'ACTIVE', '01000001111', NULL, '2022-08-01 00:00:00');

INSERT INTO `gym` (gym_name)
VALUES ('강남점'),
       ('신촌점'),
       ('홍대점'),
       ('부산점'),
       ('대구점'),
       ('광주점'),
       ('대전점'),
       ('강릉점'),
       ('속초점'),
       ('제주점');