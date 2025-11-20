CREATE SCHEMA futurify;

CREATE TABLE usuarios ( id BIGINT PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(100) NOT NULL, email VARCHAR(150) NOT NULL UNIQUE, area_atuacao VARCHAR(100), nivel_carreira VARCHAR(50), data_cadastro DATE NOT NULL );

CREATE TABLE trilhas ( id BIGINT PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(150) NOT NULL, descricao TEXT, nivel VARCHAR(50) NOT NULL, carga_horaria INT NOT NULL, foco_principal VARCHAR(100) );

CREATE TABLE competencias ( id BIGINT PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(100) NOT NULL, categoria VARCHAR(100), descricao TEXT );

CREATE TABLE trilha_competencia ( trilha_id BIGINT NOT NULL, competencia_id BIGINT NOT NULL, PRIMARY KEY (trilha_id, competencia_id), FOREIGN KEY (trilha_id) REFERENCES trilhas(id), FOREIGN KEY (competencia_id) REFERENCES competencias(id) );

CREATE TABLE matriculas ( id BIGINT PRIMARY KEY AUTO_INCREMENT, usuario_id BIGINT NOT NULL, trilha_id BIGINT NOT NULL, data_inscricao DATE NOT NULL, status VARCHAR(50) NOT NULL, FOREIGN KEY (usuario_id) REFERENCES usuarios(id), FOREIGN KEY (trilha_id) REFERENCES trilhas(id) );

CREATE TABLE ANALISE_CURRICULO (
  id_analise_curriculo     BIGINT AUTO_INCREMENT primary key,
  id_usuario               BIGINT NOT NULL,
  caminho_arquivo          VARCHAR(255) NOT NULL,
  txt_extraido             VARCHAR(500) NOT NULL,
  competencias_detectadas  VARCHAR(200) NOT NULL,
  experiencias_detectadas  VARCHAR(150),
  nivel_senioridade        VARCHAR(50) ,
  dt_analise               DATE DEFAULT (current_date) NOT NULL
);

ALTER TABLE ANALISE_CURRICULO
ADD CONSTRAINT FK_ANALISE_CURRICULO_USUARIO
FOREIGN KEY (id_usuario) REFERENCES usuarios(id);

CREATE TABLE CURRICULOS (
    id_curriculo                 BIGINT  auto_increment primary key,
    id_analise_curriculo         BIGINT  not null,
    id_usuario                   BIGINT  NOT NULL,
    titulo                       VARCHAR(200) NOT NULL,
    resumo_profissional          VARCHAR(500) not null,
    experiencias                 VARCHAR(150),
    educacao                     VARCHAR(150) not null,
    habilidades                  VARCHAR(200) not null,
    certificacoes                VARCHAR(200) not null,
    ultima_atualizacao           DATE DEFAULT (current_date) not null
);


ALTER TABLE CURRICULOS
ADD CONSTRAINT FK_CURRICULO_USUARIO
FOREIGN KEY (id_usuario) REFERENCES usuarios(id);

ALTER TABLE CURRICULOS
ADD CONSTRAINT FK_CURRICULO_ANALISE
FOREIGN KEY (id_analise_curriculo) REFERENCES ANALISE_CURRICULO(id_analise_curriculo);


CREATE TABLE HABILIDADES_EMERGENTES (
  id_habilidades_emergentes    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome                         VARCHAR(150) NOT NULL,
  categoria                    VARCHAR(100) NOT NULL,
importancia_futura             INT NOT NULL CHECK (importancia_futura BETWEEN 0 AND 10),
  descricao                    VARCHAR(250)
);

