# Synchronisation Techniques in Java

## Overview

This repository contains examples demonstrating various synchronization techniques in Java. The examples cover:

1. Synchronized blocks and methods
2. Deadlock scenarios and prevention
3. Locks and condition variables
4. Atomic variables

## How to Run

1. Ensure you have Java Development Kit (JDK) installed.
2. Compile the code using:
    ```sh
    javac -d bin src/org/ThreadControlandDeadlocks/*.java
    ```
3. Run the main class:
    ```sh
    java -cp bin org.ThreadControlandDeadlocks.Main
    ```

## Examples

### 1. Synchronized Blocks and Methods

Demonstrates thread-safe operations using synchronized methods and blocks.

### 2. Deadlock Scenarios and Prevention

Illustrates deadlock conditions and shows how to prevent them.

### 3. Locks and Condition Variables

Shows how to use `Lock` and `Condition` for managing thread coordination.

### 4. Atomic Variables

Demonstrates the use of `AtomicInteger` for thread-safe operations.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
