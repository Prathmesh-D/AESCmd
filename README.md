# 🔐 AES Encryption-Decryption CLI Tool (Java)

A simple, secure, and beginner-friendly command-line application written in Java to perform AES encryption and decryption using a 128-bit key.

---

## 📁 Project Structure

```plaintext

├── src
│ └── AESCmd.java # Main AES logic and CLI interface

```

---

## ✅ Features

- AES-128 encryption and decryption
- Base64 encoding for safe output
- Clean command-line interface
- Input validation for key length
- Exception handling for smooth operation

---

## 🧰 Requirements

- Java JDK 8 or above

---

## 🚀 How to Run

### 1. Compile the program

```bash
javac src/AESCmd.java

```

### 2. Run the program

```bash

java -cp src AESCmd

```

---

## 📌 Usage
Once you run the program, follow the on-screen instructions:

```bash

Welcome to AES Encryption/Decryption Program!

Choose an option:
1. Encrypt
2. Decrypt
3. Exit
Enter your choice: 1
Enter the plaintext: hello world
Enter the key (16 characters long): thisis16bytekey
Encrypted text: ZxK8PvwGhVZn1vKz4zyQnQ==

```

---

## 🔑 Key Guidelines
Key must be exactly 16 characters long (128-bit AES).

Example key: thisis16bytekey

---

## ⚠️ Security Note
This tool uses AES in ECB mode, which is not recommended for production use as it doesn’t hide data patterns. For secure applications, consider AES with CBC or GCM mode and proper IV and salt management.

---

## 🙋‍♂️ Author
Prathmesh Deshkar <br>
🔗 [My Profile](https://github.com/Prathmesh-D)

---
