# ACSL "What Does This Program Do" Compiler
The American Computer Science League created a "pseudocode that should be readily understandable by all programmers 
familiar with a high-level programming language, such as Python, Java, or C". They gave the pseudocode a concrete syntax,
so I was able to turn that pseudocode into a real programming language. This program will compile that pseudocode
into the also fake ACSL assembly language. I included an interpreter for the ACSL assembly language, so you can run it.
with this project if you are interested in running it. 
[See my ACSL assembly project for more info on that](https://github.com/kylediaz/acsl-assembly-shell).

If you are looking to run a program made in the "What Does This Program Do" language:
1. You have some very serious problems
2. Just use this WDTPD -> Python translator I made

I didn't make this project so I can actually run WDTPD programs. I made it to learn how compilers work. I don't know of 
any other people who made a compiler or interpreter for WDTPD, so I thought it was the perfect candidate. If translating 
it to python isn't good enough for you, please read on.

## Limitations

These are the full capabilities of the language 
[stolen from the wiki :)](https://www.categories.acsl.org/wiki/index.php?title=What_Does_This_Program_Do%3F)

| Construct | Code Segment |
| --- | --- |
| Operators | ! (not), ^ or ↑(exponent), *, / (real division), % (modulus), +, -, >, <, >=, <=, !=, ==, && (and), &#124;&#124; (or) in that order of precedence |
| Functions | abs(x) - absolute value, sqrt(x) - square root, int(x) - greatest integer <= x |
| Variables | Start with a letter, only letters and digits |
| Sequential statements | INPUT variable<br>variable = expression (assignment)<br>OUTPUT variable |
| Decision statements | `IF` `boolean expression` `THEN`<br>Statement(s)<br>`ELSE` (optional)<br>Statement(s)<br>`END IF` |
| Indefinite Loop statements | `WHILE` `Boolean expression`<br>Statement(s)<br>`END WHILE` |
| Definite Loop statements | `FOR` `variable = start` `TO` `end` `STEP` `increment`<br>Statement(s)<br>`NEXT` |
| Arrays: | 1 dimensional arrays use a single subscript such as A(5). 2 dimensional arrays use (row, col) order such as A(2,3). Arrays can start at location 0 for 1 dimensional arrays and location (0,0) for 2 dimensional arrays. Most ACSL past problems start with either A(1) or A(1,1). The size of the array will usually be specified in the problem statement. |
| Strings: | Basically python strings |

What my compiler can actually work with:

| Construct | Code Segment |
| --- | --- |
| Operators | Yup |
| Functions | Nope |
| Variables | Yup |
| Sequential statements | Yup |
| Decision statements | Yup |
| Indefinite Loop statements | Yup |
| Definite Loop statements | Yup |
| Arrays: | Nope |
| Strings: | Nope |

Unfortunately, since I'm making this compile to the ACSL assembly language, I can't do pointer arithmetic to access and
store elements. The only way I could think of storing elements in an array is to embed the array information into the 
label.

`arrayName[1] = 2` becomes `ARRNAME1 DC 2`

I would love to actually do it this way, but this wouldn't work if you used a variable as the index in the array. Sorry :(
I'm thinking about expanding this project to also compile to either x84 assembly, python bytecode, or JVM bytecode, so I 
would be able to implement the entire language.

## How to use
Arguments in this order:

`"path/to/input_file.wdtpd" ["path/to/output_folder/" | --run]`

The program will output the assembly code to `ouput.asmcsl` in the output folder. It's a plain text file, so you can use
a program like notepad to open it.
Alternatively, using `--run` argument will skip generating a file and directly feed the output into a ACSL assembly 
interpreter and run the generated program.

If you don't give it any arguments, it will prompt you for these inputs through STDIN

This program will take any text file, but I like to give the code the file extension "wdtpd".

## Example
in (test_files/wiki/1.wdtpd):
```
input H, R
B = 0
if H>48 then
    B = B + (H - 48) * 2 * R
    H = 48
end if
if H>40 then
   B = B + (H - 40) * (3/2) * R
   H = 40
end if
B = B + H * R
output B
```
out (spaced and commented to make more readable):
```
READ H
READ R
B DC 0

; First if statement
STARTIF1 LOAD H
SUB =48
BL ENDIF1

LOAD H
SUB =48
MULT =2
MULT R
H DC 48
BU STARTIF1

ENDIF1 ADD 0
; End of second if statement

; Second if statement
STARTIF2 LOAD H
SUB =40
BL ENDIF2

LOAD H
SUB =40
MULT 3
MULT R
DIV 2
ADD B
STORE B

ENDIF2 ADD 0
; End of second if statement

LOAD H
MULT R
ADD B
STORE B
PRINT B
END
```
