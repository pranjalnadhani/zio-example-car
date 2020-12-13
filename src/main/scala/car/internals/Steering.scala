package car.internals

import zio.{UIO, ZIO, ZLayer, ZManaged}

object Steering {

  def live: ZLayer[Any, Nothing, Steering] = Live.make.toLayer
  trait Service {
    def left: ZIO[Any, Nothing, Unit]
    def right: ZIO[Any, Nothing, Unit]
    def straight: ZIO[Any, Nothing, Unit]
  }

  final class Live extends Service {
    override def left: ZIO[Any, Nothing, Unit] = ???

    override def right: ZIO[Any, Nothing, Unit] = ???

    override def straight: ZIO[Any, Nothing, Unit] = ???
  }

  object Live {
    def make: ZManaged[Any, Nothing, Service] = UIO(new Live()).toManaged_
  }

}
