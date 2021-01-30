# week 05. 클래스

### 5-1. 클래스를 정의하는 방법

클래스란 객체를 정의하는 틀에 비유 하기도 한다.
사람이라는 클래스가 있다면 이 클래스의 객체로 철수, 민수, 영희 등 사람의 객체를 생성 할 수 있는 개념으로 이해한다.

생각보다 복잡한데, 클래스란 결국 객체를 생성 하는 도구 정도로 생각해보자.

```
class Person {
    int age;
    String name;
}

// class 클래스이름 {
    멤버변수들
}
```

이 처럼 클래스를 정의 할 수 있는데 class 현재 키워드가 생략되어 있는데, 이 키워드는 바로 접근지시자이다.
접근 지시자는 추후 다시 살펴 보도록 하자. 현재는 디폴트 값이 들어간 것으로 생각 하도록 하자.

위의 Person이라는 클래스는 age, name의 값을 가지고 있는데, 이 값은 각각의 객체가 서로 다른 값을 가지고 있다. 즉 객체끼리 값을 공유하지 않는다.


### 5-2. 객체 만드는 방법 (new 키워드 이해하기)

객체를 만들 때는 new 키워드를 사용한다.

```
Person p = new Person();
```

Person 이라는 클래스의 틀을 가진 p라는 객체를 생성했다.

다음과 같이 p라는 객체를 통해 멤버변수의 값을 넣어 줄 수 있다.

```
Person p = new Person();

p.age = 10;
p.name = "lkimilhol";
```

다른 객체를 생성하여 값을 넣어 보자.

```
Person p1 = new Person();

p1.age = 10;
p1.name = "lkimilhol";

Person p2 = new Person();

p2.age = 20;
p2.name = "kimmayer";
```

위의 p1의 age는 10이며 p2의 age는 20이다. 서로 두 값을 공유하지 않는다.  
new 연산자를 사용하면 새로운 메모리를 할당 해 주기 때문이다.

이 메모리는 heap에 할당이 되며 사용되지 않으면 추후 gc에 의해 메모리가 해제되게 된다.


### 5-3. 메소드 정의하는 방법

위의 클래스에 새로 메소드를 정의하여 보자.

```
class Person {
    int age;
    String name;
    
    public int getAge() {
        return this.age;
    }
}
```

this.age 라고 하는 것은 클래스가 가지고 있는 멤버변수의 값을 의미한다.  
추후 다시 알아보도록 하자.

접근지시자 반환형 메소드이름() {  
메소드에서 하는 일  
}

식으로 구현되며 () 안에는 전달 할 파라메터를 넣어 줄 수 있다.


```
class Person {
    int age;
    String name;
    
    public int getPlusAge(int plus) {
        return this.age + plus;
    }
}
```

클래스가 가지고 있는 멤버변수에 plus라고 하는 변수의 값을 더해서 리턴을 해주고 있다.
void 형인 경우에는 return을 해주지 않도록 한다. (아무것도 리턴하지 않는 것이니)

다음 예제를 보도록 하자.


```
Person p1 = new Person();

p1.age = 10;
p1.name = "lkimilhol";

System.out.println(p1.getPlusAge(10)); //20
```

p1의 age인 10과 파라메터로 넘겨준 10이 더해져 20이 출력된다.
메소드는 이 처럼 어떠한 연산이나 로직을 처리 한 뒤에 값을 return 해주는 기본 구조를 가지고 있다.

### 5-4. 생성자 정의하는 방법

생성자란 클래스라는 틀을 이용하여 객체를 생성 할 때 호출 되는 특수한 메소드이다.

다음 예시를 보도록 하자.

```
class Person {
    int age;
    String name;
    
    public Person() {
        this.age = 10
    }
    
    public int getPlusAge(int plus) {
        return this.age + plus;
    }
}
```

```
Person p1 = new Person();
System.out.println(p1.getPlusAge(10));  
```

아래 출력 결과는 과연 몇 일까? 바로 20이다.

클래스에서 객체를 생성할 때 Person()이라는 생성자가 호출 될 것이고 생성자 안에서는 age의 값을 10으로 해주고 있기 때문이다.

즉 객체가 생성 될 때 자동으로 실행되는 것이라고 이해하면 빠르다.

다음은 생성자가 가지는 특징이다.

- 생성자는 **리턴 타입이 없다**.
- 생성자는 **클래스 이름과 반드시 동일**하다.
- 모든 클래스는 **생성자가 반드시 존재**.
- 생성자가 존재하지 않아도 생략 된 것으로 생각하면 된다.

```
class Person {
    int age;
    String name;
    
    public Person() {
        this.age = 10
    }
    
    public Person(int plus) {
        this.age = plus;
    }
    
    public int getPlusAge(int plus) {
        return this.age + plus;
    }
}
```

```
Person p1 = new Person(20);
System.out.println(p1.getPlusAge(10));  
```

아래의 출력값은 얼마일까?
바로 30이다. 

객체를 생성 할 때 생성자를 호출 할 텐데 위의 코드를 보면 Person(20), 즉 20이라는 파라메터를 넘겨주었다.

이 경우 위의 클래스에서 인자가 있는 Person(int plus) 가 호출되게 되어 plus값으로 age값이 초기화 된다.

이를 메소드 오버로딩 이라고 하며 추후 자세한 내용을 다뤄보도록 하자.


### 5-5. this 키워드 이해하기

this란 사실 클래스 내의 멤버변수나 멤버함수를 지칭하기 위하며 파라메터로 넘어온 인자의 이름이 같을 경우에 유용하게 쓰인다.
아래 예시를 보자.

```
class Person {
    int age;
    String name;
    
    public int getPlusAge(int age) {
        return this.age + age;
    }
}
```

위의 코드에서 this가 빠진다면 age+age 를 리턴해 줄 것이다.

즉 멤버 변수의 age가 아닌 파라메터로 넘어온 age의 값을 2번 더해주는 꼴이 된다.  
원하는 결과가 이것이 아니라면 위와 같이 this 키워드를 사용하여 클래스 내의 멤버변수임을 지칭해주면 된다.

