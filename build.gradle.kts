plugins {
    kotlin("jvm") version "1.6.20"
    scala
    groovy
}

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.compilerArgs = listOf("-parameters", "-Xlint:unchecked")
        options.isIncremental = true
        options.isDeprecation = true
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }

    withType<GroovyCompile> {
        groovyOptions.isVerbose = true
        options.encoding = "UTF-8"
        options.compilerArgs = listOf("-parameters", "-Xlint:unchecked")
        options.isIncremental = true
        options.isDeprecation = true
    }

    withType<ScalaCompile> {
        scalaCompileOptions.encoding = "UTF-8"
        scalaCompileOptions.isDeprecation = true
        scalaCompileOptions.additionalParameters = listOf("-feature")
        options.encoding = "UTF-8"
        options.isIncremental = true
        options.isDeprecation = true
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation("org.scala-lang:scala-library:2.13.8")
    implementation(localGroovy())

    testImplementation("junit:junit:4.12")
    testImplementation("org.hamcrest:hamcrest-library:1.3")
    testImplementation("com.natpryce:hamkrest:1.7.0.0")
    testImplementation("org.scalatest:scalatest_2.13:3.1.0")
}
