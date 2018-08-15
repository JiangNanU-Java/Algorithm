

If you are a fan of Harry Potter,you would know the world of magic has its own _[currency（货币）]_ system
-- as Hagrid explained it to Harry,"Seventeen _[silver（银，银币）]_ _[Sickles（镰刀）]_ to a -[Galleon（帆船）]_
and twenty-nine Knuts to a Sickle, it's easy enough."Your job is to write a program to -[compute（计算，估算）]_
A+B where A and B are given in the standard form of "Galleon.Sickle.Knut"(Galleon is an integer in `[0, 107]`,
Sickle is an integer in `[0, 17)`,and Knut is an integer in `[0, 29)`).


 输入描述:
 Each input file contains one test case 
 which _[occupies（占据）]_ a line with A and B in the standard form, separated by one space.
 
 
 输出描述:
 For each test case you should output the sum of A and B in one line, with the same format as the input.
 
 输入例子:
 3.2.1 10.16.27
 
 输出例子:
 14.1.28
 
 
#### 解

A.B.C => Galleon.Sickle.Knut

29 Knut -> 1 Sickle
17 Sickle -> 1 Galleon

-. 读取输入

1. 计算K,进位US，得到结果RK

2. 计算S+进位US，进位UG，得到结果RS

3. 计算G+进位UG，得到结果RG

-. 得到输出

总结：
4. hasNext()为幂等，即不会对输入造成影响  
   =>取出迭代器，next()检查下一个元素，若有，则remove()，所以不影响，  
   若只有一个元素，可以直接next()，而不用hasNext()进行判断

3. \\. 第一个'\'将第二个\标位普通，普通的\将后面的标位屏普通符号  
 
2. 使用split(" ") split("\\s")分割一个空格  
   使用split("\\s+")分割多个空格

1. readLine读取字符串，空格将会包含在其中  