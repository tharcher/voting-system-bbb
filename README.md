# Sistema de Votação para o Paredão do BBB

Este é um sistema de votação desenvolvido para o Paredão do BBB, consistindo em um frontend web e uma API backend.

## Visão Geral

O sistema permite aos usuários votarem em um dos integrantes apresentados no paredão do Big Brother Brasil. Após votar, os usuários recebem uma confirmação do sucesso de seu voto.

## Tecnologias Utilizadas

- **Frontend:**
- React
- TypeScript
- HTML
- CSS
- JavaScript
- **Backend:**
- Java (Spring Boot)
- **Banco de Dados:**
- MongoDB
- **Message Broker:**
- Kafka
- **Infraestrutura:**
- Docker-Compose
- **Controle de Versão:**
- Git
- **Hospedagem de Código:**
- GitHub

## Funcionalidades
- **Apresentação dos Candidatos:** Os usuários podem ver os candidatos do paredão e escolher em quem votar.
- **Votação Ilimitada:** Os usuários podem votar quantas vezes quiserem, independentemente da opção escolhida.
- **Confirmação de Voto:** Após votar, os usuários recebem uma tela de confirmação do sucesso de seu voto.
- **Panorama de Votos:** Ver um panorama percentual dos votos por candidato até o momento.(A DESENVOLVER)
- **Prevenção de Votos Automatizados:** Medidas devem ser implementadas para prevenir votos automatizados.
- **Volume de Votos:** Estima-se um volume elevado de votos, com cerca de 1000 votos por segundo.(A DESENVOLVER)

## Arquitetura
O sistema segue uma arquitetura cliente-servidor, com o frontend web interagindo com a API backend.

-**Frontend**
O frontend é uma aplicação web desenvolvida com React, TypeScript, HTML, CSS e JavaScript.

-**Backend**
A API backend é desenvolvida em Java com Spring Boot e é responsável por receber e processar os votos dos usuários. Utiliza o MongoDB como banco de dados e o Kafka como message broker.
