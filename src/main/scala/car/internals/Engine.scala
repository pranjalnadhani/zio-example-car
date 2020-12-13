package car.internals

import zio._
import zio.console._

object Engine {
  def live: ZLayer[Console, Nothing, Engine] = Live.make.toLayer

  trait Service {
    def start: ZIO[Console, Nothing, Unit]

    def stop: ZIO[Console, Nothing, Unit]
  }

  final class Live extends Service {
    override def start: ZIO[Console, Nothing, Unit] = putStrLn("Vroom vroom")

    override def stop: ZIO[Console, Nothing, Unit] = putStrLn("Bye")
  }

  object Live {
    def make: ZManaged[Console, Nothing, Service] = UIO(new Live()).toManaged_
  }

}
