# 🅿️ Sistema de Estacionamento POO

**Sistema completo para gerenciamento de estacionamentos desenvolvido em Java, aplicando conceitos avançados de Programação Orientada a Objetos.**

## 📋 Índice
- [Funcionalidades](#-funcionalidades)
- [Tecnologias](#-tecnologias)
- [Diagrama de Classes](#-diagrama-de-classes)
- [Como Executar](#-como-executar)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Exceções Personalizadas](#-exceções-personalizadas)
- [Logs do Sistema](#-logs-do-sistema)
- [Licença](#-licença)

## 🎯 Funcionalidades

### 👨‍💼 **Módulo Gerente**
| Função | Descrição |
|--------|-----------|
| Cadastrar Atendentes | Registra novos funcionários no sistema |
| Relatórios | Gera relatórios de ocupação e equipe |
| Visualizar Logs | Acessa histórico completo de operações |

### 🚦 **Módulo Atendente**
| Função | Descrição |
|--------|-----------|
| Reservar Vagas | Registra entrada de veículos |
| Liberar Vagas | Processa saída de veículos |
| Consultar Disponibilidade | Verifica vagas livres por pátio |

### 🚗 **Tipos de Veículos**
- Carros (com controle de portas)
- Motos

## 💻 Tecnologias

![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?logo=java)
![OOP](https://img.shields.io/badge/POO-100%25-blue)
![Logging](https://img.shields.io/badge/Logging-File%20System-success)

```java
// Exemplo de código
public class Carro extends Veiculo {
    private int numPortas;
    
    // Construtor e métodos...
}
```



