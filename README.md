# Projeto Final 4 - Módulo 4

Este projeto implementa um cluster Kafka com produtores e consumidores utilizando Docker Compose.

## Estrutura

- **Zookeeper**: Gerenciador do cluster Kafka.
- **Kafka Brokers**: 3 instâncias de brokers Kafka (kafka1, kafka2, kafka3).
- **Producer**: Aplicação Java que produz mensagens para o Kafka.
- **Consumer**: Duas instâncias de aplicação Java que consomem mensagens do Kafka.

## Pré-requisitos

- Docker
- Docker Compose

## Como rodar

Para iniciar todo o ambiente (Kafka cluster, Producer e Consumers), execute o comando na raiz do diretório `mod4`:

```bash
docker-compose up -d --build
```

## Acessando a Aplicação

- **Producer API**: O serviço `producer` expõe uma API na porta `8080`.
  - URL: `http://localhost:8080`
  Requisição
  POST /producer
  ```json
  {
    "nome": "Teste",
    "email": "teste@teste"
  }
  ```

## Detalhes dos Serviços

- **Kafka**: Portas expostas `9092`, `9093`, `9094` (para acesso externo/localhost).
- **Producer**: Conecta-se aos brokers internamente.
- **Consumers**: `consumer1` e `consumer2` iniciam automaticamente e se conectam ao cluster.
