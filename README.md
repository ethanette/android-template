# Android Template

## Description

Clean architecture 기반의 프로젝트 구조와 Kotlin과 최신 기술 스택을 사용한 안드로이드 템플릿 프로젝트입니다.

Kotlin 사용하여 작업된 프로젝트로 Clean Architecture Principle, Feature module, Repository Pattern, 
MVVM Architecture 및 Jetpack components에 따라 구현하였습니다.

* Tech/Tools
    * Gradle Dependency management
    * Gradle written in Kotlin DSL
    * Gradle Custom Plugin (dependencies with no duplication)
    * [Kotlin](https://kotlinlang.org/) 100% coverage
    * [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)
      and [Flow](https://developer.android.com/kotlin/flow) for async operations
    * [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) for
      dependency injection
    * [Jetpack](https://developer.android.com/jetpack)
        * [Compose](https://developer.android.com/jetpack/compose)
        * [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/) for
          navigation between composables
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) that
          stores, exposes and manages UI state

* Modern Architecture
    * MVVM + MVI (presentation layer)
    * [Android Architecture components](https://developer.android.com/topic/libraries/architecture) ([ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
      , [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
      , [Navigation](https://developer.android.com/jetpack/androidx/releases/navigation))
    * [Android KTX](https://developer.android.com/kotlin/ktx) - Jetpack Kotlin extensions

* UI
    * [Compose](https://developer.android.com/jetpack/compose) declarative UI framework
    * [Material design](https://material.io/design)

* CI

* Testing

* Static analysis tools

## Architecture

### Application layer

### Feature layer

`Feature` 레이어는 사용자가 화면에서 보여지는 레이어입니다. `Feature` 레이어는 MVVM 그리고 MVI 패턴을 통해 정의합니다.

- **View** - 화면에 데이터를 표시하고 사용자에 대한 상호 작용은 ViewModel을 통해 전달합니다.
- **ViewModel** - 상태 변경 사항을 뷰에 전달하고 사용자 상호 작업을 처리합니다.

### Domain layer

`Domain` 레이어는 다른 레이어와 독립적입니다. 이를 통해 도메인 모델 및 비즈니스 로직을 다른 계층과 독립적으로 만들 수 있습니다. 즉, 다른 레이어의 변경
사항은 `Domain` 레이어에 영향을 미치지 않습니다. 데이터베이스(`Data` 레이어) 또는 화면 UI(`Presentation` 레이어)를 변경해도
이상적으로는 `Domain` 레이어에서 코드가 변경되지 않습니다.

- **UseCase** - 비즈니스 로직
- **Model** - 어플리케이션 내에서 사용될 데이터 모델
- **Repository Interface** - 'Domain' 레이어를 'Data' 레이어와 독립적으로 유지하는데
  필요 ([Dependency inversion](https://en.wikipedia.org/wiki/Dependency_inversion_principle)).

### Data layer

애플리케이션 데이터를 관리하고 데이터 소스를 `Domain` 레이어에 대한 구현부를 제공합니다. `Data` 레이어는 네트워크 통신 및 데이터에 로컬 캐시하는 부분을 담당합니다.

- **Repository** `Domain` 레이어에 데이터 처리에 대한 구현부를 제공합니다. 애플리케이션 구조와 외부 API Repository 품질에 따라 데이터를 병합,
  필터링 및 변환할 수도 있습니다. 이러한 작업은 `Domain` 레이어에 대한 데이터 소스를 생성하는 것이지, 비즈니스 로직 (`domain` 레이어 `UseCase` 역활)
  을 수행하지는 않는 것입니다.
- **Mapper** - `data 모델`을 `Domain 모델`에 매핑 ('Domain' 레이어를 'Data' 레이어와 독립적으로 유지하기 위해).

### Library(Android) layer

### Library(Kotlin) layer

## Data flow

# Inspiration

### Cheat sheet

- [Core App Quality Checklist](https://developer.android.com/quality) - learn about building the
  high-quality app
- [Android Ecosystem Cheat Sheet](https://github.com/igorwojda/android-ecosystem-cheat-sheet) -
  board containing 200+ most important tools
- [Kotlin Coroutines - Use Cases on Android](https://github.com/LukasLechnerDev/Kotlin-Coroutine-Use-Cases-on-Android)
    - most popular coroutine usages

### Android projects

- [Android showcase](https://github.com/igorwojda/android-showcase) - Showcase is a sample project
  that presents a modern, 2021 approach to Android application development.
- [Google I/O Android App](https://github.com/google/iosched) - Due to global events, Google I/O
  2020 was canceled and Google I/O 2021 is an online-only event, so the companion app hasn't been
  updated since 2019.
- [MVVMTemplate](https://github.com/Drjacky/MVVMTemplate) - A simple Android template that lets you
  create an Android project quickly.
- [kotlin-android-template](https://github.com/cortinico/kotlin-android-template) - A simple Github
  template that lets you create an Android/Kotlin project and be up and running in a few seconds.
- [Android Sunflower](https://github.com/android/sunflower) - A gardening app illustrating Android
  development best practices with Android Jetpack.
- [Foodies](https://github.com/catalinghita8/android-compose-mvvm-foodies) - Foodies is a sample
  project that presents a modern approach to Android app development.
- [Jetpack-Compose-MVI-Coroutines-Flow](https://github.com/Kotlin-Android-Open-Source/Jetpack-Compose-MVI-Coroutines-Flow)
    - Play MVI with Kotlin Coroutines Flow and Jetpack Compose