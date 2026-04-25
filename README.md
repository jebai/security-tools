# Security Tools Project

## Overview

This project consists of two Java projects built with Gradle:

1. **security-tools** - A Java library for testing Maven Central publishing
2. **security-tools-app** - A Java application that demonstrates usage of the library

## Project Structure

```
publish-test/
├── security-tools/          # Java Library project
│   ├── src/main/java/io/github/jebai/securitytools/
│   │   └── SecurityUtils.java
│   ├── build.gradle         # Maven Central publishing configured
│   └── gradlew              # Gradle wrapper scripts
├── security-tools-app/       # Java Application project
│   ├── src/main/java/
│   │   └── App.java
│   ├── build.gradle         # Supports switching between local and Maven Central dependency
│   └── gradlew              # Gradle wrapper scripts
├── .gitignore
└── README.md                # This file
```

## Library (security-tools)

### Maven Coordinates
- **Group ID**: `io.github.jebai`
- **Artifact ID**: `security-tools`
- **Version**: `1.0.0`

### API

```java
package io.github.jebai.securitytools;

public class SecurityUtils {
    public static String getVersion() {
        return "1.0.0";
    }
}
```

## Application (security-tools-app)

### Usage

```java
import io.github.jebai.securitytools.SecurityUtils;

public class App {
    public static void main(String[] args) {
        System.out.println("Library version: " + SecurityUtils.getVersion());
    }
}
```

## Build and Run

### Build the library

```bash
cd security-tools
./gradlew build
```

### Build and run the application with local library

```bash
cd security-tools-app
./gradlew build -PuseLocal
./gradlew run -PuseLocal
```

### Build and run the application with Maven Central dependency

```bash
cd security-tools-app
./gradlew build
./gradlew run
```

## Maven Central Publishing

### Prerequisites
- Sonatype OSSRH account
- GPG key for signing artifacts
- `gradle.properties` file with publishing credentials

### Publishing Steps

1. **Configure signing credentials** in `~/.gradle/gradle.properties`:

   ```properties
   signing.keyId=YOUR_GPG_KEY_ID
   signing.password=YOUR_GPG_PASSWORD
   signing.secretKeyRingFile=~/.gnupg/secring.gpg
   
   ossrhUsername=YOUR_SONATYPE_USERNAME
   ossrhPassword=YOUR_SONATYPE_PASSWORD
   ```

2. **Publish to Maven Central**:

   ```bash
   cd security-tools
   ./gradlew publishToSonatype closeAndReleaseSonatypeStagingRepository
   ```

3. **Verify publication** at [Maven Central](https://search.maven.org/)

## License

MIT License
