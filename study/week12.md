# week 12. 애노테이션

### 12-1. 애노테이션 정의하는 방법

애노테이션이란 자바 1.5 부터 사용된 것으로 의미를 해석하면 `주석`이라는 뜻을 가지고 있다.

하지만 // /**/ 와 같은 주석과는 다른 개념이라고 생각하면 된다.

애노테이션은 주석과 달리 설명 + 속성을 부여하는 것으로 생각하면 된다.

```
@Override
public void print() {
    //something
}
```

위의 애노테이션은 선언한 메소드가 오버라이드 된 것임을 나타내는 애노테이션이다. 애노테이션은 애노테이션만으로는 어떠한 동작을 하지 않는다. 즉 주석과 마찬가지로 애노테이션이 코드의 흐름에 영향을 주진 않는다.

하지만 애노테이션을 붙임으로써 컴파일러에게 에러 체크를 할 수 있도록 정보를 제공하거나, 코드를 자동으로 생성하는 등의 동작들이 가능하다.

일례로 위의 @Override 애노테이션의 경우 부모 클래스에 해당 메소드가 없다면 컴파일 에러를 발생 시키게 된다.

다음은 애노테이션을 새롭게 정의 해 보도록 하자.

```
public class Main {
    public static void main(String[] args) {
        // Creating a set

        @TestAnnotation(testName = "이름", testValue = 10)
        int value = 10;
    }
}

@Target(value = {ElementType.LOCAL_VARIABLE})
@interface TestAnnotation {
    String testName();
    int testValue();
}
```

@interface를 이용하여 새로운 애노테이션을 생성 할 수 있으며 정의 된 애노테이션의 element들을 생성 할 수 있으며, 생성된 요소들은 `@TestAnnotation(testName = "이름", testValue = 10)` 식으로 사용이 가능하다.
추가적으로 @Target 애노테이션을 통해 어떤 타입에 애노테이션을 붙일 수 있는지를 정의 할 수 있다.

> TYPE : 클래스, 인터페이스, enum
> ANNOTATION_TYPE : 어노테이션
> FIELD : 필드
> CONSTRUCTOR: 생성자
> METHOD: 메소드
> LOCAL_VARIABLE: 로컬 변수
> PACKAGE: 패키지

위의 타입에 맞지 않은 곳에 애노테이션을 붙일 경우 컴파일 에러를 발생 시키게 된다.

