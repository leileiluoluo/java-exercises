Feature: GitHub Issues API 测试

  Scenario: 新增一个 Issue
    Given 新增一个标题为 "Cucumber API Test" 的 Issue
    Then 响应码为 201，响应体中的 Issue 标题为 "Cucumber API Test"
