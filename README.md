# 📘 MentorIA – Plataforma Inteligente de Evolução Profissional

## O MentorIA é uma plataforma desenvolvida para auxiliar usuários em sua evolução profissional por meio da análise inteligente de currículos, gerenciamento de competências e organização de trilhas de desenvolvimento personalizadas.

### A solução integra diversos módulos que permitem avaliar informações profissionais, identificar habilidades relevantes, recomendar aprendizados e acompanhar o progresso individual.

## 🧠 Objetivo do Projeto
### Profissionais muitas vezes não conseguem:
### Organizar suas informações de carreira;
### Identificar competências fortes e fracas;
### Saber quais habilidades emergentes devem aprender;
### Entender seu nível de senioridade no mercado;
### Ter um plano estruturado de desenvolvimento.

## O MentorIA resolve isso com:

- ✔ Gestão de usuários
- ✔ Cadastro e análise automática de currículos
- ✔ Detecção de competências
- ✔ Avaliação de experiências e senioridade
- ✔ Cadastro de habilidades emergentes
- ✔ Organização de trilhas de desenvolvimento
- ✔ Controle de progresso e matrículas

## 🛠 Tecnologias Utilizadas
### Linguagem
- Java SDK 24
### Framework
- Spring Boot 3.5.7

## Dependências Principais
- Spring Web
- Spring Data JPA
- Spring Validation
- MySQL Driver
- Lombok

## ▶️ Como Executar o Projeto
### Clonar o Repositorio
- git clone git@github.com:PeOliveira18/GlobalSolution-DDD.git

### Criar o banco MySql (comandos dentro de sql => schema.sql)

### Rodar o projeto
- mvn spring-boot:run

## Endpoints
### Usuarios
- GET – Listar todos
- GET http://localhost:8080/usuarios/all
- GET – Buscar por ID
- GET http://localhost:8080/usuarios/1

- POST – Criar usuário
- POST http://localhost:8080/usuarios
{
	"nome": "diego",
	"email": "diego.cabral@gmail.com",
	"area_atuacao": "Engenheiro de Dados",
	"nivel_carreira": "Pleno",
	"data_cadastro": "2025-11-11"
}

- PUT – Atualizar usuário
- PUT http://localhost:8080/usuarios/1

{
	"nome": "Diego",
	"email": "diego.cabral@gmail.com",
	"area_atuacao": "Engenheiro de Dados",
	"nivel_carreira": "Pleno",
	"data_cadastro": "2025-11-10"
}

- DELETE – Remover
- DELETE http://localhost:8080/usuarios/2

### 🛤 Trilhas (/trilhas)
- GET all
- http://localhost:8080/trilhas/all

- GET id
- http://localhost:8080/trilhas/1

- POST criar trilha
- POST http://localhost:8080/trilhas
{
	"nome": "Cibersegurança e Proteção de Dados",
	"descricao": "Proteja sistemas e dados em um mundo cada vez mais conectado",
	"nivel": "Avancado",
	"carga_horaria": 170,
	"foco_principal": "Cryptography"
}

- PUT atualizar
- PUT http://localhost:8080/trilhas/2

{
	"nome": "Cibersegurança e Proteção de Dados",
	"descricao": "Proteja sistemas e dados em um mundo cada vez mais conectado",
	"nivel": "Avançado",
	"carga_horaria": 170,
	"foco_principal": "Cryptography"
}

- DELETE
- DELETE http://localhost:8080/trilhas/2

### 🧩 Competências (/competencias)
- GET all
- http://localhost:8080/competencias/all

- GET id
- http://localhost:8080/competencias/1

- POST criar
- POST http://localhost:8080/competencias
{
	"nome": "Java",
	"categoria": "Back End",
	"descricao": "Linguagem de programacao orientada a objetos"
}

- PUT atualizar
- PUT http://localhost:8080/competencias/1

{
	"nome": "Angular",
	"categoria": "Front End",
	"descricao": "Framework desenvolvido pelo Google para desenvolvimento Front End."
}

- DELETE
- DELETE http://localhost:8080/competencias/2

### 🎓 Matrículas (/matriculas)
- GET all
- http://localhost:8080/matriculas/all

- GET id
- http://localhost:8080/matriculas/1

- POST criar
- POST http://localhost:8080/matriculas
{
	"usuario": {
		"id": 1
	},
	"trilha": {
		"id": 2
	},
	"data_inscricao": "2025-11-11",
	"status": "Ativa"
}

- PUT atualizar
- PUT http://localhost:8080/matriculas/2

{
	"usuario": {
		"id": 1
	},
	"trilha": {
		"id": 2
	},
	"data_inscricao": "2025-11-11",
	"status": "Pendente"
}

- DELETE
- DELETE http://localhost:8080/matriculas/2

### 📄 Currículos (/curriculos)
- GET all
http://localhost:8080/curriculos/all

- GET id
http://localhost:8080/curriculos/1

- POST criar
- POST http://localhost:8080/curriculos
{
	"analiseCurriculo": {
		"id": 2
	},
	"usuario": {
		"id": 3
	},
	"titulo": "Currículo Desenvolvedor",
	"resumo_profissional": "Resumo...",
	"experiencias": "Experiências...",
	"educacao": "Graduacao andamento",
	"habilidades": "Java;Angular;React",
	"certificacoes": "Certificado Angular Udemy",
	"ultima_atualizacao": "2025-11-09"
}

- PUT atualizar
- PUT http://localhost:8080/curriculos/2

- DELETE
- DELETE http://localhost:8080/curriculos/2

### 📊 Análises de Currículo (/analises_curriculo)
- GET all
- http://localhost:8080/analises_curriculo/all

- GET id
- http://localhost:8080/analises_curriculo/2

- POST criar
- POST http://localhost:8080/analises_curriculo
{
	"usuario": {
		"id": 4
	},
	"caminho_arquivo": "c:/docs/pedro.pdf",
	"txt_extraido": "texto...",
	"competencias_detectadas": "Java; Angular",
	"experiencias_detectadas": "CLT 2 anos",
	"nivel_senioridade": "Junior",
	"dt_analise": "2025-11-09"
}

- PUT atualizar
- PUT http://localhost:8080/analises_curriculo/4

{
	"usuario": {
		"id": 4
	},
	"caminho_arquivo": "c:/docs/debora.pdf",
	"txt_extraido": "texto...",
	"competencias_detectadas": "Java; React native",
	"experiencias_detectadas": "CLT 5 anos",
	"nivel_senioridade": "Senior",
	"dt_analise": "2025-11-09"
}

- DELETE
- DELETE http://localhost:8080/analises_curriculo/3

### 🚀 Habilidades Emergentes (/habilidades_emergentes)
- GET all
- http://localhost:8080/habilidades_emergentes/all

- GET id
- http://localhost:8080/habilidades_emergentes/1

- POST criar
- POST http://localhost:8080/habilidades_emergentes
{
	"nome": "Node.js",
	"categoria": "Back End",
	"importancia_futura": 8,
	"descricao": "Linguagem de programacao orientada a objetos"
}

- PUT atualizar
- PUT http://localhost:8080/habilidades_emergentes/1

{
	"id": 1,
	"nome": "Java",
	"categoria": "Back End",
	"importancia_futura": 8,
	"descricao": "Linguagem de programacao orientada a objetos"
}

- DELETE
- DELETE http://localhost:8080/habilidades_emergentes/2

