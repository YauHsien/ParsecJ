# ParsecJ

Parser combinators (higher-order functions for parsing) in Java.

A good exercise on Java Generic Types.

### Example

An example of arithmetic parsing:

`example.Espn exp = new example.Espn();`
`ArrayList<util.Pair<util.Numeral, util.MyString>> result = exp.parse(new util.MyString("2+(4-1)*3"));`
`System.out.println(result);`

It prints:

`[(11, ""), (5, "*3"), (2, "+(4-1)*3")]`


### Reference

Graham Hutton, "Higher-Order Functions for Parsing," 1992.

[Graham Hutton, "Higher-Order Functions for Parsing," 1992.]: https://www.semanticscholar.org/paper/Higher-Order-Functions-for-Parsing-Hutton/91282fb880f72d50f4969d9d0e71eff35400444c

### Strategy 技巧

#### Java Generics 抽象型態與具體型態的媒合

1. `primitivy.Satisfy` 與 `util.MyString` ：由 `extends LinkedList<?>` 規格媒合。

1. `util.MyString` 實作 `Cloneable` 。
