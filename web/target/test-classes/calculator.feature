Feature: 计算器
  作为一个产品，我需要验收计算器功能实现是否符合预期，以便于我确认功能是否可以上线。
  # 使用cucumber做单元测试与使用Junit做单元测试对比，Junit单元测试代码可以查看 CalculatorServiceTest
  Scenario: testAdd
    Given 假设给我两个整数 10, 20
    When 当你运行测试时
    Then 我能计算两个数的和

  Scenario: testSubtract
    Given 假设给我两个整数 20, 10
    When 当你运行测试时
    Then 我能计算两个数的差

  Scenario: testMultiply
    Given 假设给我两个整数 10, 20
    When 当你运行测试时
    Then 我能计算两个数的积

  Scenario: testDivision
    Given 假设给我两个整数 20, 10
    When 当你运行测试时
    Then 我能计算两个数的商