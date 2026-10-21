# Exercícios de Java — Orientação a Objetos e Lógica

Programas de console feitos durante o curso (Entra21 / SENAC) para praticar a base da linguagem: classes, objetos, `ArrayList`, `Scanner`, menus com `switch` e validações.

| Pasta | O que faz |
|-------|-----------|
| `01-cadastro-alunos` | Cadastra alunos (nome, idade, nota), lista e busca por nome, indicando aprovado ou reprovado |
| `02-cadastro-carros` | Menu para incluir, listar e remover carros (nome, montadora e valor) |
| `03-cadastro-funcionarios` | Inclui, lista, busca e remove funcionários, com relatório de salários (soma, média, altos e baixos) |
| `04-locadora-filmes` | Simulação de locadora com várias classes (`Filme`, `Cliente`, `Locador`, `Emprestimo`, `Genero`), cadastro, empréstimo e devolução |

## Como rodar

Com o JDK instalado, entre na pasta do exercício e execute:

```bash
# exemplos
cd 01-cadastro-alunos
javac SistemaAlunos.java
java SistemaAlunos

cd ../04-locadora-filmes
javac *.java
java Principal
```
