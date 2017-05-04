INSERT INTO USUARIO (ID, USERNAME, NOME, SENHA, DATA_CRIACAO, USUARIO_CRIACAO) VALUES (1, 'admin', 'admin', '$2a$06$h5ve.bbIOBB6gw6OyMjCm.kPCV6oXEY8CyRTTlKUL2.kYk8zY0aOK', '2017-04-27', 'ADMIN');

INSERT INTO PAPEL (ID, NOME) VALUES (1, 'ROLE_USER');
INSERT INTO PAPEL (ID, NOME) VALUES (2, 'ROLE_ADMIN');
INSERT INTO PAPEL (ID, NOME) VALUES (3, 'ROLE_GUEST');

INSERT INTO USUARIO_PAPEL (USUARIO_ID, PAPEL_ID) VALUES (1, 1);
INSERT INTO USUARIO_PAPEL (USUARIO_ID, PAPEL_ID) VALUES (1, 1);
INSERT INTO USUARIO_PAPEL (USUARIO_ID, PAPEL_ID) VALUES (1, 3);

INSERT INTO GENERO(ID, NOME) VALUES (1, 'Ação');
INSERT INTO GENERO(ID, NOME) VALUES (2, 'Animação');
INSERT INTO GENERO(ID, NOME) VALUES (3, 'Aventura');
INSERT INTO GENERO(ID, NOME) VALUES (4, 'Comédia');
INSERT INTO GENERO(ID, NOME) VALUES (5, 'Ficção científica');
INSERT INTO GENERO(ID, NOME) VALUES (6, 'Guerra');
INSERT INTO GENERO(ID, NOME) VALUES (7, 'Romance');
INSERT INTO GENERO(ID, NOME) VALUES (8, 'Suspence');
INSERT INTO GENERO(ID, NOME) VALUES (9, 'Terror');

INSERT INTO FILME (ID, GENERO_ID, TITULO, URL_IMAGEM, DATA_LANCAMENTO, CLASSIFICACAO, IMDB_CLASSIFICACAO, DATA_CRIACAO, USUARIO_CRIACAO) VALUES (1, 1, 'Logan', 'http://www.foxfilm.com.br/custom-pages/logan-br/img/backgrounds_logan_outer.jpg', '2017-03-02', 5, 8.4, '2017-04-27', 'ADMIN');
INSERT INTO FILME (ID, GENERO_ID, TITULO, URL_IMAGEM, DATA_LANCAMENTO, CLASSIFICACAO, IMDB_CLASSIFICACAO, DATA_CRIACAO, USUARIO_CRIACAO) VALUES (2, 4, 'Meu Malvado Favorito 3', 'http://cdn.cinepop.com.br/2014/01/meumalvadofavorito3_1.jpg', '2017-03-02', 5, 5.4, '2017-04-27', 'ADMIN');
INSERT INTO FILME (ID, GENERO_ID, TITULO, URL_IMAGEM, DATA_LANCAMENTO, CLASSIFICACAO, IMDB_CLASSIFICACAO, DATA_CRIACAO, USUARIO_CRIACAO) VALUES (3, 2, 'Carros 3', 'http://br.web.img2.acsta.net/pictures/16/11/29/19/35/362561.jpg', '2017-06-15', 5, 6.4, '2017-04-27', 'ADMIN');
INSERT INTO FILME (ID, GENERO_ID, TITULO, URL_IMAGEM, DATA_LANCAMENTO, CLASSIFICACAO, IMDB_CLASSIFICACAO, DATA_CRIACAO, USUARIO_CRIACAO) VALUES (4, 8, 'Guerra Mundial Z 2', 'http://br.web.img3.acsta.net/pictures/15/06/16/10/47/237529.jpg', '2017-03-02', 5, 8.4, '2017-04-27', 'ADMIN');
INSERT INTO FILME (ID, GENERO_ID, TITULO, URL_IMAGEM, DATA_LANCAMENTO, CLASSIFICACAO, IMDB_CLASSIFICACAO, DATA_CRIACAO, USUARIO_CRIACAO) VALUES (5, 5, 'A Torre Negra', 'http://cinepop.com.br/wp-content/uploads/2016/07/torrenegra_2.jpg', '2017-03-02', 5, 5.4, '2017-04-27', 'ADMIN');
