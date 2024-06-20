Feature: GitHub Issues UI 测试

  Scenario: 新增一个 Issue
    Given 登录到 GitHub
    When 打开 Issues 页面并新增一个标题为 "Serenity Cucumber Integration UI Test" 的 Issue
    Then Issue 新增成功且标题为 "Serenity Cucumber Integration UI Test"
