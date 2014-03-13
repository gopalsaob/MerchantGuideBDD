Feature: Roman numeral value computation

  Background:
    Given Roman symbols having value:
      | symbolName | value |
      | I          | 1     |
      | V          | 5     |
      | X          | 10    |
      | L          | 50    |
      | C          | 100   |
      | D          | 500   |
      | M          | 1000  |

  Scenario Outline: Numbers are formed by combining symbols together and adding the values
    When input is <Input>
    Then value should be <value>

  Examples:
    | Input | value |
    | V     | 5     |
    | MMVI  | 2006  |

  Scenario: When smaller values precede larger values, the smaller values are subtracted from the larger values,
  and the result is added to the total

    When input is IV
    Then value should be 4

    When input is XIV
    Then value should be 14

  Scenario: The symbols having values with leading digit "1" e.g. "I", "X", "C", and "M" can be repeated three times in succession, but no more.

    When input is IIII
    Then an exception is thrown with the message: Illegal repetition of roman symbol, the symbol I has been repeated more than 3 times in succession

  Scenario: The symbols having values with leading digit "5"  e.g. "D", "L", and "V" can never be repeated.

    When input is DD
    Then an exception is thrown with the message: Illegal repetition of roman symbol, the symbol D has been repeated more than 1 time in succession


  Scenario: The symbols having values with leading digit "5" e.g. "V", "L", and "D" can never be subtracted.

    When input is VX
    Then an exception is thrown with the message: Illegal sequence, the symbol V cannot precede the symbol X

  Scenario: A symbol cannot be subtracted from a symbol which is more than 10 times greater its value e.g. "I" can be subtracted from "V" and "X" only. "X" can be subtracted from "L" and "C" only. "C" can be subtracted from "D" and "M" only.

    When input is IL
    Then an exception is thrown with the message: Illegal sequence, a symbol cannot precede a symbol which is more than ten times its value, I has preceded L

  Scenario: Only one small-value symbol may be subtracted from any large-value symbol.

    When input is IXC
    Then an exception is thrown with the message: Illegal sequence, a symbol cannot be preceded with more than one small value symbol, IX has preceded C

    When input is IIX
    Then an exception is thrown with the message: Illegal sequence, a symbol cannot be preceded with more than one small value symbol, II has preceded X

  Scenario: Sequence should be such that when converted to Arabic numerals, the arabic numerals can be broken into digits to get the back the original sequence

    When input is IXX
    Then an exception is thrown with the message: Illegal sequence, converted Arabic number cannot be broken into digits to get back the number.

    When input is XIX
    Then value should be 19