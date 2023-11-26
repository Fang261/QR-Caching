# Relatório Inicial - QR-Caching

## Proposta Inicial do Projeto <!-- omit in toc -->

- [Enquadramento do Projeto](#enquadramento-do-projeto)
  - [Ideia](#ideia)
  - [Contexto](#contexto)
  - [Objetivos](#objetivos)
  - [Público-Alvo](#Público-alvo)
- [Versão Preliminar com Guiões de Teste](#versão-preliminar-com-guiões-de-teste)
  - [Guião de Teste 1](#Guião-de-Teste-1)
  - [Guião de Teste 2](#Guião-de-Teste-2)
  - [Guião de Teste 3](#Guião-de-Teste-3)
- [Plano de trabalho](#plano-de-trabalho)
- [Requisitos funcionais e não funcionais](#requisitos-funcionais-e-não-funcionais)
  - [Requisitos funcionais](#requisitos-funcionais)
  - [Requisitos não funcionais](#requisitos-não-funcionais)
- [Modelo do domínio](#modelo-do-domínio)


## Enquadramento do Projeto

### Ideia

  A ideia do nosso projeto é criar uma aplicação de QR code caching, ou seja, os nossos utilizadores iram ter de andar pelo IADE em busca de todos os QR codes para que consigam completar a sua barra de progresso.

### Contexto

Este projeto está inserido num contexto tecnológico em que os QR codes se tornaram uma parte essencial da comunicação e interação. Os QR codes são uma forma eficaz de ligar o mundo físico e digital, e a sua utilização está cada vez mais comum em vários setores, incluindo a educação e o turismo. Baseando-nos no Geocaching, faremos com que a nossa aplicaçáo seja basicamente uma aventura digital, em que em vez de caixas físicas, teremos os nossos QR codes. É dentro deste contexto que a nossa aplicação encontra a sua relevância.

Queremos proporcionar aos utilizadores uma experiência única e envolvente ao explorarem o IADE em busca dos QR codes espalhados estrategicamente. Ao fazer isso, criaremos uma ligação mais profunda entre as pessoas e o ambiente do IADE, incentivando a exploração e a descoberta.

### Objetivos

  O objetivo central deste projeto é promover a inovação e a integração da tecnologia no nosso quotidiano, com foco na exploração do IADE. Almejamos desenvolver uma aplicação que permita aos utilizadores desfrutar da experiência ao máximo, tornando-a divertida e acessível a todos. A nossa meta é que tanto alunos como professores do IADE possam utilizar o QR-Caching sem dificuldades.
Cada utilizador terá a sua própria conta para uma experiência personalizada e poderão competir entre si para ver quem completa as suas buscas mais rapidamente. Os participantes poderão deixar memórias nos destinos visitados, incluindo fotos ou textos à sua escolha dentro da aplicação. Permitiremos aos utilizadores escolherem avatares para os seus perfis e mudarem os seus nomes de utilizador conforme desejarem. Forneceremos um mapa detalhado do campus do IADE para que os utilizadores possam navegar eficazmente na busca pelos QR codes, onde estes códigos estarão estrategicamente distribuídos pelo edifício e estarão claramente identificados no mapa da aplicação. 

### Público-Alvo

O nosso público-alvo abrange uma faixa etária diversificada, incluindo jovens estudantes universitários e professores com diferentes idades e experiências.  Este público está familiarizado com a tecnologia e utiliza dispositivos móveis no seu quotidiano, existe também uma inclinação para a competição amigável e o desejo de interagir socialmente com os colegas, tornando a aplicação QR-Caching uma opção atrativa.

-------------------------------------------------------------

## Versão Preliminar com Guiões de Teste

### Guião de Teste 1

O nosso caso "core" começa assim que o utilizador entra na aplicação, faz o seu login com o seu ID e Password e a partir daí tem total acesso à sua conta, onde vai ter o edifício do IADE em modelo 3D, um button que lhe dará acesso imediato à câmara, e o seu nome e foto de perfil que em sí também é um button. Clicando no modelo do IADE vai ser direcionado para uma página com a opção de escolha de todos os pisos do edifício e um outro button que serve para ser redirecionado para a página anterior. Escolhendo um piso vai ser direcionado para uma outra página onde vai ser apresentada a planta e o número do piso escolhido, com todas as localizações dos QR codes, um button para ser redirecionado para a página anterior, e outra vez outro butten para ser direcionado para a câmara. Uma vez na câmara, será encontrado só um button que redirecionará o utilizador para a página de onde veio, a inicial ou a da planta do piso. Aqui o utilizador vai dar scan ao QR code e asssim que o fizer vai para uma página onde vai poder deixar uma foto ou um texto e confirmar a sua tarefa, ou voltar a trás. 

![image](https://github.com/Fang261/QR-Caching/assets/116730433/18973af9-4a27-4ebb-94fa-4153ea865b75)


--------------------------------------------------------

### Guião de Teste 2

No segundo caso temos o sign in, em que quando um utilizador entra na aplicação e não tem uma conta, logo vai ter de carregar no button para se registar e será direcionado para outra página. Nesta página o utilizador encontrará quatro espaços de preenchimento obrigatório, Username, ID, Email e Password. Após preencher todos os espaços poderá se registar, e depois disto é direcionado de volta para a página de login.

![image](https://github.com/Fang261/QR-Caching/assets/116730433/221d79a1-e9bb-46d9-bc0f-398a5d71d7f4)


----------------------------------------------------------

### Guião de Teste 3

No terceiro caso, depois do logina e já na página inicial, se o utilizador carregar no icon do seu avatar será direcionado para o seu perfil, onde vai encontra o se Username, o seu avatar, a sua barra de progresso e um button para voltar para a página inicial. Se carregar no username poderá mudalo nessa mesma página, e se carregar no avatar irá ser direcionado para uma outra página onde terá muitos outros avatares que poderá escolher e um button para voltar para trás assim que escolher um novo ou não.

![image](https://github.com/Fang261/QR-Caching/assets/116730433/58e9bf36-2453-47b5-97bf-1b2afec00a3d)

----------------------------------------------------------

## Plano de Trabalho

O nosso plano de trabalho será apoiarmos-nos nas mockups e interfaces e ir desenvolvendo o nosso projeto, começando por desenvolver a parte visual da aplicação no Android Studios, e pensando em começar a criar a BD assim que tivermos o conhecimento.
Começar a ver também o que é preciso para termos a autorização para espalharmos os QR codes pelo IADE.

----------------------------------------------------------

## Requisitos funcionais e não funcionais

### Requisitos Funcionais

1-Login de Utilizadores:
Os utilizadores devem poder fazer login na aplicação usando um ID e senha.

2-Exploração do IADE:
Os utilizadores devem ter acesso a um modelo 3D do edifício do IADE, onde podem navegar pelos diferentes pisos.

3-Câmara Integrada:
A aplicação deve integrar uma câmara para a leitura dos QR codes.

4-Scaneamento de QR Codes:
Os utilizadores devem ser capazes de scanear os QR codes espalhados pelo edifício do IADE.

5-Registo de Memórias:
Após scanear um QR code, os utilizadores devem poder deixar uma foto ou um texto como memória associada àquele código.

6-Personalização de Perfil:
Os utilizadores devem poder personalizar o seu perfil, incluindo a escolha de avatares e a possibilidade de alterar o nome de utilizador.

7-Mapa Detalhado:
Fornecimento de um mapa detalhado do campus do IADE com a localização estratégica dos QR codes.

8-Barra de Progresso:
Os utilizadores devem ter uma barra de progresso que indica o seu progresso na busca pelos QR codes.

### Requisitos Não Funcionais

1-Desempenho:
A aplicação deve ter um tempo de resposta rápido, especialmente ao escanear QR codes.

2-Segurança:
Deve ser implementada segurança para proteger os dados dos utilizadores e prevenir ataques.

3-Compatibilidade:
A aplicação deve ser compatível com dispositivos móveis Android.

4-Usabilidade:
Deve ser desenvolvida uma interface de usuário intuitiva e amigável para facilitar a utilização por utilizadores de diferentes idades e níveis de experiência.

5-Conformidade com Regulamentos:
A aplicação deve estar em conformidade com regulamentos de privacidade e segurança de dados.

----------------------------------------------------------

## Modelo do domínio

1-Utilizador:
A entidade que representa os utilizadores da aplicação. Possui atributos como ID, Nome de Utilizador, Password e Avatar.

2-QR Code:
Representa os códigos QR espalhados pelo campus do IADE. Pode ter atributos como ID, Conteúdo (informação associada ao QR code) e Localização (piso e coordenadas).

3-Memória:
Representa as memórias deixadas pelos utilizadores após scanear um QR code. Pode incluir atributos como Foto, Texto e Data.

4-Edifício IADE:
Representa o edifício do IADE como um todo. Pode ter atributos como Pisos e Plantas.

----------------------------------------------------------
