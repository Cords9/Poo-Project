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

### 1. **Pré-requisitos**:
   - JDK 17+ instalado
   - Terminal/CLI configurado

### 2. **Passo a Passo**:

- **Clone o repositório**:

  ```bash
  git clone https://github.com/Cords9/Poo-Project.git
  ```

- **Acesse o diretório**

```bash
cd estacionamento-poo
```

- **Compile o projeto**
```bash
javac -encoding UTF-8 src/Main.java src/model/*.java src/funcionarios/*.java
```

-  **Execute o sistema**
```bash
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
```


### VagasIndisponiveisException
```java
/**
 * Lançada quando a vaga escolhida já está ocupada
 */
public class VagasIndisponiveisException extends Exception {
    public VagasIndisponiveisException() {
        super("Não há vagas disponíveis");
    }
}
```

### IdTwinException
```java
/**
 * Lançada ao tentar cadastrar um ID duplicado
 */
public class IdTwinException extends Exception {
    public IdTwinException() {
        super("ID já está em uso");
    }
}
```

### AtendentesInsuficientesException
```java
/**
 * Lançada quando não há atendentes cadastrados para operar o sistema
 */
public class AtendentesInsuficientesException extends Exception {
    public AtendentesInsuficientesException() {
        super("Nenhum atendente cadastrado");
    }
}

```


## 📝 Logs do Sistema

### 🌜 Sobre
O sistema gera automaticamente um arquivo de log chamado `L0gEstacionamento.txt` na raiz do projeto, registrando todas as operações importantes.

### 🔍 Como Visualizar
1. No menu do gerente, abra a aba **"Logs"**
2. Ou acesse diretamente o arquivo `L0gEstacionamento.txt` na pasta do programa

### 📋 Formato dos Registros
Cada linha segue o padrão:

```txt
[ MENSAGEM ]
```

Exemplo real:

```txt
Carro Renault Sandero estacionado na vaga 5

O gerente Marcos entrou no sistema

Novo atendente registrado no sistema: ||Atendente- Souza||ID- 1||CPF- 091-254-214-21||

Atendentes registrados no estacionamento- [||Atendente- Souza||ID- 1||CPF- 091-254-214-21||]

O gerente Marcos saiu do sistema

O Atendente Souza entrou no sistema

Um Carro entrou no estacionamento- Carro || marca : Fiat|| modelo : Palio|| placa : faz-q214|| Cor : Azul|| Número de portas : 4 ||

O atendente Souza saiu do sistema
```

### 📌 O que é Registrado
- Entrada/saída de veículos
- Logins de atendentes
- Erros do sistema
- Operações administrativas
- Alertas importantes



## 📜 Licença

### MIT License

```plaintext
Copyright (c) 2023 Diego Cordeiro

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
