insert into usuario (id, username, nome, senha, data_criacao, usuario_criacao) values (1, 'admin', 'admin', '$2a$06$h5ve.bbIOBB6gw6OyMjCm.kPCV6oXEY8CyRTTlKUL2.kYk8zY0aOK', '2017-04-27', 'admin');

insert into papel (id, nome) values (1, 'ROLE_USER');
insert into papel (id, nome) values (2, 'ROLE_ADMIN');
insert into papel (id, nome) values (3, 'ROLE_GUEST');

insert into usuario_papel (usuario_id, papel_id) values (1, 1);
insert into usuario_papel (usuario_id, papel_id) values (1, 1);
insert into usuario_papel (usuario_id, papel_id) values (1, 3);

insert into genero(id, nome) values (1, 'Ação');
insert into genero(id, nome) values (2, 'Animação');
insert into genero(id, nome) values (3, 'Aventura');
insert into genero(id, nome) values (4, 'Comédia');
insert into genero(id, nome) values (5, 'Ficção científica');
insert into genero(id, nome) values (6, 'Guerra');
insert into genero(id, nome) values (7, 'Romance');
insert into genero(id, nome) values (8, 'Suspence');
insert into genero(id, nome) values (9, 'Terror');

insert into filme (id, genero_id, titulo, url_imagem, data_lancamento, classificacao, imdb_classificacao, data_criacao, usuario_criacao) values (1, 1, 'Logan', 'http://www.foxfilm.com.br/custom-pages/logan-br/img/backgrounds_logan_outer.jpg', '2017-03-02', 5, 8.4, '2017-04-27', 'admin');
insert into filme (id, genero_id, titulo, url_imagem, data_lancamento, classificacao, imdb_classificacao, data_criacao, usuario_criacao) values (2, 4, 'Meu malvado favorito 3', 'http://cdn.cinepop.com.br/2014/01/meumalvadofavorito3_1.jpg', '2017-03-02', 5, 5.4, '2017-04-27', 'admin');
insert into filme (id, genero_id, titulo, url_imagem, data_lancamento, classificacao, imdb_classificacao, data_criacao, usuario_criacao) values (3, 2, 'Carros 3', 'http://br.web.img2.acsta.net/pictures/16/11/29/19/35/362561.jpg', '2017-06-15', 5, 6.4, '2017-04-27', 'admin');
insert into filme (id, genero_id, titulo, url_imagem, data_lancamento, classificacao, imdb_classificacao, data_criacao, usuario_criacao) values (4, 8, 'Guerra mundial z 2', 'http://br.web.img3.acsta.net/pictures/15/06/16/10/47/237529.jpg', '2017-03-02', 5, 8.4, '2017-04-27', 'admin');
insert into filme (id, genero_id, titulo, url_imagem, data_lancamento, classificacao, imdb_classificacao, data_criacao, usuario_criacao) values (5, 5, 'A torre negra', 'http://cinepop.com.br/wp-content/uploads/2016/07/torrenegra_2.jpg', '2017-03-02', 5, 5.4, '2017-04-27', 'admin');
