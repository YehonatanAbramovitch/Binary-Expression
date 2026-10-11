# Boolean Expressions (Java)

A small Java library for representing and manipulating **Boolean logic expressions** as expression trees.
Built as part of an Object-Oriented Programming course.

## What it does

Expressions are built by nesting objects:

```java
Expression e = new Not(
        new Xor(
                new Or(new Var("x"), new Var("y")),
                new Nor(new Var("z"), new Val(false))));

System.out.println(e);                 // ~(((x | y) ^ (z V F)))

Map<String, Boolean> assignment = new TreeMap<>();
assignment.put("x", true);
assignment.put("y", false);
assignment.put("z", false);
System.out.println(e.evaluate(assignment));   // true
```

Every expression supports:

| Method | Description |
|---|---|
| `evaluate(assignment)` / `evaluate()` | Computes the value, given values for the variables |
| `getVariables()` | Lists the variables in the expression |
| `assign(var, expression)` | Returns a new expression with a variable replaced by another expression |
| `nandify()` | Converts to an equivalent expression using only **NAND** |
| `norify()` | Converts to an equivalent expression using only **NOR** |
| `simplify()` | Applies logical identities, e.g. `x & F → F`, `x & T → x`, `x & x → x` |
| `toString()` | Readable form of the expression |

## Operators

| Class | Operator | Printed as |
|---|---|---|
| `Not` | NOT | `~(x)` |
| `And` | AND | `(x & y)` |
| `Or` | OR | `(x \| y)` |
| `Xor` | XOR | `(x ^ y)` |
| `Nand` | NAND | `(x A y)` |
| `Nor` | NOR | `(x V y)` |
| `Xnor` | XNOR | `(x # y)` |
| `Var` / `Val` | variable / constant | `x`, `T`, `F` |

## Design

- `Expression` — the interface every expression implements
- `BaseExpression` — abstract base holding an operand
  - `UnaryExpression` → `Not`
  - `BinaryExpression` → `And`, `Or`, `Xor`, `Nand`, `Nor`, `Xnor`
- `Var` and `Val` — the leaves of the tree

The structure follows the **Composite pattern**: every operation is implemented recursively, with each node delegating to its children. Expressions are treated as immutable — `assign`, `nandify`, `norify` and `simplify` return new expressions rather than modifying the original.

## Running

Requirements: **Java 8+** and **Apache Ant**.

```bash
ant run
```

This compiles the sources into `bin/` and runs `ExpressionsTest`, which builds the example expression above and prints its value, its NAND and NOR forms, and its simplified form.

## Author

**Yehonatan Abramovitch** — [Portfolio](https://yehonatanabramovitch.github.io) · [LinkedIn](https://www.linkedin.com/in/yehonatan-abramovitch)
