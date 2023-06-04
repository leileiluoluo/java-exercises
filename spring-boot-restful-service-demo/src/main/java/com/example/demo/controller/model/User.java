package com.example.demo.controller.model;

import jakarta.validation.constraints.NotNull;

public record User(@NotNull Integer id, @NotNull String name, @NotNull Integer age) {
}
