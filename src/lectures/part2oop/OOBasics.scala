package lectures.part2oop


object OOBasics extends App {

  val person = new Person("João", 30)
  println(person.age)
  println(person.x)
  person.greet("Daniel")
  person.greet()

  val author = new Writer("João", "Caparroz", 1990)
  val impostor = new Writer("João", "Caparroz", 1990)
  val novel = new Novel("Olar", 2002, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(impostor))
}

class Person(name: String, val age: Int = 0) {
  val x = 2

  println(1 + 3)

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name!")

  def greet(): Unit = println(s"Hi, I am ${this.name}!")

  def this(name: String) = this(name, 0)

  def this() = this("John Doe")
}

class Novel(name: String, year_of_release: Int, val author: Writer) {

  def authorAge: Int = this.year_of_release - this.author.year

  def isWrittenBy(author: Writer): Boolean = this.author == author

  def copy(newYearOfRelease: Int): Novel = new Novel(this.name, newYearOfRelease, this.author)
}

class Writer(val first_name: String, val surname: String, val year: Int) {
  def fullName(): String = s"$first_name $surname"
}

class Counter(val count: Int = 0) {
  def inc = new Counter(count + 1)
  def dec = new Counter(count - 1)

  def inc(n: Int) = new Counter(count + n)
  def dec(n: Int) = new Counter(count - n)
}