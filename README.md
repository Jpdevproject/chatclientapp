# Spring AI – Basic Chat Client Application

## Overview

A basic Spring Boot application demonstrating how to integrate Large Language Models (LLMs) using **Spring AI ChatClient**.

This project provides a hands-on introduction to interacting with LLMs, customizing chat options, dynamically selecting models, and processing AI-generated responses.

It is designed as a starting point for Java developers who want to explore Generative AI integration within Spring Boot applications.

## Key Features

- **LLM Interaction:** Communicate with Large Language Models using Spring AI's `ChatClient` API.
- **ChatOptions Customization:** Configure model-specific options such as model selection, temperature, and other supported generation parameters.
- **Dynamic Model Selection:** Switch between different LLM models at runtime.
- **Chat Response Handling:** Retrieve and process AI-generated responses.
- **Parameterized Testing:** Test chat interactions with multiple LLM models using JUnit 5 parameterized tests.
- **Ollama Integration:** Run and interact with locally hosted LLMs using Ollama.

## Technology Stack

| Technology | Purpose |
|---|---|
| Java 21 | Programming language |
| Spring Boot | Application framework |
| Spring AI | LLM integration |
| Ollama | Local LLM runtime |
| JUnit 5 | Unit and integration testing |
| Maven | Build and dependency management |

## Prerequisites

Ensure the following are installed:

- Java 21 or later
- Maven 3.8+
- Ollama
- An IDE such as IntelliJ IDEA or Eclipse

## Getting Started

### 1. Clone the Repository

```bash
git clone <repository-url>
cd <project-directory>
```

### 2. Install Ollama

Download and install Ollama from:

https://ollama.com/download

### 3. Download LLM Models

Pull the models you want to use:

```bash
ollama pull gemma3:1b
ollama pull llama3.2
```

Verify the downloaded models:

```bash
ollama list
```

### 4. Configure Spring Boot

Configure your `application.properties`:

```properties
spring.application.name=chat-client-app

spring.ai.ollama.base-url=http://localhost:11434
spring.ai.ollama.chat.options.model=gemma3:1b
```

### 5. Run the Application

```bash
mvn clean install
mvn spring-boot:run
```


By exploring this project, developers will understand:

1. How to integrate LLMs into Spring Boot applications.
2. How Spring AI simplifies LLM communication.
3. How to use the fluent `ChatClient` API.
4. How to customize `ChatOptions` for individual requests.
5. How to dynamically switch between LLM models.
6. How to retrieve and process `ChatResponse` metadata.

## Future Enhancements

- REST API endpoints for chat interactions.
- Conversation memory and contextual chat.
- Prompt templates and reusable prompts.
- Streaming AI responses.
- Integration with cloud-based LLM providers.
- Retrieval-Augmented Generation (RAG).
- Function calling and tool integration.

## Author

**Jyoti Prakash Behera**

Java Backend Developer | Spring Boot | Microservices | Spring AI | Generative AI

---

This repository is part of my hands-on learning journey into Generative AI and Spring AI, with a focus on integrating LLM capabilities into enterprise Java applications.
