import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    java
    kotlin("jvm") version "1.6.10"
    kotlin("kapt") version "1.6.10"
    id("org.jetbrains.compose") version "1.1.1"
    id("maven-publish")
    idea
}
idea {
    this.module {
        this.isDownloadSources = true
    }
}
val id = "takeThis"
group = "com.qxdzbc"
version = "1.0"


repositories {
    google()
    mavenCentral()
    mavenLocal()
    maven {
        url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        name = "Compose for Desktop DEV"
    }
    maven("https://plugins.gradle.org/m2/")
}

tasks {
    val jvmVersion = "15"
    compileKotlin {
        kotlinOptions { jvmTarget = jvmVersion }
        sourceCompatibility = jvmVersion
    }
}
val mockitoVersion = "4.5.1"
val dagger2Version = "2.43.1"
val coroutineVersion = "1.6.1"
dependencies{
    implementation(compose.desktop.currentOs)
    implementation("com.qxdzbc:common-compose:1.0")
    implementation("org.jetbrains.compose.material:material-icons-core:1.1.1")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:$coroutineVersion")

    implementation("com.google.dagger:dagger:${dagger2Version}")
    kapt("com.google.dagger:dagger-compiler:${dagger2Version}")
    kaptTest("com.google.dagger:dagger-compiler:${dagger2Version}")

    testImplementation("org.mockito:mockito-core:${mockitoVersion}")
    testImplementation("org.mockito:mockito-inline:${mockitoVersion}")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
    testImplementation("io.mockk:mockk:1.12.3")

    testImplementation("junit:junit:4.13.2")
    testImplementation(kotlin("test"))
}
tasks.test {
    // this is for Junit5
//    useJUnitPlatform()
    // this is for Junit4
    useJUnit()
    testLogging.showStandardStreams = true
}

compose.desktop {
    application {
        mainClass = "com.qxdzbc.take_this.MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "takeThis"
            packageVersion = "1.0.0"
            modules("java.sql")
        }
    }
}
