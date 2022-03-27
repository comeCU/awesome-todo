# awesome-todo

# 简介

这是学习[Moco](https://github.com/dreamhead/moco)作者郑晔老师的一个代码案例，@See [geektime-todo](https://github.com/dreamhead/geektime-todo)；本仓库将其改为用Maven构建。

# 过程思考

1. 怎样写可靠的程序
2. 如何写测试
3. 任务分解&自动化。

# 运行

- `application.yml`配置文件改为test

  ```yaml
  spring:
    profiles:
      active: test
  ```

- 清理编译目录

  ```shell
  mvn clean
  ```

- 运行测试

  ```shell
  mvn test
  ```

- 查看测试覆盖率报告，各模块目录 `target/jacoco-ut/index.html`

- 命令行

  ```shell
  Usage:
  	java -jar todo-cli-<version>.jar [COMMAND]
  Commands:
    add
    list
    done
  ```

  

