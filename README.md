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
    
    public Carro(String marca, String modelo, String placa, String cor, int numPortas) {
        super(marca, modelo, placa, cor);
        this.numPortas = numPortas;
    }
}
```
## 📊 Diagrama de Classes
![Diagrama de Classes do Sistema de Estacionamento](https://github.com/user-attachments/assets/719fa2fd-a22b-4bbd-8695-4838ff7cd553)

## 🚀 Como Executar

1. **Pré-requisitos**:
   - JDK 17+ instalado
   - Terminal/CLI configurado

2. **Passo a passo**:
```bash
# Clone o repositório
git clone https://github.com/Cords9/Poo-Project.git

# Acesse o diretório
cd estacionamento-poo

# Compile o projeto
javac -encoding UTF-8 src/Main.java src/model/*.java src/funcionarios/*.java

# Execute o sistema
java -cp src Main
```


3. ## 🖥️ Menu Interativo

### 👨‍💼 **Menu Gerente**  
`1` Cadastrar novo atendente  
`2` Visualizar equipe cadastrada  
`3` Gerar relatório de ocupação  
`4` Acessar logs do sistema  
`0` Encerrar sessão  

### 🚦 **Menu Atendente**  
`1` Registrar entrada de veículo  
   `1.1` Carro  
   `1.2` Moto  
`2` Registrar saída de veículo  
`3` Consultar vagas disponíveis  
   `3.1` Vagas para carros  
   `3.2` Vagas para motos  
`0` Voltar ao menu principal  

### 🔄 Como navegar:
1. Digite o número correspondente   
2. Pressione ENTER para confirmar  

## 📂 Estrutura do Projeto

```plaintext
src/
├── model/
│   ├── veiculos/
│   │   ├── Veiculo.java
│   │   ├── Carro.java 
│   │   └── Moto.java
│   │
│   ├── funcionarios/
│   │   ├── Funcionario.java
│   │   ├── Atendente.java
│   │   └── Gerente.java
│   │
│   └── vagas/
│       ├── Vaga.java
│       ├── VagaCarro.java
│       └── VagaMoto.java
│
├── exceptions/
│   ├── AtendentesInsuficientesExceptions.java
│   ├── IdTwinException.java
│   ├── InvalidPortasException.java
│   └── VagasIndisponiveisException.java
│
├── interfaces/
│   └── MostrarInfos.java
│
└── Main.java
```
## ⚠️ Exceções Personalizadas

### PortasInvalidasException
```java
  *Lançada quando um carro é criado com número inválido de portas
                        (diferente de 2 ou 4)

public class PortasInvalidasException extends Exception {
    public PortasInvalidasException() {
        super("Número de portas inválido. Deve ser 2 ou 4");
    }
}
