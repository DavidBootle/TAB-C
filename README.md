# TAB-C Java
**Text-ASCII-Binary Converter**

© 2018: David Bootle

## Install
Download the zip file from the homepage, and unzip it. Add the folders to your project's root directory, then import using `import com.bootle.converter.TAB_C;`.

## Functions
### ```TAB_C.getAscii(char character)```
  - Takes type `char`.
  - Returns type `int`.
  - Takes a character and returns it's ASCII number.
```java
TAB_C.getAscii('a');
> 97
```
### `TAB_C.getBinary(int integer)`
  - Takes type `int`.
  - Returns type `String`.
  - Takes an integer and converts it into a binary string.
```java
TAB_C.getBinary(20);
> "10100"
```
### `TAB_C.setDigits(String string, int digits)`
  - Takes type `String` and type `int`.
  - Returns type `String`.
  - `string`: Numeric string to be lengthened.
  - `digits`: Number of digits to add the the number-string.
  - Takes a number (in the form of a string) and adds digits to the front in order to make the string a certain length.
```java
TAB_C.setDigits("42", 4);
> "0042"
```
### `TAB_C.setDigits(int number, int digits)`
  - Takes type `int` and type `int`.
  - Returns type `String`.
  - `number`: An integer to be lengthened.
  - `digits`: Number of digits to add the the number-string.
  - Takes a number (in the form of a string) and adds digits to the front in order to make the string a certain length.
```java
TAB_C.setDigits(42, 4);
> "0042"
```

// TODO finish readme
