Feature: 测试Cucumber框架能运行起来
  作为武总的朋友，我需要帮武总写一个关于 cucumber 的 Demo, 以便于我更近一步加强建立与武总之间的友谊。

  Scenario: 测试客户端发送请求GET
    When 客户端发送一个GET请求 /cucumber
    Then 客户端收到响应状态码 200
    And 客户端接受到服务段返回的字符串 cucumber

  Scenario: 测试客户端发送请求POST
    Given 假设客户端发送一个POST请求 /helloCucumber
    When 客户端收到响应状态码 200
    Then 客户端接受到服务段返回的字符串 cucumber