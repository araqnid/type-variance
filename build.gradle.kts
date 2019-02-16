plugins {
    kotlin("jvm") version "1.3.21"
    scala
    groovy
}

repositories {
    jcenter()
}

tasks {
    withType<JavaCompile> {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
        options.encoding = "UTF-8"
        options.compilerArgs.add("-parameters")
        options.isIncremental = true
        options.isDeprecation = true
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
        kotlinOptions.jvmTarget = "1.8"
    }

    withType<GroovyCompile> {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
        groovyOptions.isVerbose = true
        options.encoding = "UTF-8"
        options.compilerArgs.add("-parameters")
        options.isIncremental = true
        options.isDeprecation = true
    }

    withType<ScalaCompile> {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
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
    implementation("org.scala-lang:scala-library:2.12.8")
    implementation(localGroovy())

    testImplementation("junit:junit:4.12")
    testImplementation("org.hamcrest:hamcrest-library:1.3")
    testImplementation("com.natpryce:hamkrest:1.7.0.0")
    testImplementation("org.scalatest:scalatest_2.12:3.0.5")
}
