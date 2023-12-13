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

  A ideia do nosso projeto é criar uma aplicação de QR code caching, ou seja, os nossos utilizadores iram ter de Lisboa e diversos Eventos para que consigam adquirir as suas conquistas.

### Contexto

Este projeto está inserido num contexto tecnológico em que os QR codes se tornaram uma parte essencial da comunicação e interação. Os QR codes são uma forma eficaz de ligar o mundo físico e digital, e a sua utilização está cada vez mais comum em vários setores, incluindo a educação e o turismo. Baseando-nos no Geocaching, faremos com que a nossa aplicaçáo seja basicamente uma aventura digital, em que em vez de caixas físicas, teremos os nossos QR codes. É dentro deste contexto que a nossa aplicação encontra a sua relevância.

Queremos proporcionar aos utilizadores uma experiência única e envolvente ao explorarem o IADE em busca dos QR codes espalhados estrategicamente. Ao fazer isso, criaremos uma ligação mais profunda entre as pessoas, incentivando a exploração e a descoberta.

### Objetivos

  O objetivo central deste projeto é promover a inovação e a integração da tecnologia no nosso quotidiano. Almejamos desenvolver uma aplicação que permita aos utilizadores desfrutar da experiência ao máximo, tornando-a divertida e acessível a todos. A nossa meta é que qualquer pessoa possa utilizar o QR-Caching sem dificuldades.
A nossa aplicação será basicamente um jogo social, onde os utilizadores tanto puderam andar em busca dos qrcodes que existem por lisboa, e são permanentes; ou ingressar em eventos e conseguir todo o tipo de conquistas.
Ao colectar um qrcode, tanto em eventos ou não, o objetive é o utilizador deixar uma memória em foto, texto ou ambos.

### Público-Alvo

A nossa ideia é que o QR-Caching seja utilizado por toda a gente, sem restrições.

-------------------------------------------------------------

## Versão Preliminar com Guiões de Teste

### Guião de Teste 1

![image](https://github.com/Fang261/QR-Caching/assets/116730433/62110412-3945-45cd-8de5-3402a28ac74f)

----------------------------------------------------------

## Plano de Trabalho

O nosso plano de trabalho será apoiarmos-nos nas mockups e interfaces e ir desenvolvendo o nosso projeto, começando por desenvolver a parte visual da aplicação no Android Studios, e pensando em começar a criar a BD assim que tivermos o conhecimento.
Começar a ver também o que é preciso para termos a autorização para espalharmos os QR codes pelo IADE.

----------------------------------------------------------

## Requisitos funcionais e não funcionais

### Requisitos Funcionais

1-Login de Utilizadores:
Os utilizadores devem poder fazer login na aplicação usando um email e senha.

2-Câmara Integrada:
A aplicação deve integrar uma câmara para a leitura dos QR codes.

3-Scaneamento de QR Codes:
Os utilizadores devem ser capazes de scanear os QR codes.

4-Registo de Memórias:
Após scanear um QR code, os utilizadores devem poder deixar uma foto ou um texto como memória associada àquele código.

5-Personalização de Perfil:
Os utilizadores devem poder personalizar o seu perfil, incluindo a mudança da foto de perfil e a possibilidade de alterar o nome de utilizador.

6-Barra de Progresso:
Os utilizadores devem ter uma barra de progresso que indica a experiencia necessaria para subir de nível.

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


----------------------------------------------------------
