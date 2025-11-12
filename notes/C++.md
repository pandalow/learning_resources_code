# C++ Notion

流程: preprocssing→compiling→assembly→link

非常好的问题 👍  
这其实是理解 C++ 编译系统和程序运行机制的关键一环。

C++ 从你写下 `.cpp` 文件到程序最终运行，大致要经过 **4 个编译阶段 + 1 个运行阶段**：

* * *

一、整体流程概览
    源代码(.cpp)
       ↓
    [1] 预处理（Preprocessing）
       ↓
    [2] 编译（Compilation）
       ↓
    [3] 汇编（Assembly）
       ↓
    [4] 链接（Linking）
       ↓
    可执行文件(.exe / .out)
       ↓
    [5] 运行时（Runtime）

* * *

二、阶段详解

 1️⃣ 预处理（Preprocessing）

> 处理以 `#` 开头的预处理指令。

主要任务：

* 展开所有 `#include` 文件（把头文件内容拷进来）；

* 替换所有 `#define` 宏；

* 处理条件编译（`#ifdef`、`#ifndef`）；

* 删除注释。

命令示例：
    g++ -E main.cpp -o main.i

此时输出的 `main.i` 是**纯文本展开后的源码**，仍然是 C++ 代码。

* * *

 2️⃣ 编译（Compilation）

> 把预处理后的源码翻译成汇编代码。

主要任务：

* 语法分析、语义分析；

* 类型检查；

* 优化代码；

* 生成汇编文件。

命令示例：
    g++ -S main.i -o main.s

`main.s` 是汇编语言文件，比如：
    movl $5, -4(%rbp)
    call _Z4Printi

* * *

汇编（Assembly）

> 把汇编语言翻译成**机器码（二进制）**。

命令示例：
    g++ -c main.s -o main.o

生成的 `.o`（或 `.obj`）是 **目标文件（object file）**，  
包含机器指令和符号表，但还没“拼成完整程序”。

* * *

 链接（Linking）

> 把多个目标文件 `.o` 和库文件 `.a` / `.so` 拼成一个完整的可执行程序。

主要任务：

* 把不同文件中定义和声明的符号对应起来；

* 解决函数、变量的外部引用（`extern`）；

* 加载静态库（`.a`）或动态库（`.so` / `.dll`）；

* 最终生成可执行文件（`a.out` / `.exe`）。

命令示例：
    g++ main.o utils.o -o main

在这一步，C++ 的 **linking** 工作最关键，比如：

* 如果某个函数声明了但没定义，就会报 **“undefined reference”**；

* 如果某个变量重复定义，就会报 **“multiple definition”**。

* * *

运行时（Runtime）

> 程序被加载进内存，由操作系统执行。

运行阶段发生的事：

1. **操作系统加载可执行文件** 到内存；

2. 设置栈（Stack）和堆（Heap）；

3. 初始化全局/静态变量；

4. 调用全局对象的构造函数；

5. 调用 `main()` 函数；

6. 程序执行；

7. 执行结束后调用析构函数、释放资源；

8. 退出并返回 `exit code`。

可以理解为：
    [Loader] → [Runtime Initialization] → [main()] → [Runtime Cleanup]



 整体总结表

| 阶段  | 名称                | 输入文件   | 输出文件            | 关键动作     |
| --- | ----------------- | ------ | --------------- | -------- |
| 1   | 预处理 Preprocessing | `.cpp` | `.i`            | 展开宏、头文件  |
| 2   | 编译 Compilation    | `.i`   | `.s`            | 生成汇编代码   |
| 3   | 汇编 Assembly       | `.s`   | `.o`            | 转为机器码    |
| 4   | 链接 Linking        | `.o`   | `.exe` / `.out` | 拼接目标文件   |
| 5   | 运行 Runtime        | `.exe` | —               | 加载、执行、退出 |

 四、可视化理解
    源码(main.cpp)
       ↓ （预处理）
       ↓ 展开#include、宏定义
    [main.i]
       ↓ （编译）
       ↓ 翻译成汇编
    [main.s]
       ↓ （汇编）
       ↓ 翻译成机器码
    [main.o]
       ↓ （链接）
       ↓ 合并符号与库
    [main.exe]
       ↓ （运行）
       ↓ OS加载 -> main() -> exit()

 五、扩展：为什么说模板在“编译期生成”？

因为模板（`template`）在编译阶段会被**实例化（Instantiation）**：

* 只有当模板被使用时，编译器才会生成对应的代码；

* 不用的模板不会生成机器码。

这发生在第二阶段（Compilation）内。

* * *

一句话总结：

> C++ 程序从 `.cpp` 到运行，经历了 **预处理 → 编译 → 汇编 → 链接 → 运行** 五步。  
> 其中最重要的是编译（生成机器码）和链接（拼成完整程序）。



- translation unit
    翻译单元（translation unit）在 C++ 中的含义（简短）：
    •    翻译单元 = 一个源文件经过预处理后的结果：即某个 .cpp 文件加上它 #include 的所有头文件展开后的文本。
    •    编译器对每个翻译单元单独编译，产出各自的对象文件（.obj / .o）；链接器再把这些对象文件合并并解析外部符号。
    •    因此，类的 static 成员只在类内声明一次，但必须在某个翻译单元（通常某个 .cpp）中提供定义，否则会出现 “unresolved external symbol” 链接错误。
1. Cpp file 如果include, 会在compile时变更为translation unit
2. Preprocessor - Header File
   1. `#include`: 就是一个简单的copy-paste的过程
   2. `#include` 将 新的代码copy到当前文件替换掉原来的`#include`的部分
   3. `#define`  : **预处理指令（preprocessor directive）**，其本质并不是语句或表达式，而是 **由预处理器在编译之前进行的文本替换规则**。可以定义别人的一个完全新的Keywords
   4. `#if`  可以用来预先判断: 

## Java & C++

| 概念           | C/C++ `#include` / `#define` | Java `import`      |
| ------------ | ---------------------------- | ------------------ |
| **发生时机**     | **编译前（预处理阶段）**               | **编译阶段（语义解析阶段）**   |
| **作用方式**     | 纯**文本替换**或**文件复制**           | 告诉编译器去哪个**命名空间**找类 |
| **是否改变代码内容** | ✅ 是（把内容直接展开进文件）              | ❌ 否（不复制代码）         |
| **是否影响编译时间** | ✅ 可能显著增加（因为复制）               | ❌ 基本不影响            |
| **是否参与类型检查** | ❌ 不参与（预处理器不懂类型）              | ✅ 编译器会检查类型         |

## Linker:

1. Linking 只发生在build阶段(运行阶段). 
   在 C++ 编译过程中，**linking（链接）是把多个编译单元**（比如不同的 `.cpp` 文件）以及外部库的目标文件（`.o` / `.obj`）组合成**一个可执行程序**或**动态/静态库**的阶段。
2. 其实可以自定义entry function, 只需要找到对应的entry point就可以了
3. 错误列表
   1. `C`开头的错误代码 就是编译错误 `LNK`开头的错误代码 是链接错误
   2. `Unresolved external symbol` 是链接器找不到它需要的东西
4. 如果在函数前面加一个 `static`就说明这个函数只在当前cpp文件里会被使用 其它cpp文件里都不会用到 那么它就不用参与链接 其他cpp文件就不使用
5. 一个头文件Log.h 在里面定义了一个函数 然后在两个cpp里都调用这个头文件 实际上就是把这个头文件复制到了两个cpp文件里 那么就是两个cpp文件里都写了这个函数的定义 定义重复了 如果两个cpp里都调用了头文件里的同一个函数 就会报链接错误 “未解决的外部符号”
   1. 可以把这个函数定义为static `static void Log(const char* message)`

## Forward declaration

A **forward declaration** allows us to tell the compiler about the existence of an identifier *before* actually defining the identifier.(**正向声明**允许我们在实际定义标识符*之前告诉*编译器标识符的存在。)
要为函数编写正向声明，我们使用**函数声明**语句（也称为**函数原型** ）。函数声明由函数的返回类型、名称和参数类型组成，以分号结尾。可以选择包含参数的名称。函数体不包含在声明中。

```jsx
#include <iostream>

int add(int x, int y); // forward declaration of add() (using a function declaration)

int main()
{
    std::cout << "The sum of 3 and 4 is: " << add(3, 4) << '\n'; // this works because we forward declared add() above
    return 0;
}

int add(int x, int y) // even though the body of add() isn't defined until here
{
    return x + y;
}
```

## Var

1. int 4个字节byte; 
   1. 最长instruciton为32位， 有有一个符号位，其余31位表示实际的数字 2^31^. 即20多亿 这是正数的范围 但我们还需要表示负数和0, 
   2. 可以设置位无符号数`unsigned`那就是从0到 2^32^
2. Types:
   1. 文字： char
   2. 整数：short, long, int
      1. char 1个字节, short 2个字节, long 4个字节, long long 8个字节, 但是到底几个字节都取决于编译器 我们可以调用`sizeof(long)` `sizeof(long long)`去查询 或者写`sizeof long`也行 这些数据类型也都可以变成unsigned
   3. 浮点: float, double
      1. float 4个字节 double 8个字节
   4. 逻辑: bool(true, false)
3. Function
   1. 就是代码块 在class类里面 叫做Method
   2. 谈到Function时 我们明确地指不属于类里面的东西,
      1. 你可以认为函数是有一个输入 也有一个输出 我们可以为函数提供一定的参数 当然也可以不提供参数 函数也可以不返回任何东西 就是void 
      2. **函数是为了防止写重复代码的** 但也不用所有的东西都写成函数 会让程序变慢 每次我们调用函数时 
      3. 编译器生成一个call指令 就会进入堆栈结构 把像参数这样的东西推进堆栈 还会需要一个返回地址 又会jump到二进制执行文件的不同位置 以便执行我们的函数指令 为了将push进去的结果返回 又要回到最初调用函数之前 就像在内存中跳跃来执行函数 跳跃和执行都需要时间 这些都是因为编译器决定\
      4. 保持我们的函数作为一个实际的函数 并不做内联inline

## Header File

1. 格式为， xxx.h file

2. 可以declare 在别的文件中的 function， 并在多个文件中include并使用

3. `#progma once` 这个代表最先运行， 在preprocessing阶段会首先运行（在当前文件）， 只是一次；

4. 所有的`#`开头的都是preprocesing

5. **头文件有嵌套问题 可能你在创造一个头文件时使用了另一个头文件的内容 会创造一链条的头文件**

6. 如果不用pragma once 就用`#ifndef` 这是一种过去的方式 可能有人会用 你不要用

7. **BS:  pragma once**

8. `ifndef` :
   
   ```jsx
   #ifndef _LOG_H
   #define _LOG_H
   ```

9. `<>` 的include只包含path， 但是`’ ’`的include可以用于所有

10. Debugging
    
    1. step into 逐语句(F11) 意思是进入到这行代码的函数里面, step over 逐过程(F10) 意思是从当前函数跳到下一行代码, step out 跳出(Shift+F11)意思是跳出当前函数 回到调用这个函数的位置

## If statement

1. if语句和分支通常有比较大的开销，如果效率高做优化就避免写if语句

2. `bool comparisonResult = (x == 5);` 这里的`==`是在C++标准库中被重载了
   
   1. 相当于写一个函数 接受两个整数参数 然后检查这两个整数的内存 实际上是在获取它们4个字节的内存 比较每个字节 
   2. 为了让这两个整数是相等的 内存的每一位都必须相同 看它们是否相等 相等就返回true

3. 在debug中 右键某一行代码—转到反汇编 就可以查看它的汇编指令

4. 类型提升规则
    当bool参与比较或运算时 会隐式转换为int类型 true提升为1，false提升为0 则`comparisonResult == true`等价于`(int)comparisonResult == 1` 编译器直接生成与1比较的指令

5. 编译器对bool的合法性假设
    编译器假设程序遵循C++标准 所有bool变量只能存储0或1 若通过非法手段（如内存覆写）使bool值为其他非0数 属于未定义行为 编译器无需处理

6. 逻辑操作的结果规范化
    逻辑运算符（如`==`、`&&`）生成的bool值会被规范化为0或

7. 直接比较eax是否为1（单条cmp指令）比检查非0（需两次操作 测试是否为0 然后取反）更高效 编译器在合法代码前提下选择最优路径 

8. 在开启O2优化后 编译器通过以下关键优化步骤彻底移除了条件判断和Log调用：
   
   1. 常量传播 (Constant Propagation)
      1. `int x = 6`被识别为编译期常量
      2. 所有使用`x`的地方直接替换为6
   2. 死代码消除 (Dead Code Elimination)
      1. 由于`x == 5`被替换为`6 == 5`，编译器直接判定结果为`false`
      2. 整个if代码块被识别为不可达代码，包括：
         1. `bool comparisonResult`的初始化
         2. `if (comparisonResult == true)`的条件判断
         3. `Log("Hello, World!")`的调用
   3. 函数调用优化
      - 未被调用的`Log`函数被完全移除（假设没有其他调用点）

## BestSetup

| **场景**       | **推荐工具链**             | **优点**           |
| ------------ | --------------------- | ---------------- |
| Windows 原生开发 | Visual Studio MSVC    | 深度集成 IDE，调试方便    |
| 跨平台项目（需 GCC） | MSYS2 + MinGW         | 兼容 Linux 代码，方便移植 |
| 快速管理第三方库     | vcpkg + Visual Studio | 自动处理依赖，无需手动配置路径  |

1. 使用显示所有文件管理源代码
2. 目录设置（右键项目→ porperty）：All platfom/ All Config
   1. 输出目录：`$(SolutionDir)\bin\$(Platform)\$(Configuration)\`
   2. 中间目录： `$(SolutionDir)\bin\intermediates\$(Platform)\$(Configuration)\`

## For/While loop

1. for 循环的3段声明
   
   1. 第1段 开始for循环时 运行一次
   2. 第2段 bool类型 将在for循环一次结束之后 进行评估
   3. 第3段 看上去是要在for循环的最后被运行

2. infinite loop
   
   ```jsx
       bool condition = true;
       for(; condition; ) {
           Log("This will run indefinitely unless condition is changed.");
           condition = false; // Change condition to false to prevent infinite loop
       }
   ```

3. while
   
   ```jsx
       int i = 5;
       while (i < 5) {
                   Log("This will not run because the condition is false.");
                   i++;
       }
   ```

4. do-while 是无论条件是否满足 先执行循环体一次

## Control Statement

1. continue 只能在循环中使用 表示进入这个循环的下一次迭代 如果还有下一次迭代的话 如果没有了 循环就会结束
2. break 只能在循环中使用 跳出循环 终止循环
3. return 可以使用在任何地方 直接退出函数

## Pointers（Raw Pointers）

1. Pointer is an integer and number which stores a memory address;(指针就是一个变量，它的值是另一个变量的内存地址。 )
   
   1. C++中的pointer 就是寻址用的指针
   
   2. typeless, 没有类型
      
      ```jsx
      #include <iostream>
      
      int main() {
      
       void* ptr = nullptr;
      
       int var = 8;
       // Assign the address of var to ptr
       void* pVar = &var;
      
       // Change the value of var using pointer arithmetic
      
       *ptr = 10; // This line will cause a compilation error since ptr is of type void*
      
       int* intPtr = &var;
       *intPtr = 20; // Now var is changed to 20
      
       // Dynamic memory allocation
       char* buffer = new char[10];
      
       // Double pointer
       char** pBuffer = &buffer;
      
       // deallocate memory
       delete[] buffer;
      
       std::cin.get();
      
       return 0;
      }
      ```

2. 已经存在的变量前面加上`&`, 表示取这个变量的内存地址

3. `*ptr`是逆向引用指针 dereferencing the pointer 意思是这个指针所指的那个变量 这个地址上所在的那个变量 逆向引用也可以叫做解引用
   
   1. 使用逆向引用去对这个变量读取或写入 指针就必须记录变量的类型

4. `new`关键字来申请堆内存 在结束之后也应该删除数据 因为使用了数组来分配堆内存 所以要用`delete[]`

5. Memory→ linear one-dinmisional line;
   
   1. 内存是计算机的一块**连续的地址空间**，可以想象成：
      
      > 一条很长的数组：
      > `memory[0]`, `memory[1]`, `memory[2]`, ..., `memory[n]`
      
      b. 
      
      | 区域               | 用途                     | 特点         |
      | ---------------- | ---------------------- | ---------- |
      | **Code Segment** | 程序的机器指令                | 只读         |
      | **Data Segment** | 全局变量、静态变量              | 程序启动时分配    |
      | **Heap (堆)**     | 动态分配 (`malloc`, `new`) | 程序员管理      |
      | **Stack (栈)**    | 函数调用、局部变量              | 自动管理（系统管理） |
- 现代Pointer的使用情况
  一、为什么还需要指针？
    即使在现代C++中，**“指针”这个概念**依然是不可或缺的，因为它是：
  
  - 内存寻址的唯一基础；
  
  - 实现各种抽象（如引用、迭代器、智能指针）的底层机制；
  
  - 动态内存分配、回调函数、系统调用的核心。
    👉 换句话说：
    
    > “虽然你可能不再直接 new/delete，但背后依然是指针在工作。”
    
    ---
  
  ## 🧠 二、现代C++怎么用“安全的指针”
  
    现代C++（C++11 之后）引入了**智能指针（Smart Pointer）**，它帮你自动管理内存，防止内存泄漏：
  
  | 类型                   | 含义              | 特点           |
  | -------------------- | --------------- | ------------ |
  | `std::unique_ptr<T>` | 独占所有权           | 无需手动释放       |
  | `std::shared_ptr<T>` | 引用计数共享所有权       | 自动引用计数管理     |
  | `std::weak_ptr<T>`   | 弱引用（防止循环引用）     | 不增加计数        |
  | `std::nullptr_t`     | 空指针常量 `nullptr` | 比 `NULL` 更安全 |
  
    🔹 例如：
  
  ```cpp
  #include <memory>
  
  int main() {
      auto p = std::make_unique<int>(10); // 自动分配内存
      std::cout << *p;  // 输出10
  }  // 退出作用域时自动释放内存
  
  ```
  
    不需要写 `delete p;`，智能指针会自动释放。
  
    ---
  
  ## ⚙️ 三、在哪些场景下还会用“裸指针”？
  
    虽然高层一般不用，但底层仍离不开：
  
  | 场景                           | 原因                                 |
  | ---------------------------- | ---------------------------------- |
  | 操作系统 / 嵌入式编程                 | 必须精确控制内存、寄存器地址                     |
  | 图形 / 游戏引擎                    | 需要高性能内存布局（如 OpenGL、DirectX、Vulkan） |
  | 与 C 库交互（如 OpenCV, POSIX API） | C 接口只接受裸指针                         |
  | 数据结构（链表、树、图）                 | 直接操作节点指针最方便                        |
  | 性能优化（手写 allocator、内存池）       | 避免智能指针开销                           |
  
    🔹 例如：
  
  ```cpp
  struct Node {
      int val;
      Node* next; // 裸指针实现链表
  };
  
  ```
  
    ---
  
  ## 🧱 四、为什么“直接用指针”不再推荐？
  
    因为“裸指针”带来很多 **容易犯的错误**：
  
  | 问题                     | 示例                |
  | ---------------------- | ----------------- |
  | 悬空指针（dangling pointer） | 指向已释放的内存          |
  | 内存泄漏                   | 忘记 `delete`       |
  | 野指针                    | 指针未初始化            |
  | 重复释放                   | 多次 `delete` 同一块内存 |
  | 不安全的跨线程访问              | 多线程中共享裸指针导致崩溃     |
  
    现代 C++ 倾向于：
  
  > “让资源和对象的生命周期自动化”
  > ——比如用智能指针、容器（`std::vector`）或引用。
  
    ---
  
  ## 🚀 五、现代推荐做法总结
  
  | 任务             | 推荐方式                                        |
  | -------------- | ------------------------------------------- |
  | 动态分配单个对象       | `std::make_unique<T>()`                     |
  | 共享对象           | `std::make_shared<T>()`                     |
  | 传递只读指针         | 使用 `const T*` 或 `const std::shared_ptr<T>&` |
  | 数组、集合          | 用 `std::vector`、`std::array` 代替手动分配         |
  | 不管理生命周期，只引用    | 用普通引用 `T&` 或 `const T&`                     |
  | 必须手动控制（如系统级代码） | 小心使用裸指针 `T*`                                |
  
    ---
  
  ## 💬 六、总结一句话：
  
  > 🔹 指针（pointer）仍然无处不在。
  > 即使你不直接操作裸指针，编译器、容器、智能指针、函数参数背后全是它在工作。
  > 🔹 **现代C++的思想是**：
  > “能不用裸指针就不用，让编译器帮你管理生命周期。”
  
    ---

## Reference

`&` 在 C++ 中有三种主要用途：

1. 出现在类型定义处时，表示“引用（reference）”。引用是变量的别名，不会创建新的内存。例如
   
   ```cpp
   int a = 10;
   int &b = a;
   b = 20; // a 也变成 20
   
   ```
   
    在函数参数中使用 `int &x` 表示按引用传参，函数内部修改会影响外部变量；不加 `&` 表示传值，不会影响外部。加上 `const`（如 `const std::string &s`）可以避免拷贝同时防止修改。

2. 出现在表达式中时，表示“取地址（address-of）”。
   
   ```cpp
   int a = 42;
   int* p = &a; // p 保存 a 的地址
   *p = 99;     // 通过解引用修改 a 的值
   
   ```

3. 不用 `&` 的情况：当只想复制值、不想修改原变量时，或变量体积较小（如 int、char），直接传值更简单。

对比总结：

| 写法                   | 含义         | 是否修改原变量 |
| -------------------- | ---------- | ------- |
| `int &x = a;`        | 声明引用       | ✅ 会     |
| `&a`                 | 取地址        | ❌ 不会    |
| `void f(int &x)`     | 引用传参       | ✅ 会     |
| `void f(int x)`      | 值传参        | ❌ 不会    |
| `void f(const T &x)` | 只读引用（高效安全） | ❌ 不会    |

1. 引用必须要引用已经存在的变量 引用本身并不是新的变量 不占用内存 没有真正的存储空间

2. `int&` 这个&是变量声明的一部分 并不是取地址 现在我们只是为a创造了一个别名ref，ref变量是不存在的
   
   1. 通过函数真正地修改这个变量: 用指针把变量a的内存地址传递过去
      
      ```jsx
      void Increment(int* x)
      {
          (*x)++;
          //根据运算优先级 如果不加() 就是先算++ 对地址进行递增
          //而我们期待的是先对指针逆向引用 找到这个地址的那个变量的值 对这个值++
      }
      ```
   
   2. 用引用 就是把a复制给了函数里新的引用x x就只是a的别名
      
      ```jsx
      void Increment(int& x)
      {
          x++;
      }
      ```
   
   3. 引用Reference不可以变更
      
      1. 首次指向引用地址， 之后只能调整引用地址中的值， 不可以变更引用的地址
         
         ```jsx
         int a = 5;
         int b = 8;
         
         int& ref = a;
         ref = b;
         //此时 a=8, b=8
         ```
   
   4. pointer 可以变更，只要接地址就可以了
      
      ```jsx
      int* ref = &a;
      ref = &b;
      ```
- Ref 与 Pointer的区别
  
  | 符号  | 名称             | 本质      | 能否为空            | 是否能重新指向别的对象 | 使用方式                  |
  | --- | -------------- | ------- | --------------- | ----------- | --------------------- |
  | `*` | 指针 (pointer)   | 保存“地址”  | ✅ 可以是 `nullptr` | ✅ 可以重新指向    | `p = &x; *p = 10;`    |
  | `&` | 引用 (reference) | 变量的“别名” | ❌ 不可为空          | ❌ 不可重新绑定    | `r = 10; // 相当于操作原变量` |
  
    ---
  
  ```cpp
  int a = 10;
  int* p = &a;  // p 存储的是 a 的地址
  *p = 20;      // 解引用修改 a 的值
  
  std::cout << a << std::endl; // 输出 20
  
  ```
  
  - `p` 是一个变量，里面装的是“a 的地址”
  
  - `p` 表示“取出 p 指向的那个值”
  
  - 所以 `p = 20` 等价于 `a = 20`
    
    > ✅ 指针可以为空，比如 int* p = nullptr;
    > ✅ 也可以 later 改成 `p = &b;`
    
    ---
  
  ```cpp
  int a = 10;
  int& r = a;   // r 是 a 的别名
  r = 20;       // 等价于 a = 20
  
  std::cout << a << std::endl; // 输出 20
  
  ```
  
  - `r` 不是地址，它是 `a` 的另一个名字
  
  - 你不能让 `r` 去引用别的变量
  
  - 也不能有 “空引用”
    
    > ❌ int& r = nullptr; —— 不行
    > ❌ `r = b;` —— 这只是把 b 的值赋给 a，不是重新绑定引用
    
    ---
  
  | 概念         | 类比生活中的例子                                                |
  | ---------- | ------------------------------------------------------- |
  | **指针 `*`** | “地址纸条”📄：写着‘a 在第 0x1000 号柜子里’。你拿着纸条去柜子里操作。              |
  | **引用 `&`** | “昵称”🪪：你给 a 起了个别名叫 r，说“r 其实就是 a”，你叫 r = 20 等价于给 a = 20。 |
  
    ---
  
    在这段代码中：
  
  ```cpp
  static Singleton& Get() {
      static Singleton instance;
      return instance;
  }
  
  ```
  
    `Get()` 返回的是一个 **引用**（`Singleton&`）：
  
  - 它不是复制一个新对象；
  
  - 也不是返回地址；
  
  - 而是“返回那个对象本身的别名”。
    所以：
    
    ```cpp
    Singleton::Get().Hello();
    
    ```
    
    你调用的是那个单例对象的 `Hello()` 方法，而不是一个临时拷贝。
    
    ---
  
  | 返回类型               | 含义                | 使用场景                              |
  | ------------------ | ----------------- | --------------------------------- |
  | `Singleton* Get()` | 返回指针，要用 `->` 调用   | 传统风格：`Singleton::Get()->Hello();` |
  | `Singleton& Get()` | 返回引用，可以直接用 `.` 调用 | 现代风格：`Singleton::Get().Hello();`  |
  
    ---
  
    ✅ **总结一句话：**
  
  > 指针是“装地址的变量”；引用是“对象的别名”。
  
    ---
  
    是否希望我帮你画一张“内存格子图”，展示指针、引用、原变量三者在内存中的区别？
    那会特别直观（栈上有格子、箭头、名字）。

## Class & Struct

1. **Class并不会增添任何新的功能 可以用类搞定的事 不用类也一样搞得定 类只是语法糖**
   
   1. 面向对象编程 类只是对数据和功能组合在一起的一种方法. **有数据和处理这些数据的函数**
   
   2. 尽量不要用new
      
      - new和不new的区别
        
            > ✅ C++ 的对象（instance）既可以用 new 创建，也可以不使用 new。
            > 
            > 
            > 区别在于 —— **是否在堆（heap）上创建对象，还是在栈（stack）上创建对象。**
            > 
            
            **栈上创建（不使用 `new`）**
            
            ---
            
            ```cpp
            class Person {
            public:
                Person() { std::cout << "constructed\n"; }
                ~Person() { std::cout << "destructed\n"; }
            };
            
            int main() {
                Person p;   // ✅ 栈上创建
            }               // 作用域结束时自动销毁
            
            ```
            
            📍 特点：
            
            - 内存在 **栈（stack）** 上自动分配；
            - 离开作用域时自动调用析构函数；
            - 不需要 `delete`；
            - 生命周期由作用域控制；
            - 效率高，不会内存泄漏。
            
            🧠 这就是为什么大多数局部对象、函数参数、临时变量都**不需要 new**。
            
            **堆上创建（使用 `new`）**
            
            ---
            
            ```cpp
            Person* p = new Person();  // ✅ 堆上创建
            // ...
            delete p;  // ⚠️ 必须手动释放，否则内存泄漏
            
            ```
            
            📍 特点：
            
            - 内存在 **堆（heap）** 上分配；
            - 生命周期不受作用域控制；
            - 必须手动 `delete` 或用智能指针管理；
            - 适合：对象需要跨作用域或动态大小。
            
            🧠 用堆的典型原因：
            
            - 你想让对象在函数返回后仍然存在；
            - 对象很大，不想放在栈上；
            - 动态创建对象数组；
            - 与 C 接口交互（必须使用指针）。
            
            两种方式的内存布局对比
            
            ---
            
            | 创建方式 | 位置 | 生命周期 | 是否自动释放 | 使用场景 |
            | --- | --- | --- | --- | --- |
            | **栈上创建** (`Person p;`) | 栈内存（stack） | 自动，作用域结束时销毁 | ✅ | 临时对象、局部变量 |
            | **堆上创建** (`new Person`) | 堆内存（heap） | 手动控制 | ❌（需要 delete 或智能指针） | 跨函数使用、动态对象 |
            
            ---
            
            示例：两种创建方式的区别
            
            ```cpp
            void test() {
                Person p1;               // 栈上对象（自动销毁）
                Person* p2 = new Person; // 堆上对象（需手动释放）
            } // 函数结束：p1 自动析构；p2 内存仍存在（泄漏！）
            
            ```
            
            💀 如果你忘记：
            
            ```cpp
            delete p2;  // 没写 → memory leak!
            ```
            
            现代 C++ 推荐写法（智能指针替代裸 `new`）
            
            ```cpp
            #include <memory>
            
            void test() {
                auto p = std::make_unique<Person>(); // 堆上分配，但自动释放
            } // 离开作用域自动 delete
            
            ```
            
            或者共享资源：
            
            ```cpp
            auto p = std::make_shared<Person>();
            
            ```
            
            ✅ 推荐理由：
            
            - 安全（自动释放）
            - 可控（共享引用计数）
            - 不需要显式 delete
            
            ---
            
            ---
            
            ✅ **一句话总结：**
            
            > C++ 的 instance 可以不需要 new。不用 new 时，对象在栈上创建，由系统自动销毁。用 new 时，对象在堆上创建，需要你手动或用智能指针管理。现代 C++ 推荐：尽量不用裸 new，用智能指针或栈对象。
            > 
            
            ---
      3. 创建类时 可以指定类中内容的可见性 **默认情况下都是private** 

2. Struct 基本和class无区别， struct的成员 默认为public

3. plain old data(POD) 一种**只表示变量的结构 不包含大量功能 倾向于使用struct** 这种分组只是为了让我们的代码更容易使用

4. **先在主函数中写需求 然后再回到类里写方法**

```jsx
class Log {
public:
    const int LogLevelError = 0;
    const int LogLevelWarning = 1;
    const int LogLevelInfo = 2;
private:
    int m_loglevel =  LogLevelInfo;

public:
    void setLevel(int level) {
        m_loglevel = level;
    }
    void Info(const char* message) {
        if (m_loglevel == LogLevelInfo) {
            std::cout << "[INFO]" << message << std::endl;

        }
    }
    void Warning(const char* message) {
        if (m_loglevel == LogLevelWarning) {
            std::cout << "[WARNING]" << message << std::endl;
        }
    }
    void Error(const char* message) {
        if (m_loglevel == LogLevelError) {
            std::cout << "[Error]: " << message << std::endl;
        }
    }
};
```

## Static

1. `static`就说明这个函数只在当前cpp文件里会被使用 其它cpp文件里都不会用到 那么它就不用参与链接 其他cpp文件就不使用
   
   1. **class和struct外部： 声明的静态函数或静态变量 只会在它被声明的cpp文件中(translation unit)被看到**
      
      1. 什么情况下你会在class中使用private 你就什么情况下使用static静态变量 
      2. **尽量减少全局变量** 如果没有设定为static 那么链接器就会跨编译单元进行链接 **尽量将函数和变量标记为静态 除非你真的需要它们跨翻译单元链接**
   
   2. class和struct内部：
      
      1. static在类或者结构体中 在类的所有实例中 **这个变量只存在一次(即共享这个单例的变量)**
         
         ```jsx
          // 访问类实例，直接获得对应的类变量；
          Entity::x = 2;
          Entity::y = 3;
         ```
         
         static method cannot access non-static variable;
   
   3. PS: Java 中 `static` 关键字表示“**属于类本身，而不是属于某个对象实例**”的成员；JVM 在类加载时就在**方法区（Metaspace）**中为其分配唯一存储空间。

2. 单例模式：

```jsx
class Singleton {

private:
    static Singleton* s_singleton;

    Singleton(){
        std::cout << "Singleton" << std::endl;
    }

public:
    static Singleton& Get(){
        if (!s_singleton) {
            //new Singleton() —— 在堆（heap）上分配一块内存；
            //调用 Singleton 的构造函数；
            //返回一个指向这块内存（也就是这个新对象）的 指针(Singleton*)；
            //把这个指针赋值给 s_singleton。
            s_singleton = new Singleton();
        }
        return *s_singleton;
    }

    void Hello() {
        std::cout << "Hello" << std::endl;

    }
};

Singleton* Singleton::s_singleton = nullptr;
```

| 部分            | 含义                          |
| ------------- | --------------------------- |
| `Singleton*`  | 指定类型：一个指向 `Singleton` 对象的指针 |
| `Singleton::` | 告诉编译器，这个变量属于 `Singleton` 类  |
| `s_singleton` | 变量名                         |
| `= nullptr`   | 初始化为 “空指针”                  |

## Enums

1. 数值的集合 是给一个值命名的一种方法 
   
   1. 将一组数值集合作为类型 而不仅仅是用整型作为类型
      
      ```jsx
      enum Example: unsigned char{
       // 默认A = 0, B = 1, C = 2 -> 递增
       A , B  , C
      };
      ```

2. Log的改进:
   
   ```jsx
   public:
       enum Level
       {
           //倾向于显式地写成=0 虽然它默认就是=0 仅仅为了提高代码可读性
           LevelError = 0, LevelWarning, LevelInfo
       };
   private:
       Level m_LogLevel = LevelInfo;
   
   // 在主函数里调用时 不再用log.LogLevelError 
   // 而是Log::LevelError 
   // 因为我们在Log这个类的命名空间中 有一个枚举数叫Error 
   // 枚举Level本身并不是一个命名空间 不是枚举类 
   // 暂时先不讲枚举类 所以Error Warning Info只存在于这个Log类中
   
   // 原本是
   // public:
   //     const int LogLevelError = 0; // Error级别
   //     const int LogLevelWarning = 1; // Warning级别
   //     const int LogLevelInfo = 2; // Info级别
   //
   //private:
   //    int m_LogLevel = LogLevelInfo;
   ```

## Constructors

1. 未初始化的话,就会出现随机值, 在类里可以写很多构造函数 当然参数需要是不一样的 这叫**函数重载(Overloading), 即有相同的函数/方法名 但有不同参数的不同函数版本**

```jsx
class Entity
{
public:
    float X, Y;

    Entity()
    {
        X = 0.0f;
        Y = 0.0f;
    } // 不再需要init方法了

    void Print()
    {
        std::cout << X << ", " << Y << std::endl;
    }
};
```

1. c++ 默认提供一个初始化构造, 如何禁用:
   
   1. `Log() = delete;`  delete就是禁用default的函数

2. Deconsturctor: 析构函数是卸载变量等东西 并清理使用过的内存
   
   ```jsx
   class Entity {
   private:
       int x, y;
   public:
       Entity(int x, int y) {
           this->x = x;
           this->y = y;
       }
       ~Entity() {
           std::cout << "Entity is been descontructed" << std::endl;
       }
   
       void Print() {
           std::cout << x << y << std::endl;
       }
   };
   
   ```
   
    如果用new分配一个对象 调用delete 析构函数会被调用
    析构函数前面有`~`， 只有主函数退出时 析构函数才会被调用 所以也看不到析构函数打印的那句话 都放到函数里

## Inheritance

1. 相互关联的类的层级结构 有一个包含公共功能的基类 防止代码重复 然后从基类或者父类派生一些类

```jsx
#include <iostream>

class Entity {
public:
    float X, Y;

    void Move(float xa, float ya) {
        X += xa;
        Y += ya;
    }
};

class Player : public Entity {
public:
    const char* Name;

    void PrintName() {
        std::cout << Name << std::endl;
    }
};

int MockMain() {
    //不只是有char的4bytle，还有float的byte(4); 
    std::cout << sizeof(Player) << std::endl;
    Player player;
    player.Move(5,5)

}
```

任何Entity类中不是私有的东西 都可以被Player类访问 在Player类里只需要写新的东西, 

Player 也是一个Entity 所以我们可以在任何想要使用Entity的地方使用Player 可以把Player类的实例传给适用于Entity类作为参数的函数

## Polimorphism

1. 多态（polymorphism）指同一接口可有不同实现，分为编译时多态（overloading）和运行时多态（overriding）。
2. 在 C++ 中，编译时多态通过函数重载或模板实现，运行时多态则依赖 `virtual` 关键字。若未声明为 `virtual`，函数调用在编译时静态绑定；声明为 `virtual` 后，会在运行时根据对象的实际类型进行动态绑定。C++ 允许显式控制是否启用多态，也支持运算符重载等高级特性。
3. 在 Java 中，几乎所有非 `static`、非 `final`、非 `private` 的方法默认都是虚函数，天然具备动态绑定能力。方法重载对应编译时多态，而方法重写实现运行时多态。Java 不需要 `virtual` 关键字，因为 JVM 自动支持动态派发。
4. `virtual` 与 `abstract` 的区别在于：`virtual` 表示“可以被重写”，有默认实现；`abstract` 表示“必须被重写”，没有方法体且所在类无法实例化。Java 的普通方法相当于 C++ 的虚函数，而抽象方法则相当于强制重写的虚函数。
5. 总体上，C++ 的多态是显式可控的，而 Java 的多态是默认自动的。C++ 更灵活、可优化底层性能；Java 更安全、封装性更强。

## Virtual Function

1. B是A的子类 如果在A类中创建一个方法 标记为vitual 就可以在B类中重写这个方法

```jsx
#include <iostream>

class Entity {

public:
    std::string getName() {
        return "Entity";
    }
};

class Player : public Entity {

private : 
    std::string m_Name;
public:
    Player(const std::string& name)
        : m_Name(name){}

    std::string getName() { return m_Name; }
};

int mockmain() {
    Entity* e = new Entity();
    std::cout << e->getName() << std::endl;

    Player* p = new Player("123");
    std::cout << p->getName() << std::endl;

    Entity* entity = p;
    std::cout << entity->getName() << std::endl;

}
```

1. `Player(const std::string& name) : m_Name(name) {}`
   
   1. 构造函数接受一个常量引用参数name `:`表示初始化列表开始, `m_Name(name)`表示用参数name初始化成员变量m_Name
   2. 成员变量m_Name在对象创建时直接通过参数构造 而非先默认构造再赋值 避免默认构造 + 赋值的双重操作
   3. 等效于 先默认构造 再赋值

2. `new Entity()`会在堆上动态分配一个Entity对象 并返回其内存地址/指针 因此必须用指针变量`Entity*`来接收, 堆上动态分配 `Entity* e = new Entity();` 搭配 `e->GetName();`
   
   1. 或者在栈上创建`Entity e;` 搭配 `e.GetName();`

3. `->`是指针访问成员的语法糖 `e->GetName()`等效于`(*e).GetName()`

4. `Entity* entity = p;` p是Player类型的指针 把它赋值给了Entity类型的指针entity 
   
   1. 基类指针直接指向派生类对象 这是安全的 称为向上转型 Player对象的内存布局中包含Entity的基类部分
      `Entity* entity = p;` 为什么`entity->GetName()` 会得到entity而不是123？
      我们可以知道 entity和p都是指针 通过赋值 它们的地址一定是相同的 但是p能访问m_Name 而entity不能 entity的静态类型是Entity* 
      **编译器只允许通过它访问Entity类的成员 比如GetName()无法直接访问Player类的m_Name**

```jsx
class Entity {

public:
    virtual std::string getName() {
        return "Entity";
    }
};

class Player : public Entity {

private : 
    std::string m_Name;
public:
    Player(const std::string& name)
        : m_Name(name){}

    std::string getName() override { return m_Name; }
};

```

1. 虚函数 Dynamic Dispatch 动态联编 通过v表/虚函数表来实现编译 v表就是一个表 包含基类中所有虚函数的映射 这样就可以在运行时 将它们映射到正确的覆写/override函数 
   1. 如果想覆写一个函数 就必须**将基类中的基函数标记为虚函数 在前面加上virtual 将覆写函数标记为关键字override** 只有虚函数才能被overrdie
   2. 虚函数是有运行成本的 首先需要额外的内存来存储v表 这样就可以分配到正确的函数 基类中要有一个成员指针 指向v表 以及每次调用虚函数时 要遍历这个表 来确定要映射到哪个函数

## Interface

1. 纯虚函数允许我们在基类中定义一个没有实现的函数 然后强制子类去实现该函数.
2. 接口类只包含未实现的方法 所以基本上不能实例化

```jsx
class Entity
{
public:
    virtual std::string GetName() = 0; //修改了
};

class Player : public Entity
{
private:
    std::string m_Name;
public:
    Player(const std::string& name)
        : m_Name(name) {}

    std::string GetName() override { return m_Name; }
}
```

仍然是virtual `=0` 意味着它必须在一个子类中实现

## Visibility(Scope)

1. `private` , `proctect`ed , `public`
2. private就是只有自己这个类内部可见 这个类的实例不可见 继承了这个类的子类也不可见 但是还有这个类的friend这种东西 也可以对private内容读取和写入 暂时不讨论
3. protected比private更可见 比public更不可见 这个类和它的子类可见 这个类的实例不可见
4. public 所有人都可以访问

## Array

1. 数组是连续的内存 小端序现在已经填充上了01234 每个数据都是int 4字节

2. `example[i]`来访问特定索引时:
   
   1. 实际上是对example这个指针的地址取了一个偏移量bias, 比如对于`example[2]`就是对这个地址+2*4字节(int)的偏移量
      
      ```jsx
      int* ptr = example;
      
      //ptr+2不是加2个字节的 而是加了2*4个字节
      example[2] = 5;
      *(ptr + 2) = 6;
      ```
   
   2. ptr是int类型的指针 于是ptr+2 的结果是指针移动2个int的距离 不是加2个字节 是移动 2*sizeof(int) 个字节
   
   3. 如果真的想**对字节进行操作 就把指针转换成一个字节的char类型** 做偏移 最后要把它转回int类型的指针 才能对它赋值

3. 在heap上创建:
   
   1. `int* another = new int[5];` , 不要忘了 `delete[] another`

4. 如何获得size? `int count = sizeof(a) / sizeof(int);`
   
   1. 最好的办法是有一个地方存size, 而不是计算, **栈中为数组申请内存的时候 数组的大小必须是一个编译时就要知道的常量**

5. 线程安全问题：
   
   1. 如果多线程同时调用 badExample()并修改x 需要加锁保护 否则可能导致数据竞争

## Strings

1. 通常字符串里就是很多1个字节的字符 字符串其实就是char类型的字符数组

2. `const char*` 
   
   1. `const char*` 并不是 `string`，但它**经常被当作字符串（string）来用**，因为它**指向一个以 `'\0'` 结尾的字符数组**。
   2. It is allocated to fixed block of memory, 不要修改, 而是重新生成新的而删掉旧的.
   3. 因为**字符串字面量是存储在内存的只读部分的 试图修改会导致未定义行为**

3. ”123”其实是一个const char[4] 隐藏的最后一个字节是0 称为空终止字符 是字符串结束的地方 其实我们不知道字符串到底有多少个字符 就靠从指针开始直到终止符0来计算

4. C++标准库有std::string 它只是一个char* 是一个char数组和一些用来操作char数组的函数
   
   1. 其实就是把`const char*`换成了`std::string` string有一个构造函数 接收`char*`或者`const char*`参数
      
      ```jsx
      std::string str = "hello";
      const char* cstr = str.c_str();   // C++ → C
      
      const char* text = "hi";
      std::string cppstr(text);         // C → C+
      
      ```

5. 字符串append

```jsx
//现在就是将一个指针加到了name上 +=这个操作符在string类中被重载了 所以可以这样写 也可以写成
std::string name = "123";
name += "hello";
//必须将一个操作数显式地转换为std::string 因为C++不允许两个const char*直接相加
```

1. 把字符串传给其它函数

```jsx
//传的不是引用 只不过是把传入的string复制到了函数里 不会影响到传递的原始string
//但是字符串的复制是很浪费时间
void PrintString(std::string string)
{
    string += "h";
    std::cout << string << std::endl;
}
//尽量通过常量引用传递, 常量引用是引用 所以不用复制 const表示我们不会修改它 是只读访问
void PrintString(const std::string& string)
{
    string += "h";
    std::cout << string << std::endl;
}
```

1. \0 是string的结束符号, 必须要有backslash来提示early signal

2. 拼接字符串, 多行字符串(String Literal 总是存储于只读内存中)
   
   ```jsx
   #include <iostream>
   #include <string>
   static int mockMain() {
       const char* s = "Zhuang";
   
       // 如何拼接字符串
       std::string name0 = std::string("ZHuang") + "hello";
       //如果c++ 14后
       std::string name = "Zhuang"s + "hello";
   
       // Multiple line
       const char* mline = R"(zhuang
           hello,
           cool)"
   
       //each char is 1 bytes (8 bits) ;
       const char* ss = u8"zhuang";
   
       //wide char, each char is 2 bytes(16bits), 宽字符，用于 Unicode
       const wchar_t* ws = L"Zhuang";
   
       //16bits char
       const char16_t* s16 = u"Zhuang";
   
       //32bits char
       const char32_t* s32 = U"Zhuang";
   
   }
   ```

3. String Literal 

```jsx
using namespace std::string_literals;
std::string name = "hello"s + " world";
std::string name = u8"hello"s + u8" world";
std::wstring name = L"hello"s + L" world";
std::u32string name = U"hello"s + U" world";
```

“hello”s中的s是一个用户定义的字面量 将字符串字面量（如”hello”)转换为std::string对象 这个功能来自于C++14中的`std::string_literals`命名空间

`std::string`类定义了以下重载：

平时都用`std::string` 只有在和 C 接口或底层内存打交道时，才用`const char*`。

| 场景                    | 推荐做法                                |
| --------------------- | ----------------------------------- |
| 普通文本操作                | ✅ `std::string`                     |
| 控制台输入输出               | ✅ `std::string` + `getline` / `cin` |
| 与旧式 C 库交互             | ⚙️ `s.c_str()` 转成 `const char*`     |
| 底层内存操作（如文件 IO、socket） | ⚙️ 有时用 `const char*`                |
| 不可修改字符串常量             | `const char* s = "text";`           |
| 需要修改字符串               | ✅ `std::string` 或 `char[]`          |

1. `std::string::npos;`表示一个不存在的位置 `name.find("lo")`返回的是lo所在的首位置
   ```**bool** contains **=** name.find("lo") **!=** std**::**string**::**npos;``

## Const

1. `const int* a`或者`int const* a`
    const在*左边 表示指针指向的内容是常量 而指针本身可变
    表示**a是一个指向常量int的指针 指针a本身不是常量 因此可以重新指向其他地址 但*a是常量 无法对*a进行修改**

2. `int* const a`
    const在*右边 表示指针本身是常量 不能改变指向的地址 但指向的内容可以修改
    表示**int型指针a是一个常量 指针指向的地址是不能改变的 但是可以修改指针指向的内容 a是常量 *a不是常量**

3. `const int* const a`
    两个const分别修饰指针和内容 两者都不可变
    表示a是一个指向常量int的常量指针 不能修改指针指向的内容 也不能修改指针指向的地址

```jsx
static void run() {
    // 常量, 不可以修改 MAX_AGE的值
    const int MAX_AGE = 90;

    //常量内容, 不可以修改contents, 不可以dereference改变值, 可以改变pointer的地址;
    const int* a = new int;
    int const* a = new int;

    a = nullptr;

    //常量地址, 不可以修改指向地址, 但可以修改里面的值, 可以用dereferece来改变;
    int* const b = new int;
    *b = 0;


}
```

1. Const 修饰 function: 在类的方法名之后const 意思是这个方法不会修改任何实际的类

```jsx
#include <iostream>
using namespace std;

class Entity {
private:
    int m_x, m_y;  // ✅ 成员变量（每个对象都有自己的一份数据）

public:
    // ✅ const 版本的 get()
    // 表示这个函数不会修改任何成员变量
    // 可被 const 对象调用
    int get() const {
        return m_x;
    }

    // ✅ 非 const 版本的 get()
    // 表示这个函数可以修改成员变量（尽管这里没改）
    // 只能被非 const 对象调用
    int get() {
        return m_x;
    }

    // ✅ setter 函数，用于修改成员变量
    // 注意这里用的是 int* 参数（传指针）
    void set(int* m) {
        m_x = *m;  // 将指针 m 指向的值赋给 m_x
    }
};

// ✅ 普通函数（不是类的成员）
void PrinterE() {
    Entity e;        // 非 const 对象
    int x = e.get(); // ✅ 调用 "非 const 版本" 的 get()

    const Entity e1; // const 对象（内容不可修改）
    int y = e1.get();// ✅ 调用 "const 版本" 的 get()
                     // ⚠️ e1 不能调用非 const 的方法（否则编译错误）

    cout << "x = " << x << ", y = " << y << endl;
}

int main() {
    PrinterE();
    return 0;
}

```

1. function + const的方法是只读 使用的时候可以传const reference 就不用复制
   
   ```jsx
   void PrintEntity(const Entity* e)
   {
       // e现在是一个指向常量Entity的指针
       // 可以修改指针指向的地址 但不能修改它指向的内容 也就是*e
       e = nullptr; // 合法
       std::cout << e.GetX() << std::endl;
   }
   
   // 如果通过常量引用传参 也是一样
   void PrintEntity(const Entity& e)
   {
       // e是一个引用
       // 写e=XXX 并不能修改它指向的内容
       // 因为引用只能在创建的时候初始化指定
       // 并不能后续修改它指向的内容
       // e=XXX 就只是在修改e指向的那个东西
       // 也就实际上等同于是在修改指针指向的内容
       // 既然声明了它指向的东西是const 就不能修改
       e = Entity(); // 不合法 不能修改它的内容
       std::cout << e.GetX() << std::endl;
   }
   ```

NOTES: **如果function没有修改class 或者它们不应该修改类 要总是标记这个方法为const** 这样常量引用才能使用你的方法

## Mutable

1. Mutable: **mutable允许函数是常量方法 但可以修改变量** 基本上在类成员中这样使用 就是它唯一的用法
   
   ```jsx
   class Entity
   {
   private:
       int m_X, m_Y;
       mutable int var;
   public:
       int GetX() const
       {
           var = 2;
           return m_X;
       }
   };
   ```

2. 同样可以在lambda函数中使用mutable, 来确保进入的var可以直接调用;
   
   ```jsx
   auto f = [=]() mutable
       {
           x++; //这里使用了mutable, 就可以直接随便用一个var来++
           std::cout << x << std::endl;
       }
   ```

## Constructor Intializer List

```jsx
- 构造函数用于在对象创建时初始化成员变量。

- 三种常见写法：

  1. `Player() {}`
     → 默认构造函数，不接收参数，成员用默认值构造。

  2. `Player(const std::string& name) { m_Name = name; }`
     → 赋值式初始化：成员先默认构造（空字符串），然后再赋值一次。效率较低。

  3. `Player(const std::string& name) : m_Name(name) {}`
     → 成员初始化列表：成员在对象创建时直接构造。高效、安全，推荐使用。
  但是!    
    确保每次你的初始化和你的声明顺序一致

- 初始化列表的优点：
  - 避免多余的默认构造 + 赋值。
  - 必须用于 `const` 成员或引用成员。
  - 更符合对象“在构造时即完整”的语义。

```

举例说明:

```jsx
#include <iostream>
class Entity {
private:
    int age;
    std::string m_Name;
public:
    Entity()
        : age(0),m_Name("Unknown"){ }
};
```

尽量: **使用初始化列表去初始化**

## Ternary Opeartor

```jsx
static int s_Level = 1;
static int s_Speed = 2;

int main()
{
    if (s_Level > 5)
        s_Speed = 10;
    else
        s_Speed = 5;

    // 更易读的做法 为了避免考虑优先级 用括号吧
    s_Speed = (s_Level > 5 && s_Level < 100) ? 10 : 5;

    std::string rank = s_Level > 10 ? "Master" : "Beginner";

    std::cin.get();
}
```

## Create/Instanstiaed Instance

1. Stack 有自动化生命进程, heap 不具备, 但是空间更大, 但需要手动管理;

```jsx
#include <iostream>
class Entity {
private:
    std::string m_name;

public:
    Entity()
        :m_name("Unknown"){ }
    Entity(const std::string name)
        :m_name(name){ }
    std::string getName() {
        return m_name;
    }
};

int main() {
    // 在Stack上创建Instance;
    Entity e;
    // 在Stack上用构造器创建Instance;
    { Entity e1("Hello"); }
    /**
    * Notice: Stack上创建的Instance, 会自动管理生命进程.
    * 所以它在scope结束时会销毁
    */
    Entity* e2 = &e1; // 这里的e会销毁后重新给e2;

    //在Heap上创建Instance
    Entity* ee = new Entity();

    //这个时候可以直接来指向;
    Entity* e3 = ee; // 这里是address了

    //必须要删除;
    delete ee;
}
```

1. 栈创建 在作用域结束就销毁 但是作用域不止是函数 有{}就算
2. 如果要创建的对象很大 或者希望显式地控制对象生存期 就用堆创建 否则用栈创建 **尽量用栈** 或者用智能指针 暂时不讨论
3. `Entity e2 = Entity("123");`拷贝初始化, 使用`=`进行初始化 语法上会先构造一个临时对象 再通过拷贝/移动构造函数初始化目标对象 C++17开始 编译器会强制省略临时对象的拷贝 称为拷贝省略 直接构造目标对象

## New

1. 写一个new int 需要4个字节的内存 就需要寻找4个字节内存的连续块
2. 不是一行一行搜索内存看有没有4字节连续内存 而是有**空闲列表** 会维护那些有空闲字节地址, 
3. new返回一个指向这个内存的指针
4. new 是 operator, 可以被重载;
   1. 通常 调用new会调用隐藏在里面的C函数malloc 相当于我们写了 `Entity* e = (Entity*)malloc(sizeof(Entity))` 用malloc分配了一个sizeof(Entity)大小的内存 返回void指针 再转换为Entity类型 但是和`Entity* e = new Entity[10];`的区别就是 使用new会调用Entity构造函数 而malloc只是分配内存 **还是优先使用new**
5. 必须要delete!

```jsx
int a = 2;
int* b = new int;
int* c = new int[10]; // 10个元素的数组 40字节

Entity* e1 = new Entity(); // 已经默认构造函数初始化
Entity* e2 = new Entity[10]; // Entity型的数组

delete e1;
delete[] e2;

```

## Implicity Conversion

1. C++支持一次隐式的转换, 如果不支持, 用explicit来标记构造器,使其不支持.

```jsx
#include <string>

class Entity {
private:
    std::string m_name;
    int age;
    int salary;
public:
    Entity()

        :m_name("Undefined"), age(0){ }

    Entity(const int age)
        :age(age){ }

    explicit Entity(const std::string name)// 必须显式的call, 不能支持隐式转换
        :m_name(name){ }
};

int main() {

    std::string s = "ZHuang";
    Entity e1 = s; // 隐式转换, 从 s 转换成 Entity, 因为有构造器
    Entity e2 = 22; // 隐式转换, 从 22 通过age的构造器转换

    // 不支持下面的, 因为 "Zhuang"是const char* 这个需要先转换成string
    // 然后才能转成Entity, C++仅支持1次转换过程;
    Entity e3 = "zhuang"; //  这个是不行的

}
```

## Operator

1. Simple symbol to replace the simple function, 其实就是function
2. Overloang:you Can change behaviour of operator
3. 尽量少用
4. 格式 `Vector operator++()

```jsx
struct Vector2
{
    float x, y;

    Vector2(float x, float y)
        : x(x), y(y) {}

    Vector2 Add(const Vector2& other) const
    {
        return Vector2(x*other.x, y*other.y);
}

    Vector2 operator+(const Vector2& other) const
    {
        return Add(other);
}

    Vector2 Multiply(const Vector2& other) const
    {
        return Vector2(x*other.x, y*other.y);
    }

    Vector2 operator*(const Vector2& other) const
    {
        return Multiply(other);
    }

    bool operator==(const Vector2& other)
    {
        return x==other.x && y==other.y;
    }

    bool operator!=(const Vector2& other)
    {
        return !(*this == other);
    }

};

std::ostream& operator<<(std::ostream& stream, const Vector2& other)
{
// 这是我们要重载的运算符<<的最初定义
// std::ostream& stream 接收的是std::cout
    stream << other.x << ", " << other.y;
    // other.x是浮点数 stream是知道如何打印浮点数的 所以不用对浮点数也进行重载
    return stream;
    // 要返回对stream的引用 因为流对象不可复制 必须使用引用传递
}

int main()
{
    Vector2 position(4.0f, 4.0f);
    Vector2 speed(0.5f, 1.5f);
    Vector2 powerup(1.1f, 1.1f); // 提升速度用

    Vector2 result1 = position.Add(speed.Multiply(powerup));
    Vector2 result2 = position + speed*powerup;
    // 这两个是一样的含义

    if(result1 == result2)
    {
        // do something
    }

    std::cout << result2 << std::endl;
}
```

- 一般就去重载<< (等价于toString) 或者 == (等价于equal)

## This

1. is the pointer to the current object instance that method belongs to;

```jsx
void PrintEntity1(const Entity& e)
{
    // do something
}

void PrintEntity2(Entity* e)
{
    // do something
}

class Entity{
public:
    int x, y;

    Entity(int x, int y)
    {
        // x = x;
        // y = y;
        // 绝对没有办法像上面这样不明所以地写
        this->x = x;
        // 或者
        // (*this).x = x;
        this->y = y;

        PrintEntity1(this);
        PrintEntity2(*this);

    }

    int GetX() const
    {
        return x;
    }
};
```

1. this的类型就是`Entity*` 但如果鼠标悬停在this上 会发现它的类型是`Entity* const` const的意思是this是一个常量指针 指针指向的地址不会改变 但是指向的东西可以改变
2. 如果想在类的内部调用一个类外部的函数 这个函数将Entity作为参数 就可以直接传入this
   1. 非const方法中 可以将this赋值给`Entity& e = *this` 
   2. const方法中可以将this赋值给`const Entity& e = *this`
3. 不要`delete this;` 这之后就再也不能访问类的成员数据

## Life Circle

进入一个作用域 就是在push栈帧 不一定非得是将数据push进栈帧

1. SCope: if for while作用域 空{}作用域 类作用域

2. 当这个类消失时 变量也会消失; 在作用域内栈创建类的实例对象 会调用构造函数 在`}`那行会调用析构函数

3. Scope Pointer
   
   ```jsx
   // 是指针的包装器 在构造时用堆分配指针 在析构时删除指针
   
   class ScopedPtr
   {
   private:
       Entity* m_Ptr;
   public:
       ScopedPtr(Entity* ptr)
           : m_Ptr(ptr) {}
       ~ScopedPtr(){
           delete m_Ptr;
       }
   };
   
   int main()
   {
   
       {
           // Entity* e = new Entity(); 原来是这样创建的 之后再手动删除
           // ScopedPtr e(new Entity()); 利用构造函数
           ScopedPtr e = new Entity();
           //这种是隐式转换写法 将Entity*对象转换为ScopedPtr对象 但是用这种写法就和之前看起来差不多''
           //只要离开作用域 e就会被销毁 因为实际上是在栈上分配的 new Entity()确实是在堆上分配
           // 但是ScopedPtr的构造函数接收这个堆指针 又通过析构函数负责释放它
       }
   
   }
   ```

## Smart Pointer

1. Smart Pointer 就是自动管理内存(会自动删除的)的pointer
2. `unique_ptr` 不可复制
   1. 如果复制 unique_ptr 就会有两个指针指向同一个内存块 
   2. 如果有一个被销毁了 另一个就会变成指向已经释放了的内存

```jsx
#include <memory>
#include <string>
#include <iostream>
class Entity {
private:
    std::string m_name;

public:
    Entity()
        :m_name("Undefined"){ }

    Entity(const std::string& name)
        :m_name(name){ }

    void Printer() const {
        std::cout << m_name << std::endl;
    }
};

int uniquePointer() {
    {
        std::shared_ptr<Entity> e0;
        {    
            // Unique Pointer
            // 这个是更最好的创建方式, 防止出现悬空指针
            std::unique_ptr<Entity> entity = std::make_unique<Entity>();
            entity->Printer();

            //Share Pointer
            //Reference counting-> 一个计数器会记录多个reference,
            //计数器归零, 则该pointer删除;
            std::shared_ptr<Entity> sharedEntity = std::make_shared<Entity>();

            //可以拷贝
            e0 = sharedEntity;

            //Weak Entity
            //没有计数器的shared Pointer, 你不自己控制这个, 所以当它的原有消失时,
            //你也就没了
            std::weak_ptr<Entity> weakEntity = sharedEntity;
        }
        // Block 结束后, 一起删除
    }
}
```

## Copying and Copy Construction

1. copy waste time and performance

2. **拷贝构造（copy constructor）**
    当用一个对象初始化另一个对象时触发，例如：
   
   ```cpp
   Entity e1(5);
   Entity e2 = e1;  // 调用拷贝构造
   
   ```
   
    默认是“浅拷贝”，逐个复制成员变量。

3. **拷贝赋值（copy assignment）**
    当一个已存在的对象被另一个对象赋值时触发，例如：
   
   ```cpp
   Entity e1(5), e2(10);
   e2 = e1;  // 调用拷贝赋值运算符
   
   ```
   
    表示把 e1 的内容复制到 e2 中。

4. **浅拷贝（shallow copy）**
    默认行为，仅复制对象的成员值（包括指针地址），不会新建独立内存。
    如果成员中有指针，会导致多个对象指向同一块内存。

5. **深拷贝（deep copy）**
    自定义拷贝逻辑，为每个对象分配新的内存并复制内容：
   
   ```cpp
   Example(const Example& other) {
       data = new int(*other.data);
   }
   
   ```
   
    用于避免指针共享导致的内存冲突。

6. **按值传参（by value）**
    函数形参不是引用或指针时，传递对象会触发拷贝构造：
   
   ```cpp
   void func(Entity e); // 会拷贝参数
   
   ```

7. **按引用或指针传参（by reference / by pointer）**
    不会发生拷贝，只传递地址：
   
   ```cpp
   void func(Entity& e);   // 引用，不拷贝
   void func(Entity* e);   // 指针，不拷贝
   
   ```

8. **移动语义（move semantics）**
    使用 `std::move()` 可触发“资源转移”而非复制：
   
   ```cpp
   Entity e1(5);
   Entity e2 = std::move(e1); // 调用移动构造
   
   ```
   
    节省内存与性能，但 e1 的资源会被清空或置为无效。

9. `friend` 是 C++ 里一个比较“特别”的关键字，它表示 **“友元”** —— 一种**打破封装边界、允许访问私有成员**的机制。“即使你不是我的成员函数，我也信任你，可以访问我的 private 和 protected 成员。”
   
   1. **只有被声明为 `friend` 的那个函数（或类）本身**，

```jsx
class Entity {
private:
    int x = 10;  // 私有成员

public:
    friend void print(const Entity& e); // 声明友元函数
};

void print(const Entity& e) {
    std::cout << e.x << std::endl;  // ✅ 可以访问 private 成员
}
```

1. 如果传递Object或者string, 永远用引用传递, 不要用copy

```jsx
#include <iostream>

class String {
private:
    char* m_Buffer;
    // 无符号数`unsigned`那就是从0到 2^32^
    unsigned int m_Size;
public:
    String(const char* string ){

        //获得长度
        m_Size = strlen(string);
        // 创建char数组 , +1 size是增加终止符号为\0;
        m_Buffer = new char[m_Size + 1];
        //进行逐字符拷贝, 类似for(){char[i] = stirng[i]}的操作;
        memcpy(m_Buffer,string,m_Size+1);

         // 如果不能保证string这个字符串有空终止符
      // 就要添加一句
      // m_Buffer[m_Size] = 0;
    }
    // 提供一个copy contructor, 来避免出现多指针指向同一个block的情况;
    String(const String& other) 
    :  m_Size(other.m_Size){
        m_Buffer = new char[m_Size + 1];
        memcpy(m_Buffer, other.m_Buffer, m_Size+1);
    }

    // 如果不想支持copy
    // 这里是和unique_str不允许复制的内部实现很相似
    //String(const String& ohter) = delete;

    ~String() {
        delete[] m_Buffer;
    }
    // 这个是用来提供string 修改能力
    char& operator[](unsigned int index) {
        return m_Buffer[index];
    }
    // friend 友元 支持同名函数,访问private和protected的成员;
    friend std::ostream& operator<<(std::ostream& stream, const String& string);
};

std::ostream& operator<<(std::ostream& stream, const String& string) {
    stream << string.m_Buffer;
    return stream;
}

int main() {
    String string = "ZHuang";
    // 这里如果没有deep拷贝contsructor就会出现, 多个pointer指向同一个block情况
    String a = string; 

}
```

## Arrow

1. ptr只是一个指针 一个数值 不是对象 不能调用方法,
2. **成员访问运算符（member access operator for pointers）**，它的作用是：**通过指针访问对象的成员（变量或函数）**

| 写法              | 含义                            |
| --------------- | ----------------------------- |
| `obj.member`    | 对象直接访问成员                      |
| `ptr->member`   | 通过指针访问成员（相当于 `(*ptr).member`） |
| `(*ptr).member` | 完整写法，但不常用，因为要加括号防止优先级错误       |

```jsx
// 手写智能指针
class ScopedPtr
{
private:
    Entity* m_Obj;
public:
    ScopedPtr(Entity* entity)
        : m_Obj(entity) {}

    ~ScopedPtr()
    {
        delete m_Obj;
    }

    Entity* operator->()
    {
        return m_Obj;
    }

    // 也需要写一个const版本
    // 后续创建e3时使用了这个版本
    const Entity* operator->() const
    {
        return m_Obj;
    }

};

int main()
{
    Entity* e1 = new Entity();
    e1->Print();
    // 如果不用智能指针 就是像上面那样写
    // 但如果用自己写的智能指针 就要重载运算符->
    ScopedPtr e2 = new Entity();
    e2->Print();

    const ScopedPtr e3 = new Entity();
    e3->Print();

    std::cin.get();
}
```

- 使用-> 获取内存中某个成员变量的偏移量: 每一个float有4个字节 所以x的偏移量是0 y的偏移量是4 z是8 但如果你不知道类内部的变量顺序 就不知道偏移量了

```jsx
int offset = (int)&(((Vector3*)0)->x);

// (Vector3*)nullptr：将空指针nullptr强制转换为Vector3*类型指针 此时指针值为0
// ->x：访问该指针指向的Vector3对象的成员变量x
// &(...->x)：获取成员变量x的地址
// (int)：将地址转换为整数类型
```

这里nullptr也可以写成0
nullptr只能用于表示空指针 不能表示空整数或其他类型 它的设计初衷是解决0作为空指针时的类型歧义问题

最后计算出来x的偏移量是0

空指针的地址被假设为0 成员变量x的地址=空指针地址(0)+x在Vector3中的偏移量
即 &(nullptr->x) = 0 + offset_of(x)

## Vector

`std::vector` 的创建方式有多种：

* **默认构造**：`std::vector<int> v;` 创建空向量。

* **指定大小**：`std::vector<int> v(5);` 创建 5 个默认值（int 为 0）。

* **指定大小与初始值**：`std::vector<int> v(5, 10);` 创建 5 个值为 10 的元素。

* **列表初始化（C++11 起）**：`std::vector<int> v{1, 2, 3, 4};` 或 `= {1, 2, 3, 4};`。

* **拷贝构造**：`std::vector<int> v2(v1);` 或 `std::vector<int> v2 = v1;`。

* **迭代器范围构造**：`std::vector<int> v(v1.begin(), v1.begin() + 3);` 从另一容器部分复制。

* **移动构造（C++11 起）**：`std::vector<int> v2(std::move(v1));` 高效转移资源。

* **assign 赋值初始化**：`v.assign(5, 100);` 或 `v.assign({1,2,3});` 重置内容。

* **从数组构造**：`int arr[] = {1,2,3,4}; std::vector<int> v(arr, arr+4);`。

* **动态添加元素**：使用 `push_back()` 或 `emplace_back()` 逐个加入元素。

总结：  
`std::vector` 可以通过构造函数、初始化列表、迭代器范围、assign 或动态添加来创建与初始化，灵活适应不同场景。





1. 存储vector对象比存储指针在技术上更优 vector对象的内存分配是线性的 是内存连续的数组 这样再去操作会很容易 因为都在同一个cache line上 **优先存储对象**
2. 唯一的问题是 如果要调整单个vector的大小 就要复制所有的数据 会比较缓慢 而如果是指针 实际的内存保持不变 因为你只是保存了一系列指向内存的指针 调整大小的时候 数据仍然存储着 当vector需要扩容时 它会分配一块更大的连续内存 并将原有的指针值（即内存地址）复制到新内存中 指针指向的实际对象不会被复制或移动 它们仍驻留在原有的内存位置 而由于指针的大小固定 只取决于你的系统是多少位的 复制速度极快 扩容开销低
3. **将vector传给函数或者类或者什么其它东西的时候 要确保是用引用传递 如果只读就用常量引用**

```jsx
#include <vector>
#include <iostream>

struct Vertex {
    float x, y, z;
};
// 不要拷贝,使用reference
void calcualte(std::vector<Vertex>& vertices) {

}

int main() {

    std::vector<Vertex> vertices;
    vertices.push_back({ 1,2,3 });
    vertices.push_back({ 4,5,6 });

    for (Vertex v : vertices) {
        std::cout << v.x << std::endl;
    }

    //删除时需要从开始找下面的偏移量, 而不是直接删除索引
    vertices.erase(vertices.begin()+1)


}
```

## Optimizing Vector

```jsx
#include <vector>
#include <iostream>

struct Vertex {
    float x, y, z;
};
// 不要拷贝,使用reference
void calcualte(std::vector<Vertex>& vertices) {

}

int main() {

    std::vector<Vertex> vertices;

    vertices.reserve(3);// 这里就初始化的size为3, 避免不必要的resize;
    // 如果没有reserve, 就会每次假如都resize一次
    // 
    // 这里使用emplace_back, 可以让vertex自动创建<Vertex>, 就不出现copy了
    vertices.emplace_back(1, 2, 3); 

    //会出现不必要的copy, 如果没有预定义的size, 
    // 每次push都会copy一次, resize又会cop一次
    vertices.push_back(Vertex({1, 2, 3}));
    vertices.push_back({ 4,5,6 });
    vertices.push_back({ 7,8,9 });

    for (Vertex v : vertices) {
        std::cout << v.x << std::endl;
    }

    //删除时需要从开始找下面的偏移量, 而不是直接删除索引
    vertices.erase(vertices.begin() + 1);

    std::cin.get();

}
```

1. `vertices.push_back({1, 2, 3})`
    用**聚合初始化隐式构造**一个临时Vertex对象{1, 2, 3} 当然也可以用`vertices.push_back(Vertex(1, 2, 3));`显式构造 无论显式还是隐式构造 都是调用了Vertex的构造函数 最后要把临时对象从栈帧拷贝到真实的那个Vector所在的内存中 实际上是**在main函数的栈帧中构造了这个临时Vertex对象** push_back尝试将这个临时对象添加到vector中 而vector初始为空 容量为0 就需要扩容 **vector的元素是存储在堆内存中 与main栈帧无关** 所以要分配堆内存 容量为1 然后**将main栈帧中的临时对象拷贝构造到vector的堆内存中** 触发拷贝构造函数 输出一个Copied! **main栈帧中的临时对象在表达式结束之后销毁**
    此时 vector size=1 capacity=1

2. `vertices.push_back({4, 5, 6})`
    隐式构造第二个临时Vertex对象{4, 5, 6} 当前vector容量为1 但需要存储2个元素 需要**扩容** 新容量为2*capacity=2 **将原有元素从旧的堆内存拷贝构造到新的堆内存** 输出一个Copied! 将新临时对象{4, 5, 6}从main栈帧拷贝构造到新的堆内存 输出一个Copied! 然后销毁旧内存中的元素 此时vector size=2 capacity=2

## Local Static

    void foo() {
        static int counter = 0; // ← 这是一个 local static 变量
        counter++;
        std::cout << counter << std::endl;
    }

在 C++ 里，local static（局部静态变量）是定义在函数或代码块内部、但用 `static` 修饰的变量。它只在定义**它的作用域内可见**，但它的**生命周期贯穿整个程序运行期**。

当程序第一次执行到定义语句时，local static 变量会被初始化；之后即使函数多次调用，也不会再次初始化。它被存放在静态存储区，而不是栈上，因此函数返回后它的值仍然保留。

普通局部变量在每次函数调用时都会被重新创建并销毁，而局部静态变量只会创建一次。举个例子：
    void test() {
        static int count = 0;
        count++;
        std::cout << count << std::endl;
    }

多次调用 `test()`，输出将依次是 1、2、3，因为 `count` 的值会被保留。

它常用于计数器、单例模式的实例保存或结果缓存等场景。
    class Singleton{
    public:
        static Singleton& Get()
        {
                Singleton instance;
                return instance;
        }
        void Hello(){}
        }

## Libaries

1. 在 C++ 里，**static library（静态库）** 和 **dynamic library（动态库）** 的主要区别在于：**编译时绑定** 和 **运行时加载**。

2. 倾向于在实际解决方案的项目文件夹中 保留使用的库的版本
    docs // 官方文档
    include // 头文件 GLFW/glfw3.h 和 GLFW/glfw3native.h
    lib-mingw-w64 // 为 MinGW-w64 编译器预编译的库文件
    lib-static-ucrt // 稍后介绍
    lib-vc2013
    lib-vc2015
    lib-vc2017
    lib-vc2019
    lib-vc2022 // 为 Visual Studio 2022 编译的 动态库
    LICENSE.md
    README.md
* 这是C++库的典型文件组织结构 有不同编译器编译出来的库文件 mingw-w64和很多版本的visual studio
* 库通常有两部分 includes(包含目录)和library(库目录)
* includes是一堆头文件 这样我们就可以实际使用预构建的二进制文件中的函数
* lib中有那些预构建的二进制文件 分为静态库和动态库 但也不是所有的库都会提供这两种库 可能只有一种 但是glfw提供了两种 你可以选择静态链接还是动态链接
* 在解决方案文件夹里 创建名为dependencies的文件夹 依赖项 也就是库文件的目录 在这个文件夹里 创建一个名为GLFW的文件夹 把GLFW库的include和lib-vc2022文件夹复制到这里 打开lib-vc2022文件夹

`extern` 是 C/C++ 中用于**声明外部符号**的关键字，意思是：

> “这个变量或函数在别的文件里定义，我这里只是声明它一下。”

* **你希望用户完全无需处理dependency.dll的问题:**
  * **唯一的解决方案就是将这个依赖库也静态链接** 也就是把dependency.dll替换成静态库版本dependency.lib 这样用户在编译时就只需要链接你的这个库
  * 不用再处理dependency.dll的事情 代价是 你的静态库体积增大了 这是你需要取舍的
* 什么是运行时库？
  * 运行时库（Runtime Library）是编译器提供的基础函数库 所有程序都需要它们 你的程序在运行时必须依赖这些库才能正常工作 它们包含了许多核心功能 比如 malloc free printf fopen strcpy strlen 等等

**>> 如果头文件在Visual Studio中 在解决方案中的某个地方 无论是不是在同一个项目里 但同属一个解决方案 就使用”“**

**>> 如果是一个完全的外部依赖 外部的库 不在Visual Studio中和我的实际解决方案一起编译 那就用<> 表明它是外部的 然后通过项目属性中设置附加包含目录来让编译器找到它 所以可以通过设置附加包含目录来同时使用多个头文件**

## Static lib

右键项目 - 属性 - 链接器 - 输入 - 附加依赖项 编辑填入
    glfw3.lib

在链接器 - 常规 - 附加库目录 编辑填入
    $(SolutionDir)dependencies\GLFW\lib-vc2022

头文件删除了 但头文件能提供的也就只有函数声明

而我自己写了一个声明 所以不再需要头文件 编译器也能知道glfwInit是存在的 在编译时它就自动搜索项目依赖的库文件 来找到glfwInit的二进制实现

C++支持函数重载 编译器会对函数名进行修饰 使用签名

比如glfwInit可能被编译为_Z8glfwInitv 来区分不同参数类型的同名函数 而GLFW是使用C编写的库 函数名在这个库里就是glfwInit `extern "C"`就是告诉编译器 这个函数使用C的链接规则 不要对函数名进行修饰 这样链接器就可以找到GLFW库中的函数实现

头文件提供声明 告诉我们哪些函数是可用的

库文件提供函数定义 这样就可以链接到具体的函数

## Dynamic Lib

对于动态库 有两种形式

1. 静态的 动态库版本 我已经知道里面有什么函数 我可以使用什么
2. 任意加载这个动态库 甚至不知道里面有什么

*操作流程：*

* 右键项目 → 属性 → C/C++ → 常规 ： 我们的附加包含目录仍然和静态链接一样
  
  * 属性→链接器→ 输入→ 附加依赖项:
    
    * **静态链接中我们写入的是glfw3.lib**
    * ***动态链接中我们要写入动态库的导入库 glfw3dll.lib***
  
  * 生成项目会报错, 提示找不到glfw3.dll
    
    * 复制dll 把dll和可执行文件exe放在一起 就可以正常使用了 可执行文件的目录是一种自动搜索路径
    
    /* GLFWAPI is used to declare public API functions for export
    
    * from the DLL / shared library / dynamic library.
      */
    
    #if defined(_WIN32) && defined(_GLFW_BUILD_DLL)
     /* We are building GLFW as a Win32 DLL */
    // 在 Windows (_WIN32) 且正在 构建 GLFW 为 DLL (_GLFW_BUILD_DLL)
     #define GLFWAPI __declspec(dllexport)
    // __declspec(dllexport) 告诉编译器：导出此函数 使其可在 DLL 外部调用
    #elif defined(_WIN32) && defined(GLFW_DLL)
     /* We are calling a GLFW Win32 DLL */
    // 在 Windows (_WIN32) 且 用户代码通过 DLL 使用 GLFW (GLFW_DLL)
     #define GLFWAPI __declspec(dllimport)
    // __declspec(dllimport) 告诉编译器：此函数从 DLL 导入 优化调用效率
    #elif defined(__GNUC__) && defined(_GLFW_BUILD_DLL)
     /* We are building GLFW as a Unix shared library */
    // 使用 GCC/Clang (__GNUC__) 且正在 构建 GLFW 为共享库 (_GLFW_BUILD_DLL)
     #define GLFWAPI __attribute__((visibility("default")))
    // visibility("default") 强制函数在共享库中可见（默认情况下 GCC 会隐藏符号）
    #else
    // 静态链接或非动态库场景
     #define GLFWAPI
    // GLFWAPI 定义为空 函数使用普通声明（无特殊导出/导入逻辑）
    #endif

* Define的用途 非常好的问题。你抓到了 C/C++ 宏系统里一个很本质的点。 `#define _WIN32` 之所以存在，不是为了“替换成某个值”，而是为了**“作为一个标志（flag）”**。 也就是说，它的存在本身就代表“我现在是在 Windows 平台编译”。它不需要替换内容的原因
  
  * * *
  
  当我们写：
  
      #define _WIN32
  
  它定义了一个名字 `_WIN32`，但不给任何值。 这叫“空宏”，只是告诉编译器：

> “_WIN32 这个符号现在是存在的。”

  然后在其他地方，代码可以通过：
      #ifdef _WIN32
          // 如果是 Windows 平台就执行这里
      #endif

  或者：
      #if defined(_WIN32)
          // 同上
      #endif

  来判断是不是 Windows 环境。 所以它就像一个“开关”：

* 定义了 → 表示“是 Windows”

* 没定义 → 表示“不是 Windows”
  
  * * *
  
  可以把它想成一面旗子。 “挂上旗子”就表示“这里是 Windows”； “没挂旗子”就表示“不是 Windows”。 旗子本身没有数值含义，但别的代码可以通过“有没有旗子”来决定行为。
  
  * * *
  
  Visual Studio、MinGW 等编译器在编译时会自动加上：
  
      /D _WIN32
  
  这就是在告诉预处理器“定义一个名为 _WIN32 的宏”，所以你代码里能检测到它。
  
  * * *
  
  `#define _WIN32` 并不是为了替换文本，而是为了在预处理阶段提供一个**平台标志**。 它的存在与否，用来让代码知道自己是在 Windows、Linux 还是 macOS 上编译。

你这段话其实在总结几个知识点，但信息太密集了，我帮你拆成几个简单点的意思讲：

* * *

**第一部分：这些宏是怎么“被定义”的？**

1. `_WIN32` → 当你用 Windows 平台的编译器（例如 Visual Studio、MSVC、MinGW）时， 编译器会**自动定义**这个宏。 所以不需要你写 `#define _WIN32`，系统自己加上了。

2. `_GLFW_BUILD_DLL` → 这个是 **GLFW 在自己被编译为动态库（DLL）时** 才会定义的。 比如你用 CMake 编译 GLFW，并且勾选 “BUILD_SHARED_LIBS=ON”， 它会自动在编译命令里加上 `-D_GLFW_BUILD_DLL`。 所以这个宏是**在编译 GLFW 源码本身时**定义的。

3. `GLFW_DLL` → 这个是给**你作为 GLFW 的使用者**定义的。 当你想用动态库（DLL）版本的 GLFW 时， 需要在包含头文件之前写：
      #define GLFW_DLL
      #include <GLFW/glfw3.h>
   这样编译器才会在头文件中启用 `__declspec(dllimport)` 优化。 如果不定义，也能用，但函数调用会多一层间接跳转（性能略低）。

* * *

**第二部分：为什么你没定义 `GLFW_DLL` 也能用？**

因为：

* Windows 下的 `.lib` 文件（DLL 的导入库）里已经有函数跳转表；
* 即使没有 `__declspec(dllimport)`，链接器仍能找到函数地址。

所以程序**仍能运行**，但：

* 没有 `__declspec(dllimport)` 时，编译器不会做“直接导入优化”；
* 调用函数时，会多一次间接跳转（调用速度略慢，大概 5–10%）。

* * *

**第三部分：那如果是别的库，我怎么知道要不要定义？**

答案是：

1. **看官方文档**：通常会写清楚，例如
   
   > On Windows, define XXX_DLL when using the DLL version.

2. **看头文件**：你会看到类似这样的结构：
      #if defined(_WIN32) && defined(XXX_DLL)
      #define XXX_API __declspec(dllimport)
      #elif defined(_WIN32) && defined(_XXX_BUILD_DLL)
      #define XXX_API __declspec(dllexport)
      #else
      #define XXX_API
      #endif
   一看就知道——如果你是用户，就该 `#define XXX_DLL`。

* * *

**第四部分：关于 IDE 悬停看到函数说明**

当你在 Visual Studio、CLion、VSCode 里把鼠标悬停在 `glfwInit()` 上，

出现“函数说明”“参数解释”等信息，这是因为：

* GLFW 的源代码或头文件里写了 **Doxygen 风格的注释**，例如：
  
      /*!
       * @brief 计算两个整数的和
       * @param a 第一个整数
       * @param b 第二个整数
       * @return 两数之和
       */
      int add(int a, int b);
  
  或者：
  
      /** @brief 计算两个整数的和 */
      int add(int a, int b);
  
  

这些 `/*! ... */` 或 `/** ... */` 都是 Doxygen 能识别的格式。

IDE 会读取这些注释并在悬停提示里显示出来。

* * *

**一句话总结：**

你能在 Windows 上编译运行 GLFW 动态库，是因为 `.lib` 提供了函数跳转表。

`GLFW_DLL` 宏只是启用 `__declspec(dllimport)` 优化，不定义也能跑。

如果是别的库，要看官方文档或头文件是否提到类似宏。

而悬停提示出现，是因为头文件里有 Doxygen 风格注释。

## Create Lib

* Header file 简介 这个问题问得非常关键。 理解“头文件应该写什么”是区分**接口（interface）**和**实现（implementation）**的核心。
  
  * * *
  
  可以直接记住一条原则：
  
  > 头文件（.h / .hpp）放“声明（declarations）”，源文件（.cpp）放“定义（definitions）”。
  
  * * *
  
  具体来说，头文件里一般放以下内容：
  
  * * *
  
  **① 函数声明（function declarations）** 让别的源文件知道函数的存在和用法。
  
      // math_utils.h
      #pragma once
      
      int add(int a, int b);
      double average(double a, double b);
  
  而函数的实现放在 `.cpp`：
  
      // math_utils.cpp
      #include "math_utils.h"
      
      int add(int a, int b) { return a + b; }
      double average(double a, double b) { return (a + b) / 2; }
  
  * * *
  
  **② 类定义（class definitions）** 整个类结构通常放在头文件，因为别人需要知道有哪些成员函数、属性可用。
  
      // Person.h
      #pragma once
      #include <string>
      
      class Person {
      public:
          Person(const std::string& name, int age);
          void sayHello() const;
      private:
          std::string m_name;
          int m_age;
      };
  
  实现放 `.cpp`：
  
      // Person.cpp
      #include "Person.h"
      #include <iostream>
      
      Person::Person(const std::string& name, int age)
          : m_name(name), m_age(age) {}
      
      void Person::sayHello() const {
          std::cout << "Hi, I'm " << m_name << " and I'm " << m_age << " years old.\n";
      }
  
  * * *
  
  **③ 常量、枚举、结构体定义**
  
      // constants.h
      #pragma once
      
      const double PI = 3.14159;
      
      enum class Color { Red, Green, Blue };
      
      struct Point {
          double x, y;
      };
  
  * * *
  
  **④ 模板（template）函数或类** 模板通常写在头文件里，因为编译器要在编译每个调用点时生成具体实现。
  
      // utils.h
      #pragma once
      
      template <typename T>
      T square(T x) {
          return x * x;
      }
  
  * * *
  
  **⑤ 宏定义（#define）或内联函数（inline）**
  
      #define MAX(a,b) ((a) > (b) ? (a) : (b))
      
      inline int triple(int x) { return x * 3; }
  
  * * *
  
  **⑥ 外部变量声明（extern）** 让多个文件共享同一个变量。
  
      // globals.h
      #pragma once
      
      extern int g_counter;  // 声明
  
  然后在一个 `.cpp` 文件里定义它：
  
      // globals.cpp
      int g_counter = 0;
  
  * * *
  
  **⑦ include guard 或 #pragma once** 避免头文件被重复包含：
  
      #pragma once
  
  或者：
  
      #ifndef MATH_UTILS_H
      #define MATH_UTILS_H
      // 内容
      #endif
  
  * * *
  
  **一句话总结：**

> 头文件声明接口，让别人知道“你有什么”；源文件实现逻辑，让编译器知道“你怎么做”。

  也就是： **头文件负责“告诉别人怎么用”，源文件负责“真正干活”。**

* 现在我们已经有了名为创建一个名为Game的解决方案 它自带一个名为Game的空项目
  
  * 在这个解决方案里再创建一个名为Engine的空项目
    
    * 右键Game项目→属性 → 常规 → 配置类型 设置成 应用程序.exe
    
    * 右键Engine项目 属性 - 常规 - 配置类型 设置成 静态库.lib应用到 所有配置 所有平台

按照之前的设置修改输出目录和中间目录 以及创建src文件夹

解决方案视图

在Game项目 右键源文件 通过 新建项 创建 Application.cpp

在Engine项目 分别右键源文件和头文件 创建 Engine.h和Engine.cpp

再都分别移动到src文件夹中

也可以先在文件夹视图 src文件夹中都通过新建项创建好 再切回解决方案视图 右键源文件或者头文件 添加 - 现有项 选择src文件夹里那些 这样就把文件都组织到了项目之中
    // Engine.h
    **#pragma once
    namespace** engine
    {
        **void** PrintMessage();
    }

头文件里不需要实现这个函数
    // Engine.cpp
    **#include** "Engine.h"**#include** <iostream>**namespace** engine
    {
        **void** PrintMessage()
        {
            std**::**cout **<<** "Hello from the Engine!" **<<** std**::**endl;
        }
    }`
    `// Application.cpp
    **#include** "../../Engine/src/Engine.h"// 根据""会搜索相对目录这样写
    **int** **main**()
    {
        engine**::**PrintMessage();
    }`

* 也可以通过项目属性设置:
  * 右键Game项目 - 属性 - C/C++ - 常规 - 附加包含目录 写入`$(SolutionDir)Engine\src`
  * 现在就可以写头文件 `#include "Engine.h"` 其实[前面](https://chocomintopia.github.io/1-Cherno-C++.html#mypoint_13)已经讨论过了
* 现在对Engine项目进行生成 我们得到了一个Engine.lib 按照之前设置好的输出目录和中间目录 它应该在 `D:\coding\C++\Game\bin\x64\Debug` Visual Studio的输出窗口在生成结束后 其实已经为你输出了它的所在地址
  * 右键Game项目 - 链接器 - 输入 - 附加依赖项 写入Engine.lib
  * 链接器 - 常规 - 附加库目录 写入 `$(SolutionDir)bin\x64\Debug`
* 按照之前静态链接的方法 我们应该是像这样做, 但是 这个lib是在我们的解决方案之中:
  * 右键Game项目 - 添加 - 引用 - 项目 - 解决方案 选择这个Engine项目
  * 引用的好处是如果我们修改了库的名字 仍然可以使用 而不用麻烦地修改

*Notion: 现在Game依赖于Engine 所以如果Engine发生了修改 我们去编译Game 编译Game实际上就是Game和Engine都编译了 所以即使你忘记了编译Engine也无所谓*

右键Engine项目 清理 这样生成的.lib文件就没有了 现在直接生成Game 在输出窗口就可以看到 先生成了项目Engine 又生成了项目Game 因为Game引用了Engine Game需要Engine才能工作

## NameSpace

> 给名字加上作用域，防止不同代码里的名字冲突。

* * *

来看一个简单例子。

假设你写了一个函数：
    void print() {
        std::cout << "Hello" << std::endl;
    }

而别人写的库里也有一个同名函数：
    void print() {
        std::cout << "World" << std::endl;
    }

当你在同一个项目里 `#include` 两个文件后，编译器会报错：
    error: redefinition of 'print'

因为两个函数名字一样。

* * *

这时候就可以用 **namespace** 给它们分组：
    namespace mine {
        void print() {
            std::cout << "Hello" << std::endl;
        }
    }
    namespace lib {
        void print() {
            std::cout << "World" << std::endl;
        }
    }
    int main() {
        mine::print();  // 输出 Hello
        lib::print();   // 输出 World
    }

这里 `mine::print` 和 `lib::print` 是两个不同的函数，互不冲突。

* * *

**命名空间常见用法**

1. **逻辑分组**
      namespace math {
   
          double add(double a, double b);
          double sqrt(double x);
   
      }

2. **嵌套命名空间**
      namespace graphics {
   
          namespace ui {
              void drawButton();
          }
   
      }
      // C++17 以后可以写成：
      namespace graphics::ui {
   
          void drawButton();
   
      }

3. **使用 `using` 简化访问**
      using namespace std;
      cout << "Hello";  // 不用写 std::cout
   但在大型项目里通常**不建议**全局使用 `using namespace std;`， 因为它可能让不同库里的名字冲突。

* * *

**标准库的命名空间**

C++ 标准库里的所有东西都放在 `std` 命名空间里，比如：
    std::cout
    std::string
    std::vector
    std::map

* * *

**一句话总结：**

`namespace` 是 C++ 用来组织代码和避免命名冲突的机制。

它相当于给你的函数、类、变量“加姓氏”。

## Multiple Return

强烈建议使用Struct, 使用 `struct`（终极方式）
    struct ShaderProgramSource
    {
        std::string VertexSource;
        std::string FragmentSource;
    };
    static ShaderProgramSource ParseShader(const std::string& filepath)
    {
        return { "vs", "fs" };
    }

**解释：**

结构体自定义了字段名，清晰表达每个值的意义。

调用时：
    auto sources = ParseShader("file");
    std::cout << sources.VertexSource << sources.FragmentSource;

**优点：**

* 语义清晰（字段有名字）；
* 支持不同类型；
* 安全易维护；
* 可扩展（以后想加更多返回值很方便）。

## Templates

* 泛型

* 模板并不是一个真正的函数 **只有实际调用时 这些函数才被真的创建** 所以就算模板里的函数应该是会报错的 比如有语法错误 它也不会报错 只有被调用后 还会报错

* 实际上C++标准库也是 `std::array<int, 5> arr;`
  
  ```c++
   #include <iostream> 
   #include <string>
   template<typename T> 
   void Print(T value) {
     std::cout << value << std::endl;
   } 
   // Templates 可以在compile的时候也被评估; 
   // 可以直接指定类型, 设定construct class standard; 
   template<typename T, int N> 
  
   class Array { 
  
   private:
        /*int m_Array[N];*/
        T m_Array[N];
  public:
        N GetSize() const { return N;}
  }; 
  
   int main() {
  
        // Template 可以自行定义data types;
        // Template 在不使用之前都不存在;
        Print<int>(5);
  
        Print("hello");
        Print(5.5f);
        std::cin.get();
  
  }
  ```
  
  

## Stack & Heap

一、内存的整体布局（大致结构）

典型的 C/C++ 程序在运行时，内存空间大致分为几部分：
    ┌──────────────────────┐
    │ 操作系统内核空间     │
    ├──────────────────────┤
    │ 栈 Stack             │ ← 向下增长（高地址 → 低地址）
    ├──────────────────────┤
    │ 堆 Heap              │ ← 向上增长（低地址 → 高地址）
    ├──────────────────────┤
    │ 全局/静态区（Data） │ （存放全局变量、static变量）
    ├──────────────────────┤
    │ 常量区（Text / Const）│ （存放字符串常量、代码）
    └──────────────────────┘

所以：

* 栈在高地址，往下长。堆叠, 但是最新的总在最前面;
* 堆在低地址，往上长。
* 二者之间的空间就是操作系统分配给你的**动态内存区间**。

二、Stack（栈）分配的特点

* * *

**栈** 是由 **编译器自动管理** 的内存区域。

特点

1. **速度非常快**（因为只移动栈顶指针）。
2. **内存自动释放**（函数返回时，作用域结束自动回收）。
3. **空间有限**（通常几 MB，比如 Linux 默认 8MB）。

举例
    void Foo() {
        int a = 10;        // 在栈上分配
        std::string s = "hello"; // 栈上分配对象本身，但其内部buffer可能在堆上
    }

执行到 `Foo()` 时，*栈指针向下移动*，为 `a` 和 `s` 分配空间。

当函数结束后，栈指针回退，这些内存被自动回收。

栈的结构类似这样：
    栈顶 ↓
    | 局部变量 s |
    | 局部变量 a |
    | 返回地址   |
    | 上一函数栈帧 |
    栈底 ↑

* * *

三、Heap（堆）分配的特点

**堆** 是由 **程序员手动控制** 的内存区域（C++中通过 `new` / `delete`）。

特点

1. **生命周期可控** —— 手动创建和销毁。
2. **分配速度较慢** —— 因为要向操作系统申请。
3. **容易泄漏** —— 忘记 `delete` 就会内存泄漏。

举例
    void Foo() {
        int* p = new int(10);     // 在堆上分配
        std::string* s = new std::string("hello");
        delete p;                 // 手动释放
        delete s;
    }

堆空间的结构：
    堆内存 ↑（向高地址增长）
    | new int(10)          |
    | new std::string(...) |

> 堆内存由操作系统通过“内存管理器”（如 malloc / free）分配。
> 
> C++ 的 `new/delete` 就是对它的封装。

* * *

四、Stack vs Heap 对比总结

| 特性   | Stack（栈）            | Heap（堆）           |
| ---- | ------------------- | ----------------- |
| 管理方式 | 系统自动管理              | 程序员手动分配与释放        |
| 分配速度 | 快（移动指针）             | 慢（系统调用）           |
| 生命周期 | 作用域结束自动释放           | 手动控制              |
| 内存空间 | 通常较小                | 较大（取决于系统）         |
| 存储内容 | 局部变量、函数参数、返回地址      | 动态分配的对象、数组        |
| 位置   | 高地址往低地址增长           | 低地址往高地址增长         |
| 典型错误 | 栈溢出（Stack Overflow） | 内存泄漏（Memory Leak） |

* * *

五、示意图：执行过程中的栈与堆

假设：
    void Foo() {
        int x = 42;
        int* p = new int(99);
    }

执行到 `Foo()` 时内存大致如下：
    高地址
    │
    │  ┌──────────────────────────┐
    │  │ 返回地址（main）        │
    │  │ 局部变量 x = 42          │ ← 在栈上
    │  │ 局部变量 p（指针）       │
    │  └──────────────────────────┘
    │
    │        栈向下增长
    │
    │  ┌──────────────────────────┐
    │  │ new int(99)              │ ← 在堆上
    │  └──────────────────────────┘
    │
    │        堆向上增长
    │
    低地址

`p` 本身在栈上，但它**指向堆上的数据**。

* * *

六、常见面试问题

**Q1:** 如果函数里返回一个栈上变量的地址会怎样？
    int* Foo() {
        int a = 10;
        return &a;  // ❌ 返回了无效地址
    }

答：函数结束后栈帧销毁，`a` 的内存被回收，指针悬空（dangling pointer）。

* * *

**Q2:** 哪种分配方式更快？

答：**Stack 比 Heap 快得多**，因为 Stack 只需调整指针，Heap 要向 OS 申请块空间。

* * *

**Q3:** 栈空间耗尽会发生什么？

答：递归过深时会导致 **Stack Overflow（栈溢出）**，程序崩溃。

* * *

**一句话总结：**

* **Stack**：短期、自动、快速、作用域内使用。
* **Heap**：长期、手动、灵活、但易出错。

## Marco

1. Preprocessors
2. 替换语句使用

在 C/C++ 里，**macro（宏）** 是一种在**预处理阶段（preprocessing）执行的文本替换机制**，由 `#define` 指令定义。它不是变量，也不是函数，而是编译前由预处理器进行**直接替换**的“模板”。

简单说：

> 宏是在编译前，用规则替换源代码的一段文本。

**举例 1：简单宏定义**

* * *

    #define PI 3.14159

在编译前，预处理器会把所有出现的 `PI` 替换成 `3.14159`。

相当于代码层面执行：
    float r = 2 * PI;
    // 预处理后变成：
    float r = 2 * 3.14159;

* * *

**举例 2：带参数的宏**
    #define SQUARE(x) ((x)*(x))

使用时：
    int a = 5;
    int b = SQUARE(a + 1); // 展开为 ((a + 1)*(a + 1))

这不是函数调用，而是**纯文本替换**，所以没有类型检查，也不会产生函数开销。

但如果不加括号，可能会出错：
    #define SQUARE(x) x*x
    int a = SQUARE(1+2); // 展开为 1+2*1+2 = 5 (而不是9)

* * *

**举例 3：条件宏**
    #ifdef _WIN32
        #define PLATFORM "Windows"
    #else
        #define PLATFORM "Other"
    #endif

这样在不同系统编译时，会替换成不同文本。

例如在 Windows 上 `_WIN32` 会自动定义，因此 `PLATFORM` 被替换为 `"Windows"`。

* * *

**小结**

| 分类  | 示例                                   | 说明             |
| --- | ------------------------------------ | -------------- |
| 对象宏 | `#define PI 3.14`                    | 替换常量           |
| 函数宏 | `#define MAX(a,b) ((a)>(b)?(a):(b))` | 替换为一段表达式       |
| 条件宏 | `#ifdef / #ifndef`                   | 控制不同平台/场景的编译逻辑 |

* * *

**一句话总结：**

宏是 C/C++ 编译前执行的**文本替换规则**，帮助程序员实现常量定义、跨平台适配或简化重复代码，但使用时要小心括号和副作用。

**宏的典型用途（今天仍然常见）**

1. **防止头文件重复包含（include guard）**
      #ifndef MY_HEADER_H
      #define MY_HEADER_H
      // header content
      #endif

2. **编译条件控制**
      #ifdef DEBUG
      std::cout << "Debug mode" << std::endl;
      #endif

3. **跨平台编译**
      #ifdef _WIN32
      #define CLEAR_SCREEN "cls"
      #else#define CLEAR_SCREEN "clear"
      #endif
   
   

常用

**在release版本中去掉所有的日志代码 但又要在debug版本中保留 可以通过宏实现**

* 右键项目 → 属性

* debug配置下 C/C++ - 预处理器 - 预处理器定义 编辑写入`PR_DEBUG` PR来自于我们这个项目Project_test的缩写 比如你的项目是Sparky游戏引擎 你可以写`SP_DEBUG` 总之这是你自己的宏 不会和其它的宏冲突
    // 用marco来做debug环境的分离；
    #ifdef _DEBUG
    #define Log(x) std::cout << x << std::endl;
    #else
    #define Log(x)
    #endif

## Auto

TIP: In current MVS2022, if you click **alt+f1**, the inferred type will be displayed between auto and the name. It's a great tool for those who really wants to know the type of the variable but also wants a cleaner code. It's like you can alternate between inferred type and explicit type with one button.

让C++自动推导出数据类型, 个人倾向于减少使用auto 因为希望清楚地知道变量的类型 读代码的时候看到auto并不能知道是什么变量类型 除非鼠标悬停
    int a = 5;
    auto b = a;
    auto a = 5; // int
    auto a = 5L; // long
    auto a = 5.5f; // float
    auto a = "abc"; // const char*

* C++变成了不那么关心类型的弱类型语言 只需要到处写auto就行了 是否到处都只用auto 取决于编程风格
* 如果有reference `&` 一定要reference

一、`auto` 的基本作用

* * *

当你写：
    auto x = 5;
    auto y = 3.14;
    auto s = std::string("hello");

编译器会自动推断类型为：
    int x;
    double y;
    std::string s;

👉 相当于“让编译器帮你写出右边表达式的类型”。

二、为什么要用 `auto`

* * *

C++ 类型系统非常复杂，有时一个类型名就能写一长串，例如：
    std::unordered_map<std::string, std::vector<int>>::iterator it = myMap.begin();

有了 `auto`：
    auto it = myMap.begin(); // 自动推断为 iterator

这不仅省事，还让代码更清晰、更不容易出错。

* * *

三、适合使用 `auto` 的典型场景

1. 复杂类型（尤其是模板、迭代器）
    for (auto it = myMap.begin(); it != myMap.end(); ++it) {
   
        std::cout << it->first << std::endl;
   
    }

→ 如果写完整类型，几乎没人看得清楚。

`auto` 在这类 STL 场景中尤其常用。

* * *

✅ 2. 避免重复书写类型（右边已经明确）
    std::vector<int> nums = {1, 2, 3};
    auto v = nums; // 类型显然是 std::vector<int>

右边类型已经很明确，再写一遍没必要。

* * *

✅ 3. Lambda 表达式和匿名类型（无法显式写出）
    auto func = [](int x){ return x * 2; };

`func` 的类型是匿名的，没法用普通语法声明。

此时 `auto` 是唯一选择。

* * *

✅ 4. 避免类型错误（尤其是函数返回复杂类型时）

比如：
    auto result = someComplexFunction();

这样如果函数的返回类型改变，编译器会自动推断，不需要你手动修改声明。

* * *

✅ 5. 范围 for 循环
    std::vector<std::string> names = {"A", "B", "C"};
    for (auto& name : names) { // 注意 & 防止拷贝
        std::cout << name << std::endl;
    }

比写 `for (std::string& name : names)` 简洁很多。

* * *

四、不建议使用 `auto` 的场景

⚠️ 1. 当类型变化可能导致歧义或性能问题时
    std::vector<int> v = {1, 2, 3};
    auto x = v[0]; // 注意！x 是 int (值拷贝)
    auto& y = v[0]; // y 是 int& (引用)

→ 如果不清楚什么时候需要引用，最好显式写出。

* * *

⚠️ 2. 当类型是基础类型（int, double）且可读性更重要时
    auto count = 42; // 可行，但没必要
    int count = 42;  // 更清晰

别人读代码时可能想知道这是 int 还是 double。

基础类型写清楚更直观。

* * *

⚠️ 3. 当你要确保类型一致性时
    auto a = 1;    // int
    auto b = 2.0;  // double
    auto c = a + b; // double (隐式转换)

这里 `c` 是 double，但如果你本来想要 int，`auto` 反而隐藏了类型转换。

* * *

五、一个实用经验法则（Modern C++ 社区普遍推荐）

| 情况                | 是否推荐用 `auto`     | 理由     |
| ----------------- | ---------------- | ------ |
| STL 容器迭代器         | ✅ 强烈推荐           | 避免复杂类型 |
| Lambda 表达式返回类型    | ✅ 唯一可行           |        |
| 函数返回复杂对象          | ✅ 可提高灵活性         |        |
| 局部变量类型明显          | ⚠️ 可用但非必要        |        |
| 基础类型（int, double） | ❌ 不推荐            |        |
| 可能导致隐式拷贝          | ⚠️ 慎用，考虑加引用符 `&` |        |

* * *

六、专业级用法：`auto&` 与 `const auto&`

这两种形式常用于循环中，避免拷贝，提高性能：
    std::vector<std::string> v = {"Alice", "Bob"};
    for (auto& name : v) {        // 可修改
        name += "!";
    }
    for (const auto& name : v) {  // 不可修改，避免拷贝
        std::cout << name << std::endl;
    }

* * *

七、总结一句话

> 当类型复杂、返回值不明确或冗长时，用 auto；当类型简单或需要明确语义时，显式写类型。

* * *

**记忆口诀：**

> “类型复杂让编译器干，类型简单自己写一遍。”

## Std::Array

1. 静态数组 不增长的数组 不能改变它的大小
    #include <array>
    int main()
    {
   
        std::array<int, 5> data;
        data[0] = 2;
        data[4] = 1;
       
        int dataOld[5];
        // 旧的C风格数组
       
        std::cin.get();
   
    }
* 不用传数组大小的办法
    // 原始数组 使用模板
    template <size_t N>
    void PrintArray(int (&array)[N])
    // 引用 (&array)[N] 防止数组退化成指针
    // 如果我不用模板 比如只想接受大小为5的数组
    // 就可以 void PrintArray(int (&array)[5])
    // 其实array这里换个名字也可以
    // 比如void PrintArray(int (&b)[5])
    {
  
        for (int i = 0; i < N; i++)
        {
            // print
        }
  
    }
    // 调用示例
    int arr[] = {1, 2, 3, 4, 5};
    PrintArray(arr);  // 自动推导 N=5

最优速度下 效率和原始数组没有区别, `.size()`是`std::array`的一个优势 size是一个模板参数 并不存在什么存储在数组中的size变量

作为迭代器 也有`.begin()`, `.end()`这个类也可以用大量的STL(标准模板库)算法 因为它支持迭代器

和原始数组一样 都是栈创建 而不像vector是堆分配

## Function Pointer

* 把函数作为参数传递给其它函数
    void HelloWorld()
    {
  
        std::cout << "Hello World!" << std::endl;
  
    }
    int main()
    {
  
        HelloWorld(); // 平时我们都这么用
        auto myHelloWorld = &HelloWorld;
      
        myHelloWorld();
        myHelloWorld();
      
        std::cin.get();
  
    }
    // 会输出3个 Hello World!

* `auto myHelloWorld = &HelloWorld;` 没有用`HelloWorld()`这样就不是在调用函数,
  
  * **获取函数指针** → 赋值给function → 得到函数的内存地址 → 赋值给function
  * 函数只是cpu指令 编译代码时 函数就在二进制文件的某个地方： `&HelloWorld`的意思就是 在可执行文件中找到这个helloworld函数 获取那些cpu指令的内存地址
  * 直接写`auto myHelloWorld = HelloWorld;` 会发生一个隐式转换 直接将函数名赋值
  * 这里auto的类型是 `void(*)()` 是指向：无参数，返回void的函数 的Pointer

* 声明语法是`返回类型 (*指针变量名)(参数类型)`

* 还是使用auto或者using/typedef别名吧
    // 方法1
    auto myHelloWorld = HelloWorld;
    // 方法2 返回类型 (*指针变量名)(参数类型)
    void (*myHelloWorld)() = HelloWorld;
    // (最佳)方法3
    using myFunctionType = void(*)();
    myFunctionType myHelloWorld = HelloWorld;
    // 方法4 typedef 返回类型 (*新类型名)(参数类型);
    typedef void(*myFunctionPtr)();
    myFunctionPtr myHelloWorld = HelloWorld;

会重载， 需要进行static_cast的情况：
    #include <iostream>
    void sayHello() {
        std::cout << "hello world" << std::endl;
    }
    std::string sayHello(const std::string& str) {
        std::cout << str << std::endl;
        return str;
    }
    void funPointer() {
        typedef void(*newHello)();
        typedef std::string(*paraHello)(const std::string&);
        newHello h = static_cast<newHello>(&sayHello);
        paraHello p = static_cast<paraHello>(&sayHello);
    }

* Call Back
    #include <iostream>
    #include <vector>
    void print(int& values) {
  
        std::cout << values << std::endl;
  
    }
    void forEach(const std::vector<int>& values, void(*func)(int&)) {
  
        for (int value : values) {
            func(value);
        }
  
    }
    void Callback() {
  
        std::vector<int> a = { 1,2,3,4,5 };
        forEach(a, print);
  
    }

* Lamda的表达
  
        forEach(a, [](int& values) {
            std::cout << values << std::endl;
            });

## Lambda

**一行 lambda ✅**：简短、单逻辑的小函数；

关于CallBack:

* 回调(Callback)是一种编程模式 它允许我们将一个函数作为参数传递给另一个函数 然后在某个特定事件发生时调用这个传递进来的函数
1. 假如是在一个类的内部 **类成员函数之间相互调用** 就不需要用函数指针传参 甚至也不用考虑声明顺序 直接调用就可以了 暂时我们不讨论成员函数指针

2. C语言是声明在后面的函数就可以直接调用声明在前面的函数 所以有时候**调整声明顺序**就行了 即使是 前面函数 的实现 用到了后面的函数 只需要把后面函数的声明写到 前面的函数 前面就可以了 这也属于调整声明顺序

3. 调用其它文件里的函数的场合 是用头文件 头文件中声明函数 源文件中实现函数 在要调用这个函数的文件中写头文件 不需要函数指针 直接调用
    // 根据不同条件选择不同处理函数
    void ProcessData(int mode, const std::vector<int>& data) {
   
        void (*processor)(int) = nullptr;
       
        // 根据模式动态选择处理函数
        if (mode == 1) processor = &ProcessMode1;
        else if (mode == 2) processor = &ProcessMode2;
        else processor = &DefaultProcess;
       
        // 使用选择的函数处理数据
        for (int value : data) {
            processor(value);
        }
   
    }

基本语法如下：
    [捕获列表](参数列表) -> 返回类型 {
        函数体
    };

* * *

常见几种写法和例子：

**1. 最简单形式（无参数、无返回）**
    auto sayHello = []() {
        std::cout << "Hello Lambda!" << std::endl;
    };
    sayHello();  // 调用

**2. 有参数**
    auto add = [](int a, int b) {
        return a + b;
    };
    std::cout << add(3, 4);  // 输出 7

**3. 指定返回类型**
    auto divide = [](int a, int b) -> double {
        return static_cast<double>(a) / b;
    };
    std::cout << divide(5, 2);  // 输出 2.5

**4. 捕获外部变量（非常关键）**
    int x = 10;
    auto print = [x]() { std::cout << x << std::endl; };
    print();  // 输出 10

捕获方式说明：

* [ ] `[x]`：按值捕获 `x`（复制一份）

* `[&x]`：按引用捕获 `x`（修改会影响外部）

* `[=]`：按值捕获所有外部变量

* `[&]`：按引用捕获所有外部变量

* `[=, &y]`：默认按值捕获，`y` 特例按引用

* `[&, x]`：默认按引用捕获，`x` 特例按值

示例：
    int a = 1, b = 2;
    auto lambda = [=, &b]() {
        // a 是按值捕获，b 是按引用捕获
        b += 10;
        return a + b;
    };
    std::cout << lambda();  // 输出 13
    std::cout << b;         // 输出 12

**5. 在算法中使用（最常见）**
    std::vector<int> v = {1, 2, 3, 4, 5};
    std::for_each(v.begin(), v.end(), [](int n) {
        std::cout << n * n << " ";
    });

**6. 内联立即调用**
    int result = [](int x, int y) { return x * y; }(3, 5);
    std::cout << result;  // 输出 15

* * *

总结：

* 基本语法：`[捕获](参数)->返回类型{函数体}`

* 捕获用于访问外部变量；

* 返回类型可省略，编译器自动推断；

* 可与算法（`for_each`, `sort`）等 STL 函数结合使用；

* `auto` 是定义 lambda 的常见方式。
    #include <algorithm>
    std::vector<int> values = { 1, 5, 2, 4, 3 };
    auto it = std::find_if(values.begin(), values.end(), [](int value) { return value>3; }) 
    std::cout << *it << std::endl;

`find_if()` 函数前两个参数接收容器的迭代器 用于确定查找的范围 第三个参数是一个规则函数 

* **查找范围内的数据将会逐个传递给这个规则函数** 所以这个规则函数必然有一个参数是和容器里的元素同样类型的
* 规则函数最终会返回一个bool值
  * 如果返回true 就表示现在这个数据是符合规则函数的条件的 那么find_if会返回指向现在这个数据的迭代器
  * 如果返回false 意思就是不符合规则函数中的条件 规则函数会接收下一个数据 继续开始判断 如果到达查找范围结束时 还没不符合条件 就返回指向查找范围末尾的迭代器
    
    

## NameSpace

`namespace`（命名空间）是 **C++ 用来组织代码、避免命名冲突** 的机制。

简单理解：

就像文件夹一样，用来把不同功能的代码“分区管理”，防止同名变量、函数、类互相冲突。

* * *

例如：
    #include <iostream>
    namespace Math {
        int add(int a, int b) {
            return a + b;
        }
    }
    namespace Physics {
        int add(int a, int b) {
            return a + b + 1;  // 只是示例
        }
    }
    int main() {
        std::cout << Math::add(2, 3) << std::endl;     // 调用 Math 里的 add
        std::cout << Physics::add(2, 3) << std::endl;  // 调用 Physics 里的 add
    }

这里 `Math` 和 `Physics` 都有一个函数叫 `add`，但因为它们在不同命名空间下，所以不会冲突。

访问时通过 `命名空间名::标识符` 的形式区分。

* * *

常见例子：
    #include <iostream>
    using namespace std;
    int main() {
        cout << "Hello" << endl;
    }

这里的 `std` 是标准库的命名空间，`cout`、`endl`、`string` 等都在 `std` 里。

`using namespace std;` 表示默认从 `std` 命名空间中查找标识符。

* * *

总结要点：

* 命名空间用于防止命名冲突。
* 使用 `::` 访问其中的内容。
* 可以嵌套定义命名空间。
* `using namespace` 可以引入命名空间的所有内容（但容易引起冲突）。

* * *

一个建议的好习惯：

* 在头文件里不要写 `using namespace std;`，因为会污染全局命名空间。
* 在源文件（.cpp）里可以使用，方便书写。

什么时候使用namespace？

* 如果写`using namespace std;` 就不用写`std::`了 可以放全局 也可以只放在某个函数里 可以在任何作用域里使用

* 如果是命名空间名字很长 或者有自己的命名空间 项目文件中的符号全都在这个命名空间中 需要经常访问调用那些命名空间中的符号 这时候可能会想要使用命名空间 但是 不喜欢using namespace std

* *去掉了`std::` 会看起来不明不白 你分不清哪些是C++标准库的 哪些是原始C的 非常不舒适 很难读*

* ***永远不要在头文件中使用using namespace** 这样别人使用你的头文件 就相当于把你写的use namespace复制到了自己代码的最开头 它是全局的 导致别人后面的代码直接没办法写了*

* 如果一定要using namespace 建议只using自己亲手在本地写的库 并且要在足够小的作用域里使用 比如if语句内部 函数内部 尽量不要全局
    namespace apple { namespace functions {
    // 这样写缩进就可以清楚地看到有几层命名空间
    // 而且函数也不需要再缩进了
    }
    }

## Thread

C++ 的多线程（`std::thread`）是从 **C++11** 开始引入的标准库功能，用于在同一个进程内同时执行多个任务。下面是它的核心用法与注意点。

* * *

**一、头文件与基本语法**

要使用线程，需要包含头文件：
    #include <thread>

创建线程最简单的方式是直接传入一个可调用对象（函数、lambda、函数对象等）：
    #include <iostream>
    #include <thread>
    void task() {
        std::cout << "Hello from thread!\n";
    }
    int main() {
        std::thread t(task);  // 启动一个线程，执行 task()
        t.join();             // 等待线程执行完毕
        std::cout << "Main thread done.\n";
    }

输出：
    Hello from thread!
    Main thread done.

* * *

**二、常用操作**

1. **join()** 主线程等待子线程结束。必须在析构前调用，否则程序会报错（terminate）。
      t.join();

2. **detach()** 将线程分离，线程独立运行，主线程不再等待它结束。通常用于后台任务。
      t.detach();
   ⚠️ 注意：分离后的线程不能再被 `join()`，主线程结束时如果线程还没结束，会直接终止整个进程。

3. **joinable()** 判断线程是否可被 join。
      if (t.joinable()) t.join();
   
   

* * *

**三、传参**

线程函数可以接收参数，按值拷贝传入：
    void printNum(int n) {
        std::cout << "Number: " << n << "\n";
    }
    int main() {
        std::thread t(printNum, 10);
        t.join();
    }

若要传引用，需使用 `std::ref()`：
    void addOne(int& x) {
        x += 1;
    }
    int main() {
        int val = 5;
        std::thread t(addOne, std::ref(val));
        t.join();
        std::cout << val;  // 输出 6
    }

* * *

**四、lambda 创建线程**
    std::thread t([]{
        std::cout << "Lambda thread\n";
    });
    t.join();

* * *

**五、多个线程同时运行**
    #include <vector>
    void work(int id) {
        std::cout << "Thread " << id << " running\n";
    }
    int main() {
        std::vector<std::thread> threads;
        for (int i = 0; i < 5; ++i)
            threads.emplace_back(work, i);
        for (auto& t : threads)
            t.join();
    }

* * *

**六、共享资源与互斥锁**

多线程访问共享数据时需要同步机制，比如 `std::mutex`：
    #include <mutex>
    #include <thread>
    int counter = 0;
    std::mutex mtx;
    void increment() {
        for (int i = 0; i < 1000; ++i) {
            std::lock_guard<std::mutex> lock(mtx);
            counter++;
        }
    }
    int main() {
        std::thread t1(increment);
        std::thread t2(increment);
        t1.join();
        t2.join();
        std::cout << counter; // 输出 2000
    }

* * *

**七、线程 ID 与硬件并发数**
    std::cout << std::this_thread::get_id() << "\n";
    std::cout << std::thread::hardware_concurrency() << "\n"; // 系统建议的并行线程数

* * *

**八、小结**

| 操作                                    | 说明         |
| ------------------------------------- | ---------- |
| `std::thread t(func, args...)`        | 创建线程       |
| `t.join()`                            | 等待线程结束     |
| `t.detach()`                          | 分离线程       |
| `std::ref()`                          | 传引用参数      |
| `std::mutex` / `std::lock_guard`      | 线程同步       |
| `std::thread::hardware_concurrency()` | 获取系统建议的并行数 |

* * *

    #include <iostream>
    #include <thread>
    static bool s_Finished = false;
    
    void doWork() {
    
        while (!s_Finished) {
            std::cout << "Do working " << std::endl;
        }
    }
    
    int main() {
        std::thread f(doWork);
    
        std::cin.get();
        s_Finished = true;
        f.join();
    
        std::cin.get();
        return 0;
    }

* 让那个线程sleep一会, thread join 线程加入 我们暂时不讨论了 其它语言中它常常叫做 wait / wait for exit. 调用join的目的是 在主线程上等待工作线程完成所有的执行之后 再继续执行主线程
* `using namespace std::literals::chrono_literals;` 字面量 这样就可以直接写3s直接表示3秒 3ms表示3毫秒 3h表示3小时
* `std::this_thread`可以用于给当前线程下命令

## Timing

C++库 chrono 不需要操作系统库
    #include <iostream>
    #include <chrono>
    #include <thread>
    int main() {
        using namespace std::literals::chrono_literals;
        auto start = std::chrono::high_resolution_clock::now();
        std::this_thread::sleep_for(1s);
        auto end = std::chrono::high_resolution_clock::now();
        std::chrono::duration<float> duration = end - start;
        std::cout << duration.count() << std::endl;
        std::cin.get();
    }
    #include <iostream>
    #include <chrono>
    #include <thread>
    //使用对象生存期 让它为我自动计时
    struct Timer {
        std::chrono::time_point<std::chrono::steady_clock> start, end;
        std::chrono::duration<float> duration;
        Timer() {
            this->start = std::chrono::high_resolution_clock::now();
        }
    // Decontructor 会在block结束时自动执行~
        *~Timer() {*
            this->end = std::chrono::high_resolution_clock::now();
            this->duration = end - start;
            float ms = duration.count() * 1000.0f;
            std::cout << "Timer took" << ms << "ms" << std::endl;
        }

    };

    int main() {

        Timer timer;
        std::cout << "Hello World" << std::endl;

    }

## Multi Dimisional Array

1. Collection pointer to the array

2. 二维数组就是数组的数组：想象一个指针的数组 最后会得到一个内存块 里面包含的是连续的指针 每个指针都指向内存中的某个数组 所以我们得到的是指向数组的指针的集合 也就是数组的数组
    int MultiDimisional() {
   
        int* array = new int[50];
       
        //这里第一个* 只是去分配了50个pointer的地址；
        int** a2d = new int* [50];
       
        for (int i = 0; i < 50; i++) {
            //这里是实际分配的
            a2d[i] = new int[50];
        }
        //如何访问，直接访问到存储的数组， 而不是a2d[0]， 这个是指针
        a2d[0][0] = 0;
        a2d[0][1] = 1;
        //删除： 删除整个数组, 先删除指向的数组， 然后删除整个指针；
        for (int i = 0; i < 50; i++) {
            delete[] a2d[i];
        }
        delete[] a2d;
       
        // 这里就是2个指针， 首个还是分配了1个指针指向另外一个指针；
        int*** a3d = new int** [50];
       
        for (int i = 0; i < 50; i++) {
            a3d[i] = new int* [50];
            for (int j = 0; j < 50; j++) {
                //先找到对应的指针，注意是int**, 因为还是指针。
                int** ptr = a3d[i];
                ptr[j] = new int[50];
            }
        }
       
        //用for loop来遍历整个数组， 会非常非常慢 O(n^2)
        //展平操作来进行降维， 提升速度
       
        int* squzze = new int[5 * 5];
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                // 这样就可以逐个初始化 array[0]
                squzze[x + y * 5] = 1;
            }
        }
   
    }

## Sorts

需要给它提供一个开始迭代器和一个结束迭代器 迭代器内的所有东西都会基于我们提供的谓词进行排序
    #include <iostream>
    #include <vector>
    #include <algorithm>
    #include <functional>
    int main() {
        std::vector<int> array = { 5,2,3,1,4 };
        // 用 Greater 倒序排列
        std::sort(array.begin(), array.end(), std::greater<int>());
        //自定义comparsion, 使用lambda 表达式
        std::sort(array.begin(), array.end(), [](int a, int b) { return a > b; });
        //修改比较逻辑
        std::sort(array.begin(), array.end(), [](int a, int b) { 
            if (a == 1) return false;
            if (b == 1) return true;
            });
    }

## Type Punning

“Type punning” 是 C/C++ 中一个常见但微妙的概念，它指的是**通过一种类型的对象去访问另一种类型的底层二进制表示**，也就是“用错类型去看同一块内存”。

简单地说，就是“同一块内存，用不同的类型来解释它”。

* * *

例子一：通过指针强制转换
    int a = 65;
    char* p = (char*)&a;
    std::cout << *p << std::endl;

这里：

* `a` 是一个 `int` 类型，占 4 个字节。
* 我把它的地址强制转换成 `char*`，再取一个字节。
* 输出的其实是 `a` 在内存中的第一个字节（可能是 `65` 对应的 `'A'`），这就是 type punning。

同一块内存，通过不同类型去读。

* * *

例子二：用 `union` 实现
    union Data {
        int i;
        float f;
    };
    Data d;
    d.i = 0x3f800000; // 1.0f 的 IEEE 754 表示
    std::cout << d.f << std::endl;  // 输出 1

这里我们用一个 `union`（联合体）共享同一块内存。

* `d.i` 和 `d.f` 实际上占用同一块空间；

* 写入 `i` 再读取 `f`，等于是把一个整数的二进制直接解释为一个浮点数。 这也是 type punning。

* * *

例子三：使用 `memcpy` 的安全方式

由于 type punning 可能违反 C++ 的 **strict aliasing rule（严格别名规则）**，导致未定义行为（UB），现代 C++ 推荐安全替代方法：
    float f = 1.0f;
    int i;
    std::memcpy(&i, &f, sizeof(f));  // 安全做法

这比直接 `(int&)f` 更安全，因为 `memcpy` 不违反别名规则。

* * *

总结

* **定义**：用一种类型访问另一种类型的内存。
* **目的**：查看或操作底层二进制布局。
* **风险**：可能触发未定义行为（尤其是指针/引用转换）。
* **安全替代**：`std::memcpy` 或 `std::bit_cast`（C++20引入）。

* * *

## Unions

`union`（联合体）是 C/C++ 中一种**特殊的复合数据类型**，

它和 `struct` 很像，但有一个关键区别：**所有成员共享同一块内存。**

* * *

**1. 基本概念**

定义一个 `union`：
    union Data {
        int i;
        float f;
        char c;
    };

这表示：

* `i`、`f`、`c` 全都**占用同一块内存空间**；
* `union` 的大小 = **最大成员的大小**；
* 任何时刻，只能“安全地”存储一个成员。

示意图：

| 成员  | 内存位置  | 说明             |
| --- | ----- | -------------- |
| `i` | [0,3] | 使用 4 字节        |
| `f` | [0,3] | 同样 4 字节        |
| `c` | [0,0] | 1 字节，但共享前 1 字节 |

* * *

**2. 使用示例**
    #include <iostream>
    union Data {
        int i;
        float f;
    };
    int main() {
        Data d;
        d.i = 0x3f800000;  // 1.0 的 IEEE 754 表示
        std::cout << d.f << std::endl; // 输出 1
    }

这里 `d.i` 和 `d.f` 共用同一内存。

把整数写进去，再按 float 解释，这正是 **type punning** 的一个典型应用。

* * *

**3. 主要用途**

* **节省内存** 如果同一数据结构在不同情境下只用到某一种成员，可以共用内存。
  
      union Value {
          int i;
          double d;
          char str[8];
      };
  
  在嵌入式、通讯协议或编译器内部结构中常用于节省空间。

* **类型复用 / 类型重解释（type punning）** 用来查看不同类型在内存中的表现（如 float ↔ int 转换）。

* **实现变体（variant）类型的早期方式** 例如旧式的：
  
      struct Token {
          int type; // 0=int, 1=float
          union {
              int i;
              float f;
          } value;
      };
  
  类似现代 C++ 的 `std::variant<int, float>`。

* * *

**4. 安全与限制**

* 只有最近一次写入的成员可以被“安全读取”。 访问未被激活的成员是**未定义行为（UB）**。 （C 语言允许多一点，C++ 更严格。）

* 不能含有带有非平凡构造函数或析构函数的对象（C++11前）。 从 C++11 起，可以用 `std::variant` 或 `std::aligned_storage` 实现更安全的替代方案。

* * *

**5. 和 struct 的区别**

| 特性    | struct    | union                            |
| ----- | --------- | -------------------------------- |
| 内存布局  | 每个成员独立存在  | 所有成员共享同一内存                       |
| 大小    | 各成员大小之和   | 最大成员的大小                          |
| 可同时访问 | 所有成员      | 理论上只能安全访问最后写入的成员                 |
| 用途    | 组织不同字段的数据 | 复用内存 / type punning / variant 实现 |

* * *

一句话总结：

> struct 是“并列存放”， union 是“重叠存放”。
> 
> 它让你能在一块内存中装下不同类型的数据，但同时只保证一个是有效的。

* * *

要我给你画个 `struct` 和 `union` 的内存布局对比图吗？（能清楚看出“并列 vs 重叠”的区别）

* *想给同一个变量取两个不同的名字时 很有用 通常union是匿名使用的 但是匿名union不能含有成员函数*
    strct Vector4
    {
  
        union
        {
            struct
            {
                float x, y, z, w;
            };
            struct
            {
                Vector2 a, b; // 两个vector
            };
        }
  
    }

现在union里有两个成员 于是第二个成员和第一个成员占据相同的空间 那么现在就有多种访问Vector4内数据的方法 a和x, y的内存是一样的 b和z, w的内存是一样的
    Vector4 vector = { 1.0f, 2.0f, 3.0f, 4.0f };
    PrintVector2(vector.a);
    vector.z = 500.0f;
    PrintVector2(vector.b);
    // 会输出
    // 1, 2
    // 500, 4

## Virtual Deconstructor

* 对于Derived类 首先调用了基类的构造函数 然后是Derived类的构造函数
  
  * 所以会这样输出 现在就需要虚析构函数了 我们希望在析构子类的时候 只调用子类的析构函数
    **class** **Base**{
    public:
    
        Base() { std**::**cout **<<** "Base Constructor\n"; }
        **~**Base() { std**::**cout **<<** "Base Destructor\n"; }
    
     };
    **class** **Derived** **:** **public** Base
    {
    public:
    
        Derived() { std**::**cout **<<** "Derived Constructor\n"; }
        **~**Derived() { std**::**cout **<<** "Derived Destructor\n"; }
    
     };
    **int** main()
    {
    
        Base***** base **=** **new** Base();
        **delete** base;
        std**::**cout **<<** "-------\n";
        Derived***** derived **=** **new** Derived();
        **delete** derived;
        
        std**::**cin.get();
    
    }

现在Derived类型同时也是Base类型 因为Derived是Base的子类

上面的代码会输出
    Base Constructor
    Base Destructor
    **-------**Base Constructor
    Derived Constructor
    Derived Destructor
    Base Destructor

对于Derived类 首先调用了基类的构造函数 然后是Derived类的构造函数 所以会这样输出 现在就需要虚析构函数了 我们希望在析构子类的时候 只调用子类的析构函数
    Base***** poly **=** **new** **Derived**();
    **delete** poly;

创建一个Derived实例 但是将它赋值给Base类类型 所以现在就把这种poly对象当作Base类指针来处理 但它实际上是一个指向Derived类型的指针

上面代码的执行结果就是
    Base Constructor
    Derived Constructor
    Base Destructor

只调用了基类的析构函数 没有调用派生类的析构函数 这会导致内存泄露

虚函数在方法前标注virtual 使得可以在子类中重写这个方法 虚析构函数有些不太一样 不是覆写析构函数 而是加上一个析构函数 所以如果把基类的析构函数变成虚函数 它就会调用两个析构函数 会先调用派生类析构函数 然后在层级结构中向上 调用基类析构函数

但是我们为什么非得调用派生类的析构函数 只调用基类的析构函数不行吗？
    **class** **Derived** **:** **public** Base
    {
    public:
        Derived() { m_Array **=** **new** **int**[5]; std**::**cout **<<** "Derived Constructor\n"; }
        **~**Derived() { **delete**[] m_Array; std**::**cout **<<** "Derived Destructor\n"; }
     };

现在我们在派生类中创建了一个数组 在析构时就需要删除该数组 如果只调用基类的析构函数 这个数组是无法被删除的 有内存泄露

现在将这个基类的析构函数标记为虚函数 意味着这个类有可能被扩展为子类 可能还有一个析构函数也需要被调用 如果有派生类的析构函数 就调用派生类的析构函数
    **class** **Base**{
    public:
        Base() { std**::**cout **<<** "Base Constructor\n"; }
        **virtual** **~**Base() { std**::**cout **<<** "Base Destructor\n"; }
     };

修改之后再执行
    Base***** poly **=** **new** **Derived**();
    **delete** poly;

会输出
    Base Cosntructor
    Derived Constructor
    Derived Destructor
    Base Destructor

这就和
    Derived***** derived **=** **new** **Derived**();
    **delete** derived;

输出结果一样 派生类的析构函数首先被调用 然后调用基类的析构函数 即使我们把它当作多态类型 当作基类类型来处理 它也能顺利调用子类的析构函数

但是我们为什么要创建多态类型？为什么要创建一个子类类型 并将其视为基类类型？

1. 通过基类统一接口操作不同派生类对象
    **class** **Animal** {
     public:
   
         **virtual** **void** speak() **=** 0;
         **virtual** **~**Animal() {}
   
     };
     **class** **Dog** **:** **public** Animal {
   
         **void** speak() **override** { cout **<<** “Woof**!**”; }
   
     };
     **class** **Cat** **:** **public** Animal {
   
         **void** speak() **override** { cout **<<** “Meow**!**”; }
   
     };
     **int** main() {
   
         Animal***** animals[] **=** {**new** Dog(), **new** Cat()};
         **for** (**auto*** a **:** animals) {
             a**->**speak();  // 通过统一接口调用不同实现
         }
   
     }

2. 运行时多态

**只要会写子类 就声明基类的析构函数为虚函数**

## Casting

C 语言转换

* 隐式转换
    **int** a **=** 5;
    **double** value **=** a;

* 显式转换
    double value = 5.25;
    int a = (int)value;
    double value = 5.25;
    int a = (int)value + 5.3;
    // a是10.3 而不是10.55
    double value = 5.25;
    int a = (int)(value + 5.3);
    // a是10 截断了

C++ 转换
    double value = 5.25;
    double s = static_cast<int>(value) + 5.3;

**1️⃣ static_cast**

**作用：** 在编译期进行类型安全的显式转换。

**能做的事：**

* 基本类型间的转换（如 `int` → `float`）

* 父类与子类之间的**已知方向转换**（上行安全，下行要自己保证安全）

* 去掉 `void*` 的类型信息（即 `void* → T*`） **不能做的事：**

* 不能去掉 `const`、`volatile` 限定

* 不能跨类型的指针（例如 `int*` → `double*`）

**示例：**
    double d = 3.14;
    int n = static_cast<int>(d); // 编译期安全转换

* * *

**2️⃣ reinterpret_cast**

**作用：** 重新解释内存的比特内容，不做任何语义层面的检查。

**能做的事：** 几乎任何指针类型之间的转换、整数与指针间的转换。

**风险：** 极大，常用于底层系统编程（例如硬件寄存器访问、类型穿透）。

**不会改变实际的内存内容，只是“换个角度看”。**

**示例：**
    int n = 65;
    char* p = reinterpret_cast<char*>(&n); // 把 int 内存当作 char* 解释

这种操作容易出bug，不建议在普通应用层使用。

* * *

**3️⃣ const_cast**

**作用：** 移除或添加 `const`、`volatile` 限定。

**用途：**

* 在需要修改const对象的API中强制去掉只读属性（一般是旧接口遗留问题）

* 常见于C库接口不接受const指针的情况。 **注意：** 如果你真的去修改一个原本是`const`定义的对象，会产生**未定义行为**。

**示例：**
    const int a = 10;
    int* p = const_cast<int*>(&a); // 去掉const
    //*p = 20; // ❌ 未定义行为

* * *

**4️⃣ dynamic_cast**（你先不看也可以）

**作用：** 在运行时进行安全的类型检查（RTTI）。

**只能用于多态类型（含虚函数的类）**。

**用途：** 从基类指针安全地转回子类指针。失败时返回 `nullptr`。
    Base* b = new Derived();
    Derived* d = dynamic_cast<Derived*>(b); // 安全的向下转换

*只是语法糖 好处是可以通过搜索*

## Conditional and BreakPoint

* 我们希望在程序运行时 去修改代码再调试
* 打断点→对断点右键→ 条件
  * 会看到条件前面被勾选了 条件表达式可以是任何的布尔语句 也可以勾选操作 输出一些东西 条件和操作同时勾选就可以同时使用 不需要停止应用程序 也没有重新编译代码

## Safe

* 尽量使用智能指针 就能自动释放内存 我们仍然需要学习原始指针 需要知道内存是如何工作的
* 但如果代码很多就会变得难以管理 停止关于原始指针和智能指针的争论 都可以用 自由地编写代码 智能指针只是原始指针上的包装 本质上只是能自动删除和释放内存 不应该害怕原始指针

## Precompiled Headers

**Precompiled Header（预编译头，简称 PCH）** 是一种 **编译加速机制**。它的核心目的是：

在大型 C++ 项目中，**避免重复编译那些几乎不会变的头文件**（例如 `<iostream>`、`<vector>`、`<string>`、Windows SDK、OpenGL、Qt、MFC 等库头文件）。

* * *

具体原理

编译器在处理 C++ 源代码时，需要先把所有 `#include` 的头文件展开、解析、语法分析，这个过程非常耗时。

但很多头文件在不同源文件中都是一样的，比如：
    #include <iostream>
    #include <vector>
    #include <string>
    #include "MyCommon.h"

如果项目中有 100 个 `.cpp` 文件，编译器默认会对这几百 KB 的头文件重复编译 100 次。

而 **预编译头文件** 就是把这些常用头文件 **编译一次，缓存结果**，之后再使用缓存直接加载。

* * *

工作方式（以 Visual Studio 为例）

1. 你创建一个文件，例如：
      // pch.h
      #pragma once
      #include <iostream>
      #include <vector>
      #include <string>
      #include "MyCommon.h"

2. 然后再写一个 cpp 文件：
      // pch.cpp
      #include "pch.h"
   这个文件会被单独编译成一个 `.pch` 文件（预编译结果）。

3. 其他所有 cpp 文件在开头只需要写：
      #include "pch.h"
   编译器就直接使用之前生成的 `.pch` 缓存，而不用重新解析 `<iostream>`、`<vector>` 等头文件。

* * *

优点

* 显著减少编译时间（特别是大型项目）。
* 避免多次解析庞大的库头文件。
* 在 IDE（如 Visual Studio、Xcode）中自动支持。

* * *

缺点

* 如果 `pch.h` 改动，所有 cpp 都得重新编译（因为缓存失效）。
* 不同编译器、不同项目的配置方式略有不同（如 MSVC 和 GCC 语法不一样）。
* 不适合频繁改动的文件。

* * *

GCC / Clang 的做法

在 GCC 或 Clang 中，可以手动创建：
    g++ -x c++-header pch.h -o pch.h.gch

之后编译时：
    g++ main.cpp -include pch.h

编译器会自动使用 `pch.h.gch` 作为预编译头。

* * *

一句话总结：

**Precompiled Header 是编译器提前把常用头文件编译成中间结果以加快后续编译速度的机制。**

是否想让我举个带时间对比的例子（比如编译一个包含 `<iostream>` 的项目有无 PCH 的速度差）？

* 预编译头文件是抓取一堆头文件 并将它们转换成编译器可以使用的格式 而不必一遍一遍地读取这些头文件

> 实际上我们每次include头文件时 都是读取整个头文件 然后编译它 而且你调用的这个头文件可能还包含其它头文件 都要被复制过来

> 于是在你想要编译main文件之前 所有的代码每一次都要被解析和编译 就算是不同的cpp文件有相同的头文件 由于这个头文件是单独包含在每个文件中的 每一个翻译单元都是单独编译 然后再进行链接 每次你对cpp文件进行修改 整个文件都要重新编译 头文件每次都要开始重新解析并重新编译这时需要使用预编译头文件 作用是接收一堆你告诉它要接收的头文件 它只编译一次 以二进制格式存储 这对编译器来说比单纯的文本处理要快得多 每次你include里预编译的头文件 它就已经有了你需要的一切

预编译头文件pch真正的用处是 外部依赖 比如STL 第三方API 但是如果你把它全都放在pch里 使用的时候

只知道你include了pch 但是不知道具体是用了哪个第三方库 也不知道是需要哪个文件

而且**有些库可能只有个别几个cpp文件才需要使用 就不能放在pch里**让所有cpp文件都添加上它 应该放进pch的是STL这种高频使用的

这里include的是pch.h 如果用c++模板创建项目的话 Visual Studio默认是写成stdafx.h 当然我们平时都是用空项目创建的 现在我们就手动创建一个pch.h 我们在pch.h中包含一堆其它的头文件 可能像这样

```
// pch.h 
#pragma once 
#include <iostream> 
#include <algorithm> 
#include <functional> 
#include <memory> 
#include <thread> 
#include <utility> 
#include <string> 
#include <stack> 
#include <deque> 
#include <array> 
#include <vector> 
#include <set> 
#include <map> 
#include <unordered_set> 
#include <unordered_map> 
#include <windows.h>
```

**一旦你有了头文件 就需要再做一个包含头文件的cpp文件** 这是Visual Studio的做法 所以我们还需要再新建一个pch.cpp

```
// pch.cpp #include "pch.h"
```

- 右键pch.cpp - 属性 - C/C++ - 预编译头 在预编译头文件处 编辑写入 pch.h 然后 预编译头 改成 创建 预编译头输出文件的那个.pch 就是预编译头文件在编译后的二进制格式

- 右键整个项目 - 属性 - C/C++ - 预编译头 在预编译头文件处 编辑写入 pch.h 然后 预编译头 改成 使用 这样就会适用到所有的文件 现在你打开右键main.cpp - 属性 - C/C++ - 预编译头 就会发现已经配置好了

- 我们想查看main.i 先要右键main.cpp - 属性 - C/C++ - 预处理器 - 预处理到文件 选择是

- 开始生成项目 编译器肯定会报链接错误 说没找到main.obj 不用理会 来到Project_test\bin\intermediates\x64\Debug文件夹 找到main.i 里面有40多万行 前面都是头文件 这就是每次都要重新编译的内容 最后几行才是我们的main函数
  
  - 别忘了把预处理到文件关掉 
    现在我们要对比使用预编译头前后的差异
  
  - 右键项目 - 属性 - C/C++ - 预编译头 换成不使用预编译头
    上方菜单栏点击 工具 - 选项 - 项目和解决方案 - VC++项目设置 生成计时改为 是

## Dynamic Cast

1. dynamic_cast是专门用于沿继承层次结构进行的强制类型转换 比如想从派生类型转换为基类类型 或者从基类类型转换为派生类型

2. 好的，深入讲清楚 `dynamic_cast` 的语义、前提、返回规则、典型用法与坑点。
   基本作用
   
   * 在“运行时”做**安全的**类型转换（RTTI 支持）。
   
   * 常用于**向下转型**（Base* → Derived*）或**横向转型**（同一继承树不同分支的基类指针之间，通过共同的最派生对象找到另一侧）。
   
   * 只能用于**多态类型**（基类里至少有一个 `virtual` 成员，常见是虚析构）。
   
   前提条件
   
   * 源类型必须是**指向/引用某个多态类**的“基类或子类”。最常见是 `Base*`、`Base&`。
   
   * 目标类型是某个相关类的“指针或引用”，比如 `Derived*`、`Derived&`、或另一侧的 `Sibling*`。
   
   * 访问控制要通过（private/protected 继承或成员可见性不足会导致编译期错误）。
   
   * RTTI 没被禁用（例如编译器开了 `-fno-rtti` 会直接编译不过）。
   
   返回与失败行为
   
   * 指针版本：`dynamic_cast<T*>(pBase)`
     
     * 成功：返回有效指向目标子对象的指针（带正确偏移）。
     
     * 失败：返回 `nullptr`（不抛异常）。
   
   * 引用版本：`dynamic_cast<T&>(baseRef)`
     
     * 成功：得到目标引用。
     
     * 失败：抛出 `std::bad_cast` 异常（必须 `try/catch`）。
   
   * 转成 `void*`：`dynamic_cast<void*>(pBase)`
     
     * 返回“**最派生对象**”的首地址指针（常用于定位完整对象起始地址）。要求源类型为多态。
   
   与 `static_cast` 的关键差异
   
   * `static_cast` 只在**编译期**检查类型关系，不做运行时验证；向下转型时容易产生未定义行为。
   
   * `dynamic_cast` 在**运行时**根据实际对象类型检查，失败安全（nullptr/异常）。
   
   * 成本：`dynamic_cast` 需要 RTTI 查找和层次遍历，通常是小常数开销，但在复杂多继承/热循环中要谨慎。
   
   典型用法：安全的向下转型
   
       struct Base { virtual ~Base() = default; };
       struct Derived : Base { void foo() {} };
       
       void f(Base* b) {
           if (auto d = dynamic_cast<Derived*>(b)) {
               d->foo();           // 安全：只有真的是 Derived 才会进来
           } else {
               // 不是 Derived
           }
       }
   
   横向转型（side cast）：多重继承分支之间
   
       struct A { virtual ~A() = default; };
       struct B { virtual ~B() = default; };
       struct C : A, B {};
       
       void g(A* pa) {
           if (auto pb = dynamic_cast<B*>(pa)) {   // 通过最派生对象 C，从 A* 横转到 B*
               // 成功只有在实际对象是 C（或同时继承 A、B 的类型）
           }
       }
   
   引用失败抛异常
   
       void h(Base& br) {
           try {
               Derived& dr = dynamic_cast<Derived&>(br); // 若失败抛 std::bad_cast
               dr.foo();
           } catch (const std::bad_cast& e) {
               // 处理失败
           }
       }
   
   与访问控制、继承方式的关系
   
   * `dynamic_cast` 受“**可访问性**”限制：如果在当前上下文里，从目标类型看不见所需的基类路径（比如私有继承导致不可访问），则**编译期报错**，不是运行期失败。
   
   * 公有继承的向下、横向转型最常见；私有/受保护继承经常会触发不可访问。
   
   与非多态类
   
   * 若尝试从/到非多态类做“向下或横向” `dynamic_cast`，**编译期报错**。
   
   * 唯一特殊的是：`dynamic_cast<void*>` 也要求源为多态类指针。
   
   复杂层次、虚继承与菱形结构
   
   * `dynamic_cast` 能正确处理虚继承/菱形结构下的指针偏移，定位到正确的子对象。
   
   * 如果目标类型在层次中**不唯一或不确定**（存在二义性），转型会**失败**（指针得 nullptr / 引用抛异常）。
   
   性能注意
   
   * 单次开销通常很小（实现依赖编译器与层次结构，典型为沿 vptr/RTTI 数据结构做检查）。
   
   * 不建议在**高频热路径**里频繁使用；可以通过虚函数、访客模式（visitor）、`std::variant` 等设计规避大量 RTTI 查询。
   
   何时应当使用
   
   * 你确实需要基于**实际运行时类型**做分支逻辑，并且对象来自一个“**不受你控制**的抽象接口”（比如框架回调给你 `Base*`）。
   
   * 你需要**安全**的向下/横向转换，不能冒未定义行为的风险。
   
   * 只偶尔使用；更多时候，优先通过**虚函数（多态）**把类型判断转为“行为分发”，或使用**访问者/变体**等更清晰的设计。
   
   几个常见坑
   
   * 忘了给基类加虚函数（典型是忘记虚析构），导致 `dynamic_cast` 编译不过。
   
   * 用引用版本没做异常处理，失败直接抛 `std::bad_cast`。
   
   * 把设计问题丢给 RTTI：大量 `dynamic_cast` 往往提示**抽象设计**可以更好（考虑虚函数、访问者）。
   
   * RTTI 被禁用或跨模块 RTTI 配置不一致，可能导致奇怪行为或链接问题（工程配置要统一）。
   
   小结一句话
   
   * 当你“**不知道**手里这个 `Base*` 背后是不是 `Derived`，但又**必须**在运行时判断”时，用 `dynamic_cast`；成功才用它，失败安全兜底。其他情况优先考虑静态多态（模板）、虚函数分发或 `std::variant`。
   * 
   
   ```c++
   Player* p1 = dynamic_cast<Player*>(e1);
   if (dynamic_cast<Player*>(e1))
   // e1是否是Player的实例
   // 如果是 dynamic_cast返回值非空 可以进入条件语句
   // 如果不是 dynamic_cast返回值为nullptr 无法进入条件语句
   // 当然这里完全可以写成 if (p1)
   {
       // do something
   }
   ```
   
   


